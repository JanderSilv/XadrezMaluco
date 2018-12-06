package com.xadrez.core;

import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
import java.util.ArrayList;

/**
 * 
 */
public class Tabuleiro {
    
    public final int SIZE = 10;
    
    private Peca[][] tab;
       
    public Tabuleiro(){
         tab = new Peca[SIZE][SIZE];
    }
   
    public Peca getPeca(int x,int y){
        if(isInBounds(x, y)){
            return tab[x][y];
        }
        return null;
    }
    
    public boolean isInBounds(int x,int y){
    if(x<0 || y<0 || x>=SIZE || y>=SIZE) return false;
    return true;
    }
    
    public boolean isFree(int x,int y){
       return (isInBounds(x,y) && getPeca(x, y)==null);
    }
    
    public void movePeca(int x,int y,Peca p){
          p.setPosition(x, y);
          tab[x][y] = p;
    }
    
    public void setPeca(Position pos,Peca p){   
          tab[pos.x][pos.y] = p;       
    }
   
    public void removePeca(int x,int y){
    tab[x][y]=null;
    }
      
    public ArrayList<Peca> getPecasInRange(int x,int y,int range,boolean IgnorarNulos){
        
        ArrayList<Peca> pecas = new ArrayList<Peca>();
      
        for(int i=x-range;i<=x+range;i++){
            for(int j=y-range;j<=y+range;j++){
               
                if(i>=0 && j>=0 && i<SIZE && j<SIZE && (x!=i || y!=j)){
                    if( (int)Math.sqrt(Math.pow(x-i, 2)+Math.pow(y-j, 2)) <=range){   
                       Peca p=getPeca(i, j); 
                       
                       if(IgnorarNulos == true){
                           if(p!=null){
                             pecas.add(p);
                          }
                       }
                       else{
                             pecas.add(p);
                       }

                    }
                }
               
            }
        }
       
        return pecas;       
    }
    
    public ArrayList<Position> getValidsMoviments(MovTree m,Position from,int time){
    
        ArrayList<Position> pos = new ArrayList<>();
        
        if(m==null || from == null) return null;
           
        int size = m.Count(); 
  
        for(int i =0;i<size;i++)
        {
            if(m.value!=null){
                int mvy =m.value.y;  
                if(time>0)
                 {
                     mvy*=-1;
                 }
                int x= m.value.x+from.x;
                int y= mvy+from.y;
                
                Peca p =getPeca(x, y);
                
                if(p!=null){
                 if((m.IsParavel()==false) || (m.IsParavel() && p.time == time) || m.MoveApenas()==true) break;
                 
                 if(m.IsParavel() && p.time!=time && m.MoveApenas() == false ){
                    pos.add(new Position(x, y));
                    break;
                 }
                }
                
            }
            ArrayList<Position> aux = getValidsMoviments(m.Get(i),from,time);
            if(aux.size()>0)
            {
                pos.addAll(aux);
            }
        }
        
            if(m.value!=null)
             {
                 int mvy =m.value.y;  
                 if(time>0)
                 {
                     mvy*=-1;
                 }
                 int x= m.value.x+from.x;
                 int y= mvy+from.y;
                 
                 if(m.IsParavel()){                   
                    if(isInBounds(x,y))
                    {
                        Peca p = getPeca(x,y);
                        
                        if(p==null){
                            if(m.AtaqueApenas()==false) pos.add(new Position(x, y));
                        }
                        else if(p.time != time)
                        {
                            if(m.MoveApenas()==false) pos.add(new Position(x, y));
                        }
                    } 
                 }
             }
            
            return pos;
    }
}

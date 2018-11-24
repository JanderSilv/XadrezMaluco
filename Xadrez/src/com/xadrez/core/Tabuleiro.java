/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;

import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
import java.util.ArrayList;

/**
 *
 * @author ruann
 */
public class Tabuleiro {
    
    public final int SIZE = 10;
    
    public Peca[][] tab;
       
    public Tabuleiro(){
         tab = new Peca[SIZE][SIZE];
    }
   
    public Peca GetPeca(int x,int y){
        if(IsInBounds(x, y)){
            return tab[x][y];
        }
        return null;
    }
    
    public boolean IsInBounds(int x,int y){
    if(x<0 || y<0 || x>=SIZE || y>=SIZE) return false;
    return true;
    }
    
    public boolean IsFree(int x,int y){
       return (IsInBounds(x,y) && GetPeca(x, y)==null);
    }
    
    public boolean SetPeca(int x,int y,Peca p){
        if(IsFree(x, y)){
            p.posicao.x=x;
            p.posicao.y=y;
            tab[x][y] = p;
          return true;
        }
        return false;
    }
   
    public void RemovePeca(int x,int y){
    tab[x][y]=null;
    }
    
    public Peca[] GetPecasInRange(int x,int y,int range){
        
        ArrayList<Peca> pecas = new ArrayList<Peca>();
        
        for(int i=x-range;i<x+range;i++){
            for(int j=y-range;j<y+range;j++){
                 if( (int)Math.sqrt(Math.pow(x-i, 2)+Math.pow(y-j, 2)) <=range){
                    Peca p=GetPeca(x, y); 
                     if(p!=null){
                           pecas.add(p);
                    }
                 }
            }
        }
        if(pecas.size()>0) return (Peca[])pecas.toArray();
        
        return null;
    }
    
    public boolean LugarParavel(int x,int y,int time){
       
    return false;
    }
    
    public ArrayList<Position> GetValidsMoviments(MovTree m,Position from,int time){
    
        ArrayList<Position> pos = new ArrayList<Position>();
        
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
                Peca p =GetPeca(x, y);
               
                if(p!=null){
                 if((m.IsParavel()==false) || (m.IsParavel() && p.time == time)) break;
                 if(m.IsParavel() && p.time!=time){
                    pos.add(m.value);
                    break;
                 }
                }
                
            }
            ArrayList<Position> aux = GetValidsMoviments(m.Get(i),from,time);
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
                    if(IsInBounds(x,y))
                    {
                        Peca p = GetPeca(x,y);
                        if(p==null){
                            pos.add(new Position(x, y));
                        }
                        else if(p.time != time)
                        {
                             pos.add(new Position(x, y));
                        }
                    } 
                 }
             }
            
            return pos;
    }
}

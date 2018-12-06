
package com.xadrez.core;

import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
import javax.swing.ImageIcon;

public abstract class Peca {
    
    public int id;
    public int time;
    public int vida;
    public String nome;
    public int coolDown;
    public int direcao;
    
    public ImageIcon icon;
    public ImageIcon iconGrande;
    protected Position posicao;
    protected MovTree movimentacao;
    protected Xadrez xadrez;
    
    private boolean indo;
 
    
    public Peca(int vida, String nome,Position posicao,int time,Xadrez xadrez) {
      id=this.hashCode();
      this.time = time;
      this.vida = vida;
      this.nome = nome;
      this.posicao = posicao;
      this.coolDown = 0;
      movimentacao = new MovTree(null);
      this.xadrez = xadrez;
      indo= true;
      if(time==0)direcao=1;
      else direcao = -1;
    
    }
    
     public abstract void setPosition(int x,int y);
     public abstract Position getPosition();
     public abstract MovTree getMovimentacao();
     public abstract void CriarMovimentacao();
     public void Habilidade(){}
     
     public void Atualizacao(){
         
      
         if(indo){
            if((time==0 && posicao.y == xadrez.getTabuleiroTam()-1) || (time!=0 && posicao.y==0)){
               direcao*=-1;
              indo = false;
            }
         }else{
          if((time==0 && posicao.y == 0) || (time!=0 && posicao.y==xadrez.getTabuleiroTam()-1)){
               direcao*=-1;
              indo = true;
            }
         
         }     
       
     }
}

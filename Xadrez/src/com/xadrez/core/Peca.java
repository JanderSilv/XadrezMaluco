
package com.xadrez.core;

import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
import javax.swing.ImageIcon;

public abstract class Peca {
    
    public int id;
    public int time;
    public int vida;
    public String nome;
    
    public ImageIcon icon;
    protected Position posicao;
    protected MovTree movimentacao;
    protected Xadrez xadrez;
    public int coolDown;
    
    public Peca(int vida, String nome,Position posicao,int time,Xadrez xadrez) {
      id=this.hashCode();
      this.time = time;
      this.vida = vida;
      this.nome = nome;
      this.posicao = posicao;
      this.coolDown = 0;
      movimentacao = new MovTree(null);
      this.xadrez = xadrez;
    }
   
     public abstract void setPosition(int x,int y);
     public abstract Position getPosition();
     public abstract MovTree getMovimentacao();
     public abstract void CriarMovimentacao();
     public void Habilidade(){}
}

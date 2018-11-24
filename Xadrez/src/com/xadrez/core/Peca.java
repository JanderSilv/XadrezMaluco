
package com.xadrez.core;

import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;

public abstract class Peca {
    
    public int id;
    public int time;
    public int vida;
    public String nome;
    Position posicao;
    protected MovTree movimentacao;
    
    public int coolDown;
    
    public Peca(int vida, String nome,Position posicao,int time) {
      id=this.hashCode();
      this.time = time;
      this.vida = vida;
      this.nome = nome;
      this.posicao = posicao;
      this.coolDown = 0;
      movimentacao = new MovTree(null);
    }
   
     public abstract void CriarMovimentacao();
}

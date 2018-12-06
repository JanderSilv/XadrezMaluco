
package com.xadrez.core;

import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
import javax.swing.ImageIcon;

public abstract class Peca {

   
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    
    public int getVida() {
        return vida;
    }

    
    public void setVida(int vida) {
        this.vida = vida;
    }

    
    public String getNome() {
        return nome;
    }

 
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getCoolDown() {
        return coolDown;
    }

  
    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }
    
    public void atualizaCoolDown(int valor){
       this.coolDown+=valor;
    }
    
    public void Curar(int valor){
        this.vida+=valor;
    }
    public void Dano(int valor){
        this.vida-=valor;
    }
    
    public int id;
    protected int time;
    protected int vida;
    protected String nome;
    protected int coolDown;
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
            if((getTime()==0 && posicao.y == xadrez.getTabuleiroTam()-1) || (getTime()!=0 && posicao.y==0)){
               direcao*=-1;
              indo = false;
            }
         }else{
          if((getTime()==0 && posicao.y == 0) || (getTime()!=0 && posicao.y==xadrez.getTabuleiroTam()-1)){
               direcao*=-1;
              indo = true;
            }
         
         }     
       
     }
}

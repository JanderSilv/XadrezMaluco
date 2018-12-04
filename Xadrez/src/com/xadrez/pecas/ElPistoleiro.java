package com.xadrez.pecas;

import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
import javax.swing.ImageIcon;
/**
 *
 * @author JegueNu
 */
 public class ElPistoleiro extends Peca{
       
       public ElPistoleiro(Position posicao,int time,Xadrez xadrez){
       super(30, "ElPinstoleiro", posicao, time,xadrez);
        if(time==0)icon = new ImageIcon("src\\com\\xadrez\\imagens\\pistoleiro_azul.png");
        else icon = new ImageIcon("src\\com\\xadrez\\imagens\\pistoleiro_vermelho.png");
       CriarMovimentacao();
       }      
    
    @Override
    public void CriarMovimentacao(){
          movimentacao.Add(new MovTree(0,1)).Add(new MovTree(0,2)).Add(new MovTree(0,3)); // Movimentação para frente.
          movimentacao.Add(new MovTree(-1,1)).Add(new MovTree(-1,2)).Add(new MovTree(-1,3)); // Movimentação esquerda-frente.
          movimentacao.Add(new MovTree(1,1)).Add(new MovTree(1,2)).Add(new MovTree(1,3)); // Movimentação direita-frente.
    }

    @Override
    public MovTree getMovimentacao() {
        return movimentacao; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setPosition(int x, int y) {      
      posicao.x=x;
      posicao.y=y;
    }

    @Override
    public Position getPosition() {
       return posicao;
    }
    
    @Override
    public void Habilidade(){
    System.out.println("Habilidade de "+nome);
    }
 }
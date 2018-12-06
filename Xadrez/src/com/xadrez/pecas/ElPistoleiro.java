package com.xadrez.pecas;

import com.xadrez.actions.ElPistoleiroAction;
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
       ElPistoleiroAction habilidade;
       int ultimaDir = 2;
       public ElPistoleiro(Position posicao,int time,Xadrez xadrez){
       super(20, "ElPistoleiro", posicao, time,xadrez);
        if(time==0)icon = new ImageIcon("src\\com\\xadrez\\imagens\\pistoleiro_azul.png");
        else icon = new ImageIcon("src\\com\\xadrez\\imagens\\pistoleiro_vermelho.png");
        CriarMovimentacao();
        habilidade= new ElPistoleiroAction(xadrez, this);
       }      
    
    @Override
    public void CriarMovimentacao(){
          
         
    }

    @Override
    public MovTree getMovimentacao() {
     
          movimentacao = new MovTree(null);
          if(ultimaDir !=0) movimentacao.Add(new MovTree(0,1)).Add(new MovTree(0,2)).Add(new MovTree(0,3)); // Movimentação para frente.
          if(ultimaDir !=-1) movimentacao.Add(new MovTree(-1,1)).Add(new MovTree(-1,2)).Add(new MovTree(-1,3)); // Movimentação esquerda-frente.
          if(ultimaDir !=1) movimentacao.Add(new MovTree(1,1)).Add(new MovTree(1,2)).Add(new MovTree(1,3)); // Movimentação direita-frente.
    
        return movimentacao; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setPosition(int x, int y) { 
      ultimaDir = x-posicao.x;
      posicao.x=x;
      posicao.y=y;
    }

    @Override
    public Position getPosition() {
       return posicao;
    }
    
    @Override
    public void Habilidade(){
        xadrez.MudarFluxo(habilidade);
    }
 }

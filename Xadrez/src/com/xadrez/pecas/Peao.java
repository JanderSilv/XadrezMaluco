/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.pecas;

import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
import javax.swing.ImageIcon;

/**
 *
 * @author ruann
 */
public class Peao extends Peca {

    private boolean jaMoveu;
    public Peao(Position posicao, int time,Xadrez xadrez) {
        super(60, "Peao", posicao, time,xadrez);
         if(time==0)icon = new ImageIcon("src\\com\\xadrez\\imagens\\peao_azul.png");
        else icon = new ImageIcon("src\\com\\xadrez\\imagens\\peao_vermelho.png");
        jaMoveu = false; 
        CriarMovimentacao();
         coolDown = -1;
    }

    @Override
    public void CriarMovimentacao() {
       movimentacao.Add(new MovTree(0, 1,true,false,true)).Add(new MovTree(0, 2,true,false,true));
       movimentacao.Add(new MovTree(-1, 1,true,true,false));
       movimentacao.Add(new MovTree(1, 1,true,true,false));
    }
    @Override
    public MovTree getMovimentacao() {
        if(jaMoveu){          
            movimentacao =  new MovTree(null,true,false,true);
            movimentacao.Add(new MovTree(0, 1,true,false,true));  
            movimentacao.Add(new MovTree(-1, 1,true,true,false));
            movimentacao.Add(new MovTree(1, 1,true,true,false));
        }
        return movimentacao;
    }

    @Override
    public void setPosition(int x, int y) {
      jaMoveu=true;
      posicao.x=x;
      posicao.y=y;
    }

    @Override
    public Position getPosition() {
       return posicao;
    }
    
   
}

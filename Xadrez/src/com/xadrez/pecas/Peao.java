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
         if(time==1)icon = new ImageIcon("");
        else icon = new ImageIcon("");
        jaMoveu = false; 
        CriarMovimentacao();
         coolDown = -1;
    }

    @Override
    public void CriarMovimentacao() {
        
        movimentacao.Add(new MovTree(0, 1)).Add(new MovTree(0, 2));
    }
    @Override
    public MovTree getMovimentacao() {
        if(jaMoveu){          
            movimentacao = new MovTree(null);
            movimentacao.Add(new MovTree(0, 1));   
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

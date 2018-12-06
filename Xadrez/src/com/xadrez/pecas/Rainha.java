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
 * @author brcar
 */
public class Rainha extends Peca {
    
    public Rainha(Position posicao, int time,Xadrez xadrez){
        super(20, "Rainha", posicao, time,xadrez);
        coolDown=-1;
         if(time==0)icon = new ImageIcon("src\\com\\xadrez\\imagens\\rainha_azul.png");
        else icon = new ImageIcon("src\\com\\xadrez\\imagens\\rainha_vermelho.png");
        CriarMovimentacao();
    }
    
    @Override
    public void CriarMovimentacao() {
       
        movimentacao.Add(new MovTree(0, 1)).Add(new MovTree(0, 2)).Add(new MovTree(0, 3)).Add(new MovTree(0, 4)).Add(new MovTree(0, 5)).Add(new MovTree(0, 6)).Add(new MovTree(0, 7)).Add(new MovTree(0, 8)).Add(new MovTree(0, 9)).Add(new MovTree(0, 10));
        movimentacao.Add(new MovTree(0, -1)).Add(new MovTree(0, -2)).Add(new MovTree(0, -3)).Add(new MovTree(0, -4)).Add(new MovTree(0, -5)).Add(new MovTree(0, -6)).Add(new MovTree(0, -7)).Add(new MovTree(0, -8)).Add(new MovTree(0, -9)).Add(new MovTree(0, -10));
        movimentacao.Add(new MovTree(1,1)).Add(new MovTree(2,2)).Add(new MovTree(3,3)).Add(new MovTree(4,4)).Add(new MovTree(5,5)).Add(new MovTree(6,6)).Add(new MovTree(7,7)).Add(new MovTree(8,8)).Add(new MovTree(9,9)).Add(new MovTree(10,10));
        movimentacao.Add(new MovTree(-1,-1)).Add(new MovTree(-2,-2)).Add(new MovTree(-3,-3)).Add(new MovTree(-4,-4)).Add(new MovTree(-5,-5)).Add(new MovTree(-6,-6)).Add(new MovTree(-7,-7)).Add(new MovTree(-8,-8)).Add(new MovTree(-9,-9)).Add(new MovTree(-10,-10));
        movimentacao.Add(new MovTree(-1,1)).Add(new MovTree(-2,2)).Add(new MovTree(-3,3)).Add(new MovTree(-4,4)).Add(new MovTree(-5,5)).Add(new MovTree(-6,6)).Add(new MovTree(-7,7)).Add(new MovTree(-8,8)).Add(new MovTree(-9,9)).Add(new MovTree(-10,10));
        movimentacao.Add(new MovTree(1,-1)).Add(new MovTree(2,-2)).Add(new MovTree(3,-3)).Add(new MovTree(4,-4)).Add(new MovTree(5,-5)).Add(new MovTree(6,-6)).Add(new MovTree(7,-7)).Add(new MovTree(8,-8)).Add(new MovTree(9,-9)).Add(new MovTree(10,-10));
        movimentacao.Add(new MovTree(1,0)).Add(new MovTree(2,0)).Add(new MovTree(3,0)).Add(new MovTree(4,0)).Add(new MovTree(5,0)).Add(new MovTree(6,0)).Add(new MovTree(7,0)).Add(new MovTree(8,0)).Add(new MovTree(9,0)).Add(new MovTree(10,0));
        movimentacao.Add(new MovTree(-1,0)).Add(new MovTree(-2,0)).Add(new MovTree(-3,0)).Add(new MovTree(-4,0)).Add(new MovTree(-5,0)).Add(new MovTree(-6,0)).Add(new MovTree(-7,0)).Add(new MovTree(-8,0)).Add(new MovTree(-9,0)).Add(new MovTree(-10,0));
    }    
    @Override
    public void setPosition(int x, int y) {
        posicao.x = x;
        posicao.y = y;
    }

    @Override
    public Position getPosition() {
      return posicao;
    }

    @Override
    public MovTree getMovimentacao() {
       return movimentacao;
    }
}   

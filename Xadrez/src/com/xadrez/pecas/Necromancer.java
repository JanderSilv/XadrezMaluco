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
 * @author Jander
 */
public class Necromancer extends Peca {

    public Necromancer(Position posicao, int time,Xadrez xadrez) {
        super(40, "Necromancer", posicao, time,xadrez);
         if(time==1)icon = new ImageIcon("C:\\Users\\ruann\\Documents\\NetBeansProjects\\Xadrez\\src\\com\\xadrez\\imagens\\necromancer_azul.jpg");
        else icon = new ImageIcon("C:\\Users\\ruann\\Documents\\NetBeansProjects\\Xadrez\\src\\com\\xadrez\\imagens\\necromancer_vermelho.jpg");
        CriarMovimentacao();
    }

    @Override
    public void CriarMovimentacao() {
      movimentacao.Add(new MovTree(1, 1)).Add(new MovTree(2, 2)); // Movimentação para frente-diagonal a direita.
      movimentacao.Add(new MovTree(-1, 1)).Add(new MovTree(-2, 2)); // Movimentação para a frente-diagonal a esquerda.
      movimentacao.Add(new MovTree(1, -1)).Add(new MovTree(2, -2)); // Movimentação para trás-diagonal a direita.
      movimentacao.Add(new MovTree(-1, -1)).Add(new MovTree(-2, -2)); // Movimentação para a trás-diagonal a esquerda.
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
        
    }
}

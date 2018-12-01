/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.pecas;

import com.xadrez.actions.NecromancerAction;
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
    NecromancerAction habilidade;
    
    public Necromancer(Position posicao, int time,Xadrez xadrez) {
        super(40, "Necromancer", posicao, time,xadrez);
         if(time==1)icon = new ImageIcon("C:\\Users\\ruann\\Documents\\NetBeansProjects\\Xadrez\\src\\com\\xadrez\\imagens\\necromancer_azul.jpg");
        else icon = new ImageIcon("C:\\Users\\ruann\\Documents\\NetBeansProjects\\Xadrez\\src\\com\\xadrez\\imagens\\necromancer_vermelho.jpg");
         habilidade = new NecromancerAction(xadrez, this);
         CriarMovimentacao();
    }

    @Override
    public void CriarMovimentacao() {
      movimentacao.Add(new MovTree(1, 1)).Add(new MovTree(2, 2)); // Movimentação para diagonal a direita.
      movimentacao.Add(new MovTree(-1, -1)).Add(new MovTree(-2, -2)); // Movimentação para a diagonal a esquerda.
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
        xadrez.acao = habilidade;
        xadrez.acao.executeAction(null);
    }
}

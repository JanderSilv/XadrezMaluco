package com.xadrez.pecas;

import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
import javax.swing.ImageIcon;

/**
 *
 * @author Jafe
 */

public class PaiDeTodos extends Peca {

    public PaiDeTodos(Position posicao, int time,Xadrez xadrez) {
        super(1, "PaiDeTodos", posicao, time,xadrez);
         if(time==1)icon = new ImageIcon("C:\\Users\\ruann\\Documents\\NetBeansProjects\\Xadrez\\src\\com\\xadrez\\imagens\\rei_azul.jpg");
        else icon = new ImageIcon("C:\\Users\\ruann\\Documents\\NetBeansProjects\\Xadrez\\src\\com\\xadrez\\imagens\\rei_vermelho.jpg");
        CriarMovimentacao();
    }

    @Override
    public void CriarMovimentacao() {
      movimentacao.Add(new MovTree(0, 1)).Add(new MovTree(0,2)); // Movimentação para frente.
      movimentacao.Add(new MovTree(0, -1)).Add(new MovTree(0,-2)); // Movimentação para tras.
      movimentacao.Add(new MovTree(1, 0)).Add(new MovTree(2,0)); // Movimentação para direita.
      movimentacao.Add(new MovTree(-1, 0)).Add(new MovTree(-2,0)); // Movimentação para esquerda.
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
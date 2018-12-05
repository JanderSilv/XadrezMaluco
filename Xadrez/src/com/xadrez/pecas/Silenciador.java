/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.pecas;

import com.xadrez.actions.SilenciadorAction;
import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
import javax.swing.ImageIcon;

/**
 *
 * @author ruann
 */
public class Silenciador extends Peca {
    SilenciadorAction habilidade;
    
    public Silenciador(Position posicao,int time,Xadrez xadrez) {
        super(40, "Silenciador", posicao,time,xadrez);
         if(time==0)icon = new ImageIcon("src\\com\\xadrez\\imagens\\silenciador_azul.png");
        else icon = new ImageIcon("src\\com\\xadrez\\imagens\\silenciador_vermelho.png");
       CriarMovimentacao();
       habilidade = new SilenciadorAction(xadrez,this);
    }
    
    @Override
    public void CriarMovimentacao(){
        movimentacao.Add(new MovTree(-1,0,false)).Add(new MovTree(-1,1,true));
        movimentacao.Add(new MovTree( 0,1,false)).Add(new MovTree( 1,1,true));
        movimentacao.Add(new MovTree( 1,0,false)).Add(new MovTree(1,-1,true));
        movimentacao.Add(new MovTree(0,-1,false)).Add(new MovTree(-1,-1,true));
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
          xadrez.MudarFluxo(habilidade);
    }
}

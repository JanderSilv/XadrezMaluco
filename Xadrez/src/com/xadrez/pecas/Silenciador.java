/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.pecas;

import com.xadrez.core.Peca;
import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;

/**
 *
 * @author ruann
 */
public class Silenciador extends Peca {
    
    public Silenciador(Position posicao,int time) {
        super(40, "Silenciador", posicao,time);
       CriarMovimentacao();
    }
    
    @Override
    public void CriarMovimentacao(){
        movimentacao.Add(new MovTree(-1,0,false)).Add(new MovTree(-1,1,true));
        movimentacao.Add(new MovTree( 0,1,false)).Add(new MovTree( 1,1,true));
        movimentacao.Add(new MovTree( 1,0,false)).Add(new MovTree(1,-1,true));
        movimentacao.Add(new MovTree(0,-1,false)).Add(new MovTree(-1,-1,true));
    }
}

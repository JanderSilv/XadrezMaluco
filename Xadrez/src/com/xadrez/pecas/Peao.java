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
public class Peao extends Peca {

    public Peao(Position posicao, int time) {
        super(60, "Peao", posicao, time);
         CriarMovimentacao();
    }

    @Override
    public void CriarMovimentacao() {
        movimentacao.Add(new MovTree(0, 1, true));
    }
    
}

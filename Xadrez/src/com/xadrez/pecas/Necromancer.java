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
 * @author Jander
 */
public class Necromancer extends Peca {

    public Necromancer(Position posicao, int time) {
        super(40, "Necromancer", posicao, time);
        CriarMovimentacao();
    }

    @Override
    public void CriarMovimentacao() {
      movimentacao.Add(new MovTree(1, 1)).Add(new MovTree(2, 2)); // Movimentação para diagonal a direita.
      movimentacao.Add(new MovTree(-1, -1)).Add(new MovTree(-2, -2)); // Movimentação para a diagonal a esquerda.
    }    
}

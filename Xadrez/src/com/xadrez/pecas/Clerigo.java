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
 * @author brcar
 */
public class Clerigo extends Peca {
    
    public Clerigo(Position posicao, int time){
        super(40, "Clerigo", posicao, time);
        CriarMovimentacao();
    }
    
    @Override
    public void CriarMovimentacao() {
        movimentacao.Add(new MovTree(0,1)).Add(new MovTree(0,2)).Add(new MovTree(0,3));
        movimentacao.Add(new MovTree(1,1)).Add(new MovTree(2,2)).Add(new MovTree(3,3));
        movimentacao.Add(new MovTree(-1,1)).Add(new MovTree(-2,2)).Add(new MovTree(-3,3));
    
}
}
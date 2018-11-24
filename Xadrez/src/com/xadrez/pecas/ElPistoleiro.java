package com.xadrez.pecas;

import com.xadrez.core.Peca;
import com.xadrez.estructure.MovTree;
import com.xadrez.estructure.Position;
/**
 *
 * @author JegueNu
 */
 public class ElPistoleiro extends Peca{
       
       public ElPistoleiro(Position posicao,int time){
       super(30, "ElPinstoleiro", posicao, time);
       CriarMovimentacao();
       }      
    
    @Override
    public void CriarMovimentacao(){
          movimentacao.Add(new MovTree(0,1)).Add(new MovTree(0,2)).Add(new MovTree(0,3)); // Movimentação para frente.
          movimentacao.Add(new MovTree(-1,1)).Add(new MovTree(-1,2)).Add(new MovTree(-1,3)); // Movimentação esquerda-frente.
          movimentacao.Add(new MovTree(1,1)).Add(new MovTree(1,2)).Add(new MovTree(1,3)); // Movimentação direita-frente.
    }
 }
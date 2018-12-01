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
public class Rainha extends Peca {
    
    public Rainha(Position posicao, int time){
        super(40, "Rainha", posicao, time);
        CriarMovimentacao();
    }
    
    @Override
    public void CriarMovimentacao() {
       
        MovTree last=movimentacao;     
        //cima
        for(int i=0;i<10;i++){
            last = last.Add(new MovTree(0,i));
        }
        //baixo
         last=movimentacao;     
        for(int i=0;i<10;i++){
            last = last.Add(new MovTree(0,-i));
        }
        
         //direita
         last=movimentacao;     
        for(int i=0;i<10;i++){
            last = last.Add(new MovTree(i,0));
        }
        
        //esquerda
         last=movimentacao;     
        for(int i=0;i<10;i++){
            last = last.Add(new MovTree(-i,0));
        }
        // 1 do teclado 
          last=movimentacao;     
        for(int i=0;i<10;i++){
            last = last.Add(new MovTree(-i,-i));
        }
        
      
         // 9  do teclado
        last=movimentacao;     
        for(int i=0;i<10;i++){
            last = last.Add(new MovTree(i,i));
        }
         // 7 do teclado
        last=movimentacao;     
        for(int i=0;i<10;i++){
            last = last.Add(new MovTree(-i,i));
        }
        
}
}   

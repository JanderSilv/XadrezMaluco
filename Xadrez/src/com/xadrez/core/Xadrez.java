/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;

import com.xadrez.estructure.Position;
import com.xadrez.pecas.Peao;
import com.xadrez.pecas.Silenciador;

/**
 *
 * @author ruann
 */
public class Xadrez {
    
    Jogador jogador1,jogador2;
    Tabuleiro tabuleiro;
    
    
    public Xadrez(Jogador j1,Jogador j2){
    tabuleiro = new Tabuleiro();
    jogador1 = j1;
    jogador2 = j2;
    
    
    GerarPecas(jogador1);
    GerarPecas(jogador2);
    
    ColocarNoTabuleiro();
        System.out.println("Partida criada");
    }
    
   private void GerarPecas(Jogador j){
     for(int x=0;x<tabuleiro.SIZE;x++){
        j.pecas.add(new Peao(new Position(x, Math.abs(j.time-1)) ,j.time));
        j.pecas.add(new Silenciador(new Position(x, Math.abs(j.time))   ,j.time));
     }        
    }
    
   private void ColocarNoTabuleiro(){
     Peca p;
    for(int i=0;i<tabuleiro.SIZE*2;i++){
       
             p = jogador1.pecas.get(i);
        tabuleiro.SetPeca(p.posicao.x, p.posicao.y, p);
             p = jogador2.pecas.get(i);
        tabuleiro.SetPeca(p.posicao.x, p.posicao.y, p);
    }
    }
    
}

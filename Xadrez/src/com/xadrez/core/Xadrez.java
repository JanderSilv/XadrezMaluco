/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;

import com.xadrez.estructure.Position;
import com.xadrez.graphic.TelaXadrez;
import com.xadrez.pecas.Peao;
import com.xadrez.pecas.Silenciador;
import java.awt.Color;
import java.util.ArrayList;


/**
 *
 * @author ruann
 */
public class Xadrez {
    
    Jogador jogador1,jogador2;
    Tabuleiro tabuleiro;
    TelaXadrez window;
    Peca pecaParaMover;
    
    int turno;
    int timeAtual;
    
    public Xadrez(Jogador j1,Jogador j2,TelaXadrez window){
    
    turno = 0;
    tabuleiro = new Tabuleiro();
    jogador1 = j1;
    jogador2 = j2;
    this.window = window;
    
    GerarPecas(jogador1);
    GerarPecas(jogador2);
    ColocarNoTabuleiro();
    UpdateWindow();
    
    window.SetPlayer(j1);
    }
    
   public void CasaSelecionada(int x,int y){
       
       RestaurarCasasCor();     
       Peca p = tabuleiro.GetPeca(x, y);
       window.SetPeca(p);
      
       if(p!=null){
        
        if(p.time==timeAtual){
            pecaParaMover = p;
            PintarCasas(tabuleiro.GetValidsMoviments(p.movimentacao, p.posicao, p.time));
        }
       }else{
            if(pecaParaMover!=null){
                ArrayList<Position> mov_validos=tabuleiro.GetValidsMoviments(pecaParaMover.movimentacao, pecaParaMover.posicao, pecaParaMover.time);
                for(Position pos:mov_validos){
                    if(pos.x == x && pos.y == y){
                        tabuleiro.RemovePeca(pecaParaMover.posicao.x,pecaParaMover.posicao.y);
                        tabuleiro.SetPeca(x, y, pecaParaMover);
                        pecaParaMover = null;
                         UpdateWindow();
                    }
                }
            }
                             
       }  
   }
   
   private void PintarCasas(ArrayList<Position> casas){
      
       for(Position p:casas){
           System.out.println("Pintando: "+p.x+" - "+p.y);
           window.casas_tab[p.x][p.y].setBackground(Color.blue);
       }
   }
   
   private void RestaurarCasasCor(){
    for(int x=0;x<tabuleiro.SIZE;x++){
            for(int y=0;y<tabuleiro.SIZE;y++){
          if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) 
                {
                     window.casas_tab[x][y].setBackground(Color.WHITE);
                } else {
                    window.casas_tab[x][y].setBackground(Color.BLACK);
                }  
            }
    }
   
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
    
   private void UpdateWindow(){
       for(int x=0;x<tabuleiro.SIZE;x++){
            for(int y=0;y<tabuleiro.SIZE;y++){
                
                Peca p = tabuleiro.GetPeca(x, y);
                if(p!=null){
                     window.casas_tab[x][y].setText(p.nome);              
                }else{
                    window.casas_tab[x][y].setText("");    
                }
           }
       }
   }
}

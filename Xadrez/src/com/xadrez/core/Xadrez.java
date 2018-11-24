/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;

import com.xadrez.estructure.Position;
import com.xadrez.graphic.TelaXadrez;
import com.xadrez.pecas.Clerigo;
import com.xadrez.pecas.ElPistoleiro;
import com.xadrez.pecas.Necromancer;
import com.xadrez.pecas.PaiDeTodos;
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
       
       UpdateWindow();
       Peca p = tabuleiro.GetPeca(x, y);
       window.SetPeca(p);
       
       if(p!=null)
       {
            if(p.time==timeAtual){
                 pecaParaMover = p;
                 PintarCasas(tabuleiro.GetValidsMoviments(p.movimentacao, p.posicao, p.time));
                 System.out.println("Posicao peca: "+ p.posicao.x+" - "+p.posicao.y);
             }
       }
       else
       {
           
            if(pecaParaMover!=null)
            {
               
                ArrayList<Position> mov_validos=tabuleiro.GetValidsMoviments(pecaParaMover.movimentacao, pecaParaMover.posicao, pecaParaMover.time);
                System.out.println("Posicao posiveis: "+ mov_validos.size());
                for(Position pos:mov_validos)
                {
                    System.out.println("Posicao validas: "+ x+" - "+y);
                        if(pos.x == x && pos.y == y)
                        {
                            System.out.println("Posicao escolhida: "+ x+" - "+y);
                            tabuleiro.RemovePeca(pecaParaMover.posicao.x,pecaParaMover.posicao.y);
                            tabuleiro.SetPeca(x, y, pecaParaMover);
                            pecaParaMover = null;
                             UpdateWindow();
                             turno++;
                             timeAtual = (turno%2)*jogador2.time;
                            
                             if(timeAtual == 0){
                                window.SetPlayer(jogador1);
                             }else{
                                window.SetPlayer(jogador2);
                             }
                             
                        }   
                }
            }
                             
       }  
   }
   
   private void PintarCasas(ArrayList<Position> casas){
      
       for(Position p:casas){
           window.casas_tab[p.x][p.y].setBackground(Color.blue);
       }
   }
   
   
   private void GerarPecas(Jogador j){
     for(int x=0;x<tabuleiro.SIZE;x++){
        j.pecas.add(new Peao(new Position(x, Math.abs(j.time-1)) ,j.time));     
     }
     j.pecas.add(new Clerigo(new Position(0, Math.abs(j.time))   ,j.time));
     j.pecas.add(new Clerigo(new Position(9, Math.abs(j.time))   ,j.time));
     j.pecas.add(new ElPistoleiro(new Position(1, Math.abs(j.time))   ,j.time));
     j.pecas.add(new ElPistoleiro(new Position(8, Math.abs(j.time))   ,j.time));
     j.pecas.add(new Silenciador(new Position(2, Math.abs(j.time))   ,j.time));
     j.pecas.add(new Silenciador(new Position(7, Math.abs(j.time))   ,j.time));
     j.pecas.add(new Necromancer(new Position(3, Math.abs(j.time))   ,j.time));
     j.pecas.add(new Necromancer(new Position(6, Math.abs(j.time))   ,j.time));
     j.pecas.add(new PaiDeTodos(new Position(4, Math.abs(j.time))   ,j.time));
     j.pecas.add(new PaiDeTodos(new Position(5, Math.abs(j.time))   ,j.time));
     
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
                
                if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) 
                {
                     window.casas_tab[x][y].setBackground(Color.WHITE);
                } else {
                    window.casas_tab[x][y].setBackground(Color.BLACK);
                }  
                
                Peca p = tabuleiro.GetPeca(x, y);
                if(p!=null){
                     window.casas_tab[x][y].setText(p.nome);
                     if(p.time == 0) window.casas_tab[x][y].setBackground(Color.GREEN);
                     else window.casas_tab[x][y].setBackground(Color.RED);
                }else{
                    window.casas_tab[x][y].setText("");    
                }
           }
       }
   }
}

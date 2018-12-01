/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;

import com.xadrez.actions.AcaoPadrao;
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
 * Classe que representa a logica do xadrez em si
 * Fica entre a TelaXadrez e o Tabuleiro
 */
public class Xadrez {
    
    Jogador jogador1,jogador2;
    TelaXadrez window;
    Peca pecaParaMover;
    
    public Tabuleiro tabuleiro;
    public int turno;
    public int timeAtual;
    public Peca pecaEmSelecao;
    public boolean moveu;
    public boolean usouHabilidade;
    public final Action acaoPadrao;
    public Action acao;
    
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
    
    acaoPadrao = new AcaoPadrao(this);
    acao=acaoPadrao;
    }
    
    //Acão padrao a ser tomada quando o usuário seleciona uma peça
   public void CasaSelecionada(int x,int y){
   
       UpdateWindow();
       Peca p = pecaEmSelecao =tabuleiro.GetPeca(x, y);
       window.SetPeca(p);
     
       if(!moveu)
       {
          if(p!=null && p.time == timeAtual)
          {
               pecaParaMover = p;
               PintarCasas(tabuleiro.GetValidsMoviments(p.getMovimentacao(), p.getPosition(), p.time),Color.blue);
          }
          else
          {
               ExecutaMovimentacao(x, y);
                pecaParaMover = null;
          }  
       }
     
     
    mudaTurno();
        
   }
   
    //Responsavel por movimentação das peças
   private void ExecutaMovimentacao(int x,int y){
   if(pecaParaMover!=null)
            {
                ArrayList<Position> mov_validos=tabuleiro.GetValidsMoviments(pecaParaMover.getMovimentacao(), pecaParaMover.getPosition(), pecaParaMover.time);           
                for(Position pos:mov_validos)
                {   
                   
                    if(pos.x == x && pos.y == y)
                        { 
                            
                            Peca inimigaAchada = tabuleiro.GetPeca(x, y);                                                        
                            if(inimigaAchada!=null)
                            {
                                
                                if(timeAtual==0){ 
                                    jogador2.pecas.remove(inimigaAchada);
                                    jogador2.cemiterio.add(inimigaAchada);                               
                                }
                                else{
                                    jogador1.pecas.remove(inimigaAchada);
                                    jogador1.cemiterio.add(inimigaAchada);    
                                }
                           
                            }
                         
                            tabuleiro.RemovePeca(pecaParaMover.getPosition()); 
                            tabuleiro.MovePeca(x, y, pecaParaMover);                               
                           
                           
                             UpdateWindow();
                           
                            moveu = true;
                          
                        }
                     
                }
            }
   }  
   
    //incompleta
   private void podeUsarHabilidade(){
   Jogador j = (turno==0)? jogador1:jogador2;
   }
   
   //Faz a mudança de turno do jogo
   //Seleciona o personagem a jogar
   public void mudaTurno(){
    if(moveu && usouHabilidade){
        turno++;
        timeAtual = (turno%2)*jogador2.time;
        window.SetPlayer((turno%2==0)? jogador1:jogador2);                       
        moveu = false;
        usouHabilidade = false;
        UpdateWindow();
        
         for(Peca p:jogador1.pecas){
         if(p.coolDown>0) p.coolDown--;
         }
         for(Peca p:jogador2.pecas){
         if(p.coolDown>0) p.coolDown--;
         }
       
    }
   }
   
   //Troca a cor das casas do tabuleiro
   private void PintarCasas(ArrayList<Position> casas, Color cor){
      
       for(Position p:casas){
           window.casas_tab[p.x][p.y].setBackground(cor);
       }
   }
   
   //Cria objetos do tipo Peça e coloca na lista de peças do jogador
   private void GerarPecas(Jogador j){
     for(int x=0;x<tabuleiro.SIZE;x++){
        j.pecas.add(new Peao(new Position(x, Math.abs(j.time-1)) ,j.time,this));     
     }
     j.pecas.add(new Clerigo(new Position(0, Math.abs(j.time))   ,j.time,this));
     j.pecas.add(new Clerigo(new Position(9, Math.abs(j.time))   ,j.time,this));
     j.pecas.add(new ElPistoleiro(new Position(1, Math.abs(j.time))   ,j.time,this));
     j.pecas.add(new ElPistoleiro(new Position(8, Math.abs(j.time))   ,j.time,this));
     j.pecas.add(new Silenciador(new Position(2, Math.abs(j.time))   ,j.time,this));
     j.pecas.add(new Silenciador(new Position(7, Math.abs(j.time))   ,j.time,this));
     j.pecas.add(new Necromancer(new Position(3, Math.abs(j.time))   ,j.time,this));
     j.pecas.add(new Necromancer(new Position(6, Math.abs(j.time))   ,j.time,this));
     j.pecas.add(new PaiDeTodos(new Position(4, Math.abs(j.time))   ,j.time,this));
     j.pecas.add(new PaiDeTodos(new Position(5, Math.abs(j.time))   ,j.time,this));
     
    }
    
   
   private void ColocarNoTabuleiro(){
     Peca p;
    for(int i=0;i<tabuleiro.SIZE*2;i++){
       
             p = jogador1.pecas.get(i);
        tabuleiro.SetPeca(p.getPosition(), p);
             p = jogador2.pecas.get(i);
        tabuleiro.SetPeca(p.getPosition(), p);
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
                window.casas_tab[x][y].setIcon(null);
                Peca p = tabuleiro.GetPeca(x, y);
                if(p!=null){
                     window.casas_tab[x][y].setText(p.nome);
                     if(p.icon!=null)window.casas_tab[x][y].setIcon(p.icon);
                     
                     if(p.time == 0) window.casas_tab[x][y].setBackground(Color.GREEN);
                     else window.casas_tab[x][y].setBackground(Color.RED);
                }else{
                    window.casas_tab[x][y].setText("");    
                }
           }
       }
   }
}

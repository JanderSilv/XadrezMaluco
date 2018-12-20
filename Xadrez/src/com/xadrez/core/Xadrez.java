/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;

import com.xadrez.actions.AcaoPadrao;
import com.xadrez.estructure.Position;
import com.xadrez.graphic.TelaFimDeJogo;
import com.xadrez.graphic.TelaXadrez;
import com.xadrez.pecas.Clerigo;
import com.xadrez.pecas.ElPistoleiro;
import com.xadrez.pecas.Necromancer;
import com.xadrez.pecas.PaiDeTodos;
import com.xadrez.pecas.Peao;
import com.xadrez.pecas.Rainha;
import com.xadrez.pecas.Silenciador;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 * Classe que representa a logica do xadrez em si
 * Fica entre a TelaXadrez e o Tabuleiro
 */
public class Xadrez {

  
    private Jogador jogador1,jogador2;
    private TelaXadrez window;
    private Peca pecaParaMover;
    
    private Tabuleiro tabuleiro;
    private int turno;
    private int timeAtual;
    private Peca pecaEmSelecao;
    public boolean moveu;
    public boolean usouHabilidade;
    
    private final Action ACAOPADRAO;
    private Action acao;
    
    public Xadrez(Jogador j1,Jogador j2,TelaXadrez window){
    
    turno = 0;
    tabuleiro = new Tabuleiro();
    jogador1 = j1;
    jogador2 = j2;
    this.window = window;
    gerarPecas(jogador1);
    gerarPecas(jogador2);
    colocarNoTabuleiro();
    updateWindow();
    
    window.SetPlayer(j1);
    
    ACAOPADRAO = new AcaoPadrao(this);
    acao=ACAOPADRAO;
    }
    
    //Acão padrao a ser tomada quando o usuário seleciona uma peça
   public void casaSelecionada(int x,int y){
   
       updateWindow();
       Peca p = pecaEmSelecao =tabuleiro.getPeca(x, y);
        getWindow().SetPeca(p);
     
       if(!moveu)
       {
          if(p!=null && p.getTime() == timeAtual)
          {
               pecaParaMover = p;
               pintarCasas(tabuleiro.getValidsMoviments(p.getMovimentacao(), p.getPosition(), p.getTime(),p.direcao),Color.blue);
               pintarCasa(new Position(x, y), Color.yellow);
          }
          else 
          {
               executaMovimentacao(x, y);
                pecaParaMover = null;
          }  
       }
     
     
    mudaTurno();
        
   }
   
    //Responsavel por movimentação das peças
   private void executaMovimentacao(int x,int y){
       boolean sucesso=false;
   if(pecaParaMover!=null)
            {
                ArrayList<Position> mov_validos=tabuleiro.getValidsMoviments(pecaParaMover.getMovimentacao(), pecaParaMover.getPosition(), pecaParaMover.getTime(),pecaParaMover.direcao);           
                
                for(Position pos:mov_validos)
                {                      
                    if(pos.x == x && pos.y == y)
                        { 
                            
                            Peca inimigaAchada = tabuleiro.getPeca(x, y);                                                        
                            if(inimigaAchada!=null)
                            {
                                
                                if(timeAtual==0){ 
                                    jogador2.MatarPeca(inimigaAchada);  
                                     window.SetMensagemUsuario(inimigaAchada.getNome() +" foi morta por "+pecaParaMover.getNome());
                                }
                                else{
                                    jogador1.MatarPeca(inimigaAchada);
                                     window.SetMensagemUsuario(inimigaAchada.getNome() +" foi morta por "+pecaParaMover.getNome());
                                }
                          
                            }
                         
                            removePeca(pecaParaMover.getPosition()); 
                            movePeca(x, y, pecaParaMover);                               
                           
                           
                             updateWindow();
                           sucesso = true;
                            moveu = true;
                            break;
                          
                        } 
                     
                }
            }
        if(!sucesso){
            JOptionPane.showMessageDialog(null, "Local inválido");
        }
   }  
   
   //Faz a mudança de turno do jogo
   //Seleciona o personagem a jogar
   public void mudaTurno(){
      
    if(moveu && usouHabilidade){
        turno++;
        timeAtual = getTimeAtual();
        window.SetPlayer(getJogadorAtual());                       
        window.SetMensagemUsuario(getJogadorAtual().nome+" é sua vez!");
        moveu = false;
        usouHabilidade = false;
        
        atualizarPecas();
        updateWindow();
        
        if(jogador1.getPecas().size()==0){
            new TelaFimDeJogo(jogador2);
            window.dispose();
        }
        if(jogador2.getPecas().size()==0){
            new TelaFimDeJogo(jogador1);
            window.dispose();
        }
    }
   }
   
   public void atualizarPecas(){
        ArrayList<Peca> j1_Pecas =jogador1.getPecas();
        ArrayList<Peca> j2_Pecas =jogador2.getPecas();
        
         for(Peca p:j1_Pecas){
             if(p.getCoolDown()>0){ p.atualizaCoolDown(-1);}
             if(p.getVida()<=0){
                 jogador1.MatarPeca(p);
                 tabuleiro.removePeca(p);
             }
             p.Atualizacao();
         }
         for(Peca p:j2_Pecas){
             if(p.getCoolDown()>0) {p.atualizaCoolDown(-1);}
             if(p.getVida()<=0){
                 jogador2.MatarPeca(p);
                 tabuleiro.removePeca(p);
             }
             p.Atualizacao();
         }
   
   }
   //Troca a cor das casas do tabuleiro
   private void pintarCasas(ArrayList<Position> casas, Color cor){
      
       for(Position p:casas){
            getWindow().casas_tab[p.x][p.y].setBackground(cor);
       }
   }
   private void pintarCasa(Position casa,Color cor){
        getWindow().casas_tab[casa.x][casa.y].setBackground(cor);
   }
   
   //Cria objetos do tipo Peça e coloca na lista de peças do jogador
   private void gerarPecas(Jogador j){
         ArrayList<Peca> pecas =j.getPecas();
         int time = j.getTime();
     for(int x=0;x<tabuleiro.SIZE;x++){
       pecas.add(new Peao(new Position(x, Math.abs(time-1)) ,time,this));
     }
     pecas.add(new Clerigo(new Position(0, Math.abs(time))   ,time,this));
     pecas.add(new Clerigo(new Position(9, Math.abs(time))   ,time,this));
     pecas.add(new ElPistoleiro(new Position(1, Math.abs(time))   ,time,this));
     pecas.add(new ElPistoleiro(new Position(8, Math.abs(time))   ,time,this));
     pecas.add(new Silenciador(new Position(2, Math.abs(time))   ,time,this));
     pecas.add(new Silenciador(new Position(7, Math.abs(time))   ,time,this));
     pecas.add(new Necromancer(new Position(3, Math.abs(time))   ,time,this));
     pecas.add(new Necromancer(new Position(6, Math.abs(time))   ,time,this));
     pecas.add(new PaiDeTodos(new Position(4, Math.abs(time))   ,time,this));
     pecas.add(new Rainha(new Position(5, Math.abs(time))   ,time,this));
     
    }
    
   //Coloca as peças dos jogadores no tabuleiro (obs: independente se já há outra peça no local)
   private void colocarNoTabuleiro(){
     Peca p;
      ArrayList<Peca> j1_Pecas =jogador1.getPecas();
      ArrayList<Peca> j2_Pecas =jogador2.getPecas();
    
      for(int i=0;i<tabuleiro.SIZE * 2;i++){
       
             p = j1_Pecas.get(i);
        tabuleiro.setPeca(p.getPosition(), p);
             p = j2_Pecas.get(i);
        tabuleiro.setPeca(p.getPosition(), p);
    }
    }
    
   //Atualiza a janela
   public void updateWindow(){
       for(int x=0;x<tabuleiro.SIZE;x++){
            for(int y=0;y<tabuleiro.SIZE;y++){
            
                if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) 
                {
                     getWindow().casas_tab[x][y].setBackground(Color.WHITE);
                } else {
                    getWindow().casas_tab[x][y].setBackground(Color.BLACK);
                }  
                getWindow().casas_tab[x][y].setIcon(null);
                Peca p = tabuleiro.getPeca(x, y);
                if(p!=null){
                     getWindow().casas_tab[x][y].setText(p.getNome());
                     if(p.icon!=null)getWindow().casas_tab[x][y].setIcon(p.icon);
                     
                     if(p.getTime() == 0) getWindow().casas_tab[x][y].setBackground(Color.GREEN);
                     else getWindow().casas_tab[x][y].setBackground(Color.RED);
                }else{
                    getWindow().casas_tab[x][y].setText("");    
                }
           }
       }
   }
   
   //Retorna a peça nas coordenadas especificadas
   public Peca getPeca(int x,int y){
    return tabuleiro.getPeca(x, y);
   }
   
    //Retorna a peça na posiçao especificada
   public Peca getPeca(Position p){
   return  tabuleiro.getPeca(p.x,p.y);
   }
   
   public void setPeca(Peca p){
    tabuleiro.setPeca(p.getPosition(), p);
   }
   
    //Retorna as peças nas coordenadas especificadas, dentro do raio especificado, IgnorarNulos para ignorar casas vazias
   public ArrayList<Peca> getPecasInRange(int x,int y,int range,boolean IgnorarNulos){
        return tabuleiro.getPecasInRange(x, y, range, IgnorarNulos);
   }
   
   //Retorna as peças na posicao especificadas, dentro do raio especificado, IgnorarNulos para ignorar casas vazias
   public ArrayList<Peca> getPecasInRange(Position pos,int range,boolean IgnorarNulos){
        return tabuleiro.getPecasInRange(pos.x, pos.y, range, IgnorarNulos);
   }
   
   //Move uma peça e atualiza suas coordenadas internas
   public void movePeca(int x,int y,Peca p){
    tabuleiro.movePeca(x, y, p);
   }
   
   //Remove uma peça do tabuleiro
   public void removePeca(int x,int y){
    tabuleiro.removePeca(x,y);
    }

    //Remove uma peça do tabuleiro
   public void removePeca(Position p){
    tabuleiro.removePeca(p.x,p.y);
    }
   
    //Retorna a TelaXadrez
   public TelaXadrez getWindow() {
        return window;
    }
   
   //Retorna qual o turno atual
   public int getTurno(){
    return turno;
   }
   
   //Retorna qual o time atual
   public int getTimeAtual(){
   return(turno%2)*jogador2.getTime();
   }
   
   //Retorna o jogador atual
   public Jogador getJogadorAtual(){
     if(getTimeAtual()==0) return jogador1;
     return jogador2;
   }
   
   //Retorna a peça selecionada atualmente
   public Peca getPecaEmSelecao(){
    return pecaEmSelecao;
   }
   
   //Faz o fluxo de jogo voltar ao original
   public void RestaurarFluxo(){
    acao = ACAOPADRAO;
   }
  
   //Muda o fluxo de jogo
   public void MudarFluxo(Action acao){
   this.acao = acao;
   }
   
   //Retorna o fluxo de jogo atual
   public Action getAction(){
   return acao;
   }
    //Retorna o tamanho do tabuleiro
   public int getTabuleiroTam(){
   return tabuleiro.SIZE;
   }
   

}

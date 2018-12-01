/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.actions;

import com.xadrez.core.Action;
import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import java.awt.event.ActionEvent;
import com.xadrez.core.Jogador;
import com.xadrez.core.XadrezButton;
import com.xadrez.estructure.Position;
import com.xadrez.graphic.TelaCemiterio;
import java.util.ArrayList;

/**
 *
 * @author Jander
 */
public class NecromancerAction extends Action {
    
   Jogador jogador;
   Peca me;
   public Peca pecaRevivida;

    public NecromancerAction(Xadrez x, Peca p){
        super(x);
        me = p;
    }

    @Override
    public void executeAction(ActionEvent e){
   
        jogador = (xadrez.turno%2==0)?xadrez.jogador1:xadrez.jogador2;
        boolean vazio = ((jogador.cemiterio == null) || (jogador.cemiterio.size()) == 0);
        
        if (vazio && pecaRevivida == null){
            
            System.out.println("Cemitério vazio, não há peças para serem revividas");
            
            xadrez.acao = xadrez.acaoPadrao;
            
            return;
        } else {
            
           ArrayList<Peca> pecas = xadrez.tabuleiro.GetPecasInRange(me.getPosition().x, me.getPosition().y, 1);
            
            if (pecas.size() == 8){
                
                System.out.println("Casas ocupadas, impossivel reviver");
                
                xadrez.acao = xadrez.acaoPadrao;
                
                return;
                
            } else if (pecaRevivida != null) {
        
                XadrezButton button = (XadrezButton)e.getSource(); // pega qual foi o botao q foi clicado
                Peca lugarSelecionado = xadrez.tabuleiro.GetPeca(button.coord_x, button.coord_y);
                
                if (lugarSelecionado == null){
                    xadrez.tabuleiro.MovePeca(button.coord_x, button.coord_y, pecaRevivida);
                    me.coolDown = -1;
                    xadrez.acao = xadrez.acaoPadrao;
                }
                
            }
            else{
                new TelaCemiterio(xadrez.window, jogador, this);
            } 
            
        }
       
    }
    
}

// xadrez.tabuleiro.getPecasInRange
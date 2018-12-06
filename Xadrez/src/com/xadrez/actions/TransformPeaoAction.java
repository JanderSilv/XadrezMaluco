/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.actions;

import com.xadrez.core.Action;
import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.estructure.Position;
import com.xadrez.graphic.TelaPeaoTransformacao;
import com.xadrez.pecas.Clerigo;
import com.xadrez.pecas.ElPistoleiro;
import com.xadrez.pecas.Necromancer;
import com.xadrez.pecas.PaiDeTodos;
import com.xadrez.pecas.Peao;
import com.xadrez.pecas.Rainha;
import com.xadrez.pecas.Silenciador;
import java.awt.event.ActionEvent;

/**
 *
 * @author ruann
 */
public class TransformPeaoAction extends Action {

   
    private Position pos;
    private int time;
    public int selecionado;
    private Peca peca;
    public TransformPeaoAction(Position posicao,int time,Xadrez x,Peca peca) {
        super(x);
        pos = posicao;
        this.time = time;
        selecionado = -1;
        this.peca=peca;
    }

    @Override
    public void executeAction(ActionEvent e) {
       if(selecionado == -1){
         new TelaPeaoTransformacao(xadrez.getWindow(), xadrez, this);
       }else{
           System.out.println("selecionado: "+selecionado);
           xadrez.removePeca(peca.getPosition());
           xadrez.getJogadorAtual().RemovePeca(peca);
           
           switch(selecionado){
                case 0:
                peca = new Clerigo(pos, time, xadrez);
                break;               
                case 1:
                peca = new ElPistoleiro(pos, time, xadrez);
                break;
                case 2:
                peca = new Necromancer(pos, time, xadrez);
                break;
                case 3:
                peca = new PaiDeTodos(pos, time, xadrez);
                break;
                case 4:
                peca = new Rainha(pos, time, xadrez);
                break;
                case 5:
                peca = new Silenciador(pos, time, xadrez);
                break;  
           }
            peca.Girar();
           xadrez.getJogadorAtual().AdcionarPeca(peca);
           xadrez.setPeca(peca);
           xadrez.RestaurarFluxo();
           xadrez.UpdateWindow();
          
       }
    }
    
}

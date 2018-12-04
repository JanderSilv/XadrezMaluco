/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.actions;

import com.xadrez.core.Action;
import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.core.XadrezButton;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Jafe Ferreira
 */
public class PaiDeTodosAction extends Action {
    Peca p;
    public PaiDeTodosAction(Xadrez x,Peca P) {
        super(x);
        p=P;
        
    }

    @Override
    public void executeAction(ActionEvent e) {
        XadrezButton button = (XadrezButton)e.getSource();
         Peca P=xadrez.tabuleiro.GetPeca(button.coord_x, button.coord_y);
         
         if(null==P){//verifica se onde o usuario clicou  está vazio
          xadrez.tabuleiro.RemovePeca(p.getPosition());
          xadrez.tabuleiro.MovePeca(button.coord_x, button.coord_y,p);
          p.coolDown+=6;
          xadrez.moveu=true;
          xadrez.acao=xadrez.acaoPadrao;//faz o jogo sair do estado de habilidade (OBRIGATÓRIO)
          
         }else{
             
            JOptionPane.showMessageDialog(null, "O espaço contem uma peca, selecione uma peca valida");
            
         }
    }
    
}

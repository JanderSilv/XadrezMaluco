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

/**
 *
 * @author ruann
 */
public class SilenciadorAction extends Action{

    Peca me;
    public SilenciadorAction(Xadrez x,Peca p) {
        super(x);
        me=p;
    }

    @Override
    public void executeAction(ActionEvent e) {
         XadrezButton button = (XadrezButton)e.getSource();
         Peca p = xadrez.tabuleiro.GetPeca(button.coord_x, button.coord_y);
         
         if(p!=null){
             p.coolDown+=4;
             me.coolDown+=5;
         xadrez.acao=xadrez.acaoPadrao;
         }else{
             System.out.println("Espaco vazio, selecione uma peca valida");
         }
         
    }
    
}

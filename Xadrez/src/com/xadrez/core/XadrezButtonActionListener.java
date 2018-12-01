/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener para o XadrezButton
 * Quando o XadrezButton é clicado o método actionPerformed é chamado
 */
public class XadrezButtonActionListener implements ActionListener {

  Xadrez xadrez;
  
    public void setXadrez(Xadrez xadrez){
       this.xadrez = xadrez;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //executa a ação que estiver setada no xadrez
       xadrez.acao.executeAction(e);
    }
    
}

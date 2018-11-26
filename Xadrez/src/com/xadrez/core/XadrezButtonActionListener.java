/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ruann
 */
public class XadrezButtonActionListener implements ActionListener {

  Xadrez xadrez;
  
    public void setXadrez(Xadrez xadrez){
       this.xadrez = xadrez;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        XadrezButton button = (XadrezButton)e.getSource();      
       xadrez.CasaSelecionada(button.coord_x, button.coord_y);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.actions;

import com.xadrez.core.Action;
import com.xadrez.core.Xadrez;
import com.xadrez.core.XadrezButton;
import java.awt.event.ActionEvent;

/**
 *
 * @author ruann
 */
public class AcaoPadrao extends Action{

    
    public AcaoPadrao(Xadrez xadrez){
     super(xadrez);
    }
    
    @Override
    public void executeAction(ActionEvent e) {
       XadrezButton button = (XadrezButton)e.getSource();      
       xadrez.CasaSelecionada(button.coord_x, button.coord_y);
    }
    
}

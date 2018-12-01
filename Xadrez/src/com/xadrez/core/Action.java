/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;

import java.awt.event.ActionEvent;

/**
 *
 * @author ruann
 */
public abstract class Action {
    protected Xadrez xadrez;
    
    public Action(Xadrez x){
    xadrez=x;
    }
     public abstract void executeAction (ActionEvent e);
}

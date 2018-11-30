/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.core;
import javax.swing.JButton;

/**
 *
 * @author ruann
 */
public class XadrezButton extends JButton {
    public int coord_x,coord_y;
    public boolean listening;
    public XadrezButton(int x,int y){
     
        coord_x = x;
        coord_y = y;
        listening = true;
       
    }

  
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.graphic;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jander
 */
public class CanvasBackgrounds extends JPanel {
    
    private ImageIcon img;
    
    public CanvasBackgrounds(){
        img = new ImageIcon();
    }
    
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), getHeight(), this);
    }
    
    public void setImg(ImageIcon img){
        this.img = img;
    }
    
    public ImageIcon getImg(){
        return this.img;
    }
 }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.estructure;

/**
 *
 * @author ruann
 */
public class Position {
    public int x,y;
    public Position(int x,int y){
     this.x=x;
     this.y=y;
    }
    public boolean Igual(Position pos){
    if(pos.x == x && pos.y == y) return true;
    return false;
    }
}

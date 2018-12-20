/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.estructure;

import java.util.ArrayList;
import java.util.Collection;


public class MovTree {
   private ArrayList<MovTree> path;
   public Position value;
   boolean paravel = true;
   boolean ataqueApenas = false;
   boolean moveApenas = false;
   
   
   public MovTree(){
        path = new ArrayList<MovTree>();
   }
   public MovTree(Position p){
        path = new ArrayList<MovTree>();
        value =p;
   }
   public MovTree(Position p,boolean paravel){
        path = new ArrayList<MovTree>();
        value =p;
        this.paravel=paravel;
   }
   public MovTree(int x,int y){
        path = new ArrayList<MovTree>();
        value =new Position(x, y);
   }  
   public MovTree(int x,int y,boolean paravel){
        path = new ArrayList<MovTree>();
        value =new Position(x, y);
        this.paravel=paravel;
   }
   
   public MovTree(Position p,boolean paravel,boolean ataqueApenas,boolean moveApenas){
         path = new ArrayList<MovTree>();
         value =p;
         this.paravel=paravel;
         this.ataqueApenas=ataqueApenas;
         this.moveApenas = moveApenas;
   }  
   public MovTree(int x,int y,boolean paravel,boolean ataqueApenas,boolean moveApenas){
         path = new ArrayList<MovTree>();
          value =new Position(x, y);
         this.paravel=paravel;
         this.ataqueApenas=ataqueApenas;
         this.moveApenas = moveApenas;
   }
   
   public MovTree add(MovTree no){
        path.add(no);
        return no;
   }
   public MovTree[] addRange(Collection<MovTree> c){
       path.addAll(c);
       return (MovTree[])c.toArray();
   }
   public MovTree get(int index){
       return path.get(index);
   }
   public int count(){
       return path.size();
   }
   public boolean isParavel(){
       return paravel;
   }
   public boolean ataqueApenas(){
       return ataqueApenas;
   }
   public boolean moveApenas(){
      return moveApenas;
   }
}

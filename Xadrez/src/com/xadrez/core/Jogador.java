
package com.xadrez.core;

import java.util.ArrayList;

public class Jogador {

    
    public String nome;
    private int time;
    private ArrayList<Peca> pecas;
    private ArrayList<Peca> cemiterio;   
    
    public Jogador(int time, String nome){
    this.nome = nome;
    this.time = time;
    pecas = new ArrayList<Peca>();
    cemiterio = new ArrayList<Peca>();
    }
    
    public int getTime(){
     return time;
    }
    
    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(ArrayList<Peca> pecas) {
        this.pecas = pecas;
    }
   
    public ArrayList<Peca> getCemiterio() {
        return cemiterio;
    }

    public void setCemiterio(ArrayList<Peca> cemiterio) {
        this.cemiterio = cemiterio;
    }
    
    public void MatarPeca(Peca p){
        pecas.remove(p);
        cemiterio.add(p);
    }
    public void RemovePeca(Peca p){
     pecas.remove(p);
    }
    
    public void AdcionarPeca(Peca p){
    pecas.add(p);
   }
  
}

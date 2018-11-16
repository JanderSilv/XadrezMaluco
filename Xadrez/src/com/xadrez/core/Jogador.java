
package com.xadrez.core;

import java.util.ArrayList;

public class Jogador {
    public String nome;
    public int time;
    public ArrayList<Peca> pecas;
    public ArrayList<Peca> cemiterio;   
    
    public Jogador(int time, String nome){
    this.nome = nome;
    this.time = time;
    pecas = new ArrayList<Peca>();
    cemiterio = new ArrayList<Peca>();
    }
}

package com.xadrez.actions;

import com.xadrez.audio.Audio;
import com.xadrez.core.Action;
import com.xadrez.core.Jogador;
import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.estructure.Position;
import java.awt.event.ActionEvent;
/**
 *
 * @author Jão
 */

public class ElPistoleiroAction extends Action{
    
    Jogador jogador;
    Peca peca;
    
    public ElPistoleiroAction(Xadrez x, Peca p) {      
        super(x); 
        peca = p;
    }

    @Override
    public void executeAction(ActionEvent e) {
       Position pos = peca.getPosition();
       Peca esq = xadrez.getPeca(pos.x-1, pos.y);
       Peca dir = xadrez.getPeca(pos.x+1, pos.y);
      
       if(esq!=null && dir!=null){
           Audio.playSound("Pistoleiro.wav", false);
           esq.Dano(20);
           dir.Dano(20);
             
           peca.atualizaCoolDown(5);          
       }
       xadrez.RestaurarFluxo();
    }
    
}

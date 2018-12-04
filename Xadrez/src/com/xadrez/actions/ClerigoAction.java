/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.actions;

import com.xadrez.core.Action;
import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.core.XadrezButton;
import com.xadrez.estructure.Position;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author brcar
 */
public class ClerigoAction extends Action {

    Peca me;
    Peca p;
    public ClerigoAction(Xadrez x,Peca p) {
        super(x);
        me=p;
    }

    @Override
    public void executeAction(ActionEvent e) {
        Position pos = me.getPosition();
         ArrayList<Peca> pecas = xadrez.tabuleiro.GetPecasInRange(pos.x,pos.y,5);

         XadrezButton button = (XadrezButton)e.getSource(); 
          p =  xadrez.tabuleiro.GetPeca(button.coord_x, button.coord_y);

         if(p!=null){
              JOptionPane.showMessageDialog(null, "Peça pega: " +p.nome);
             
//              System.out.println("Peca pegada");
//              System.out.println(p.nome);

              for(Peca pe:pecas)
                {
                    if(pe.getPosition().x == pe.getPosition().x && pe.getPosition().y == pe.getPosition().y){
                       p.vida += 10;
                       me.coolDown += 4;
                       xadrez.acao = xadrez.acaoPadrao;
                       JOptionPane.showMessageDialog(null, "Peca curada");
                     break;
                    }
                }

         }else{
             JOptionPane.showMessageDialog(null, "Espaco vazio, selecione uma peca valida");
         }

    }
}


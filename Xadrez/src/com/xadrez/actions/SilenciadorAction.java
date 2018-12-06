/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.actions;

import com.xadrez.audio.Audio;
import com.xadrez.core.Action;
import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.core.XadrezButton;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author ruann
 */
public class SilenciadorAction extends Action{

    Peca me; //variavel pra dizer a peça q usou o poder
    
    public SilenciadorAction(Xadrez x,Peca p) {
        super(x);//passa o xadrez(x) pra variavel xadrez da classe pai;
        me=p;
    }

    @Override
    public void executeAction(ActionEvent e) {
         XadrezButton button = (XadrezButton)e.getSource(); // pega qual foi o botao q foi clicado
         Peca p = xadrez.getPeca(button.coord_x, button.coord_y);//usa as coordenadas do botao pra achar a peça naquela posição
         
         if(p!=null){//verifica se onde o usuario clicou não está vazio
             p.atualizaCoolDown(4); // aumenta o coolDown da peca que foi escolhida (essa é minha habilidade)
             me.atualizaCoolDown(5);//aumenta meu coolDown
                Audio.playSound("Silencer.wav", false);
             xadrez.RestaurarFluxo();//faz o jogo sair do estado de habilidade (OBRIGATÓRIO)
         }else{
             JOptionPane.showMessageDialog(null, "Espaco vazio, selecione uma peça valida");
         }
         
    }
    
}

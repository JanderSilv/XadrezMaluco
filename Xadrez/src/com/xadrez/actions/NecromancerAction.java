package com.xadrez.actions;

import com.xadrez.core.Action;
import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import java.awt.event.ActionEvent;
import com.xadrez.core.Jogador;
import com.xadrez.core.XadrezButton;
import com.xadrez.estructure.Position;
import com.xadrez.graphic.TelaCemiterio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jander
 */
public class NecromancerAction extends Action {
    
    Jogador jogador;
    Peca me;
    public Peca pecaRevivida;
    ArrayList<Peca> pecas;
    
    public NecromancerAction(Xadrez x, Peca p){
        super(x);
        me = p;
    }

    @Override
    public void executeAction(ActionEvent e){
   
        jogador = xadrez.getJogadorAtual();
        ArrayList<Peca> cemiterio = jogador.getCemiterio();
        boolean vazio = ((cemiterio == null) || (cemiterio.size()) == 0);
        
        if (vazio && pecaRevivida == null){
            
            JOptionPane.showMessageDialog(null, "Cemitério vazio, não há peças para serem revividas");
            
           xadrez.RestaurarFluxo();
            
            return;
        } else {
            int val=0;
            
          pecas = xadrez.getPecasInRange(me.getPosition(), 1,false);
           
           for(int i=0;i<pecas.size();i++){
                if(pecas.get(i)!= null){
                    val++;
                }
           }
           
           System.out.println(pecas.size() +"casas ao redor ");
           System.out.println(val +"casas ocupadas ao redor ");
           
            if (val==pecas.size()){
                JOptionPane.showMessageDialog(null, "Casas ocupadas, impossível reviver");    
                xadrez.RestaurarFluxo();
                pecas.clear();
                return;
                
            } else if (pecaRevivida != null) {
        
                XadrezButton button = (XadrezButton)e.getSource(); // pega qual foi o botao q foi clicado
                Peca lugarSelecionado = xadrez.getPeca(button.coord_x, button.coord_y);
                Position mePos = me.getPosition();
                
                if(Math.sqrt(Math.pow(button.coord_x - mePos.x, 2) + Math.pow(button.coord_y - mePos.y, 2)) <=1.5f){
                
                  
                        xadrez.movePeca(button.coord_x, button.coord_y, pecaRevivida);
                        me.coolDown = -1;
                      xadrez.RestaurarFluxo();
                        pecas.clear();
                    
                
                }
               
                
            }
            else{
                new TelaCemiterio(xadrez.getWindow(), jogador, this);
            } 
            
        }
       
    }
    
}

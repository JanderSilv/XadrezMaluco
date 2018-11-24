/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.graphic;

import com.xadrez.core.Jogador;
import com.xadrez.core.Peca;
import com.xadrez.core.Xadrez;
import com.xadrez.core.XadrezButton;
import com.xadrez.core.XadrezButtonActionListener;
import com.xadrez.estructure.Position;
import com.xadrez.pecas.Silenciador;
import java.awt.Color;
import java.util.ArrayList;
import static javax.security.auth.callback.ConfirmationCallback.YES;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author ruann
 */
public class TelaXadrez extends javax.swing.JFrame {

    Jogador jogador1,jogador2;
   
    public XadrezButton[][] casas_tab;
    XadrezButtonActionListener buttonListener;
    Xadrez xadrez;
    
    public TelaXadrez(Jogador jogador1,Jogador jogador2) {
        
        buttonListener = new XadrezButtonActionListener();
        casas_tab = new XadrezButton[10][10];
        
        this.jogador1=jogador1;
        this.jogador2=jogador2;
       
        initComponents();
       
        GerarTab();
        xadrez=new Xadrez(jogador1,jogador2,this);
        buttonListener.setXadrez(xadrez);
        
    }

    public void GerarTab(){      
        int panel_x=panel_Tabuleiro.getSize().width;
        int panel_y=panel_Tabuleiro.getSize().height;
        
        int btn_sizex = panel_x/10;
        int bnt_sizey = panel_y/10;
        
        for(int x=0;x<10;x++){
            for(int y=0;y<10;y++){
                  
                XadrezButton b= new XadrezButton(x,y);
                b.addActionListener(buttonListener);
                
                if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) 
                {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }  
                
                   b.setLocation(btn_sizex*x, bnt_sizey*y);
                   b.setSize(btn_sizex, bnt_sizey);
                   casas_tab[x][y] = b;
                   
                   panel_Tabuleiro.add(b);
            }
        }
    }
  
    public void SetPlayer(Jogador j){
    txt_Nome_Player.setText(j.nome);
    j.cemiterio.add(new Silenciador(new Position(0, Math.abs(j.time))   ,j.time));
    
    DefaultListModel listModel = new DefaultListModel();
    
    for(Peca p:j.cemiterio){
        listModel.addElement(p.nome);
    }
   lista_cemiterio.setModel(listModel);
   
    }
    
    public void SetPeca(Peca p){
    if(p==null){
        txt_Nome_Peca.setText("");
        txt_Vida_Peca.setText("");
        txt_Habilidade_Peca.setText("");
        btn_Ativar_Habilidade.setEnabled(false);
    }else{    
        txt_Nome_Peca.setText(p.nome);
        txt_Vida_Peca.setText(String.valueOf(p.vida));
        if(p.coolDown == -1){
        txt_Habilidade_Peca.setText("não tem");
        btn_Ativar_Habilidade.setEnabled(false);
        }else if(p.coolDown==0){
        txt_Habilidade_Peca.setText("disponível");
         btn_Ativar_Habilidade.setEnabled(true);
        }else{
        txt_Habilidade_Peca.setText("espere "+String.valueOf(p.coolDown)+" turnos");
         btn_Ativar_Habilidade.setEnabled(false);
        }
     }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Controle = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_Nome_Peca = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Vida_Peca = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Habilidade_Peca = new javax.swing.JLabel();
        btn_Ativar_Habilidade = new javax.swing.JButton();
        btn_Ajuda_Peca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_cemiterio = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        txt_Nome_Player = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0), new java.awt.Dimension(25, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0));
        panel_Tabuleiro = new javax.swing.JPanel();
        btn_Nova_Partida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_Controle.setBackground(new java.awt.Color(204, 204, 204));
        panel_Controle.setForeground(new java.awt.Color(153, 153, 153));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("IMAGEM");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setDefaultCapable(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nome:");

        txt_Nome_Peca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_Nome_Peca.setText("nome da peca");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Vida:");

        txt_Vida_Peca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_Vida_Peca.setText("40");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Habilidade:");

        txt_Habilidade_Peca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_Habilidade_Peca.setText("disponível");

        btn_Ativar_Habilidade.setText("Ativar Habilidade");
        btn_Ativar_Habilidade.setBorderPainted(false);

        btn_Ajuda_Peca.setText("Ajuda");
        btn_Ajuda_Peca.setBorderPainted(false);

        lista_cemiterio.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista_cemiterio);

        jLabel5.setText("CEMITÉRIO");

        txt_Nome_Player.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Nome_Player.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Nome_Player.setText("NOME DO JOGADOR");

        javax.swing.GroupLayout panel_ControleLayout = new javax.swing.GroupLayout(panel_Controle);
        panel_Controle.setLayout(panel_ControleLayout);
        panel_ControleLayout.setHorizontalGroup(
            panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_Nome_Player, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ControleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ControleLayout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ControleLayout.createSequentialGroup()
                        .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_ControleLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Habilidade_Peca))
                            .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panel_ControleLayout.createSequentialGroup()
                                    .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(42, 42, 42)
                                    .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_Vida_Peca)
                                        .addComponent(txt_Nome_Peca)))
                                .addGroup(panel_ControleLayout.createSequentialGroup()
                                    .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn_Ativar_Habilidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_Ajuda_Peca, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(13, 13, 13))))
                        .addGap(34, 34, 34))))
            .addGroup(panel_ControleLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_ControleLayout.setVerticalGroup(
            panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ControleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_Nome_Player)
                .addGap(30, 30, 30)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panel_ControleLayout.createSequentialGroup()
                            .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(5, 5, 5))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Nome_Peca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_Vida_Peca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Habilidade_Peca))
                .addGap(37, 37, 37)
                .addComponent(btn_Ativar_Habilidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Ajuda_Peca)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_Tabuleiro.setBackground(new java.awt.Color(255, 255, 255));
        panel_Tabuleiro.setMinimumSize(new java.awt.Dimension(320, 320));
        panel_Tabuleiro.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                panel_TabuleiroAncestorResized(evt);
            }
        });

        javax.swing.GroupLayout panel_TabuleiroLayout = new javax.swing.GroupLayout(panel_Tabuleiro);
        panel_Tabuleiro.setLayout(panel_TabuleiroLayout);
        panel_TabuleiroLayout.setHorizontalGroup(
            panel_TabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );
        panel_TabuleiroLayout.setVerticalGroup(
            panel_TabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        btn_Nova_Partida.setText("Nova Partida");
        btn_Nova_Partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Nova_PartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel_Tabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_Controle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Nova_Partida)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btn_Nova_Partida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Tabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Controle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Nova_PartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Nova_PartidaActionPerformed
      if(JOptionPane.showConfirmDialog(this,"Tem certeza? \n Sua partida atual será perdida","Confirmar saida",YES_NO_OPTION) == YES){
      new TelaDeJogadores().setVisible(true);
        this.dispose();
      }
 
        
    }//GEN-LAST:event_btn_Nova_PartidaActionPerformed

    private void panel_TabuleiroAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_panel_TabuleiroAncestorResized
        // TODO add your handling code here:
        int panel_x=panel_Tabuleiro.getSize().width;
        int panel_y=panel_Tabuleiro.getSize().height;
        
        int btn_sizex = panel_x/10;
        int bnt_sizey = panel_y/10;
          
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(casas_tab[i][j]!=null){
                  casas_tab[i][j].setSize(btn_sizex, bnt_sizey);
                  casas_tab[i][j].setLocation(btn_sizex*i, bnt_sizey*j);
                }                  
            }
        }
       
    }//GEN-LAST:event_panel_TabuleiroAncestorResized

  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ajuda_Peca;
    private javax.swing.JButton btn_Ativar_Habilidade;
    private javax.swing.JButton btn_Nova_Partida;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista_cemiterio;
    private javax.swing.JPanel panel_Controle;
    private javax.swing.JPanel panel_Tabuleiro;
    private javax.swing.JLabel txt_Habilidade_Peca;
    private javax.swing.JLabel txt_Nome_Peca;
    private javax.swing.JLabel txt_Nome_Player;
    private javax.swing.JLabel txt_Vida_Peca;
    // End of variables declaration//GEN-END:variables
}

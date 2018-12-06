/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.graphic;

import com.xadrez.core.Jogador;
import com.xadrez.pecas.PaiDeTodos;
import java.awt.Color;


public class TelaFimDeJogo extends javax.swing.JFrame {

    /**
     * Creates new form TelaFimDeJogo
     */
    public TelaFimDeJogo(Jogador vencedor) {
     this.setBackground(new Color(255,153,102));
     this.setVisible(true);
     this.setResizable(false);
        initComponents();
         txt_NomeUsuario.setText(vencedor.nome+" VENCEU!");
        btn_ImagenPaiDeTodos.setIcon(new PaiDeTodos(null,0,null).icon);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ImagenPaiDeTodos = new javax.swing.JButton();
        txt_NomeUsuario = new javax.swing.JLabel();
        btn_JogarNovamente = new javax.swing.JButton();
        btn_Sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 102));

        btn_ImagenPaiDeTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ImagenPaiDeTodosActionPerformed(evt);
            }
        });

        txt_NomeUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_NomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_NomeUsuario.setText("jLabel1");

        btn_JogarNovamente.setText("Nova Partida");
        btn_JogarNovamente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_JogarNovamenteActionPerformed(evt);
            }
        });

        btn_Sair.setText("Sair");
        btn_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_ImagenPaiDeTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, Short.MAX_VALUE)
                        .addComponent(txt_NomeUsuario)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_JogarNovamente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txt_NomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ImagenPaiDeTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_JogarNovamente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Sair)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SairActionPerformed
    this.dispose();
    }//GEN-LAST:event_btn_SairActionPerformed

    private void btn_JogarNovamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_JogarNovamenteActionPerformed
       
        new TelaDeJogadores().setVisible(true);
        this.dispose();
      
    }//GEN-LAST:event_btn_JogarNovamenteActionPerformed

    private void btn_ImagenPaiDeTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ImagenPaiDeTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ImagenPaiDeTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ImagenPaiDeTodos;
    private javax.swing.JButton btn_JogarNovamente;
    private javax.swing.JButton btn_Sair;
    private javax.swing.JLabel txt_NomeUsuario;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.graphic;


import com.xadrez.actions.TransformPeaoAction;
import com.xadrez.core.Xadrez;
import com.xadrez.estructure.Position;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ruann
 */
public class TelaPeaoTransformacao extends javax.swing.JFrame {

    DefaultListModel listModel;
     JFrame sender;
     
     
    public TelaPeaoTransformacao(JFrame sender,Xadrez xadrez,TransformPeaoAction action) {
      initComponents();
        listModel = new DefaultListModel();
        this.sender = sender;
        this.setVisible(true);
        this.setResizable(false);
        sender.setEnabled(false);
      
      listModel.addElement("Clérigo");
      listModel.addElement("El Pistoleiro");
      listModel.addElement("Necromancer");
      listModel.addElement("Pai de Todos");
      listModel.addElement("Rainha");
      listModel.addElement("Silenciador");
      
      jList_listaPecas.setModel(listModel);
      jList_listaPecas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               if (!e.getValueIsAdjusting()) {
                  action.selecionado =jList_listaPecas.getSelectedIndex();
                   Close();
                   dispose();
               }
            }
        });
      
    }
    
    public void Close(){
      sender.setEnabled(true);
      sender.setVisible(true);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_listaPecas = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        txt_titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_titulo.setText("SELECIONE UMA PEÇA");

        jList_listaPecas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList_listaPecas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList_listaPecas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}

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
import javax.swing.ImageIcon;
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

        canvasBackgrounds1 = new com.xadrez.graphic.CanvasBackgrounds();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_listaPecas = new javax.swing.JList<>();
        txt_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(244, 323));
        setMinimumSize(new java.awt.Dimension(244, 323));
        setPreferredSize(new java.awt.Dimension(244, 323));

        canvasBackgrounds1.setImg(new ImageIcon("src\\com\\xadrez\\imagens\\cemiterio.jpg"));
        canvasBackgrounds1.setMaximumSize(new java.awt.Dimension(244, 323));
        canvasBackgrounds1.setMinimumSize(new java.awt.Dimension(244, 323));
        canvasBackgrounds1.setPreferredSize(new java.awt.Dimension(244, 323));

        jList_listaPecas.setBackground(new java.awt.Color(255, 255, 204));
        jList_listaPecas.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jList_listaPecas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList_listaPecas);

        txt_titulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txt_titulo.setText("SELECIONE UMA PEÇA");

        javax.swing.GroupLayout canvasBackgrounds1Layout = new javax.swing.GroupLayout(canvasBackgrounds1);
        canvasBackgrounds1.setLayout(canvasBackgrounds1Layout);
        canvasBackgrounds1Layout.setHorizontalGroup(
            canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                        .addComponent(txt_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        canvasBackgrounds1Layout.setVerticalGroup(
            canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, canvasBackgrounds1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(canvasBackgrounds1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvasBackgrounds1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.xadrez.graphic.CanvasBackgrounds canvasBackgrounds1;
    private javax.swing.JList<String> jList_listaPecas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}

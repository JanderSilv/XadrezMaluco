/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.graphic;

import com.xadrez.actions.NecromancerAction;
import com.xadrez.core.Jogador;
import com.xadrez.core.Peca;
import com.xadrez.fontes.Fontes;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ruann
 */
public class TelaCemiterio extends JFrame {

    /**
     * Creates new form TelaCemiterio
     */
    Fontes tpFonte;
    JFrame sender;
    Peca selecionada;
    public TelaCemiterio(JFrame sender,Jogador jogador,NecromancerAction actionNecro) {
        initComponents();
        ArrayList<Peca> cemiterio = jogador.getCemiterio();
        this.sender = sender;
        this.setVisible(true);
        this.setResizable(false);
        sender.setEnabled(false);
        setIcon();
        
        tpFonte = new Fontes();
        txt_Cemiterio.setFont(tpFonte.GetFonte(tpFonte.doubleFeature, 0, 24));
        lista_cemiterio.setFont(tpFonte.GetFonte(tpFonte.caveirada, 0, 15));
        txt_Caveira.setFont(tpFonte.GetFonte(tpFonte.skulls, 0, 36));
        
         DefaultListModel listModel = new DefaultListModel();
         for(Peca p:cemiterio){
            listModel.addElement(p.nome);
         }
         lista_cemiterio.setModel(listModel);
        lista_cemiterio.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               if (!e.getValueIsAdjusting()) {
                   int i=lista_cemiterio.getSelectedIndex();
                   actionNecro.pecaRevivida = cemiterio.get(i);
                   cemiterio.remove(i);
                   System.out.println(i);
                   Close();
                   dispose();
               }
            }
        });
    }

    public void Close(){
    sender.setEnabled(true);
        sender.setAlwaysOnTop(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvasBackgrounds1 = new com.xadrez.graphic.CanvasBackgrounds();
        txt_Cemiterio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_cemiterio = new javax.swing.JList<>();
        txt_Caveira = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(244, 323));
        setMinimumSize(new java.awt.Dimension(244, 323));
        setPreferredSize(new java.awt.Dimension(244, 323));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        canvasBackgrounds1.setImg(new ImageIcon("src\\com\\xadrez\\imagens\\cemiterio.jpg"));
        canvasBackgrounds1.setMaximumSize(new java.awt.Dimension(244, 323));
        canvasBackgrounds1.setMinimumSize(new java.awt.Dimension(244, 323));
        canvasBackgrounds1.setPreferredSize(new java.awt.Dimension(244, 323));

        txt_Cemiterio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_Cemiterio.setText("CEMITÉRIO");

        lista_cemiterio.setBackground(new java.awt.Color(255, 255, 204));
        lista_cemiterio.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista_cemiterio);

        txt_Caveira.setText("n");

        javax.swing.GroupLayout canvasBackgrounds1Layout = new javax.swing.GroupLayout(canvasBackgrounds1);
        canvasBackgrounds1.setLayout(canvasBackgrounds1Layout);
        canvasBackgrounds1Layout.setHorizontalGroup(
            canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                        .addComponent(txt_Cemiterio, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Caveira, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        canvasBackgrounds1Layout.setVerticalGroup(
            canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Cemiterio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Caveira, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvasBackgrounds1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvasBackgrounds1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       Close();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.xadrez.graphic.CanvasBackgrounds canvasBackgrounds1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista_cemiterio;
    private javax.swing.JLabel txt_Caveira;
    private javax.swing.JLabel txt_Cemiterio;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icone.png")));
    }
}

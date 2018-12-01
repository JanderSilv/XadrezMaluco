
package com.xadrez.graphic;



public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_jogar = new javax.swing.JButton();
        btn_tutorial = new javax.swing.JButton();
        btn_creditos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_jogar.setText("JOGAR");
        btn_jogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jogarActionPerformed(evt);
            }
        });

        btn_tutorial.setText("TUTORIAL");
        btn_tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tutorialActionPerformed(evt);
            }
        });

        btn_creditos.setText("CREDITOS");
        btn_creditos.setActionCommand("CREDITOS");
        btn_creditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creditosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_creditos)
                    .addComponent(btn_tutorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_jogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btn_jogar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tutorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_creditos)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_jogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jogarActionPerformed
        // TODO add your handling code here:
        new TelaDeJogadores().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_jogarActionPerformed

    private void btn_tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tutorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tutorialActionPerformed

    private void btn_creditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creditosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_creditosActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_creditos;
    private javax.swing.JButton btn_jogar;
    private javax.swing.JButton btn_tutorial;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.graphic;

import com.xadrez.core.Jogador;
import com.xadrez.core.Xadrez;
import static javax.security.auth.callback.ConfirmationCallback.YES;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author ruann
 */
public class TelaXadrez extends javax.swing.JFrame {

  Jogador j1,j2;
    private int QUESTION_MENSAGE;
    
    public TelaXadrez(Jogador j1,Jogador j2) {
        initComponents();
        this.j1=j1;
        this.j2=j2;
        SetPlayer(j1);
        Xadrez xadrex = new Xadrez(j1,j2);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Controle = new javax.swing.JPanel();
        txt_Nome_Player = new javax.swing.JLabel();
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
        jList1 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        panel_Tabuleiro = new javax.swing.JPanel();
        btn_Nova_Partida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_Controle.setBackground(new java.awt.Color(204, 204, 204));
        panel_Controle.setForeground(new java.awt.Color(153, 153, 153));

        txt_Nome_Player.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_Nome_Player.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Nome_Player.setText("NOME DO JOGADOR");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("IMAGEM");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setDefaultCapable(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);

        jLabel2.setText("Nome:");

        txt_Nome_Peca.setText("nome da peca");

        jLabel3.setText("Vida:");

        txt_Vida_Peca.setText("40");

        jLabel4.setText("Habilidade:");

        txt_Habilidade_Peca.setText("disponível");

        btn_Ativar_Habilidade.setText("Ativar Habilidade");
        btn_Ativar_Habilidade.setBorderPainted(false);

        btn_Ajuda_Peca.setText("Ajuda");
        btn_Ajuda_Peca.setBorderPainted(false);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel5.setText("CEMITÉRIO");

        javax.swing.GroupLayout panel_ControleLayout = new javax.swing.GroupLayout(panel_Controle);
        panel_Controle.setLayout(panel_ControleLayout);
        panel_ControleLayout.setHorizontalGroup(
            panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ControleLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ControleLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Habilidade_Peca)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ControleLayout.createSequentialGroup()
                        .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_ControleLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(txt_Vida_Peca))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ControleLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Nome_Peca)))
                        .addGap(24, 24, 24))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ControleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ControleLayout.createSequentialGroup()
                        .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_ControleLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel5)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ControleLayout.createSequentialGroup()
                        .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Ativar_Habilidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Ajuda_Peca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42))))
            .addGroup(panel_ControleLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Nome_Player)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_ControleLayout.setVerticalGroup(
            panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ControleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_Nome_Player)
                .addGap(13, 13, 13)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(36, 36, 36)
                .addComponent(btn_Ativar_Habilidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Ajuda_Peca)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_Tabuleiro.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panel_TabuleiroLayout = new javax.swing.GroupLayout(panel_Tabuleiro);
        panel_Tabuleiro.setLayout(panel_TabuleiroLayout);
        panel_TabuleiroLayout.setHorizontalGroup(
            panel_TabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        panel_TabuleiroLayout.setVerticalGroup(
            panel_TabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(panel_Controle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Tabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Nova_PartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Nova_PartidaActionPerformed
      if(JOptionPane.showConfirmDialog(this,"Tem certeza? \n Sua partida atual será perdida","Confirmar saida",YES_NO_OPTION) == YES){
      new TelaDeJogadores().setVisible(true);
        this.dispose();
      }
 
        
    }//GEN-LAST:event_btn_Nova_PartidaActionPerformed

  public void SetPlayer(Jogador j){
    txt_Nome_Player.setText(j.nome);
  }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ajuda_Peca;
    private javax.swing.JButton btn_Ativar_Habilidade;
    private javax.swing.JButton btn_Nova_Partida;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_Controle;
    private javax.swing.JPanel panel_Tabuleiro;
    private javax.swing.JLabel txt_Habilidade_Peca;
    private javax.swing.JLabel txt_Nome_Peca;
    private javax.swing.JLabel txt_Nome_Player;
    private javax.swing.JLabel txt_Vida_Peca;
    // End of variables declaration//GEN-END:variables
}

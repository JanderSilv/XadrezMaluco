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
import com.xadrez.fontes.Fontes;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import static javax.security.auth.callback.ConfirmationCallback.YES;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 * @author JanderSilv
 * @author ruann
 */
public class TelaXadrez extends javax.swing.JFrame {
    
    Fontes tpFonte;
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
        setIcon();
                
        tpFonte = new Fontes();
        txt_Nome_Player.setFont(tpFonte.GetFonte(tpFonte.Sketch, 0, 24));
        txt_Cemiterio.setFont(tpFonte.GetFonte(tpFonte.doubleFeature, 0, 18));
        txt_Caveira.setFont(tpFonte.GetFonte(tpFonte.skulls, 0, 36));
        lista_cemiterio.setFont(tpFonte.GetFonte(tpFonte.caveirada, 0, 10));
        
        btn_Ativar_Habilidade.setEnabled(false);
       
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
    DefaultListModel listModel = new DefaultListModel();
    ArrayList<Peca> cemiterio = j.getCemiterio(); 
    for(Peca p:cemiterio){
        listModel.addElement(p.getNome());
    }
   lista_cemiterio.setModel(listModel);
   
    }
    
    public void SetPeca(Peca p){
    if(p==null){
        txt_Nome_Peca.setText("");
        txt_Vida_Peca.setText("");
        txt_Habilidade_Peca.setText("");
        btn_ImgPeca.setIcon(null);
        btn_Ativar_Habilidade.setEnabled(false);
    }else{    
        txt_Nome_Peca.setText(p.getNome());
        txt_Vida_Peca.setText(String.valueOf(p.getVida()));
        btn_ImgPeca.setIcon(p.iconGrande);
        if(p.getCoolDown()==-1){
        txt_Habilidade_Peca.setText("não tem");
        btn_Ativar_Habilidade.setEnabled(false);
        }
        else if(p.getCoolDown()==0){
         txt_Habilidade_Peca.setText("disponível");
         btn_Ativar_Habilidade.setEnabled(true);
        }
        else{
        txt_Habilidade_Peca.setText("espere "+String.valueOf(p.getCoolDown())+" turnos");
         btn_Ativar_Habilidade.setEnabled(false);
        }
        if(p.getTime() != xadrez.getTimeAtual()){
         btn_Ativar_Habilidade.setEnabled(false);
        }
     }
    }
    
    public void SetMensagemUsuario(String texto){
       txt_MensagemUsuario.setText(texto);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvasBackgrounds1 = new com.xadrez.graphic.CanvasBackgrounds();
        btn_Nova_Partida = new javax.swing.JButton();
        panel_Tabuleiro = new javax.swing.JPanel();
        panel_Controle = new javax.swing.JPanel();
        btn_ImgPeca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_Nome_Peca = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Vida_Peca = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Habilidade_Peca = new javax.swing.JLabel();
        btn_Ativar_Habilidade = new javax.swing.JButton();
        btn_Ajuda_Peca = new javax.swing.JButton();
        txt_Cemiterio = new javax.swing.JLabel();
        txt_Nome_Player = new javax.swing.JLabel();
        btn_finalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_cemiterio = new javax.swing.JList<>();
        txt_Caveira = new javax.swing.JLabel();
        txt_MensagemUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        canvasBackgrounds1.setImg(new ImageIcon("src\\com\\xadrez\\imagens\\TelaXadrez.jpg"));
        canvasBackgrounds1.setPreferredSize(new java.awt.Dimension(815, 651));

        btn_Nova_Partida.setText("Nova Partida");
        btn_Nova_Partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Nova_PartidaActionPerformed(evt);
            }
        });

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
            .addGap(0, 559, Short.MAX_VALUE)
        );
        panel_TabuleiroLayout.setVerticalGroup(
            panel_TabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_Controle.setBackground(new java.awt.Color(255, 153, 102));

        btn_ImgPeca.setBackground(new java.awt.Color(255, 255, 255));
        btn_ImgPeca.setBorder(null);
        btn_ImgPeca.setBorderPainted(false);
        btn_ImgPeca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_ImgPeca.setDefaultCapable(false);
        btn_ImgPeca.setFocusPainted(false);
        btn_ImgPeca.setFocusable(false);
        btn_ImgPeca.setMaximumSize(new java.awt.Dimension(88, 85));
        btn_ImgPeca.setMinimumSize(new java.awt.Dimension(88, 85));
        btn_ImgPeca.setPreferredSize(new java.awt.Dimension(88, 85));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/xadrez/imagens/infoPeca_Nome.png"))); // NOI18N

        txt_Nome_Peca.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        txt_Nome_Peca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_Nome_Peca.setText("nome da peca");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/xadrez/imagens/infoPeca_Vida.png"))); // NOI18N

        txt_Vida_Peca.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        txt_Vida_Peca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_Vida_Peca.setText("40");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/xadrez/imagens/infoPeca_Habilidade.png"))); // NOI18N

        txt_Habilidade_Peca.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        txt_Habilidade_Peca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_Habilidade_Peca.setText("disponível");

        btn_Ativar_Habilidade.setText("Ativar Habilidade");
        btn_Ativar_Habilidade.setBorderPainted(false);
        btn_Ativar_Habilidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Ativar_Habilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ativar_HabilidadeActionPerformed(evt);
            }
        });

        btn_Ajuda_Peca.setText("Ajuda");
        btn_Ajuda_Peca.setBorderPainted(false);
        btn_Ajuda_Peca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ajuda_PecaActionPerformed(evt);
            }
        });

        txt_Cemiterio.setFont(new java.awt.Font("Double Feature", 0, 18)); // NOI18N
        txt_Cemiterio.setForeground(new java.awt.Color(51, 51, 51));
        txt_Cemiterio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Cemiterio.setText("CEMITÉRIO");

        txt_Nome_Player.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txt_Nome_Player.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Nome_Player.setText("NOME DO JOGADOR");

        btn_finalizar.setText("Finalizar Jogada");
        btn_finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarActionPerformed(evt);
            }
        });

        lista_cemiterio.setFont(new java.awt.Font("Barbarian", 0, 18)); // NOI18N
        lista_cemiterio.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista_cemiterio);

        txt_Caveira.setFont(new java.awt.Font("DesignersSkulls", 0, 36)); // NOI18N
        txt_Caveira.setText("n");
        txt_Caveira.setToolTipText("");

        javax.swing.GroupLayout panel_ControleLayout = new javax.swing.GroupLayout(panel_Controle);
        panel_Controle.setLayout(panel_ControleLayout);
        panel_ControleLayout.setHorizontalGroup(
            panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ControleLayout.createSequentialGroup()
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ControleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_ControleLayout.createSequentialGroup()
                                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_ControleLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(panel_ControleLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Nome_Peca, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_Vida_Peca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_Habilidade_Peca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                            .addGroup(panel_ControleLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txt_Nome_Player, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panel_ControleLayout.createSequentialGroup()
                        .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_ControleLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(txt_Cemiterio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Caveira, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_ControleLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_ControleLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(btn_ImgPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panel_ControleLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_finalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Ativar_Habilidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Ajuda_Peca, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_ControleLayout.setVerticalGroup(
            panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ControleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txt_Nome_Player)
                .addGap(18, 18, 18)
                .addComponent(btn_ImgPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Nome_Peca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_Vida_Peca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_Habilidade_Peca))
                .addGap(18, 18, 18)
                .addComponent(btn_Ativar_Habilidade)
                .addGap(11, 11, 11)
                .addComponent(btn_finalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Ajuda_Peca)
                .addGap(7, 7, 7)
                .addGroup(panel_ControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Cemiterio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Caveira, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        txt_MensagemUsuario.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txt_MensagemUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout canvasBackgrounds1Layout = new javax.swing.GroupLayout(canvasBackgrounds1);
        canvasBackgrounds1.setLayout(canvasBackgrounds1Layout);
        canvasBackgrounds1Layout.setHorizontalGroup(
            canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                        .addComponent(panel_Tabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Controle, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                        .addComponent(btn_Nova_Partida)
                        .addGap(157, 157, 157)
                        .addComponent(txt_MensagemUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        canvasBackgrounds1Layout.setVerticalGroup(
            canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasBackgrounds1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Nova_Partida)
                    .addComponent(txt_MensagemUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(canvasBackgrounds1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Tabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Controle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jLabel2.setBackground(new Color(0,0,0,0));
        jLabel3.setBackground(new Color(0,0,0,0));
        jLabel4.setBackground(new Color(0,0,0,0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvasBackgrounds1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvasBackgrounds1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
        );

        this.setLocation(300,50);
        this.setResizable(false);

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

    private void btn_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarActionPerformed
        if(xadrez.moveu == true || xadrez.usouHabilidade == true){
            xadrez.moveu=true;
            xadrez.usouHabilidade = true;
            xadrez.mudaTurno();
        }else{
        JOptionPane.showMessageDialog(null, "É preciso mover uma peça ou usar uma habilidade antes");
        }
    }//GEN-LAST:event_btn_finalizarActionPerformed

    private void btn_Ativar_HabilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ativar_HabilidadeActionPerformed
        if(xadrez.getPecaEmSelecao().getCoolDown()==0){
            xadrez.usouHabilidade = true;
            xadrez.getPecaEmSelecao().Habilidade();
            xadrez.mudaTurno();
        }
    }//GEN-LAST:event_btn_Ativar_HabilidadeActionPerformed

    private void btn_Ajuda_PecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ajuda_PecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Ajuda_PecaActionPerformed

  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ajuda_Peca;
    private javax.swing.JButton btn_Ativar_Habilidade;
    private javax.swing.JButton btn_ImgPeca;
    private javax.swing.JButton btn_Nova_Partida;
    private javax.swing.JButton btn_finalizar;
    private com.xadrez.graphic.CanvasBackgrounds canvasBackgrounds1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista_cemiterio;
    private javax.swing.JPanel panel_Controle;
    private javax.swing.JPanel panel_Tabuleiro;
    private javax.swing.JLabel txt_Caveira;
    private javax.swing.JLabel txt_Cemiterio;
    private javax.swing.JLabel txt_Habilidade_Peca;
    private javax.swing.JLabel txt_MensagemUsuario;
    private javax.swing.JLabel txt_Nome_Peca;
    private javax.swing.JLabel txt_Nome_Player;
    private javax.swing.JLabel txt_Vida_Peca;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icone.png")));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Espace_praticien.*;


import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static public_var.variables.*;
import rojerusan.RSPanelsSlider;
/*
 *
 * @author berich
 */
public class praticien_login extends javax.swing.JFrame {
 
  public static String  idf;
    public praticien_login() {
        initComponents();
        cnx= DB_Connexion.Connexion();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        
    }

    public String recuperer(){
        return idf ;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_pra_local = new rojerusan.RSButtonMetro();
        btn_pra_spec = new rojerusan.RSButtonMetro();
        PanelSlider = new rojerusan.RSPanelsSlider();
        pra_spec = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spec = new rojerusan.RSComboMetro();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        btn_cnx_spec = new rojerusan.RSButtonMetro();
        jLabel11 = new javax.swing.JLabel();
        txt_login1 = new rojerusan.RSMetroTextFullPlaceHolder();
        txt_pass1 = new rojerusan.RSMetroTextPassPlaceHolderView();
        pra_local = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spec2 = new rojerusan.RSComboMetro();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btn_cnx_local = new rojerusan.RSButtonMetro();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        jLabel10 = new javax.swing.JLabel();
        txt_login2 = new rojerusan.RSMetroTextFullPlaceHolder();
        txt_pass2 = new rojerusan.RSMetroTextPassPlaceHolderView();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1350, 750));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(3, 182, 215));
        jLabel4.setText("Bienvenue");

        btn_pra_local.setBackground(new java.awt.Color(3, 182, 215));
        btn_pra_local.setText("Local");
        btn_pra_local.setFocusPainted(false);
        btn_pra_local.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pra_localActionPerformed(evt);
            }
        });

        btn_pra_spec.setBackground(new java.awt.Color(3, 182, 215));
        btn_pra_spec.setText("Centre Spécialisé");
        btn_pra_spec.setFocusPainted(false);
        btn_pra_spec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pra_specActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_pra_spec, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btn_pra_local, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pra_local, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pra_spec, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new Color(255,255,255,120));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(500, 30, 390, 150);

        PanelSlider.setBackground(new java.awt.Color(255, 255, 255));

        pra_spec.setBackground(new java.awt.Color(255, 255, 255));
        pra_spec.setForeground(new java.awt.Color(3, 182, 215));
        pra_spec.setName("pra_spec"); // NOI18N
        pra_spec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pra_specMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pra_specMouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_User_48px_7.png"))); // NOI18N
        jLabel8.setToolTipText("nom d'utilisateur");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Lock_50px_2.png"))); // NOI18N
        jLabel9.setToolTipText("mot de passe");

        spec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pneumologue", "oncologue", "radiologue", "pathologiste", "oncologue radiothérapeute", "chirurgien thoracique", "Laboratoire d’analyses médicales", "pharmacien " }));
        spec.setToolTipText("Spécialité");
        spec.setColorArrow(new java.awt.Color(3, 182, 215));
        spec.setColorBorde(new java.awt.Color(255, 255, 255));
        spec.setColorFondo(new java.awt.Color(3, 182, 215));
        spec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(3, 182, 215));
        jLabel2.setText("  Centre Spécialisé");

        btn_cnx_spec.setBackground(new java.awt.Color(3, 182, 215));
        btn_cnx_spec.setText("Connexion");
        btn_cnx_spec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cnx_specActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Multiple_Choice_50px_3.png"))); // NOI18N
        jLabel11.setToolTipText("choisir une spécialité");

        txt_login1.setForeground(new java.awt.Color(3, 182, 215));
        txt_login1.setBorderColor(new java.awt.Color(3, 182, 215));
        txt_login1.setBotonColor(new java.awt.Color(3, 182, 215));
        txt_login1.setPhColor(new java.awt.Color(3, 182, 215));
        txt_login1.setPlaceholder("Identifiant");

        txt_pass1.setForeground(new java.awt.Color(3, 182, 215));
        txt_pass1.setBorderColor(new java.awt.Color(3, 182, 215));
        txt_pass1.setBotonColor(new java.awt.Color(3, 182, 215));
        txt_pass1.setPhColor(new java.awt.Color(3, 182, 215));
        txt_pass1.setPlaceholder("Mot de passe");
        txt_pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pass1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pra_specLayout = new javax.swing.GroupLayout(pra_spec);
        pra_spec.setLayout(pra_specLayout);
        pra_specLayout.setHorizontalGroup(
            pra_specLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pra_specLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cnx_spec, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(pra_specLayout.createSequentialGroup()
                .addGroup(pra_specLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pra_specLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pra_specLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pra_specLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(pra_specLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spec, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_login1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pra_specLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pra_specLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pra_specLayout.setVerticalGroup(
            pra_specLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pra_specLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pra_specLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(spec, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pra_specLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_login1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pra_specLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txt_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btn_cnx_spec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(405, 405, 405))
        );

        PanelSlider.add(pra_spec, "card2");

        pra_local.setBackground(new java.awt.Color(255, 255, 255));
        pra_local.setName("pra_local"); // NOI18N
        pra_local.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pra_localMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pra_localMouseExited(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_User_48px_7.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Lock_50px_2.png"))); // NOI18N

        spec2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Médecin référant local", "radiologue", "Laboratoire d’analyse Médicales", "pharmacien" }));
        spec2.setToolTipText("Spécialité");
        spec2.setColorArrow(new java.awt.Color(3, 182, 215));
        spec2.setColorBorde(new java.awt.Color(255, 255, 255));
        spec2.setColorFondo(new java.awt.Color(3, 182, 215));
        spec2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spec2ActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(3, 182, 215));

        jLabel3.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(3, 182, 215));
        jLabel3.setText("Praticien Local");

        btn_cnx_local.setBackground(new java.awt.Color(3, 182, 215));
        btn_cnx_local.setText("Connexion");
        btn_cnx_local.setFocusPainted(false);
        btn_cnx_local.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cnx_localActionPerformed(evt);
            }
        });

        rSButtonHover1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonHover1.setForeground(new java.awt.Color(3, 185, 215));
        rSButtonHover1.setText("inscrire");
        rSButtonHover1.setBorderPainted(false);
        rSButtonHover1.setColorHover(new java.awt.Color(255, 255, 255));
        rSButtonHover1.setColorText(new java.awt.Color(3, 182, 215));
        rSButtonHover1.setColorTextHover(new java.awt.Color(102, 102, 102));
        rSButtonHover1.setFocusPainted(false);
        rSButtonHover1.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Multiple_Choice_50px_3.png"))); // NOI18N
        jLabel10.setToolTipText("choisir une spécialité");

        txt_login2.setForeground(new java.awt.Color(3, 182, 215));
        txt_login2.setBorderColor(new java.awt.Color(3, 182, 215));
        txt_login2.setBotonColor(new java.awt.Color(3, 182, 215));
        txt_login2.setPlaceholder("Identifiant");

        txt_pass2.setForeground(new java.awt.Color(3, 182, 215));
        txt_pass2.setBorderColor(new java.awt.Color(3, 182, 215));
        txt_pass2.setBotonColor(new java.awt.Color(3, 182, 215));
        txt_pass2.setPhColor(new java.awt.Color(3, 182, 215));
        txt_pass2.setPlaceholder("Mot de passe");

        javax.swing.GroupLayout pra_localLayout = new javax.swing.GroupLayout(pra_local);
        pra_local.setLayout(pra_localLayout);
        pra_localLayout.setHorizontalGroup(
            pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pra_localLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pra_localLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pra_localLayout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pra_localLayout.createSequentialGroup()
                                .addGroup(pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_login2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(spec2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txt_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pra_localLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pra_localLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cnx_local, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );
        pra_localLayout.setVerticalGroup(
            pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pra_localLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spec2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(pra_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pra_localLayout.createSequentialGroup()
                        .addComponent(txt_login2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pra_localLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btn_cnx_local, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelSlider.add(pra_local, "card3");

        getContentPane().add(PanelSlider);
        PanelSlider.setBounds(500, 195, 390, 460);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Logout_Rounded_Left_50px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 20, 50, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/bgdoc.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1600, 1102));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -20, 1600, 1141);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pra_localMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pra_localMouseEntered
     
    }//GEN-LAST:event_pra_localMouseEntered

    private void pra_localMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pra_localMouseExited
       
    }//GEN-LAST:event_pra_localMouseExited

    private void pra_specMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pra_specMouseExited
      
    }//GEN-LAST:event_pra_specMouseExited

    private void pra_specMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pra_specMouseEntered
      
    }//GEN-LAST:event_pra_specMouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.hide();
        login_Home h = new  login_Home();
        h.setVisible(true);

    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn_pra_localActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pra_localActionPerformed
       if (!this.btn_pra_local.isSelected()) {
            this.btn_pra_spec.setSelected(false);
            this.btn_pra_local.setSelected(true);
          
            this.PanelSlider.slidPanel(2, pra_local, RSPanelsSlider.direct.Right);}        // TODO add your handling code here:
                                     
    }//GEN-LAST:event_btn_pra_localActionPerformed

    private void btn_pra_specActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pra_specActionPerformed
      if (!this.btn_pra_spec.isSelected()) {
            this.btn_pra_spec.setSelected(true);
            this.btn_pra_local.setSelected(false);
           
            this.PanelSlider.slidPanel(2, pra_spec, RSPanelsSlider.direct.Right);}
    }//GEN-LAST:event_btn_pra_specActionPerformed

    private void btn_cnx_specActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cnx_specActionPerformed
       String rqt =" select * from praticien where `praticien_identifiant` = ? and `praticien_password` = ?  and `praticien_specialite`= ?  " ;
       String specialite= (String) spec.getSelectedItem();
       try{
            ps = cnx.prepareStatement(rqt);
            ps.setString(1, txt_login1.getText()); idf=txt_login1.getText();
            ps.setString(2, String.valueOf(txt_pass1.getPassword()));
            ps.setString(3,specialite );
           
            rs = ps.executeQuery();
        if(rs.next()){
          setVisible(false);
       
         if (specialite.equals("pneumologue")) new pneumologue().setVisible(true);
         if (specialite.equals("oncologue")) new oncologue().setVisible(true);
         if (specialite.equals("pathologiste")) new s_anatomie_pathologique().setVisible(true);
         if (specialite.equals("oncologue radiothérapeute")) new radiotherapie().setVisible(true);
         if (specialite.equals("chirurgien thoracique")) new chirurgie_thoracique().setVisible(true);
         if (specialite.equals("Laboratoire d’analyse Médicales")) new labo_analyses().setVisible(true);
         if (specialite.equals("radiologue")) new radiologue().setVisible(true);
         if (specialite.equals("pharmacien")) new pharmacien().setVisible(true);
        }else { JOptionPane.showMessageDialog(this, "identifiant ou mot de passe incorrect( PS: vérifier ta spécialité )");
       txt_login1.setText("");
       txt_pass1.setText("");
        }
                ps.close();
                rs.close();
                
        }catch(SQLException e){
           Logger.getLogger(praticien_login.class.getName()).log(Level.SEVERE ,null,e);
           
    }                             
    }//GEN-LAST:event_btn_cnx_specActionPerformed

    private void btn_cnx_localActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cnx_localActionPerformed
       String rqt =" select * from praticien where `praticien_identifiant` = ? and `praticien_password` = ?  and `praticien_specialite`= ?  " ;
        String specialite= (String) spec2.getSelectedItem();
       try{
            ps = cnx.prepareStatement(rqt);
            ps.setString(1, txt_login2.getText()); idf=txt_login2.getText();
            ps.setString(2, String.valueOf(txt_pass2.getPassword()));
            ps.setString(3,specialite );
            rs = ps.executeQuery();
        if(rs.next()){
          setVisible(false);
          if (specialite.equals("Médecin référant local")) new medecin_Ref_local().setVisible(true);
         if (specialite.equals("radiologue")) new radiologue().setVisible(true);
         if (specialite.equals("Laboratoire d’analyse Médicales")) new labo_analyses().setVisible(true);
         if (specialite.equals("pharmacien") )new pharmacien().setVisible(true);
         
        
        }else { JOptionPane.showMessageDialog(this, "identifiant ou mot de passe  incorrect ( PS: vérifier votre  spécialité ) ");
       txt_login2.setText("");
       txt_pass2.setText("");
        }
                ps.close();
                rs.close();
                
        }catch(SQLException e){
           Logger.getLogger(praticien_login.class.getName()).log(Level.SEVERE ,null,e);
           
    }                      
    }//GEN-LAST:event_btn_cnx_localActionPerformed

    private void spec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spec2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spec2ActionPerformed

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        new inscrire_prat_local().setVisible(true);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void txt_pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pass1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(praticien_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(praticien_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(praticien_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(praticien_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new praticien_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSPanelsSlider PanelSlider;
    private rojerusan.RSButtonMetro btn_cnx_local;
    private rojerusan.RSButtonMetro btn_cnx_spec;
    private rojerusan.RSButtonMetro btn_pra_local;
    private rojerusan.RSButtonMetro btn_pra_spec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pra_local;
    private javax.swing.JPanel pra_spec;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSComboMetro spec;
    private rojerusan.RSComboMetro spec2;
    private rojerusan.RSMetroTextFullPlaceHolder txt_login1;
    private rojerusan.RSMetroTextFullPlaceHolder txt_login2;
    private rojerusan.RSMetroTextPassPlaceHolderView txt_pass1;
    private rojerusan.RSMetroTextPassPlaceHolderView txt_pass2;
    // End of variables declaration//GEN-END:variables
}

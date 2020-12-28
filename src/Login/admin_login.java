/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import Espace_Admin.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.event.DocumentListener;
import static public_var.variables.*;


/**
 *
 * @author berich
 */
public class admin_login extends javax.swing.JFrame {
    
    
     public static String A;
  
     
    /**
     * Creates new form admin_login
     */
    public admin_login() {
        initComponents();
        
       cnx= DB_Connexion.Connexion();
    }
    
  
    
   
  

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textlogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Description = new javax.swing.JLabel();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        textpassword = new rojerusan.RSMetroTextPassPlaceHolderView();
        jLabel8 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1350, 750));
        getContentPane().setLayout(null);

        textlogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textlogin.setForeground(new java.awt.Color(3, 182, 215));
        textlogin.setText("Admin");
        textlogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));
        textlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textloginMouseClicked(evt);
            }
        });
        textlogin.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                textloginInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        textlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textloginActionPerformed(evt);
            }
        });
        textlogin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textloginPropertyChange(evt);
            }
        });
        textlogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textloginKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_User_48px_7.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Lock_50px_2.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(3, 182, 215));
        jLabel4.setText(" Espace Administrateur");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("_______________________________________________________");

        Description.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N

        rSButtonMetro1.setBackground(new java.awt.Color(3, 182, 215));
        rSButtonMetro1.setText("Connexion");
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });

        rSButtonHover1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonHover1.setForeground(new java.awt.Color(3, 185, 215));
        rSButtonHover1.setText("Changer mot de passe");
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

        textpassword.setForeground(new java.awt.Color(3, 182, 215));
        textpassword.setBorderColor(new java.awt.Color(3, 182, 215));
        textpassword.setBotonColor(new java.awt.Color(3, 182, 215));
        textpassword.setPhColor(new java.awt.Color(3, 182, 215));
        textpassword.setPlaceholder("Mot de passe");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Description, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(218, 218, 218))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(rSButtonMetro1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textlogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButtonMetro1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1.setBackground(new Color(255,255,255,160));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(500, 80, 400, 500);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Logout_Rounded_Left_50px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 10, 50, 90);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/p5.jpg"))); // NOI18N
        bg.setText("jLabel2");
        getContentPane().add(bg);
        bg.setBounds(0, 0, 1594, 1125);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.hide();
        login_Home h = new  login_Home();
        h.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
          String rqt =" select * from admin where 	admin_identifiant = ? and admin_password = ? " ;
        try{
            ps = cnx.prepareStatement(rqt);
            ps.setString(1, textlogin.getText());
            ps.setString(2, String.valueOf(textpassword.getPassword()));
            rs = ps.executeQuery();
        if(rs.next()){
          setVisible(false);
          new Admin_accueil1().setVisible(true);               
        }else { JOptionPane.showMessageDialog(this, "nom d'utilisateur ou mot de passe incorrect");
        textpassword.setText("");}
                ps.close();
                rs.close();
                  
        }catch(SQLException e){
           Logger.getLogger(admin_login.class.getName()).log(Level.SEVERE ,null,e);
           
        }
       
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        new changepassword().setVisible(true);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void textloginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textloginKeyTyped
        char a = evt.getKeyChar();
        evt.consume();

    }//GEN-LAST:event_textloginKeyTyped

    private void textloginPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textloginPropertyChange

    }//GEN-LAST:event_textloginPropertyChange

    private void textloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textloginActionPerformed

    }//GEN-LAST:event_textloginActionPerformed

    private void textloginInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_textloginInputMethodTextChanged

    }//GEN-LAST:event_textloginInputMethodTextChanged

    private void textloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textloginMouseClicked

    }//GEN-LAST:event_textloginMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    Thread.sleep(3000);
                }catch(Exception e){
                    System.out.println(e);
                }
                new admin_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Description;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private javax.swing.JTextField textlogin;
    private rojerusan.RSMetroTextPassPlaceHolderView textpassword;
    // End of variables declaration//GEN-END:variables
}

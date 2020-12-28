/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espace_Patient;

import Login.DB_Connexion;
import static Login.patient_login.idf;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static public_var.variables.*;

/**
 *
 * @author berich
 */
public class Modifier_patient_profil extends javax.swing.JFrame {

  
    patient_home ph= new patient_home();
    public Modifier_patient_profil() {
        initComponents();
        cnx= DB_Connexion.Connexion();
        Afficher_infos();
    }

    //Methods 
    //inserer image : 
    public void insert_image() {
        DB_Connexion c = new  DB_Connexion ();
        c.filen();
        String chemin = c.getchemin();
        try {
        if (chemin == null) {

        } else {
            picture.setIcon(new ImageIcon(chemin));
            chemin_img.setText(chemin);

            } 
            }catch (Exception e) {
                e.printStackTrace();
        }

    }
    
        //Modifier patient
    public void update_patient(){
      
       String situation_fam = (String) situationf.getSelectedItem();
       String Wilaya = (String) wilaya.getSelectedItem();
       String ide = ph.mat.getText();
        String rqt = "update patient  set patient_password=?,patient_address=?,patient_wilaya=?,patient_situation_famillial=?,patient_email=?,patient_num_phone=?,image=? where patient_identifiant= '"+ide+"' ";
        try {
            ps = cnx.prepareStatement(rqt);
           
            ps.setString(1, password.getText());
            ps.setString(2, address.getText());
            ps.setString(3,Wilaya);
            ps.setString(4,situation_fam );
            ps.setString(5, email.getText());
            ps.setString(6, tel.getText());
            ps.setString(7, chemin_img.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modification effectuée");
            ph.Afficher(); 
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
     //Afficher les infos
  
    
    public void Afficher_infos(){
        try {
            
            String rqt = " select * from patient where patient_identifiant = '" +idf+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();

            if (rs.next()) {
               
                
                 
                String s8 = rs.getString("patient_situation_famillial");
                switch(s8)
                {
                    case "Célibataire":
                situationf.setSelectedIndex(0);
                break;
                    case "Marié(e)":
                        situationf.setSelectedIndex(1);
                        break;
                }
                String s9= rs.getString("patient_address");
                address.setText(s9);
                String s10 = rs.getString("patient_wilaya");
                switch(s10){
                    case "1-Adrar": wilaya.setSelectedIndex(0); break;
                     case "2-Chlef": wilaya.setSelectedIndex(1); break;
                      case "3-Laghouat": wilaya.setSelectedIndex(2); break;
                       case "4-Oum El-Bouaghi": wilaya.setSelectedIndex(3); break;
                        case "5-Batna": wilaya.setSelectedIndex(4); break;
                         case "6-Béjaïa": wilaya.setSelectedIndex(5); break;
                          case "7-Biskra": wilaya.setSelectedIndex(6); break;
                           case "8-Béchar": wilaya.setSelectedIndex(7); break;
                            case "9-Blida": wilaya.setSelectedIndex(8); break;
                             case "10-Bouira": wilaya.setSelectedIndex(9); break;
                              case "11-Tamanrasset": wilaya.setSelectedIndex(10); break;
                               case "12-Tébessa": wilaya.setSelectedIndex(11); break;
                                case "13-Tlemcen": wilaya.setSelectedIndex(12); break;
                                 case "14-Tiaret": wilaya.setSelectedIndex(13); break;
                                  case "15-Tizi Ouzou": wilaya.setSelectedIndex(14); break;
                     case "16-Alger": wilaya.setSelectedIndex(15); break;
                      case "17-Djelfa": wilaya.setSelectedIndex(16); break;
                       case "18-Jijel": wilaya.setSelectedIndex(17); break;
                        case "19-Sétif": wilaya.setSelectedIndex(18); break;
                         case "20-Saida": wilaya.setSelectedIndex(19); break;
                          case "21-Skikda": wilaya.setSelectedIndex(20); break;
                           case "22-Sidi Bel Abbes": wilaya.setSelectedIndex(21); break;
                            case "23-Annaba": wilaya.setSelectedIndex(22); break;
                             case "24-Guelma": wilaya.setSelectedIndex(23); break;
                              case "25-Constantine": wilaya.setSelectedIndex(24); break;
                               case "26-Médéa": wilaya.setSelectedIndex(25); break;
                                case "27-Mostaganem": wilaya.setSelectedIndex(26); break;
                                 case "28-M'Sila": wilaya.setSelectedIndex(27); break;
                                  case "29-Mascara": wilaya.setSelectedIndex(28); break;
                     case "30-Ouargla": wilaya.setSelectedIndex(29); break;
                      case "31-Oran": wilaya.setSelectedIndex(30); break;
                       case "32-El-Bayadh": wilaya.setSelectedIndex(31); break;
                        case "33-Illizi": wilaya.setSelectedIndex(32); break;
                         case "34-Bord-Bou-Arréridj": wilaya.setSelectedIndex(33); break;
                          case "35-Boumerdès": wilaya.setSelectedIndex(34); break;
                           case "36-El-Taref": wilaya.setSelectedIndex(35); break;
                            case "37-Tindouf": wilaya.setSelectedIndex(36); break;
                              case "38-Tissemsilt": wilaya.setSelectedIndex(37); break;
                               case "39-El Oued": wilaya.setSelectedIndex(38); break;
                                case "40-Khenchela": wilaya.setSelectedIndex(39); break;
                                 case "41-Souk Ahras": wilaya.setSelectedIndex(40); break;
                                  case "42-Tipaza": wilaya.setSelectedIndex(41); break;
                                   case "43-Milaa": wilaya.setSelectedIndex(42); break;
                                    case "44-Aïn Defla": wilaya.setSelectedIndex(43); break;
                     case "45-Naâma": wilaya.setSelectedIndex(44); break;
                      case "46-Aïn Témouchent": wilaya.setSelectedIndex(45); break;
                       case "47-Ghardaïa": wilaya.setSelectedIndex(46); break;
                        case "48-Relizane": wilaya.setSelectedIndex(47); break;
                        
                
                
                }
                
                
                String s11 = rs.getString("patient_email");
                
                email.setText(s11);
                String s12 = rs.getString("patient_num_phone");
                tel.setText(s12);
                String s14 =rs.getString("image");
                if(s14.equals("")){
                 ImageIcon img = new ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/sem_foto.jpg"));
                picture.setIcon(img);
                }else{
                picture.setIcon(new ImageIcon(s14));
                }
                String s16 = rs.getString("patient_password");
                password.setText(s16);
                String s17 = rs.getString("image");
                chemin_img.setText(s17);
                
              
               String s20=rs.getString("date_insc");
               date_inscr.setText(s20); 
             
               
            }
                ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }

     /* public void  generer_id_patient(){
      String phone= tel.getText();
      String g="P."+phone+"";
      id.setText(g); 
      }
      
      public void  generer_Num_doss(){
    
      String phone= tel.getText();
     
      String annee= (date_inscr.getText()).substring(0,4);
      String m ="DM."+phone+"/"+annee+"";
      ndoss.setText(m); 
      }
       */
                  
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        situationf = new javax.swing.JComboBox<>();
        address = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        wilaya = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        picture = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        chemin_img = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        btn_update = new rojerusan.RSButtonHover();
        jLabel1 = new javax.swing.JLabel();
        date_inscr = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(3, 182, 215));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations Patient", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andalus", 1, 18), new java.awt.Color(3, 182, 215))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(44, 62, 80));
        jLabel5.setText("Situation Familliale :");

        jLabel7.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(44, 62, 80));
        jLabel7.setText("Adresse :");

        jLabel8.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(44, 62, 80));
        jLabel8.setText("Wilaya :");

        jLabel9.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(44, 62, 80));
        jLabel9.setText("Email :");

        jLabel10.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(44, 62, 80));
        jLabel10.setText("Télephone :");

        situationf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Célibataire", "Marié(e)" }));

        tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telKeyTyped(evt);
            }
        });

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        wilaya.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-Adrar", "2-Chlef", "3-Laghouat", "4-Oum El-Bouaghi", "5-Batna", "6-Béjaïa", "7-Biskra", "8-Béchar", "9-Blida", "10-Bouira", "11-Tamanrasset", "12-Tébessa", "13-Tlemcen", "14-Tiaret", "15-Tizi Ouzou", "16-Alger", "17-Djelfa", "18-Jijel", "19-Sétif", "20-Saida", "21-Skikda", "22-Sidi Bel Abbes", "23-Annaba", "24-Guelma", "25-Constantine", "26-Médéa", "27-Mostaganem", "28-M'Sila", "29-Mascara", "30-Ouargla", "31-Oran", "32-El-Bayadh", "33-Illizi", "34-Bord-Bou-Arréridj", "35-Boumerdès", "36-El-Taref", "37-Tindouf", "38-Tissemsilt", "39-El Oued", "40-Khenchela", "41-Souk Ahras", "42-Tipaza", "43-Mila", "44-Aïn Defla", "45-Naâma", "46-Aïn Témouchent", "47-Ghardaïa", "48-Relizane" }));
        wilaya.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        wilaya.setName("wilaya"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/sem_foto.jpg"))); // NOI18N
        jScrollPane1.setViewportView(picture);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Add_Image_40px_1.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        chemin_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chemin_imgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chemin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(chemin_img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel3.setBackground(new Color(255,255,255,120));

        jLabel13.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(44, 62, 80));
        jLabel13.setText("Mot De Passe :");

        btn_update.setBackground(new java.awt.Color(3, 182, 215));
        btn_update.setText("Valider");
        btn_update.setToolTipText("");
        btn_update.setColorHover(new java.awt.Color(255, 255, 255));
        btn_update.setColorTextHover(new java.awt.Color(3, 182, 215));
        btn_update.setFocusPainted(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(situationf, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wilaya, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(password)
                                    .addComponent(tel, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(situationf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(wilaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new Color(255,255,255,200));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(200, 40, 450, 590);

        jLabel1.setText("Date d'inscription:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(210, 20, 120, 14);
        jPanel1.add(date_inscr);
        date_inscr.setBounds(310, 20, 100, 14);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/free-office-wallpaper-26001-26685-hd-wallpapers.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(-420, -400, 1290, 1130);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(875, 738));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chemin_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chemin_imgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chemin_imgActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        insert_image();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       update_patient();
      
       
    }//GEN-LAST:event_btn_updateActionPerformed

    private void telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telKeyTyped
        //  pour taper que des chiffres
         char tlf = evt.getKeyChar();
          if (!(Character.isDigit(tlf) || (tlf == KeyEvent.VK_BACK_SPACE) || (tlf == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_telKeyTyped

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

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
            java.util.logging.Logger.getLogger(Modifier_patient_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modifier_patient_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modifier_patient_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modifier_patient_profil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modifier_patient_profil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private rojerusan.RSButtonHover btn_update;
    private javax.swing.JTextField chemin_img;
    private javax.swing.JLabel date_inscr;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField password;
    private javax.swing.JLabel picture;
    private javax.swing.JComboBox<String> situationf;
    private javax.swing.JTextField tel;
    private javax.swing.JComboBox<String> wilaya;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espace_praticien;
import Dossier_Médical.CR_examination;
import Dossier_Médical.dossier_med;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.*;

import Espace_Patient.*;
import Listes.praticien;
import Login.*;
import static Login.patient_login.idf;
import interfaces.inter_praticien;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import public_var.fonctions;
import static public_var.variables.*;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author berich
 */
public class medecin_Ref_local extends javax.swing.JFrame {
     int position;
     String atachement_path;
    public medecin_Ref_local() {
        initComponents();
        cnx= DB_Connexion.Connexion();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
       fonctions.HeureSystem(Heure);
        
        Afficher();
        btn_ok.setVisible(false);
         this.MenuP.add(pn_Menup);
         
          Affichertable_praticien();
    }
    praticien_login ph =new praticien_login();
     
     
     public void Afficher(){
        try {
            praticien_login ph =new praticien_login();
            String idft=  ph.recuperer();
            String rqt = " select * from praticien where praticien_identifiant = '" +idft+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("praticien_identifiant");
                id.setText(s1);
                String s2 = rs.getString("praticien_nom");
                nom.setText(s2);
                nom_prat.setText(s2);
                String s3 = rs.getString("praticien_prenom");
                prenom.setText(s3);
                String s4 = rs.getString("praticien_type");
                type.setText(s4);
                String s5 = rs.getString("praticien_specialite");
                spec.setText(s5);
                String s6 = rs.getString("praticien_email");
                mail.setText(s6);
                String s7 = rs.getString("praticien_num_phone");
                tel.setText(s7);
                String s8 = rs.getString("praticien_password");
                pass2.setText(s8);
                String s9=rs.getString("address");
                address.setText(s9);
           
                
            }
                ps.close();
                rs.close();
               
        } catch (Exception e) {
            System.out.println(e);
            
        }
        }
      
    
    
    
    public void update_praticien(){
      
       

       String idf = id.getText();
        String rqt = "update praticien  set    praticien_password=? ,praticien_email=?,praticien_num_phone=? where praticien_identifiant= '"+idf+"' ";
        try {
            ps = cnx.prepareStatement(rqt);
           
            ps.setString(1, pass2.getText());
           
            ps.setString(2, mail.getText());
            ps.setString(3, tel.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modification effectuée");
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
    // Afficher 
     public void afficher_infos_patient( dossier_med info) {
        
        try {
            int R =  MES_PATIENTS.getSelectedRow();
            String M = (MES_PATIENTS.getModel().getValueAt(R, 0).toString());
            String rqt = " select * from patient where N_doss_med= '" +M+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                 String s = rs.getString("N_doss_med");
               info.numdoss.setText(s);
               //info.doss.setText(s);
                String s1 = rs.getString("patient_identifiant");
               info.mat.setText(s1);
                String s2 = rs.getString("patient_nom");
                info.nom.setText(s2);
               
                String s3 = rs.getString("patient_prenom");
                info.prenom.setText(s3);
               
                String s4 = rs.getString("patient_date_naiss");
                info.date_naiss.setText(s4);
                String s5 = rs.getString("patient_age");
                info.age.setText(s5);
               
                String s6 = rs.getString("patient_sexe");
                info.sexe.setText(s6);
                String s7 = rs.getString("patient_gsanguin");
                info.gsang.setText(s7);
                String s8 = rs.getString("patient_situation_famillial");
                info.sit_fam.setText(s8);
                String s9= rs.getString("patient_address");
                info.address.setText(s9);
                String s10 = rs.getString("patient_wilaya");
                info.wilaya.setText(s10 );
                String s11 = rs.getString("patient_email");
                info.email.setText(s11);
                String s12 = rs.getString("patient_num_phone");
                info.tlf.setText(s12);
                String s13 = rs.getString("patient_code_assurance");
                info.code_assurance.setText(s13);
                String s14 =rs.getString("image");
                if(s14.equals("")){
                ImageIcon img = new ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/sem_foto.jpg"));
                info.image.setIcon(img);
                }else{
                info.image.setIcon(new ImageIcon(s14));
                }
                String s15 = rs.getString("date_insc");
                info.dateins.setText(s15);
                String s16 = rs.getString("pneumolgue_ref");
                inter_praticien inter_pra = new inter_praticien();
                praticien pn= (praticien) inter_pra.selectnom_prenom(s16);
                info.pneu.setText(pn.toString());
                String s17 = rs.getString("oncologue_ref");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s17);
                info.onco.setText(pn2.toString());
                
            }
                ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
     
     
      //Remplir qlq champs :
 
     public void Remplir_CR( CR_examination C){
       String idft= ph.recuperer();
         //nom Docteur
       inter_praticien inter_pra2 = new inter_praticien();
       praticien pn2= (praticien) inter_pra2.selectnom_prenom(idft);
       C.nom_prenom.setText(pn2.toString());
       //Address 
       String s1=address.getText();
       C.address.setText(s1);
       C.id.setText(idft);
       
       String c=spec.getText();
       C.spece.setText(c);
       
        
        try {
            int R =  MES_PATIENTS.getSelectedRow();
            String M = (MES_PATIENTS.getModel().getValueAt(R, 0).toString());
            String rqt = " select * from patient where N_doss_med= '" +M+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                 String s = rs.getString("N_doss_med");
               
                C.doss.setText(s);
                String s2 = rs.getString("patient_nom");
                C.nomp.setText(s2);
                String s3 = rs.getString("patient_prenom");
                C.prenomp.setText(s3);
                String s5 = rs.getString("patient_age");
                C.AgeP.setText(s5);
               
                
            }
                ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
       
       
     }
     
   
     //recherche :
     public void recherche_patient2( String rech)
     {
         try {
         String rqt= "select  N_doss_med as 'N° dossier médical', patient_nom  as 'Nom',  patient_prenom as 'Prenom' ,patient_date_naiss as 'Date de naissance' from patient where N_doss_med LIKE'" + rech + "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
    
           MES_PATIENTS.setModel(DbUtils.resultSetToTableModel(rs));
             ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_Menup = new javax.swing.JPanel();
        btn_CR = new rojerusan.RSButtonPane();
        jLabel33 = new javax.swing.JLabel();
        voir = new rojerusan.RSButtonPane();
        jLabel35 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        MenuP = new rojerusan.RSPopuMenu();
        liste_praticiens = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        table_praticien = new rojerusan.RSTableMetro()    {public boolean isCellEditable(int d,int c){
            return false;
        }
    };
    textsearch4 = new rojerusan.RSMetroTextFullPlaceHolder();
    jLabel49 = new javax.swing.JLabel();
    liste_patients = new javax.swing.JPanel();
    jPanel8 = new javax.swing.JPanel();
    jScrollPane7 = new javax.swing.JScrollPane();
    table_patient1 = new rojerusan.RSTableMetro();
    textsearch2 = new rojerusan.RSMetroTextFullPlaceHolder();
    jLabel39 = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    panelp = new javax.swing.JPanel();
    jSeparator1 = new javax.swing.JSeparator();
    jSeparator2 = new javax.swing.JSeparator();
    jSeparator3 = new javax.swing.JSeparator();
    btn_accueil = new rojerusan.RSButtonMetro();
    btn_dossier = new rojerusan.RSButtonHover();
    btn_profil = new rojerusan.RSButtonHover();
    btn_msg = new rojerusan.RSButtonHover();
    jLabel2 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    nom_prat = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    PanelSlider = new rojerusan.RSPanelsSlider();
    accuiel = new javax.swing.JPanel();
    Heure = new javax.swing.JLabel();
    jCalendar1 = new com.toedter.calendar.JCalendar();
    profil_praticien = new javax.swing.JPanel();
    jPanel4 = new javax.swing.JPanel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jPanel5 = new javax.swing.JPanel();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    jLabel22 = new javax.swing.JLabel();
    jLabel23 = new javax.swing.JLabel();
    jLabel24 = new javax.swing.JLabel();
    jLabel25 = new javax.swing.JLabel();
    jLabel26 = new javax.swing.JLabel();
    pass2 = new javax.swing.JTextField();
    id = new javax.swing.JTextField();
    prenom = new javax.swing.JTextField();
    nom = new javax.swing.JTextField();
    type = new javax.swing.JTextField();
    mail = new javax.swing.JTextField();
    tel = new javax.swing.JTextField();
    spec = new javax.swing.JTextField();
    jLabel28 = new javax.swing.JLabel();
    btn_ok = new rojerusan.RSButtonHover();
    jLabel32 = new javax.swing.JLabel();
    address = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    C_dossier_med = new javax.swing.JPanel();
    jPanel7 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    MES_PATIENTS = new rojerusan.RSTableMetro(){public boolean isCellEditable(int d,int c){
        return false;
    }};
    jLabel29 = new javax.swing.JLabel();
    textsearch3 = new rojerusan.RSMetroTextFullPlaceHolder();
    jLabel7 = new javax.swing.JLabel();
    messagerie = new javax.swing.JPanel();
    jPanel6 = new javax.swing.JPanel();
    jLabel44 = new javax.swing.JLabel();
    jScrollPane9 = new javax.swing.JScrollPane();
    msg = new javax.swing.JTextArea();
    from = new javax.swing.JTextField();
    jLabel45 = new javax.swing.JLabel();
    jLabel47 = new javax.swing.JLabel();
    jLabel43 = new javax.swing.JLabel();
    jLabel46 = new javax.swing.JLabel();
    path_attach = new javax.swing.JTextField();
    jLabel41 = new javax.swing.JLabel();
    subject = new rojerusan.RSMetroTextFullPlaceHolder();
    name = new rojerusan.RSMetroTextFullPlaceHolder();
    to = new rojerusan.RSMetroTextFullPlaceHolder();
    pass = new rojerusan.RSMetroTextPassPlaceHolderView();
    btn_envoyer = new javax.swing.JButton();
    btn_annuler = new javax.swing.JButton();
    rSButtonHover5 = new rojerusan.RSButtonHover();
    rSButtonHover6 = new rojerusan.RSButtonHover();
    scrol = new javax.swing.JScrollPane();

    pn_Menup.setBackground(new java.awt.Color(255, 255, 255));
    pn_Menup.setPreferredSize(new java.awt.Dimension(350, 90));

    btn_CR.setBackground(new java.awt.Color(255, 255, 255));
    btn_CR.setColorHover(new java.awt.Color(52, 73, 94));
    btn_CR.setColorNormal(new java.awt.Color(255, 255, 255));
    btn_CR.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            btn_CRMousePressed(evt);
        }
    });

    jLabel33.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel33.setForeground(new java.awt.Color(3, 182, 215));
    jLabel33.setText("Ajouter un compte rendu");

    javax.swing.GroupLayout btn_CRLayout = new javax.swing.GroupLayout(btn_CR);
    btn_CR.setLayout(btn_CRLayout);
    btn_CRLayout.setHorizontalGroup(
        btn_CRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_CRLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(55, 55, 55))
    );
    btn_CRLayout.setVerticalGroup(
        btn_CRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(btn_CRLayout.createSequentialGroup()
            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    voir.setBackground(new java.awt.Color(255, 255, 255));
    voir.setForeground(new java.awt.Color(3, 182, 215));
    voir.setColorHover(new java.awt.Color(52, 73, 94));
    voir.setColorNormal(new java.awt.Color(255, 255, 255));
    voir.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            voirMousePressed(evt);
        }
    });

    jLabel35.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel35.setForeground(new java.awt.Color(3, 182, 215));
    jLabel35.setText("Consulter les données médicales");

    javax.swing.GroupLayout voirLayout = new javax.swing.GroupLayout(voir);
    voir.setLayout(voirLayout);
    voirLayout.setHorizontalGroup(
        voirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(voirLayout.createSequentialGroup()
            .addGap(42, 42, 42)
            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(18, Short.MAX_VALUE))
    );
    voirLayout.setVerticalGroup(
        voirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, voirLayout.createSequentialGroup()
            .addGap(0, 3, Short.MAX_VALUE)
            .addComponent(jLabel35))
    );

    javax.swing.GroupLayout pn_MenupLayout = new javax.swing.GroupLayout(pn_Menup);
    pn_Menup.setLayout(pn_MenupLayout);
    pn_MenupLayout.setHorizontalGroup(
        pn_MenupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jSeparator11)
        .addComponent(voir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        .addComponent(btn_CR, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
    );
    pn_MenupLayout.setVerticalGroup(
        pn_MenupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_MenupLayout.createSequentialGroup()
            .addComponent(voir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btn_CR, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jPanel9.setBackground(new java.awt.Color(255, 255, 255));
    jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des praticiens\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 182, 215))); // NOI18N

    table_praticien.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Nom", "Prenom", "spécialité", "Email"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            true, true, true, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    table_praticien.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
    table_praticien.setColorBordeFilas(new java.awt.Color(52, 73, 94));
    table_praticien.setColorBordeHead(new java.awt.Color(52, 73, 94));
    table_praticien.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
    table_praticien.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
    table_praticien.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
    table_praticien.setColorSelBackgound(new java.awt.Color(3, 182, 215));
    table_praticien.setGrosorBordeFilas(0);
    table_praticien.setGrosorBordeHead(0);
    table_praticien.setRowHeight(20);
    table_praticien.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            table_praticienMouseClicked(evt);
        }
    });
    jScrollPane8.setViewportView(table_praticien);

    textsearch4.setForeground(new java.awt.Color(3, 182, 215));
    textsearch4.setBorderColor(new java.awt.Color(3, 182, 215));
    textsearch4.setBotonColor(new java.awt.Color(3, 182, 215));
    textsearch4.setPhColor(new java.awt.Color(3, 182, 215));
    textsearch4.setPlaceholder("nom / prenom/specialité");
    textsearch4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            textsearch4ActionPerformed(evt);
        }
    });
    textsearch4.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            textsearch4KeyReleased(evt);
        }
    });

    jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Find_User_Male_30px.png"))); // NOI18N

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(textsearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(58, 58, 58))
    );
    jPanel9Layout.setVerticalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textsearch4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout liste_praticiensLayout = new javax.swing.GroupLayout(liste_praticiens);
    liste_praticiens.setLayout(liste_praticiensLayout);
    liste_praticiensLayout.setHorizontalGroup(
        liste_praticiensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 399, Short.MAX_VALUE)
        .addGroup(liste_praticiensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(liste_praticiensLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
    liste_praticiensLayout.setVerticalGroup(
        liste_praticiensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 372, Short.MAX_VALUE)
        .addGroup(liste_praticiensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel8.setBackground(new java.awt.Color(255, 255, 255));
    jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mes patients", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 182, 215))); // NOI18N

    table_patient1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "N° dossier médical", "Nom", "Prenom"
        }
    ));
    table_patient1.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
    table_patient1.setColorBordeFilas(new java.awt.Color(52, 73, 94));
    table_patient1.setColorBordeHead(new java.awt.Color(52, 73, 94));
    table_patient1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
    table_patient1.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
    table_patient1.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
    table_patient1.setColorSelBackgound(new java.awt.Color(3, 182, 215));
    table_patient1.setFuenteFilas(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
    table_patient1.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
    table_patient1.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    table_patient1.setGrosorBordeFilas(0);
    table_patient1.setGrosorBordeHead(0);
    table_patient1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            table_patient1MouseClicked(evt);
        }
    });
    jScrollPane7.setViewportView(table_patient1);

    textsearch2.setForeground(new java.awt.Color(3, 182, 215));
    textsearch2.setBorderColor(new java.awt.Color(3, 182, 215));
    textsearch2.setBotonColor(new java.awt.Color(3, 182, 215));
    textsearch2.setPhColor(new java.awt.Color(3, 182, 215));
    textsearch2.setPlaceholder("N°dossier médical");
    textsearch2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            textsearch2ActionPerformed(evt);
        }
    });
    textsearch2.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            textsearch2KeyReleased(evt);
        }
    });

    jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Find_User_Male_30px.png"))); // NOI18N

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textsearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(47, 47, 47))
    );
    jPanel8Layout.setVerticalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(textsearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(22, 22, 22)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(66, 66, 66))
    );

    javax.swing.GroupLayout liste_patientsLayout = new javax.swing.GroupLayout(liste_patients);
    liste_patients.setLayout(liste_patientsLayout);
    liste_patientsLayout.setHorizontalGroup(
        liste_patientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 397, Short.MAX_VALUE)
        .addGroup(liste_patientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(liste_patientsLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
    liste_patientsLayout.setVerticalGroup(
        liste_patientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 367, Short.MAX_VALUE)
        .addGroup(liste_patientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
    );

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setLayout(null);

    panelp.setBackground(new java.awt.Color(52, 73, 94));
    panelp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    jSeparator1.setForeground(new java.awt.Color(3, 182, 215));

    jSeparator2.setForeground(new java.awt.Color(3, 182, 215));

    jSeparator3.setForeground(new java.awt.Color(3, 182, 215));

    btn_accueil.setBackground(new java.awt.Color(255, 255, 255));
    btn_accueil.setForeground(new java.awt.Color(52, 73, 94));
    btn_accueil.setText("Accueil");
    btn_accueil.setFocusPainted(false);
    btn_accueil.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
    btn_accueil.setSelected(true);
    btn_accueil.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_accueilMouseClicked(evt);
        }
    });
    btn_accueil.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_accueilActionPerformed(evt);
        }
    });

    btn_dossier.setBackground(new java.awt.Color(52, 73, 94));
    btn_dossier.setText("Consulter Dossier Médical");
    btn_dossier.setActionCommand("DEMANDE COMPTE RENDUS");
    btn_dossier.setBorderPainted(false);
    btn_dossier.setColorHover(new java.awt.Color(3, 182, 215));
    btn_dossier.setColorText(new java.awt.Color(3, 180, 215));
    btn_dossier.setColorTextHover(new java.awt.Color(52, 73, 94));
    btn_dossier.setFocusPainted(false);
    btn_dossier.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
    btn_dossier.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_dossierActionPerformed(evt);
        }
    });

    btn_profil.setBackground(new java.awt.Color(52, 73, 94));
    btn_profil.setForeground(new java.awt.Color(3, 182, 215));
    btn_profil.setText("PROFIL");
    btn_profil.setToolTipText("");
    btn_profil.setBorderPainted(false);
    btn_profil.setColorHover(new java.awt.Color(3, 182, 215));
    btn_profil.setColorText(new java.awt.Color(3, 182, 215));
    btn_profil.setColorTextHover(new java.awt.Color(52, 73, 94));
    btn_profil.setFocusPainted(false);
    btn_profil.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
    btn_profil.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_profilActionPerformed(evt);
        }
    });

    btn_msg.setBackground(new java.awt.Color(52, 73, 94));
    btn_msg.setForeground(new java.awt.Color(3, 182, 215));
    btn_msg.setText("Messagerie");
    btn_msg.setToolTipText("");
    btn_msg.setBorderPainted(false);
    btn_msg.setColorHover(new java.awt.Color(3, 182, 215));
    btn_msg.setColorText(new java.awt.Color(3, 182, 215));
    btn_msg.setColorTextHover(new java.awt.Color(52, 73, 94));
    btn_msg.setFocusPainted(false);
    btn_msg.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
    btn_msg.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_msgActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout panelpLayout = new javax.swing.GroupLayout(panelp);
    panelp.setLayout(panelpLayout);
    panelpLayout.setHorizontalGroup(
        panelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(btn_accueil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(panelpLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2)
                .addComponent(jSeparator1)
                .addComponent(jSeparator3)
                .addComponent(btn_profil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_dossier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelpLayout.createSequentialGroup()
                    .addComponent(btn_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
            .addContainerGap())
    );
    panelpLayout.setVerticalGroup(
        panelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelpLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btn_accueil, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btn_profil, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(22, 22, 22)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(45, 45, 45)
            .addComponent(btn_dossier, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(32, 32, 32)
            .addComponent(btn_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(475, 475, 475))
    );

    jPanel2.add(panelp);
    panelp.setBounds(10, 140, 390, 520);

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/j1.png"))); // NOI18N
    jPanel2.add(jLabel2);
    jLabel2.setBounds(0, 0, 160, 130);

    jPanel1.setBackground(new java.awt.Color(52, 73, 94));

    jLabel1.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(3, 182, 215));
    jLabel1.setText("Bienvenue :  ");

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Logout_Rounded_Down_40px.png"))); // NOI18N
    jLabel3.setToolTipText("Déconnexion");
    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel3MouseClicked(evt);
        }
    });

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Dr : ");

    nom_prat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    nom_prat.setForeground(new java.awt.Color(255, 255, 255));

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText("Médecin Local");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(123, 123, 123)
            .addComponent(jLabel8)
            .addGap(244, 244, 244)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(nom_prat, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 405, Short.MAX_VALUE)
            .addComponent(jLabel3)
            .addGap(22, 22, 22))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(23, 23, 23))
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(nom_prat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel2.add(jPanel1);
    jPanel1.setBounds(30, 30, 1330, 80);

    PanelSlider.setBackground(new java.awt.Color(255, 255, 255));

    accuiel.setBackground(new java.awt.Color(255, 255, 255));
    accuiel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94), 3));
    accuiel.setName("accuiel"); // NOI18N

    Heure.setFont(new java.awt.Font("DS-Digital", 1, 48)); // NOI18N
    Heure.setForeground(new java.awt.Color(3, 182, 215));

    jCalendar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(3, 182, 215), 3, true));
    jCalendar1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

    javax.swing.GroupLayout accuielLayout = new javax.swing.GroupLayout(accuiel);
    accuiel.setLayout(accuielLayout);
    accuielLayout.setHorizontalGroup(
        accuielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(accuielLayout.createSequentialGroup()
            .addGroup(accuielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(accuielLayout.createSequentialGroup()
                    .addGap(192, 192, 192)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(accuielLayout.createSequentialGroup()
                    .addGap(300, 300, 300)
                    .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(303, Short.MAX_VALUE))
    );
    accuielLayout.setVerticalGroup(
        accuielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(accuielLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(155, Short.MAX_VALUE))
    );

    PanelSlider.add(accuiel, "card8");

    profil_praticien.setName("profil_praticien"); // NOI18N
    profil_praticien.setLayout(null);

    jPanel4.setBackground(new java.awt.Color(255, 255, 255));
    jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));
    jPanel4.setLayout(null);
    jPanel4.setBackground(new Color(255,255,255,160));

    jLabel13.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(52, 73, 94));
    jLabel13.setText("Mon Profil");
    jPanel4.add(jLabel13);
    jLabel13.setBounds(20, 10, 118, 30);

    jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Edit_30px_1.png"))); // NOI18N
    jLabel14.setToolTipText("Modifier");
    jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel14MouseClicked(evt);
        }
    });
    jPanel4.add(jLabel14);
    jLabel14.setBounds(430, 0, 30, 50);

    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Refresh_30px.png"))); // NOI18N
    jLabel5.setToolTipText("Actualiser");
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel5MouseClicked(evt);
        }
    });
    jPanel4.add(jLabel5);
    jLabel5.setBounds(160, 3, 49, 40);

    profil_praticien.add(jPanel4);
    jPanel4.setBounds(30, 0, 470, 50);

    jPanel5.setBackground(new java.awt.Color(255, 255, 255));
    jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));

    jLabel15.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(52, 73, 94));
    jLabel15.setText("Nom :");

    jLabel16.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(52, 73, 94));
    jLabel16.setText("Prenom :");

    jLabel22.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel22.setForeground(new java.awt.Color(52, 73, 94));
    jLabel22.setText("Email :");

    jLabel23.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel23.setForeground(new java.awt.Color(52, 73, 94));
    jLabel23.setText("Télephone :");

    jLabel24.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel24.setForeground(new java.awt.Color(52, 73, 94));
    jLabel24.setText("Type:");

    jLabel25.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel25.setForeground(new java.awt.Color(52, 73, 94));
    jLabel25.setText("Identifiant :");

    jLabel26.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel26.setForeground(new java.awt.Color(52, 73, 94));
    jLabel26.setText("Mot De Passe :");

    pass2.setEditable(false);
    pass2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    pass2.setForeground(new java.awt.Color(52, 73, 94));
    pass2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
    pass2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            pass2ActionPerformed(evt);
        }
    });

    id.setEditable(false);
    id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    id.setForeground(new java.awt.Color(52, 73, 94));
    id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

    prenom.setEditable(false);
    prenom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    prenom.setForeground(new java.awt.Color(52, 73, 94));
    prenom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
    prenom.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            prenomActionPerformed(evt);
        }
    });

    nom.setEditable(false);
    nom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    nom.setForeground(new java.awt.Color(52, 73, 94));
    nom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
    nom.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            nomActionPerformed(evt);
        }
    });

    type.setEditable(false);
    type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    type.setForeground(new java.awt.Color(52, 73, 94));
    type.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
    type.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            typeActionPerformed(evt);
        }
    });

    mail.setEditable(false);
    mail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    mail.setForeground(new java.awt.Color(52, 73, 94));
    mail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

    tel.setEditable(false);
    tel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    tel.setForeground(new java.awt.Color(52, 73, 94));
    tel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

    spec.setEditable(false);
    spec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    spec.setForeground(new java.awt.Color(52, 73, 94));
    spec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

    jLabel28.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel28.setForeground(new java.awt.Color(52, 73, 94));
    jLabel28.setText("Spécialité:");

    btn_ok.setBackground(new java.awt.Color(3, 182, 215));
    btn_ok.setForeground(new java.awt.Color(52, 73, 94));
    btn_ok.setText("OK");
    btn_ok.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_okActionPerformed(evt);
        }
    });

    jLabel32.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel32.setForeground(new java.awt.Color(52, 73, 94));
    jLabel32.setText("Address:");

    address.setEditable(false);
    address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    address.setForeground(new java.awt.Color(52, 73, 94));
    address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addGap(50, 50, 50)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addGap(129, 129, 129)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(84, 84, 84))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(51, 51, 51)))
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pass2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
            .addContainerGap(51, Short.MAX_VALUE))
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel16)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(type))
            .addGap(13, 13, 13)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel28)
                .addComponent(spec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLabel32)
                    .addGap(3, 3, 3))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel22)
                .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLabel23)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel25))
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel26)
                .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jPanel5.setBackground(new Color(255,255,255,160));

    profil_praticien.add(jPanel5);
    jPanel5.setBounds(30, 60, 470, 450);

    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/bgdoc.jpg"))); // NOI18N
    profil_praticien.add(jLabel6);
    jLabel6.setBounds(0, 1, 1150, 540);

    PanelSlider.add(profil_praticien, "card2");

    C_dossier_med.setName("C_dossier_med"); // NOI18N
    C_dossier_med.setLayout(null);

    MES_PATIENTS.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    MES_PATIENTS.setColorBackgoundHead(new java.awt.Color(52, 73, 94));
    MES_PATIENTS.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
    MES_PATIENTS.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
    MES_PATIENTS.setColorSelBackgound(new java.awt.Color(3, 182, 215));
    MES_PATIENTS.setGrosorBordeFilas(0);
    MES_PATIENTS.setGrosorBordeHead(0);
    MES_PATIENTS.setSelectionBackground(new java.awt.Color(3, 182, 215));
    MES_PATIENTS.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            MES_PATIENTSMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(MES_PATIENTS);

    jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Search_Property_40px_1.png"))); // NOI18N

    textsearch3.setForeground(new java.awt.Color(52, 73, 94));
    textsearch3.setBorderColor(new java.awt.Color(52, 73, 94));
    textsearch3.setBotonColor(new java.awt.Color(52, 73, 94));
    textsearch3.setPhColor(new java.awt.Color(52, 73, 94));
    textsearch3.setPlaceholder("N°dossier  ");
    textsearch3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            textsearch3ActionPerformed(evt);
        }
    });
    textsearch3.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            textsearch3KeyReleased(evt);
        }
    });

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jLabel29)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(textsearch3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(42, Short.MAX_VALUE))
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(textsearch3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(70, Short.MAX_VALUE))
    );

    jPanel7.setBackground(new Color(255,255,255,160));

    C_dossier_med.add(jPanel7);
    jPanel7.setBounds(30, 70, 870, 440);

    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/bgdoc.jpg"))); // NOI18N
    C_dossier_med.add(jLabel7);
    jLabel7.setBounds(0, 0, 1120, 620);

    PanelSlider.add(C_dossier_med, "card5");

    messagerie.setBackground(new java.awt.Color(255, 255, 255));
    messagerie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));
    messagerie.setForeground(new java.awt.Color(3, 182, 215));
    messagerie.setName("messagerie"); // NOI18N

    jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

    jLabel44.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel44.setForeground(new java.awt.Color(3, 182, 215));
    jLabel44.setText("Mot De Passe:");

    msg.setColumns(20);
    msg.setRows(5);
    msg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));
    jScrollPane9.setViewportView(msg);

    from.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    from.setForeground(new java.awt.Color(3, 182, 215));
    from.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));

    jLabel45.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel45.setForeground(new java.awt.Color(3, 182, 215));
    jLabel45.setText("Email Destinataire:");

    jLabel47.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel47.setForeground(new java.awt.Color(3, 182, 215));
    jLabel47.setText("Message:");

    jLabel43.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel43.setForeground(new java.awt.Color(3, 182, 215));
    jLabel43.setText("Email:");

    jLabel46.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    jLabel46.setForeground(new java.awt.Color(3, 182, 215));
    jLabel46.setText("Objet:");

    path_attach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));
    path_attach.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            path_attachActionPerformed(evt);
        }
    });

    jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Add_File_30px_1.png"))); // NOI18N
    jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel41MouseClicked(evt);
        }
    });

    subject.setForeground(new java.awt.Color(3, 182, 215));
    subject.setBorderColor(new java.awt.Color(3, 182, 215));
    subject.setBotonColor(new java.awt.Color(3, 182, 215));
    subject.setPhColor(new java.awt.Color(3, 182, 215));
    subject.setPlaceholder("");

    name.setForeground(new java.awt.Color(3, 182, 215));
    name.setBorderColor(new java.awt.Color(3, 182, 215));
    name.setBotonColor(new java.awt.Color(3, 182, 215));
    name.setPhColor(new java.awt.Color(3, 182, 215));
    name.setPlaceholder("nom.extention");

    to.setForeground(new java.awt.Color(3, 182, 215));
    to.setBorderColor(new java.awt.Color(3, 182, 215));
    to.setBotonColor(new java.awt.Color(3, 182, 215));
    to.setPhColor(new java.awt.Color(3, 182, 215));
    to.setPlaceholder("");

    pass.setForeground(new java.awt.Color(3, 182, 215));
    pass.setBorderColor(new java.awt.Color(3, 182, 215));
    pass.setBotonColor(new java.awt.Color(3, 182, 215));
    pass.setPhColor(new java.awt.Color(3, 182, 215));
    pass.setPlaceholder("mot de passe de mail");

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(jLabel47)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel43)
                            .addGap(99, 99, 99)
                            .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel41)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(path_attach, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel44)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel46)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel45)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())))
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel43))
                .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel44)
                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(15, 15, 15)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel45)
                .addComponent(to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel46)
                .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE))
            .addGap(6, 6, 6)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel47))
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(path_attach))
            .addContainerGap())
    );

    btn_envoyer.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    btn_envoyer.setForeground(new java.awt.Color(3, 182, 215));
    btn_envoyer.setText("Enoyer");
    btn_envoyer.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_envoyerActionPerformed(evt);
        }
    });

    btn_annuler.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
    btn_annuler.setForeground(new java.awt.Color(3, 182, 215));
    btn_annuler.setText("Annuler");
    btn_annuler.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_annulerActionPerformed(evt);
        }
    });

    rSButtonHover5.setBackground(new java.awt.Color(3, 182, 215));
    rSButtonHover5.setText("Liste des emails patients");
    rSButtonHover5.setActionCommand("Liste des email patients");
    rSButtonHover5.setColorHover(new java.awt.Color(3, 182, 215));
    rSButtonHover5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rSButtonHover5ActionPerformed(evt);
        }
    });

    rSButtonHover6.setBackground(new java.awt.Color(3, 182, 215));
    rSButtonHover6.setText("Liste des emails praticiens");
    rSButtonHover6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rSButtonHover6ActionPerformed(evt);
        }
    });

    scrol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));

    javax.swing.GroupLayout messagerieLayout = new javax.swing.GroupLayout(messagerie);
    messagerie.setLayout(messagerieLayout);
    messagerieLayout.setHorizontalGroup(
        messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(messagerieLayout.createSequentialGroup()
            .addGroup(messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(messagerieLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(messagerieLayout.createSequentialGroup()
                            .addComponent(rSButtonHover5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(rSButtonHover6, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                        .addGroup(messagerieLayout.createSequentialGroup()
                            .addComponent(scrol, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addGroup(messagerieLayout.createSequentialGroup()
                    .addGap(157, 157, 157)
                    .addComponent(btn_annuler)
                    .addGap(58, 58, 58)
                    .addComponent(btn_envoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    messagerieLayout.setVerticalGroup(
        messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(messagerieLayout.createSequentialGroup()
            .addGroup(messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(messagerieLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSButtonHover6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSButtonHover5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrol, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(messagerieLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btn_annuler)
                .addComponent(btn_envoyer))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    PanelSlider.add(messagerie, "card6");

    jPanel2.add(PanelSlider);
    PanelSlider.setBounds(410, 140, 950, 520);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1620, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.hide();
    new praticien_login().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_msgActionPerformed
        if (!this.btn_msg.isSelected()) {
           
            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(true);
            this.btn_dossier.setSelected(false);
            this.btn_accueil.setSelected(false);
           
            this.PanelSlider.slidPanel(3,messagerie, RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_msgActionPerformed

    private void btn_profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profilActionPerformed
        if (!this.btn_profil.isSelected()) {
        
            this.btn_profil.setSelected(true);
            this.btn_msg.setSelected(false);
            this.btn_dossier.setSelected(false);
            this.btn_accueil.setSelected(false);
          
            this.PanelSlider.slidPanel(4, profil_praticien, RSPanelsSlider.direct.Right);

        }
    }//GEN-LAST:event_btn_profilActionPerformed

    private void btn_dossierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dossierActionPerformed
        if (!this.btn_dossier.isSelected()) {
        
            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(false);
            this.btn_dossier.setSelected(true);
            this.btn_accueil.setSelected(false);
          

            this.PanelSlider.slidPanel(3,C_dossier_med, RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_dossierActionPerformed

    private void btn_accueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accueilActionPerformed
        if (!this.btn_accueil.isSelected()) {
            
            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(false);
            this.btn_dossier.setSelected(false);
            this.btn_accueil.setSelected(true);
          

            this.PanelSlider.slidPanel(3,accuiel , RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_accueilActionPerformed

    private void btn_accueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accueilMouseClicked

    }//GEN-LAST:event_btn_accueilMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        mail.setEditable(true);
        tel.setEditable(true);
        pass2.setEditable(true);
        btn_ok.setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Afficher();
        btn_ok.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void pass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass2ActionPerformed

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        update_praticien();
    }//GEN-LAST:event_btn_okActionPerformed

    private void MES_PATIENTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MES_PATIENTSMouseClicked
        int row = MES_PATIENTS.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.MES_PATIENTS.setRowSelectionInterval(row, row);
            position = evt.getY() / 16;
            MenuP.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.MES_PATIENTS.setRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_MES_PATIENTSMouseClicked

    private void textsearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textsearch3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textsearch3ActionPerformed

    private void textsearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearch3KeyReleased
        recherche_patient2(this.textsearch3.getText());
    }//GEN-LAST:event_textsearch3KeyReleased

    private void btn_CRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CRMousePressed
        CR_examination  CR= new  CR_examination();
        CR.setVisible(true);
        Remplir_CR(CR);
    }//GEN-LAST:event_btn_CRMousePressed

    private void voirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voirMousePressed
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
            this.MenuP.setVisible(false);
            dossier_med ds= new dossier_med() ;
            ds.setVisible(true);
            afficher_infos_patient(ds);
        }
    }//GEN-LAST:event_voirMousePressed

    private void path_attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_path_attachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_path_attachActionPerformed

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f =chooser.getSelectedFile();
        atachement_path=f.getAbsolutePath();
        path_attach.setText(atachement_path);
    }//GEN-LAST:event_jLabel41MouseClicked

    private void btn_envoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_envoyerActionPerformed
        String  msg_content=msg.getText();

        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session;
        session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from.getText(),pass.getText());

                }
            }

        );
        try{
            Message message= new MimeMessage(session);
            message.setFrom(new InternetAddress(from.getText()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to.getText()));
            message.setSubject(subject.getText());
            //message.setText(msg.getText());

            MimeBodyPart  msgbodypart= new MimeBodyPart ();
            msgbodypart.setText(msg_content);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(msgbodypart);
            msgbodypart=new MimeBodyPart();
            DataSource source = new FileDataSource(atachement_path);
            msgbodypart.setDataHandler(new DataHandler(source));
            msgbodypart.setFileName(name.getText());
            multipart.addBodyPart(msgbodypart);
            message.setContent(multipart);
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "votre mail est bien envoyé");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_btn_envoyerActionPerformed

    private void btn_annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_annulerActionPerformed
        from.setText("");
        to.setText("");
        pass.setText("");
        subject.setText("");
        msg.setText("");
    }//GEN-LAST:event_btn_annulerActionPerformed

    private void rSButtonHover5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover5ActionPerformed
        scrol.setViewportView(liste_patients);
    }//GEN-LAST:event_rSButtonHover5ActionPerformed

    private void rSButtonHover6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover6ActionPerformed
        scrol.setViewportView(liste_praticiens);
    }//GEN-LAST:event_rSButtonHover6ActionPerformed

    private void table_praticienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_praticienMouseClicked
        Affichage_email();
    }//GEN-LAST:event_table_praticienMouseClicked

    private void textsearch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textsearch4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textsearch4ActionPerformed

    private void textsearch4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearch4KeyReleased
        recherche_praticien(this.textsearch4.getText());
    }//GEN-LAST:event_textsearch4KeyReleased

    private void table_patient1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_patient1MouseClicked
        Affichage_emailpatient();
    }//GEN-LAST:event_table_patient1MouseClicked

    private void textsearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textsearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textsearch2ActionPerformed

    private void textsearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearch2KeyReleased
        recherche_patient3( this.textsearch2.getText()) ;
    }//GEN-LAST:event_textsearch2KeyReleased

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
            java.util.logging.Logger.getLogger(medecin_Ref_local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(medecin_Ref_local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(medecin_Ref_local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(medecin_Ref_local.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new medecin_Ref_local().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel C_dossier_med;
    private javax.swing.JLabel Heure;
    private rojerusan.RSTableMetro MES_PATIENTS;
    private rojerusan.RSPopuMenu MenuP;
    private rojerusan.RSPanelsSlider PanelSlider;
    private javax.swing.JPanel accuiel;
    public static javax.swing.JTextField address;
    private rojerusan.RSButtonPane btn_CR;
    private rojerusan.RSButtonMetro btn_accueil;
    private javax.swing.JButton btn_annuler;
    private rojerusan.RSButtonHover btn_dossier;
    private javax.swing.JButton btn_envoyer;
    private rojerusan.RSButtonHover btn_msg;
    private rojerusan.RSButtonHover btn_ok;
    private rojerusan.RSButtonHover btn_profil;
    private javax.swing.JTextField from;
    public static javax.swing.JTextField id;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel liste_patients;
    private javax.swing.JPanel liste_praticiens;
    public static javax.swing.JTextField mail;
    private javax.swing.JPanel messagerie;
    private javax.swing.JTextArea msg;
    private rojerusan.RSMetroTextFullPlaceHolder name;
    public static javax.swing.JTextField nom;
    private javax.swing.JLabel nom_prat;
    private javax.swing.JPanel panelp;
    private rojerusan.RSMetroTextPassPlaceHolderView pass;
    public static javax.swing.JTextField pass2;
    private javax.swing.JTextField path_attach;
    private javax.swing.JPanel pn_Menup;
    public static javax.swing.JTextField prenom;
    private javax.swing.JPanel profil_praticien;
    private rojerusan.RSButtonHover rSButtonHover5;
    private rojerusan.RSButtonHover rSButtonHover6;
    private javax.swing.JScrollPane scrol;
    public static javax.swing.JTextField spec;
    private rojerusan.RSMetroTextFullPlaceHolder subject;
    private rojerusan.RSTableMetro table_patient1;
    private rojerusan.RSTableMetro table_praticien;
    public static javax.swing.JTextField tel;
    private rojerusan.RSMetroTextFullPlaceHolder textsearch2;
    private rojerusan.RSMetroTextFullPlaceHolder textsearch3;
    private rojerusan.RSMetroTextFullPlaceHolder textsearch4;
    private rojerusan.RSMetroTextFullPlaceHolder to;
    public static javax.swing.JTextField type;
    private rojerusan.RSButtonPane voir;
    // End of variables declaration//GEN-END:variables
 public void Affichertable_praticien() {
        try {
           
          String rqt = "select    praticien_nom as 'Nom', praticien_prenom as 'Prenom ', praticien_specialite as 'Spécialité', praticien_email as 'Email' from praticien";
       
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
          table_praticien.setModel(DbUtils.resultSetToTableModel(rs));
      
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
     
      //Rechercher Praticien 
        public void recherche_praticien( String rech)
     {
         try {
String rqt= "select  praticien_nom as 'Nom', praticien_prenom as 'Prenom', praticien_specialite as 'Spécialité' , praticien_email as 'Email' from  praticien where ( praticien_prenom LIKE'" + rech + "%' OR  praticien_nom LIKE'" + rech+ "%' OR "
                    + "	 praticien_specialite LIKE'" + rech + "%' )";
            ps = cnx.prepareStatement(rqt);
            //ps.setString(1, "%"+textsearch.getText()+"%");
            rs = ps.executeQuery();
          table_praticien.setModel(DbUtils.resultSetToTableModel(rs));
             ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
     }
        
     
     
        
      public void Affichage_email() {
        

            int R =  table_praticien.getSelectedRow();
            String M = (table_praticien.getModel().getValueAt(R, 3).toString());
            to.setText(M);
               
    }  
     
     
      
     
     //Afficher table patient
        public void Affichertable_patients3() {
    
        try {
           
          String rqt = "select  N_doss_med as 'N° dossier médical', patient_nom  as 'Nom',  patient_prenom as 'Prenom' ,patient_email as 'email' from patient  ";
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_patient1.setModel(DbUtils.resultSetToTableModel(rs));
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
        //recherche :
            public void recherche_patient3( String rech)
     {
         try {
String rqt= "select  N_doss_med as 'N° dossier médical', patient_nom  as 'Nom',  patient_prenom as 'Prenom' ,patient_email as 'email' from patient where  (N_doss_med LIKE'" + rech + "' )";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
    
           table_patient1.setModel(DbUtils.resultSetToTableModel(rs));
             ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
     }
        
             public void Affichage_emailpatient() {
        

            int R =  table_patient1.getSelectedRow();
            String M = (table_patient1.getModel().getValueAt(R, 3).toString());
            to.setText(M);
               
    }  
      
      
      
      

  
      
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espace_praticien;

import Dossier_Médical.CR_radiologue;
import Dossier_Médical.imageradio;
import Listes.praticien;
import Login.DB_Connexion;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.*;

import Login.praticien_login;
import interfaces.inter_praticien;
import java.awt.Color;
import java.io.File;
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
import rojerusan.RSPanelsSlider;
import static public_var.variables.*;
/**
 *
 * @author berich
 */
public class radiologue extends javax.swing.JFrame {

    String atachement_path;
    String ds;
    public radiologue() {
        initComponents();
          cnx= DB_Connexion.Connexion();
         fonctions.HeureSystem(Heure);
         Afficher();
         btn_ok.setVisible(false);
         Affichertable_praticien();
    }

         imageradio I =new imageradio();
          praticien_login ph =new praticien_login();
         String idft=  ph.recuperer();
   
     
       //methods     
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
                from.setText(s6);
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
      
      
      
      
           
         //Remplir qlq champs :
 
     public void Remplir_CR( CR_radiologue C){
       praticien_login ph =new praticien_login();
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
      
      
     }
      
     
      public void Affichertable_CRS_RADIO() {
        try {
           
          
          
            
            
            String rqt = "select ider as 'id',date as 'Date'from examenradiologique  where `idpra` = '"+idft+"' "; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_radio.setModel(DbUtils.resultSetToTableModel(rs));
          
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
     
     
     
     public void afficher_detail_CR_RADIO() {
        
        try {
           
            int R =  table_radio.getSelectedRow();
            N = (table_radio.getModel().getValueAt(R, 0).toString());
           
            String rqt = "select * from examenradiologique WHERE `ider` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("date");
                date_saisie6.setText(s1);
                String s2 = rs.getString("contexte");
                context6.setText(s2);
                String s3 = rs.getString("Num_doss_medical");
                doss6.setText(s3);
                this.ds=s3;
                String s4 = rs.getString("idpra");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s4);
                nom_prenom8.setText(pn2.toString());
                String s5=rs.getString("type_radio");
                type.setText(s5);
                
                String s6=rs.getString("image");
                
                 I.picture.setIcon(new ImageIcon(s6));
                
              
            }
                ps.close();
                rs.close();
               
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ds+"'";
                 ps = cnx.prepareStatement(rqt2);
                rs = ps.executeQuery();
                if(rs.next()){
                String s5=rs.getString("patient_nom");
                nomp8.setText(s5);
                 String s6=rs.getString("patient_prenom");
                prenomp8.setText(s6);
                 String s8=rs.getString("patient_age");
                AgeP8.setText(s8);
                
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
     
     
     
     
     
     
     
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
    jLabel7 = new javax.swing.JLabel();
    PanelSlider = new rojerusan.RSPanelsSlider();
    accuiel = new javax.swing.JPanel();
    Heure = new javax.swing.JLabel();
    jCalendar1 = new com.toedter.calendar.JCalendar();
    compte_rendu = new javax.swing.JPanel();
    panel = new javax.swing.JPanel();
    jScrollPane10 = new javax.swing.JScrollPane();
    jPanel10 = new javax.swing.JPanel();
    jScrollPane11 = new javax.swing.JScrollPane();
    table_radio = new rojerusan.RSTableMetro();
    jDateChooser5 = new com.toedter.calendar.JDateChooser();
    rSButtonHover1 = new rojerusan.RSButtonHover();
    jLabel8 = new javax.swing.JLabel();
    jPanel34 = new javax.swing.JPanel();
    jSeparator74 = new javax.swing.JSeparator();
    jLabel84 = new javax.swing.JLabel();
    nom_prenom8 = new javax.swing.JLabel();
    address9 = new javax.swing.JLabel();
    jPanel35 = new javax.swing.JPanel();
    jLabel85 = new javax.swing.JLabel();
    nomp8 = new javax.swing.JLabel();
    jSeparator75 = new javax.swing.JSeparator();
    jLabel86 = new javax.swing.JLabel();
    jSeparator76 = new javax.swing.JSeparator();
    prenomp8 = new javax.swing.JLabel();
    jLabel87 = new javax.swing.JLabel();
    jSeparator77 = new javax.swing.JSeparator();
    AgeP8 = new javax.swing.JLabel();
    jPanel36 = new javax.swing.JPanel();
    jLabel88 = new javax.swing.JLabel();
    jSeparator78 = new javax.swing.JSeparator();
    jLabel89 = new javax.swing.JLabel();
    date_saisie6 = new javax.swing.JLabel();
    jSeparator79 = new javax.swing.JSeparator();
    doss6 = new javax.swing.JLabel();
    jLabel90 = new javax.swing.JLabel();
    jScrollPane30 = new javax.swing.JScrollPane();
    context6 = new javax.swing.JTextArea();
    id6 = new javax.swing.JLabel();
    spece6 = new javax.swing.JLabel();
    jLabel91 = new javax.swing.JLabel();
    jSeparator80 = new javax.swing.JSeparator();
    type1 = new javax.swing.JLabel();
    jLabel36 = new javax.swing.JLabel();
    profil_praticien = new javax.swing.JPanel();
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
    jPanel4 = new javax.swing.JPanel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
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
    btn_dossier.setText("Insérer Un Compte Rendu");
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
            .addGap(27, 27, 27)
            .addComponent(btn_profil, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33)
            .addComponent(btn_dossier, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(34, 34, 34)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(41, 41, 41)
            .addComponent(btn_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(427, 427, 427))
    );

    jPanel2.add(panelp);
    panelp.setBounds(10, 150, 390, 540);

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/radio2.png"))); // NOI18N
    jPanel2.add(jLabel2);
    jLabel2.setBounds(0, 0, 130, 140);

    jPanel1.setBackground(new java.awt.Color(52, 73, 94));

    jLabel1.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(3, 182, 215));
    jLabel1.setText("Bienvenue : ");

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Logout_Rounded_Down_40px.png"))); // NOI18N
    jLabel3.setToolTipText("Déconnexion");
    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel3MouseClicked(evt);
        }
    });

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Mr / Mme:");

    nom_prat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    nom_prat.setForeground(new java.awt.Color(255, 255, 255));

    jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setText("Radiologue");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(113, 113, 113)
            .addComponent(jLabel7)
            .addGap(253, 253, 253)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(nom_prat, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
            .addComponent(jLabel3)
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nom_prat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))))
            .addContainerGap(24, Short.MAX_VALUE))
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
                    .addGap(214, 214, 214)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(accuielLayout.createSequentialGroup()
                    .addGap(319, 319, 319)
                    .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(271, Short.MAX_VALUE))
    );
    accuielLayout.setVerticalGroup(
        accuielLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(accuielLayout.createSequentialGroup()
            .addGap(99, 99, 99)
            .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(89, Short.MAX_VALUE))
    );

    PanelSlider.add(accuiel, "card8");

    compte_rendu.setName("compte_rendu"); // NOI18N

    panel.setBackground(new java.awt.Color(255, 255, 255));
    panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94), 2));
    panel.setName("panel"); // NOI18N

    jScrollPane10.setBorder(null);

    jPanel10.setBackground(new java.awt.Color(255, 255, 255));
    jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 1078, Short.MAX_VALUE)
    );
    jPanel10Layout.setVerticalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 733, Short.MAX_VALUE)
    );

    jScrollPane10.setViewportView(jPanel10);

    table_radio.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null},
            {null},
            {null},
            {null}
        },
        new String [] {
            "Title 1"
        }
    ));
    table_radio.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
    table_radio.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
    table_radio.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
    table_radio.setColorSelBackgound(new java.awt.Color(3, 182, 215));
    jScrollPane11.setViewportView(table_radio);

    rSButtonHover1.setBackground(new java.awt.Color(52, 73, 94));
    rSButtonHover1.setText("Inserer compte rendu");
    rSButtonHover1.setFocusPainted(false);
    rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rSButtonHover1ActionPerformed(evt);
        }
    });

    jLabel8.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(52, 73, 94));
    jLabel8.setText("Historique :");

    jPanel34.setBackground(new java.awt.Color(255, 255, 255));

    jLabel84.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
    jLabel84.setForeground(new java.awt.Color(52, 73, 94));
    jLabel84.setText("DR.");

    nom_prenom8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    nom_prenom8.setForeground(new java.awt.Color(52, 73, 94));

    address9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    address9.setForeground(new java.awt.Color(52, 73, 94));

    jPanel35.setBackground(new java.awt.Color(255, 255, 255));
    jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));

    jLabel85.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel85.setForeground(new java.awt.Color(52, 73, 94));
    jLabel85.setText("NOM:");

    nomp8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    nomp8.setForeground(new java.awt.Color(52, 73, 94));

    jLabel86.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel86.setForeground(new java.awt.Color(52, 73, 94));
    jLabel86.setText("Prenom:");

    prenomp8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    prenomp8.setForeground(new java.awt.Color(52, 73, 94));

    jLabel87.setBackground(new java.awt.Color(255, 255, 255));
    jLabel87.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel87.setForeground(new java.awt.Color(52, 73, 94));
    jLabel87.setText("Age :");

    AgeP8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    AgeP8.setForeground(new java.awt.Color(52, 73, 94));

    javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
    jPanel35.setLayout(jPanel35Layout);
    jPanel35Layout.setHorizontalGroup(
        jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel35Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addComponent(jLabel87)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(AgeP8, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator77, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel85)
                        .addComponent(jSeparator75, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel86)
                        .addComponent(jSeparator76, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(prenomp8, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomp8, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(170, Short.MAX_VALUE))
    );
    jPanel35Layout.setVerticalGroup(
        jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel35Layout.createSequentialGroup()
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel85))
                .addComponent(nomp8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26)
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(prenomp8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addComponent(jLabel87)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addComponent(AgeP8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGap(9, 9, 9))
    );

    jPanel36.setBackground(new java.awt.Color(255, 255, 255));
    jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
    jPanel36.setForeground(new java.awt.Color(52, 73, 94));

    jLabel88.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel88.setForeground(new java.awt.Color(52, 73, 94));
    jLabel88.setText("Dossier : ");

    jLabel89.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel89.setForeground(new java.awt.Color(52, 73, 94));
    jLabel89.setText("Le :");

    date_saisie6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    date_saisie6.setForeground(new java.awt.Color(52, 73, 94));

    doss6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    doss6.setForeground(new java.awt.Color(52, 73, 94));

    javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
    jPanel36.setLayout(jPanel36Layout);
    jPanel36Layout.setHorizontalGroup(
        jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel36Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator79, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel36Layout.createSequentialGroup()
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator78))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(doss6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel36Layout.createSequentialGroup()
                    .addComponent(jLabel89)
                    .addGap(18, 18, 18)
                    .addComponent(date_saisie6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(142, Short.MAX_VALUE))
    );
    jPanel36Layout.setVerticalGroup(
        jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel36Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(doss6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel88))
            .addGap(2, 2, 2)
            .addComponent(jSeparator78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(44, 44, 44)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(date_saisie6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jLabel90.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel90.setForeground(new java.awt.Color(52, 73, 94));
    jLabel90.setText("Diagnostic :");

    context6.setEditable(false);
    context6.setColumns(20);
    context6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    context6.setForeground(new java.awt.Color(52, 73, 94));
    context6.setRows(5);
    context6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
    jScrollPane30.setViewportView(context6);

    jLabel91.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
    jLabel91.setForeground(new java.awt.Color(52, 73, 94));

    type1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

    jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Pictures_Folder_50px.png"))); // NOI18N
    jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel36MouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
    jPanel34.setLayout(jPanel34Layout);
    jPanel34Layout.setHorizontalGroup(
        jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jSeparator74, javax.swing.GroupLayout.Alignment.TRAILING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jSeparator80, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(235, 235, 235))
        .addGroup(jPanel34Layout.createSequentialGroup()
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(id6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(58, 58, 58)
                    .addComponent(spece6))
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGap(346, 346, 346)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                            .addComponent(jLabel84)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nom_prenom8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel91)))
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGap(305, 305, 305)
                    .addComponent(address9, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(jPanel34Layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                            .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(307, 307, 307))
                        .addGroup(jPanel34Layout.createSequentialGroup()
                            .addComponent(jLabel90)
                            .addGap(821, 821, 821)))
                    .addComponent(jLabel36))
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 90, Short.MAX_VALUE))
    );
    jPanel34Layout.setVerticalGroup(
        jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel34Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel91)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
            .addComponent(jSeparator80, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel84)
                .addComponent(nom_prenom8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
            .addComponent(address9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addComponent(jSeparator74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(62, 62, 62)
                    .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel90))
                .addComponent(jLabel36))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(id6)
                .addComponent(spece6)))
    );

    javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
    panel.setLayout(panelLayout);
    panelLayout.setHorizontalGroup(
        panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelLayout.createSequentialGroup()
            .addGap(34, 34, 34)
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(panelLayout.createSequentialGroup()
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelLayout.createSequentialGroup()
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    panelLayout.setVerticalGroup(
        panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLayout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                            .addGap(18, 18, Short.MAX_VALUE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(panelLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))))
    );

    javax.swing.GroupLayout compte_renduLayout = new javax.swing.GroupLayout(compte_rendu);
    compte_rendu.setLayout(compte_renduLayout);
    compte_renduLayout.setHorizontalGroup(
        compte_renduLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, compte_renduLayout.createSequentialGroup()
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(0, 0, 0))
    );
    compte_renduLayout.setVerticalGroup(
        compte_renduLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    PanelSlider.add(compte_rendu, "card5");

    profil_praticien.setName("profil_praticien"); // NOI18N
    profil_praticien.setLayout(null);

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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
            .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jPanel5.setBackground(new Color(255,255,255,160));

    profil_praticien.add(jPanel5);
    jPanel5.setBounds(30, 60, 470, 470);

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

    jLabel6.setBackground(new java.awt.Color(255, 255, 255));
    jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/salaire-radiologue_1.jpg"))); // NOI18N
    profil_praticien.add(jLabel6);
    jLabel6.setBounds(0, -140, 1290, 810);

    PanelSlider.add(profil_praticien, "card2");

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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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
                            .addComponent(rSButtonHover6, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addGroup(messagerieLayout.createSequentialGroup()
                            .addComponent(scrol, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addGroup(messagerieLayout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addComponent(btn_annuler)
                    .addGap(80, 80, 80)
                    .addComponent(btn_envoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    messagerieLayout.setVerticalGroup(
        messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(messagerieLayout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(messagerieLayout.createSequentialGroup()
                    .addGroup(messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSButtonHover6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSButtonHover5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrol))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(messagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btn_envoyer)
                .addComponent(btn_annuler))
            .addContainerGap(15, Short.MAX_VALUE))
    );

    PanelSlider.add(messagerie, "card6");

    jPanel2.add(PanelSlider);
    PanelSlider.setBounds(420, 140, 940, 550);

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
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_accueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accueilMouseClicked

    }//GEN-LAST:event_btn_accueilMouseClicked

    private void btn_accueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accueilActionPerformed
        if (!this.btn_accueil.isSelected()) {

            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(false);
            this.btn_dossier.setSelected(false);
            this.btn_accueil.setSelected(true);

            this.PanelSlider.slidPanel(3,accuiel , RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_accueilActionPerformed

    private void btn_dossierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dossierActionPerformed
        if (!this.btn_dossier.isSelected()) {

            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(false);
            this.btn_dossier.setSelected(true);
            this.btn_accueil.setSelected(false);

            this.PanelSlider.slidPanel(3,compte_rendu, RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_dossierActionPerformed

    private void btn_profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profilActionPerformed
        if (!this.btn_profil.isSelected()) {

            this.btn_profil.setSelected(true);
            this.btn_msg.setSelected(false);
            this.btn_dossier.setSelected(false);
            this.btn_accueil.setSelected(false);

            this.PanelSlider.slidPanel(4,profil_praticien, RSPanelsSlider.direct.Right);

        }
    }//GEN-LAST:event_btn_profilActionPerformed

    private void btn_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_msgActionPerformed
        if (!this.btn_msg.isSelected()) {

            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(true);
            this.btn_dossier.setSelected(false);
            this.btn_accueil.setSelected(false);

            this.PanelSlider.slidPanel(3,messagerie, RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_msgActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.hide();
        new praticien_login().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

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

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed

        CR_radiologue CR= new CR_radiologue();
        CR.setVisible(true);
        Remplir_CR(CR);
        String input = JOptionPane.showInputDialog(null, "N° dossier médical");
        try {

            String rqt = " select * from patient where N_doss_med= '" +input+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                CR.doss.setText(input);
                String s2 = rs.getString("patient_nom");
                CR.nomp.setText(s2);
                String s3 = rs.getString("patient_prenom");
                CR.prenomp.setText(s3);
                String s5 = rs.getString("patient_age");
                CR.AgeP.setText(s5);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);}
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked

        I.setVisible(true);
    }//GEN-LAST:event_jLabel36MouseClicked

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
            java.util.logging.Logger.getLogger(radiologue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(radiologue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(radiologue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(radiologue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new radiologue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel AgeP8;
    private javax.swing.JLabel Heure;
    private rojerusan.RSPanelsSlider PanelSlider;
    private javax.swing.JPanel accuiel;
    public static javax.swing.JTextField address;
    public javax.swing.JLabel address9;
    private rojerusan.RSButtonMetro btn_accueil;
    private javax.swing.JButton btn_annuler;
    private rojerusan.RSButtonHover btn_dossier;
    private javax.swing.JButton btn_envoyer;
    private rojerusan.RSButtonHover btn_msg;
    private rojerusan.RSButtonHover btn_ok;
    private rojerusan.RSButtonHover btn_profil;
    private javax.swing.JPanel compte_rendu;
    public javax.swing.JTextArea context6;
    public javax.swing.JLabel date_saisie6;
    public javax.swing.JLabel doss6;
    private javax.swing.JTextField from;
    public static javax.swing.JTextField id;
    public javax.swing.JLabel id6;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser5;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
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
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator74;
    private javax.swing.JSeparator jSeparator75;
    private javax.swing.JSeparator jSeparator76;
    private javax.swing.JSeparator jSeparator77;
    private javax.swing.JSeparator jSeparator78;
    private javax.swing.JSeparator jSeparator79;
    private javax.swing.JSeparator jSeparator80;
    private javax.swing.JPanel liste_patients;
    private javax.swing.JPanel liste_praticiens;
    public static javax.swing.JTextField mail;
    private javax.swing.JPanel messagerie;
    private javax.swing.JTextArea msg;
    private rojerusan.RSMetroTextFullPlaceHolder name;
    public static javax.swing.JTextField nom;
    private javax.swing.JLabel nom_prat;
    public javax.swing.JLabel nom_prenom8;
    public javax.swing.JLabel nomp8;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelp;
    private rojerusan.RSMetroTextPassPlaceHolderView pass;
    public static javax.swing.JTextField pass2;
    private javax.swing.JTextField path_attach;
    public static javax.swing.JTextField prenom;
    public javax.swing.JLabel prenomp8;
    private javax.swing.JPanel profil_praticien;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSButtonHover rSButtonHover5;
    private rojerusan.RSButtonHover rSButtonHover6;
    private javax.swing.JScrollPane scrol;
    public static javax.swing.JTextField spec;
    public javax.swing.JLabel spece6;
    private rojerusan.RSMetroTextFullPlaceHolder subject;
    private rojerusan.RSTableMetro table_patient1;
    private rojerusan.RSTableMetro table_praticien;
    private rojerusan.RSTableMetro table_radio;
    public static javax.swing.JTextField tel;
    private rojerusan.RSMetroTextFullPlaceHolder textsearch2;
    private rojerusan.RSMetroTextFullPlaceHolder textsearch4;
    private rojerusan.RSMetroTextFullPlaceHolder to;
    public static javax.swing.JTextField type;
    private javax.swing.JLabel type1;
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

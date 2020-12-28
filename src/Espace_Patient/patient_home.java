/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espace_Patient;


import Dossier_Médical.Fiche_Mes_RDVs;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.*;

import Listes.*;
import Login.*;
import interfaces.inter_RDV;
import interfaces.inter_infos_suivi;
import interfaces.inter_praticien;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import public_var.fonctions;
import static public_var.variables.*;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author berich
 */
public class patient_home extends javax.swing.JFrame {
    private final DefaultListModel listModel = new DefaultListModel();
   
     private final DefaultComboBoxModel combModelpra= new DefaultComboBoxModel();
     private String Rep1;
     private String Rep2;
     private String Rep3;
     private String Rep4;
     public static String specialite;
     String des="signaler";
     String atachement_path;
     String filename;
     
    
    public patient_home() {
        initComponents();
        cnx=DB_Connexion.Connexion();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        Affichertable_praticien();
        
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup2.add(jRadioButton3);
        buttonGroup2.add(jRadioButton4);
        buttonGroup3.add(jRadioButton5);
        buttonGroup3.add(jRadioButton6);
        buttonGroup4.add(jRadioButton7);
        buttonGroup4.add(jRadioButton8);
        
         Afficher();
         fonctions.HeureSystem(Heure);
         fonctions.HeureSystemsec(heure_envoie);
         fonctions.DateSystem(Date);
         fonctions.DateSystem(date_envoie);
         Affichertable_Mes_RDV();
    }
    
    
    patient_login ph =new patient_login();
    String idef=  ph.recuperer();
    Fiche_Mes_RDVs drdv=new  Fiche_Mes_RDVs();
    public  void Afficher(){
        try {
            
            String rqt = " select * from patient where patient_identifiant = '" +idef+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                 String s = rs.getString("N_doss_med");
                numdoss.setText(s);
                num_doss.setText(s);
                num_doss2.setText(s);
                String s1 = rs.getString("patient_identifiant");
                mat.setText(s1);
                String s2 = rs.getString("patient_nom");
                nom.setText(s2);
                nompatient.setText(s2);
                String s3 = rs.getString("patient_prenom");
                prenom.setText(s3);
                prenompatient.setText(s3);
                String s4 = rs.getString("patient_date_naiss");
                date_naiss.setText(s4);
                String s5 = rs.getString("patient_age");
                age.setText(s5);
                String s6 = rs.getString("patient_sexe");
                sexe.setText(s6);
                String s7 = rs.getString("patient_gsanguin");
                gsang.setText(s7);
                String s8 = rs.getString("patient_situation_famillial");
                sit_fam.setText(s8);
                String s9= rs.getString("patient_address");
                address.setText(s9);
                String s10 = rs.getString("patient_wilaya");
                wilaya.setText(s10 );
                String s11 = rs.getString("patient_email");
                email.setText(s11);
                from.setText(s11);
                String s12 = rs.getString("patient_num_phone");
                tlf.setText(s12);
                String s13 = rs.getString("patient_code_assurance");
                code_assurance.setText(s13);
                String s14 =rs.getString("image");
                if(s14.equals("")){
                ImageIcon img = new ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/sem_foto.jpg"));
                image.setIcon(img);
                }else{
                image.setIcon(new ImageIcon(s14));
                }
                String s15 = rs.getString("date_insc");
                dateins.setText(s15);
                String s16 = rs.getString("pneumolgue_ref");
                inter_praticien inter_pra = new inter_praticien();
                praticien pn= (praticien) inter_pra.selectnom_prenom(s16);
                pneu2.setText(pn.toString());
                pneu.setText(pn.toString());
                String s17 = rs.getString("oncologue_ref");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s17);
                onco2.setText(pn2.toString());
                onco.setText(pn2.toString());
            }
                ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
  //_______________________________________________________________________________________________________
    
    
    //___________________________________________________________________________________________________
    
    public void initComboList2(){
        inter_praticien inter_pra = new inter_praticien();
         java.util.List<praticien> sp= inter_pra.selectspec();
         for (Object s : sp) {
            praticien  ps = (praticien)s;
            combModelpra.addElement(ps);
        }
        this.nom_prenom.setModel(combModelpra);
        
        
        
    }
    
    
    
 //vider champs  inforamtions de suivi:
    public void vider(){
        
         poids.setText("");
         fievre.setText("");
         app.setSelectedItem("Pas de probléme");
         essouf.setSelectedItem("Pas de probléme");
         toux.setSelectedItem("Pas de probléme");
         deprime.setSelectedItem("Pas de probléme");
         faiblesse.setSelectedItem("Pas de probléme");
         douleur.setText("");
         jRadioButton1.setSelected(false);
         jRadioButton2.setSelected(false);
         jRadioButton3.setSelected(false);
         jRadioButton4.setSelected(false);
         jRadioButton5.setSelected(false);
         jRadioButton6.setSelected(false);
         jRadioButton7.setSelected(false);
         jRadioButton8.setSelected(false);
         comment.setText("");
         
        
    }
    
    
     // Afficher la table RDV
      
       public void Affichertable_Mes_RDV() {
        try {
            
            
          String ND= numdoss.getText();
           String rqt = "select id_RDV as 'id',date_envoie as 'Date d envoie',heure_envoie'Heure d envoie' from rendez_vous where `Num_doss_med` = '"+ND+"'  AND `desc` ='"+des+"'"; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           DRDVS_TABLE.setModel(DbUtils.resultSetToTableModel(rs));
           
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
    
    
    
       
         //   Afficher demande RDV detail 
        // Afficher 
       public static Connection cnx2;
     public void afficher_detail_RDV(Fiche_Mes_RDVs  Drdv) {
        
        try {
            
            int R =  DRDVS_TABLE.getSelectedRow();
            N = (DRDVS_TABLE.getModel().getValueAt(R, 0).toString());
           
           
            String rqt = "select * from rendez_vous WHERE `id_RDV` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
               
                String s2 = rs.getString("date_RDV");
                Drdv.date.setText(s2);
                String s3 = rs.getString("heure_RDV");
                Drdv.heure.setText(s3);
                String s4 = rs.getString("Raison");
                Drdv.raison.setText(s4);
                String s5 = rs.getString("id_Praticien");
                //System.out.println(s5);
                String rqt2= "select * from praticien where  `praticien_identifiant` LIKE '" +s5+"'";
                PreparedStatement  ps2 = cnx.prepareStatement(rqt2);
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.next()){
                String s6=rs2.getString("praticien_specialite");
                Drdv.specialite.setText(s6);
                inter_praticien inter_pra = new inter_praticien();
                praticien pn= (praticien) inter_pra.selectnom_prenom(s5);
                Drdv.nom.setText(pn.toString());
                }
                ps2.close();
                rs2.close();
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
     
     
     
     
      public void recherche_RDV( String rech)
     {
         String ND= numdoss.getText();
         try {
String rqt= "select id_RDV as 'id',date_envoie as 'Date d envoie',heure_envoie as 'Heure d envoie'from rendez_vous where `Num_doss_med` = '"+ND+"'  AND `desc` ='"+des+"' AND ( date_envoie LIKE'" + rech + "%'  )";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
         DRDVS_TABLE.setModel(DbUtils.resultSetToTableModel(rs));
             ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
     }  
    
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
     
     
     
     
     
     
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Demande_RDV = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        heure = new javax.swing.JTextField();
        combo_spec = new rojerusan.RSComboMetro();
        rSButtonHover4 = new rojerusan.RSButtonHover();
        rSButtonHover3 = new rojerusan.RSButtonHover();
        jScrollPane2 = new javax.swing.JScrollPane();
        raison = new javax.swing.JTextArea();
        nom_prenom = new rojerusan.RSComboMetro();
        date = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        num_doss2 = new javax.swing.JTextField();
        date_envoie = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        heure_envoie = new javax.swing.JTextField();
        jSeparator31 = new javax.swing.JSeparator();
        MES_RDVS = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DRDVS_TABLE = new rojerusan.RSTableMetro() {
            public boolean isCellEditable(int d,int c){
                return false;
            }};
            jLabel52 = new javax.swing.JLabel();
            jLabel53 = new javax.swing.JLabel();
            rdvsearch = new rojerusan.RSMetroTextFullPlaceHolder();
            buttonGroup1 = new javax.swing.ButtonGroup();
            buttonGroup2 = new javax.swing.ButtonGroup();
            buttonGroup3 = new javax.swing.ButtonGroup();
            buttonGroup4 = new javax.swing.ButtonGroup();
            jPanel2 = new javax.swing.JPanel();
            panelp = new javax.swing.JPanel();
            jSeparator1 = new javax.swing.JSeparator();
            jSeparator2 = new javax.swing.JSeparator();
            jSeparator3 = new javax.swing.JSeparator();
            btn_accueil = new rojerusan.RSButtonMetro();
            btn_profil = new rojerusan.RSButtonHover();
            btn_ajout_infos = new rojerusan.RSButtonHover();
            btn_msg = new rojerusan.RSButtonHover();
            btn_rdv = new rojerusan.RSButtonHover();
            jSeparator32 = new javax.swing.JSeparator();
            jPanel8 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            prenompatient = new javax.swing.JLabel();
            nompatient = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            PanelSlider = new rojerusan.RSPanelsSlider();
            accueil = new javax.swing.JPanel();
            Heure = new javax.swing.JLabel();
            jCalendar1 = new com.toedter.calendar.JCalendar();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            profil = new javax.swing.JPanel();
            jPanel3 = new javax.swing.JPanel();
            patient_infos = new javax.swing.JPanel();
            jLabel8 = new javax.swing.JLabel();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            jLabel13 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            jLabel54 = new javax.swing.JLabel();
            jLabel22 = new javax.swing.JLabel();
            jScrollPane3 = new javax.swing.JScrollPane();
            image = new javax.swing.JLabel();
            jLabel55 = new javax.swing.JLabel();
            jLabel56 = new javax.swing.JLabel();
            jLabel20 = new javax.swing.JLabel();
            onco2 = new javax.swing.JLabel();
            nom = new javax.swing.JLabel();
            prenom = new javax.swing.JLabel();
            date_naiss = new javax.swing.JLabel();
            age = new javax.swing.JLabel();
            sexe = new javax.swing.JLabel();
            sit_fam = new javax.swing.JLabel();
            gsang = new javax.swing.JLabel();
            address = new javax.swing.JLabel();
            code_assurance = new javax.swing.JLabel();
            email = new javax.swing.JLabel();
            tlf = new javax.swing.JLabel();
            wilaya = new javax.swing.JLabel();
            jSeparator4 = new javax.swing.JSeparator();
            jSeparator7 = new javax.swing.JSeparator();
            jSeparator33 = new javax.swing.JSeparator();
            jSeparator34 = new javax.swing.JSeparator();
            jSeparator35 = new javax.swing.JSeparator();
            jSeparator6 = new javax.swing.JSeparator();
            jSeparator36 = new javax.swing.JSeparator();
            jSeparator37 = new javax.swing.JSeparator();
            jSeparator9 = new javax.swing.JSeparator();
            jSeparator10 = new javax.swing.JSeparator();
            jSeparator11 = new javax.swing.JSeparator();
            jSeparator12 = new javax.swing.JSeparator();
            jSeparator13 = new javax.swing.JSeparator();
            jSeparator14 = new javax.swing.JSeparator();
            jSeparator15 = new javax.swing.JSeparator();
            jLabel57 = new javax.swing.JLabel();
            jLabel23 = new javax.swing.JLabel();
            jSeparator16 = new javax.swing.JSeparator();
            jSeparator17 = new javax.swing.JSeparator();
            jSeparator18 = new javax.swing.JSeparator();
            numdoss = new javax.swing.JLabel();
            dateins = new javax.swing.JLabel();
            jSeparator19 = new javax.swing.JSeparator();
            jLabel24 = new javax.swing.JLabel();
            jLabel25 = new javax.swing.JLabel();
            mat = new javax.swing.JLabel();
            pneu2 = new javax.swing.JLabel();
            jSeparator20 = new javax.swing.JSeparator();
            jSeparator21 = new javax.swing.JSeparator();
            jSeparator22 = new javax.swing.JSeparator();
            jSeparator23 = new javax.swing.JSeparator();
            jLabel7 = new javax.swing.JLabel();
            jLabel39 = new javax.swing.JLabel();
            Rendez_vous = new javax.swing.JPanel();
            jSeparator5 = new javax.swing.JSeparator();
            rSButtonHover1 = new rojerusan.RSButtonHover();
            rSButtonHover2 = new rojerusan.RSButtonHover();
            ScrolPane = new javax.swing.JScrollPane();
            infos_suivi = new javax.swing.JPanel();
            jScrollPane6 = new javax.swing.JScrollPane();
            jPanel9 = new javax.swing.JPanel();
            jPanel7 = new javax.swing.JPanel();
            douleur = new javax.swing.JTextField();
            jSlider1 = new javax.swing.JSlider();
            jLabel21 = new javax.swing.JLabel();
            jLabel27 = new javax.swing.JLabel();
            jLabel28 = new javax.swing.JLabel();
            jLabel30 = new javax.swing.JLabel();
            jLabel33 = new javax.swing.JLabel();
            jLabel29 = new javax.swing.JLabel();
            jLabel31 = new javax.swing.JLabel();
            jLabel34 = new javax.swing.JLabel();
            jRadioButton1 = new javax.swing.JRadioButton();
            jLabel35 = new javax.swing.JLabel();
            jRadioButton2 = new javax.swing.JRadioButton();
            jLabel36 = new javax.swing.JLabel();
            jRadioButton4 = new javax.swing.JRadioButton();
            jRadioButton5 = new javax.swing.JRadioButton();
            jRadioButton6 = new javax.swing.JRadioButton();
            jLabel37 = new javax.swing.JLabel();
            jRadioButton7 = new javax.swing.JRadioButton();
            fievre = new javax.swing.JTextField();
            pneu = new javax.swing.JTextField();
            btn_enoyer = new rojerusan.RSButtonHover();
            num_doss = new javax.swing.JTextField();
            jLabel40 = new javax.swing.JLabel();
            btn_vider = new rojerusan.RSButtonHover();
            jLabel42 = new javax.swing.JLabel();
            jRadioButton3 = new javax.swing.JRadioButton();
            jLabel26 = new javax.swing.JLabel();
            app = new rojerusan.RSComboMetro();
            essouf = new rojerusan.RSComboMetro();
            deprime = new rojerusan.RSComboMetro();
            toux = new rojerusan.RSComboMetro();
            faiblesse = new rojerusan.RSComboMetro();
            jRadioButton8 = new javax.swing.JRadioButton();
            jLabel32 = new javax.swing.JLabel();
            jScrollPane8 = new javax.swing.JScrollPane();
            comment = new javax.swing.JTextArea();
            jSeparator8 = new javax.swing.JSeparator();
            Date = new javax.swing.JTextField();
            poids = new javax.swing.JTextField();
            onco = new javax.swing.JTextField();
            Demandes = new javax.swing.JPanel();
            Messagerie = new javax.swing.JPanel();
            jPanel1 = new javax.swing.JPanel();
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
            jPanel4 = new javax.swing.JPanel();
            jScrollPane5 = new javax.swing.JScrollPane();
            table_praticien = new rojerusan.RSTableMetro()    {public boolean isCellEditable(int d,int c){
                return false;
            }
        };
        textsearch1 = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel48 = new javax.swing.JLabel();

        Demande_RDV.setBackground(new java.awt.Color(255, 255, 255));
        Demande_RDV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Demande d' un Rendez-vous", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 182, 215))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(3, 182, 215));
        jLabel4.setText("Spécialité * :");
        jLabel4.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(3, 182, 215));
        jLabel16.setText("Praticien* :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(3, 182, 215));
        jLabel17.setText("Date  de préférence:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(3, 182, 215));
        jLabel18.setText("Heure de préférence :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(3, 182, 215));
        jLabel19.setText("Raisons de la Demande :");

        heure.setForeground(new java.awt.Color(3, 182, 215));
        heure.setText("00:00:00");
        heure.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        combo_spec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pneumologue", "oncologue", "oncologue radiothérapeute", "chirurgien thoracique" }));
        combo_spec.setColorArrow(new java.awt.Color(3, 182, 215));
        combo_spec.setColorBorde(new java.awt.Color(3, 182, 215));
        combo_spec.setColorFondo(new java.awt.Color(3, 182, 215));
        combo_spec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_specMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                combo_specMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_specMousePressed(evt);
            }
        });
        combo_spec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_specActionPerformed(evt);
            }
        });

        rSButtonHover4.setBackground(new java.awt.Color(3, 182, 215));
        rSButtonHover4.setText("Annuler");
        rSButtonHover4.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonHover4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover4ActionPerformed(evt);
            }
        });

        rSButtonHover3.setBackground(new java.awt.Color(3, 182, 215));
        rSButtonHover3.setText("Valider");
        rSButtonHover3.setColorHover(new java.awt.Color(204, 204, 204));
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });

        raison.setColumns(20);
        raison.setRows(5);
        raison.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        jScrollPane2.setViewportView(raison);

        nom_prenom.setColorArrow(new java.awt.Color(3, 182, 215));
        nom_prenom.setColorBorde(new java.awt.Color(3, 182, 215));
        nom_prenom.setColorFondo(new java.awt.Color(3, 182, 215));

        date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));
        date.setDateFormatString("YYY-MM-dd");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(3, 182, 215));
        jLabel38.setText("N° dossier médicales:");
        jLabel38.setToolTipText("");

        num_doss2.setEditable(false);
        num_doss2.setForeground(new java.awt.Color(3, 182, 215));
        num_doss2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        num_doss2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num_doss2ActionPerformed(evt);
            }
        });

        date_envoie.setEditable(false);
        date_envoie.setForeground(new java.awt.Color(3, 182, 215));
        date_envoie.setBorder(null);
        date_envoie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_envoieActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(3, 182, 215));
        jLabel50.setText("Le:");
        jLabel50.setToolTipText("");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(3, 182, 215));
        jLabel51.setText("à:");
        jLabel51.setToolTipText("");

        heure_envoie.setEditable(false);
        heure_envoie.setForeground(new java.awt.Color(3, 182, 215));
        heure_envoie.setBorder(null);
        heure_envoie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heure_envoieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Demande_RDVLayout = new javax.swing.GroupLayout(Demande_RDV);
        Demande_RDV.setLayout(Demande_RDVLayout);
        Demande_RDVLayout.setHorizontalGroup(
            Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Demande_RDVLayout.createSequentialGroup()
                .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Demande_RDVLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_envoie, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heure_envoie, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Demande_RDVLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(Demande_RDVLayout.createSequentialGroup()
                                .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(heure, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Demande_RDVLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nom_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Demande_RDVLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combo_spec, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Demande_RDVLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(Demande_RDVLayout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(num_doss2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(51, 51, 51))
            .addGroup(Demande_RDVLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(rSButtonHover3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(rSButtonHover4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Demande_RDVLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jSeparator31)
                .addContainerGap())
        );
        Demande_RDVLayout.setVerticalGroup(
            Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Demande_RDVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date_envoie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heure_envoie, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num_doss2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_spec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Demande_RDVLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addGroup(Demande_RDVLayout.createSequentialGroup()
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heure, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(Demande_RDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSButtonHover4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(rSButtonHover3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        MES_RDVS.setBackground(new java.awt.Color(255, 255, 255));
        MES_RDVS.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mes Rendez-vous ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(52, 73, 94))); // NOI18N
        MES_RDVS.setPreferredSize(new java.awt.Dimension(534, 492));

        DRDVS_TABLE.setForeground(new java.awt.Color(3, 182, 215));
        DRDVS_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date d'envoie", "Heure d'envoie", "Signaler par"
            }
        ));
        DRDVS_TABLE.setColorBackgoundHead(new java.awt.Color(52, 73, 94));
        DRDVS_TABLE.setColorBordeFilas(new java.awt.Color(52, 73, 94));
        DRDVS_TABLE.setColorBordeHead(new java.awt.Color(52, 73, 94));
        DRDVS_TABLE.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        DRDVS_TABLE.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
        DRDVS_TABLE.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
        DRDVS_TABLE.setColorSelBackgound(new java.awt.Color(3, 182, 215));
        DRDVS_TABLE.setGrosorBordeFilas(0);
        DRDVS_TABLE.setGrosorBordeHead(0);
        DRDVS_TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DRDVS_TABLEMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(DRDVS_TABLE);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Refresh_48px.png"))); // NOI18N
        jLabel52.setToolTipText("Actualiser");
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Search_Property_40px_1.png"))); // NOI18N

        rdvsearch.setForeground(new java.awt.Color(3, 182, 215));
        rdvsearch.setBorderColor(new java.awt.Color(52, 73, 94));
        rdvsearch.setBotonColor(new java.awt.Color(52, 73, 94));
        rdvsearch.setPhColor(new java.awt.Color(3, 182, 215));
        rdvsearch.setPlaceholder("format date : yyyy/mm/jj");
        rdvsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdvsearchActionPerformed(evt);
            }
        });
        rdvsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rdvsearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout MES_RDVSLayout = new javax.swing.GroupLayout(MES_RDVS);
        MES_RDVS.setLayout(MES_RDVSLayout);
        MES_RDVSLayout.setHorizontalGroup(
            MES_RDVSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
            .addGroup(MES_RDVSLayout.createSequentialGroup()
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdvsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel52)
                .addGap(1, 1, 1))
        );
        MES_RDVSLayout.setVerticalGroup(
            MES_RDVSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MES_RDVSLayout.createSequentialGroup()
                .addGroup(MES_RDVSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MES_RDVSLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(MES_RDVSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MES_RDVSLayout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(MES_RDVSLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(rdvsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE))))
                    .addGroup(MES_RDVSLayout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1350, 750));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        panelp.setBackground(new java.awt.Color(255, 255, 255));
        panelp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jSeparator1.setForeground(new java.awt.Color(3, 182, 215));

        jSeparator2.setForeground(new java.awt.Color(3, 182, 215));

        jSeparator3.setForeground(new java.awt.Color(3, 182, 215));

        btn_accueil.setBackground(new java.awt.Color(3, 182, 215));
        btn_accueil.setText("Accueil");
        btn_accueil.setFocusPainted(false);
        btn_accueil.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        btn_accueil.setOpaque(true);
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

        btn_profil.setBackground(new java.awt.Color(255, 255, 255));
        btn_profil.setBorder(null);
        btn_profil.setForeground(new java.awt.Color(3, 182, 215));
        btn_profil.setText("PROFIL");
        btn_profil.setToolTipText("");
        btn_profil.setColorHover(new java.awt.Color(255, 255, 255));
        btn_profil.setColorText(new java.awt.Color(3, 182, 215));
        btn_profil.setColorTextHover(new java.awt.Color(204, 204, 204));
        btn_profil.setFocusPainted(false);
        btn_profil.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btn_profil.setName(""); // NOI18N
        btn_profil.setOpaque(true);
        btn_profil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profilActionPerformed(evt);
            }
        });

        btn_ajout_infos.setBackground(new java.awt.Color(255, 255, 255));
        btn_ajout_infos.setBorder(null);
        btn_ajout_infos.setText("AJOUTER DES INFORMATIONS DE SUIVI");
        btn_ajout_infos.setActionCommand("DEMANDE COMPTE RENDUS");
        btn_ajout_infos.setColorHover(new java.awt.Color(255, 255, 255));
        btn_ajout_infos.setColorText(new java.awt.Color(3, 180, 215));
        btn_ajout_infos.setColorTextHover(new java.awt.Color(204, 204, 204));
        btn_ajout_infos.setFocusPainted(false);
        btn_ajout_infos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btn_ajout_infos.setName(""); // NOI18N
        btn_ajout_infos.setOpaque(true);
        btn_ajout_infos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ajout_infosActionPerformed(evt);
            }
        });

        btn_msg.setBackground(new java.awt.Color(255, 255, 255));
        btn_msg.setBorder(null);
        btn_msg.setForeground(new java.awt.Color(3, 182, 215));
        btn_msg.setText("MESSAGERIE");
        btn_msg.setToolTipText("");
        btn_msg.setColorHover(new java.awt.Color(255, 255, 255));
        btn_msg.setColorText(new java.awt.Color(3, 182, 215));
        btn_msg.setColorTextHover(new java.awt.Color(204, 204, 204));
        btn_msg.setFocusPainted(false);
        btn_msg.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btn_msg.setName(""); // NOI18N
        btn_msg.setOpaque(true);
        btn_msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_msgActionPerformed(evt);
            }
        });

        btn_rdv.setBackground(new java.awt.Color(255, 255, 255));
        btn_rdv.setBorder(null);
        btn_rdv.setText(" RENDEZ-VOUS");
        btn_rdv.setToolTipText("");
        btn_rdv.setColorHover(new java.awt.Color(255, 255, 255));
        btn_rdv.setColorText(new java.awt.Color(3, 182, 215));
        btn_rdv.setColorTextHover(new java.awt.Color(204, 204, 204));
        btn_rdv.setFocusPainted(false);
        btn_rdv.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btn_rdv.setName(""); // NOI18N
        btn_rdv.setOpaque(true);
        btn_rdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rdvActionPerformed(evt);
            }
        });

        jSeparator32.setForeground(new java.awt.Color(3, 182, 215));

        javax.swing.GroupLayout panelpLayout = new javax.swing.GroupLayout(panelp);
        panelp.setLayout(panelpLayout);
        panelpLayout.setHorizontalGroup(
            panelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ajout_infos, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_accueil, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_profil, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_rdv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                    .addGroup(panelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_msg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelpLayout.setVerticalGroup(
            panelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btn_accueil, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_profil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_ajout_infos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_rdv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2.add(panelp);
        panelp.setBounds(10, 130, 370, 550);

        jPanel8.setBackground(new java.awt.Color(3, 182, 215));

        jLabel1.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenue:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Logout_Rounded_Down_40px.png"))); // NOI18N
        jLabel3.setToolTipText("Déconnexion");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        prenompatient.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        prenompatient.setForeground(new java.awt.Color(255, 255, 255));

        nompatient.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        nompatient.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nompatient, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prenompatient, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(nompatient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prenompatient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(jPanel8);
        jPanel8.setBounds(110, 30, 1210, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/patient128.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 0, 160, 130);

        accueil.setBackground(new java.awt.Color(255, 255, 255));
        accueil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));
        accueil.setName("accueil"); // NOI18N

        Heure.setFont(new java.awt.Font("DS-Digital", 1, 48)); // NOI18N
        Heure.setForeground(new java.awt.Color(3, 182, 215));

        jCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/depositphotos_180794068-stock-illustration-doctor_1.png"))); // NOI18N

        javax.swing.GroupLayout accueilLayout = new javax.swing.GroupLayout(accueil);
        accueil.setLayout(accueilLayout);
        accueilLayout.setHorizontalGroup(
            accueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accueilLayout.createSequentialGroup()
                .addGroup(accueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accueilLayout.createSequentialGroup()
                        .addGap(955, 955, 955)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(accueilLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addGap(42, 42, 42)
                        .addGroup(accueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        accueilLayout.setVerticalGroup(
            accueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accueilLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(accueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(accueilLayout.createSequentialGroup()
                        .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(260, 260, 260)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelSlider.add(accueil, "card7");

        profil.setName("profil"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(1000, 1200));

        patient_infos.setBackground(new java.awt.Color(228, 241, 254));
        patient_infos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations Patient", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andalus", 1, 18), new java.awt.Color(3, 182, 215))); // NOI18N
        patient_infos.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(3, 182, 215));
        jLabel8.setText("Nom :");
        patient_infos.add(jLabel8);
        jLabel8.setBounds(50, 250, 73, 20);

        jLabel9.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(3, 182, 215));
        jLabel9.setText("Prenom :");
        patient_infos.add(jLabel9);
        jLabel9.setBounds(430, 250, 89, 20);

        jLabel10.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(3, 182, 215));
        jLabel10.setText("Date de Naissance :");
        patient_infos.add(jLabel10);
        jLabel10.setBounds(50, 300, 159, 20);

        jLabel11.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(3, 182, 215));
        jLabel11.setText("Sexe :");
        patient_infos.add(jLabel11);
        jLabel11.setBounds(50, 350, 140, 21);

        jLabel12.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(3, 182, 215));
        jLabel12.setText("Situation Familliale :");
        patient_infos.add(jLabel12);
        jLabel12.setBounds(50, 410, 170, 30);

        jLabel13.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(3, 182, 215));
        jLabel13.setText("Adresse :");
        patient_infos.add(jLabel13);
        jLabel13.setBounds(50, 470, 99, 28);

        jLabel14.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(3, 182, 215));
        jLabel14.setText("Wilaya :");
        patient_infos.add(jLabel14);
        jLabel14.setBounds(430, 470, 67, 20);

        jLabel15.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(3, 182, 215));
        jLabel15.setText("Email :");
        patient_infos.add(jLabel15);
        jLabel15.setBounds(50, 540, 90, 19);

        jLabel54.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(3, 182, 215));
        jLabel54.setText("Télephone :");
        patient_infos.add(jLabel54);
        jLabel54.setBounds(430, 530, 96, 26);

        jLabel22.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(3, 182, 215));
        jLabel22.setText("Groupe Sanguin :");
        patient_infos.add(jLabel22);
        jLabel22.setBounds(430, 360, 144, 20);

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Espace_Admin/sem_foto.jpg"))); // NOI18N
        jScrollPane3.setViewportView(image);

        patient_infos.add(jScrollPane3);
        jScrollPane3.setBounds(50, 30, 190, 190);

        jLabel55.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(3, 182, 215));
        jLabel55.setText("Code d'assurance:");
        patient_infos.add(jLabel55);
        jLabel55.setBounds(430, 410, 147, 23);

        jLabel56.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(3, 182, 215));
        jLabel56.setText("Date d'inscription:");
        patient_infos.add(jLabel56);
        jLabel56.setBounds(430, 30, 170, 30);

        jLabel20.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(3, 182, 215));
        jLabel20.setText("Age :");
        patient_infos.add(jLabel20);
        jLabel20.setBounds(430, 300, 73, 20);

        onco2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        onco2.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(onco2);
        onco2.setBounds(600, 200, 190, 30);

        nom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nom.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(nom);
        nom.setBounds(220, 240, 190, 30);

        prenom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        prenom.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(prenom);
        prenom.setBounds(600, 240, 190, 30);

        date_naiss.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date_naiss.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(date_naiss);
        date_naiss.setBounds(220, 290, 190, 30);

        age.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        age.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(age);
        age.setBounds(600, 290, 190, 30);

        sexe.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sexe.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(sexe);
        sexe.setBounds(220, 350, 190, 30);

        sit_fam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sit_fam.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(sit_fam);
        sit_fam.setBounds(220, 410, 190, 30);

        gsang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gsang.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(gsang);
        gsang.setBounds(600, 350, 190, 30);

        address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        address.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(address);
        address.setBounds(220, 470, 190, 30);

        code_assurance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        code_assurance.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(code_assurance);
        code_assurance.setBounds(600, 400, 190, 30);

        email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        email.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(email);
        email.setBounds(220, 530, 190, 30);

        tlf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tlf.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(tlf);
        tlf.setBounds(590, 520, 190, 30);

        wilaya.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        wilaya.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(wilaya);
        wilaya.setBounds(600, 460, 190, 30);
        patient_infos.add(jSeparator4);
        jSeparator4.setBounds(10, 238, 780, 10);
        patient_infos.add(jSeparator7);
        jSeparator7.setBounds(50, 280, 360, 2);
        patient_infos.add(jSeparator33);
        jSeparator33.setBounds(50, 332, 360, 10);
        patient_infos.add(jSeparator34);
        jSeparator34.setBounds(50, 390, 360, 2);
        patient_infos.add(jSeparator35);
        jSeparator35.setBounds(50, 450, 0, 2);
        patient_infos.add(jSeparator6);
        jSeparator6.setBounds(50, 450, 360, 2);
        patient_infos.add(jSeparator36);
        jSeparator36.setBounds(50, 512, 360, 10);
        patient_infos.add(jSeparator37);
        jSeparator37.setBounds(50, 572, 370, 0);
        patient_infos.add(jSeparator9);
        jSeparator9.setBounds(50, 570, 360, 2);
        patient_infos.add(jSeparator10);
        jSeparator10.setBounds(430, 282, 370, 0);
        patient_infos.add(jSeparator11);
        jSeparator11.setBounds(430, 332, 370, 0);
        patient_infos.add(jSeparator12);
        jSeparator12.setBounds(430, 390, 370, 2);
        patient_infos.add(jSeparator13);
        jSeparator13.setBounds(430, 452, 370, 0);
        patient_infos.add(jSeparator14);
        jSeparator14.setBounds(440, 510, 360, 0);
        patient_infos.add(jSeparator15);
        jSeparator15.setBounds(430, 570, 370, 2);

        jLabel57.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(3, 182, 215));
        jLabel57.setText("Oncologue .R:");
        patient_infos.add(jLabel57);
        jLabel57.setBounds(430, 210, 150, 20);

        jLabel23.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(3, 182, 215));
        jLabel23.setText("N° dossier médical :");
        patient_infos.add(jLabel23);
        jLabel23.setBounds(430, 80, 170, 28);
        patient_infos.add(jSeparator16);
        jSeparator16.setBounds(430, 70, 360, 2);
        patient_infos.add(jSeparator17);
        jSeparator17.setBounds(430, 112, 360, 10);
        patient_infos.add(jSeparator18);
        jSeparator18.setBounds(430, 162, 360, 2);

        numdoss.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numdoss.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(numdoss);
        numdoss.setBounds(600, 80, 190, 30);

        dateins.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateins.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(dateins);
        dateins.setBounds(600, 30, 190, 30);
        patient_infos.add(jSeparator19);
        jSeparator19.setBounds(430, 200, 360, 2);

        jLabel24.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(3, 182, 215));
        jLabel24.setText("identifiant:");
        patient_infos.add(jLabel24);
        jLabel24.setBounds(430, 120, 92, 30);

        jLabel25.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(3, 182, 215));
        jLabel25.setText("Pneumologue .R:");
        patient_infos.add(jLabel25);
        jLabel25.setBounds(430, 170, 150, 20);

        mat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mat.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(mat);
        mat.setBounds(600, 120, 190, 30);

        pneu2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pneu2.setForeground(new java.awt.Color(52, 73, 94));
        patient_infos.add(pneu2);
        pneu2.setBounds(600, 170, 190, 30);
        patient_infos.add(jSeparator20);
        jSeparator20.setBounds(430, 280, 360, 2);
        patient_infos.add(jSeparator21);
        jSeparator21.setBounds(430, 330, 360, 20);
        patient_infos.add(jSeparator22);
        jSeparator22.setBounds(430, 452, 360, 10);
        patient_infos.add(jSeparator23);
        jSeparator23.setBounds(430, 510, 360, 2);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Edit_30px_1.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        patient_infos.add(jLabel7);
        jLabel7.setBounds(890, 70, 30, 30);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Refresh_30px.png"))); // NOI18N
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        patient_infos.add(jLabel39);
        jLabel39.setBounds(890, 20, 30, 30);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(patient_infos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(patient_infos, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout profilLayout = new javax.swing.GroupLayout(profil);
        profil.setLayout(profilLayout);
        profilLayout.setHorizontalGroup(
            profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profilLayout.setVerticalGroup(
            profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PanelSlider.add(profil, "card2");

        Rendez_vous.setBackground(new java.awt.Color(255, 255, 255));
        Rendez_vous.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));
        Rendez_vous.setName("Rendez_vous"); // NOI18N

        jSeparator5.setForeground(new java.awt.Color(3, 182, 215));
        jSeparator5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        rSButtonHover1.setBackground(new java.awt.Color(3, 182, 215));
        rSButtonHover1.setText("Demander un Rendez-vous");
        rSButtonHover1.setColorHover(new java.awt.Color(255, 255, 255));
        rSButtonHover1.setColorTextHover(new java.awt.Color(3, 182, 215));
        rSButtonHover1.setFocusPainted(false);
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });

        rSButtonHover2.setBackground(new java.awt.Color(3, 182, 215));
        rSButtonHover2.setText("Voir Mes prochains Rendez-vous");
        rSButtonHover2.setColorHover(new java.awt.Color(255, 255, 255));
        rSButtonHover2.setColorTextHover(new java.awt.Color(3, 182, 215));
        rSButtonHover2.setFocusPainted(false);
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });

        ScrolPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Rendez_vousLayout = new javax.swing.GroupLayout(Rendez_vous);
        Rendez_vous.setLayout(Rendez_vousLayout);
        Rendez_vousLayout.setHorizontalGroup(
            Rendez_vousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Rendez_vousLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5))
            .addGroup(Rendez_vousLayout.createSequentialGroup()
                .addGroup(Rendez_vousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Rendez_vousLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(rSButtonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(rSButtonHover2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Rendez_vousLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(ScrolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        Rendez_vousLayout.setVerticalGroup(
            Rendez_vousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Rendez_vousLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Rendez_vousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSButtonHover1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(rSButtonHover2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ScrolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelSlider.add(Rendez_vous, "card3");

        infos_suivi.setBackground(new java.awt.Color(255, 255, 255));
        infos_suivi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));
        infos_suivi.setName("infos_suivi"); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evaluer La Douleur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 182, 215))); // NOI18N

        douleur.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        douleur.setText("0");
        douleur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));
        douleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                douleurActionPerformed(evt);
            }
        });

        jSlider1.setBackground(new java.awt.Color(3, 182, 215));
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(10);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(douleur, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(douleur)
            .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(3, 182, 215));
        jLabel21.setText("N° dossier médical:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(3, 182, 215));
        jLabel27.setText("Sensation de faiblesse :");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(3, 182, 215));
        jLabel28.setText("Appétit :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(3, 182, 215));
        jLabel30.setText("Essoufflement :");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(3, 182, 215));
        jLabel33.setText("Poids  :");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(3, 182, 215));
        jLabel29.setText("Déprime :");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(3, 182, 215));
        jLabel31.setText("Toux :");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(3, 182, 215));
        jLabel34.setText("Gonflement brutal du visage :");

        jRadioButton1.setText("OUI");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(3, 182, 215));
        jLabel35.setText("Apparition d'une boule sous la peau :");

        jRadioButton2.setText("NON");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(3, 182, 215));
        jLabel36.setText("Changement de la voix :");

        jRadioButton4.setText("NON");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jRadioButton5.setText("OUI");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setText("NON");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(3, 182, 215));
        jLabel37.setText("Apparition  du sang dans les crachats:");

        jRadioButton7.setText("OUI");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        fievre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        fievre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fievreActionPerformed(evt);
            }
        });

        pneu.setEditable(false);
        pneu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        btn_enoyer.setBackground(new java.awt.Color(3, 182, 215));
        btn_enoyer.setText("envoyer");
        btn_enoyer.setColorHover(new java.awt.Color(255, 255, 255));
        btn_enoyer.setColorTextHover(new java.awt.Color(3, 182, 215));
        btn_enoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enoyerActionPerformed(evt);
            }
        });

        num_doss.setEditable(false);
        num_doss.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(3, 182, 215));
        jLabel40.setText("Pneumologue réferant:");

        btn_vider.setBackground(new java.awt.Color(3, 182, 215));
        btn_vider.setText("vider");
        btn_vider.setColorHover(new java.awt.Color(255, 255, 255));
        btn_vider.setColorTextHover(new java.awt.Color(3, 182, 215));
        btn_vider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viderActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(3, 182, 215));
        jLabel42.setText("Oncologue réferant:");

        jRadioButton3.setText("OUI");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(3, 182, 215));
        jLabel26.setText("Saisie le :");

        app.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pas de probléme", "Probléme léger", "Probléme Moyen", "Probléme importat" }));
        app.setColorArrow(new java.awt.Color(3, 182, 215));
        app.setColorBorde(new java.awt.Color(3, 182, 215));
        app.setColorFondo(new java.awt.Color(3, 182, 215));
        app.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appActionPerformed(evt);
            }
        });

        essouf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pas de probléme", "Probléme léger", "Probléme Moyen", "Probléme importat" }));
        essouf.setColorArrow(new java.awt.Color(3, 182, 215));
        essouf.setColorBorde(new java.awt.Color(3, 182, 215));
        essouf.setColorFondo(new java.awt.Color(3, 182, 215));

        deprime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pas de probléme", "Probléme léger", "Probléme Moyen", "Probléme importat" }));
        deprime.setColorArrow(new java.awt.Color(3, 182, 215));
        deprime.setColorBorde(new java.awt.Color(3, 182, 215));
        deprime.setColorFondo(new java.awt.Color(3, 182, 215));

        toux.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pas de probléme", "Probléme léger", "Probléme Moyen", "Probléme importat" }));
        toux.setColorArrow(new java.awt.Color(3, 182, 215));
        toux.setColorBorde(new java.awt.Color(3, 182, 215));
        toux.setColorFondo(new java.awt.Color(3, 182, 215));

        faiblesse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pas de probléme", "Probléme léger", "Probléme Moyen", "Probléme importat" }));
        faiblesse.setColorArrow(new java.awt.Color(3, 182, 215));
        faiblesse.setColorBorde(new java.awt.Color(3, 182, 215));
        faiblesse.setColorFondo(new java.awt.Color(3, 182, 215));

        jRadioButton8.setText("NON");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(3, 182, 215));
        jLabel32.setText("Fievre :");

        jScrollPane8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commentaire libre(champs facultatif)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 182, 215))); // NOI18N

        comment.setColumns(20);
        comment.setRows(5);
        jScrollPane8.setViewportView(comment);

        jSeparator8.setForeground(new java.awt.Color(3, 182, 215));

        Date.setEditable(false);
        Date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        poids.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        onco.setEditable(false);
        onco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pneu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(onco, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel29))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(poids, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(toux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(essouf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(app, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deprime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faiblesse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel21))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(num_doss, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_vider, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btn_enoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addGap(147, 147, 147)
                                    .addComponent(fievre, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel34)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jRadioButton1)
                                            .addGap(18, 18, 18)
                                            .addComponent(jRadioButton2))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jRadioButton6))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jRadioButton8)
                                            .addGap(18, 18, 18)
                                            .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jRadioButton3)
                                            .addGap(18, 18, 18)
                                            .addComponent(jRadioButton4)))))
                            .addComponent(jLabel36))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(pneu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(num_doss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(onco, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(poids, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(app, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fievre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(essouf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(toux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(jRadioButton5)
                        .addComponent(jRadioButton6)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel29))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deprime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faiblesse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel34)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_enoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_vider, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        jScrollPane6.setViewportView(jPanel9);

        javax.swing.GroupLayout infos_suiviLayout = new javax.swing.GroupLayout(infos_suivi);
        infos_suivi.setLayout(infos_suiviLayout);
        infos_suiviLayout.setHorizontalGroup(
            infos_suiviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infos_suiviLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        infos_suiviLayout.setVerticalGroup(
            infos_suiviLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infos_suiviLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelSlider.add(infos_suivi, "card5");

        Demandes.setName("Demandes"); // NOI18N

        javax.swing.GroupLayout DemandesLayout = new javax.swing.GroupLayout(Demandes);
        Demandes.setLayout(DemandesLayout);
        DemandesLayout.setHorizontalGroup(
            DemandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        DemandesLayout.setVerticalGroup(
            DemandesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        PanelSlider.add(Demandes, "card4");

        Messagerie.setBackground(new java.awt.Color(255, 255, 255));
        Messagerie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 2));
        Messagerie.setForeground(new java.awt.Color(3, 182, 215));
        Messagerie.setName("Messagerie"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(99, 99, 99)
                                .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(path_attach, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel43))
                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel47))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des praticiens\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(3, 182, 215))); // NOI18N

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
        jScrollPane5.setViewportView(table_praticien);

        textsearch1.setForeground(new java.awt.Color(3, 182, 215));
        textsearch1.setBorderColor(new java.awt.Color(3, 182, 215));
        textsearch1.setBotonColor(new java.awt.Color(3, 182, 215));
        textsearch1.setPhColor(new java.awt.Color(3, 182, 215));
        textsearch1.setPlaceholder("nom / prenom/specialité");
        textsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textsearch1ActionPerformed(evt);
            }
        });
        textsearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textsearch1KeyReleased(evt);
            }
        });

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Find_User_Male_30px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textsearch1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout MessagerieLayout = new javax.swing.GroupLayout(Messagerie);
        Messagerie.setLayout(MessagerieLayout);
        MessagerieLayout.setHorizontalGroup(
            MessagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagerieLayout.createSequentialGroup()
                .addGroup(MessagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MessagerieLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MessagerieLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btn_envoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(btn_annuler)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        MessagerieLayout.setVerticalGroup(
            MessagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagerieLayout.createSequentialGroup()
                .addGroup(MessagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MessagerieLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(MessagerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_annuler)
                    .addComponent(btn_envoyer))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        PanelSlider.add(Messagerie, "card6");

        jPanel2.add(PanelSlider);
        PanelSlider.setBounds(390, 110, 930, 570);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1350, 790);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.hide();
      patient_login  pa = new  patient_login();
       pa.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_accueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accueilMouseClicked
        
    }//GEN-LAST:event_btn_accueilMouseClicked

    private void btn_accueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accueilActionPerformed
        if (!this.btn_accueil.isSelected()) {
            this.btn_rdv.setSelected(false);
            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(false);
           
            this.btn_accueil.setSelected(true);
             this.btn_ajout_infos.setSelected(false);

            this.PanelSlider.slidPanel(4,accueil, RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_accueilActionPerformed

    private void btn_profilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profilActionPerformed
        if (!this.btn_profil.isSelected()) {
             this.btn_rdv.setSelected(false);
             this.btn_profil.setSelected(true);
             this.btn_msg.setSelected(false);
            
             this.btn_accueil.setSelected(false);
             this.btn_ajout_infos.setSelected(false);

            this.PanelSlider.slidPanel(4,profil,RSPanelsSlider.direct.Right);
           
        }
    }//GEN-LAST:event_btn_profilActionPerformed

    private void btn_rdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rdvActionPerformed
        if (!this.btn_rdv.isSelected()) {
            this.btn_rdv.setSelected(true);
            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(false);
           
            this.btn_accueil.setSelected(false);
             this.btn_ajout_infos.setSelected(false);

            this.PanelSlider.slidPanel(4,Rendez_vous, RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_rdvActionPerformed

    private void btn_ajout_infosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ajout_infosActionPerformed
       if (!this.btn_ajout_infos.isSelected()) {
            this.btn_rdv.setSelected(false);
            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(false);
         
            this.btn_accueil.setSelected(false);
             this.btn_ajout_infos.setSelected(true);

            this.PanelSlider.slidPanel(3,infos_suivi, RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_ajout_infosActionPerformed

    private void btn_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_msgActionPerformed
         if (!this.btn_msg.isSelected()) {
            this.btn_rdv.setSelected(false);
            this.btn_profil.setSelected(false);
            this.btn_msg.setSelected(true);
         
            this.btn_accueil.setSelected(false);
             this.btn_ajout_infos.setSelected(false);

            this.PanelSlider.slidPanel(3,Messagerie, RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_msgActionPerformed

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
ScrolPane.setViewportView(Demande_RDV);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
ScrolPane.setViewportView(MES_RDVS);        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void douleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_douleurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_douleurActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
douleur.setText(Integer.toString(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1StateChanged

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        Rep4="OUI";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
      Rep1="OUI";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
       Rep2="OUI";
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
      Rep3="OUI";
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void fievreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fievreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fievreActionPerformed

    private void btn_enoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enoyerActionPerformed
        try {
            patient_login ph =new patient_login();
          String idef=  ph.recuperer();
            String rqt = " select * from patient where patient_identifiant = '" +idef+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
        
        
        inter_infos_suivi inf = new inter_infos_suivi();
            String s1=Date.getText();
            String s2=num_doss.getText();
            String s3=poids.getText();
            String s4=fievre.getText();
            String s5=app.getSelectedItem().toString();
            String s6=essouf.getSelectedItem().toString();
            String s7=toux.getSelectedItem().toString();
            String s8=deprime.getSelectedItem().toString();
            String s9=faiblesse.getSelectedItem().toString();
            String s10=app.getSelectedItem().toString();
            String s11=Rep1;
            String s12=Rep2;
            String s13=Rep3;
            String s14=Rep4;
            String s15=douleur.getText();
            String s16=comment.getText();
            String s18 = rs.getString("oncologue_ref");
            String s17 = rs.getString("pneumolgue_ref");
            infos_suivi infs= new infos_suivi(s2, s17, s18, s1,s3,s4,s5,s14,s7,s8,s6,s9,s15,s11, s13,s12,s16) ;
            inf.insertinfos_suivi(infs);
            
            
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(patient_home.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }//GEN-LAST:event_btn_enoyerActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        Rep1="NON";
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
       Rep2="NON";
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        Rep3="NON";
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       Rep4="NON";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btn_viderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viderActionPerformed
        vider();
    }//GEN-LAST:event_btn_viderActionPerformed

    private void appActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appActionPerformed

    private void num_doss2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num_doss2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_num_doss2ActionPerformed

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        
            inter_RDV rdv = new inter_RDV();
            praticien pra3 = (praticien)nom_prenom.getSelectedItem();
            String s1=num_doss2.getText();
            String s2 =((JTextField)date.getDateEditor().getUiComponent()).getText();
            String s3=heure.getText();
            String s4=raison.getText();
            String s5=date_envoie.getText();
            String s6=heure_envoie.getText();
            RDV R;
            R = new RDV(s1,s5,s6,pra3.getId(), s2, s3, s4);
            rdv.insertRDV(R);
          
    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void combo_specActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_specActionPerformed
        nom_prenom.removeAllItems();
        specialite=(String) combo_spec.getSelectedItem();
        System.out.println(specialite);
        this.initComboList2();
         
    }//GEN-LAST:event_combo_specActionPerformed

    private void combo_specMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_specMouseClicked
       
    }//GEN-LAST:event_combo_specMouseClicked

    private void combo_specMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_specMousePressed
      /*  specialite=(String) combo_spec.getSelectedItem();
         System.out.println(specialite);
         this.initComboList2();*/
    }//GEN-LAST:event_combo_specMousePressed

    private void combo_specMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_specMouseEntered
       
    }//GEN-LAST:event_combo_specMouseEntered

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

    private void date_envoieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_envoieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_envoieActionPerformed

    private void heure_envoieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heure_envoieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heure_envoieActionPerformed

    private void DRDVS_TABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DRDVS_TABLEMouseClicked
        afficher_detail_RDV(drdv);
        drdv.setVisible(true);
    }//GEN-LAST:event_DRDVS_TABLEMouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
        Affichertable_Mes_RDV();
    }//GEN-LAST:event_jLabel52MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
       new Modifier_patient_profil().setVisible(true);
       
       
    }//GEN-LAST:event_jLabel7MouseClicked

    private void rSButtonHover4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover4ActionPerformed

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        Afficher();
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
       JFileChooser chooser = new JFileChooser();
       chooser.showOpenDialog(null);
       File f =chooser.getSelectedFile();
       atachement_path=f.getAbsolutePath();
       path_attach.setText(atachement_path);
       
       
    }//GEN-LAST:event_jLabel41MouseClicked

    private void path_attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_path_attachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_path_attachActionPerformed

    private void table_praticienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_praticienMouseClicked
        Affichage_email();
    }//GEN-LAST:event_table_praticienMouseClicked

    private void textsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textsearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textsearch1ActionPerformed

    private void textsearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearch1KeyReleased
        recherche_praticien(this.textsearch1.getText());
    }//GEN-LAST:event_textsearch1KeyReleased

    private void rdvsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdvsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdvsearchActionPerformed

    private void rdvsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdvsearchKeyReleased
        recherche_RDV(this.rdvsearch.getText());
    }//GEN-LAST:event_rdvsearchKeyReleased

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
            java.util.logging.Logger.getLogger(patient_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patient_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patient_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patient_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patient_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro DRDVS_TABLE;
    private javax.swing.JTextField Date;
    private javax.swing.JPanel Demande_RDV;
    private javax.swing.JPanel Demandes;
    private javax.swing.JLabel Heure;
    private javax.swing.JPanel MES_RDVS;
    private javax.swing.JPanel Messagerie;
    private rojerusan.RSPanelsSlider PanelSlider;
    private javax.swing.JPanel Rendez_vous;
    private javax.swing.JScrollPane ScrolPane;
    private javax.swing.JPanel accueil;
    public javax.swing.JLabel address;
    public javax.swing.JLabel age;
    private rojerusan.RSComboMetro app;
    private rojerusan.RSButtonMetro btn_accueil;
    private rojerusan.RSButtonHover btn_ajout_infos;
    private javax.swing.JButton btn_annuler;
    private rojerusan.RSButtonHover btn_enoyer;
    private javax.swing.JButton btn_envoyer;
    private rojerusan.RSButtonHover btn_msg;
    private rojerusan.RSButtonHover btn_profil;
    private rojerusan.RSButtonHover btn_rdv;
    private rojerusan.RSButtonHover btn_vider;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    public javax.swing.JLabel code_assurance;
    public rojerusan.RSComboMetro combo_spec;
    private javax.swing.JTextArea comment;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField date_envoie;
    public javax.swing.JLabel date_naiss;
    public javax.swing.JLabel dateins;
    private rojerusan.RSComboMetro deprime;
    private javax.swing.JTextField douleur;
    public javax.swing.JLabel email;
    private rojerusan.RSComboMetro essouf;
    private rojerusan.RSComboMetro faiblesse;
    private javax.swing.JTextField fievre;
    private javax.swing.JTextField from;
    public javax.swing.JLabel gsang;
    private javax.swing.JTextField heure;
    private javax.swing.JTextField heure_envoie;
    public javax.swing.JLabel image;
    private javax.swing.JPanel infos_suivi;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSlider jSlider1;
    public javax.swing.JLabel mat;
    private javax.swing.JTextArea msg;
    private rojerusan.RSMetroTextFullPlaceHolder name;
    public javax.swing.JLabel nom;
    private rojerusan.RSComboMetro nom_prenom;
    private javax.swing.JLabel nompatient;
    private javax.swing.JTextField num_doss;
    private javax.swing.JTextField num_doss2;
    public javax.swing.JLabel numdoss;
    private javax.swing.JTextField onco;
    public javax.swing.JLabel onco2;
    private javax.swing.JPanel panelp;
    private rojerusan.RSMetroTextPassPlaceHolderView pass;
    private javax.swing.JTextField path_attach;
    private javax.swing.JPanel patient_infos;
    private javax.swing.JTextField pneu;
    public javax.swing.JLabel pneu2;
    private javax.swing.JTextField poids;
    public javax.swing.JLabel prenom;
    private javax.swing.JLabel prenompatient;
    private javax.swing.JPanel profil;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSButtonHover rSButtonHover2;
    private rojerusan.RSButtonHover rSButtonHover3;
    private rojerusan.RSButtonHover rSButtonHover4;
    private javax.swing.JTextArea raison;
    private rojerusan.RSMetroTextFullPlaceHolder rdvsearch;
    public javax.swing.JLabel sexe;
    public javax.swing.JLabel sit_fam;
    private rojerusan.RSMetroTextFullPlaceHolder subject;
    private rojerusan.RSTableMetro table_praticien;
    private rojerusan.RSMetroTextFullPlaceHolder textsearch1;
    public javax.swing.JLabel tlf;
    private rojerusan.RSMetroTextFullPlaceHolder to;
    private rojerusan.RSComboMetro toux;
    public javax.swing.JLabel wilaya;
    // End of variables declaration//GEN-END:variables
}

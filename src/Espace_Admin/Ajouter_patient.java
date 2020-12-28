/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espace_Admin;

import Espace_Patient.Modifier_patient_profil;
import Listes.praticien;
import Login.DB_Connexion;
import interfaces.inter_praticien;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import public_var.fonctions;
import static public_var.variables.*;

/**
 *
 * @author berich
 */
public class Ajouter_patient extends javax.swing.JFrame {

    private final DefaultListModel listModel = new DefaultListModel();
    private final DefaultComboBoxModel combModelpneu = new DefaultComboBoxModel();
    private final DefaultComboBoxModel combModelonco= new DefaultComboBoxModel();
    public String sexe;
     //Admin_accueil1 ac= new Admin_accueil1();
    public Ajouter_patient() {
    
        initComponents();
       cnx= DB_Connexion.Connexion();
     
        fonctions.DateSystem(date_insc);
       this.initComboList1();
        choix();
    }

   
    
     // choisir (ajouter  ou modifier)
      public void choix() {
      // Admin_accueil1 ad= new Admin_accueil1();
        String c = Admin_accueil1.result();
        if (c== "Modifier") {
           btn_update.setVisible(true);
           btn_vider.setVisible(false);
      
        } else if (c!= "Modifier") {
            btn_update.setVisible(false);
        }
        if (c == "ajouter") {
            btn_add.setVisible(true);

        } else if (c!= "ajouter") {
            btn_add.setVisible(false);
        }

    }
     // Ajouter patient 
    
    public void Add_patient()
    {
        //Admin_accueil1 ac= new Admin_accueil1();
       String situation_fam = (String) situationf.getSelectedItem();
      
       String gsanguin = (String) gsang.getSelectedItem();
       String Wilaya = (String) wilaya.getSelectedItem();
       praticien pneu_ref= (praticien) combo_pneu.getSelectedItem();
       praticien  onco_ref = (praticien)combo_onco.getSelectedItem();
       String Pneu=pneu_ref.getId();
       String Onco=onco_ref.getId();
      
       
        try {

            String rqt = "insert into patient (patient_identifiant,N_doss_med ,patient_password,patient_nom,patient_prenom,patient_date_naiss, patient_age ,patient_sexe,patient_address,patient_wilaya,patient_situation_famillial,patient_gsanguin,patient_email,patient_num_phone,patient_code_assurance,image,	date_insc,pneumolgue_ref,oncologue_ref) values (?,?,?,?,?,?,?,?,?,'"+Wilaya+"','"+situation_fam+"','"+gsanguin+"',?,?,?,?,?,'"+Pneu+"','"+Onco+"')";
            ps = cnx.prepareStatement(rqt);
            ps.setString(1, mat.getText());
            ps.setString(2, ndoss.getText());
            ps.setString(3, password.getText());
            ps.setString(4, nom.getText());
            ps.setString(5, prenom.getText());
            ps.setString(6, ((JTextField)date_naiss.getDateEditor().getUiComponent()).getText());
            ps.setString(7,age.getText());
            ps.setString(8,sexe);
            ps.setString(9, address.getText());
            ps.setString(10, email.getText());
            ps.setString(11, tel.getText());
            ps.setString(12, assurance.getText());
            ps.setString(13, chemin_img.getText());
            ps.setString(14, date_insc.getText());
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "Enregistrement avec succès");
            Admin_accueil1.Affichertable_patient();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    }
     //vider
     public void vider_champs() {
        try {
            mat.setText("");
            ndoss.setText("");
            nom.setText("");
            prenom.setText("");
            jRadioButtonH.setSelected(false);
            sexe="Homme";
            age.setText("");
            date_naiss.setDate(null);
            address.setText("");
            wilaya.setSelectedItem("1-Adrar");
            situationf.setSelectedItem("Célibataire");
            gsang.setSelectedItem("A+");
            assurance.setText("");
            email.setText("");
            tel.setText("");
            password.setText("");
            ImageIcon img = new ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/sem_foto.jpg"));
            picture.setIcon(img);
            chemin_img.setText("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
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
    
     //calculer age 
      public void calculer_age(){
          try {
            Date dact = new Date();
            DateFormat Format = new SimpleDateFormat("yyyy");
            String Date = Format.format(dact);
            String  sd= Date;

            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy", Locale.getDefault());
            String dt = sdformat.format(date_naiss.getDate());

            int date1 = Integer.parseInt(sd);
            int date2 = Integer.parseInt(dt);

            int r = (date1 - date2 );
            if (r<=0 || r>150)   {JOptionPane.showMessageDialog(null, "Date de naissance invalide");
             date_naiss.setDate(null);
             age.setText(" ");    
                    }
           
            else{
            String R = String.valueOf(r);
            age.setText(R);}

        } catch (Exception e) {
          System.out.println(e);
                
        }


    }                   
      public void  generer_id_patient(){
      String phone= tel.getText();
      String g="P."+phone+"";
      mat.setText(g); 
      }
      
      public void  generer_Num_doss(){
      Calendar Cal = new GregorianCalendar();
      String phone= tel.getText();
      int annee = Cal.get(Calendar.YEAR);
      String m ="DM."+phone+"/"+annee+"";
      ndoss.setText(m); 
      }
       
      
      
      
      
       //Modifier patient
    public void update_patient(){
        //Admin_accueil1 ac= new Admin_accueil1();
       String situation_fam = (String) situationf.getSelectedItem();
       String gsanguin = (String) gsang.getSelectedItem();
       String Wilaya = (String) wilaya.getSelectedItem();
       praticien pneu_ref= (praticien) combo_pneu.getSelectedItem();
       praticien  onco_ref = (praticien)combo_onco.getSelectedItem();
       String Pneu=pneu_ref.getId();
       String Onco=onco_ref.getId();
       String m = ndoss.getText();
       String rqt = "update patient  set patient_password=?,patient_nom=?,patient_prenom=?,patient_date_naiss=?, patient_age=? ,patient_sexe=?,patient_address=?,patient_wilaya=?,patient_situation_famillial=?,patient_gsanguin=?,patient_email=?,patient_num_phone=?,patient_code_assurance=?,image=? ,pneumolgue_ref=?,oncologue_ref=? where N_doss_med= '"+m+"' ";
       try {
            ps = cnx.prepareStatement(rqt);
            ps.setString(1, password.getText());
            ps.setString(2, nom.getText());
            ps.setString(3, prenom.getText());
            ps.setString(4, ((JTextField)date_naiss.getDateEditor().getUiComponent()).getText());
            ps.setString(5,age.getText());
            ps.setString(6,sexe);
            ps.setString(7, address.getText());
            ps.setString(8,Wilaya);
            ps.setString(9,situation_fam );
            ps.setString(10,gsanguin);
            ps.setString(11, email.getText());
            ps.setString(12, tel.getText());
            ps.setString(13, assurance.getText());
            ps.setString(14, chemin_img.getText());
            ps.setString(15,Pneu);
            ps.setString(16,Onco);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modification effectuée");
            Admin_accueil1.Affichertable_patient();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
   //Afficher les infos
  
    
    public void Afficher_infos(){
        //Admin_accueil1 info = new Admin_accueil1();
        try {
            String m = Admin_accueil1.tableresult();
            String rqt = " select * from patient where 	N_doss_med = '" +m+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();

            if (rs.next()) {
                String s1 = rs.getString("patient_identifiant");
                mat.setText(s1);
                String s2 = rs.getString("patient_nom");
                nom.setText(s2);
                String s3 = rs.getString("patient_prenom");
                prenom.setText(s3);
                Date s4 = rs.getDate("patient_date_naiss");
                date_naiss.setDate(s4);
                String s5 = rs.getString("patient_age");
                age.setText(s5);
                String s6 = rs.getString("patient_sexe");
                String S=s6;
                if (S.equals("Homme")) {
                    jRadioButtonH.setSelected(true);
                    sexe = "Homme";
                } else if (S.equals("Femme")) {
                    jRadioButtonF.setSelected(true);
                    sexe = "Femme";
                }
                   String s7 = rs.getString("patient_gsanguin");
                switch(s7){
                    case  "A+" :
                    gsang.setSelectedIndex(0);
                    break;
                    case  "A-":
                     gsang.setSelectedIndex(1);
                    break;
                    case "B+":
                     gsang.setSelectedIndex(2);
                    break;
                    case "B-":
                      gsang.setSelectedIndex(3);
                     break;
                     
                 case "AB+":
                     gsang.setSelectedIndex(4);
                    break;
                    case "AB-":
                    gsang.setSelectedIndex(5);
                    break;
                    case "O+":
                     gsang.setSelectedIndex(6);
                    break;
                    case "O-":
                     gsang.setSelectedIndex(4);
                    break; 
                    
                }
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
                     case "16-Alger":wilaya.setSelectedIndex(15); break;
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
                           case "36-El-Taref":wilaya.setSelectedIndex(35); break;
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
                String s13 = rs.getString("patient_code_assurance");
                assurance.setText(s13);
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
               
                date_insc.setVisible(false);
                labeldate.setVisible(false);
                String s19 = rs.getString("N_doss_med");
                ndoss.setText(s19);
             inter_praticien inter_pra = new inter_praticien();
                java.util.List<praticien> pn= inter_pra.selectoncologue();
                java.util.List<praticien> pn2= inter_pra.selectpneumologue();
                String s20 = rs.getString("pneumolgue_ref");
                 for(int i=0;i<pn2.size();i++){
                   String p=(pn2.get(i)).getId();
                if((s20).equals(p))  { combo_pneu.setSelectedIndex(i) ;}
           
                }
                String s21 = rs.getString("oncologue_ref");
                for(int i=0;i<pn.size();i++){
                   String p=(pn.get(i)).getId();
                if((s21).equals(p))  { combo_onco.setSelectedIndex(i); }
           
                }
                
             
            }
                ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    
    
    //--------------------------
    public void initComboList1(){
        inter_praticien inter_pra = new inter_praticien();
        java.util.List<praticien> pn= inter_pra.selectpneumologue();
        for (Object m : pn) {
            praticien  p = (praticien)m;
            combModelpneu.addElement(p);
        }
        this.combo_pneu.setModel(combModelpneu);
        
         java.util.List<praticien> onc= inter_pra.selectoncologue();
         for (Object O : onc) {
            praticien  o = (praticien)O;
            combModelonco.addElement(o);
        }
        this.combo_onco.setModel(combModelonco);
      
      
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        jRadioButtonH = new javax.swing.JRadioButton();
        jRadioButtonF = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        assurance = new javax.swing.JTextField();
        date_naiss = new com.toedter.calendar.JDateChooser();
        label = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        situationf = new rojerusan.RSComboMetro();
        gsang = new rojerusan.RSComboMetro();
        wilaya = new rojerusan.RSComboMetro();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        picture = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        chemin_img = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        mat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        combo_pneu = new rojerusan.RSComboMetro();
        combo_onco = new rojerusan.RSComboMetro();
        jLabel17 = new javax.swing.JLabel();
        ndoss = new javax.swing.JTextField();
        btn_update = new rojerusan.RSButtonHover();
        btn_add = new rojerusan.RSButtonHover();
        btn_vider = new rojerusan.RSButtonHover();
        labeldate = new javax.swing.JLabel();
        date_insc = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(3, 182, 215));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations Patient", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andalus", 1, 18), new java.awt.Color(3, 182, 215))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(44, 62, 80));
        jLabel1.setText("Nom :");

        jLabel2.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 62, 80));
        jLabel2.setText("Prenom :");

        jLabel3.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 62, 80));
        jLabel3.setText("Date De Naissance :");

        jLabel4.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(44, 62, 80));
        jLabel4.setText("Sexe :");

        jLabel5.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(44, 62, 80));
        jLabel5.setText("Situation Familliale :");

        jLabel6.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(44, 62, 80));
        jLabel6.setText("Groupe Sanguin :");

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

        nom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });

        prenom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        tel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telKeyTyped(evt);
            }
        });

        buttonGroup1.add(jRadioButtonH);
        jRadioButtonH.setText("Homme");
        jRadioButtonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonHActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonF);
        jRadioButtonF.setText("Femme");
        jRadioButtonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(44, 62, 80));
        jLabel16.setText("Code d'assurance :");

        assurance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        date_naiss.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        date_naiss.setDateFormatString("YYY-MM-dd");

        label.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        label.setForeground(new java.awt.Color(44, 62, 80));
        label.setText("Age :");

        age.setEditable(false);
        age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        age.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ageMouseEntered(evt);
            }
        });
        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });

        situationf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Célibataire", "Marié(e)" }));
        situationf.setColorArrow(new java.awt.Color(3, 182, 215));
        situationf.setColorFondo(new java.awt.Color(3, 182, 215));

        gsang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        wilaya.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1-Adrar", "2-Chlef", "3-Laghouat", "4-Oum El-Bouaghi", "5-Batna", "6-Béjaïa", "7-Biskra", "8-Béchar", "9-Blida", "10-Bouira", "11-Tamanrasset", "12-Tébessa", "13-Tlemcen", "14-Tiaret", "15-Tizi Ouzou", "16-Alger", "17-Djelfa", "18-Jijel", "19-Sétif", "20-Saida", "21-Skikda", "22-Sidi Bel Abbes", "23-Annaba", "24-Guelma", "25-Constantine", "26-Médéa", "27-Mostaganem", "28-M'Sila", "29-Mascara", "30-Ouargla", "31-Oran", "32-El-Bayadh", "33-Illizi", "34-Bord-Bou-Arréridj", "35-Boumerdès", "36-El-Taref", "37-Tindouf", "38-Tissemsilt", "39-El Oued", "40-Khenchela", "41-Souk Ahras", "42-Tipaza", "43-Mila", "44-Aïn Defla", "45-Naâma", "46-Aïn Témouchent", "47-Ghardaïa", "48-Relizane" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(assurance, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nom)
                                            .addComponent(date_naiss, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                            .addComponent(age))
                                        .addComponent(prenom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jRadioButtonH)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                        .addComponent(jRadioButtonF, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(gsang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(situationf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(wilaya, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date_naiss, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonH)
                            .addComponent(jRadioButtonF))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(situationf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(gsang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(assurance, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wilaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        jPanel2.setBackground(new Color(255,255,255,100));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 40, 500, 620);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Photo Patient", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andalus", 1, 18), new java.awt.Color(3, 182, 215))); // NOI18N

        picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Espace_Admin/sem_foto.jpg"))); // NOI18N
        jScrollPane1.setViewportView(picture);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new Color(255,255,255,100));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(540, 40, 430, 250);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        chemin_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chemin_imgActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(chemin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chemin_img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new Color(255,255,255,120));

        jPanel1.add(jPanel4);
        jPanel4.setBounds(540, 290, 430, 50);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(44, 62, 80));
        jLabel13.setText("Mot De Passe :");

        jLabel15.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(44, 62, 80));
        jLabel15.setText("Identifiant:");
        jLabel15.setToolTipText("");

        mat.setEditable(false);
        mat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                matMouseEntered(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(44, 62, 80));
        jLabel11.setText("Pneumologue Référant :");

        jLabel12.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(44, 62, 80));
        jLabel12.setText("Oncologue Référant :");

        combo_pneu.setColorArrow(new java.awt.Color(3, 182, 215));
        combo_pneu.setColorFondo(new java.awt.Color(3, 182, 215));

        combo_onco.setColorArrow(new java.awt.Color(3, 182, 215));
        combo_onco.setColorFondo(new java.awt.Color(3, 182, 215));

        jLabel17.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(44, 62, 80));
        jLabel17.setText("N° dossier médical:");
        jLabel17.setToolTipText("");

        ndoss.setEditable(false);
        ndoss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ndossMouseEntered(evt);
            }
        });
        ndoss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ndossActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_onco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_pneu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(100, 100, 100)
                        .addComponent(password))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mat, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ndoss, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(ndoss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(combo_pneu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_onco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(29, 29, 29))
        );

        jPanel5.setBackground(new Color(255,255,255,120));

        jPanel1.add(jPanel5);
        jPanel5.setBounds(540, 350, 430, 260);

        btn_update.setBackground(new java.awt.Color(3, 182, 215));
        btn_update.setText("Modifier");
        btn_update.setColorHover(new java.awt.Color(255, 255, 255));
        btn_update.setColorTextHover(new java.awt.Color(3, 182, 215));
        btn_update.setFocusPainted(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel1.add(btn_update);
        btn_update.setBounds(700, 620, 120, 40);

        btn_add.setBackground(new java.awt.Color(3, 182, 215));
        btn_add.setText("Ajouter");
        btn_add.setColorHover(new java.awt.Color(255, 255, 255));
        btn_add.setColorTextHover(new java.awt.Color(3, 182, 215));
        btn_add.setFocusPainted(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add);
        btn_add.setBounds(850, 620, 120, 40);

        btn_vider.setBackground(new java.awt.Color(3, 182, 215));
        btn_vider.setText("Vider");
        btn_vider.setColorHover(new java.awt.Color(255, 255, 255));
        btn_vider.setColorTextHover(new java.awt.Color(3, 182, 215));
        btn_vider.setFocusPainted(false);
        btn_vider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viderActionPerformed(evt);
            }
        });
        jPanel1.add(btn_vider);
        btn_vider.setBounds(540, 620, 120, 40);

        labeldate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labeldate.setForeground(new java.awt.Color(44, 62, 80));
        labeldate.setText("Date d'inscription :");
        jPanel1.add(labeldate);
        labeldate.setBounds(20, 0, 140, 30);

        date_insc.setEditable(false);
        jPanel1.add(date_insc);
        date_insc.setBounds(150, 0, 160, 30);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/backg1.jpeg"))); // NOI18N
        jPanel1.add(jLabel14);
        jLabel14.setBounds(0, 0, 1110, 1040);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1127, 716));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void chemin_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chemin_imgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chemin_imgActionPerformed

    private void jRadioButtonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonHActionPerformed
        sexe="Homme";
    }//GEN-LAST:event_jRadioButtonHActionPerformed

    private void jRadioButtonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFActionPerformed
        sexe="Femme";
    }//GEN-LAST:event_jRadioButtonFActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void ageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ageMouseEntered
    calculer_age();        
        
                      

    }//GEN-LAST:event_ageMouseEntered

    private void telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telKeyTyped
       //  pour taper que des chiffres
         char tlf = evt.getKeyChar();
          if (!(Character.isDigit(tlf) || (tlf == KeyEvent.VK_BACK_SPACE) || (tlf == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
  
    }//GEN-LAST:event_telKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      insert_image();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       update_patient();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
         Add_patient();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_viderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viderActionPerformed
       vider_champs();
    }//GEN-LAST:event_btn_viderActionPerformed

    private void matMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matMouseEntered
       generer_id_patient();
    }//GEN-LAST:event_matMouseEntered

    private void ndossMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ndossMouseEntered
        generer_Num_doss();
    }//GEN-LAST:event_ndossMouseEntered

    private void ndossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ndossActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ndossActionPerformed

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
                
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Ajouter_patient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Ajouter_patient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Ajouter_patient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Ajouter_patient.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Modifier_patient_profil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JTextField assurance;
    private rojerusan.RSButtonHover btn_add;
    private rojerusan.RSButtonHover btn_update;
    private rojerusan.RSButtonHover btn_vider;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField chemin_img;
    private rojerusan.RSComboMetro combo_onco;
    private rojerusan.RSComboMetro combo_pneu;
    private javax.swing.JTextField date_insc;
    private com.toedter.calendar.JDateChooser date_naiss;
    private javax.swing.JTextField email;
    private rojerusan.RSComboMetro gsang;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButtonF;
    private javax.swing.JRadioButton jRadioButtonH;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labeldate;
    private javax.swing.JTextField mat;
    private javax.swing.JTextField ndoss;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField password;
    private javax.swing.JLabel picture;
    private javax.swing.JTextField prenom;
    private rojerusan.RSComboMetro situationf;
    private javax.swing.JTextField tel;
    private rojerusan.RSComboMetro wilaya;
    // End of variables declaration//GEN-END:variables
}

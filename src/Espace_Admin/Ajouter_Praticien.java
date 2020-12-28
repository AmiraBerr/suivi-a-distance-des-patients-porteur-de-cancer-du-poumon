/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espace_Admin;

import Espace_praticien.labo_analyses;
import Espace_praticien.medecin_Ref_local;
import Espace_praticien.pharmacien;
import Espace_praticien.radiologue;
import Login.DB_Connexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static public_var.variables.*;

/**
 *
 * @author BSR
 */



public class Ajouter_Praticien extends javax.swing.JFrame {

        public Connection cnx=null;
        public PreparedStatement ps=null;
        public  ResultSet rs=null;
        public String type;
         //Admin_accueil1 ac= new Admin_accueil1();
        public Ajouter_Praticien() {
        initComponents();
       cnx= DB_Connexion.Connexion();
        spec.setVisible(false);
        spec1.setVisible(false);
        choix1();
      
    }
    
        // choisir (ajouter  ou modifier)
      public void choix1() {
          //Admin_accueil1 ac= new Admin_accueil1();
        String c = Admin_accueil1.result();
        if (c== "Modifier") {
           btn_update.setVisible(true);
      
        } else if (c!= "Modifier") {
             btn_update.setVisible(false);
        }
        if (c == "ajouter") {
            btn_add.setVisible(true);

        } else if (c!= "ajouter") {
            btn_add.setVisible(false);
        }

    }

    //méthod ajouter praticien
     public void Add_praticien()
    {
        //Admin_accueil1 ac= new Admin_accueil1();
         String specialite1 = (String) spec.getSelectedItem();
         String specialite2 = (String) spec1.getSelectedItem();
        try {
/*
             if (type=="Centre Spécialisé"){
            String rqt = "insert into praticien (praticien_identifiant,praticien_password,praticien_nom,praticien_prenom,praticien_type,praticien_specialite, praticien_email,praticien_num_phone) values (?,?,?,?,?,'"+specialite1+"',?,?)";   
            pc = cnx.prepareStatement(rqt);  
            }
            if (type=="Local"){
               
            String rqt = "insert into praticien (praticien_identifiant,praticien_password,praticien_nom,praticien_prenom,praticien_type,praticien_specialite, praticien_email,praticien_num_phone) values (?,?,?,?,?,'"+specialite2+"',?,?)";   
           pc = cnx.prepareStatement(rqt);  
          
            }
            */
            if (jRadioButtonS.isSelected()){
            String rqt = "insert into praticien (praticien_identifiant,praticien_password,praticien_nom,praticien_prenom,praticien_type,praticien_specialite, praticien_email,praticien_num_phone,address) values (?,?,?,?,?,'"+specialite1+"',?,?,?)";   
            ps = cnx.prepareStatement(rqt);  
            ps.setString(1, id.getText());
            ps.setString(2, pass.getText());
            ps.setString(3, nom.getText());
            ps.setString(4, prenom.getText());
            ps.setString(5,type);
            ps.setString(6, email.getText());
            ps.setString(7,tel.getText()); 
            ps.setString(8,address.getText()); 
           
            }
          if (jRadioButtonL.isSelected()){
               
            String rqt = "insert into praticien (praticien_identifiant,praticien_password,praticien_nom,praticien_prenom,praticien_type,praticien_specialite, praticien_email,praticien_num_phone,address) values (?,?,?,?,?,'"+specialite2+"',?,?,?)";   
            ps = cnx.prepareStatement(rqt);  
            ps.setString(1, id.getText());
            ps.setString(2, pass.getText());
            ps.setString(3, nom.getText());
            ps.setString(4, prenom.getText());
            ps.setString(5,type);
            ps.setString(6, email.getText());
            ps.setString(7,tel.getText()); 
            ps.setString(8,address.getText());
          
            }
            
         
            ps.execute();
            JOptionPane.showMessageDialog(null, "Enregistrement avec succès");
           Admin_accueil1.Affichertable_praticien();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
        }
    }
     //method pour vider les champs
     public void vider_champs(){
           try {
   
            id.setText("");
            nom.setText("");
            prenom.setText("");
            jRadioButtonS.setSelected(false);
            jRadioButtonL.setSelected(false);
            address.setText("");
            email.setText("");
            tel.setText("");
            pass.setText("");
          
        } catch (Exception e) {
            System.out.println(e);
        }
         
    
     }

     
        //Modifier praticien
    public void update_praticien(){
      //Admin_accueil1 ac= new Admin_accueil1();
       String spece = (String) spec.getSelectedItem();
       String spece2 = (String) spec1.getSelectedItem();

       String idf = id.getText();
        String rqt = "update praticien  set praticien_identifiant=?   ,praticien_password=?,praticien_nom=?,praticien_prenom=?,praticien_type=?,praticien_specialite=? ,praticien_email=?,praticien_num_phone=?,address=? where praticien_identifiant= '"+idf+"' ";
        try {
            ps = cnx.prepareStatement(rqt);
            ps.setString(1, id.getText());
            ps.setString(2, pass.getText());
            ps.setString(3, nom.getText());
            ps.setString(4, prenom.getText());
            ps.setString(5,type);
            if(type.equals("Local")) {  ps.setString(6,spece2 ); }
            else{ ps.setString(6,spece );}
            ps.setString(7, email.getText());
            ps.setString(8, tel.getText());
            ps.setString(9, address.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modification effectuée");
            Admin_accueil1.Affichertable_praticien();
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
     
     //Afficher les infos
  
    
    public void Afficher_infos(){
       
        // Admin_accueil1 ac= new Admin_accueil1();
        try {
            String m =Admin_accueil1.tableresult();
            String rqt = " select * from praticien where praticien_identifiant = '" +m+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();

            if (rs.next()) {
                String s1 = rs.getString("praticien_identifiant");
                id.setText(s1);
                String s2 = rs.getString("praticien_password");
                pass.setText(s2);
                String s3 = rs.getString("praticien_nom");
                nom.setText(s3);
                String s4 = rs.getString("praticien_prenom");
                prenom.setText(s4);
                String s = rs.getString("address");
                address.setText(s);
                
                String s5 = rs.getString("praticien_type");
                String S=s5;
                if (S.equals("Local")) {
                    jRadioButtonL.setSelected(true);
                    type = "Local";
                } else if (S.equals("Centre Spécialisé")) {
                    jRadioButtonS.setSelected(true);
                    type= "Centre Spécialisé";
                }
               
                
                
                   String s6 = rs.getString("praticien_specialite");
                switch(s6){
                    case  "service de pneumologie" :
                    spec.setSelectedIndex(0);
                    break;
                    case  "service d’oncologie":
                    spec.setSelectedIndex(1);
                    break;
                    case "service de  radiologie":
                    spec.setSelectedIndex(2);
                    break;
                    case "service anatomie  pathologique":
                     spec.setSelectedIndex(3);
                     break;
                     
                 case "service de radiothérapie":
                    spec.setSelectedIndex(4);
                    break;
                    case "service de chirurgie thoracique":
                    spec.setSelectedIndex(5);
                    break;
                    case "Laboratoire d’analyses médicales":
                    spec.setSelectedIndex(6);
                    spec1.setSelectedIndex(2);
                    break;
                    case "pharmacie":
                    spec.setSelectedIndex(4);
                     spec1.setSelectedIndex(3);
                    break; 
                    
                 case "Médecin référant local":
                    spec1.setSelectedIndex(0);
                    break;
                    case "radiologue":
                    spec1.setSelectedIndex(1);
                    break;
                  
                    
                    
                    
                    
                }
              
               
                String s11 = rs.getString("praticien_email");
                email.setText(s11);
                String s12 = rs.getString("praticien_num_phone");
                tel.setText(s12);
                
            }
                ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    
    public void  generer_id_praticien(){
      String specialite1= (String) spec.getSelectedItem(); 
      String specialite2= (String) spec1.getSelectedItem();
      String phone= tel.getText();
      if(type=="Local"){
         if (specialite2.equals("Médecin référant local")) {String g ="LM."+phone+""; id.setText(g); }
         if (specialite2.equals("radiologue")) {String g="LR."+phone+""; id.setText(g); }
         if (specialite2.equals("Laboratoire d’analyses médicales")) {String g="LA."+phone+""; id.setText(g); }
         if (specialite2.equals("pharmacien") ) {String g="LP."+phone+""; id.setText(g); }
      }
      else{
          
          
         if (specialite1.equals("pneumologue")) {String g="SN."+phone+""; id.setText(g); }
         if (specialite1.equals("oncologue")) {String g="SO."+phone+""; id.setText(g); }
         if (specialite1.equals("pathologiste")) {String g="ST."+phone+""; id.setText(g); }
         if (specialite1.equals("radiologue")) {String g="SR."+phone+""; id.setText(g); }
         if (specialite1.equals("oncologue radiothérapeute"))  {String g="SD."+phone+""; id.setText(g); }
         if (specialite1.equals("chirurgien thoracique")) {String g="SC."+phone+""; id.setText(g); }
         if (specialite1.equals("Laboratoire d’analyses médicales")){String g="SA."+phone+""; id.setText(g); }
         if (specialite1.equals("pharmacien") ) {String g="SP."+phone+""; id.setText(g); }
      }
      
      }
     
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_vider = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jRadioButtonS = new javax.swing.JRadioButton();
        jRadioButtonL = new javax.swing.JRadioButton();
        spec = new javax.swing.JComboBox<>();
        spec1 = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 718));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(3, 182, 215));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations Praticiens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andalus", 1, 18), new java.awt.Color(3, 182, 215))); // NOI18N
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 620));

        jLabel2.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(44, 62, 80));
        jLabel2.setText("Nom:");

        jLabel3.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(44, 62, 80));
        jLabel3.setText("Prénom:");

        jLabel4.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(44, 62, 80));

        jLabel5.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(44, 62, 80));
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(44, 62, 80));
        jLabel6.setText("Téléphone:");

        nom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        prenom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomActionPerformed(evt);
            }
        });

        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        tel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(3, 182, 215));

        jLabel7.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(44, 62, 80));
        jLabel7.setText("Identifiant:");

        jLabel8.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(44, 62, 80));
        jLabel8.setText("Mot De Passe:");

        id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                idMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pass)
                        .addGap(2, 2, 2)))
                .addGap(32, 32, 32))
        );

        btn_add.setBackground(new java.awt.Color(3, 182, 215));
        btn_add.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        btn_add.setText("Ajouter");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_vider.setBackground(new java.awt.Color(3, 182, 215));
        btn_vider.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        btn_vider.setText("Vider");
        btn_vider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viderActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(44, 62, 80));
        jLabel9.setText("Type & Spécialité: :");

        jRadioButtonS.setBackground(new java.awt.Color(3, 182, 215));
        buttonGroup1.add(jRadioButtonS);
        jRadioButtonS.setText("Centre Spécialisé");
        jRadioButtonS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 211, 182)));
        jRadioButtonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSActionPerformed(evt);
            }
        });

        jRadioButtonL.setBackground(new java.awt.Color(3, 182, 215));
        buttonGroup1.add(jRadioButtonL);
        jRadioButtonL.setText("Local");
        jRadioButtonL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 211, 182)));
        jRadioButtonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLActionPerformed(evt);
            }
        });

        spec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pneumologue", "oncologue", "radiologue", "pathologiste", "oncologue radiothérapeute", "chirurgien thoracique", "Laboratoire d’analyses médicales", "pharmacien" }));
        spec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        spec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specActionPerformed(evt);
            }
        });

        spec1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Médecin référant local", "radiologue", "Laboratoire d’analyses médicales", "pharmacien" }));
        spec1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        spec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spec1ActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(3, 182, 215));
        btn_update.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        btn_update.setText("Modifier");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(44, 62, 80));
        jLabel10.setText("Address:");

        address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(btn_vider, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                        .addComponent(jRadioButtonS)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                                    .addComponent(jRadioButtonL, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(85, 85, 85))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(prenom))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(nom))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(spec1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 19, Short.MAX_VALUE)
                                        .addComponent(spec, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(340, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonS, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spec, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spec1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_vider)
                    .addComponent(btn_update))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(254, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addGap(301, 301, 301)))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(130, 20, 490, 620);

        jLabel1.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.interiorBackground"));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/bgpatttttttttt.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-80, -180, 1310, 1050);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(676, 687));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void spec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spec1ActionPerformed

    }//GEN-LAST:event_spec1ActionPerformed

    private void specActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specActionPerformed

    }//GEN-LAST:event_specActionPerformed

    private void jRadioButtonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLActionPerformed
       type="Local";
        if (jRadioButtonL.isSelected()) {spec1.setVisible(true);  spec.setVisible(false);}
    }//GEN-LAST:event_jRadioButtonLActionPerformed

    private void jRadioButtonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSActionPerformed
        type="Centre Spécialisé";
        if (jRadioButtonS.isSelected()) {spec.setVisible(true); spec1.setVisible(false);}
    }//GEN-LAST:event_jRadioButtonSActionPerformed

    private void btn_viderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viderActionPerformed
    vider_champs();
    }//GEN-LAST:event_btn_viderActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        Add_praticien();
    }//GEN-LAST:event_btn_addActionPerformed

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       update_praticien();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void idMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idMouseEntered
       generer_id_praticien();
    }//GEN-LAST:event_idMouseEntered

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telKeyTyped
         //  pour taper que des chiffres
         //  pour taper que des chiffres
         char tlf = evt.getKeyChar();
          if (!(Character.isDigit(tlf) || (tlf == KeyEvent.VK_BACK_SPACE) || (tlf == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_telKeyTyped

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
            java.util.logging.Logger.getLogger(Ajouter_Praticien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajouter_Praticien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajouter_Praticien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajouter_Praticien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ajouter_Praticien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_vider;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField email;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JRadioButton jRadioButtonL;
    private javax.swing.JRadioButton jRadioButtonS;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField prenom;
    private javax.swing.JComboBox<String> spec;
    private javax.swing.JComboBox<String> spec1;
    private javax.swing.JTextField tel;
    // End of variables declaration//GEN-END:variables
}

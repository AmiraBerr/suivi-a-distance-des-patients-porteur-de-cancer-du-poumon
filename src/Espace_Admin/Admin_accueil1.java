/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Espace_Admin;
import Listes.praticien;
import Login.*;
import interfaces.inter_praticien;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import net.proteanit.sql.DbUtils;
import static public_var.variables.*;
import rojerusan.RSPanelsSlider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import public_var.*;
/**
 *
 * @author berich
 */
public class Admin_accueil1 extends javax.swing.JFrame {
     //DECLARATION:
   
    
   static  String  M ;
   static String T;
   int position;
   static String C = "";
    
    //instances
    infos_patient inf=new  infos_patient();
    
    
    
    public Admin_accueil1() {
        initComponents();
        cnx= DB_Connexion.Connexion();
        this.MenuP.add(pn_Menup);
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        fonctions.HeureSystem(Heure);
        Affichertable_patient();
        Affichertable_praticien();
        
    }
   
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuP = new rojerusan.RSPopuMenu();
        pn_Menup = new javax.swing.JPanel();
        btn_modifier = new rojerusan.RSButtonPane();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btn_supprimer = new rojerusan.RSButtonPane();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        voir = new rojerusan.RSButtonPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MenuPra = new rojerusan.RSPopuMenu();
        pn_Menupra = new javax.swing.JPanel();
        btn_modifier_pra = new rojerusan.RSButtonPane();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btn_supprimer_pra = new rojerusan.RSButtonPane();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btn_accueil = new rojerusan.RSButtonMetro();
        btn_G_patients = new rojerusan.RSButtonHover();
        btn_G_praticiens = new rojerusan.RSButtonHover();
        PanelSlider = new rojerusan.RSPanelsSlider();
        bgpanel = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        Heure = new javax.swing.JLabel();
        Gestion_Patients = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patients_table = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int d,int c){
                return false;
            }

        };
        jButton5 = new javax.swing.JButton();
        rSLabelCircleImage2 = new rojerusan.RSLabelCircleImage();
        textsearch = new rojerusan.RSMetroTextFullPlaceHolder();
        jLabel24 = new javax.swing.JLabel();
        btn_ajouter = new rojerusan.RSButtonIconI();
        jLabel25 = new javax.swing.JLabel();
        Gestion_Praticiens = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_praticien = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int a,int b){
                return false;
            }};
            jPanel12 = new javax.swing.JPanel();
            jLabel23 = new javax.swing.JLabel();
            jLabel30 = new javax.swing.JLabel();
            jLabel31 = new javax.swing.JLabel();
            jLabel32 = new javax.swing.JLabel();
            jLabel33 = new javax.swing.JLabel();
            prenom = new javax.swing.JTextField();
            email = new javax.swing.JTextField();
            nom = new javax.swing.JTextField();
            type = new javax.swing.JTextField();
            spec = new javax.swing.JTextField();
            label = new javax.swing.JLabel();
            id = new javax.swing.JTextField();
            jLabel39 = new javax.swing.JLabel();
            tel = new javax.swing.JTextField();
            jSeparator2 = new javax.swing.JSeparator();
            jSeparator4 = new javax.swing.JSeparator();
            jSeparator5 = new javax.swing.JSeparator();
            jSeparator6 = new javax.swing.JSeparator();
            jSeparator7 = new javax.swing.JSeparator();
            jSeparator8 = new javax.swing.JSeparator();
            jSeparator9 = new javax.swing.JSeparator();
            jLabel40 = new javax.swing.JLabel();
            address = new javax.swing.JTextField();
            jButton4 = new javax.swing.JButton();
            btn_modifier1 = new javax.swing.JButton();
            btn_supp = new javax.swing.JButton();
            jLabel17 = new javax.swing.JLabel();
            textsearch1 = new rojerusan.RSMetroTextFullPlaceHolder();
            rSButtonCircle3 = new rojerusan.RSButtonCircle();
            rSButtonCircle2 = new rojerusan.RSButtonCircle();
            rSButtonCircle1 = new rojerusan.RSButtonCircle();
            rSButtonCircle4 = new rojerusan.RSButtonCircle();
            rSButtonCircle5 = new rojerusan.RSButtonCircle();
            jLabel36 = new javax.swing.JLabel();

            pn_Menup.setBackground(new java.awt.Color(255, 255, 255));
            pn_Menup.setPreferredSize(new java.awt.Dimension(180, 80));

            btn_modifier.setBackground(new java.awt.Color(255, 255, 255));
            btn_modifier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
            btn_modifier.setColorHover(new java.awt.Color(204, 204, 255));
            btn_modifier.setColorNormal(new java.awt.Color(255, 255, 255));
            btn_modifier.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    btn_modifierMousePressed(evt);
                }
            });

            jLabel27.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel27.setForeground(new java.awt.Color(3, 182, 215));
            jLabel27.setText("Modifier");

            jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Edit_20px_6.png"))); // NOI18N

            javax.swing.GroupLayout btn_modifierLayout = new javax.swing.GroupLayout(btn_modifier);
            btn_modifier.setLayout(btn_modifierLayout);
            btn_modifierLayout.setHorizontalGroup(
                btn_modifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_modifierLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE))
            );
            btn_modifierLayout.setVerticalGroup(
                btn_modifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            btn_supprimer.setBackground(new java.awt.Color(255, 255, 255));
            btn_supprimer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
            btn_supprimer.setColorHover(new java.awt.Color(204, 204, 255));
            btn_supprimer.setColorNormal(new java.awt.Color(255, 255, 255));
            btn_supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    btn_supprimerMousePressed(evt);
                }
            });

            jLabel29.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel29.setForeground(new java.awt.Color(3, 182, 215));
            jLabel29.setText("Supprimer");

            jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Trash_20px_1.png"))); // NOI18N

            javax.swing.GroupLayout btn_supprimerLayout = new javax.swing.GroupLayout(btn_supprimer);
            btn_supprimer.setLayout(btn_supprimerLayout);
            btn_supprimerLayout.setHorizontalGroup(
                btn_supprimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_supprimerLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            btn_supprimerLayout.setVerticalGroup(
                btn_supprimerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel28)
            );

            voir.setBackground(new java.awt.Color(255, 255, 255));
            voir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
            voir.setForeground(new java.awt.Color(3, 182, 215));
            voir.setColorHover(new java.awt.Color(204, 204, 255));
            voir.setColorNormal(new java.awt.Color(255, 255, 255));
            voir.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    voirMousePressed(evt);
                }
            });

            jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Eye_20px.png"))); // NOI18N

            jLabel6.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(3, 182, 215));
            jLabel6.setText("Voir");

            javax.swing.GroupLayout voirLayout = new javax.swing.GroupLayout(voir);
            voir.setLayout(voirLayout);
            voirLayout.setHorizontalGroup(
                voirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(voirLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            voirLayout.setVerticalGroup(
                voirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(voirLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addGroup(voirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(voirLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );

            javax.swing.GroupLayout pn_MenupLayout = new javax.swing.GroupLayout(pn_Menup);
            pn_Menup.setLayout(pn_MenupLayout);
            pn_MenupLayout.setHorizontalGroup(
                pn_MenupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 180, Short.MAX_VALUE)
                .addComponent(btn_supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, Short.MAX_VALUE)
                .addComponent(voir, javax.swing.GroupLayout.PREFERRED_SIZE, 180, Short.MAX_VALUE)
            );
            pn_MenupLayout.setVerticalGroup(
                pn_MenupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_MenupLayout.createSequentialGroup()
                    .addComponent(voir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            btn_modifier_pra.setBackground(new java.awt.Color(255, 255, 255));
            btn_modifier_pra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
            btn_modifier_pra.setColorHover(new java.awt.Color(204, 204, 255));
            btn_modifier_pra.setColorNormal(new java.awt.Color(255, 255, 255));
            btn_modifier_pra.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    btn_modifier_praMousePressed(evt);
                }
            });

            jLabel34.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel34.setForeground(new java.awt.Color(3, 182, 215));
            jLabel34.setText("Modifier");

            jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Edit_20px_6.png"))); // NOI18N

            javax.swing.GroupLayout btn_modifier_praLayout = new javax.swing.GroupLayout(btn_modifier_pra);
            btn_modifier_pra.setLayout(btn_modifier_praLayout);
            btn_modifier_praLayout.setHorizontalGroup(
                btn_modifier_praLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_modifier_praLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            btn_modifier_praLayout.setVerticalGroup(
                btn_modifier_praLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
            );

            btn_supprimer_pra.setBackground(new java.awt.Color(255, 255, 255));
            btn_supprimer_pra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
            btn_supprimer_pra.setColorHover(new java.awt.Color(204, 204, 255));
            btn_supprimer_pra.setColorNormal(new java.awt.Color(255, 255, 255));
            btn_supprimer_pra.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    btn_supprimer_praMousePressed(evt);
                }
            });

            jLabel37.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel37.setForeground(new java.awt.Color(3, 182, 215));
            jLabel37.setText("Supprimer");

            jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Trash_20px_1.png"))); // NOI18N

            javax.swing.GroupLayout btn_supprimer_praLayout = new javax.swing.GroupLayout(btn_supprimer_pra);
            btn_supprimer_pra.setLayout(btn_supprimer_praLayout);
            btn_supprimer_praLayout.setHorizontalGroup(
                btn_supprimer_praLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_supprimer_praLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE))
            );
            btn_supprimer_praLayout.setVerticalGroup(
                btn_supprimer_praLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btn_supprimer_praLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addGroup(btn_supprimer_praLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(btn_supprimer_praLayout.createSequentialGroup()
                            .addComponent(jLabel37)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(6, 6, 6))
            );

            javax.swing.GroupLayout pn_MenupraLayout = new javax.swing.GroupLayout(pn_Menupra);
            pn_Menupra.setLayout(pn_MenupraLayout);
            pn_MenupraLayout.setHorizontalGroup(
                pn_MenupraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 176, Short.MAX_VALUE)
                .addGroup(pn_MenupraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_supprimer_pra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(btn_modifier_pra, javax.swing.GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE))
            );
            pn_MenupraLayout.setVerticalGroup(
                pn_MenupraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 81, Short.MAX_VALUE)
                .addGroup(pn_MenupraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_MenupraLayout.createSequentialGroup()
                        .addComponent(btn_modifier_pra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_supprimer_pra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setPreferredSize(new java.awt.Dimension(1350, 750));

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));

            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/admin128.png"))); // NOI18N

            jPanel2.setBackground(new java.awt.Color(3, 182, 215));

            jLabel1.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("Bienvenue : Administrateur");

            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Logout_Rounded_Down_40px.png"))); // NOI18N
            jLabel3.setToolTipText("Déconnexion");
            jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel3MouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(269, 269, 269)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 16, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(14, 14, 14))
            );

            jPanel3.setBackground(new java.awt.Color(255, 255, 255));
            jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            jSeparator1.setForeground(new java.awt.Color(3, 182, 215));

            jSeparator3.setForeground(new java.awt.Color(3, 182, 215));

            btn_accueil.setBackground(new java.awt.Color(3, 182, 215));
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

            btn_G_patients.setBackground(new java.awt.Color(255, 255, 255));
            btn_G_patients.setForeground(new java.awt.Color(3, 182, 215));
            btn_G_patients.setText("GESTION DES PATIENT");
            btn_G_patients.setToolTipText("");
            btn_G_patients.setBorderPainted(false);
            btn_G_patients.setColorHover(new java.awt.Color(255, 255, 255));
            btn_G_patients.setColorText(new java.awt.Color(3, 182, 215));
            btn_G_patients.setColorTextHover(new java.awt.Color(204, 204, 204));
            btn_G_patients.setFocusPainted(false);
            btn_G_patients.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            btn_G_patients.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_G_patientsActionPerformed(evt);
                }
            });

            btn_G_praticiens.setBackground(new java.awt.Color(255, 255, 255));
            btn_G_praticiens.setText("GESTION DES PRATICIEN");
            btn_G_praticiens.setBorderPainted(false);
            btn_G_praticiens.setColorHover(new java.awt.Color(255, 255, 255));
            btn_G_praticiens.setColorText(new java.awt.Color(3, 182, 215));
            btn_G_praticiens.setColorTextHover(new java.awt.Color(204, 204, 204));
            btn_G_praticiens.setFocusPainted(false);
            btn_G_praticiens.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            btn_G_praticiens.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_G_praticiensActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_G_patients, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_accueil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btn_G_praticiens, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btn_accueil, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(62, 62, 62)
                    .addComponent(btn_G_patients, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btn_G_praticiens, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(160, 160, 160))
            );

            bgpanel.setBackground(new java.awt.Color(255, 255, 255));
            bgpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 4));
            bgpanel.setName("bgpanel"); // NOI18N

            jCalendar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(3, 182, 215), 3, true));
            jCalendar1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

            Heure.setFont(new java.awt.Font("DS-Digital", 1, 48)); // NOI18N
            Heure.setForeground(new java.awt.Color(3, 182, 215));

            javax.swing.GroupLayout bgpanelLayout = new javax.swing.GroupLayout(bgpanel);
            bgpanel.setLayout(bgpanelLayout);
            bgpanelLayout.setHorizontalGroup(
                bgpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgpanelLayout.createSequentialGroup()
                    .addContainerGap(259, Short.MAX_VALUE)
                    .addGroup(bgpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(226, 226, 226))
            );
            bgpanelLayout.setVerticalGroup(
                bgpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgpanelLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(159, Short.MAX_VALUE))
            );

            PanelSlider.add(bgpanel, "card2");

            Gestion_Patients.setName("Gestion_Patients"); // NOI18N
            Gestion_Patients.setLayout(null);

            jPanel4.setBackground(new java.awt.Color(255, 255, 255));
            jPanel4.setLayout(null);

            jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Find_User_Male_30px.png"))); // NOI18N

            jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            jScrollPane1.setBackground(new Color(255,255,255,180));
            jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jScrollPane1MouseClicked(evt);
                }
            });

            patients_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "N° dossier medical", "Nom", "Prenom", "Date de Naissance"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            patients_table.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
            patients_table.setColorBordeFilas(new java.awt.Color(52, 73, 94));
            patients_table.setColorBordeHead(new java.awt.Color(52, 73, 94));
            patients_table.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
            patients_table.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
            patients_table.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
            patients_table.setColorSelBackgound(new java.awt.Color(3, 182, 215));
            patients_table.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            patients_table.setGrosorBordeFilas(0);
            patients_table.setGrosorBordeHead(0);
            patients_table.setName("patients_table"); // NOI18N
            patients_table.setRowHeight(22);
            patients_table.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    patients_tableMouseClicked(evt);
                }
            });
            jScrollPane1.setViewportView(patients_table);

            jButton5.setBackground(new java.awt.Color(3, 182, 215));
            jButton5.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jButton5.setForeground(new java.awt.Color(255, 255, 255));
            jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Print_48px.png"))); // NOI18N
            jButton5.setText("Imprimer");
            jButton5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
                }
            });

            rSLabelCircleImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Refresh_64px_1.png"))); // NOI18N
            rSLabelCircleImage2.setColorBorde(new java.awt.Color(255, 255, 255));
            rSLabelCircleImage2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    rSLabelCircleImage2MouseClicked(evt);
                }
            });

            textsearch.setForeground(new java.awt.Color(3, 182, 215));
            textsearch.setBorderColor(new java.awt.Color(3, 182, 215));
            textsearch.setBotonColor(new java.awt.Color(3, 182, 215));
            textsearch.setPhColor(new java.awt.Color(3, 182, 215));
            textsearch.setPlaceholder("N°dossier  / nom / prenom");
            textsearch.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    textsearchActionPerformed(evt);
                }
            });
            textsearch.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    textsearchKeyReleased(evt);
                }
            });

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(rSLabelCircleImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addGap(0, 9, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(274, 274, 274))))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(rSLabelCircleImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                    .addComponent(jButton5)
                    .addContainerGap())
            );

            jPanel5.setBackground(new Color(255,255,255,180));

            jPanel4.add(jPanel5);
            jPanel5.setBounds(130, 70, 740, 430);

            jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Cancel_30px.png"))); // NOI18N
            jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel24MouseClicked(evt);
                }
            });
            jPanel4.add(jLabel24);
            jLabel24.setBounds(1310, 60, 30, 30);

            btn_ajouter.setBackground(new java.awt.Color(255, 255, 255));
            btn_ajouter.setForeground(new java.awt.Color(3, 182, 215));
            btn_ajouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Add_User_Group_Man_Man_48px.png"))); // NOI18N
            btn_ajouter.setText("Nouveau Patient");
            btn_ajouter.setColorHover(new java.awt.Color(204, 204, 204));
            btn_ajouter.setColorText(new java.awt.Color(3, 182, 215));
            btn_ajouter.setFocusPainted(false);
            btn_ajouter.setMargin(new java.awt.Insets(5, 14, 5, 40));
            btn_ajouter.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_ajouterActionPerformed(evt);
                }
            });
            jPanel4.add(btn_ajouter);
            btn_ajouter.setBounds(130, 0, 230, 50);

            jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/bgpatttttttttt.jpg"))); // NOI18N
            jPanel4.add(jLabel25);
            jLabel25.setBounds(0, 0, 1130, 650);

            Gestion_Patients.add(jPanel4);
            jPanel4.setBounds(0, 0, 1100, 640);

            PanelSlider.add(Gestion_Patients, "card5");

            Gestion_Praticiens.setName("Gestion_Praticiens"); // NOI18N

            jPanel6.setBackground(new java.awt.Color(255, 255, 255));
            jPanel6.setLayout(null);

            jScrollPane1.setBackground(new Color(255,255,255,180));
            jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jScrollPane2MouseClicked(evt);
                }
            });

            table_praticien.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            table_praticien.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
            table_praticien.setColorBordeFilas(new java.awt.Color(255, 255, 255));
            table_praticien.setColorBordeHead(new java.awt.Color(255, 255, 255));
            table_praticien.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
            table_praticien.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
            table_praticien.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
            table_praticien.setColorSelBackgound(new java.awt.Color(3, 182, 215));
            table_praticien.setRowHeight(22);
            table_praticien.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    table_praticienMouseClicked(evt);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    table_praticienMousePressed(evt);
                }
            });
            jScrollPane2.setViewportView(table_praticien);

            jPanel4.setBackground(new Color(255,255,255,120));
            jPanel12.setBackground(new java.awt.Color(255, 255, 255));
            jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information Praticien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andalus", 1, 18), new java.awt.Color(52, 73, 94))); // NOI18N
            jPanel12.setForeground(new java.awt.Color(255, 255, 255));

            jLabel23.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel23.setForeground(new java.awt.Color(3, 182, 215));
            jLabel23.setText("Nom :");

            jLabel30.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel30.setForeground(new java.awt.Color(3, 182, 215));
            jLabel30.setText("Prenom :");

            jLabel31.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel31.setForeground(new java.awt.Color(3, 182, 215));
            jLabel31.setText("Spécialité :");

            jLabel32.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel32.setForeground(new java.awt.Color(3, 182, 215));
            jLabel32.setText("Email :");

            jLabel33.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel33.setForeground(new java.awt.Color(3, 182, 215));
            jLabel33.setText("Télephone :");

            prenom.setEditable(false);
            prenom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            prenom.setForeground(new java.awt.Color(52, 73, 94));
            prenom.setBorder(null);
            prenom.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    prenomActionPerformed(evt);
                }
            });

            email.setEditable(false);
            email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            email.setForeground(new java.awt.Color(52, 73, 94));
            email.setBorder(null);

            nom.setEditable(false);
            nom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            nom.setForeground(new java.awt.Color(52, 73, 94));
            nom.setBorder(null);
            nom.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nomActionPerformed(evt);
                }
            });

            type.setEditable(false);
            type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            type.setForeground(new java.awt.Color(52, 73, 94));
            type.setBorder(null);

            spec.setEditable(false);
            spec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            spec.setForeground(new java.awt.Color(52, 73, 94));
            spec.setBorder(null);
            spec.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    specActionPerformed(evt);
                }
            });

            label.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            label.setForeground(new java.awt.Color(3, 182, 215));
            label.setText("Identifiant:");

            id.setEditable(false);
            id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            id.setForeground(new java.awt.Color(52, 73, 94));
            id.setBorder(null);
            id.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    idActionPerformed(evt);
                }
            });

            jLabel39.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel39.setForeground(new java.awt.Color(3, 182, 215));
            jLabel39.setText("Type:");

            tel.setEditable(false);
            tel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            tel.setForeground(new java.awt.Color(52, 73, 94));
            tel.setBorder(null);
            tel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    telActionPerformed(evt);
                }
            });

            jLabel40.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jLabel40.setForeground(new java.awt.Color(3, 182, 215));
            jLabel40.setText("Address:");

            address.setEditable(false);
            address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            address.setForeground(new java.awt.Color(52, 73, 94));
            address.setBorder(null);

            javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
            jPanel12.setLayout(jPanel12Layout);
            jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jSeparator9)
                            .addContainerGap())
                        .addComponent(jSeparator4)
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator5)
                        .addComponent(jSeparator6)
                        .addComponent(jSeparator8)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tel)
                                    .addGap(11, 11, 11))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(address)
                                    .addGap(12, 12, 12))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(11, 11, 11))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(email)
                                    .addGap(5, 5, 5)))
                            .addGap(18, 18, 18))
                        .addComponent(jSeparator7)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spec, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())))
            );
            jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel39)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(8, 8, 8)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(2, 2, 2)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10))
            );

            jButton4.setBackground(new java.awt.Color(3, 182, 215));
            jButton4.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            jButton4.setForeground(new java.awt.Color(255, 255, 255));
            jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Print_48px.png"))); // NOI18N
            jButton4.setText("Imprimer");
            jButton4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
                }
            });

            btn_modifier1.setBackground(new java.awt.Color(255, 255, 255));
            btn_modifier1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            btn_modifier1.setForeground(new java.awt.Color(3, 182, 215));
            btn_modifier1.setText("Modifier ");
            btn_modifier1.setBorder(null);

            btn_supp.setBackground(new java.awt.Color(255, 255, 255));
            btn_supp.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
            btn_supp.setForeground(new java.awt.Color(3, 182, 215));
            btn_supp.setText("Supprimer ");
            btn_supp.setBorder(null);
            btn_supp.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btn_suppActionPerformed(evt);
                }
            });

            jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Find_User_Male_30px.png"))); // NOI18N

            textsearch1.setForeground(new java.awt.Color(3, 182, 215));
            textsearch1.setBorderColor(new java.awt.Color(3, 182, 215));
            textsearch1.setBotonColor(new java.awt.Color(3, 182, 215));
            textsearch1.setPhColor(new java.awt.Color(3, 182, 215));
            textsearch1.setPlaceholder("id / nom / spécialité");
            textsearch1.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    textsearch1KeyReleased(evt);
                }
            });

            javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
            jPanel11.setLayout(jPanel11Layout);
            jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGap(182, 182, 182)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(467, 467, 467)
                            .addComponent(btn_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(139, 139, 139)
                            .addComponent(btn_modifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(429, 429, 429)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_modifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())))
            );

            jPanel11.setBackground(new Color(255,255,255,180));

            jPanel6.add(jPanel11);
            jPanel11.setBounds(10, 110, 950, 450);

            rSButtonCircle3.setBackground(new java.awt.Color(255, 255, 255));
            rSButtonCircle3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Registration_52px.png"))); // NOI18N
            rSButtonCircle3.setToolTipText("Modifier");
            rSButtonCircle3.setColorHover(new java.awt.Color(220, 210, 255));
            rSButtonCircle3.setFocusPainted(false);
            rSButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rSButtonCircle3ActionPerformed(evt);
                }
            });
            jPanel6.add(rSButtonCircle3);
            rSButtonCircle3.setBounds(640, 0, 100, 100);

            rSButtonCircle2.setBackground(new java.awt.Color(255, 255, 255));
            rSButtonCircle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Waste_50px.png"))); // NOI18N
            rSButtonCircle2.setToolTipText("supprimer");
            rSButtonCircle2.setColorHover(new java.awt.Color(220, 210, 255));
            rSButtonCircle2.setFocusPainted(false);
            rSButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rSButtonCircle2ActionPerformed(evt);
                }
            });
            jPanel6.add(rSButtonCircle2);
            rSButtonCircle2.setBounds(830, 0, 105, 100);

            rSButtonCircle1.setBackground(new java.awt.Color(255, 255, 255));
            rSButtonCircle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Refresh_30px.png"))); // NOI18N
            rSButtonCircle1.setToolTipText("actualiser");
            rSButtonCircle1.setColorHover(new java.awt.Color(220, 210, 255));
            rSButtonCircle1.setFocusPainted(false);
            rSButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rSButtonCircle1ActionPerformed(evt);
                }
            });
            jPanel6.add(rSButtonCircle1);
            rSButtonCircle1.setBounds(440, 0, 110, 100);

            rSButtonCircle4.setBackground(new java.awt.Color(255, 255, 255));
            rSButtonCircle4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Add_User_Group_Man_Man_60px.png"))); // NOI18N
            rSButtonCircle4.setToolTipText("Ajouter");
            rSButtonCircle4.setColorHover(new java.awt.Color(204, 204, 204));
            rSButtonCircle4.setFocusPainted(false);
            rSButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rSButtonCircle4ActionPerformed(evt);
                }
            });
            jPanel6.add(rSButtonCircle4);
            rSButtonCircle4.setBounds(50, 0, 110, 100);

            rSButtonCircle5.setBackground(new java.awt.Color(255, 255, 255));
            rSButtonCircle5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Print_52px.png"))); // NOI18N
            rSButtonCircle5.setToolTipText("imprimer");
            rSButtonCircle5.setColorHover(new java.awt.Color(220, 210, 255));
            rSButtonCircle5.setFocusPainted(false);
            rSButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rSButtonCircle5ActionPerformed(evt);
                }
            });
            jPanel6.add(rSButtonCircle5);
            rSButtonCircle5.setBounds(240, 0, 110, 100);

            jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/backg.png"))); // NOI18N
            jPanel6.add(jLabel36);
            jLabel36.setBounds(0, -20, 1550, 660);

            javax.swing.GroupLayout Gestion_PraticiensLayout = new javax.swing.GroupLayout(Gestion_Praticiens);
            Gestion_Praticiens.setLayout(Gestion_PraticiensLayout);
            Gestion_PraticiensLayout.setHorizontalGroup(
                Gestion_PraticiensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
            );
            Gestion_PraticiensLayout.setVerticalGroup(
                Gestion_PraticiensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
            );

            PanelSlider.add(Gestion_Praticiens, "card4");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(PanelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(37, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(71, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         this.hide();
        admin_login  al = new  admin_login();
        al.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    imprimer_liste_patient();  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void patients_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patients_tableMouseClicked
        
        
        int row = patients_table.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.patients_table.setRowSelectionInterval(row, row);
            position = evt.getY() / 16;
            MenuP.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.patients_table.setRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_patients_tableMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void btn_accueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accueilActionPerformed
         if (!this.btn_accueil.isSelected()) {
            this.btn_accueil.setSelected(true);
            this.btn_G_praticiens.setSelected(false);
            this.btn_G_patients.setSelected(false);
            this.PanelSlider.slidPanel(4, bgpanel, RSPanelsSlider.direct.Right);}
    }//GEN-LAST:event_btn_accueilActionPerformed

    private void btn_accueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_accueilMouseClicked
      
    }//GEN-LAST:event_btn_accueilMouseClicked

    private void btn_supprimerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_supprimerMousePressed
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
            this.MenuP.setVisible(false);
            int R = this.patients_table.getSelectedRow();
            C = this.patients_table.getValueAt(R, 0).toString();
            Supprimer_patient(inf);
        }
    }//GEN-LAST:event_btn_supprimerMousePressed

    private void voirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voirMousePressed
       if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
            this.MenuP.setVisible(false);
            int R = this.patients_table.getSelectedRow();
            C = this.patients_table.getValueAt(R, 1).toString();
           inf.setVisible(true);
           inf.pack();
          afficher_infos_patient(inf);
       }    
        
    }//GEN-LAST:event_voirMousePressed

    private void btn_G_patientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_G_patientsActionPerformed
            if (!this.btn_G_patients.isSelected()) {
            this.btn_G_praticiens.setSelected(false);
            this.btn_G_patients.setSelected(true);
        
            this.btn_accueil.setSelected(false);
            
            this.PanelSlider.slidPanel(4, Gestion_Patients, RSPanelsSlider.direct.Right);
        }        
    }//GEN-LAST:event_btn_G_patientsActionPerformed

    private void btn_G_praticiensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_G_praticiensActionPerformed
        if (!this.btn_G_praticiens.isSelected()) {
            this.btn_G_praticiens.setSelected(true);
            this.btn_G_patients.setSelected(false);
          
             this.btn_accueil.setSelected(false);
            
            this.PanelSlider.slidPanel(4, Gestion_Praticiens, RSPanelsSlider.direct.Right);
        }
    }//GEN-LAST:event_btn_G_praticiensActionPerformed

    private void btn_modifierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modifierMousePressed
       this.T="Modifier";
       afficher_infos_patient( inf);
       Ajouter_patient mp = new  Ajouter_patient();
       mp.setVisible(true);
       mp.Afficher_infos();
       
    }//GEN-LAST:event_btn_modifierMousePressed

    private void btn_suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suppActionPerformed
        Supprimer_praticien();
    }//GEN-LAST:event_btn_suppActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomActionPerformed

    private void specActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_specActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        MessageFormat header = new MessageFormat("Liste des Praticiens:");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            table_praticien.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rSLabelCircleImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSLabelCircleImage2MouseClicked
     Affichertable_patient();
      
    }//GEN-LAST:event_rSLabelCircleImage2MouseClicked

    private void btn_modifier_praMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modifier_praMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifier_praMousePressed

    private void btn_supprimer_praMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_supprimer_praMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_supprimer_praMousePressed

    private void rSButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonCircle1ActionPerformed

       Affichertable_praticien();
       vider_praticien();
    }//GEN-LAST:event_rSButtonCircle1ActionPerformed

    private void rSButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonCircle4ActionPerformed
    this.T="ajouter";
    Ajouter_Praticien P =  new Ajouter_Praticien();
    P.setVisible(true);
    }//GEN-LAST:event_rSButtonCircle4ActionPerformed

    private void rSButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonCircle5ActionPerformed
       imprimer_liste_praticiens();
    }//GEN-LAST:event_rSButtonCircle5ActionPerformed

    private void table_praticienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_praticienMouseClicked
       Affichage_praticien();
    }//GEN-LAST:event_table_praticienMouseClicked

    private void rSButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonCircle2ActionPerformed
      Supprimer_praticien();
    }//GEN-LAST:event_rSButtonCircle2ActionPerformed

    private void rSButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonCircle3ActionPerformed
       this.T="Modifier";
       Ajouter_Praticien pra=  new Ajouter_Praticien();
       pra.setVisible(true);
       pra.Afficher_infos();
       
    }//GEN-LAST:event_rSButtonCircle3ActionPerformed

    private void table_praticienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_praticienMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_table_praticienMousePressed

    private void btn_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ajouterActionPerformed
       this.T="ajouter";
         Ajouter_patient AP=new Ajouter_patient();
         AP.setVisible(true);
    }//GEN-LAST:event_btn_ajouterActionPerformed

    private void textsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearchKeyReleased
    recherche_patient(this.textsearch.getText());
    }//GEN-LAST:event_textsearchKeyReleased

    private void textsearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textsearch1KeyReleased
         recherche_praticien(this.textsearch1.getText());
    }//GEN-LAST:event_textsearch1KeyReleased

    private void textsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textsearchActionPerformed

    private void telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed
    
    /**
     * @param args the command line arguments
     */

    /**
     *
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */

    /**
     *
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */

    /**
     *
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */

    /**
     *
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
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
            java.util.logging.Logger.getLogger(Admin_accueil1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_accueil1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_accueil1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_accueil1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_accueil1().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Gestion_Patients;
    private javax.swing.JPanel Gestion_Praticiens;
    public static javax.swing.JLabel Heure;
    private rojerusan.RSPopuMenu MenuP;
    private rojerusan.RSPopuMenu MenuPra;
    private rojerusan.RSPanelsSlider PanelSlider;
    public static javax.swing.JTextField address;
    private javax.swing.JPanel bgpanel;
    private rojerusan.RSButtonHover btn_G_patients;
    private rojerusan.RSButtonHover btn_G_praticiens;
    private rojerusan.RSButtonMetro btn_accueil;
    private rojerusan.RSButtonIconI btn_ajouter;
    private rojerusan.RSButtonPane btn_modifier;
    private javax.swing.JButton btn_modifier1;
    private rojerusan.RSButtonPane btn_modifier_pra;
    private javax.swing.JButton btn_supp;
    private rojerusan.RSButtonPane btn_supprimer;
    private rojerusan.RSButtonPane btn_supprimer_pra;
    public static javax.swing.JTextField email;
    public static javax.swing.JTextField id;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel label;
    public static javax.swing.JTextField nom;
    public static rojerusan.RSTableMetro patients_table;
    private javax.swing.JPanel pn_Menup;
    private javax.swing.JPanel pn_Menupra;
    public static javax.swing.JTextField prenom;
    private rojerusan.RSButtonCircle rSButtonCircle1;
    private rojerusan.RSButtonCircle rSButtonCircle2;
    private rojerusan.RSButtonCircle rSButtonCircle3;
    private rojerusan.RSButtonCircle rSButtonCircle4;
    private rojerusan.RSButtonCircle rSButtonCircle5;
    private rojerusan.RSLabelCircleImage rSLabelCircleImage2;
    public static javax.swing.JTextField spec;
    public static rojerusan.RSTableMetro table_praticien;
    public static javax.swing.JTextField tel;
    private rojerusan.RSMetroTextFullPlaceHolder textsearch;
    private rojerusan.RSMetroTextFullPlaceHolder textsearch1;
    public static javax.swing.JTextField type;
    private rojerusan.RSButtonPane voir;
    // End of variables declaration//GEN-END:variables

    
    
    
    
    
    
    
    
    
    
    
    
    
    
//----------------------------------------GESTION DES PATIENTS -------------------------------------------------------  
   

    public static  void Affichertable_patient() {
        try {
           
          String rqt = "select  N_doss_med as 'N° dossier médical', patient_nom as 'Nom',  patient_prenom as 'Prenom',  patient_date_naiss as 'Date de naissance' from patient";
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           
         patients_table.setModel(DbUtils.resultSetToTableModel(rs));
        
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
    
    
    //Imprimer
    public  void imprimer_liste_patient()
    {
        MessageFormat header = new MessageFormat("Liste des Patients:");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            patients_table.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }
    }
    
     // Afficher 
     public    void afficher_infos_patient( infos_patient info) {
        
        try {
            int R =  patients_table.getSelectedRow();
            this.M= (patients_table.getModel().getValueAt(R, 0).toString());
            String rqt = " select * from patient where N_doss_med= '" +M+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                 String s = rs.getString("N_doss_med");
               info.numdoss.setText(s);
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
      //Vider champs
      public  void vider(infos_patient info) {
        try {
            info.mat.setText("");
            info.nom.setText("");
            info.prenom.setText("");
            info.sexe.setText("");
            info.age.setText("");
            info.date_naiss.setText("");
            info.address.setText("");
            info.wilaya.setText("");
            info.sit_fam.setText("");
            info.gsang.setText("");
            info.code_assurance.setText("");
            info.email.setText("");
            info.tlf.setText("");
            ImageIcon img = new ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/sem_foto.jpg"));
           info.image.setIcon(img);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
      
      // Supprimer Patient
      public   void Supprimer_patient(infos_patient info)
      {
          
          int R =  patients_table.getSelectedRow();
          this.M= (patients_table.getModel().getValueAt(R, 0).toString());
       try {
            if (JOptionPane.showConfirmDialog(null, " voulez vous supprimer ce patient?",
                    "Supprimer Patient", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (M.length() != 0) {

                    String requete = "delete from patient where N_doss_med = '"+M+"'";
                    ps = cnx.prepareStatement(requete);
                    //ps.setString(1, info.numdoss.getText());
                    ps.execute();
                    JOptionPane.showMessageDialog(null,"deleted");
                    Affichertable_patient();
                } 
                
                
            }
                ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de suppression \n" + e.getMessage());
        }}
      
// table result
      public  static String tableresult() { 
        return M;
    }
      public static String result() {
        return T;
    }

     
     public  void recherche_patient( String rech)
     {
         try {
String rqt= "select   N_doss_med as 'N° dossier médical', patient_nom as 'Nom',  patient_prenom as 'Prenom',  patient_date_naiss as 'Date de naissance'  from  patient where (N_doss_med LIKE'" + rech + "%' OR patient_nom LIKE'" + rech+ "%' OR "
                    + "	patient_prenom LIKE'" + rech + "%' )";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
           patients_table.setModel(DbUtils.resultSetToTableModel(rs));
             ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
     }
      
    
    
    

//------------------------------------ Gestion des PRATICIEN---------------------------------------------------------------
    public static void Affichertable_praticien() {
        try {
           
          String rqt = "select    praticien_identifiant as 'Identifiant', praticien_nom as 'Nom', praticien_specialite as 'Spécialité' from praticien";
       
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_praticien.setModel(DbUtils.resultSetToTableModel(rs));
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
    
     public void Affichage_praticien() {
        try {

            int R =  table_praticien.getSelectedRow();
          this.M = (table_praticien.getModel().getValueAt(R, 0).toString());
            String rqt = " select * from praticien where praticien_identifiant = '" +M+ "' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();

            if (rs.next()) {
                String s1 = rs.getString("praticien_identifiant");
                id.setText(s1);
                String s2 = rs.getString("praticien_nom");
                nom.setText(s2);
                String s3 = rs.getString("praticien_prenom");
                prenom.setText(s3);
                String s4 = rs.getString("praticien_type");
                type.setText(s4);
                String s5 = rs.getString("praticien_specialite");
                spec.setText(s5);
                String s6 = rs.getString("praticien_email");
                email.setText(s6);   
                String s7 = rs.getString("praticien_num_phone");
                tel.setText(s7); 
                String s8 = rs.getString("address");
                address.setText(s7); 
            }
                ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }  
       //méthod pour vider les champs
      public void vider_praticien(){
         try {
            id.setText("");
            nom.setText("");
            prenom.setText("");
            type.setText("");
            spec.setText("");
            email.setText("");
            tel.setText("");
            address.setText("");
            
        } catch (Exception e) {
            System.out.println(e);
        }
          
      }
    //imprimer liste praticien 
       public void imprimer_liste_praticiens()
    {
        MessageFormat header = new MessageFormat("Liste des Praticiens:");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            table_praticien.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }
    }
    
       
       
       //Rechercher Praticien 
        public void recherche_praticien( String rech)
     {
         try {
String rqt= "select   praticien_identifiant as 'Identifiant', praticien_nom as 'Nom', praticien_specialite as 'Spécialité'  from  praticien where ( praticien_identifiant LIKE'" + rech + "%' OR  praticien_nom LIKE'" + rech+ "%' OR "
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
        
        
        
         // Supprimer Praticien
      public void Supprimer_praticien()
      {
       try {
            if (JOptionPane.showConfirmDialog(null, " voulez vous supprimer ce praticien?",
                    "Supprimer Praticien", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                if (id.getText().length() != 0) {
                    String requete = "delete from praticien where praticien_identifiant = ?";
                    ps = cnx.prepareStatement(requete);
                    ps.setString(1, id.getText());
                    ps.execute();
                    JOptionPane.showMessageDialog(null,"deleted");
                  vider_praticien();
                  Affichertable_praticien();
                } 
            }
                ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de suppression \n" + e.getMessage());
        }}
      












}

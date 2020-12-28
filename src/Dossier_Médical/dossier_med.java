/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dossier_Médical;

import Listes.praticien;
import Login.DB_Connexion;
import interfaces.inter_praticien;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import public_var.variables;
import static public_var.variables.N;

import static public_var.variables.cnx;
import static public_var.variables.ps;
import static public_var.variables.rs;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author pc
 */
public class dossier_med extends javax.swing.JFrame {

    /**
     * Creates new form dossier_med
     */
     
    public dossier_med() {
        initComponents();
          cnx= DB_Connexion.Connexion();
      // table_onco.getColumnModel().getColumn(0).setPreferredWidth(0);
      // table_onco.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
       
      //   Affichertable_CRS_PNEU();
      // Affichertable_CRS_ONCO();
      // Affichertable_CRS_MED();
      // Affichertable_CRS_PHARM();
    
       
    }
   
        imageradio I =new imageradio();
  //--------------COMPTE RENDU ONCOLOGUE ----------------------------------------------------------
    
     // Afficher la table copmtes rendus oncologue  par date 
      
       public void Affichertable_CRS_ONCO() {
        try {
           
            String speci="oncologue";
          
             String ND= numdoss.getText();
            
            String rqt = "select ide as 'id',date as 'Date'from rapportexamination where `Num_doss_medical` = '"+ND+"'  AND `specialite` ='"+speci+"'"; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_onco.setModel(DbUtils.resultSetToTableModel(rs));
          
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
       
    
    
     public void afficher_detail_CR_ONCO() {
        
        try {
            
            int R =  table_onco.getSelectedRow();
            N = (table_onco.getModel().getValueAt(R, 0).toString());
           
            String rqt = "select * from rapportexamination WHERE `ide` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("date");
                date_saisie.setText(s1);
                String s2 = rs.getString("contexte");
                context.setText(s2);
                String s3 = rs.getString("Num_doss_medical");
                doss.setText(s3);
                String s4 = rs.getString("idpra");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s4);
                nom_prenom.setText(pn2.toString());
                
              
            }
                ps.close();
                rs.close();
                String ND= numdoss.getText();
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ND+"'";
                 ps = cnx.prepareStatement(rqt2);
                rs = ps.executeQuery();
                if(rs.next()){
                String s5=rs.getString("patient_nom");
                nomp.setText(s5);
                 String s6=rs.getString("patient_prenom");
                prenomp.setText(s6);
                 String s8=rs.getString("patient_age");
                AgeP.setText(s8);
                
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    
    
     
      // Afficher la table copmtes rendus pneumplogue   par date 
      
       public void Affichertable_CRS_PNEU() {
        try {
            String specia="pneumologue";
          
            String ND= numdoss.getText();
            System.out.println(ND);
            String rqt = "select ide as 'id',date  as 'Date'from rapportexamination where `Num_doss_medical` = '"+ND+"'  AND `specialite` ='"+specia+"' "; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_pneu.setModel(DbUtils.resultSetToTableModel(rs));
          
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
       
    
    
     public void afficher_detail_CR_PNEU() {
        
        try {
            
            int R =  table_pneu.getSelectedRow();
            N= (table_pneu.getModel().getValueAt(R, 0).toString());
           
            String rqt = "select * from rapportexamination WHERE `ide` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("date");
                date_saisie1.setText(s1);
                String s2 = rs.getString("contexte");
                context1.setText(s2);
                String s3 = rs.getString("Num_doss_medical");
                doss1.setText(s3);
                String s4 = rs.getString("idpra");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s4);
                nom_prenom3.setText(pn2.toString());
                
              
            }
                ps.close();
                rs.close();
                String ND= numdoss.getText();
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ND+"'";
                 ps = cnx.prepareStatement(rqt2);
                rs = ps.executeQuery();
                if(rs.next()){
                String s5=rs.getString("patient_nom");
                nomp3.setText(s5);
                 String s6=rs.getString("patient_prenom");
                prenomp3.setText(s6);
                 String s8=rs.getString("patient_age");
                AgeP3.setText(s8);
                
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    
      // Afficher la table copmtes rendus medecin local  par date 
      
       public void Affichertable_CRS_MED() {
        try {
           
            String speci="Médecin référant local";
          
            String ND= numdoss.getText();
            
           String rqt = "select ide,date from rapportexamination where `Num_doss_medical` = '"+ND+"'  AND `specialite` ='"+speci+"'"; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_med.setModel(DbUtils.resultSetToTableModel(rs));
          
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
       
    
    
     public void afficher_detail_CR_MED() {
        
        try {
            
            int R =  table_med.getSelectedRow();
            N = (table_med.getModel().getValueAt(R, 0).toString());
           
            String rqt = "select * from rapportexamination WHERE `ide` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("date");
                date_saisie5.setText(s1);
                String s2 = rs.getString("contexte");
                context5.setText(s2);
                String s3 = rs.getString("Num_doss_medical");
                doss5.setText(s3);
                String s4 = rs.getString("idpra");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s4);
                nom_prenom7.setText(pn2.toString());
                
              
            }
                ps.close();
                rs.close();
                String ND= numdoss.getText();
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ND+"'";
                 ps = cnx.prepareStatement(rqt2);
                rs = ps.executeQuery();
                if(rs.next()){
                String s5=rs.getString("patient_nom");
                nomp7.setText(s5);
                 String s6=rs.getString("patient_prenom");
                prenomp7.setText(s6);
                 String s8=rs.getString("patient_age");
                AgeP7.setText(s8);
                
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    //---------------------------------------------------------------------------------------------------
      // Afficher la table copmtes rendus pharmacien  par date 
      
       public void Affichertable_CRS_PHARM() {
        try {
           
           
            String ND= numdoss.getText();
            
            String rqt = "select idd as 'id',date as 'Date'from donneespharmacologique  where `Num_doss_medical` = '"+ND+"' "; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_pharm.setModel(DbUtils.resultSetToTableModel(rs));
          
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
       
    
    
     public void afficher_detail_CR_PHARM() {
        
        try {
            
            int R =  table_pharm.getSelectedRow();
            N = (table_pharm.getModel().getValueAt(R, 0).toString());
           
            String rqt = "select * from donneespharmacologique WHERE `idd` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("date");
                date_saisie4.setText(s1);
                String s2 = rs.getString("contexte");
                context4.setText(s2);
                String s3 = rs.getString("Num_doss_medical");
                doss4.setText(s3);
                String s4 = rs.getString("idpra");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s4);
                nom_prenom6.setText(pn2.toString());
                
              
            }
                ps.close();
                rs.close();
                String ND= numdoss.getText();
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ND+"'";
                 ps = cnx.prepareStatement(rqt2);
                rs = ps.executeQuery();
                if(rs.next()){
                String s5=rs.getString("patient_nom");
                nomp6.setText(s5);
                 String s6=rs.getString("patient_prenom");
                prenomp6.setText(s6);
                 String s8=rs.getString("patient_age");
                AgeP6.setText(s8);
                
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    
    
     
     
     
     
     
     
     // Afficher la table copmtes rendus chirurgie  par date 
      
       public void Affichertable_CRS_CHIR() {
        try {
           
           
          
             String ND= numdoss.getText();
            
            String rqt = "select idc as 'id',date as 'Date'from chirurgie where `Num_doss_medical` = '"+ND+"' "; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_chir.setModel(DbUtils.resultSetToTableModel(rs));
          
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
       
    
    
     public void afficher_detail_CR_CHIR() {
        
        try {
            
            int R =  table_chir.getSelectedRow();
            N = (table_chir.getModel().getValueAt(R, 0).toString());
           
            String rqt = "select * from chirurgie WHERE `idc` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("date");
                date_saisie3.setText(s1);
                String s2 = rs.getString("contexte");
                context3.setText(s2);
                String s3 = rs.getString("Num_doss_medical");
                doss3.setText(s3);
                String s4 = rs.getString("idpra");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s4);
                nom_prenom5.setText(pn2.toString());
                
              
            }
                ps.close();
                rs.close();
                String ND= numdoss.getText();
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ND+"'";
                 ps = cnx.prepareStatement(rqt2);
                rs = ps.executeQuery();
                if(rs.next()){
                String s5=rs.getString("patient_nom");
                nomp5.setText(s5);
                 String s6=rs.getString("patient_prenom");
                prenomp5.setText(s6);
                 String s8=rs.getString("patient_age");
                AgeP5.setText(s8);
                
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    
    // Afficher la table copmtes rendus radiotherapie par date 
      
       public void Affichertable_CRS_RADT() {
        try {
           
          
          
             String ND= numdoss.getText();
            
            String rqt = "select idr as 'id',date as 'Date'from radiotherapie where `Num_doss_medical` = '"+ND+"' "; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_radt.setModel(DbUtils.resultSetToTableModel(rs));
          
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
       
    
    
     public void afficher_detail_CR_RADT() {
        
        try {
            
            int R =  table_radt.getSelectedRow();
            N = (table_radt.getModel().getValueAt(R, 0).toString());
           
            String rqt = "select * from radiotherapie WHERE `idr` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("date");
                date_saisie8.setText(s1);
                String s2 = rs.getString("contexte");
                context8.setText(s2);
                String s3 = rs.getString("Num_doss_medical");
                doss8.setText(s3);
                String s4 = rs.getString("idpra");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s4);
                nom_prenom10.setText(pn2.toString());
                
              
            }
                ps.close();
                rs.close();
                String ND= numdoss.getText();
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ND+"'";
                 ps = cnx.prepareStatement(rqt2);
                rs = ps.executeQuery();
                if(rs.next()){
                String s5=rs.getString("patient_nom");
                nomp10.setText(s5);
                 String s6=rs.getString("patient_prenom");
                prenomp10.setText(s6);
                 String s8=rs.getString("patient_age");
                AgeP10.setText(s8);
                
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
   
    
     
       
    // Afficher la table copmtes rendus pathologisye par date 
      
       public void Affichertable_CRS_ANAP() {
        try {
           
          
          
             String ND= numdoss.getText();
            
            String rqt = "select idap as 'id',date as 'Date'from anatomiepathologique where `Num_doss_medical` = '"+ND+"' "; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_anap.setModel(DbUtils.resultSetToTableModel(rs));
          
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
       
    
    
     public void afficher_detail_CR_ANAP() {
        
        try {
            
            int R =  table_anap.getSelectedRow();
            N = (table_anap.getModel().getValueAt(R, 0).toString());
           
            String rqt = "select * from anatomiepathologique WHERE `idap` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("date");
                date_saisie2.setText(s1);
                String s2 = rs.getString("contexte");
                context2.setText(s2);
                String s3 = rs.getString("Num_doss_medical");
                doss2.setText(s3);
                String s4 = rs.getString("idpra");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s4);
                nom_prenom4.setText(pn2.toString());
                
              
            }
                ps.close();
                rs.close();
                String ND= numdoss.getText();
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ND+"'";
                 ps = cnx.prepareStatement(rqt2);
                rs = ps.executeQuery();
                if(rs.next()){
                String s5=rs.getString("patient_nom");
                nomp4.setText(s5);
                 String s6=rs.getString("patient_prenom");
                prenomp4.setText(s6);
                 String s8=rs.getString("patient_age");
                AgeP4.setText(s8);
                
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    
    
    
    // Afficher la table copmtes rendus laboratoires des analyses médical par date 
      
       public void Affichertable_CRS_LABO() {
        try {
           
          
          
             String ND= numdoss.getText();
            
            String rqt = "select ida as 'id',date as 'Date'from analysesmedicales  where `Num_doss_medical` = '"+ND+"' "; 
           ps = cnx.prepareStatement(rqt);
           rs = ps.executeQuery();
           table_analyses.setModel(DbUtils.resultSetToTableModel(rs));
          
                ps.close();
                rs.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        }
     
     
     
     public void afficher_detail_CR_LABO() {
        
        try {
            
            int R =  table_analyses.getSelectedRow();
            N = (table_analyses.getModel().getValueAt(R, 0).toString());
           
            String rqt = "select * from analysesmedicales WHERE `ida` LIKE'" +N+ "'";
           
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            if (rs.next()) {
                String s1 = rs.getString("date");
                date_saisie7.setText(s1);
                String s2 = rs.getString("contexte");
                context7.setText(s2);
                String s3 = rs.getString("Num_doss_medical");
                doss7.setText(s3);
                String s4 = rs.getString("idpra");
                inter_praticien inter_pra2 = new inter_praticien();
                praticien pn2= (praticien) inter_pra2.selectnom_prenom(s4);
                nom_prenom9.setText(pn2.toString());
                
              
            }
                ps.close();
                rs.close();
                String ND= numdoss.getText();
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ND+"'";
                 ps = cnx.prepareStatement(rqt2);
                rs = ps.executeQuery();
                if(rs.next()){
                String s5=rs.getString("patient_nom");
                nomp9.setText(s5);
                 String s6=rs.getString("patient_prenom");
                prenomp9.setText(s6);
                 String s8=rs.getString("patient_age");
                AgeP9.setText(s8);
                
                }
                 ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    
    
    
    
     
     
      // Afficher la table copmtes rendus laboratoires des analyses médical par date 
      
       public void Affichertable_CRS_RADIO() {
        try {
           
          
          
             String ND= numdoss.getText();
            
            String rqt = "select ider as 'id',date as 'Date'from examenradiologique  where `Num_doss_medical` = '"+ND+"' "; 
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
                String ND= numdoss.getText();
                String rqt2= "select * from patient where  `N_doss_med` LIKE '" +ND+"'";
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

        jPanel1 = new javax.swing.JPanel();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        infos_personnel = new javax.swing.JPanel();
        pn_infosp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        patient_infos = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        image = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        onco = new javax.swing.JLabel();
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
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        numdoss = new javax.swing.JLabel();
        dateins = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        mat = new javax.swing.JLabel();
        pneu = new javax.swing.JLabel();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        S_pneumologie = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        table_pneu = new rojerusan.RSTableMetro();
        jScrollPane24 = new javax.swing.JScrollPane();
        jPanel19 = new javax.swing.JPanel();
        jSeparator39 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        nom_prenom3 = new javax.swing.JLabel();
        address4 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        nomp3 = new javax.swing.JLabel();
        jSeparator40 = new javax.swing.JSeparator();
        jLabel46 = new javax.swing.JLabel();
        jSeparator41 = new javax.swing.JSeparator();
        prenomp3 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jSeparator42 = new javax.swing.JSeparator();
        AgeP3 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jSeparator43 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        date_saisie1 = new javax.swing.JLabel();
        jSeparator44 = new javax.swing.JSeparator();
        doss1 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        context1 = new javax.swing.JTextArea();
        id1 = new javax.swing.JLabel();
        spece1 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jSeparator45 = new javax.swing.JSeparator();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        S_oncologie = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        nom_prenom = new javax.swing.JLabel();
        address1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nomp = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        prenomp = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        AgeP = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        date_saisie = new javax.swing.JLabel();
        jSeparator29 = new javax.swing.JSeparator();
        doss = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        context = new javax.swing.JTextArea();
        id = new javax.swing.JLabel();
        spece = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator30 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_onco = new rojerusan.RSTableMetro();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        S_radiologie = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
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
        type = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_radio = new rojerusan.RSTableMetro();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        labo_analyses = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jSeparator81 = new javax.swing.JSeparator();
        jLabel92 = new javax.swing.JLabel();
        nom_prenom9 = new javax.swing.JLabel();
        address10 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        nomp9 = new javax.swing.JLabel();
        jSeparator82 = new javax.swing.JSeparator();
        jLabel94 = new javax.swing.JLabel();
        jSeparator83 = new javax.swing.JSeparator();
        prenomp9 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jSeparator84 = new javax.swing.JSeparator();
        AgeP9 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jSeparator85 = new javax.swing.JSeparator();
        jLabel97 = new javax.swing.JLabel();
        date_saisie7 = new javax.swing.JLabel();
        jSeparator86 = new javax.swing.JSeparator();
        doss7 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        context7 = new javax.swing.JTextArea();
        id7 = new javax.swing.JLabel();
        spece7 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jSeparator87 = new javax.swing.JSeparator();
        type1 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        table_analyses = new rojerusan.RSTableMetro();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        S_anatomie_pathologique = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jSeparator46 = new javax.swing.JSeparator();
        jLabel52 = new javax.swing.JLabel();
        nom_prenom4 = new javax.swing.JLabel();
        address5 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        nomp4 = new javax.swing.JLabel();
        jSeparator47 = new javax.swing.JSeparator();
        jLabel54 = new javax.swing.JLabel();
        jSeparator48 = new javax.swing.JSeparator();
        prenomp4 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jSeparator49 = new javax.swing.JSeparator();
        AgeP4 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jSeparator50 = new javax.swing.JSeparator();
        jLabel57 = new javax.swing.JLabel();
        date_saisie2 = new javax.swing.JLabel();
        jSeparator51 = new javax.swing.JSeparator();
        doss2 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        context2 = new javax.swing.JTextArea();
        id2 = new javax.swing.JLabel();
        spece2 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jSeparator52 = new javax.swing.JSeparator();
        jScrollPane17 = new javax.swing.JScrollPane();
        table_anap = new rojerusan.RSTableMetro();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        S_radiotherapie = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jSeparator88 = new javax.swing.JSeparator();
        jLabel100 = new javax.swing.JLabel();
        nom_prenom10 = new javax.swing.JLabel();
        address11 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        nomp10 = new javax.swing.JLabel();
        jSeparator89 = new javax.swing.JSeparator();
        jLabel102 = new javax.swing.JLabel();
        jSeparator90 = new javax.swing.JSeparator();
        prenomp10 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jSeparator91 = new javax.swing.JSeparator();
        AgeP10 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jSeparator92 = new javax.swing.JSeparator();
        jLabel105 = new javax.swing.JLabel();
        date_saisie8 = new javax.swing.JLabel();
        jSeparator93 = new javax.swing.JSeparator();
        doss8 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        context8 = new javax.swing.JTextArea();
        id8 = new javax.swing.JLabel();
        spece8 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jSeparator94 = new javax.swing.JSeparator();
        jScrollPane11 = new javax.swing.JScrollPane();
        table_radt = new rojerusan.RSTableMetro();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        S_chirurgie = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jSeparator53 = new javax.swing.JSeparator();
        jLabel60 = new javax.swing.JLabel();
        nom_prenom5 = new javax.swing.JLabel();
        address6 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        nomp5 = new javax.swing.JLabel();
        jSeparator54 = new javax.swing.JSeparator();
        jLabel62 = new javax.swing.JLabel();
        jSeparator55 = new javax.swing.JSeparator();
        prenomp5 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jSeparator56 = new javax.swing.JSeparator();
        AgeP5 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jSeparator57 = new javax.swing.JSeparator();
        jLabel65 = new javax.swing.JLabel();
        date_saisie3 = new javax.swing.JLabel();
        jSeparator58 = new javax.swing.JSeparator();
        doss3 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        context3 = new javax.swing.JTextArea();
        id3 = new javax.swing.JLabel();
        spece3 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jSeparator59 = new javax.swing.JSeparator();
        jScrollPane13 = new javax.swing.JScrollPane();
        table_chir = new rojerusan.RSTableMetro();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        pharmacie = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jSeparator60 = new javax.swing.JSeparator();
        jLabel68 = new javax.swing.JLabel();
        nom_prenom6 = new javax.swing.JLabel();
        address7 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        nomp6 = new javax.swing.JLabel();
        jSeparator61 = new javax.swing.JSeparator();
        jLabel70 = new javax.swing.JLabel();
        jSeparator62 = new javax.swing.JSeparator();
        prenomp6 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jSeparator63 = new javax.swing.JSeparator();
        AgeP6 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jSeparator64 = new javax.swing.JSeparator();
        jLabel73 = new javax.swing.JLabel();
        date_saisie4 = new javax.swing.JLabel();
        jSeparator65 = new javax.swing.JSeparator();
        doss4 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        context4 = new javax.swing.JTextArea();
        id4 = new javax.swing.JLabel();
        spece4 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jSeparator66 = new javax.swing.JSeparator();
        jScrollPane15 = new javax.swing.JScrollPane();
        table_pharm = new rojerusan.RSTableMetro();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        C_medecin_local = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jSeparator67 = new javax.swing.JSeparator();
        jLabel76 = new javax.swing.JLabel();
        nom_prenom7 = new javax.swing.JLabel();
        address8 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        nomp7 = new javax.swing.JLabel();
        jSeparator68 = new javax.swing.JSeparator();
        jLabel78 = new javax.swing.JLabel();
        jSeparator69 = new javax.swing.JSeparator();
        prenomp7 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jSeparator70 = new javax.swing.JSeparator();
        AgeP7 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jSeparator71 = new javax.swing.JSeparator();
        jLabel81 = new javax.swing.JLabel();
        date_saisie5 = new javax.swing.JLabel();
        jSeparator72 = new javax.swing.JSeparator();
        doss5 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        context5 = new javax.swing.JTextArea();
        id5 = new javax.swing.JLabel();
        spece5 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jSeparator73 = new javax.swing.JSeparator();
        jScrollPane19 = new javax.swing.JScrollPane();
        table_med = new rojerusan.RSTableMetro();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btn_suiv = new rojerusan.RSButtonIconD();
        btn_prec = new rojerusan.RSButtonIconI();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));
        jPanel1.setPreferredSize(new java.awt.Dimension(20000, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelsSlider1.setPreferredSize(new java.awt.Dimension(20000, 800));

        infos_personnel.setBackground(new java.awt.Color(255, 255, 255));
        infos_personnel.setName("infos_personnel"); // NOI18N
        infos_personnel.setPreferredSize(new java.awt.Dimension(1400, 800));

        pn_infosp.setBackground(new java.awt.Color(255, 255, 255));
        pn_infosp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        pn_infosp.setName("pn_infosp"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(3, 182, 215));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informations Patient");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        patient_infos.setBackground(new java.awt.Color(228, 241, 254));
        patient_infos.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(3, 182, 215));
        jLabel8.setText("Nom :");
        patient_infos.add(jLabel8);
        jLabel8.setBounds(50, 258, 73, 20);

        jLabel9.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(3, 182, 215));
        jLabel9.setText("Prenom :");
        patient_infos.add(jLabel9);
        jLabel9.setBounds(430, 260, 89, 20);

        jLabel10.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(3, 182, 215));
        jLabel10.setText("Date de Naissance :");
        patient_infos.add(jLabel10);
        jLabel10.setBounds(50, 310, 159, 20);

        jLabel11.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(3, 182, 215));
        jLabel11.setText("Sexe :");
        patient_infos.add(jLabel11);
        jLabel11.setBounds(50, 370, 140, 21);

        jLabel12.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(3, 182, 215));
        jLabel12.setText("Situation Familliale :");
        patient_infos.add(jLabel12);
        jLabel12.setBounds(50, 420, 170, 30);

        jLabel13.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(3, 182, 215));
        jLabel13.setText("Adresse :");
        patient_infos.add(jLabel13);
        jLabel13.setBounds(50, 490, 99, 28);

        jLabel14.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(3, 182, 215));
        jLabel14.setText("Wilaya :");
        patient_infos.add(jLabel14);
        jLabel14.setBounds(430, 490, 67, 20);

        jLabel15.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(3, 182, 215));
        jLabel15.setText("Email :");
        patient_infos.add(jLabel15);
        jLabel15.setBounds(50, 550, 90, 19);

        jLabel16.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(3, 182, 215));
        jLabel16.setText("Télephone :");
        patient_infos.add(jLabel16);
        jLabel16.setBounds(430, 550, 96, 26);

        jLabel29.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(3, 182, 215));
        jLabel29.setText("Groupe Sanguin :");
        patient_infos.add(jLabel29);
        jLabel29.setBounds(430, 360, 144, 20);

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Espace_Admin/sem_foto.jpg"))); // NOI18N
        jScrollPane20.setViewportView(image);

        patient_infos.add(jScrollPane20);
        jScrollPane20.setBounds(50, 20, 190, 190);

        jLabel18.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(3, 182, 215));
        jLabel18.setText("Code d'assurance:");
        patient_infos.add(jLabel18);
        jLabel18.setBounds(430, 430, 147, 23);

        jLabel19.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(3, 182, 215));
        jLabel19.setText("Date d'inscription:");
        patient_infos.add(jLabel19);
        jLabel19.setBounds(430, 30, 170, 30);

        jLabel20.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(3, 182, 215));
        jLabel20.setText("Age :");
        patient_infos.add(jLabel20);
        jLabel20.setBounds(430, 300, 73, 20);
        patient_infos.add(onco);
        onco.setBounds(590, 200, 190, 30);
        patient_infos.add(nom);
        nom.setBounds(220, 250, 190, 30);
        patient_infos.add(prenom);
        prenom.setBounds(600, 250, 190, 30);
        patient_infos.add(date_naiss);
        date_naiss.setBounds(220, 300, 190, 30);
        patient_infos.add(age);
        age.setBounds(600, 300, 190, 30);
        patient_infos.add(sexe);
        sexe.setBounds(220, 360, 190, 30);
        patient_infos.add(sit_fam);
        sit_fam.setBounds(220, 420, 190, 30);
        patient_infos.add(gsang);
        gsang.setBounds(600, 360, 190, 30);
        patient_infos.add(address);
        address.setBounds(220, 480, 190, 30);
        patient_infos.add(code_assurance);
        code_assurance.setBounds(600, 420, 190, 30);
        patient_infos.add(email);
        email.setBounds(220, 540, 190, 30);
        patient_infos.add(tlf);
        tlf.setBounds(600, 540, 190, 30);
        patient_infos.add(wilaya);
        wilaya.setBounds(600, 480, 190, 30);
        patient_infos.add(jSeparator4);
        jSeparator4.setBounds(10, 238, 780, 10);
        patient_infos.add(jSeparator1);
        jSeparator1.setBounds(50, 280, 360, 2);
        patient_infos.add(jSeparator2);
        jSeparator2.setBounds(50, 332, 360, 10);
        patient_infos.add(jSeparator3);
        jSeparator3.setBounds(50, 390, 360, 2);
        patient_infos.add(jSeparator5);
        jSeparator5.setBounds(50, 450, 0, 2);
        patient_infos.add(jSeparator6);
        jSeparator6.setBounds(50, 450, 360, 2);
        patient_infos.add(jSeparator7);
        jSeparator7.setBounds(50, 512, 360, 10);
        patient_infos.add(jSeparator8);
        jSeparator8.setBounds(50, 572, 370, 0);
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

        jLabel21.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(3, 182, 215));
        jLabel21.setText("Oncologue .R:");
        patient_infos.add(jLabel21);
        jLabel21.setBounds(430, 210, 150, 20);

        jLabel30.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(3, 182, 215));
        jLabel30.setText("N° dossier médical :");
        patient_infos.add(jLabel30);
        jLabel30.setBounds(430, 80, 170, 28);
        patient_infos.add(jSeparator16);
        jSeparator16.setBounds(430, 70, 360, 2);
        patient_infos.add(jSeparator17);
        jSeparator17.setBounds(430, 112, 360, 10);
        patient_infos.add(jSeparator18);
        jSeparator18.setBounds(430, 162, 360, 2);
        patient_infos.add(numdoss);
        numdoss.setBounds(600, 80, 190, 30);
        patient_infos.add(dateins);
        dateins.setBounds(600, 30, 190, 30);
        patient_infos.add(jSeparator19);
        jSeparator19.setBounds(430, 200, 360, 2);

        jLabel31.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(3, 182, 215));
        jLabel31.setText("identifiant:");
        patient_infos.add(jLabel31);
        jLabel31.setBounds(430, 120, 92, 30);

        jLabel32.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(3, 182, 215));
        jLabel32.setText("Pneumologue .R:");
        patient_infos.add(jLabel32);
        jLabel32.setBounds(430, 170, 150, 20);
        patient_infos.add(mat);
        mat.setBounds(590, 120, 190, 30);
        patient_infos.add(pneu);
        pneu.setBounds(590, 170, 190, 30);
        patient_infos.add(jSeparator20);
        jSeparator20.setBounds(430, 280, 360, 2);
        patient_infos.add(jSeparator21);
        jSeparator21.setBounds(430, 330, 360, 20);
        patient_infos.add(jSeparator22);
        jSeparator22.setBounds(430, 452, 360, 10);
        patient_infos.add(jSeparator23);
        jSeparator23.setBounds(430, 510, 360, 2);

        javax.swing.GroupLayout pn_infospLayout = new javax.swing.GroupLayout(pn_infosp);
        pn_infosp.setLayout(pn_infospLayout);
        pn_infospLayout.setHorizontalGroup(
            pn_infospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_infospLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(patient_infos, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );
        pn_infospLayout.setVerticalGroup(
            pn_infospLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_infospLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patient_infos, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout infos_personnelLayout = new javax.swing.GroupLayout(infos_personnel);
        infos_personnel.setLayout(infos_personnelLayout);
        infos_personnelLayout.setHorizontalGroup(
            infos_personnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infos_personnelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_infosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        infos_personnelLayout.setVerticalGroup(
            infos_personnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infos_personnelLayout.createSequentialGroup()
                .addComponent(pn_infosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(infos_personnel, "card3");

        S_pneumologie.setBackground(new java.awt.Color(255, 255, 255));
        S_pneumologie.setName("S_pneumologie"); // NOI18N
        S_pneumologie.setPreferredSize(new java.awt.Dimension(1400, 800));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(3, 182, 215));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Comptes Rendus  Des Consultations de pneumplogie");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        table_pneu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        table_pneu.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
        table_pneu.setColorBordeFilas(new java.awt.Color(52, 73, 94));
        table_pneu.setColorBordeHead(new java.awt.Color(52, 73, 94));
        table_pneu.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_pneu.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
        table_pneu.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
        table_pneu.setColorSelBackgound(new java.awt.Color(3, 182, 215));
        table_pneu.setGrosorBordeFilas(0);
        table_pneu.setGrosorBordeHead(0);
        table_pneu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_pneuMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(table_pneu);

        jScrollPane24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane24.setForeground(new java.awt.Color(52, 73, 94));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(52, 73, 94));
        jLabel44.setText("DR.");

        nom_prenom3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_prenom3.setForeground(new java.awt.Color(52, 73, 94));

        address4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        address4.setForeground(new java.awt.Color(52, 73, 94));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(52, 73, 94));
        jLabel45.setText("NOM:");

        nomp3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomp3.setForeground(new java.awt.Color(52, 73, 94));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(52, 73, 94));
        jLabel46.setText("Prenom:");

        prenomp3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomp3.setForeground(new java.awt.Color(52, 73, 94));

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(52, 73, 94));
        jLabel47.setText("Age :");

        AgeP3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AgeP3.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeP3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jSeparator40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(jSeparator41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomp3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomp3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel45))
                    .addComponent(nomp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prenomp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(AgeP3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jPanel21.setForeground(new java.awt.Color(52, 73, 94));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(52, 73, 94));
        jLabel48.setText("Dossier : ");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(52, 73, 94));
        jLabel49.setText("Le :");

        date_saisie1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_saisie1.setForeground(new java.awt.Color(52, 73, 94));

        doss1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doss1.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doss1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(date_saisie1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doss1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(2, 2, 2)
                .addComponent(jSeparator43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_saisie1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(52, 73, 94));
        jLabel50.setText("Diagnostic :");

        context1.setEditable(false);
        context1.setColumns(20);
        context1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        context1.setForeground(new java.awt.Color(52, 73, 94));
        context1.setRows(5);
        context1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane25.setViewportView(context1);

        jLabel51.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator39, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator45, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel50)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(spece1))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_prenom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel51)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(address4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator45, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(nom_prenom3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(address4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id1)
                    .addComponent(spece1)))
        );

        jScrollPane24.setViewportView(jPanel19);

        jDateChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        jDateChooser2.setForeground(new java.awt.Color(204, 204, 204));
        jDateChooser2.setToolTipText("choisir une date ");
        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout S_pneumologieLayout = new javax.swing.GroupLayout(S_pneumologie);
        S_pneumologie.setLayout(S_pneumologieLayout);
        S_pneumologieLayout.setHorizontalGroup(
            S_pneumologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_pneumologieLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(S_pneumologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(S_pneumologieLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(S_pneumologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        S_pneumologieLayout.setVerticalGroup(
            S_pneumologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_pneumologieLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(S_pneumologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(S_pneumologieLayout.createSequentialGroup()
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 180, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(S_pneumologie, "card7");

        S_oncologie.setBackground(new java.awt.Color(255, 255, 255));
        S_oncologie.setName("S_oncologie"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(3, 182, 215));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Comptes Rendus  Des Consultations d'oncologie");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane4.setForeground(new java.awt.Color(52, 73, 94));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 73, 94));
        jLabel2.setText("DR.");

        nom_prenom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_prenom.setForeground(new java.awt.Color(52, 73, 94));

        address1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        address1.setForeground(new java.awt.Color(52, 73, 94));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 73, 94));
        jLabel5.setText("NOM:");

        nomp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomp.setForeground(new java.awt.Color(52, 73, 94));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(52, 73, 94));
        jLabel17.setText("Prenom:");

        prenomp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomp.setForeground(new java.awt.Color(52, 73, 94));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(52, 73, 94));
        jLabel33.setText("Age :");

        AgeP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AgeP.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeP, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomp, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomp, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addComponent(nomp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prenomp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(AgeP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jPanel14.setForeground(new java.awt.Color(52, 73, 94));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(52, 73, 94));
        jLabel34.setText("Dossier : ");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(52, 73, 94));
        jLabel35.setText("Le :");

        date_saisie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_saisie.setForeground(new java.awt.Color(52, 73, 94));

        doss.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doss.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doss, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(date_saisie, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doss, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(2, 2, 2)
                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_saisie, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 73, 94));
        jLabel4.setText("Diagnostic :");

        context.setEditable(false);
        context.setColumns(20);
        context.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        context.setForeground(new java.awt.Color(52, 73, 94));
        context.setRows(5);
        context.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane1.setViewportView(context);

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator24, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(spece))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(address1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nom_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(address1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(spece)))
        );

        jScrollPane4.setViewportView(jPanel12);

        table_onco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        table_onco.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
        table_onco.setColorBordeFilas(new java.awt.Color(52, 73, 94));
        table_onco.setColorBordeHead(new java.awt.Color(52, 73, 94));
        table_onco.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_onco.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
        table_onco.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
        table_onco.setColorSelBackgound(new java.awt.Color(3, 182, 215));
        table_onco.setGrosorBordeFilas(0);
        table_onco.setGrosorBordeHead(0);
        table_onco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_oncoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_onco);

        javax.swing.GroupLayout S_oncologieLayout = new javax.swing.GroupLayout(S_oncologie);
        S_oncologie.setLayout(S_oncologieLayout);
        S_oncologieLayout.setHorizontalGroup(
            S_oncologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_oncologieLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(S_oncologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(S_oncologieLayout.createSequentialGroup()
                        .addGroup(S_oncologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18676, Short.MAX_VALUE))
        );
        S_oncologieLayout.setVerticalGroup(
            S_oncologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_oncologieLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(S_oncologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(S_oncologieLayout.createSequentialGroup()
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 121, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(S_oncologie, "card8");

        S_radiologie.setBackground(new java.awt.Color(255, 255, 255));
        S_radiologie.setName("S_radiologie"); // NOI18N

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(3, 182, 215));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Examens Radiologiques");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        jScrollPane6.setBorder(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));

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

        type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

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
                                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane6.setViewportView(jPanel5);

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
        table_radio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_radioMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(table_radio);

        javax.swing.GroupLayout S_radiologieLayout = new javax.swing.GroupLayout(S_radiologie);
        S_radiologie.setLayout(S_radiologieLayout);
        S_radiologieLayout.setHorizontalGroup(
            S_radiologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_radiologieLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(S_radiologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(S_radiologieLayout.createSequentialGroup()
                        .addGroup(S_radiologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18676, Short.MAX_VALUE))
        );
        S_radiologieLayout.setVerticalGroup(
            S_radiologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_radiologieLayout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(S_radiologieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(S_radiologieLayout.createSequentialGroup()
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(S_radiologieLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(S_radiologie, "card6");

        labo_analyses.setBackground(new java.awt.Color(255, 255, 255));
        labo_analyses.setName("labo_analyses"); // NOI18N

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(3, 182, 215));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText(" Analyses Médicales");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        jScrollPane8.setBorder(null);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));

        jLabel92.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(52, 73, 94));
        jLabel92.setText("DR.");

        nom_prenom9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_prenom9.setForeground(new java.awt.Color(52, 73, 94));

        address10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        address10.setForeground(new java.awt.Color(52, 73, 94));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(52, 73, 94));
        jLabel93.setText("NOM:");

        nomp9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomp9.setForeground(new java.awt.Color(52, 73, 94));

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(52, 73, 94));
        jLabel94.setText("Prenom:");

        prenomp9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomp9.setForeground(new java.awt.Color(52, 73, 94));

        jLabel95.setBackground(new java.awt.Color(255, 255, 255));
        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(52, 73, 94));
        jLabel95.setText("Age :");

        AgeP9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AgeP9.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeP9, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator84, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel93)
                            .addComponent(jSeparator82, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94)
                            .addComponent(jSeparator83, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomp9, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomp9, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel93))
                    .addComponent(nomp9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prenomp9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(AgeP9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jPanel39.setForeground(new java.awt.Color(52, 73, 94));

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(52, 73, 94));
        jLabel96.setText("Dossier : ");

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(52, 73, 94));
        jLabel97.setText("Le :");

        date_saisie7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_saisie7.setForeground(new java.awt.Color(52, 73, 94));

        doss7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doss7.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator86, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator85))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doss7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addGap(18, 18, 18)
                        .addComponent(date_saisie7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doss7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96))
                .addGap(2, 2, 2)
                .addComponent(jSeparator85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_saisie7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(52, 73, 94));
        jLabel98.setText("HEMATOLOGIE:");

        context7.setEditable(false);
        context7.setColumns(20);
        context7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        context7.setForeground(new java.awt.Color(52, 73, 94));
        context7.setRows(5);
        context7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane31.setViewportView(context7);

        jLabel99.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(52, 73, 94));

        type1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator81, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator87, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addGap(232, 232, 232)
                        .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(id7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(spece7))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addComponent(jLabel92)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_prenom9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel99)))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(address10, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel99)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator87, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92)
                    .addComponent(nom_prenom9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(address10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel98)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id7)
                    .addComponent(spece7)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane8.setViewportView(jPanel6);

        table_analyses.setModel(new javax.swing.table.DefaultTableModel(
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
        table_analyses.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
        table_analyses.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
        table_analyses.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
        table_analyses.setColorSelBackgound(new java.awt.Color(3, 182, 215));
        table_analyses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_analysesMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(table_analyses);

        javax.swing.GroupLayout labo_analysesLayout = new javax.swing.GroupLayout(labo_analyses);
        labo_analyses.setLayout(labo_analysesLayout);
        labo_analysesLayout.setHorizontalGroup(
            labo_analysesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labo_analysesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(labo_analysesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(labo_analysesLayout.createSequentialGroup()
                        .addGroup(labo_analysesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18676, Short.MAX_VALUE))
        );
        labo_analysesLayout.setVerticalGroup(
            labo_analysesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labo_analysesLayout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(labo_analysesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(labo_analysesLayout.createSequentialGroup()
                        .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(labo_analysesLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        rSPanelsSlider1.add(labo_analyses, "card7");

        S_anatomie_pathologique.setBackground(new java.awt.Color(255, 255, 255));
        S_anatomie_pathologique.setName("S_anatomie_pathologique"); // NOI18N

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(3, 182, 215));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Comptes Rundus Histo- pathologique");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        jScrollPane16.setBorder(null);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel52.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(52, 73, 94));
        jLabel52.setText("DR.");

        nom_prenom4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_prenom4.setForeground(new java.awt.Color(52, 73, 94));

        address5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        address5.setForeground(new java.awt.Color(52, 73, 94));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(52, 73, 94));
        jLabel53.setText("NOM:");

        nomp4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomp4.setForeground(new java.awt.Color(52, 73, 94));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(52, 73, 94));
        jLabel54.setText("Prenom:");

        prenomp4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomp4.setForeground(new java.awt.Color(52, 73, 94));

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(52, 73, 94));
        jLabel55.setText("Age :");

        AgeP4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AgeP4.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeP4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator49, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jSeparator47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)
                            .addComponent(jSeparator48, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomp4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomp4, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel53))
                    .addComponent(nomp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prenomp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(AgeP4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jPanel24.setForeground(new java.awt.Color(52, 73, 94));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(52, 73, 94));
        jLabel56.setText("Dossier : ");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(52, 73, 94));
        jLabel57.setText("Le :");

        date_saisie2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_saisie2.setForeground(new java.awt.Color(52, 73, 94));

        doss2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doss2.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator51, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doss2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(18, 18, 18)
                        .addComponent(date_saisie2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doss2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(2, 2, 2)
                .addComponent(jSeparator50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_saisie2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(52, 73, 94));
        jLabel58.setText("Diagnostic :");

        context2.setEditable(false);
        context2.setColumns(20);
        context2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        context2.setForeground(new java.awt.Color(52, 73, 94));
        context2.setRows(5);
        context2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane26.setViewportView(context2);

        jLabel59.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator46, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator52, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel58)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(spece2))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_prenom4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel59)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(address5, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator52, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(nom_prenom4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(address5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id2)
                    .addComponent(spece2)))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane16.setViewportView(jPanel11);

        table_anap.setModel(new javax.swing.table.DefaultTableModel(
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
        table_anap.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
        table_anap.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
        table_anap.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
        table_anap.setColorSelBackgound(new java.awt.Color(3, 182, 215));
        table_anap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_anapMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(table_anap);

        javax.swing.GroupLayout S_anatomie_pathologiqueLayout = new javax.swing.GroupLayout(S_anatomie_pathologique);
        S_anatomie_pathologique.setLayout(S_anatomie_pathologiqueLayout);
        S_anatomie_pathologiqueLayout.setHorizontalGroup(
            S_anatomie_pathologiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_anatomie_pathologiqueLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(S_anatomie_pathologiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(S_anatomie_pathologiqueLayout.createSequentialGroup()
                        .addGroup(S_anatomie_pathologiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jDateChooser6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18676, Short.MAX_VALUE))
        );
        S_anatomie_pathologiqueLayout.setVerticalGroup(
            S_anatomie_pathologiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_anatomie_pathologiqueLayout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(S_anatomie_pathologiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(S_anatomie_pathologiqueLayout.createSequentialGroup()
                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(S_anatomie_pathologiqueLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        rSPanelsSlider1.add(S_anatomie_pathologique, "card10");

        S_radiotherapie.setBackground(new java.awt.Color(255, 255, 255));
        S_radiotherapie.setName("S_radiotherapie"); // NOI18N

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(3, 182, 215));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Comptes rendus de la Radiothérapie");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        jScrollPane10.setBorder(null);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jLabel100.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(52, 73, 94));
        jLabel100.setText("DR.");

        nom_prenom10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_prenom10.setForeground(new java.awt.Color(52, 73, 94));

        address11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        address11.setForeground(new java.awt.Color(52, 73, 94));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(52, 73, 94));
        jLabel101.setText("NOM:");

        nomp10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomp10.setForeground(new java.awt.Color(52, 73, 94));

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(52, 73, 94));
        jLabel102.setText("Prenom:");

        prenomp10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomp10.setForeground(new java.awt.Color(52, 73, 94));

        jLabel103.setBackground(new java.awt.Color(255, 255, 255));
        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(52, 73, 94));
        jLabel103.setText("Age :");

        AgeP10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AgeP10.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeP10, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator91, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel101)
                            .addComponent(jSeparator89, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel102)
                            .addComponent(jSeparator90, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomp10, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomp10, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel101))
                    .addComponent(nomp10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prenomp10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(AgeP10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jPanel42.setForeground(new java.awt.Color(52, 73, 94));

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(52, 73, 94));
        jLabel104.setText("Dossier : ");

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(52, 73, 94));
        jLabel105.setText("Le :");

        date_saisie8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_saisie8.setForeground(new java.awt.Color(52, 73, 94));

        doss8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doss8.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator93, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator92))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doss8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel105)
                        .addGap(18, 18, 18)
                        .addComponent(date_saisie8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doss8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104))
                .addGap(2, 2, 2)
                .addComponent(jSeparator92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_saisie8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(52, 73, 94));
        jLabel106.setText("Diagnostic :");

        context8.setEditable(false);
        context8.setColumns(20);
        context8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        context8.setForeground(new java.awt.Color(52, 73, 94));
        context8.setRows(5);
        context8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane32.setViewportView(context8);

        jLabel107.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator88, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator94, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel106)
                    .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(id8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(spece8))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(jLabel100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_prenom10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel107)))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(address11, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel107)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator94, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel100)
                    .addComponent(nom_prenom10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(address11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel106)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id8)
                    .addComponent(spece8)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane10.setViewportView(jPanel7);

        table_radt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Date"
            }
        ));
        table_radt.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
        table_radt.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
        table_radt.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
        table_radt.setColorSelBackgound(new java.awt.Color(3, 182, 215));
        table_radt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_radtMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(table_radt);

        javax.swing.GroupLayout S_radiotherapieLayout = new javax.swing.GroupLayout(S_radiotherapie);
        S_radiotherapie.setLayout(S_radiotherapieLayout);
        S_radiotherapieLayout.setHorizontalGroup(
            S_radiotherapieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_radiotherapieLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(S_radiotherapieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(S_radiotherapieLayout.createSequentialGroup()
                        .addGroup(S_radiotherapieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jDateChooser7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18676, Short.MAX_VALUE))
        );
        S_radiotherapieLayout.setVerticalGroup(
            S_radiotherapieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_radiotherapieLayout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(S_radiotherapieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(S_radiotherapieLayout.createSequentialGroup()
                        .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(S_radiotherapieLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        rSPanelsSlider1.add(S_radiotherapie, "card7");

        S_chirurgie.setBackground(new java.awt.Color(255, 255, 255));
        S_chirurgie.setName("S_chirurgie"); // NOI18N

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(3, 182, 215));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText(" Comptes rendus de la Chirurgie Thoracique");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        jScrollPane12.setBorder(null);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jLabel60.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(52, 73, 94));
        jLabel60.setText("DR.");

        nom_prenom5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_prenom5.setForeground(new java.awt.Color(52, 73, 94));

        address6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        address6.setForeground(new java.awt.Color(52, 73, 94));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(52, 73, 94));
        jLabel61.setText("NOM:");

        nomp5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomp5.setForeground(new java.awt.Color(52, 73, 94));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(52, 73, 94));
        jLabel62.setText("Prenom:");

        prenomp5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomp5.setForeground(new java.awt.Color(52, 73, 94));

        jLabel63.setBackground(new java.awt.Color(255, 255, 255));
        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(52, 73, 94));
        jLabel63.setText("Age :");

        AgeP5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AgeP5.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeP5, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator56, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jSeparator54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62)
                            .addComponent(jSeparator55, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomp5, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomp5, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel61))
                    .addComponent(nomp5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prenomp5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(AgeP5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jPanel27.setForeground(new java.awt.Color(52, 73, 94));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(52, 73, 94));
        jLabel64.setText("Dossier : ");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(52, 73, 94));
        jLabel65.setText("Le :");

        date_saisie3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_saisie3.setForeground(new java.awt.Color(52, 73, 94));

        doss3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doss3.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator58, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doss3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addGap(18, 18, 18)
                        .addComponent(date_saisie3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doss3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addGap(2, 2, 2)
                .addComponent(jSeparator57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_saisie3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(52, 73, 94));
        jLabel66.setText("Diagnostic :");

        context3.setEditable(false);
        context3.setColumns(20);
        context3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        context3.setForeground(new java.awt.Color(52, 73, 94));
        context3.setRows(5);
        context3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane27.setViewportView(context3);

        jLabel67.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator53, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator59, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel66)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(id3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(spece3))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_prenom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel67)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(address6, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator59, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addComponent(nom_prenom5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(address6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id3)
                    .addComponent(spece3)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane12.setViewportView(jPanel8);

        table_chir.setModel(new javax.swing.table.DefaultTableModel(
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
        table_chir.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
        table_chir.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
        table_chir.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
        table_chir.setColorSelBackgound(new java.awt.Color(3, 182, 215));
        table_chir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_chirMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(table_chir);

        javax.swing.GroupLayout S_chirurgieLayout = new javax.swing.GroupLayout(S_chirurgie);
        S_chirurgie.setLayout(S_chirurgieLayout);
        S_chirurgieLayout.setHorizontalGroup(
            S_chirurgieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_chirurgieLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(S_chirurgieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(S_chirurgieLayout.createSequentialGroup()
                        .addGroup(S_chirurgieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jDateChooser8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18676, Short.MAX_VALUE))
        );
        S_chirurgieLayout.setVerticalGroup(
            S_chirurgieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(S_chirurgieLayout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(S_chirurgieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(S_chirurgieLayout.createSequentialGroup()
                        .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(S_chirurgieLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        rSPanelsSlider1.add(S_chirurgie, "card8");

        pharmacie.setBackground(new java.awt.Color(255, 255, 255));
        pharmacie.setName("pharmacie"); // NOI18N

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(3, 182, 215));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Données Pharmacologiques");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        jScrollPane14.setBorder(null);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(52, 73, 94));
        jLabel68.setText("DR.");

        nom_prenom6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_prenom6.setForeground(new java.awt.Color(52, 73, 94));

        address7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        address7.setForeground(new java.awt.Color(52, 73, 94));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(52, 73, 94));
        jLabel69.setText("NOM:");

        nomp6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomp6.setForeground(new java.awt.Color(52, 73, 94));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(52, 73, 94));
        jLabel70.setText("Prenom:");

        prenomp6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomp6.setForeground(new java.awt.Color(52, 73, 94));

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(52, 73, 94));
        jLabel71.setText("Age :");

        AgeP6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AgeP6.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeP6, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator63, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69)
                            .addComponent(jSeparator61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70)
                            .addComponent(jSeparator62, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomp6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomp6, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel69))
                    .addComponent(nomp6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prenomp6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(AgeP6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jPanel30.setForeground(new java.awt.Color(52, 73, 94));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(52, 73, 94));
        jLabel72.setText("Dossier : ");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(52, 73, 94));
        jLabel73.setText("Le :");

        date_saisie4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_saisie4.setForeground(new java.awt.Color(52, 73, 94));

        doss4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doss4.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator65, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator64))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doss4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(18, 18, 18)
                        .addComponent(date_saisie4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doss4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addGap(2, 2, 2)
                .addComponent(jSeparator64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_saisie4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(52, 73, 94));
        jLabel74.setText("Médicaments :");

        context4.setEditable(false);
        context4.setColumns(20);
        context4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        context4.setForeground(new java.awt.Color(52, 73, 94));
        context4.setRows(5);
        context4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane28.setViewportView(context4);

        jLabel75.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator60, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator66, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel74)
                    .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(id4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(spece4))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_prenom6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel75)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(address7, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator66, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addComponent(nom_prenom6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(address7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id4)
                    .addComponent(spece4)))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane14.setViewportView(jPanel9);

        jScrollPane15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane15MouseClicked(evt);
            }
        });

        table_pharm.setModel(new javax.swing.table.DefaultTableModel(
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
        table_pharm.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
        table_pharm.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
        table_pharm.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
        table_pharm.setColorSelBackgound(new java.awt.Color(3, 182, 215));
        table_pharm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_pharmMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(table_pharm);

        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));
        jDateChooser1.setForeground(new java.awt.Color(204, 204, 204));
        jDateChooser1.setToolTipText("choisir une date ");
        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout pharmacieLayout = new javax.swing.GroupLayout(pharmacie);
        pharmacie.setLayout(pharmacieLayout);
        pharmacieLayout.setHorizontalGroup(
            pharmacieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pharmacieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pharmacieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pharmacieLayout.createSequentialGroup()
                        .addGroup(pharmacieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 1273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18727, Short.MAX_VALUE))
        );
        pharmacieLayout.setVerticalGroup(
            pharmacieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pharmacieLayout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(pharmacieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pharmacieLayout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pharmacieLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        rSPanelsSlider1.add(pharmacie, "card9");

        C_medecin_local.setBackground(new java.awt.Color(255, 255, 255));
        C_medecin_local.setName("C_medecin_local"); // NOI18N

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(3, 182, 215));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Comptes Rendus  Des Consultations de médecin local");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215)));

        jScrollPane18.setBorder(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 182, 215), 3));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel76.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(52, 73, 94));
        jLabel76.setText("DR.");

        nom_prenom7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_prenom7.setForeground(new java.awt.Color(52, 73, 94));

        address8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        address8.setForeground(new java.awt.Color(52, 73, 94));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(52, 73, 94));
        jLabel77.setText("NOM:");

        nomp7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomp7.setForeground(new java.awt.Color(52, 73, 94));

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(52, 73, 94));
        jLabel78.setText("Prenom:");

        prenomp7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomp7.setForeground(new java.awt.Color(52, 73, 94));

        jLabel79.setBackground(new java.awt.Color(255, 255, 255));
        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(52, 73, 94));
        jLabel79.setText("Age :");

        AgeP7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AgeP7.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AgeP7, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator70, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel77)
                            .addComponent(jSeparator68, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78)
                            .addComponent(jSeparator69, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomp7, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomp7, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel77))
                    .addComponent(nomp7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prenomp7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(AgeP7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jPanel33.setForeground(new java.awt.Color(52, 73, 94));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(52, 73, 94));
        jLabel80.setText("Dossier : ");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(52, 73, 94));
        jLabel81.setText("Le :");

        date_saisie5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_saisie5.setForeground(new java.awt.Color(52, 73, 94));

        doss5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        doss5.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator72, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator71))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doss5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addGap(18, 18, 18)
                        .addComponent(date_saisie5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doss5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80))
                .addGap(2, 2, 2)
                .addComponent(jSeparator71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_saisie5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(52, 73, 94));
        jLabel82.setText("Diagnostic :");

        context5.setEditable(false);
        context5.setColumns(20);
        context5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        context5.setForeground(new java.awt.Color(52, 73, 94));
        context5.setRows(5);
        context5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        jScrollPane29.setViewportView(context5);

        jLabel83.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator67, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator73, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel82)
                    .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(id5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(spece5))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel31Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_prenom7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel83)))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(address8, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator73, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel76)
                    .addComponent(nom_prenom7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(address8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id5)
                    .addComponent(spece5)))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane18.setViewportView(jPanel10);

        jScrollPane19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane19MouseClicked(evt);
            }
        });

        table_med.setModel(new javax.swing.table.DefaultTableModel(
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
        table_med.setColorBackgoundHead(new java.awt.Color(3, 182, 215));
        table_med.setColorFilasForeground1(new java.awt.Color(3, 182, 215));
        table_med.setColorFilasForeground2(new java.awt.Color(3, 182, 215));
        table_med.setColorSelBackgound(new java.awt.Color(3, 182, 215));
        table_med.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_medMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(table_med);

        javax.swing.GroupLayout C_medecin_localLayout = new javax.swing.GroupLayout(C_medecin_local);
        C_medecin_local.setLayout(C_medecin_localLayout);
        C_medecin_localLayout.setHorizontalGroup(
            C_medecin_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_medecin_localLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(C_medecin_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(C_medecin_localLayout.createSequentialGroup()
                        .addGroup(C_medecin_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(C_medecin_localLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18699, Short.MAX_VALUE))
        );
        C_medecin_localLayout.setVerticalGroup(
            C_medecin_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(C_medecin_localLayout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(C_medecin_localLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(C_medecin_localLayout.createSequentialGroup()
                        .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 41, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(C_medecin_local, "card11");

        jPanel1.add(rSPanelsSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 20010, 630));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_suiv.setBackground(new java.awt.Color(3, 182, 215));
        btn_suiv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Double_Right_30px_1.png"))); // NOI18N
        btn_suiv.setText("Suivant");
        btn_suiv.setColorHover(new java.awt.Color(52, 73, 94));
        btn_suiv.setColorTextHover(new java.awt.Color(3, 182, 215));
        btn_suiv.setFocusPainted(false);
        btn_suiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suivActionPerformed(evt);
            }
        });

        btn_prec.setBackground(new java.awt.Color(3, 182, 215));
        btn_prec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plateforme_cancer_du_poumon/images/icons8_Double_Left_30px_1.png"))); // NOI18N
        btn_prec.setText("Précedent");
        btn_prec.setColorHover(new java.awt.Color(52, 73, 94));
        btn_prec.setColorTextHover(new java.awt.Color(3, 182, 215));
        btn_prec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_precActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_prec, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 955, Short.MAX_VALUE)
                .addComponent(btn_suiv, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_suiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_prec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 1310, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1418, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suivActionPerformed
        if (variables.compteur < 10 && variables.compteur> 0) {
            variables.compteur++;
            if (variables.compteur == 2) {
                rSPanelsSlider1.slidPanel(2, S_pneumologie, RSPanelsSlider.direct.Right);
                 Affichertable_CRS_PNEU();

            }
            if (variables.compteur == 3) {
                rSPanelsSlider1.slidPanel(2, S_oncologie, RSPanelsSlider.direct.Right);
                Affichertable_CRS_ONCO();
            }
            if (variables.compteur == 4) {
                rSPanelsSlider1.slidPanel(2, S_radiologie, RSPanelsSlider.direct.Right);
               Affichertable_CRS_RADIO();
            }
            if (variables.compteur== 5) {
                rSPanelsSlider1.slidPanel(2, labo_analyses, RSPanelsSlider.direct.Right);
                Affichertable_CRS_LABO();
            }
            if (variables.compteur == 6) {
                rSPanelsSlider1.slidPanel(2, S_anatomie_pathologique, RSPanelsSlider.direct.Right);
                Affichertable_CRS_ANAP();
            }

            if (variables.compteur == 7) {
                rSPanelsSlider1.slidPanel(2, S_radiotherapie, RSPanelsSlider.direct.Right);
                Affichertable_CRS_RADT();
            }
            if (variables.compteur == 8) {
                rSPanelsSlider1.slidPanel(2, S_chirurgie, RSPanelsSlider.direct.Right);
             Affichertable_CRS_CHIR();
            }

            if (variables.compteur == 9) {
                rSPanelsSlider1.slidPanel(2,pharmacie, RSPanelsSlider.direct.Right);
              Affichertable_CRS_PHARM();
            }
            if (variables.compteur == 10) {
                rSPanelsSlider1.slidPanel(2, C_medecin_local, RSPanelsSlider.direct.Right);
                Affichertable_CRS_MED();
            }

        }
    }//GEN-LAST:event_btn_suivActionPerformed

    private void btn_precActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_precActionPerformed
        if (variables.compteur < 11 && variables.compteur> 1) {
            variables.compteur--;
            if (variables.compteur  == 1) {
                rSPanelsSlider1.slidPanel(2, infos_personnel, RSPanelsSlider.direct.Left);
                //this.btn_prec.setEnabled(false);
                // remplir les champs
            }
            if (variables.compteur == 2) {
                rSPanelsSlider1.slidPanel(2, S_pneumologie, RSPanelsSlider.direct.Left);
                Affichertable_CRS_PNEU();

            }
            if (variables.compteur == 3) {
                rSPanelsSlider1.slidPanel(2, S_oncologie, RSPanelsSlider.direct.Left);
                Affichertable_CRS_ONCO();
            }
            if (variables.compteur == 4) {
                rSPanelsSlider1.slidPanel(2, S_radiologie, RSPanelsSlider.direct.Left);
                Affichertable_CRS_RADIO();
            }
            if (variables.compteur== 5) {
                rSPanelsSlider1.slidPanel(2, labo_analyses, RSPanelsSlider.direct.Left);
                Affichertable_CRS_LABO();
            }
            if (variables.compteur == 6) {
                rSPanelsSlider1.slidPanel(2, S_anatomie_pathologique, RSPanelsSlider.direct.Left);
               Affichertable_CRS_ANAP();
            }

            if (variables.compteur == 7) {
                rSPanelsSlider1.slidPanel(2, S_radiotherapie, RSPanelsSlider.direct.Left);
                Affichertable_CRS_RADT();
            }
            if (variables.compteur == 8) {
                rSPanelsSlider1.slidPanel(2, S_chirurgie, RSPanelsSlider.direct.Left);
                Affichertable_CRS_CHIR();
            }

            if (variables.compteur == 9) {
                rSPanelsSlider1.slidPanel(2, pharmacie, RSPanelsSlider.direct.Left);
               Affichertable_CRS_PHARM();
            }

        }
    }//GEN-LAST:event_btn_precActionPerformed

    private void table_oncoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_oncoMouseClicked
       afficher_detail_CR_ONCO();
    }//GEN-LAST:event_table_oncoMouseClicked

    private void table_pneuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_pneuMouseClicked
     afficher_detail_CR_PNEU();
    }//GEN-LAST:event_table_pneuMouseClicked

    private void jScrollPane19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane19MouseClicked

    private void table_medMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_medMouseClicked
       afficher_detail_CR_MED();
    }//GEN-LAST:event_table_medMouseClicked

    private void jScrollPane15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane15MouseClicked
     
    }//GEN-LAST:event_jScrollPane15MouseClicked

    private void table_chirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_chirMouseClicked
       afficher_detail_CR_CHIR();
    }//GEN-LAST:event_table_chirMouseClicked

    private void table_pharmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_pharmMouseClicked
    afficher_detail_CR_PHARM();
    }//GEN-LAST:event_table_pharmMouseClicked

    private void table_radtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_radtMouseClicked
       afficher_detail_CR_RADT();
    }//GEN-LAST:event_table_radtMouseClicked

    private void table_anapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_anapMouseClicked
      afficher_detail_CR_ANAP();
    }//GEN-LAST:event_table_anapMouseClicked

    private void table_analysesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_analysesMouseClicked
      afficher_detail_CR_LABO();
    }//GEN-LAST:event_table_analysesMouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
      
          I.setVisible(true);

    }//GEN-LAST:event_jLabel36MouseClicked

    private void table_radioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_radioMouseClicked
     afficher_detail_CR_RADIO();
    }//GEN-LAST:event_table_radioMouseClicked

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
            java.util.logging.Logger.getLogger(dossier_med.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dossier_med.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dossier_med.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dossier_med.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dossier_med().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel AgeP;
    public javax.swing.JLabel AgeP10;
    public javax.swing.JLabel AgeP3;
    public javax.swing.JLabel AgeP4;
    public javax.swing.JLabel AgeP5;
    public javax.swing.JLabel AgeP6;
    public javax.swing.JLabel AgeP7;
    public javax.swing.JLabel AgeP8;
    public javax.swing.JLabel AgeP9;
    private javax.swing.JPanel C_medecin_local;
    private javax.swing.JPanel S_anatomie_pathologique;
    private javax.swing.JPanel S_chirurgie;
    private javax.swing.JPanel S_oncologie;
    private javax.swing.JPanel S_pneumologie;
    private javax.swing.JPanel S_radiologie;
    private javax.swing.JPanel S_radiotherapie;
    public javax.swing.JLabel address;
    public javax.swing.JLabel address1;
    public javax.swing.JLabel address10;
    public javax.swing.JLabel address11;
    public javax.swing.JLabel address4;
    public javax.swing.JLabel address5;
    public javax.swing.JLabel address6;
    public javax.swing.JLabel address7;
    public javax.swing.JLabel address8;
    public javax.swing.JLabel address9;
    public javax.swing.JLabel age;
    private rojerusan.RSButtonIconI btn_prec;
    private rojerusan.RSButtonIconD btn_suiv;
    public javax.swing.JLabel code_assurance;
    public javax.swing.JTextArea context;
    public javax.swing.JTextArea context1;
    public javax.swing.JTextArea context2;
    public javax.swing.JTextArea context3;
    public javax.swing.JTextArea context4;
    public javax.swing.JTextArea context5;
    public javax.swing.JTextArea context6;
    public javax.swing.JTextArea context7;
    public javax.swing.JTextArea context8;
    public javax.swing.JLabel date_naiss;
    public javax.swing.JLabel date_saisie;
    public javax.swing.JLabel date_saisie1;
    public javax.swing.JLabel date_saisie2;
    public javax.swing.JLabel date_saisie3;
    public javax.swing.JLabel date_saisie4;
    public javax.swing.JLabel date_saisie5;
    public javax.swing.JLabel date_saisie6;
    public javax.swing.JLabel date_saisie7;
    public javax.swing.JLabel date_saisie8;
    public javax.swing.JLabel dateins;
    public javax.swing.JLabel doss;
    public javax.swing.JLabel doss1;
    public javax.swing.JLabel doss2;
    public javax.swing.JLabel doss3;
    public javax.swing.JLabel doss4;
    public javax.swing.JLabel doss5;
    public javax.swing.JLabel doss6;
    public javax.swing.JLabel doss7;
    public javax.swing.JLabel doss8;
    public javax.swing.JLabel email;
    public javax.swing.JLabel gsang;
    public javax.swing.JLabel id;
    public javax.swing.JLabel id1;
    public javax.swing.JLabel id2;
    public javax.swing.JLabel id3;
    public javax.swing.JLabel id4;
    public javax.swing.JLabel id5;
    public javax.swing.JLabel id6;
    public javax.swing.JLabel id7;
    public javax.swing.JLabel id8;
    public javax.swing.JLabel image;
    private javax.swing.JPanel infos_personnel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
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
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator47;
    private javax.swing.JSeparator jSeparator48;
    private javax.swing.JSeparator jSeparator49;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator50;
    private javax.swing.JSeparator jSeparator51;
    private javax.swing.JSeparator jSeparator52;
    private javax.swing.JSeparator jSeparator53;
    private javax.swing.JSeparator jSeparator54;
    private javax.swing.JSeparator jSeparator55;
    private javax.swing.JSeparator jSeparator56;
    private javax.swing.JSeparator jSeparator57;
    private javax.swing.JSeparator jSeparator58;
    private javax.swing.JSeparator jSeparator59;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator60;
    private javax.swing.JSeparator jSeparator61;
    private javax.swing.JSeparator jSeparator62;
    private javax.swing.JSeparator jSeparator63;
    private javax.swing.JSeparator jSeparator64;
    private javax.swing.JSeparator jSeparator65;
    private javax.swing.JSeparator jSeparator66;
    private javax.swing.JSeparator jSeparator67;
    private javax.swing.JSeparator jSeparator68;
    private javax.swing.JSeparator jSeparator69;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator70;
    private javax.swing.JSeparator jSeparator71;
    private javax.swing.JSeparator jSeparator72;
    private javax.swing.JSeparator jSeparator73;
    private javax.swing.JSeparator jSeparator74;
    private javax.swing.JSeparator jSeparator75;
    private javax.swing.JSeparator jSeparator76;
    private javax.swing.JSeparator jSeparator77;
    private javax.swing.JSeparator jSeparator78;
    private javax.swing.JSeparator jSeparator79;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator80;
    private javax.swing.JSeparator jSeparator81;
    private javax.swing.JSeparator jSeparator82;
    private javax.swing.JSeparator jSeparator83;
    private javax.swing.JSeparator jSeparator84;
    private javax.swing.JSeparator jSeparator85;
    private javax.swing.JSeparator jSeparator86;
    private javax.swing.JSeparator jSeparator87;
    private javax.swing.JSeparator jSeparator88;
    private javax.swing.JSeparator jSeparator89;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSeparator jSeparator90;
    private javax.swing.JSeparator jSeparator91;
    private javax.swing.JSeparator jSeparator92;
    private javax.swing.JSeparator jSeparator93;
    private javax.swing.JSeparator jSeparator94;
    private javax.swing.JPanel labo_analyses;
    public javax.swing.JLabel mat;
    public javax.swing.JLabel nom;
    public javax.swing.JLabel nom_prenom;
    public javax.swing.JLabel nom_prenom10;
    public javax.swing.JLabel nom_prenom3;
    public javax.swing.JLabel nom_prenom4;
    public javax.swing.JLabel nom_prenom5;
    public javax.swing.JLabel nom_prenom6;
    public javax.swing.JLabel nom_prenom7;
    public javax.swing.JLabel nom_prenom8;
    public javax.swing.JLabel nom_prenom9;
    public javax.swing.JLabel nomp;
    public javax.swing.JLabel nomp10;
    public javax.swing.JLabel nomp3;
    public javax.swing.JLabel nomp4;
    public javax.swing.JLabel nomp5;
    public javax.swing.JLabel nomp6;
    public javax.swing.JLabel nomp7;
    public javax.swing.JLabel nomp8;
    public javax.swing.JLabel nomp9;
    public javax.swing.JLabel numdoss;
    public javax.swing.JLabel onco;
    private javax.swing.JPanel patient_infos;
    private javax.swing.JPanel pharmacie;
    private javax.swing.JPanel pn_infosp;
    public javax.swing.JLabel pneu;
    public javax.swing.JLabel prenom;
    public javax.swing.JLabel prenomp;
    public javax.swing.JLabel prenomp10;
    public javax.swing.JLabel prenomp3;
    public javax.swing.JLabel prenomp4;
    public javax.swing.JLabel prenomp5;
    public javax.swing.JLabel prenomp6;
    public javax.swing.JLabel prenomp7;
    public javax.swing.JLabel prenomp8;
    public javax.swing.JLabel prenomp9;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    public javax.swing.JLabel sexe;
    public javax.swing.JLabel sit_fam;
    public javax.swing.JLabel spece;
    public javax.swing.JLabel spece1;
    public javax.swing.JLabel spece2;
    public javax.swing.JLabel spece3;
    public javax.swing.JLabel spece4;
    public javax.swing.JLabel spece5;
    public javax.swing.JLabel spece6;
    public javax.swing.JLabel spece7;
    public javax.swing.JLabel spece8;
    private rojerusan.RSTableMetro table_analyses;
    private rojerusan.RSTableMetro table_anap;
    private rojerusan.RSTableMetro table_chir;
    private rojerusan.RSTableMetro table_med;
    private rojerusan.RSTableMetro table_onco;
    private rojerusan.RSTableMetro table_pharm;
    private rojerusan.RSTableMetro table_pneu;
    private rojerusan.RSTableMetro table_radio;
    private rojerusan.RSTableMetro table_radt;
    public javax.swing.JLabel tlf;
    private javax.swing.JLabel type;
    private javax.swing.JLabel type1;
    public javax.swing.JLabel wilaya;
    // End of variables declaration//GEN-END:variables
}

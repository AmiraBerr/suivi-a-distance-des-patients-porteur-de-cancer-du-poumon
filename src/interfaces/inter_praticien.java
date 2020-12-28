/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Espace_Patient.patient_home;
import static Espace_Patient.patient_home.specialite;
import Listes.praticien;
import Login.DB_Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static public_var.variables.*;

/**
 *
 * @author berich
 */
public class inter_praticien implements Interface_G<praticien>{
   
    @Override
   
        
     public List<praticien> selectpneumologue() {
         List<praticien> l = new ArrayList<>();
         
        try {
           cnx =DB_Connexion.Connexion();
            String spe="pneumologue";
            String rqt = "select * from praticien where praticien_specialite LIKE '"+spe+"' ";
          PreparedStatement   ps4 = cnx.prepareStatement(rqt);
       ResultSet     rs4 = ps4.executeQuery();
            while (rs4.next()) {
           praticien m = new praticien(rs4.getString("praticien_identifiant"),rs4.getString("praticien_password"),rs4.getString("praticien_nom"), rs4.getString("praticien_prenom"), rs4.getString("praticien_type"),rs4.getString("praticien_specialite"),rs4.getString("address"),rs4.getString("praticien_email"),rs4.getString("praticien_num_phone"));
            l.add(m);
            }
          
                ps4.close();
                rs4.close();
                //cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(inter_praticien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public List<praticien> selectoncologue() {
         List<praticien> l = new ArrayList<>();
         
        try {
           cnx =DB_Connexion.Connexion();
            String sp="oncologue";
            String rqt = "select * from praticien where praticien_specialite LIKE '"+sp+"' ";
            PreparedStatement   ps3 = cnx.prepareStatement(rqt);
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
            praticien m = new praticien(rs3.getString("praticien_identifiant"),rs3.getString("praticien_password"),rs3.getString("praticien_nom"), rs3.getString("praticien_prenom"), rs3.getString("praticien_type"),rs3.getString("praticien_specialite"), rs3.getString("address"),     rs3.getString("praticien_email"),rs3.getString("praticien_num_phone"));
            l.add(m);
            }
             
                ps3.close();
                rs3.close();
                //cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(inter_praticien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public void insertinfos_suivi(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<praticien> selectinfos_suivi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRDV(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<praticien> selectRDV_pra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<praticien> selectspec() {
        
      
        List<praticien> l = new ArrayList<>();
         
        try {
           cnx =DB_Connexion.Connexion();
            String spec=specialite;
            String rqt = "select * from praticien where praticien_specialite LIKE '"+spec+"' ";
           PreparedStatement ps6 = cnx.prepareStatement(rqt);
           ResultSet rs6 = ps6.executeQuery();
            while (rs6.next()) {
            praticien m = new praticien(rs6.getString("praticien_identifiant"),rs6.getString("praticien_password"),rs6.getString("praticien_nom"), rs6.getString("praticien_prenom"), rs6.getString("praticien_type"),rs6.getString("praticien_specialite"),rs6.getString("address"),rs6.getString("praticien_email"),rs6.getString("praticien_num_phone"));
            l.add(m);
            }
                
            ps.close();
            rs.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(inter_praticien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
        
        
        
    }

    @Override
    public praticien selectnom_prenom(String id) {
       
          praticien m = null;
        try {
           Connection cnx1 =DB_Connexion.Connexion();
            
           String rqt = "select * from praticien where praticien_identifiant LIKE '"+id+"' ";
           PreparedStatement   ps1 = cnx1.prepareStatement(rqt);
           ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
             m = new praticien(rs1.getString("praticien_identifiant"),rs1.getString("praticien_password"),rs1.getString("praticien_nom"), rs1.getString("praticien_prenom"), rs1.getString("praticien_type"),rs1.getString("praticien_specialite"),rs1.getString("address"),rs1.getString("praticien_email"),rs1.getString("praticien_num_phone"));
            
            }
                
               ps1.close();
               rs1.close();
        } catch (SQLException ex) {
            Logger.getLogger(inter_praticien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
       
    }

    @Override
    public void insertRDV_pra(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertrapport_Examination(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert_radiotherapie(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertExamens_Radiologique(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertDonneesPharmacologique(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertChirurgie(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAnatomiePathologique(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAnalyses(praticien objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
     
     
     
    
}

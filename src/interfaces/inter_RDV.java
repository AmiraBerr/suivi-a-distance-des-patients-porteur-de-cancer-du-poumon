/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Listes.RDV;
import Listes.praticien;
import Login.DB_Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static public_var.variables.cnx;
import static public_var.variables.ps;
import static public_var.variables.rs;

/**
 *
 * @author berich
 */
public class inter_RDV  implements Interface_G<RDV> {

    @Override
    public List<RDV> selectpneumologue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RDV> selectoncologue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertinfos_suivi(RDV objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RDV> selectinfos_suivi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRDV(RDV objet) {
       
         try {
           cnx= DB_Connexion.Connexion();
            String rqt = "INSERT INTO `rendez_vous`(`date_envoie`,`heure_envoie`,`desc`,`Num_doss_med`, `id_Praticien`, `date_RDV`,`heure_RDV`,`Raison`) VALUES (?,?,?,?,?,?,?,?)";
             ps = cnx.prepareStatement(rqt);
             ps.setString(1, objet.getDate_envoie());
             ps.setString(2, objet.getHeure_envoie());
             ps.setString(3,"demander");
             ps.setString(4, objet.getNum_doss());
             ps.setString(5, objet.getId_praticien());
             ps.setString(6, objet.getDate());
             ps.setString(7, objet.getHeure());
             ps.setString(8, objet.getRaison());
             
             ps.execute();
             ps.close();
             rs.close();
        JOptionPane.showMessageDialog(null, "envoyé avec succès ");
        } 
         catch (SQLException e) {
          System.out.println("--> SQLException : " + e);
          JOptionPane.showMessageDialog(null, e.getMessage());
    } 
    }

    
    public void insertRDV_pra(RDV objet) {
       
         try {
           cnx= DB_Connexion.Connexion();
            String rqt = "INSERT INTO `rendez_vous`(`date_envoie`,`heure_envoie`,`desc`,`Num_doss_med`, `id_Praticien`, `date_RDV`,`heure_RDV`,`Raison`) VALUES (?,?,?,?,?,?,?,?)";
             ps = cnx.prepareStatement(rqt);
             ps.setString(1, objet.getDate_envoie());
             ps.setString(2, objet.getHeure_envoie());
             ps.setString(3,"signaler");
             ps.setString(4, objet.getNum_doss());
             ps.setString(5, objet.getId_praticien());
             ps.setString(6, objet.getDate());
             ps.setString(7, objet.getHeure());
             ps.setString(8, objet.getRaison());
             
             ps.execute();
             ps.close();
             rs.close();
        JOptionPane.showMessageDialog(null, "envoyé avec succès ");
        } 
         catch (SQLException e) {
          System.out.println("--> SQLException : " + e);
          JOptionPane.showMessageDialog(null, e.getMessage());
    } 
    }
    
    
    
    @Override
    public List<RDV> selectRDV_pra() {
        List RDVList = new ArrayList();
         RDV rdv = new RDV();
         String id_pra = rdv.getId_praticien();
      
          try 
        {
           
            cnx= DB_Connexion.Connexion();
            String rqt = "select * from rendez_vous where id_Praticien LIKE '"+id_pra+"' ";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
               
                
                rdv.setId(rs.getInt("id_RDV"));
                rdv.setDate_envoie("date_envoie");
                rdv.setHeure_envoie("heure_envoie");
                rdv.setDesc("desc");
                rdv.setNum_doss(rs.getString("Num_doss_med"));
                rdv.setId_praticien(rs.getString("id_Praticien"));
                rdv.setDate(rs.getString("date_RDV"));
                rdv.setHeure(rs.getString("heure_RDV"));
                rdv.setRaison(rs.getString("Raison"));
               
                ps.close();
                rs.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(inter_infos_suivi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return RDVList;
        
        
    }

    @Override
    public List<RDV> selectspec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public praticien selectnom_prenom(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertrapport_Examination(RDV objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert_radiotherapie(RDV objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertExamens_Radiologique(RDV objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertDonneesPharmacologique(RDV objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertChirurgie(RDV objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAnatomiePathologique(RDV objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAnalyses(RDV objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

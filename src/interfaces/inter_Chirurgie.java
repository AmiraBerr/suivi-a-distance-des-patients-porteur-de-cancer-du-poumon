/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Listes.Chirurgie;
import Listes.praticien;
import Login.DB_Connexion;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import static public_var.variables.cnx;
import static public_var.variables.ps;
import static public_var.variables.rs;

/**
 *
 * @author pc
 */
public class inter_Chirurgie implements Interface_G<Chirurgie> {

    @Override
    public praticien selectnom_prenom(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chirurgie> selectpneumologue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chirurgie> selectoncologue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chirurgie> selectspec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertinfos_suivi(Chirurgie objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chirurgie> selectinfos_suivi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRDV(Chirurgie objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRDV_pra(Chirurgie objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chirurgie> selectRDV_pra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertrapport_Examination(Chirurgie objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert_radiotherapie(Chirurgie objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertExamens_Radiologique(Chirurgie objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertDonneesPharmacologique(Chirurgie objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertChirurgie(Chirurgie objet) {
        
        try {
            cnx= DB_Connexion.Connexion();
           String rqt = "INSERT INTO `chirurgie`(`idc`, `date`, `contexte`, `idpra`, `Num_doss_medical`) VALUES (?,?,?,?,?)";
            ps = cnx.prepareStatement(rqt);
            ps.setInt(1, objet.getIdc());
            ps.setString(2, objet.getDate());
            ps.setString(3, objet.getContexte());
            ps.setString(4, objet.getId_praticien());
            ps.setString(5, objet.getNum_doss());
            
            ps.execute();
            ps.close();
            rs.close();
            JOptionPane.showMessageDialog(null, "Ajouté avec succès ");
        } catch (SQLException e) {
           System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
        
    }

    @Override
    public void insertAnatomiePathologique(Chirurgie objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAnalyses(Chirurgie objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

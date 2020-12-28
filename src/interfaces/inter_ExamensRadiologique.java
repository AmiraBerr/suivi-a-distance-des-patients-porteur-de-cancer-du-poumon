/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Listes.ExamensRadiologique;
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
public class inter_ExamensRadiologique implements Interface_G<ExamensRadiologique>{

    @Override
    public praticien selectnom_prenom(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExamensRadiologique> selectpneumologue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExamensRadiologique> selectoncologue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExamensRadiologique> selectspec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertinfos_suivi(ExamensRadiologique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExamensRadiologique> selectinfos_suivi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRDV(ExamensRadiologique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRDV_pra(ExamensRadiologique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExamensRadiologique> selectRDV_pra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertrapport_Examination(ExamensRadiologique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert_radiotherapie(ExamensRadiologique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertExamens_Radiologique(ExamensRadiologique objet) {
        try {
            cnx= DB_Connexion.Connexion();
           String rqt = "INSERT INTO `examenradiologique`(`ider`,`type_radio`, `date`, `contexte`,`image`, `idpra`, `Num_doss_medical`) VALUES (?,?,?,?,?,?,?)";
            ps = cnx.prepareStatement(rqt);
            ps.setInt(1, objet.getIdr());
            ps.setString(2, objet.getType_radio());
            ps.setString(3, objet.getDate());
            ps.setString(4, objet.getContexte());
            ps.setString(5, objet.getImage());
            ps.setString(6, objet.getId_praticien());
            ps.setString(7, objet.getNum_doss());
            
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
    public void insertDonneesPharmacologique(ExamensRadiologique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertChirurgie(ExamensRadiologique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAnatomiePathologique(ExamensRadiologique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAnalyses(ExamensRadiologique objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

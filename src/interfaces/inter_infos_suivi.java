/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Listes.infos_suivi;
import Listes.praticien;
import Login.DB_Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static public_var.variables.*;

/**
 *
 * @author berich
 */
public class inter_infos_suivi  implements Interface_G<infos_suivi> {

    @Override
    public List<infos_suivi> selectpneumologue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<infos_suivi> selectoncologue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertinfos_suivi(infos_suivi objet) {
       
          
        try {
            cnx= DB_Connexion.Connexion();
           String rqt = "INSERT INTO `infos_suivi`(`Num_doss_med`, `pneumologue_ref`, `oncologue_ref`, `date_saisie`, `poids`, `fievre`,`appétit`, `G_brutal_visage`, `toux`, `Déprime`, `essoufllement`, `faiblesse`, `douleur`, `C_brutal_voix`,`boule_sous_peau`, `sang_crachats`, `commentaire`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = cnx.prepareStatement(rqt);
            ps.setString(1, objet.getNum_doss());
            ps.setString(2, objet.getPneu_ref());
            ps.setString(3, objet.getOnco_ref());
            ps.setString(4, objet.getDate());
            ps.setString(5, objet.getPoids());
            ps.setString(6, objet.getFievre());
            ps.setString(7, objet.getAppétit());
            ps.setString(8, objet.getG_brutal_visage());
            ps.setString(9, objet.getToux());
            ps.setString(10, objet.getDeprime());
            ps.setString(11, objet.getEssoufflement());
            ps.setString(12, objet.getFaiblesse());
            ps.setString(13, objet.getDouleur());
            ps.setString(14, objet.getC_brutal_voix());
            ps.setString(15, objet.getBoule_sous_peau());
            ps.setString(16, objet.getSang_crachats());
            ps.setString(17, objet.getCommentaire());
            ps.execute();
            ps.close();
            rs.close();
            JOptionPane.showMessageDialog(null, "envoyé avec succès ");
        } catch (SQLException e) {
           System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public List<infos_suivi> selectinfos_suivi() {
           List infosList = new ArrayList();
      
          try 
        {
           
            cnx= DB_Connexion.Connexion();
            String rqt = "select * from infos_suivi";
            ps = cnx.prepareStatement(rqt);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                infos_suivi infos = new infos_suivi();
                
                
                infos.setId(rs.getInt("id_IS"));
                infos.setNum_doss(rs.getString("Num_doss_med"));
                infos.setPneu_ref(rs.getString("pneumologue_ref"));
                infos.setOnco_ref(rs.getString("oncologue_ref"));
                infos.setDate(rs.getString("date_saisie"));
                infos.setPoids(rs.getString("poids"));
                infos.setFievre(rs.getString("fievre"));
                infos.setAppétit(rs.getString("Appétit"));
                infos.setG_brutal_visage(rs.getString("G_brutal_visage"));
                infos.setToux(rs.getString("toux"));
                infos.setDeprime(rs.getString("Déprime"));
                infos.setEssoufflement(rs.getString("essoufllement"));
                infos.setFaiblesse(rs.getString("faiblesse"));
                infos.setDouleur(rs.getString("douleur"));
                infos.setC_brutal_voix(rs.getString("C_brutal_voix"));
                infos.setBoule_sous_peau((rs.getString("boule_sous_peau")));
                infos.setSang_crachats(rs.getString("sang_crachats"));
                infos.setCommentaire(rs.getString("commentaire"));
                infosList.add(infos);
                
                ps.close();
                rs.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(inter_infos_suivi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return infosList;
    }

    @Override
    public void insertRDV(infos_suivi objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<infos_suivi> selectRDV_pra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<infos_suivi> selectspec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public praticien selectnom_prenom(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRDV_pra(infos_suivi objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertrapport_Examination(infos_suivi objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert_radiotherapie(infos_suivi objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertExamens_Radiologique(infos_suivi objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertDonneesPharmacologique(infos_suivi objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertChirurgie(infos_suivi objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAnatomiePathologique(infos_suivi objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAnalyses(infos_suivi objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
        
        
        
        
    }
        
        
        
        
        
     


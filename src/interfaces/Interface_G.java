/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Listes.praticien;
import Login.DB_Connexion;
import java.util.List;
import static public_var.variables.*;

/**
 *
 * @author berich
 * @param <T>
 */
public interface Interface_G<T> {
   
     public praticien selectnom_prenom(String id);
     public List<T> selectpneumologue();
     public List<T> selectoncologue();
     public List<T> selectspec();
     public List<T> selectRDV_pra();
     public List<T> selectinfos_suivi();
     public void insertinfos_suivi(T objet);
     public void insertRDV(T objet);
     public void insertRDV_pra(T objet);
     public void insertrapport_Examination( T objet);
     public void insert_radiotherapie( T objet);
     public void insertExamens_Radiologique( T objet);
     public void insertDonneesPharmacologique( T objet);
     public void insertChirurgie( T objet);
     public void insertAnatomiePathologique( T objet);
     public void insertAnalyses( T objet);
      
}

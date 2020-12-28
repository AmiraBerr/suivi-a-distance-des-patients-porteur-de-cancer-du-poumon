/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listes;

/**
 *
 * @author pc
 */
public class RapportExamination {
    
    
    
    private int ide;
    private String date;
    private String specialite;
    private String contexte;
    private String num_doss;   //id de dossier med 
    private String id_praticien; // id de praticien 

    public RapportExamination(int ide, String specialite, String date, String contexte, String num_doss, String id_praticien) {
        this.ide = ide;
        this.date = date;
        this.specialite=specialite;
        this.contexte = contexte;
        this.num_doss = num_doss;
        this.id_praticien = id_praticien;
    }

    public RapportExamination(String date, String specialite, String contexte, String num_doss, String id_praticien) {
        
        this.specialite=specialite;
        this.date = date;
        this.contexte = contexte;
        this.num_doss = num_doss;
        this.id_praticien = id_praticien;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    
    
    
    
    
    
    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }

    public void setNum_doss(String num_doss) {
        this.num_doss = num_doss;
    }

    public void setId_praticien(String id_praticien) {
        this.id_praticien = id_praticien;
    }

    public String getDate() {
        return date;
    }

    public String getContexte() {
        return contexte;
    }

    public String getNum_doss() {
        return num_doss;
    }

    public String getId_praticien() {
        return id_praticien;
    }

    @Override
    public String toString() {
        return "RapportExamination{" + "ide=" + ide + ", date=" + date + ", specialite=" + specialite + ", contexte=" + contexte + ", num_doss=" + num_doss + ", id_praticien=" + id_praticien + '}';
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
}

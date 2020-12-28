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
public class Chirurgie {
    private int idc;
    private String date;
    private String contexte;
    private String num_doss;   //id de dossier med 
    private String id_praticien; // id de praticien 

    public Chirurgie(int idc, String date, String contexte, String num_doss, String id_praticien) {
        this.idc = idc;
        this.date = date;
        this.contexte = contexte;
        this.num_doss = num_doss;
        this.id_praticien = id_praticien;
    }

    public Chirurgie(String date, String contexte, String num_doss, String id_praticien) {
        this.date = date;
        this.contexte = contexte;
        this.num_doss = num_doss;
        this.id_praticien = id_praticien;
    }

    public Chirurgie() {
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContexte() {
        return contexte;
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }

    public String getNum_doss() {
        return num_doss;
    }

    public void setNum_doss(String num_doss) {
        this.num_doss = num_doss;
    }

    public String getId_praticien() {
        return id_praticien;
    }

    public void setId_praticien(String id_praticien) {
        this.id_praticien = id_praticien;
    }

    @Override
    public String toString() {
        return "Chirurgie{" + "idc=" + idc + ", date=" + date + ", contexte=" + contexte + ", num_doss=" + num_doss + ", id_praticien=" + id_praticien + '}';
    }
    
    
    
}

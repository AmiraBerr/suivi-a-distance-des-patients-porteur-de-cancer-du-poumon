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
public class ExamensRadiologique {
    
    
      
    private int idr;
    private String date;
    private String type_radio;
    private String contexte;
     private String image;
    private String num_doss;   //id de dossier med 
    private String id_praticien; // id de praticien 

    public ExamensRadiologique(int idr, String date, String type_radio, String contexte, String image, String num_doss, String id_praticien) {
        this.idr = idr;
        this.date = date;
        this.type_radio = type_radio;
        this.contexte = contexte;
        this.image = image;
        this.num_doss = num_doss;
        this.id_praticien = id_praticien;
    }

    public ExamensRadiologique(String date, String type_radio, String contexte, String image, String num_doss, String id_praticien) {
        this.date = date;
        this.type_radio = type_radio;
        this.contexte = contexte;
        this.image = image;
        this.num_doss = num_doss;
        this.id_praticien = id_praticien;
    }

    public ExamensRadiologique() {
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType_radio() {
        return type_radio;
    }

    public void setType_radio(String type_radio) {
        this.type_radio = type_radio;
    }

    public String getContexte() {
        return contexte;
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        return "ExamensRadiologique{" + "idr=" + idr + ", date=" + date + ", type_radio=" + type_radio + ", contexte=" + contexte + ", image=" + image + ", num_doss=" + num_doss + ", id_praticien=" + id_praticien + '}';
    }
   
    
    
}

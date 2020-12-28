/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listes;



/**
 *
 * @author berich
 */
public class RDV   {
    private int id;
    private String date_envoie;
    private String heure_envoie;
    private String desc;
    private String num_doss;   //id de dossier med 
    private String id_praticien; // id de praticien 
    private String date;
    private String heure;
    private String raison;

    public RDV(String num_doss,String date_envoie,String heure_envoie, String id_praticien, String date, String heure, String raison) {
        this.num_doss = num_doss;
        this.date_envoie=date_envoie;
        this.heure_envoie=heure_envoie;
        this.id_praticien = id_praticien;
        this.date = date;
        this.heure = heure;
        this.raison = raison;
        this.desc=desc;
    }
    

    public RDV(int id, String num_doss, String id_praticien, String date, String heure, String raison) {
        this.id = id;
        this.num_doss = num_doss;
        this.id_praticien = id_praticien;
        this.date = date;
        this.heure = heure;
        this.raison = raison;
    }

    public RDV() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public String getHeure_envoie() {
        return heure_envoie;
    }

    public void setHeure_envoie(String heure_envoie) {
        this.heure_envoie = heure_envoie;
    }
    
     public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }
    public String getDate_envoie() {
        return date_envoie;
    }

    public void setDate_envoie(String date_envoie) {
        this.date_envoie = date_envoie;
    }
    @Override
    public String toString() {
        return "RDV{" + "num_doss=" + num_doss + ", id_praticien=" + id_praticien + ", date=" + date + ", heure=" + heure + ", raison=" + raison + '}';
    }
    
    
    
    
    
}

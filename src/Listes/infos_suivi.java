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
public class infos_suivi {
    
    private int id;
    private String num_doss;
    private String pneu_ref;
    private String onco_ref;
    private String date;
    private String poids;
    private String fievre;
    private String appétit;
    private String G_brutal_visage;
    private String toux;
    private String deprime;
    private String essoufflement;
    private String faiblesse;
    private String douleur;
    private String C_brutal_voix;
    private String boule_sous_peau;
    private String sang_crachats;
    private String commentaire;
    
    
    public infos_suivi(int id, String num_doss, String pneu_ref, String onco_ref, String date,String poids,String fievre,String appétit,String G_brutal_visage,String toux,String deprime,String essoufflement,String faiblesse,String douleur,String C_brutal_voix, String boule_sous_peau,String sang_crachats,String commentaire) {
        this.id = id;
        this.num_doss = num_doss;
        this.pneu_ref = pneu_ref;
        this.onco_ref = onco_ref;
        this.date =date;
        this.poids=poids;
        this.fievre=fievre;
        this.appétit=appétit;
        this.G_brutal_visage=G_brutal_visage;
        this.C_brutal_voix=C_brutal_voix;
        this.deprime=deprime;
        this.essoufflement=essoufflement;
        this.faiblesse=faiblesse;
        this.sang_crachats=sang_crachats;
        this.toux=toux;
        this.boule_sous_peau=boule_sous_peau;
        this.douleur=douleur;
        this.commentaire=commentaire;
    }

    public infos_suivi( String num_doss, String pneu_ref, String onco_ref, String date,String poids,String  fievre,String appétit,String G_brutal_visage,String toux,String deprime,String essoufflement,String faiblesse,String douleur,String C_brutal_voix, String boule_sous_peau,String sang_crachats,String commentaire) {
        this.num_doss = num_doss;
        this.pneu_ref = pneu_ref;
        this.onco_ref = onco_ref;
        this.date =date;
        this.poids=poids;
        this.fievre=fievre;
        this.appétit=appétit;
        this.G_brutal_visage=G_brutal_visage;
        this.C_brutal_voix=C_brutal_voix;
        this.deprime=deprime;
        this.essoufflement=essoufflement;
        this.faiblesse=faiblesse;
        this.sang_crachats=sang_crachats;
        this.toux=toux;
        this.boule_sous_peau=boule_sous_peau;
        this.douleur=douleur;
        this.commentaire=commentaire;
    }

    public infos_suivi() {
    }

    @Override
    public String toString() {
        return "infos_suivi{" + "num_doss=" + num_doss + ", pneu_ref=" + pneu_ref + ", onco_ref=" + onco_ref + ", date=" + date + ", poids=" + poids + ", fievre=" + fievre + ", app\u00e9tit=" + appétit + ", G_brutal_visage=" + G_brutal_visage + ", toux=" + toux + ", deprime=" + deprime + ", essoufflement=" + essoufflement + ", faiblesse=" + faiblesse + ", douleur=" + douleur + ", C_brutal_voix=" + C_brutal_voix + ", boule_sous_peau=" + boule_sous_peau + ", sang_crachats=" + sang_crachats + ", commentaire=" + commentaire + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum_doss() {
        return num_doss;
    }

    public void setNum_doss(String num_doss) {
        this.num_doss = num_doss;
    }

    public String getPneu_ref() {
        return pneu_ref;
    }

    public void setPneu_ref(String pneu_ref) {
        this.pneu_ref = pneu_ref;
    }

    public String getOnco_ref() {
        return onco_ref;
    }

    public void setOnco_ref(String onco_ref) {
        this.onco_ref = onco_ref;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getFievre() {
        return fievre;
    }

    public void setFievre(String fievre) {
        this.fievre = fievre;
    }

    public String getAppétit() {
        return appétit;
    }

    public void setAppétit(String appétit) {
        this.appétit = appétit;
    }

    public String getG_brutal_visage() {
        return G_brutal_visage;
    }

    public void setG_brutal_visage(String G_brutal_visage) {
        this.G_brutal_visage = G_brutal_visage;
    }

    public String getToux() {
        return toux;
    }

    public void setToux(String toux) {
        this.toux = toux;
    }

    public String getDeprime() {
        return deprime;
    }

    public void setDeprime(String deprime) {
        this.deprime = deprime;
    }

    public String getEssoufflement() {
        return essoufflement;
    }

    public void setEssoufflement(String essoufflement) {
        this.essoufflement = essoufflement;
    }

    public String getFaiblesse() {
        return faiblesse;
    }

    public void setFaiblesse(String faiblesse) {
        this.faiblesse = faiblesse;
    }

    public String getDouleur() {
        return douleur;
    }

    public void setDouleur(String douleur) {
        this.douleur = douleur;
    }

    public String getC_brutal_voix() {
        return C_brutal_voix;
    }

    public void setC_brutal_voix(String C_brutal_voix) {
        this.C_brutal_voix = C_brutal_voix;
    }

    public String getBoule_sous_peau() {
        return boule_sous_peau;
    }

    public void setBoule_sous_peau(String boule_sous_peau) {
        this.boule_sous_peau = boule_sous_peau;
    }

    public String getSang_crachats() {
        return sang_crachats;
    }

    public void setSang_crachats(String sang_crachats) {
        this.sang_crachats = sang_crachats;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
             
        
    
}

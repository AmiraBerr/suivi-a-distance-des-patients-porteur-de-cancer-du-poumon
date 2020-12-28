/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listes;


public class praticien {
   private String id;
   private String password;
   private String type;
   private String specialite;
   private String address;
   private String nom;
   private String prenom;
   private String email;
   private String telPort;
   
   public praticien(String id, String password, String nom, String prenom, String type,String specialite,String address, String email, String telPort) {
        this.id = id;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.type=type;
        this.specialite=specialite;
        this.email = email;
        this.telPort = telPort;
        this.address=address;
     
    }
   
   
   
     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_type() {
        return type;
    }

    public void setId_type(String id_role) {
        this.type = type;
    }
     public void setId_spec(String specialite) {
        this.specialite = specialite;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelPort() {
        return telPort;
    }

    public void setTelPort(String telPort) {
        this.telPort = telPort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

  

  /*  @Override
    public String toString() {
        return "praticien{" + "id=" + id + ", login=" + login + ", password=" + password + ", type=" + type+ ", specialite=" + specialite+      ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telPort=" + telPort + ", telFixe=" + telFixe + '}';
    }*/
    
    @Override
    public String toString() {
        return  this.getNom() + " " + this.getPrenom();
    }
}

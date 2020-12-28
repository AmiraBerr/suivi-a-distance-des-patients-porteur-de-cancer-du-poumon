/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DB_Connexion {
     Connection cnx=null;
     String nom_fich= null;
     public static String chemin;
         
    public static Connection Connexion(){
       try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:8889/mybdd","root","root"); // for mac 
	if (cnx!= null)
	System.out.println("Connexion à la base de données a été établie avec succès");
				 else 
				System.out.println("impossible de se connecter à la base de données");
						
       return cnx;
       
       }catch(Exception e) {
           System.out.println("--> SQLException : " + e) ;
           
       return null;
       }
    }
    
    public String getchemin(){
    
    return chemin;     
        
    }
     public void filen() {
        try {

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Choisir une image png");
            chooser.setApproveButtonText("Ajouter une image");
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            nom_fich = f.getAbsolutePath();
            this.chemin = (nom_fich);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null," Veuiler choisir une image ");;
        }
    
    
}
}
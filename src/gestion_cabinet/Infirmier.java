/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_cabinet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author eloua
 */
public class Infirmier extends Personne {
    String username;
    String password;
    String specialite;
    
    public Infirmier () {}
    
    public Infirmier (String id) {
        this.id = id;      
    }
    
    public Infirmier (
            String nom,
            String prenom, 
            String adresse, 
            String ngsm, 
            String civilite, 
            String email, 
            String cin,
            String username,
            String password,
            String specialite ) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ngsm = ngsm;
        this.civilite = civilite;
        this.email = email;
        this.cin = cin;
        this.username = username;
        this.password = password;
        this.specialite = specialite;
    }
    
     public Infirmier (
            String id,
            String nom,
            String prenom, 
            String adresse, 
            String ngsm, 
            String civilite, 
            String email, 
            String cin,
            String username,
            String password,
            String specialite ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ngsm = ngsm;
        this.civilite = civilite;
        this.email = email;
        this.cin = cin;
        this.username = username;
        this.password = password;
        this.specialite = specialite;
    }
     
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getSpecialite() {
        return this.specialite;
    }
    
    public Infirmier getInfirmierById(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            ResultSet rs = smts.executeQuery("SELECT * FROM infirmier WHERE Id = " + this.id);
            while(rs.next()){
                return new Infirmier(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10),
                rs.getString(11));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public void addInfirmier(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("INSERT INTO infirmier VALUES ("
                    + "DEFAULT ,'"
                    + this.nom + "', '"
                    + this.prenom + "', '"
                    + this.adresse + "', '"
                    + this.ngsm + "', '"
                    + this.civilite + "', '"
                    + this.email + "', '"
                    + this.cin + "', '"
                    + this.username + "', '"
                    + this.password + "', "
                    + this.specialite + ");");
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void removeInfirmier(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("DELETE FROM infirmier WHERE id = " + this.id);
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

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
public class Medecin extends Personne {
    
    String username;
    String password;
    String specialite;
    String agenda;
    
    public Medecin () {}
    
    public Medecin (String id) {
        this.id = id;      
    }
    
    public Medecin (
            String nom,
            String prenom, 
            String adresse, 
            String ngsm, 
            String civilite, 
            String email, 
            String cin,
            String username,
            String password,
            String specialite,
            String agenda ) {
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
        this.agenda = agenda;       
    }
    
     public Medecin (
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
            String specialite,
            String agenda ) {
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
        this.agenda = agenda;       
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
    
    public String getAgenda(){
        return this.agenda;
    }
    
    public Medecin getMedecinById(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            ResultSet rs = smts.executeQuery("SELECT * FROM medecin WHERE Id = " + this.id);
            while(rs.next()){
                return new Medecin(
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
                rs.getString(11),
                rs.getString(12));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public void addMedecin(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("INSERT INTO medecin VALUES ("
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
                    + this.specialite + ", "
                    + this.agenda + ");");
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void removeMedecin(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("DELETE FROM medecin WHERE id = " + this.id);
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

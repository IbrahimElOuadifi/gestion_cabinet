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
public class Patient extends Personne {
    
    String date_naissance;
    String date_inscription;
    String sex;
    String profession;
    String code_assurance;
    String dossier_medical;
    
    public Patient(String id){
        this.id = id;
    }
    
    public Patient (
            String nom,
            String prenom, 
            String adresse, 
            String ngsm, 
            String civilite, 
            String email, 
            String cin,
            String date_naissance,
            String date_inscription,
            String sex,
            String profession,
            String code_assurance,
            String dossier_medical) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ngsm = ngsm;
        this.civilite = civilite;
        this.email = email;
        this.cin = cin;
        this.date_naissance = date_naissance;
        this.date_inscription = date_inscription;
        this.sex = sex;
        this.profession = profession;
        this.code_assurance = code_assurance;
        this.dossier_medical = dossier_medical;
    }
   
    public Patient (
            String id,
            String nom,
            String prenom, 
            String adresse, 
            String ngsm, 
            String civilite, 
            String email, 
            String cin,
            String date_naissance,
            String date_inscription,
            String sex,
            String profession,
            String code_assurance,
            String dossier_medical) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ngsm = ngsm;
        this.civilite = civilite;
        this.email = email;
        this.cin = cin;
        this.date_naissance = date_naissance;
        this.date_inscription = date_inscription;
        this.sex = sex;
        this.profession = profession;
        this.code_assurance = code_assurance;
        this.dossier_medical = dossier_medical;
    }
    
    public Patient getPatientById(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            ResultSet rs = smts.executeQuery("SELECT * FROM patient WHERE Id = " + this.id);
            while(rs.next()){
                return new Patient(
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
                rs.getString(12),
                rs.getString(13),
                rs.getString(14));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public void addPatient(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("INSERT INTO patient VALUES ("
                    + "DEFAULT ,'"
                    + this.nom + "', '"
                    + this.prenom + "', '"
                    + this.adresse + "', '"
                    + this.ngsm + "', '"
                    + this.civilite + "', '"
                    + this.email + "', '"
                    + this.cin + "', '"
                    + this.date_naissance + "', '"
                    + this.date_naissance + "', '"
                    + this.sex + "', '"
                    + this.profession + "', '"
                    + this.code_assurance + "', "
                    + this.dossier_medical + ");");
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void removePatient(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("DELETE FROM patient WHERE id = " + this.id);
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

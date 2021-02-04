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
public class Admin extends Personne {
    
    String username;
    String password;
    
    public Admin () {}
    
    public Admin (String id) {
        this.id = id;
    }
    
    public Admin (
            String id,
            String nom,
            String prenom, 
            String adresse, 
            String ngsm, 
            String civilite, 
            String email, 
            String cin,
            String username,
            String password ) {
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
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public Admin getAdminById(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            ResultSet rs = smts.executeQuery("SELECT * FROM admin WHERE Id = " + this.id);
            while(rs.next()){
                return new Admin(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return new Admin();
    }
}

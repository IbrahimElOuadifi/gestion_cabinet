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
public class Acte {
    String id;
    String libelle;
    String observation;
    String url_annexe;
    String infirmier;
    String consultation;
    
    public Acte(String id){
        this.id = id;
    }
   
    public Acte (
            String libelle,
            String observation, 
            String url_annexe, 
            String infirmier,
            String consulation) {
        this.libelle = libelle;
        this.observation = observation;
        this.url_annexe = url_annexe;
        this.infirmier = infirmier;
        this.consultation  = consulation;
    }
    
    public Acte (
            String id,
            String libelle,
            String observation, 
            String url_annexe, 
            String infirmier,
            String consulation) {
        this.id = id;
        this.libelle = libelle;
        this.observation = observation;
        this.url_annexe = url_annexe;
        this.infirmier = infirmier;
        this.consultation  = consulation;
    }
    
    public Acte getActeById(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            ResultSet rs = smts.executeQuery("SELECT * FROM acte WHERE Id = " + this.id);
            while(rs.next()){
                return new Acte(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public void addActe(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("INSERT INTO acte VALUES ("
                    + "DEFAULT ,'"
                    + this.libelle + "', '"
                    + this.observation + "', '"
                    + this.url_annexe + "', "
                    + this.infirmier + ", "
                    + this.consultation + ");");
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void removeActe(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("DELETE FROM acte WHERE id = " + this.id);
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

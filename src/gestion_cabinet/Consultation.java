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
public class Consultation {
    String id;
    String date;
    String heure;
    String rapport;
    String etat;
    String reglement;
    
    public Consultation(String id){
        this.id = id;
    }
   
    public Consultation (
            String date,
            String heure, 
            String rapport, 
            String etat,
            String reglement) {
        this.date = date;
        this.heure = heure;
        this.rapport = rapport;
        this.etat = etat;
        this.reglement = reglement;
    }
    
    public Consultation (
            String id,
            String date,
            String heure, 
            String rapport, 
            String etat,
            String reglement) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.rapport = rapport;
        this.etat = etat;
        this.reglement = reglement;
    }
    
    public Consultation getConsultationById(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            ResultSet rs = smts.executeQuery("SELECT * FROM consultation WHERE Id = " + this.id);
            while(rs.next()){
                return new Consultation(
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
    
    public void addConsultation(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("INSERT INTO render_vous VALUES ("
                    + "DEFAULT ,'"
                    + this.date + "', '"
                    + this.heure + "', '"
                    + this.rapport + "', "
                    + this.etat + ", "
                    + this.reglement + ");");
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void removeConsultation(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("DELETE FROM consultation WHERE id = " + this.id);
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

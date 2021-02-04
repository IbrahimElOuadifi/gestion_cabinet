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
public class RendezVous {
    
    String id;
    String date;
    String heure;
    String patient;
    String service;
    
    public RendezVous(String id){
        this.id = id;
    }
   
    public RendezVous (
            String date,
            String heure, 
            String patient, 
            String service) {
        this.date = date;
        this.heure = heure;
        this.patient = patient;
        this.service = service;
    }
    
    public RendezVous (
            String id,
            String date,
            String heure, 
            String patient, 
            String service) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.patient = patient;
        this.service = service;
    }
    
    public RendezVous getRendezVousById(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            ResultSet rs = smts.executeQuery("SELECT * FROM render_vous WHERE Id = " + this.id);
            while(rs.next()){
                return new RendezVous(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public void addRendezVous(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("INSERT INTO render_vous VALUES ("
                    + "DEFAULT ,'"
                    + this.date + "', '"
                    + this.heure + "', "
                    + this.patient + ", "
                    + this.service + ");");
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void removeRendezVous(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_cabinet", "root", "");
            System.out.println("Connectd");
            Statement smts = (Statement) con.createStatement();
            int result = smts.executeUpdate("DELETE FROM render_vous WHERE id = " + this.id);
            
            System.out.println(result + " affected!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

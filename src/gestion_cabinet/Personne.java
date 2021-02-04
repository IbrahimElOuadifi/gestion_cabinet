/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_cabinet;

/**
 *
 * @author eloua
 */
public class Personne {
    String id;
    String nom;
    String prenom;
    String adresse;
    String ngsm;
    String civilite;
    String email;
    String cin;
    
    public Personne () {
        
    }
    
    public Personne (String id) {
        this.id = id;
    }
    
    public Personne (
            String nom,
            String prenom, 
            String adresse, 
            String ngsm, 
            String civilite, 
            String email, 
            String cin ) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ngsm = ngsm;
        this.civilite = civilite;
        this.email = email;
        this.cin = cin;
    }
    
    public Personne (
            String id,
            String nom,
            String prenom, 
            String adresse, 
            String ngsm, 
            String civilite, 
            String email, 
            String cin ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ngsm = ngsm;
        this.civilite = civilite;
        this.email = email;
        this.cin = cin;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
    
    public String getAdresse(){
        return this.adresse;
    }
    
    public String getNGSM(){
        return this.ngsm;
    }
    
    public String getCililte(){
        return this.civilite;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getCIN(){
        return this.cin;
    }
}

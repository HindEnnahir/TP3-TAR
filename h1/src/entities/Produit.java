
package entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marque;
    private String reference;
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    private double prix;
    private String designation;

    public Produit(String marque, String reference, Date dateAchat, double prix, String designation) {
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.designation = designation;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getReference() {
        return reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", marque=" + marque + ", reference=" + reference + ", dateAchat=" + dateAchat + ", prix=" + prix + ", designation=" + designation + '}';
    }
    
}

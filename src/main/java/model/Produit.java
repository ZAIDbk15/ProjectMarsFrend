
package model;
import java.io.Serializable;
import jakarta.persistence.*;


public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;

    private String designation;

    private float prix;

    private int quantite;
    private int rating;
    private int sdr;
    private String photo;
    private InventoryStatus inventoryStatus;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRating() {
        this.rating=5;
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public InventoryStatus getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(InventoryStatus inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    //bi-directional many-to-one association to Categorie
    private Categorie categorie;

    public Produit() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrix() {
        return this.prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getSdr() {
        return this.sdr;
    }

    public void setSdr(int sdr) {
        this.sdr = sdr;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return id + " => " + designation + ","+prix+ ","+quantite;
    }
}

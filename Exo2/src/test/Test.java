package test;

import ma.projet.classes.Categorie;
import ma.projet.classes.Produit;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.service.ProduitService;
import ma.projet.service.CommandeService;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.classes.ProduitCommandePK;
import ma.projet.service.LigneCommandeProduitService;

public class Test {

    public static void main(String[] args) {
        // Création des services
        CommandeService commandeService = new CommandeService();
        ProduitService produitService = new ProduitService();
        LigneCommandeProduitService ligneCommandeService = new LigneCommandeProduitService();

        // Ouverture d'une session Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Création de catégories
        Categorie categorie1 = new Categorie("RT50", "Ordinateur");
        Categorie categorie2 = new Categorie("AP67", "Tablette");

        // Sauvegarder les catégories
        session.save(categorie1);
        session.save(categorie2);

        // Création de produits
        Produit produit1 = new Produit("ES12", 120);
        Produit produit2 = new Produit("ZR85", 100);
        Produit produit3 = new Produit("EE85", 200);

        // Assigner les catégories aux produits
        produit1.setCategorie(categorie1);
        produit2.setCategorie(categorie2);
        produit3.setCategorie(categorie2);

        // Sauvegarder les produits
        session.save(produit1);
        session.save(produit2);
        session.save(produit3);

        // Création d'une commande
        Commande commande = new Commande(new Date());
        session.save(commande);

        // Création de lignes de commande
        // Ajouter des lignes de commande
        // Ajouter ligne1
        LigneCommandeProduit ligne1 = new LigneCommandeProduit(commande, produit1, 2);
        ligne1.setPk(new ProduitCommandePK(produit1.getId(), commande.getId(), 2));
        ligneCommandeService.create(ligne1);
        session.flush(); 
        session.clear();  

// Ajouter ligne2
        LigneCommandeProduit ligne2 = new LigneCommandeProduit(commande, produit2, 2);
        ligne2.setPk(new ProduitCommandePK(produit2.getId(), commande.getId(), 2));
        ligneCommandeService.create(ligne2);
        session.flush();  
        session.clear();

// Ajouter ligne3
        LigneCommandeProduit ligne3 = new LigneCommandeProduit(commande, produit3, 2);
        ligne3.setPk(new ProduitCommandePK(produit3.getId(), commande.getId(), 2));
        ligneCommandeService.create(ligne3);
        session.flush(); 
        session.clear(); 

       // LigneCommandeProduit ligne1 = new LigneCommandeProduit(commande, produit1, 2);
        // ligne1.setPk(new ProduitCommandePK(produit1.getId(), commande.getId(), 2));
        //ligneCommandeService.create(ligne1);
        //LigneCommandeProduit ligne2 = new LigneCommandeProduit(commande, produit2, 2);
        //ligne2.setPk(new ProduitCommandePK(produit2.getId(), commande.getId(), 2));
        //ligneCommandeService.create(ligne2);
        // LigneCommandeProduit ligne3 = new LigneCommandeProduit(commande, produit3, 2);
        // ligne3.setPk(new ProduitCommandePK(produit3.getId(), commande.getId(), 2));
        //ligneCommandeService.create(ligne3);
        // Sauvegarder les lignes de commande
        session.save(ligne1);
        session.save(ligne2);
        session.save(ligne3);

        // Commit des transactions
        session.getTransaction().commit();
        session.close();

        // Test des méthodes
        // 1. Afficher les produits d'une commande donnée
        commandeService.afficherProduitsDansCommande(commande.getId());

        // 2. Afficher la liste des produits par catégorie
        produitService.findByCategorie(categorie2.getId());

        // 3. Afficher les produits commandés entre deux dates
        Date debut = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 10);  
        Date fin = new Date();
        produitService.findProduitsCommandesBetweenDates(debut, fin);
        System.out.printf("--------");

        // 4. Afficher les produits dont le prix est supérieur à 100 DH
        produitService.trouverProduitsAvecPrixSuperieurA100();
    }
}

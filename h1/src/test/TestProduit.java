package test;

import entities.Produit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import services.ProduitService;

public class TestProduit {

    public static void main(String[] args) {

        //QUESTION1
        ProduitService p = new ProduitService();
        p.create(new Produit("ZARA", "123", new Date("2002/05/23"), 12, "Z"));
        p.create(new Produit("BERCHKA", "127", new Date("2003/08/23"), 120, "B"));
        p.create(new Produit("STRADI", "129", new Date("2020/09/26"), 179, "L"));
        p.create(new Produit("COCO", "888", new Date("2004/05/24"), 18, "M"));
        p.create(new Produit("FLOU", "188", new Date("2006/07/29"), 1000, "P"));
//        //QUESTION3
//        System.out.println(p.findById(2));
//        //QUESTION2
//        for(Produit u : p.findAll())
//           System.out.println(u);
        //QUESTION3
        //System.out.println(p.findById(2));
        //QUESTION4
        // p.delete(p.findById(3));
        //QUESTION5
//         Produit pl = p.findById(1);
//        pl.setMarque("lolo");
//        p.update(pl);
        //QUESTION6 
//        Produit pl = new Produit();
//        for (Produit p1 : p.findAll()) {
//            if (p1.getPrix() > 100) {
//                System.out.println(p);
//            }
//
//        }

        //QUESTION7
//        Scanner s = new Scanner(System.in);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateDebut = null;
//        Date dateFin = null;
//
//        // Demander à l'utilisateur de saisir les dates de début et de fin
//        System.out.println("Entrez la date de début de recherche (yyyy-MM-dd) :");
//        try {
//            dateDebut = dateFormat.parse(s.nextLine());
//        } catch (ParseException ex) {
//            System.out.println("Date invalide.");
//            return; // Quitte la recherche en cas de date invalide
//        }
//        System.out.println("Entrez la date de fin de recherche (yyyy-MM-dd) :");
//        try {
//            dateFin = dateFormat.parse(s.nextLine());
//        } catch (ParseException ex) {
//            System.out.println("Date invalide.");
//            return; // Quitte la recherche en cas de date invalide
//        }
//        
//           for (Produit p1 : p.findAll()) {
//            if (p1.getDateAchat().after(dateDebut) && p1.getDateAchat().before(dateFin)) {
//                System.out.println(p);
//            }
//        
//        
//        
//           } 
    }
}

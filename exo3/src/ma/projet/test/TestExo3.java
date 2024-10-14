package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePK;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.ProjetService;
import ma.projet.services.TacheService;

public class TestExo3 {

    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        EmployeTacheService ets = new EmployeTacheService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();

        // Création des employés
        Employe e1 = new Employe("hind", "ennahir", "06678058899");
        Employe e2 = new Employe("hind", "ennahir", "06458900");
        es.create(e1);
        es.create(e2);

        // Création d'un projet
        Projet p = new Projet("JAVA", new Date(2002 / 07 / 25), new Date(2020 / 07 / 25), e2);
        ps.create(p);

        // Création de tâches
        Tache t1 = new Tache("Analyse", new Date(2013 / 02 / 10), new Date(2013 / 02 / 2013), 20000, p);
        Tache t2 = new Tache("Conceprion", new Date(2013 / 03 / 10), new Date(2013 / 07 / 05), 10000, p);
        ts.create(t1);
        ts.create(t2);

        Date dateAttribution = new Date();
        EmployeTachePK employeTachePK1 = new EmployeTachePK(e2.getId(), t1.getId(), dateAttribution);
        EmployeTache employeTache1 = new EmployeTache(employeTachePK1);
        ets.create(employeTache1);

        EmployeTachePK employeTachePK2 = new EmployeTachePK(e2.getId(), t2.getId(), dateAttribution);
        EmployeTache employeTache2 = new EmployeTache(employeTachePK2);
        ets.create(employeTache2);

        System.out.println("Tâches assignées à 'hind'.");
    
        es.getProjetsGererParEmploye(e2);
        System.out.println(p.getId());
        ps.getTachesByProjets(p);
        ps.getCompletedTasksInProject(p);
        ts.getProjectsManagedByEmployee(t2);
        System.out.println(t1.getDateDebut());
        Date d1 = new Date("2021/02/01");
        Date d2 = new Date("2024/02/01");
        System.out.println(ts.getBetweenDate(d1, d2));
        for (Tache y : ts.getBetweenDate(d1, d2)) {
            System.out.println(y);
        }
    }
}



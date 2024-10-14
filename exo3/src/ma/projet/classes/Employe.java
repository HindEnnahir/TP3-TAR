package ma.projet.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(
            name = "getTasksPerformedByEmployee",
            query = "SELECT t FROM Tache t JOIN t.employetache et WHERE et.employe.id = :employeId"
    ),
    @NamedQuery(
            name = "getProjectsByEmployee",
            query = "SELECT p FROM Projet p WHERE p.employe.id = :employeeId"
    )

})
public class Employe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom, prenom, telephone;
    @OneToMany(mappedBy = "employe", fetch = FetchType.EAGER)
    private List<Projet> projets;
    @OneToMany(mappedBy = "employe", fetch = FetchType.EAGER)
    private List<EmployeTache> employetaches;

    public Employe() {
    }

    public Employe(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public List<EmployeTache> getEmployetaches() {
        return employetaches;
    }

    public void setEmployetaches(List<EmployeTache> employetaches) {
        this.employetaches = employetaches;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + '}';
    }

}

package ma.projet.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class EmployeTache implements Serializable {

    @EmbeddedId
    private EmployeTachePK id;
    @JoinColumn(name = "tache", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Tache tache;
    @JoinColumn(name = "employe", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Employe employe;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;

    public EmployeTache() {
    }

    public EmployeTache(EmployeTachePK id) {
        this.id = id;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public EmployeTachePK getId() {
        return id;
    }

    public void setId(EmployeTachePK id) {
        this.id = id;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    @Override
    public String toString() {
        return "EmployeTache{" + "id=" + id + ", dateFin=" + dateFin + '}';
    }

}

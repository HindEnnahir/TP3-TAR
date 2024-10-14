
package ma.projet.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

@Embeddable
public class MariagePK implements Serializable {
    
    private int femme ;
    private int homme ;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut ;

    public MariagePK() {
    }

    public MariagePK(int femme, int homme, Date dateDebut) {
        this.femme = femme;
        this.homme = homme;
        this.dateDebut = dateDebut;
    }
    
    

    public int getFemme() {
        return femme;
    }

    public int getHomme() {
        return homme;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setFemme(int femme) {
        this.femme = femme;
    }

    public void setHomme(int homme) {
        this.homme = homme;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    
    
}

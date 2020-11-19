package dam2.m6.UF2.Activitat8;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Propietaris implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private long id;

    private String nom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaBaseDeDades;
    private int anys;
    private boolean cotxePersonal;

    public Propietaris() {
    }

    public Propietaris(String nom, Date fechaBaseDeDades, int anys, boolean cotxePersonal) {
        this.nom = nom;
        this.fechaBaseDeDades = fechaBaseDeDades;
        this.anys = anys;
        this.cotxePersonal = cotxePersonal;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getFechaBaseDeDades() {
        return fechaBaseDeDades;
    }

    public int getAnys() {
        return anys;
    }

    public boolean isCotxePersonal() {
        return cotxePersonal;
    }
    
    @Override
    public String toString() {
        return String.format("(%s, %d, %d, %b)", this.nom, this.fechaBaseDeDades, this.anys, this.cotxePersonal);
    }
}
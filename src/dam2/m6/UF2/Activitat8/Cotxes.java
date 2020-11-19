package dam2.m6.UF2.Activitat8;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Cotxes implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    private long id;

    private String modelCotxes;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataIngres;
    private int anyMatriculacio;
    private boolean averiat;

    public Cotxes() {
    }

    public Cotxes(String modelCotxes, Date dataIngres, int anyMatriculacio, boolean averiat) {
        this.modelCotxes = modelCotxes;
        this.dataIngres = dataIngres;
        this.anyMatriculacio = anyMatriculacio;
        this.averiat = averiat;
    }

    public long getId() {
        return id;
    }

    public String getModelCotxes() {
        return modelCotxes;
    }

    public Date getDataIngres() {
        return dataIngres;
    }

    public int getAnyMatriculacio() {
        return anyMatriculacio;
    }

    public boolean isAveriat() {
        return averiat;
    }



    @Override
    public String toString() {
        return String.format("(%s, %s, %d, %b)", this.modelCotxes, this.dataIngres, this.anyMatriculacio, this.averiat);
    }
}
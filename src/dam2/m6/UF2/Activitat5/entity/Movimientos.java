package dam2.m6.UF2.Activitat5.entity;
// Generated 31-ene-2021 20:04:23 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Movimientos generated by hbm2java
 */
@Entity
@Table(name = "movimientos")
public class Movimientos  implements java.io.Serializable {
    
     @Id @GeneratedValue
     @Column(name = "idMovimento")
     private Integer idMovimiento;
      @Column(name = "idPartida")
     private Partida partida;
       @Column(name = "columnaInicio")
     private int columnaInicio;
        @Column(name = "columnaFinal")
     private int columnaFinal;
         @Column(name = "filaInicio")
     private int filaInicio;
          @Column(name = "filaFinal")
     private int filaFinal;
     
    public Movimientos() {
    }

    public Movimientos(Partida partida, int columnaInicio, int columnaFinal, int filaInicio, int filaFinal) {
       this.partida = partida;
       this.columnaInicio = columnaInicio;
       this.columnaFinal = columnaFinal;
       this.filaInicio = filaInicio;
       this.filaFinal = filaFinal;
    }
   
    public Integer getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    public Partida getPartida() {
        return this.partida;
    }
    
    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    public int getColumnaInicio() {
        return this.columnaInicio;
    }
    
    public void setColumnaInicio(int columnaInicio) {
        this.columnaInicio = columnaInicio;
    }
    public int getColumnaFinal() {
        return this.columnaFinal;
    }
    
    public void setColumnaFinal(int columnaFinal) {
        this.columnaFinal = columnaFinal;
    }
    public int getFilaInicio() {
        return this.filaInicio;
    }
    
    public void setFilaInicio(int filaInicio) {
        this.filaInicio = filaInicio;
    }
    public int getFilaFinal() {
        return this.filaFinal;
    }
    
    public void setFilaFinal(int filaFinal) {
        this.filaFinal = filaFinal;
    }




}



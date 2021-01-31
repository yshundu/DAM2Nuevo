/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m6.UF2.Activitat5.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Yang
 */
@Entity
@Table(name = "partida", schema = "damas")
public class Partida implements Serializable {
    
    private int idPartida;
     private String guanyador;
     private Set movimientos = new HashSet(0);

    public Partida() {
    }

    public Partida(String guanyador) {
        this.guanyador = guanyador;
    }
    
    public Partida(String guanyador, Set movimientos) {
       this.guanyador = guanyador;
       this.movimientos = movimientos;
    }
    
    @Id
    @GeneratedValue
    @Column(name = "idPartida")
    public Integer getIdPartida() {
        return this.idPartida;
    }
    
    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }
    
    @Column(name = "guanyador")
    public String getGuanyador() {
        return this.guanyador;
    }
    
    public void setGuanyador(String guanyador) {
        this.guanyador = guanyador;
    }
    public Set getMovimientos() {
        return this.movimientos;
    }
    
    public void setMovimientos(Set movimientos) {
        this.movimientos = movimientos;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m6.UF2.Activitat5.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Yang
 */
public class Partida implements Serializable {
    
    private Integer idPartida;
    private String guanyador;

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String getGuanyador() {
        return guanyador;
    }

    public void setGuanyador(String guanyador) {
        this.guanyador = guanyador;
    }


    public Partida() {
    }

    public Partida(Integer idPartida, String guanyador) {
        this.idPartida = idPartida;
        this.guanyador = guanyador;
    }

    

}
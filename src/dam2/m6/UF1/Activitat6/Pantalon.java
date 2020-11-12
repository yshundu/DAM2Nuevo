/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act6m6;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@XmlRootElement(name = "Pantalon")

//@XmlAccessorType(XmlAccessType.FIELD) // This line was added
class Pantalon {
        
        private int id;
        private String detalls;
        private int numeroPantalon;	
        private String marca;
        private String tamany;
        private String tiposPantalones;
    @XmlAttribute(name="detalls")   
    public String getDetalls() {
        return detalls;
    }

    public void setDetalls(String detalls) {
        this.detalls = detalls;
    }

 
     @XmlAttribute(name="id")
     public int getId() {
		return this.id;
	}        
	public void setId(int id) {
		this.id = id;
	}
    @XmlElement(name="numeroPantalon")
    public int getNumeroPantalon() {
        return numeroPantalon;
    }

    public void setNumeroPantalon(int numeroPantalon) {
        this.numeroPantalon = numeroPantalon;
    }
    @XmlElement(name="marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
@XmlElement(name="tamany")
    public String getTamany() {
        return tamany;
    }

    public void setTamany(String Tamany) {
        this.tamany = Tamany;
    }
@XmlElement(name="tiposPantalones")
    public String getTiposPantalones() {
        return tiposPantalones;
    }

    public void setTiposPantalones(String tiposPantalones) {
        this.tiposPantalones = tiposPantalones;
    }
        
        
        
}

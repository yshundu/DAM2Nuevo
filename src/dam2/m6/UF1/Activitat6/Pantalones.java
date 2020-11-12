/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act6m6;

import java.util.Arrays;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Pantalones {
	
	private Pantalon[] pantalones;

    public Pantalon[] getPantalones() {
        return pantalones;
    }
	public void setPantalones(Pantalon[] pantalones) {
		this.pantalones = pantalones;
	}

    @Override
    public String toString() {
        return "Pantalones{" + "pantalones=" + Arrays.toString(pantalones) + '}';
    }
 
}

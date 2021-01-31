/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF2.Activitat4;

import java.util.Arrays;

/**
 *
 * @author Yang
 */
public class metodeBombolla implements Runnable{
    
    public int[] arrayBombolla;
    public int parts;

    public metodeBombolla(int[] arrayBombolla, int part) {
        this.arrayBombolla = arrayBombolla;
        this.parts = part;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
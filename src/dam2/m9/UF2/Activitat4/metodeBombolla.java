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

    public metodeBombolla(int[] arrayBombolla, int part ) {
        this.arrayBombolla = arrayBombolla;
        this.parts = part;
    }
    @Override
    public void run() {
        int aux;
        int[] arrayAux;
        for (int i = 1; i < arrayBombolla.length; i++) {

            for (int j = 0; j < arrayBombolla.length - i; j++) {

                if (arrayBombolla[j] > arrayBombolla[j + 1]) {
                    arrayAux = arrayBombolla.clone();
                    aux = arrayBombolla[j];
                    arrayBombolla[j] = arrayBombolla[j + 1];
                    arrayBombolla[j + 1] = aux;
                    
                    System.out.println("Part " + (parts + 1)+ " " + Arrays.toString(arrayAux) + " > " + Arrays.toString(arrayBombolla));
                }

            }

        }
        
        System.out.println(Arrays.toString(arrayBombolla));
    }
}
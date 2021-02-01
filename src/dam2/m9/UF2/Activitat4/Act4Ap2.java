/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF2.Activitat4;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/**
 *
 * @author Yang
 */
public class Act4Ap2 {
    //Inicialitcem el array
    static int[] arrayContador = {0, 0, 0, 0};

    public static void main(String[] args) throws InterruptedException {
        //Les fills
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        //Array de aleatoris
        int[] numerosAleatoris = new int[20];
        //Cridem a la funcio bombolla creant un array de 4 posicions
        metodeBombolla[] arrayBombollas = new metodeBombolla[4];
        //generem els numeros aleatoris dis del array de aleatoris
        for (int i = 0; i < numerosAleatoris.length; i++) {
            numerosAleatoris[i] = (int) (Math.random() * 20) + 1;
        }

        System.out.println(Arrays.toString(numerosAleatoris));
        //Assignem els numeros aleatoris a les posicions del array del metode
        //bombolla
        int contadorX = 0;
        for (int i = 0; i < arrayBombollas.length; i++) {
            int[] arrayAux = new int[numerosAleatoris.length / 4];
            for (int j = 0; j < arrayAux.length; j++) {
                arrayAux[j] = numerosAleatoris[contadorX];
                contadorX++;
            }
            metodeBombolla bombolla = new metodeBombolla(arrayAux, i);
            arrayBombollas[i] = bombolla;
            executor.execute(arrayBombollas[i]);
        }

        executor.shutdown();
        //Generem un array de 20 posicions pels ordenades
        int arrayOrdenada[] = new int[20];
        //Ordenem el array
        for (int i = 0; i < arrayOrdenada.length; i++) {

            int aux = valorMesPetit(
                    arrayBombollas[0].arrayBombolla[arrayContador[0]],
                    arrayBombollas[1].arrayBombolla[arrayContador[1]], 
                    arrayBombollas[2].arrayBombolla[arrayContador[2]], 
                    arrayBombollas[3].arrayBombolla[arrayContador[3]]);

            arrayOrdenada[i] = aux;

        }
        //Utilitzo sleep perque aquest system out sigui lo ultim que surti
        //mentres que els fills acaben
         Thread.sleep(500);
         //Imprimim per pantalla el array
        System.out.println(Arrays.toString(arrayOrdenada));
    }
    //Funcio per buscar el valor mes petita
    static int valorMesPetit(int valor1, int valor2, int valor3, int valor4 ) {

        int[] aux = {valor1, valor2, valor3, valor4};
        int minim = valor1;
        int y = 0;
        boolean comprovar = false;
        
        for (int i = 0; i < aux.length; i++) {

            if (arrayContador[i] < 4) {
                
                if (aux[i] <= minim ) {
                    minim = aux[i];
                    y = i;
                    
                    comprovar = true;
                }
            }

        }
        
        if (comprovar == true) {
            arrayContador[y]++;

        }

        return minim;
    }
}
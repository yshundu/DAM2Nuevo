/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF2.Activitat4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/**
 *
 * @author Yang
 */
public class Act4Ap3AForkJoin extends RecursiveTask<Long>{
    int base;
    int exponente;

    public Act4Ap3AForkJoin(int base, int exponente) {
        this.base = base;
        this.exponente = exponente;
    }
    
    public static int elevadoX(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
        return elevadoX (base,exponente-1) * base;
        }
    }
    
    @Override
    protected Long compute() {
        if (exponente == 0) {
            return (long) 1;
        } else {
            //Si el exponente no es 0 llamamos a la funcion de nuevo
            Act4Ap3AForkJoin tmp = new Act4Ap3AForkJoin(base,exponente-1);
            tmp.fork();
            return tmp.join() * base;
        }
    }
    
        public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new Act4Ap3AForkJoin(5,5)));

    }
}

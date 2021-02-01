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
public class Act4Ap3BForkJoin extends RecursiveTask<Long>{

    int valor1;
    int valor2;
    
    public Act4Ap3BForkJoin(int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    
    @Override
    protected Long compute() {
        if (valor2 == 0) {
            return (long)valor1;
        } else {
            //Si el segon valor no es 0 tornem a cridar a la funcio
            //Y fem un fork join
            Act4Ap3BForkJoin tmp = new Act4Ap3BForkJoin(valor2, valor1%valor2);
            tmp.fork();
            return (long)tmp.join();
        }
    }
    
    public static void main(String[] args) {
     ForkJoinPool pool = new ForkJoinPool();
     System.out.println(pool.invoke(new Act4Ap3BForkJoin(15, 5)));

    }
}

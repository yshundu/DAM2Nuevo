/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF2.Activitat2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class activitatM9UF2 {

    public static void main(final String... args) throws InterruptedException, ExecutionException {
        //mostrem hora actual abans d’execució
    Calendar calendario = new GregorianCalendar();
    System.out.println("Inici: "+ calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE) +
        ":" + calendario.get(Calendar.SECOND));
    // Crea un pool de 4 fils
    final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(4);
    // Crea objecte Runnable.
    final Runnable ob = new activitatM9UF2().new ExecutaFil();
    // Programa Fil, s’inicia als 5 segons i després es va executant cada 6 segons
    schExService.scheduleWithFixedDelay(ob, 5, 6, TimeUnit.SECONDS);
    // Espera per acabar 35 segons
    schExService.awaitTermination(35, TimeUnit.SECONDS);
    // shutdown .
    schExService.shutdownNow();
    System.out.println("Completat");
    }

    // Fil Runnable
    class ExecutaFil implements Runnable {
        @Override
        public void run() {
            Calendar calendario = new GregorianCalendar();
            System.out.println("Hora execució tasca: "+
                calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                calendario.get(Calendar.MINUTE) + ":" +
                calendario.get(Calendar.SECOND));
            System.out.println("Tasca en execució");
            System.out.println("Execució acabada");
            }
        }
    }

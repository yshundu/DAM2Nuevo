/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF2.Activitat1;

import java.util.*;
import java.util.concurrent.*;

public class Activitat1UF2 {
	static class Suma implements Callable<Integer> {
		private int operador1;
		private int operador2;
		
		public Suma(int operador1, int operador2) {
			this.operador1 = operador1;
			this.operador2 = operador2;
			}
                //Cambiem el tipus de Multiplicacio a Suma
		@Override
		public Integer call() throws Exception {
			return operador1 + operador2;
			}
		}

	public static void main(String[] args) throws
		InterruptedException, ExecutionException {
                    //3 fills a 5 fills
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
			List<Suma> llistaTasques= new ArrayList<Suma>();
                        //Augmentem les tasques de 10 a 25
			for (int i = 0; i < 25; i++) {
				Suma calcula = new Suma((int)(Math.random()*10), (int)(Math.random()*10));
				llistaTasques.add(calcula);
				}
			List <Future<Integer>> llistaResultats;
			llistaResultats = executor.invokeAll(llistaTasques);
			
			executor.shutdown();    
			
			for (int i = 0; i < llistaResultats.size(); i++) {
				Future<Integer> resultat = llistaResultats.get(i);
				try {
					System.out.println("Resultat tasca "+i+ " és:" +
					resultat.get());
				}
				catch (InterruptedException | ExecutionException e)
					{
                                            e.printStackTrace();
					}
				}
		}
	}

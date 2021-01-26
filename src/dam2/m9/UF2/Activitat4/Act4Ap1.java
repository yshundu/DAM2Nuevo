package dam2.m9.UF2.Activitat4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Alumne
 */
public class Act4Ap1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        List<Client> llistaTasques = new ArrayList<Client>();
        
        for (int i=1;i<=50;i++) {
            int cantitatArticles = (int) (Math.random() * 30 + 1);
            Client client = new Client(cantitatArticles);
            llistaTasques.add(client);
            System.out.println("Creat el client "+i+" amb " + client.getArticles() + " articles " + Arrays.toString(client.getArrayArticles()));
            Thread.sleep(3000);
        }
        
        List <Future<Integer>> llistaResultats;
	llistaResultats = executor.invokeAll(llistaTasques);
        //executor.shutdown(); 
        
        for (int i = 0; i < llistaResultats.size(); i++) {
	Future<Integer> resultat = llistaResultats.get(i);
	try {
            System.out.println("Resultat tasca "+i+ " és:" + resultat.get());
	}
	catch (Exception e)
		{
               e.printStackTrace();
		}
	}
    }
    
}

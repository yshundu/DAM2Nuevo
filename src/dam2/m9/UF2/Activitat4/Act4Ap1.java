package dam2.m9.UF2.Activitat4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Yangshun Zhan Du i Raul Gimenez Perez
 */
public class Act4Ap1 {
    public static void main(String[] args) throws InterruptedException {
        //La quantitat de fills
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //Guardem una llista amb les tasques
        List<Client> llistaTasques = new ArrayList<Client>();
        //Creem les 50 clients
        for (int i=1;i<=50;i++) {
            //Aleatori de les quantitats i ho afegim al constructor
            int cantitatArticles = (int) (Math.random() * 30 + 1);
            Client client = new Client(cantitatArticles, i);
            //Afegim la tasca
            llistaTasques.add(client);
           // System.out.println("Creat el client "+i+" amb " + client.getArticles() + " articles " + Arrays.toString(client.getArrayArticles()));            
            
            //executor.shutdown(); 
            //Thread.sleep(3000);
        }
        List <Future<Integer>> llistaResultats;
        llistaResultats = executor.invokeAll(llistaTasques);
    }
    
}

package dam2.m9.UF2.Activitat4;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 *
 * @author Alumne
 */
public class Client implements Callable<Integer>{
    int articles;
    int numClient;
    int arrayArticles[];
 //Constructor
    public Client(int articles, int numClient) {
        this.articles = articles;
        this.numClient = numClient;
        arrayArticles = new int[articles];
        for (int i=0;i<articles;i++){
            arrayArticles[i] = (int) (Math.random() * 7 + 2);
        }
        System.out.println("Creat el client "+ getNumClient() +" amb " + getArticles() + " articles " + Arrays.toString(getArrayArticles()));
        
    }

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }
    
        public int[] getArrayArticles() {
        return arrayArticles;
    }

    public void setArrayArticles(int[] arrayArticles) {
        this.arrayArticles = arrayArticles;
    }
    
    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Client " + getNumClient() + " passa per caixa...");
        //int tempsAleatori;
          for (int j = 0; j < articles + 1; j++) {
                //tempsAleatori = (int) (Math.random() * (6 - 0 + 1));
                try {
                    Thread.sleep(getArrayArticles()[j] * 500);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (j == articles) {
                    //Si la tasca s'ha acabat
                    System.out.println("Client " + numClient + " article " + j + "/" + articles + " (" + getArrayArticles()[j] + " segons) FINALITZAT");
                }else{
                    //Sino
                    System.out.println("Client " + numClient + " article " + j + "/" + articles + " (" + getArrayArticles()[j] + " segons)");
                }
            }
        return 1;
        
    }
}

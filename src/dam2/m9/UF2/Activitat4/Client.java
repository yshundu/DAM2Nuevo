package dam2.m9.UF2.Activitat4;

import java.util.concurrent.Callable;

/**
 *
 * @author Alumne
 */
public class Client implements Callable<Integer>{
    int articles;
    int arrayArticles[];

    public Client(int articles) {
        this.articles = articles;
        arrayArticles = new int[articles];
        for (int i=0;i<articles;i++){
            arrayArticles[i] = (int) (Math.random() * 7 + 2);
        }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package dam2.m9.UF2.Activitat3;

/**
 *
 * @author Alumne
 */
public class calculaFibonacci1 {
    public static long calculaFibonacci(long numero) {
        //double calcul = java.lang.Math.cos(54879854);
        if (numero==0) { return 0; }
        else if (numero==1) { return 1; }
        else {
            return (calculaFibonacci(numero-2) + calculaFibonacci(numero-1));
        }
    }

    public static void main(String[] args){
        calculaFibonacci(50);
    }
}

package dam2.m6.UF2.Activitat5;

/**
 *
 * @author Yang
 */
public class FinestraPartida {
        boolean jugaX = true;
        boolean jugaO = false;
        int filaOrigen = -1;
        int columnaOrigen = -1;
        
        fila = obtenirFilaClicada();
        columna = obtenirColumnaClicada();
        
        if (noHiHaOrigen()) {
            if ((jugaX)&&(esX(fila,columna))) {
                actualitzaNouOrigen(fila,columna);
        } else if ((jugaO)&&(esO(fila,columna))){
                actualitzaNouOrigen(fila,columna);
            }
        else {
            mostraError();
        }
        } else {
            if (movimentValid(fila,columna)) {
                if (esBuit(fila,columna)||(ocupatContrari(fila,columna))) {
                    mou(fila,columna);
                }
            } else if (ocupatPropi(fila,columna)) {
                actualitzaNouOrigen(fila,columna);
            } else {
                mostraErrorMoviment();
            }
        }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m3.UF6.Avaluables.Activitat7Grafic;


public class Fitxa {
    
    // ATRIBUTOS
    private int fila;
    private int columna;
    private String tipo;
    // true -> blanca, false -> negra
    private boolean blanca;

    // CONSTRUCTOR
    public Fitxa(int fila, int columna, javax.swing.JTable tablero, boolean turno){
        this.fila = fila;
        this.columna = columna;
        this.tipo = String.valueOf(tablero.getValueAt(fila, columna));
        this.blanca = turno;
    }
    // CONSTRUCTOR ALTERNATIVO PARA REINICIAR COORDENADAS RÁPDIO
    public Fitxa(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    // GETTERS Y SETTERS
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isBlanca() {
        return blanca;
    }
    public void setBlanca(boolean blanca) {
        this.blanca = blanca;
    }

    public boolean perteneceTurno() {

        final String ENUM_FICHAS_BLANCAS = "TCAQKP";
        final String ENUM_FICHAS_NEGRAS = "tcaqkp";
        boolean pertenece;

        // COLOR TRUE ES BLANCA
        if (this.isBlanca())
            pertenece = ENUM_FICHAS_BLANCAS.contains(this.tipo);
        // NEGRA
        else
            pertenece = ENUM_FICHAS_NEGRAS.contains(this.tipo);

        return pertenece;
    }
    
    
    // METODO QUE PASA DE MAYUSCULAS A MINUSCULAS
    private void mayusMinus() {
        setTipo(tipo.toLowerCase());
        System.out.println(tipo);
    }

    /*
     * METODO QUE DEVUELVE SI UNA FICHA PUEDE HACER UN MOVIMIENTO
     * RECIBE POR PARAMETRO FICHA DESTINO PARA COMPROBAR DESPLAZAMIENTO
     *
     * CUANDO SE LLAMA A ESTE METODO YA SE HA COMPROBADO ANTES QUE EL ORIGEN ES UNA
     * CASILLA CON UNA PIEZA DE SU TURNO. Y EL DESTINO UNA CASILLA CON UN VACIO
     * O UNA PIEZA DEL COLOR CONTRARIO
     */
    public boolean movimientoValido(Fitxa fichaDestino, javax.swing.JTable tablero){

        boolean valido;

        // PASO BLANCAS A MINUSCULAS
        // (YA QUE LAS COMPROBACIONES SON IGUALES PARA BLANCAS Y NEGRAS - EXCEPTO PEON
        mayusMinus();
        // PEON
        switch (this.tipo) {
            // PEON
            case "p":
                System.out.println("peon");
                valido = this.isPeonValido(fichaDestino, tablero);
                break;

            // TORRE
            case "t":
                System.out.println("torre");
                valido = this.isTorreValida(fichaDestino, tablero);
                break;

            // CABALLO
            case "c":
                System.out.println("caballo");
                // SOLO HACE FALTA ESTA LINEA, NO HAY QUE COMPROBAR PATH (COLISIONES), NI LAS 4 DIRECCIONES
                // SIEMPRE AVANZA -> 2 + 1 = 3 -> SUMA DE CASILLAS AVANZADAS
                // AL CUADRADO -> 4 + 1 = 5 -> AL HACERLO AL CUADRADO DAN IGUAL LOS SIGNOS (IGNORA LOS NEGATIVOS) Y VALE PARA TODAS LAS DIRECCIONES A LA VEZ
                valido = (Math.pow(this.fila - fichaDestino.getFila(), 2)
                        + Math.pow(this.columna - fichaDestino.getColumna(), 2) == 5);
                break;

            // ALFIL
            case "a":
                System.out.println("alfil");
                valido = this.isAlfilValido(fichaDestino, tablero);
                break;

            // REINA (COMBINACION/SUMA DE MOVIMIENTOS DE LA TORRE Y EL ALFIL)
            case "q":
                valido = this.isTorreValida(fichaDestino, tablero)
                        || this.isAlfilValido(fichaDestino, tablero);
                break;
            case "·":
                valido = false;
                System.out.println("agua");
                break;
            // REY
            default:
                System.out.println("rey");
                // SE PUEDE MOVER 1 CASILLA EN CUALQUIER DIRECCION
                // NO HAY QUE COMPROBAR PATH (COLISIONES)
                valido = (Math.abs(fila - fichaDestino.getFila()) <= 1
                        && Math.abs(columna - fichaDestino.getColumna()) <= 1);
                
                break;
        }

        return valido;
    }

    // METODO QUE DEVUELVE SI LA FICHA PEON PUEDE HACER EL MOVIMIENTO INDICADO
    private boolean isPeonValido(Fitxa destino, javax.swing.JTable tablero) {

        boolean valido;

        // INTENTA COMER
        if (!destino.getTipo().equals("·"))
            valido = (Math.abs(columna - destino.getColumna()) == 1)
                    && peonAvanzaUno(destino);

        // NO COME -> NO SE PUEDE MOVER DE LADO
        else if (columna - destino.getColumna() == 0){

            // PRIMER TURNO
            if (fila == 1 || fila == 6) {
                // SE MUEVE 2 CASILLAS
                if (Math.abs(fila - destino.getFila()) == 2){
                    // COMPRUEBA QUE NO SE SALTA UNA FICHA
                    if (this.isBlanca())
                        valido = tablero.getValueAt(fila - 1, columna).equals("·");
                    else
                        valido = tablero.getValueAt(fila + 1, columna).equals("·");
                }
                // SE PODRIA MOVER 1 EN EL PRIMER TURNO
                else
                    valido = peonAvanzaUno(destino);

            }
            // EL RESTO DE TURNOS SOLO PODRIA AVANZAR 1
            else
                valido = peonAvanzaUno(destino);
        }
        // SI SE MUEVE DE LADO SIN COMER
        else
            valido = false;

        return valido;
    }

    // DEVUELVE SI EL PEON PUEDE AVANZAR 1 CASILLA (METODO AUXILIAR DE isPeonValido)
    private boolean peonAvanzaUno(Fitxa destino){

        return (this.isBlanca() && fila - destino.getFila() == 1 // BLANCAS
                || !this.isBlanca() && fila - destino.getFila() == -1); // NEGRAS
    }

    // METODO QUE DEVUELVE SI LA FICHA TORRE PUEDE HACER EL MOVIMIENTO INDICADO
    private boolean isTorreValida(Fitxa destino, javax.swing.JTable tablero) {

        return ((fila == destino.getFila() || columna == destino.getColumna())
                && !colisiona(destino, tablero));
    }

    // METODO QUE DEVUELVE SI LA FICHA ALFIL PUEDE HACER EL MOVIMIENTO INDICADO
    private boolean isAlfilValido(Fitxa destino, javax.swing.JTable tablero) {

        return  ((Math.abs(fila - destino.getFila()) == Math.abs(columna - destino.getColumna()))
                && !colisiona(destino,tablero));
    }

    // METODO QUE DEVUELVE SI UNA FICHA COLISIONA EN SU CAMINO
    // (GENERICO PARA CUALQUIER PIEZA Y DIRECCION)
    private boolean colisiona(Fitxa destino, javax.swing.JTable tablero){

        // CALCULO VECTOR UNITARIO (VER MAS INFO EN EL METODO)
        int direccion[] = calculaVector(destino);

        // MUEVO POSICION INICIAL 1 UNIDAD EN DIRECCION A DESTINO (PARA NO CONTARSE A SI MISMA)
        int filaActual = this.fila + direccion[0]; // uso 2 variables primitivas para no cambiar el valor de la ficha origen (OBJETO)
        int columnaActual = this.columna + direccion[1];

        // MIENTRAS NO HAYAMOS LLEGADO AL DESTINO
        while (!(filaActual == destino.getFila()
                && columnaActual == destino.getColumna())){

            // SI ENCUENTRA ALGO DIFERENTE A VACIO POR EL CAMINO -> SALE PORQUE COLISIONA
            if (!tablero.getValueAt(filaActual, columnaActual).equals("·"))
                return true;

            // VA AVANZANDO 1 UNIDAD HACIA POSICION DESTINO
            filaActual = filaActual + direccion[0];
            columnaActual = columnaActual + direccion[1];
        }

        // SI SALE DEL BUCLE DEVUELVE FALSE PORQUE NO SE HA ENCONTRADO NINGUNA PIEZA DE CAMINO
        return false;
    }

    // METODO QUE DADO UN DESTINO DEVUELVE UN VECTOR UNITARIO QUE INDICA LA TRAYECTORIA
    private int[] calculaVector(Fitxa destino) {

        int vector[] = new int[2]; // pos[0] -> fila, pos[1] -> columna

        // CALCULA DESPLAZAMIENTO ENTRE LAS DOS COORDENADAS ORIGEN Y DESTINO
        int desplazamientoFila = destino.getFila() - this.fila;
        int desplazamientoColumna = destino.getColumna() - this.columna;

        // SE DIVIDE FILA ENTRE SI MISMO (EN VALOR ABSOLUTO) PARA OBTENER VALOR UNITARIO
        // LAS ARRAYS DE INT ESTAN INICIALIZADAS EN 0, ASI QUE SI EL DESPLAZAMIENTO ES 0
        // LA ARRAY YA TENDRÁ 0 ASIGNADO
        if (desplazamientoFila != 0)
            vector[0] = desplazamientoFila / Math.abs(desplazamientoFila);

        // CALCULA COLUMNA IGUAL QUE FILA
        if (desplazamientoColumna != 0)
            vector[1] = desplazamientoColumna / Math.abs(desplazamientoColumna);

        return vector;
    }
}

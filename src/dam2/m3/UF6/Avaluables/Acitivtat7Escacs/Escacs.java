/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m3.UF6.Avaluables.Acitivtat7Escacs;

import java.util.Scanner;


public class Escacs {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

		//Matriz tablero
		Fitxa[][] matriuTauler = new Fitxa[8][8];
		Tauler tauler = new Tauler(matriuTauler);
		
		//Variables
		int cont = 0;
		int origenFila;
		int origenColumna;
		int destiFila;
		int destiColumna;
		boolean acabarPartida = false;
		
		//Inicialitzem tauler
		tauler.omplirTauler();
		
		do {
			tauler.mostrarTauler();
			System.out.println("");
			//Inicien blanques
			if(returnColor(cont) == 'B') {
				System.out.println("Juguen Blanques");
			}else {
				System.out.println("Jueguen Negres");
			}
			

			
			do {		
			//Variables de columna	
			System.out.println("Origen Fila: (1-8)");
			origenFila = teclado.nextInt();
			System.out.print("Origen Columna: (A-H)");
			origenColumna = teclado.next().toUpperCase().charAt(0) - 'A';
			System.out.print("Desti Fila: (1-8)");
			destiFila = teclado.nextInt();
			System.out.print("Desti Columna: (A-H)");
			destiColumna = teclado.next().toUpperCase().charAt(0) - 'A';
			
			System.out.println(origenFila);
			System.out.println(origenColumna);
			System.out.println(destiFila);
			System.out.println(destiColumna);
			
			} while (!tauler.mover(origenFila-1, origenColumna, destiFila-1, destiColumna,returnColor(cont)));
			
			
			cont++;
			
		} while (!acabarPartida);
		
			
		
	}
	
	public static char returnColor(int cont) {
		char color = ' ';
		
		if(cont % 2 == 0) {
			color = 'B';
		}else {
			color = 'n';
		}
		return color;
	}
	
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m3.UF6.Avaluables.Activitat7Grafic;


/**
 *
 * @author fedep
 */
public class Tauler {

	private Fitxa[][] matriuTauler = new Fitxa[8][8];

	public Tauler(Fitxa[][] matriuTauler) {
		this.matriuTauler = matriuTauler;
	}

	public void omplirTauler() {
		//inicialitzem a blancs
		for (int i = 0; i < matriuTauler.length; i++) {
			for (int j = 0; j < matriuTauler.length; j++) {
				matriuTauler[i][j] = new Fitxa('·','·',i,j);
			}
		}

		//Peons
		for (int i = 0; i < 8; i++) {
			matriuTauler[1][i] = new Fitxa('p','n',1,i);;
			matriuTauler[6][i] = new Fitxa('P','B',6,i);;
		}

		//Torres 
		matriuTauler[0][0] = new Fitxa('t','n',0,0);
		matriuTauler[0][7] = new Fitxa('t','n',0,7);
                matriuTauler[7][0] = new Fitxa('T','B',7,0);
                matriuTauler[7][7] = new Fitxa('T','B',7,7);

		//Caballs
		matriuTauler[0][1] = new Fitxa('c','n',0,1);
		matriuTauler[0][6] = new Fitxa('c','n',0,6);
                matriuTauler[7][1] = new Fitxa('C','B',7,1);
		matriuTauler[7][6] = new Fitxa('C','B',7,6);

		//Alfils
		matriuTauler[0][2] = new Fitxa('a','n',0,2);
		matriuTauler[0][5] = new Fitxa('a','n',0,5);
                matriuTauler[7][2] = new Fitxa('A','B',7,2);
		matriuTauler[7][5] = new Fitxa('A','B',7,5);

		//Rey i reina
		matriuTauler[0][3] = new Fitxa('q','n',0,3);
		matriuTauler[0][4] = new Fitxa('k','n',0,4);
                matriuTauler[7][3] = new Fitxa('Q','B',7,3);
		matriuTauler[7][4] = new Fitxa('K','B',7,4);

	}


//	public void mostrarTauler() {
//
//		for (int i = 0; i < matriuTauler.length; i++) {
//			for (int j = 0; j < matriuTauler.length; j++) {
//				if (matriuTauler[i][j] != null) {
//					//System.out.print(matriuTauler[i][j].getTipo() + " ");
//				}
//
//			}
//			System.out.println(" ");
//		}
//	}

	public boolean mover(int origenFila,int origenColumna, int destiFila, int destiColumna,char color) {
		
		//Comprovem que estigui dins del tauler
		if((origenFila >= 0 && origenFila <= 7) &&
				(origenColumna >= 0 && origenColumna <= 7) &&
				(destiFila >= 0 && destiFila <= 7) && 
				(destiColumna >= 0 && destiColumna <= 7)) {

			if(matriuTauler[origenFila][origenColumna].getTipo() != '·' ) {
				if((matriuTauler[origenFila][origenColumna].getColor() == color) && 
						(matriuTauler[destiFila][destiColumna].getColor() != color)) {

					
					if(matriuTauler[origenFila][origenColumna].MoureFitxa(origenFila, origenColumna, destiFila, 
							destiColumna, color, matriuTauler[origenFila][origenColumna].getTipo(),matriuTauler)) {
						
						matriuTauler[destiFila][destiColumna] = matriuTauler[origenFila][origenColumna];
						matriuTauler[origenFila][origenColumna] = new Fitxa('·','·',origenFila,origenColumna);
						return true;
					}else {
						System.out.println("Movimient incorrecte");
						return false;
					}
				}else {
					System.out.println("Aquesta fitxa no és teva");
					return false;
				}

			}else {
				System.out.println("Es una posició buida");
				return false;
			}

		}else {
			System.out.println("Error en el movimient");
			return false;
		}


	}
	
	public boolean reyVivo() {
		boolean reyBlanco = false;
		boolean reyNegro = false;
		
		for (int i = 0; i < matriuTauler.length; i++) {
			for (int j = 0; j < matriuTauler.length; j++) {
			
				if(matriuTauler[i][j].getTipo() == 'K') {
					reyBlanco = true;
				}
				if(matriuTauler[i][j].getTipo() == 'k') {
					reyNegro = true;
				}
				
			}
		}
		
		
		if(reyBlanco && reyNegro) {
			return true;
		}else if(reyBlanco && !reyNegro) {
			System.out.println("Han ganado las Blancas");
			return false;
		}else {
			System.out.println("Han ganado las Negras");
			return false;
		}				
		
	}


}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m5;

/**
 *
 * @author Alumne
 */
public class Activitat8JUnit {
String nom,codi, nomProfessor, aula;
int numAlumnes;
//constructor de la clase modul
 public Activitat8JUnit(String nom, String codi, String nomProfessor, String aula, int numAlumnes) {

 }
//mètodes get per a establir els atributs de la classe (feu els que falten)
 public String getNom() {
 return nom;
 }
 public int getNumAlumnes() {
 return numAlumnes;
 }
//Método que devuelva si els alumnes cabran a l’aula (a una aula hi caben 20 alumnes)
 public boolean alumnesAula() {

     
return true;
}

}

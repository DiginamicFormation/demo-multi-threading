package fr.diginamic.runnables;

import java.util.concurrent.Callable;

/** Classe qui calcule progressivement la somme des 25 premiers entiers et affiche l'étape de
 * calcul (entre 1 et 25).
 * Le Traitement retourne la somme une fois le travail terminé.
 * @author DIGINAMIC
 *
 */
public class Traitement3 implements Callable<Integer> {

	/**
	 * Obligation de rédéfinir la méthode call. 
	 * Comme la classe Traitement3 implémente Call<Integer> alors
	 * la méthode call() doit retourner un résultat de type Integer
	 */
	@Override
	public Integer call() throws Exception {
		Integer somme = 0;
		for (int i=1; i<=25; i++){
			System.out.println("Traitement 3 - étape " + i);
			somme+=i;
			
			// Temps de pause de 375 ms pour simuler un traitement long
			Thread.sleep(375);
		}
		return somme;
	}


}

package fr.diginamic.runnables;

import java.util.concurrent.Callable;

/** Classe qui calcule progressivement la somme des 15 premiers entiers et affiche l'étape de
 * calcul (entre 1 et 15)
 * Le Traitement retourne la somme une fois le travail terminé.
 * @author DIGINAMIC
 *
 */
public class Traitement2 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Integer somme = 0;
		for (int i=1; i<=15; i++){
			System.out.println("Traitement 2 - étape " + i);
			somme+=i;
			
			// Temps de pause de 250 ms pour simuler un traitement long
			Thread.sleep(250);
		}
		return somme;
	}

}

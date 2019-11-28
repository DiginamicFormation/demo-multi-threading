package fr.diginamic.runnables;

import java.util.concurrent.Callable;

/** Classe qui calcule progressivement la somme des 25 premiers entiers et affiche l'étape de
 * calcul (entre 1 et 25).
 * Le Traitement retourne la somme une fois le travail terminé.
 * @author DIGINAMIC
 *
 */
public class Traitement3 implements Callable<Integer> {

	
	public Integer call() {
		Integer somme = 0;
		for (int i=1; i<=25; i++){
			System.out.println("Traitement 3 - étape " + i);
			somme+=i;
			try {
				Thread.sleep(375);
			} catch (InterruptedException e) {
				// en cas de problème de gestion de thread, je génère
				// une exception pour interrompre le thread
				throw new RuntimeException(e);
			}
		}
		return somme;
	}


}

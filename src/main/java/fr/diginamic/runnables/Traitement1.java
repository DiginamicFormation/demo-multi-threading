package fr.diginamic.runnables;

import java.util.concurrent.Callable;

/** Classe qui calcule progressivement la somme des 10 premiers entiers et affiche l'étape de
 * calcul (entre 0 et 9)
 * Le Traitement retourne la somme une fois le travail terminé.
 * @author DIGINAMIC
 *
 */
public class Traitement1 implements Callable<Integer> {

	@Override
	public Integer call() {
		Integer somme = 0;
		for (int i=1; i<=10; i++){
			System.out.println("Traitement 1 - étape " + i);
			somme+=i;
			try {
				Thread.sleep(125);
			} catch (InterruptedException e) {
				// en cas de problème de gestion de thread, je génère
				// une exception pour interrompre le thread
				throw new RuntimeException(e);
			}
		}
		return somme;
	}

}

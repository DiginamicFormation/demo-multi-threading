package fr.diginamic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import fr.diginamic.runnables.Traitement1;
import fr.diginamic.runnables.Traitement2;
import fr.diginamic.runnables.Traitement3;

/**
 * Classe de mise en oeuvre du multi-threading
 * 
 * @author DIGINAMIC
 *
 */
public class AppelMultiThreading {

	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args paramètres non utilisés ici
	 * @throws Exception une exception peut se produire si un thread échoue
	 */
	public static void main(String[] args) throws Exception {

		/*
		 * Chaque classe Traitement1, Traitement2 et Traitement3 implémentent une
		 * interface appelée Callable<T>. Cette interface oblige à redéfinir la méthode
		 * call(). Le type générique <T> correspond au type de rétour de la méthode
		 * call(). Pour chacune des classes ci-dessous, c'est Callable<Integer> qui est
		 * implémentée.
		 */
		Traitement1 tt1 = new Traitement1();
		Traitement2 tt2 = new Traitement2();
		Traitement3 tt3 = new Traitement3();

		// L'instance de ExecutorService threadService créée ci-dessous permet de gérer
		// l'exécution en parallèlle des divers threads (Traitement1, Traitement2 et
		// Traitement3).
		// La valeur 3 passée en paramètre de cette méthode correspond au nombre de
		// threads qu'on va exécuter en parallèle
		ExecutorService threadService = Executors.newFixedThreadPool(3);

		// on demande l'exécution du traitement 1 à threadService
		// La méthode submit retourne un objet de type Future
		// Cet objet futur possède une méthode get() qui retourne le résultat
		// du traitement 1 uniquement lorsque le traitement 1 est terminé.
		Future<Integer> future1 = threadService.submit(tt1);

		// on demande l'exécution du traitement 2 à threadService
		Future<Integer> future2 = threadService.submit(tt2);

		// on demande l'exécution du traitement 3 à threadService
		Future<Integer> future3 = threadService.submit(tt3);

		// On attend que tous les traitements soient terminés de manière
		// à ensuite pouvoir invoquer la méthode get() de chaque objet
		// future.
		// Si on invoque cette méthode sur un futur non terminé, la méthode
		// get() retourne null.
		while (!future1.isDone() && !future2.isDone() && !future3.isDone()) {
		}

		// Une fois tous les traitements terminés, on récupère les résultats
		// retournés par chaque traitement pour les agréger.
		Integer sommeGlobale = future1.get() + future2.get() + future3.get();

		// On affiche le résultat final
		System.out.println("Résultat final: " + sommeGlobale);
	}

}

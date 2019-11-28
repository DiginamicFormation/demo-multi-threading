package fr.diginamic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import fr.diginamic.runnables.Traitement1;
import fr.diginamic.runnables.Traitement2;
import fr.diginamic.runnables.Traitement3;

/** Classe de mise en oeuvre du multi-threading
 * @author DIGINAMIC
 *
 */
public class AppelMultiThreading {

	/** Point d'entrée de l'application
	 * @param args paramètres non utilisés ici
	 * @throws Exception une exception peut se produire si un thread échoue
	 */
	public static void main(String[] args) throws Exception {
		
		// Chaque classe Traitement1, 2 et 3 implémentent une interface Callable.
		// qui oblige à redéfinir la méthode call.
		Traitement1 tt1 = new Traitement1();
		Traitement2 tt2 = new Traitement2();
		Traitement3 tt3 = new Traitement3();
		
		// On créé un executor service en passant par une factory
		// en paramètre de cette factory, on indique le nb de threads 
		// qu'on va exécuter en parallèle
		ExecutorService threadService = Executors.newFixedThreadPool(3);
		
		// on demande l'exécution du traitement 1 à l'executor service
		// La méthode submit retourne un objet de type Future
		// Cet objet futur possède une méthode get() qui retourne le résultat
		// du traitement 1 uniquement lorsque le traitement 1 sera terminé.
		Future<Integer> future1 = threadService.submit(tt1);
		
		// on demande l'exécution du traitement 2 à l'executor service
		Future<Integer> future2 = threadService.submit(tt2);
		
		// on demande l'exécution du traitement 3 à l'executor service
		Future<Integer> future3 = threadService.submit(tt3);
		
		// On attend que tous les traitements soient terminés de manière
		// à ensuite pouvoir invoquer la méthode get() de chaque objet
		// future.
		// Si on invoque cette méthode sur un futur non terminé, la méthode
		// get() retourne null.
		while (!future1.isDone() && !future2.isDone() && !future3.isDone()){
			Thread.sleep(1);
		}
		
		// Une fois tous les traitements terminés, on récupère les résultats
		// retournés par chaque traitement pour les agréger.
		Integer sommeGlobale = future1.get()+future2.get()+future3.get();
		
		// On affiche le résultat final
		System.out.println(sommeGlobale);
	}

}

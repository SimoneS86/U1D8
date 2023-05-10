package esercizio2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SommaTotale {

	private static final Logger logger = LoggerFactory.getLogger(SommaTotale.class);

	public static void main(String[] args) {
		int[] arrayCasuale = new int[3000];
		Random rand = new Random();
		for (int i = 0; i < arrayCasuale.length; i++) {
			arrayCasuale[i] = rand.nextInt(100);
		}

		MyRunnableSomma thread1 = new MyRunnableSomma(arrayCasuale, 0, 1000);
		MyRunnableSomma thread2 = new MyRunnableSomma(arrayCasuale, 1000, 2000);
		MyRunnableSomma thread3 = new MyRunnableSomma(arrayCasuale, 2000, 3000);

		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);

		t1.start();
		t2.start();
		t3.start();

		int sommaTotale = 0;
		try {
			t1.join();
			sommaTotale += thread1.getSommaParziale();
			t2.join();
			sommaTotale += thread2.getSommaParziale();
			t3.join();
			sommaTotale += thread3.getSommaParziale();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.info("Somma totale: " + sommaTotale);
	}
}
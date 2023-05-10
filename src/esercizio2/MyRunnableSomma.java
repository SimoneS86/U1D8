package esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRunnableSomma implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(MyRunnableSomma.class);
	private int[] arrayCasuale;
	private int inizio, fine;
	private int sommaParziale;

	public MyRunnableSomma(int[] arrayCasuale, int inizio, int fine) {
		this.arrayCasuale = arrayCasuale;
		this.inizio = inizio;
		this.fine = fine;
		this.sommaParziale = 0;
	}

	public void run() {
		for (int i = inizio; i < fine; i++) {
			sommaParziale += arrayCasuale[i];
		}
		logger.info("Thread completato: SommaParziale: " + sommaParziale);
	}

	public int getSommaParziale() {
		return sommaParziale;
	}
}
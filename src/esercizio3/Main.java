package esercizio3;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		RegistroPresenze registro = new RegistroPresenze();

		registro.aggiungiPresenza("Roberto Baggio", 4);
		registro.aggiungiPresenza("Paolo Maldini", 9);
		registro.aggiungiPresenza("Alessandro Del Piero", 12);
		registro.aggiungiPresenza("Javier Zanetti", 4);
		registro.aggiungiPresenza("Ajeje Brazorf", 1);

		File file = new File("presenze.txt");

		try {
			registro.salvaSuFile(file);
			RegistroPresenze registroCaricato = new RegistroPresenze();
			registroCaricato.caricaDaFile(file);

			logger.info("Presenze caricate da file:");
			for (RegistroPresenze.Presenza p : registroCaricato.getPresenze()) {
				logger.info(p.getNome() + ": " + p.getGiorni() + " giorni");
			}
		} catch (IOException e) {
			logger.error("Errore durante l'accesso al file: " + e.getMessage());
		}
	}
}

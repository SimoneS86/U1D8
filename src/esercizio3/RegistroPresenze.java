package esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	private List<Presenza> presenze;

	public RegistroPresenze() {
		presenze = new ArrayList<>();
	}

	public void aggiungiPresenza(String nome, int giorni) {
		presenze.add(new Presenza(nome, giorni));
	}

	public void salvaSuFile(File file) throws IOException {
		List<String> presenzeToString = new ArrayList<>();
		for (Presenza p : presenze) {
			presenzeToString.add(p.getNome() + "@" + p.getGiorni());
		}
		String data = String.join("#", presenzeToString);
		FileUtils.writeStringToFile(file, data, "UTF-8");
	}

	public void caricaDaFile(File file) throws IOException {
		String data = FileUtils.readFileToString(file, "UTF-8");
		String[] presenzeToString = data.split("#");
		for (String p : presenzeToString) {
			String[] sezioni = p.split("@");
			String nome = sezioni[0];
			int giorni = Integer.parseInt(sezioni[1]);
			presenze.add(new Presenza(nome, giorni));
		}
	}

	public List<Presenza> getPresenze() {
		return Collections.unmodifiableList(presenze);
	}

	public static class Presenza {
		private String nome;
		private int giorni;

		public Presenza(String nome, int giorni) {
			this.nome = nome;
			this.giorni = giorni;
		}

		public String getNome() {
			return nome;
		}

		public int getGiorni() {
			return giorni;
		}
	}
}

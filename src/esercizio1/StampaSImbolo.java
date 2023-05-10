package esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StampaSImbolo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnableStampaSimbolo("*"));
		Thread t2 = new Thread(new MyRunnableStampaSimbolo("#"));
		t1.start();
		t2.start();
	}

	private static class MyRunnableStampaSimbolo implements Runnable {
		private String simbolo;
		private Logger logger;

		public MyRunnableStampaSimbolo(String simbolo) {
			this.simbolo = simbolo;
			this.logger = LoggerFactory.getLogger(MyRunnableStampaSimbolo.class);
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				logger.info(simbolo);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.error("Thread interrupted", e);
				}
			}
		}
	}
}

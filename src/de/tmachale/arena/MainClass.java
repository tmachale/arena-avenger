package de.tmachale.arena;

import Prog1Tools.IOTools;

public class MainClass {

	public static void main(String[] args) {

		int read, attackUser, attackCPU, timeInt, userDef;
		int x = 0, level=1;
		long timeUser, zstNachher, zstVorher;
		Warri warriHummel=new Warri();
		Warri warriEnemy=new Warri();
		
		System.out
				.println("Erstelle deinen Warrior, du kannst 70 Punkte beliebig verteilen");
		String name = IOTools.readString("Gib den Namen deines Warris ein: ");
		do {
			if (x > 0) {
				System.out.println("Werte ergeben nicht 70. Bitte erneut eingeben:");
			}
			warriHummel.setLife(IOTools.readInteger("Leben:"));
			warriHummel.setAttack(IOTools.readInteger("Angriff:"));
			warriHummel.setAgi(IOTools.readInteger("Beweglichkeit:"));
			x = x + 1;
		} while (warriHummel.getLife()+warriHummel.getAttack()+warriHummel.getAgi() != 70);

		

	
	do {
		System.out.println("");
		System.out.println("Level:"+level);
		System.out.println("");
		System.out.println("Warrior: " + name + " Leben: " + warriHummel.getLife()
				+ " Angriff: " + warriHummel.getAttack() + " Beweglichkeit: " + warriHummel.getAgi());

		warriEnemy.setLife((int) ((Math.random() * 10) + 10)+10*level);
		warriEnemy.setAttack((int) ((Math.random() * 10) + 10)+10*level);
		warriEnemy.setAgiForPc((int) 50+20*level);
		System.out.println("CPU Leben: " + warriEnemy.getLife() + " Angriff: "
				+ warriEnemy.getAttack() + " Beweglichkeit: " + warriEnemy.getAgi());
		char goGo = IOTools.readChar("Kann es losgehen?");
		if (goGo == 'j') {
		}
		// Start round
		System.out.println("");
		int round = 0;
		while (warriEnemy.getLife() > 0 && warriHummel.getLife() > 0) {
			round = round + 1;
			System.out.println("");
			System.out.println("Runde " + round + ":");
			System.out.println("---------------------");
			// Angriff Spieler
			System.out.println(name + " greift an!");
			int randomNumb = (int) ((Math.random() * 10));
			System.out.println("Drücke " + randomNumb);
			zstVorher = System.currentTimeMillis();
			do {
				read = IOTools.readInteger();
			} while (read != randomNumb);

			zstNachher = System.currentTimeMillis();
			System.out.println("Zeit benötigt: " + ((zstNachher - zstVorher))
					+ " ms");
			timeUser = zstNachher - zstVorher;
			timeInt = (int) timeUser;
			attackUser = warriHummel.getAttack() * 600 / timeInt;
			System.out.println(name + " greift mit " + attackUser + " an!");
			// Ende Angriff Spieler

			// Verteidigung Bot
			try {
				Thread.sleep(1000);
			} catch (Exception ex) { /* !! DOUH !! */
			}
			;
			int botDef = (int) ((Math.random() * 10 * 1));
			botDef = attackUser * botDef / 100;
			System.out.println("CPU blockt " + botDef + " Schaden");
			warriEnemy.setLife(warriEnemy.getLife() - attackUser + botDef);
			System.out.println("");
			// Ende Verteidigung Bot
			if (warriEnemy.getLife() <= 0) {
				System.out.println(name + " gewinnt!");
				
			}else{
				// Angriff Bot
					attackCPU = warriEnemy.getAttack();
				System.out.println("CPU greift mit " + attackCPU + " an!");
				// Ende Agriff Bot

				// Verteidigung Spieler
				try {
					Thread.sleep(1000);
				} catch (Exception ex) { /* !! DOUH !! */
				}
				;
				userDef = warriEnemy.getAttack() /10; //need better balance
				System.out.println(name + " blockt " + userDef + " Schaden");
				warriHummel.setLife(warriHummel.getLife() - attackCPU + userDef);
				System.out.println("");
				// Ende Verteidigung
				if (warriHummel.getLife() <= 0) {
					System.out.println(name + " hat leider verloren.");
					System.exit(0);
				}
				// Ausgabe Werte
				try {
					Thread.sleep(1000);
				} catch (Exception ex) { /* !! DOUH !! */
				}
				
				System.out.println(name + " Leben: " + warriHummel.getLife()
						+ "  CPU Leben: " + warriEnemy.getLife());
				try {
					Thread.sleep(1000);
				} catch (Exception ex) { /* !! DOUH !! */
				}
				
				System.out.println();

				char again = IOTools.readChar("Nächste Runde Starten?");
				if (again == 'j') {
					
				}
				}
	
		}
			// Ende round
				level++;
				warriHummel.setLife(70-warriHummel.getAgi()-warriHummel.getAttack());
				}while (warriHummel.getLife() > 0);
		}

	public String getWarri() {
		String s = "blub";
		return s;
	}
	
}
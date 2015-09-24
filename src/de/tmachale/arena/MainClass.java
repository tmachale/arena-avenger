package de.tmachale.arena;

import Prog1Tools.IOTools;

public class MainClass {

	public static void main(String[] args) {

		int all, read, attackUser, attackCPU, longAttack, timeInt, userDef;
		int x = 0, level = 0;
		long timeUser, zstNachher, zstVorher;
		Warri warriHummel=new Warri();
		
		System.out
				.println("Erstelle deinen Warrior, du kannst 70 Punkte beliebig verteilen");
		String name = IOTools.readString("Gib den Namen deines Warris ein: ");
		do {
			if (x > 0) {
				System.out
						.println("Werte ergeben nicht 70. Bitte erneut eingeben:");
			}
			warriHummel.setLife(IOTools.readInteger("Leben:"));
			warriHummel.setAttack(IOTools.readInteger("Angriff:"));
			warriHummel.setAgi(IOTools.readInteger("Beweglichkeit:"));
			x = x + 1;
		} while (warriHummel.getLife()+warriHummel.getAttack()+warriHummel.getAgi() != 70);

		

		System.out.println("");
		System.out.println("Level " + (level + 1));
		System.out.println("Warrior: " + name + " Leben: " + warriHummel.getLife()
				+ " Angriff: " + warriHummel.getAttack() + " Beweglichkeit: " + warriHummel.getAgi());

		int[] warriCPU = new int[3];
		warriCPU[0] = (int) ((Math.random() * 10) + 20);
		warriCPU[1] = (int) ((Math.random() * 10) + 20);
		warriCPU[2] = (int) 70 - warriCPU[0] - warriCPU[1];
		System.out.println("CPU Leben: " + warriCPU[0] + " Angriff: "
				+ warriCPU[1] + " Beweglichkeit: " + warriCPU[2]);
		char goGo = IOTools.readChar("Kann es losgehen?");
		if (goGo == 'j') {
		}
		// Start round
		System.out.println("");
		int round = 0;
		while (warriCPU[0] > 0 && warriHummel.getLife() > 0) {
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
			int botDef = (int) ((Math.random() * 10 * level));
			botDef = attackUser * botDef / 100;
			System.out.println("CPU blockt " + botDef + " Schaden");
			warriCPU[0] = warriCPU[0] - attackUser + botDef;
			System.out.println("");
			// Ende Verteidigung Bot
			if (warriCPU[0] <= 0) {
				System.out.println(name + " gewinnt!");
				level++;
			} else {
				// Angriff Bot
				switch (level) {
				case 1:
					attackCPU = warriCPU[1] * 5 / 10;
					break;
				case 2:
					attackCPU = warriCPU[1] * 6 / 10;
					break;
				case 3:
					attackCPU = warriCPU[1] * 7 / 10;
					break;
				case 4:
					attackCPU = warriCPU[1] * 8 / 10;
					break;
				case 5:
					attackCPU = warriCPU[1] * 9 / 10;
					break;
				default:
					attackCPU = warriCPU[1];
					break;
				}

				System.out.println("CPU greift mit " + attackCPU + " an!");
				// Ende Agriff Bot

				// Verteidigung Spieler
				try {
					Thread.sleep(1000);
				} catch (Exception ex) { /* !! DOUH !! */
				}
				;
				userDef = warriCPU[1] / 2;
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
				;
				System.out.println(name + " Leben: " + warriHummel.getLife()
						+ "  CPU Leben: " + warriCPU[0]);
				try {
					Thread.sleep(1000);
				} catch (Exception ex) { /* !! DOUH !! */
				}
				;
				System.out.println();

				char again = IOTools.readChar("Nächste Runde Starten?");
				if (again == 'j') {

				}
				// System.out.println("3");
				// try {Thread.sleep(1000); } catch(Exception ex) { /* !!
				// DOUH !! */ };
				// System.out.println("2");
				// try {Thread.sleep(1000); } catch(Exception ex) { /* !!
				// DOUH !! */ };
				// System.out.println("1");
				// try {Thread.sleep(1000); } catch(Exception ex) { /* !!
				// DOUH !! */ };
				//
				// try {Thread.sleep(3000); } catch(Exception ex) { /* !!
				// DOUH !! */ };

			}
			// Ende round
		}
		//
	}

	public String getWarri() {
		String s = "blub";
		return s;
	}
	// public Integer theAttack(){
	// System.out.println(name+"greift an!");

	// }
}
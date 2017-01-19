package blackJack;

import java.util.Scanner;

public class JocBlackJack {

	private Pachet pachetJoc, manaJucator, manaDealer;

	double baniJucator = 100.00;
	Scanner sc = new Scanner(System.in);

	public JocBlackJack() {
		pachetJoc = new Pachet();
		manaJucator = new Pachet();
		manaDealer = new Pachet();
	}

	public void IncepeJoc() {
		
		pachetJoc.pachetDeCarti();
		pachetJoc.amestecaCartileDinPachet();

		while (baniJucator > 0) {

			System.out.println(" AI " + baniJucator +" FISE "+ " CAT VREI SA PARIEZI ");
			double pariuJucator = sc.nextDouble();
			if (pariuJucator > baniJucator) {
				System.out.println(" AI PARIAT MAI MULT DECAT AI !");
				break;
			}
			boolean sfarsitJoc = false;

			manaJucator.trage(pachetJoc);
			manaJucator.trage(pachetJoc);

			manaDealer.trage(pachetJoc);
			manaDealer.trage(pachetJoc);

			while (true) {
				System.out.println(" Mana ta : ");
				System.out.println(manaJucator.toString());
				System.out.println(" VALOAREA MAINII TALE ESTE : " + manaJucator.valoareCarte());
				System.out.println();
				// mana dealer//

				System.out.println(" Dealerul a primit :\n " + manaDealer.getCarte(0).toString() + " si o carte ASCUNSA ");
				System.out.println();
				System.out.println(" CE VREI SA FACI (1)MAI TRAGE  sau (2)STOP");
				int raspuns = sc.nextInt();

				if (raspuns == 1) {
					manaJucator.trage(pachetJoc);
					System.out.println(" Ai primit cartea :" + manaJucator.getCarte(manaJucator.marimePachet() - 1).toString());
					if (manaJucator.valoareCarte() > 21) {
						System.out.println(" Ai pierdut ! " + manaJucator.valoareCarte());
						baniJucator -= pariuJucator;
						sfarsitJoc = true;
						break;
					}
				}
				if (raspuns == 2) {
					break;

				}
			}
			// arata cartile dealerului//
			System.out.println(" Cartile dealerului sunt : " + manaDealer.toString());

			if (manaDealer.valoareCarte() > manaJucator.valoareCarte() && sfarsitJoc == false) {
				System.out.println(" DEALERUL A CASTIGAT !");
				baniJucator -= pariuJucator;
				sfarsitJoc = true;
			}
			while ((manaDealer.valoareCarte() < 21) && sfarsitJoc == false) {
				manaDealer.trage(pachetJoc);
				System.out.println(" Dealerul a Primit : " + manaDealer.getCarte(manaDealer.marimePachet() - 1).toString());

			}
			System.out.println("Valoarea mainii dealerului este : " + manaDealer.valoareCarte());

			if ((manaDealer.valoareCarte() > 17) && sfarsitJoc == false) {
				System.out.println("DEALERUL A PIERDUT ! AI CASTIGAT !");
				baniJucator += pariuJucator;
				sfarsitJoc = true;
			}
			if (manaDealer.valoareCarte() == manaDealer.valoareCarte() && sfarsitJoc == false) {
				System.out.println(" EGALITATE ");
				sfarsitJoc = true;
			}
			if (manaJucator.valoareCarte() > manaDealer.valoareCarte() && sfarsitJoc == false) {
				System.out.println(" AI CASTIGAT !");
				baniJucator += pariuJucator;
				sfarsitJoc = true;
			} else if (sfarsitJoc == false) {
				System.out.println(" AI PIERDUT !");
				baniJucator -= pariuJucator;
				sfarsitJoc = true;
			}

			manaJucator.umplePachetDinNou(pachetJoc);
			manaDealer.umplePachetDinNou(pachetJoc);
			System.out.println(" SFARSIT RUNDA ");

		}
		System.out.println(" SFARSIT JOC ");

	}

}

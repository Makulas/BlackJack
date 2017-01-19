package blackJack;

import java.util.Scanner;

public class DriverJocBlackJack {

	public static void main(String[] args) {
		
		System.out.println();
		System.out.println("***********************BLACKJACK***********************************************");
		System.out.println();
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print(" NUMELE DUMENAVOASTRA : ");String nume = sc.nextLine();
		System.out.println();
		
		System.out.println(" BINE AI VENIT "+ nume + " LA JOCUL BLACKJACK");
		System.out.println(" VEI INCEPE JOCUL CU 100 FISE ");
		System.out.println();
		
		JocBlackJack newGame = new JocBlackJack();
		newGame.IncepeJoc();
		

	}

}

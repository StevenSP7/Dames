package appli;
import java.util.Scanner;

import plateau.Damier;

public class Application {

	public static void main(String[] args) {
		
		Damier partie = new Damier();
		
		Scanner sc = new Scanner(System.in);
		String s;
		boolean GG=false;
		do {

		System.out.println("    a   b   c   d   e   f   g   h   i   j");

		System.out.print("   ");
		for(int i=0;i<10;++i) {
			System.out.print("--- ");
		}

		System.out.println();

		for(int i=9;i>=0;--i) {
			System.out.print(i + " ");
			
			for(int j=0;j<10;++j) {
				System.out.print("| " + partie.getTableau(i,j) + " ");
			}
			
			System.out.print("| ");
			
			System.out.print(i);
			
			System.out.print("\n");
			
			System.out.print("   ");
			
			for(int k=0;k<10;++k) {
				System.out.print("--- ");
			}
			
			System.out.print("\n");
		}

		System.out.println("    a   b   c   d   e   f   g   h   i   j");

		partie.leJoueur();
		s = sc.nextLine();	
		partie.jouer(s);

		GG=partie.Gagnant();
		} while(GG);

	}
	
}
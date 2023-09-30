package plateau;

import java.util.ArrayList;

import ia.Arbre;
import piece.Dame;
import piece.Piece;
import piece.Pion;

public class Damier {
	public static final int MIN = 0;
	public static final int MAX = 9;

	private ArrayList<Piece> noires = new ArrayList<Piece>();
	private ArrayList<Piece> blanches = new ArrayList<Piece>();

	private char[][] tableau = new char[MAX+1][MAX+1];
	private String cp;

	private int joueur = 2;
	Arbre a;
	private Arbre coupsPion;
	private Arbre coupsDame;
	private ArrayList<Arbre> coupsP = new ArrayList<Arbre>();
	private ArrayList<Arbre> coupsD = new ArrayList<Arbre>();
	public int getJoueur() {
		return joueur;
	}

	/**
	 * Initialise l'echiquier avec les pieces a la bonne position et le tableau pour afficher les pieces
	 */
	public Damier() {

		
		for(int y=0;y<10;y+=2) {
			noires.add(new Pion(y, 0, 'n'));
			blanches.add(new Pion(y+1, 9, 'b'));

			noires.add(new Pion(y+1, 0+1, 'n'));
			blanches.add(new Pion(y, 9-1, 'b'));

			noires.add(new Pion(y, 0+2, 'n'));
			blanches.add(new Pion(y+1, 9-2, 'b'));

			noires.add(new Pion(y+1, 0+3, 'n'));
			blanches.add(new Pion(y, 9-3, 'b'));
		}
		
		

		//noires.add(new Dame(6, 2, 'N'));
		/*noires.add(new Pion(2, 6, 'n'));
		blanches.add(new Pion(5, 5, 'b'));
		blanches.add(new Pion(3, 5, 'b'));
		blanches.add(new Pion(5, 3, 'b'));
		blanches.add(new Pion(7, 7, 'b'));*/

		//noires.add(new Pion(8, 8, 'n'));
		
		/*
		noires.add(new Pion(3, 1, 'n'));
		noires.add(new Pion(5, 1, 'n'));
		blanches.add(new Pion(2, 2, 'b'));
		*/
		
		for(int i=0;i<=MAX;++i) {
			for(int j=0;j<=MAX;++j) {
				tableau[i][j]=' ';
			}
		}

		mettreLesPieces();

		/*Arbre test = new Arbre(this);
		System.out.println("ICI");
		test.AlgoMinMax();

		System.out.println("ICI");
		System.out.println(test.minimax3(test,test.getMaxDepth()[0],true));

		Arbre a = new Arbre(this);
		Arbre b = new Arbre(this,a);
		Arbre c = new Arbre(this,a);
		Arbre d = new Arbre(this,b);
		Arbre e = new Arbre(this,b);
		Arbre f = new Arbre(this,c);
		Arbre g = new Arbre(this,c);

		f.setPoints(8);
		g.setPoints(9);

		d.setPoints(7);
		e.setPoints(4);


		a.test2(b);
		a.test2(c);

		b.test2(d);
		b.test2(e);

		c.test2(f);
		c.test2(g);

		ArrayList<ArrayList<Arbre>> arb = new ArrayList<ArrayList<Arbre>>();
		ArrayList<Arbre> ar = new ArrayList<Arbre>();
		ar.add(a);
		ArrayList<Arbre> ar2 = new ArrayList<Arbre>();
		ar2.add(b);
		ar2.add(c);

		ArrayList<Arbre> ar3 = new ArrayList<Arbre>();
		ar3.add(d);
		ar3.add(e);
		ar3.add(f);
		ar3.add(g);

		arb.add(ar);
		arb.add(ar2);
		arb.add(ar3);
		System.out.println("WU "+test.minimax3(a,a.getMaxDepth()[0],true));*/
		/*for(int y=arb.size()-1;y>0;y--) {

			test.RecursivePoints(arb.get(y),3);
		}

		System.out.print("AR3 : ");
		for(int y=0;y<ar3.size();y++) {
			System.out.print("  "+ar3.get(y).getPoints());
		}

		System.out.println();

		System.out.print("AR2 : ");
		for(int y=0;y<ar2.size();y++) {
			System.out.print("  "+ar2.get(y).getPoints());
		}
		System.out.println();

		System.out.print("AR1 " + ar.get(0).getPoints());*/

		//System.out.println(test.meilleurCoup(test,test.getMaxDepth()[0],true));
		//System.out.println(test.getDeepestNodes().get(20).getRacine().getPoints());
		/*System.out.println(test.getDeepestNodes().get(0).getRacine().getNoeud().size());
		System.out.println(test.getDeepestNodes().get(0).getRacine().getNoeud().get(0).getPoints());
		System.out.println(test.getDeepestNodes().get(0).getPoints());*/

		//System.out.println(test.getDeepestNodes().get(0).getRacine().getPoints());
		//System.out.println(test.trouver(test,test.getMaxDepth()[0]));
		//test.initializePoints(test);
		/*
		System.out.println(test.getNoeud().get(0).getPoints());
		System.out.println(test.getMaxDepth()[0]);
		System.out.println(test.meilleurCoup(test,test.getMaxDepth()[0],true));*/
		//System.out.println(test.getNoeud().get(0).getPoints());
		/*
		Arbre coups=new Arbre(this);
		
		coups.CoupObligatoire();
		ArrayList<Arbre> P = coups.getDeepestNodes();
		
		coups.test();
		coups.test2(P);
		coups.getNoeud().get(0).getPartie().afficherDamier();
		System.out.println(coups.getNoeud().size());
		*/
		
		
		//test.getDeepestNodes().get(0).getRacine().getPartie().afficherDamier();
		
		//System.out.println(test.getDeepestNodes().size());
		
		/*
		for(int i=0;i<test.getDeepestNodes().size();i++) {
			test.getDeepestNodes().get(i).getPartie().mettreLesPieces();
			test.getDeepestNodes().get(i).getPartie().afficherDamier();
		}
		*/

	}
	public void Toutletemp(){
		a = new Arbre(this,null);
		a.initialiser();
		this.mettreLesPieces();
	}

	public Damier(Damier d) {

		
		for(int y=0;y<d.getNoires().size();y++) {
			if(d.getNoires().get(y).getClass()==Pion.class) {
				noires.add(new Pion(d.getNoires().get(y).getColonne(), d.getNoires().get(y).getLigne(), 'n'));
			}

			if(d.getNoires().get(y).getClass()==Dame.class) {
				noires.add(new Dame(d.getNoires().get(y).getColonne(), d.getNoires().get(y).getLigne(), 'N'));
			}

		}
		
		for(int y=0;y<d.getBlanches().size();y++) {
			if(d.getBlanches().get(y).getClass()==Dame.class) {
				blanches.add(new Dame(d.getBlanches().get(y).getColonne(), d.getBlanches().get(y).getLigne(), 'B'));
			}
			
			if(d.getBlanches().get(y).getClass()==Pion.class) {
				blanches.add(new Pion(d.getBlanches().get(y).getColonne(), d.getBlanches().get(y).getLigne(), 'b'));
			}
			
		}
		
		joueur=d.getJoueur();

		for(int i=0;i<=MAX;++i) {
			for(int j=0;j<=MAX;++j) {
				tableau[i][j]=' ';
			}
		}
	}
	

	public void Remplacer(Damier d) {
		this.noires.clear();
		this.blanches.clear();

		for(int y=0;y<d.getNoires().size();y++) {
			if(d.getNoires().get(y).getClass()==Pion.class) {
				if(d.getNoires().get(y).getLigne()==9) {
                	noires.add(new Dame(d.getNoires().get(y).getColonne(), d.getNoires().get(y).getLigne(), 'B'));
                }else {
                	noires.add(new Pion(d.getNoires().get(y).getColonne(), d.getNoires().get(y).getLigne(), 'n'));
                }
				
			}

			if(d.getNoires().get(y).getClass()==Dame.class) {
				noires.add(new Dame(d.getNoires().get(y).getColonne(), d.getNoires().get(y).getLigne(), 'N'));
			}

		}

		for(int y=0;y<d.getBlanches().size();y++) {
			if(d.getBlanches().get(y).getClass()==Dame.class) {
				blanches.add(new Dame(d.getBlanches().get(y).getColonne(), d.getBlanches().get(y).getLigne(), 'B'));
			}

			if(d.getBlanches().get(y).getClass()==Pion.class) {
				if(d.getBlanches().get(y).getLigne()==0) {
                	blanches.add(new Dame(d.getBlanches().get(y).getColonne(), d.getBlanches().get(y).getLigne(), 'B'));
                }else {
                	blanches.add(new Pion(d.getBlanches().get(y).getColonne(), d.getBlanches().get(y).getLigne(), 'b'));
                }
				
			}

		}

		for(int i=0;i<=MAX;++i) {
			for(int j=0;j<=MAX;++j) {
				tableau[i][j]=' ';
			}
		}

		d.LeTourDuJoueur();
		this.joueur=d.getJoueur();
		mettreLesPieces();
	}
	
	public void afficherDamier() {

		System.out.println("    a   b   c   d   e   f   g   h   i   j");
		
		System.out.print("   ");
		for(int i=0;i<10;++i) {
			System.out.print("--- ");
		}
		
		System.out.println();

		for(int i=9;i>=0;--i) {
			System.out.print(i + " ");
			
			for(int j=0;j<10;++j) {
				System.out.print("| " + getTableau(i,j) + " ");
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

	}
	/**
	 * Met les pieces dans le tableau
	 */
	public void mettreLesPieces() {

		for(int i=0;i<blanches.size();++i) {
			tableau[blanches.get(i).getLigne()][blanches.get(i).getColonne()]=blanches.get(i).getNom();
		}


		for(int i=0;i<noires.size();++i) {
			tableau[noires.get(i).getLigne()][noires.get(i).getColonne()]=noires.get(i).getNom();
		}

	}

	public void TrouverLeDepart(Arbre a){
		if(a.getRacine().getDeplacement()==null){
			cp=""+a.getDeplacement().charAt(0)+""+a.getDeplacement().charAt(1);
		}else{
			this.TrouverLeDepart(a.getRacine());
		}
	}

	/**
	 * Traduit les coups du joueur 
	 * @param s
	 */
	public void jouer(String s) {
		
		int p=0;
		int y=0;
		int Cas = 0;
		int Max=0;

		if(coupsDame.getMaxDepth()[0]<coupsPion.getMaxDepth()[0]){
			Max=1;
		}
		if(coupsDame.getMaxDepth()[0]>coupsPion.getMaxDepth()[0]){
			Max=2;

		}

		if(!(coupsP.get(0).equals(coupsPion))&&(Max==1||Max==0)) {
				Cas = 1;
				ArrayList<String> a = new ArrayList<String>();
				for (int i = 0; i < coupsP.size(); i++) {

					TrouverLeDepart(coupsP.get(i));

					cp += "" + coupsP.get(i).getDeplacement().charAt(2) + "" + coupsP.get(i).getDeplacement().charAt(3);
					a.add(cp);
				}

				for ( y=0; y < a.size(); y++) {

					if (a.get(y).equals(s)) {
						Cas = 2;
						p=y;
					}
				}
		}
		if(!(coupsD.get(0).equals(coupsDame))&&(Max==2||Max==0)) {
			Cas = 1;
			ArrayList<String> a = new ArrayList<String>();
			for (int i = 0; i < coupsD.size(); i++) {

				TrouverLeDepart(coupsD.get(i));

				cp += "" + coupsD.get(i).getDeplacement().charAt(2) + "" + coupsD.get(i).getDeplacement().charAt(3);
				a.add(cp);
			}

			for ( y=0; y < a.size(); y++) {

				if (a.get(y).equals(s)) {
					Cas = 3;
					p=y;
				}
			}
		}
		if(Cas==2){

			this.Remplacer(coupsP.get(p).getPartie());

		}
		if(Cas==3){

			this.Remplacer(coupsD.get(p).getPartie());

		}


		//Scanner scs = new Scanner(s);
		
		if(Cas==0) {
			if (s.length() == 4) {
				char c = s.charAt(0);
				int colonneSrc = c - 'a';
				int ligneSrc = Integer.parseInt("" + s.charAt(1));

				char d = s.charAt(2);
				int colonneDest = d - 'a';
				int ligneDest = Integer.parseInt("" + s.charAt(3));

				if (LeBonJoueur(colonneSrc, ligneSrc) == true) {

					if (estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Piece piece = occupant(colonneSrc, ligneSrc);
						piece.deplacerPiece(colonneDest, ligneDest, this);
					}
				}

			} else {
				System.out.println("Vous n'avez pas bien ecrit votre coup");
			}
		}

		//scs.close();

	}

	/**
	 * return la position des piece dans le tableau
	 * @param ligne du tableau
	 * @param colonne du tableau
	 * @return la position des pieces ou un caractere vide
	 */

	public char getTableau(int ligne,int colonne) {
		if(colonne < MIN || colonne > MAX || ligne < MIN || ligne > MAX ) {
			return ' ';
		}
		return tableau[ligne][colonne];
	}


	private boolean estLibrePourJoueur(int colonne, int ligne) {
		/*
		if(joueur==1) {
			for(Piece blanche : blanches) {
				if(blanche.occupe(colonne, ligne)) {
					return false;
				}
			}
		}

		if(joueur==2) {
			for(Piece noire : noires) {
				if(noire.occupe(colonne, ligne)) {
					return false;
				}
			}	
		}
		*/

		if(tableau[ligne][colonne]==' ') {
			return true;
		}
		return false;
	}
	
	/**
	 * verifie si la case est occuper par une piece quelconque
	 * @param colonne destination
	 * @param ligne destination
	 * @return true si une piece se trouve sur la destination
	 */
	public boolean estLibre(int colonne, int ligne) {

		for(Piece blanche : blanches) {
			if(blanche.occupe(colonne, ligne)) {
				return false;

			}
		}

		for(Piece noire : noires) {
			if(noire.occupe(colonne, ligne)) {
				return false;
			}
		}	

		return true;

	}

	/**
	 * Savoir si une piece se trouve sur cette case et renvoiyer son type
	 * @param colonne destination
	 * @param ligne destination
	 * @return le type si il y a une piece sur cette case sinon null
	 */
	public Piece occupant(int colonne, int ligne) {

		for(Piece blanche : blanches) {

			if(blanche.occupe(colonne, ligne)) {
				return blanche;
			}

		}

		for(Piece noire : noires) {
			if(noire.occupe(colonne, ligne)) {
				return noire;
			}
		}

		return null;
	}
	
	
	public int Allier(int colonne, int ligne) {

		for(Piece blanche : blanches) {

			if(blanche.occupe(colonne, ligne)) {
				return 1;
			}

		}

		for(Piece noire : noires) {
			if(noire.occupe(colonne, ligne)) {
				return 2;
			}
		}

		return 0;
	}

	/**
	 * verifie si la piece choisie est bien celui du joueur qui doit joueur
	 * @param colonne de la piece
	 * @param ligne de la piece
	 * @return false si ce n'est pas le tour du joueur en question
	 */
	private boolean LeBonJoueur(int colonne, int ligne) {
		for(Piece blanche : blanches) {

			if(blanche.occupe(colonne, ligne)) {

				if(joueur==1) {
					return true;
				}
			}

		}

		for(Piece noire : noires) {
			if(noire.occupe(colonne, ligne)) {
				if(joueur==2) {
					return true;
				}
			}

		}
		System.out.println("Ce n'est pas ton tour");
		return false;
	}

	/**
	 * Si la piece peut etre attaquer par un adversaire
	 * @param colonne destination
	 * @param ligne destination
	 * @return si elle peut etre attaquer
	 */
	/*
	private boolean attaquant(int colonne, int ligne)
	{

		if(joueur==2) {

			for(Piece blanche : blanches)
			{
				if(blanche.peutAllerEn(colonne, ligne, this))
				{
					System.out.println("roi noir en echec");
					return true;
				}
			}
		}

		if(joueur==1) {

			for(Piece noire : noires) {

				if(noire.peutAllerEn(colonne, ligne, this)==true) {
					System.out.println("roi blanc en echec");
					return true;
				}
			}

		}
		return false;
	}
	
	*/
	
	/**
	 * affiche le joueur qui doit jouer
	 */
	public void leJoueur() {


		if(joueur==1) {
			System.out.print("c'est au tour des blanc :");
		}
		if(joueur==2) {
			System.out.print("c'est au tour des noir :");
		}

		
		coupsPion=new Arbre(this);
		coupsPion.CoupObligatoire();
		
		coupsDame=new Arbre(this);
		coupsDame.CoupObligatoireDame();

		coupsP = coupsPion.getDeepestNodes();
		coupsD = coupsDame.getDeepestNodes();

		int Max=0;

		if(coupsDame.getMaxDepth()[0]<coupsPion.getMaxDepth()[0]){
			Max=1;

		}
		if(coupsDame.getMaxDepth()[0]>coupsPion.getMaxDepth()[0]){
			Max=2;

		}

		if(!(coupsP.get(0).equals(coupsPion))) {
			System.out.println("\n"+"Coup Obligatoire: ");
			if(Max==1||Max==0) {
				for (int i = 0; i < coupsP.size(); i++) {
					coupsPion.getDeepestNodes().get(i).depart();
					System.out.print(coupsP.get(i).getDeplacement().charAt(2) + "" + coupsP.get(i).getDeplacement().charAt(3) + "\n");
				}
			}
		}
		
		if(!(coupsD.get(0).equals(coupsDame)) ) {
			if((coupsP.get(0).equals(coupsPion))) {
				System.out.println("\n"+"Coup Obligatoire: ");
			}
			if(Max==2||Max==0) {
				for (int i = 0; i < coupsD.size(); i++) {
					coupsD.get(i).depart();
					System.out.print(coupsD.get(i).getDeplacement().charAt(2) + "" + coupsD.get(i).getDeplacement().charAt(3) + "\n");
				}
			}
		}
	}

	
	public void setVideTableau(int ligne,int col) {
		this.tableau[ligne][col] =' ';
	}

	public char[][] getTableau() {
		return tableau;
	}

	public ArrayList<Piece> getNoires() {
		return noires;
	}

	public ArrayList<Piece> getBlanches() {
		return blanches;
	}
	
	/**
	 * alterne entre les 2 joueur
	 */
	public void LeTourDuJoueur(){

		if(joueur==1) {
			++joueur;
		} else {
			--joueur;
		}

	}

	/**
	 * Verifie si c'est un deplacement possible
	 * @param colonneSrc colonne de la piece
	 * @param ligneSrc ligne de la piece
	 * @param colonneDest colonne de destination
	 * @param ligneDest ligne de destination
	 * @return true si c'est possible de se deplacer vers la destination sinon false
	 */
	public boolean estJouable(int colonneSrc, int ligneSrc, int colonneDest, int ligneDest) {

		Piece piece = occupant(colonneSrc, ligneSrc);

		if(piece == null 
				|| colonneDest < MIN || colonneDest > MAX || ligneDest < MIN || ligneDest > MAX 
				|| !estLibrePourJoueur(colonneDest, ligneDest)
				|| !piece.peutAllerEn(colonneDest, ligneDest, this))
		{
				return false;	
		}

		return true;
	}

	public boolean Gagnant(){
		Toutletemp();
		if(a.getNoeud().isEmpty()){
			if(joueur==1){
				System.out.println("Les Noires ont Gagnees!");
				return false;
			}else
				System.out.println("Les Blancs ont Gagnees!");
				return false;
		}
		if(blanches.isEmpty()){
			System.out.println("Les Noires ont Gagnees!");
			return false;
		}
		if(noires.isEmpty()){
			System.out.println("Les Blancs ont Gagnees!");
			return false;
		}
		return true;
	}

}

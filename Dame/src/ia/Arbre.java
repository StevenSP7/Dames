package ia;

import java.util.ArrayList;

import piece.Dame;
import piece.Pion;
import plateau.Damier;

public class Arbre {

	private Arbre Racine;
    private ArrayList<Arbre> noeud = new ArrayList<Arbre>();
	private int[] maxDepth = new int[1];
	private Damier partie;
	private String deplacement;
	private int Points=0;

	public Damier getPartie() {
		return partie;
	}

	public ArrayList<Arbre> getNoeud() {
		return noeud;
	}

	public String getDeplacement() {
		return deplacement;
	}

	public int[] getMaxDepth() {
		return maxDepth;
	}

	public void test() {
		noeud.clear();
	}

	public void test2(ArrayList<Arbre> A) {
		noeud.addAll(A);
	}

	public Arbre(Damier d,Arbre a){
		partie = d;
		Racine = a;
		deplacement=null;
	}

	public Arbre(Damier d){
		partie = d;
		Racine = null;
		deplacement=null;
	}

	public void initialiser() {
		creer();
	}

	public Arbre getRacine() {
		return Racine;
	}


	public void CoupObligatoire(){
		if(partie.getJoueur()==1) {
			for (int i = 0; i < partie.getBlanches().size(); i++) {
				if (partie.getBlanches().get(i).getClass() == Pion.class) {
					int colonneSrc = partie.getBlanches().get(i).getColonne();
					int ligneSrc = partie.getBlanches().get(i).getLigne();

					int colonneDest = colonneSrc + 2;
					int ligneDest = ligneSrc + 2;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {

						Damier h = new Damier(partie);
						int y=97+colonneSrc;
						char p=(char)y;
						y=97+colonneDest;
						char p2=(char)y;

						h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);

						noeud.add(new Arbre(h,this));
						noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
						noeud.get(noeud.size() - 1).CoupObligatoire();

					}


					colonneDest = colonneSrc + 2;
					ligneDest = ligneSrc - 2;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						int y=97+colonneSrc;
						char p=(char)y;
						y=97+colonneDest;
						char p2=(char)y;


						h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						noeud.add(new Arbre(h,this));
						noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
						noeud.get(noeud.size() - 1).CoupObligatoire();

					}


					colonneDest = colonneSrc - 2;
					ligneDest = ligneSrc - 2;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						int y=97+colonneSrc;
						char p=(char)y;
						y=97+colonneDest;
						char p2=(char)y;


						h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						noeud.add(new Arbre(h,this));
						noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
						noeud.get(noeud.size() - 1).CoupObligatoire();
					}


					colonneDest = colonneSrc - 2;
					ligneDest = ligneSrc + 2;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						int y=97+colonneSrc;
						char p=(char)y;
						y=97+colonneDest;
						char p2=(char)y;


						h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						noeud.add(new Arbre(h,this));
						noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
						noeud.get(noeud.size() - 1).CoupObligatoire();
					}


				}


			}
		}
		if(partie.getJoueur()==2) {
			for (int i = 0; i < partie.getNoires().size(); i++) {

				if (partie.getNoires().get(i).getClass() == Pion.class) {
					int colonneSrc = partie.getNoires().get(i).getColonne();
					int ligneSrc = partie.getNoires().get(i).getLigne();

					int colonneDest = colonneSrc + 2;
					int ligneDest = ligneSrc + 2;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {

						Damier h = new Damier(partie);
						int y=97+colonneSrc;
						char p=(char)y;
						y=97+colonneDest;
						char p2=(char)y;

						h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						noeud.add(new Arbre(h,this));
						noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
						noeud.get(noeud.size() - 1).CoupObligatoire();

					}


					colonneDest = colonneSrc + 2;
					ligneDest = ligneSrc - 2;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						int y=97+colonneSrc;
						char p=(char)y;
						y=97+colonneDest;
						char p2=(char)y;

						h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						noeud.add(new Arbre(h,this));
						noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
						noeud.get(noeud.size() - 1).CoupObligatoire();
					}


					colonneDest = colonneSrc - 2;
					ligneDest = ligneSrc - 2;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						int y=97+colonneSrc;
						char p=(char)y;
						y=97+colonneDest;
						char p2=(char)y;

						h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						noeud.add(new Arbre(h,this));
						noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
						noeud.get(noeud.size() - 1).CoupObligatoire();
					}


					colonneDest = colonneSrc - 2;
					ligneDest = ligneSrc + 2;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						int y=97+colonneSrc;
						char p=(char)y;
						y=97+colonneDest;
						char p2=(char)y;

						h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						noeud.add(new Arbre(h,this));
						noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
						noeud.get(noeud.size() - 1).CoupObligatoire();

					}


				}

			}
		}
	}

	public void CoupObligatoireDame(){

		if(partie.getJoueur()==1) {
			for (int i = 0; i < partie.getBlanches().size(); i++) {

				if (partie.getBlanches().get(i).getClass() == Dame.class) {
					int colonneSrc = partie.getBlanches().get(i).getColonne();
					int ligneSrc = partie.getBlanches().get(i).getLigne();

					for (int x = 1; x < 10; x++) {

						int colonneDest = colonneSrc - x;
						int ligneDest = ligneSrc + x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {

							Damier h = new Damier(partie);
							int y=97+colonneSrc;
							char p=(char)y;
							y=97+colonneDest;
							char p2=(char)y;


							h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
							Dame d = (Dame) h.getBlanches().get(i);
							if (d.getCpt() == 1) {
								noeud.add(new Arbre(h,this));
								noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
								noeud.get(noeud.size() - 1).CoupObligatoireDame();

							}


						}

						colonneDest = colonneSrc + x;
						ligneDest = ligneSrc - x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							int y=97+colonneSrc;
							char p=(char)y;
							y=97+colonneDest;
							char p2=(char)y;

							h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);

							Dame d = (Dame) h.getBlanches().get(i);
							if (d.getCpt() == 1) {
								noeud.add(new Arbre(h,this));
								noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
								noeud.get(noeud.size() - 1).CoupObligatoireDame();

							}

						}

						colonneDest = colonneSrc + x;
						ligneDest = ligneSrc + x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);

							int y=97+colonneSrc;
							char p=(char)y;
							y=97+colonneDest;
							char p2=(char)y;


							h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);

							Dame d = (Dame) h.getBlanches().get(i);
							if (d.getCpt() == 1) {
								noeud.add(new Arbre(h,this));
								noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
								noeud.get(noeud.size() - 1).CoupObligatoireDame();
							}

						}

						colonneDest = colonneSrc - x;
						ligneDest = ligneSrc - x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							int y=97+colonneSrc;
							char p=(char)y;
							y=97+colonneDest;
							char p2=(char)y;

							h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);

							Dame d = (Dame) h.getBlanches().get(i);
							if (d.getCpt() == 1) {
								noeud.add(new Arbre(h,this));
								noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
								noeud.get(noeud.size() - 1).CoupObligatoireDame();
							}
						}
					}
				}
			}
		}
		if(partie.getJoueur()==2) {
			for (int i = 0; i < partie.getNoires().size(); i++) {


				if (partie.getNoires().get(i).getClass() == Dame.class) {
					int colonneSrc = partie.getNoires().get(i).getColonne();
					int ligneSrc = partie.getNoires().get(i).getLigne();

					for (int x = 1; x < 10; x++) {

						int colonneDest = colonneSrc - x;
						int ligneDest = ligneSrc + x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {

							Damier h = new Damier(partie);
							int y=97+colonneSrc;
							char p=(char)y;
							y=97+colonneDest;
							char p2=(char)y;

							h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);

							Dame d = (Dame) h.getNoires().get(i);
							if (d.getCpt() == 1) {
								noeud.add(new Arbre(h,this));
								noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
								noeud.get(noeud.size() - 1).CoupObligatoireDame();

							}


						}

						colonneDest = colonneSrc + x;
						ligneDest = ligneSrc - x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							int y=97+colonneSrc;
							char p=(char)y;
							y=97+colonneDest;
							char p2=(char)y;

							h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);

							Dame d = (Dame) h.getNoires().get(i);
							if (d.getCpt() == 1) {
								noeud.add(new Arbre(h,this));
								noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
								noeud.get(noeud.size() - 1).CoupObligatoireDame();

							}

						}

						colonneDest = colonneSrc + x;
						ligneDest = ligneSrc + x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							int y=97+colonneSrc;
							char p=(char)y;
							y=97+colonneDest;
							char p2=(char)y;


							h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);

							Dame d = (Dame) h.getNoires().get(i);
							if (d.getCpt() == 1) {
								noeud.add(new Arbre(h,this));
								noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
								noeud.get(noeud.size() - 1).CoupObligatoireDame();
							}

						}

						colonneDest = colonneSrc - x;
						ligneDest = ligneSrc - x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							int y=97+colonneSrc;
							char p=(char)y;
							y=97+colonneDest;
							char p2=(char)y;

							h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);

							Dame d = (Dame) h.getNoires().get(i);
							if (d.getCpt() == 1) {
								noeud.add(new Arbre(h,this));
								noeud.get(noeud.size() - 1).deplacement=p+Integer.toString(ligneSrc)+p2+Integer.toString(ligneDest);
								noeud.get(noeud.size() - 1).CoupObligatoireDame();
							}
						}
					}
				}
			}
		}
	}


	public void AlgoMinMax(){
		boolean vainceur=false;
		int joueur;
		ArrayList<ArrayList<Arbre>> arb = new ArrayList<ArrayList<Arbre>>();
		ArrayList<Arbre> a = new ArrayList<Arbre>();
		a.add(this);
		while(true) {
			System.out.println("LA");
			for(int y=0;y<a.size();y++){

				//ne pas oublier le coup obligatoire dame
				a.get(y).CoupObligatoire();
				if(a.get(y).getNoeud().size()==0) {

					a.get(y).creer();
				}else{

					ArrayList<Arbre> b = a.get(y).getDeepestNodes();
					a.get(y).noeud.clear();
					a.get(y).noeud.addAll(b);

					//break;
				}

				if(a.get(y).getPartie().Gagnant()==false){
					a.get(y).getPartie().afficherDamier();
					vainceur=true;
				}

			}
			a.clear();
			a.addAll(getDeepestNodes());
			arb.add(a);
			//for(int h=0;h<;h++){

			//}
			if(a.size()>100||vainceur==true){

				for (int l=0;l<a.size();l++){

					a.get(l).Points = l+1;

				}

                /*for (int o=arb.size()-2;o>0;o--) {
					//System.out.println("lol");
					RecursivePoints(arb.get(o), o);
				}*/

				break;
			}
		}
	}
	public void test2(Arbre A) {
		noeud.add(A);
	}
	/*public void trouver(Arbre node, int profondeur){
            node.getRacine().Points=309844;
        int res=0;
        for (Arbre enfant : node.getNoeud()) {
            int score = trouver(enfant, profondeur - 1);
            res = Math.max(res, score);
        }
        //return res;
    }*/
	// Define a modified version of the Minimax algorithm that starts from the leaf nodes
    /*public int minimax2(Arbre node, int profondeur, boolean joueurMax) {
		if (node.getNoeud().isEmpty()) {
			// Leaf node: return the points for the leaf node
			return node.getPoints();
		}

		// Non-leaf node: recursively evaluate and propagate scores
		ArrayList<Arbre> children = node.getDeepestNodes();
		int bestScore;
		if (joueurMax) {
			// Maximizing player: find the maximum score among the children
			bestScore = Integer.MIN_VALUE;
			for (Arbre child : children) {
				int score = minimax(child, profondeur - 1, false); // Recursively evaluate child node
				bestScore = Math.max(bestScore, score); // Update best score with maximum value
			}
		} else {
			// Minimizing player: find the minimum score among the children
			bestScore = Integer.MAX_VALUE;
			for (Arbre child : children) {
				int score = minimax(child, profondeur - 1, true); // Recursively evaluate child node
				bestScore = Math.min(bestScore, score); // Update best score with minimum value
			}
		}

		return bestScore; // Return the best score for the current node
	}*/
    /*public int minimax(Arbre noeud, int profondeur, boolean joueurMax) {
		boolean premierfois = false;
		if (profondeur == 0 || noeud.getNoeud().isEmpty()) {
			// Si on atteint la profondeur maximale ou si le nœud est une feuille de l'arbre
			// Évaluer la valeur du nœud et la retourner
			return noeud.getPoints();
		}

		if (premierfois ==true) {
			if (joueurMax) {
				int meilleurScore = Integer.MIN_VALUE;
				for (Arbre enfant : noeud.getNoeud()) {
					int score = minimax(enfant, profondeur - 1, false);
					meilleurScore = Math.max(meilleurScore, score);
				}
				return meilleurScore;
			} else {
				int meilleurScore = Integer.MAX_VALUE;
				for (Arbre enfant : noeud.getNoeud()) {
					int score = minimax(enfant, profondeur - 1, true);
					meilleurScore = Math.min(meilleurScore, score);
				}
				return meilleurScore;
			}
		}
		if (premierfois == false) {
			if (joueurMax) {
				int meilleurScore = Integer.MIN_VALUE;
				for (Arbre enfant : noeud.getNoeud()) {
					int score = minimax(enfant, profondeur - 1, false);
					meilleurScore = Math.max(meilleurScore, score);
				}
				return meilleurScore;
			} else {
				int meilleurScore = Integer.MAX_VALUE;
				for (Arbre enfant : noeud.getNoeud()) {
					int score = minimax(enfant, profondeur - 1, true);
					meilleurScore = Math.min(meilleurScore, score);
				}
				return meilleurScore;
			}
			premierfois=true;
		}
		return profondeur;//------------
	}*/
	public Arbre getRacine2(int nb) {
		Arbre a=this;
		for(int i=0;i<nb;i++){
			a=a.getRacine2(i);
		}
		return a;
	}

	public void Mettre(Arbre b,boolean minmax,int profondeurmax,int debut/*,boolean first*/) {

		if(debut==profondeurmax){
			return;
		}

		//Arbre o=new Arbre();
		//int indice = 0;
		//if(first==true) {
		if (minmax == true) {
			int indice = 0;
			for (int y = 0; y < b.getDeepestNodes().size(); y++) {//mettre boolean first pb bcl
				indice = b.getDeepestNodes().get(y).getRacine().getNoeud().get(0).getPoints();
				for (int i = 0; i < b.getDeepestNodes().get(y).getRacine().getNoeud().size(); i++) {

					//for (int y = 0; y < b.getDeepestNodes().get(0).getRacine().getNoeud().size(); y++ ) {
					if (indice < b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints()) {

						indice = b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints();

					}
					//}
				}

				b.getDeepestNodes().get(y).getRacine().setPoints(indice);
				minmax=false;
				Mettre(b.getDeepestNodes().get(y).getRacine2(debut),minmax,profondeurmax,debut+1);
			}
		} else {
			int indice = 0;
			for (int y = 0; y < b.getDeepestNodes().size(); y++) {
				indice = b.getDeepestNodes().get(y).getRacine().getNoeud().get(0).getPoints();
				for (int i = 0; i < b.getDeepestNodes().get(y).getRacine().getNoeud().size(); i++) {

					//for (int y = 0; y < b.getDeepestNodes().get(0).getRacine().getNoeud().size(); y++ ) {
					if (indice > b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints()) {
						indice = b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints();
					}
					//}
				}

				b.getDeepestNodes().get(y).getRacine().setPoints(indice);
				minmax=true;
				Mettre(b.getDeepestNodes().get(y).getRacine2(debut),minmax,profondeurmax,debut+1);
			}
		}

		//Mettre();
        /*}else{
			if (minmax == true) {
				for (int y = 0; y < b.getDeepestNodes().size(); y++) {
					for (int i = 0; i < b.getDeepestNodes().get(y).getRacine().getNoeud().size(); i++) {
						indice = b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints();
						//for (int y = 0; y < b.getDeepestNodes().get(0).getRacine().getNoeud().size(); y++ ) {
						if (indice < b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints()) {
							indice = b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints();
						}
						//}
					}

					b.getDeepestNodes().get(y).getRacine().setPoints(indice);
				}
			} else {
				for (int y = 0; y < b.getDeepestNodes().size(); y++) {
					for (int i = 0; i < b.getDeepestNodes().get(y).getRacine().getNoeud().size(); i++) {
						indice = b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints();
						//for (int y = 0; y < b.getDeepestNodes().get(0).getRacine().getNoeud().size(); y++ ) {
						if (indice < b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints()) {
							indice = b.getDeepestNodes().get(y).getRacine().getNoeud().get(i).getPoints();
						}
						//}
					}

					b.getDeepestNodes().get(y).getRacine().setPoints(indice);
				}
			}
		}
		first=false;
*/
	}


	public int minimax3(Arbre noeud, int profondeur, boolean joueurMax) {
		if (profondeur <= 1 /*|| noeud.getNoeud().isEmpty()*/) {
			// Si on atteint la profondeur maximale ou si le nœud est une feuille de l'arbre
			// Évaluer la valeur du nœud et la retourner
			//System.out.println(noeud.getPoints());
			return noeud.getPoints();
		}
		//ArrayList<Arbre> children = noeud.getNoeud();
		if (joueurMax) {
			int meilleurScore = Integer.MIN_VALUE;

			for (Arbre enfant : noeud.getNoeud()) {
				int score = minimax3(enfant, profondeur - 1, false);
				meilleurScore = Math.max(meilleurScore, score);
			}
			return meilleurScore;
		} else {
			int meilleurScore = Integer.MAX_VALUE;
			for (Arbre enfant : noeud.getNoeud()) {
				int score = minimax3(enfant, profondeur - 1, true);
				meilleurScore = Math.min(meilleurScore, score);
			}
			return meilleurScore;
		}
	}

	public String meilleurCoup(Arbre racine, int profondeur, boolean joueurMax) {
		int meilleurScore = Integer.MIN_VALUE;
		String meilleurCoup = null;
		for (Arbre enfant : racine.getNoeud()) {
			int score = minimax3(enfant, profondeur - 1, joueurMax);
			System.out.println(score+" "+meilleurScore);
			System.out.println(enfant.getDeplacement());
			if (score > meilleurScore) {
				meilleurScore = score;
				meilleurCoup = enfant.getDeplacement();
			}
		}
		return meilleurCoup;
	}

	public void setPoints(int points) {
		Points = points;
	}

    /*public void initializePoints(Arbre node) {
		if (node == null) {
			return; // Base case: if node is null, return
		}

		ArrayList<Arbre> children = node.getNoeud(); // Get children of the current node

		// If node is a leaf node (i.e., has no children), initialize points
		if (children.isEmpty()) {
			node.setPoints(node.getPoints()); // Set points for the leaf node
		} else {
			// If node is not a leaf node, initialize points for its children recursively
			for (Arbre child : children) {
				initializePoints(child); // Recursively initialize points for the child node
			}

			// Set points for the non-leaf node based on the points of its children
			int points = 0;
			for (Arbre child : children) {
				//points += child.getPoints(); // Accumulate points of all children
				points= child.
			}
			node.setPoints(points); // Set points for the current node
		}
	}*/

	public boolean oui(){
		for (int i =0;i<getDeepestNodes().size();i++){
			if(getDeepestNodes().get(i).getPoints()<1){
				return false;
			}
		}
		return true;
	}

	public int getPoints() {
		return Points;
	}

	private void RecursivePoints(ArrayList<Arbre> a,int taille) {
		//System.out.println("lol");

		if(taille%2==0){
			//System.out.println("1111111111111");
			for (int m=0;m<a.size();m++) {
				//System.out.println(a.get(m).getPoints());
				int min=Integer.MIN_VALUE;
				for (int n=0;n<a.get(m).getNoeud().size();n++){
					if(min>a.get(m).getNoeud().get(n).Points) {
						min=a.get(m).getNoeud().get(n).Points;
					}
				}
				a.get(m).getRacine().Points=min;
			}
		}else if(taille%2==1){
			//System.out.println("00000000000000");
			for (int m=0;m<a.size();m++) {
				int max=Integer.MAX_VALUE;
				//System.out.println(a.get(m).getPoints());
				for (int n=0;n<a.get(m).getNoeud().size();n++){
					if(max<a.get(m).getNoeud().get(n).Points) {
						max=a.get(m).getNoeud().get(n).Points;
					}
				}

				a.get(m).getRacine().Points=max;
			}
		}
	}

	public void depart(){
		if(this.getRacine().getDeplacement()==null){
			System.out.print(this.getDeplacement().charAt(0)+""+this.getDeplacement().charAt(1));
		}else{
			this.getRacine().depart();
		}
	}

	public void LesCoups(ArrayList<String> coups){
		if(this.getRacine()!=null){
			coups.add(this.deplacement);
			this.getRacine().LesCoups(coups);
		}else{
			return;
		}
	}

	public ArrayList<Arbre> getDeepestNodes() {
		ArrayList<Arbre> deepestNodes = new ArrayList<Arbre>();
		maxDepth[0] = 0;
		getDeepestNodes(this, 1, maxDepth, deepestNodes);
		return deepestNodes;
	}

	private void getDeepestNodes(Arbre r, int depth, int[] maxDepth, ArrayList<Arbre> deepestNodes) {
		if (r == null) {
			return;
		}
		if (depth > maxDepth[0]) {
			deepestNodes.clear();
			deepestNodes.add(r);
			maxDepth[0] = depth;
		} else if (depth == maxDepth[0]) {
			deepestNodes.add(r);
		}
		for (Arbre child : r.getNoeud()) {
			getDeepestNodes(child, depth + 1, maxDepth, deepestNodes);
		}
	}


	private void creer() {

		if (partie.getJoueur() == 1) {
			for (int i = 0; i < partie.getBlanches().size(); i++) {

				if (partie.getBlanches().get(i).getClass() == Pion.class) {
					int colonneSrc = partie.getBlanches().get(i).getColonne();
					int ligneSrc = partie.getBlanches().get(i).getLigne();

					int colonneDest = colonneSrc + 1;
					int ligneDest = ligneSrc + 1;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {

						Damier h = new Damier(partie);
						h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						h.LeTourDuJoueur();
						noeud.add(new Arbre(h,this));

					}

					colonneDest = colonneSrc + 1;
					ligneDest = ligneSrc - 1;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						h.LeTourDuJoueur();
						noeud.add(new Arbre(h,this));

					}

					colonneDest = colonneSrc - 1;
					ligneDest = ligneSrc - 1;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						h.LeTourDuJoueur();
						noeud.add(new Arbre(h,this));
					}

					colonneDest = colonneSrc - 1;
					ligneDest = ligneSrc + 1;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						h.LeTourDuJoueur();
						noeud.add(new Arbre(h,this));
					}
				}

				if (partie.getBlanches().get(i).getClass() == Dame.class) {
					int colonneSrc = partie.getBlanches().get(i).getColonne();
					int ligneSrc = partie.getBlanches().get(i).getLigne();

					for (int x = 1; x < 10; x++) {

						int colonneDest = colonneSrc - x;
						int ligneDest = ligneSrc + x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
							h.LeTourDuJoueur();
							noeud.add(new Arbre(h,this));
						}

						colonneDest = colonneSrc + x;
						ligneDest = ligneSrc - x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
							h.LeTourDuJoueur();
							noeud.add(new Arbre(h,this));
						}

						colonneDest = colonneSrc + x;
						ligneDest = ligneSrc + x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
							h.LeTourDuJoueur();
							noeud.add(new Arbre(h,this));
						}

						colonneDest = colonneSrc - x;
						ligneDest = ligneSrc - x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							h.getBlanches().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
							h.LeTourDuJoueur();
							noeud.add(new Arbre(h,this));
						}
					}
				}
			}
		}
		if (partie.getJoueur() == 2) {
			for (int i = 0; i < partie.getNoires().size(); i++) {

				if (partie.getNoires().get(i).getClass() == Pion.class) {
					int colonneSrc = partie.getNoires().get(i).getColonne();
					int ligneSrc = partie.getNoires().get(i).getLigne();

					int colonneDest = colonneSrc + 1;
					int ligneDest = ligneSrc + 1;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {

						Damier h = new Damier(partie);
						h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						h.LeTourDuJoueur();
						noeud.add(new Arbre(h,this));
					}

					colonneDest = colonneSrc + 1;
					ligneDest = ligneSrc - 1;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						h.LeTourDuJoueur();
						noeud.add(new Arbre(h,this));

					}

					colonneDest = colonneSrc - 1;
					ligneDest = ligneSrc - 1;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						h.LeTourDuJoueur();
						noeud.add(new Arbre(h,this));
					}

					colonneDest = colonneSrc - 1;
					ligneDest = ligneSrc + 1;

					if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
						Damier h = new Damier(partie);
						h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
						h.LeTourDuJoueur();
						noeud.add(new Arbre(h,this));
					}
				}

				if (partie.getNoires().get(i).getClass() == Dame.class) {
					int colonneSrc = partie.getNoires().get(i).getColonne();
					int ligneSrc = partie.getNoires().get(i).getLigne();

					for (int x = 1; x < 10; x++) {

						int colonneDest = colonneSrc - x;
						int ligneDest = ligneSrc + x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
							h.LeTourDuJoueur();
							noeud.add(new Arbre(h,this));
						}

						colonneDest = colonneSrc + x;
						ligneDest = ligneSrc - x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
							h.LeTourDuJoueur();
							noeud.add(new Arbre(h,this));
						}

						colonneDest = colonneSrc + x;
						ligneDest = ligneSrc + x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
							h.LeTourDuJoueur();
							noeud.add(new Arbre(h,this));
						}

						colonneDest = colonneSrc - x;
						ligneDest = ligneSrc - x;

						if (partie.estJouable(colonneSrc, ligneSrc, colonneDest, ligneDest) == true) {
							Damier h = new Damier(partie);
							h.getNoires().get(i).deplacerPieceIA(colonneDest, ligneDest, h);
							h.LeTourDuJoueur();
							noeud.add(new Arbre(h,this));
						}
					}
				}
			}
		}
	}
}
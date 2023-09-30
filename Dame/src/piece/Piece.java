package piece;

import plateau.Damier;

public abstract class Piece {
	private int colonne, ligne;
	private char Nom;

	/**
	 * Initialise une piece
	 * @param colonne la colonne de la piece
	 * @param ligne la colonne de la piece
	 * @param Nom le nom de la piece
	 */
	public Piece(int colonne, int ligne, char Nom) 
	{
		this.colonne = colonne;
		this.ligne = ligne;
		this.Nom = Nom;
	}

	/**
	 * getter colonne
	 * @return colonne de la piece
	 */
	public int getColonne()
	{
		return colonne;
	}
	
	/**
	 * getter ligne
	 * @return ligne de la piece
	 */
	public int getLigne()
	{
		return ligne;
	}
	
	/**
	 *  getter nom
	 * @return nom de la piece
	 */
	public char getNom()
	{
		return Nom;
	}
	
	/**
	 * Si il y a une piece a la colonne et ligne donner
	 * @param colonne la colonne a verifier
	 * @param ligne la ligne a verifier
	 * @return true si il y a une piece a la ligne donner
	 */
	
	public boolean occupe(int colonne, int ligne) 
	{
		return this.colonne == colonne && this.ligne == ligne;
	}
	
	/**
	 * deplacer la piece c'est a dire changer sa colonne et sa ligne
	 * @param colonne de la piece
	 * @param ligne de la piece
	 */
	public void deplacer(int colonne, int ligne) {
		this.colonne = colonne;
		this.ligne = ligne;
	}
	/**
	 * Si c'est un piece qui peut etre mit en echec
	 * @return false 
	 */
	public boolean craintEchec(){
		return false;
	}
	
	/**
	 * Si la piece peut se deplacer vers la ligne et colonne indiquer en parametre 
	 * @param colonne oe se deplacer
	 * @param ligne oe se deplacer
	 * @param e Echiquier 
	 * @return true si c'est possible de se deplacer sinon false
	 */
	public abstract boolean peutAllerEn(int colonne, int ligne, Damier d);
	public abstract void deplacerPiece(int colonne, int ligne, Damier d);
	public abstract void deplacerPieceIA(int colonne, int ligne, Damier d);
}

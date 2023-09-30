package piece;

import plateau.Damier;

public class Dame extends Piece {
	/**
	 * Initialise la piece Dame
	 * @param colonne de la Dame
	 * @param ligne de la Dame
	 * @param Nom de la Dame
	 */
	
	private static int cpt = 0;
	private static int colonneAdverse=0;
	private static int ligneAdverse=0;

	public Dame(int colonne, int ligne, char Nom) 
	{
		super(colonne, ligne, Nom);
	}
	public int getCpt() {
		return cpt;
	}
	/**
	 * Si la piece peut se deplacer vers la ligne et colonne indiquer en parametre 
	 * @param colonne ou se deplacer
	 * @param ligne ou se d�placer
	 * @return true si c'est possible de se deplacer sinon false
	 */
	@Override
	public boolean peutAllerEn(int colonne, int ligne, Damier d) {
		
		cpt=0;
		colonneAdverse=0;
		ligneAdverse=0;
		
		if (Math.abs(getColonne() - colonne) != Math.abs(getLigne() - ligne)){
			System.out.println("Mouvement impossible ");
			return false;
		}
			
		//Blanc
		if(d.getJoueur()==1) {
			d.setVideTableau(getLigne(), getColonne());
			if(d.estLibre(colonne, ligne)==true) {
					boolean positifC;
					if((colonne-getColonne())>0) {
						positifC=true;
					}else {
						positifC=false;
					}
					boolean positifL;
					if((ligne-getLigne())>0) {
						positifL=true;
					}else {
						positifL=false;
					}

					for(int y=1;y<Math.abs(colonne-getColonne());y++) {
						if(positifC==true) {
							if(positifL==true) {
								if(d.Allier(getColonne()+y,getLigne()+y)==1) {
									cpt=999;
								}
								if(d.Allier(getColonne()+y,getLigne()+y)==2) {
			
									colonneAdverse=getColonne()+y;
									ligneAdverse=getLigne()+y;
									cpt++;
								}
							}
							if(positifL==false) {
								if(d.Allier(getColonne()+y,getLigne()-y)==1) {
									cpt=999;
								}
								if(d.Allier(getColonne()+y,getLigne()-y)==2) {
									colonneAdverse=getColonne()+y;
									ligneAdverse=getLigne()-y;
									cpt++;
								}
							}
						}
						if(positifC==false) {
							if(positifL==true) {
								if(d.Allier(getColonne()-y,getLigne()+y)==1){
									cpt=999;
								}
								if(d.Allier(getColonne()-y,getLigne()+y)==2){
									colonneAdverse=getColonne()-y;
									ligneAdverse=getLigne()+y;
									cpt++;	
								}
							}

							if(positifL==false) {
								if(d.Allier(getColonne()-y,getLigne()-y)==1){
									cpt=999;
								}
								if(d.Allier(getColonne()-y,getLigne()-y)==2){
									colonneAdverse=getColonne()-y;
									ligneAdverse=getLigne()-y;
									cpt++;
								}
							}
						}
					}
					System.out.println(cpt);
			}
		}
			
		
		//Noire	
		if(d.getJoueur()==2) {
			d.setVideTableau(getLigne(), getColonne());
			if(d.estLibre(colonne, ligne)==true) {
				boolean positifC;
				if((colonne-getColonne())>0) {
					positifC=true;
				}else {
					positifC=false;
				}
				boolean positifL;
				if((ligne-getLigne())>0) {
					positifL=true;
				}else {
					positifL=false;
				}

				for(int y=1;y<Math.abs(colonne-getColonne());y++) {
						
					if(positifC==true) {
						if(positifL==true) {
							if(d.Allier(getColonne()+y,getLigne()+y)==2) {
								cpt=999;
								return false;
							}
							if(d.Allier(getColonne()+y,getLigne()+y)==1) {
								
								colonneAdverse=getColonne()+y;
								ligneAdverse=getLigne()+y;
								cpt++;
							}
						}
						if(positifL==false) {
							if(d.Allier(getColonne()+y,getLigne()-y)==2) {
								cpt=999;
								return false;
							}
							if(d.Allier(getColonne()+y,getLigne()-y)==1) {
								colonneAdverse=getColonne()+y;
								ligneAdverse=getLigne()-y;
								cpt++;
							}
						}
					}
					if(positifC==false) {
						if(positifL==true) {
							if(d.Allier(getColonne()-y,getLigne()+y)==2){
								cpt=999;
								return false;
							}
							if(d.Allier(getColonne()-y,getLigne()+y)==1){
								colonneAdverse=getColonne()-y;
								ligneAdverse=getLigne()+y;
								cpt++;
							}
						}

						if(positifL==false) {
							if(d.Allier(getColonne()-y,getLigne()-y)==2){
								cpt=999;
								return false;
							}
							if(d.Allier(getColonne()-y,getLigne()-y)==1){
								colonneAdverse=getColonne()-y;
								ligneAdverse=getLigne()-y;
								cpt++;
							}
						}
					}
				}
				//System.out.println(cpt);
			}
			
			
		}
		
		if(cpt>1) {
			//System.out.println("Ne peut aller a cette destination");
			return false;
		}
		
		return true;
	}
	

	@Override
	public void deplacerPiece(int colonne, int ligne, Damier d) {
		
		if(d.getJoueur()==1) {

				if(cpt==0) {
					this.deplacer(colonne,ligne);

				}

				if(cpt==1) {
					for(int j=0;j<d.getNoires().size();++j){
						if(d.getNoires().get(j).getLigne()==ligneAdverse && d.getNoires().get(j).getColonne()==colonneAdverse){
							d.setVideTableau(ligneAdverse, colonneAdverse);
							d.getNoires().remove(j);

						}
					}

					this.deplacer(colonne,ligne);

				}
					
					d.mettreLesPieces();

		}
		if(d.getJoueur()==2) {

							if(cpt==0) {
		
								this.deplacer(colonne,ligne);

							}

							if(cpt==1) {
								for(int j=0;j<d.getBlanches().size();++j){
									if(d.getBlanches().get(j).getLigne()==ligneAdverse && d.getBlanches().get(j).getColonne()==colonneAdverse){
										d.setVideTableau(ligneAdverse, colonneAdverse);
										d.getBlanches().remove(j);
									}
								}
								this.deplacer(colonne,ligne);

							}

					d.mettreLesPieces();

		}

		d.LeTourDuJoueur();
	}

	@Override
	public void deplacerPieceIA(int colonne, int ligne, Damier d) {

		if(d.getJoueur()==1) {

			if(cpt==0) {
				this.deplacer(colonne,ligne);

			}
			if(cpt==1) {
				for(int j=0;j<d.getNoires().size();++j){

					if(d.getNoires().get(j).getLigne()==ligneAdverse && d.getNoires().get(j).getColonne()==colonneAdverse){
						d.setVideTableau(ligneAdverse, colonneAdverse);
						d.getNoires().remove(j);

					}
				}
				this.deplacer(colonne,ligne);

			}

			d.mettreLesPieces();

		}

		if(d.getJoueur()==2) {

			if(cpt==0) {

				this.deplacer(colonne,ligne);

			}

			if(cpt==1) {
				for(int j=0;j<d.getBlanches().size();++j){
					if(d.getBlanches().get(j).getLigne()==ligneAdverse && d.getBlanches().get(j).getColonne()==colonneAdverse){
						d.setVideTableau(ligneAdverse, colonneAdverse);
						d.getBlanches().remove(j);

					}
				}
				this.deplacer(colonne,ligne);

			}

			d.mettreLesPieces();

		}

	}

	
	
}

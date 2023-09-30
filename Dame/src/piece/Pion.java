package piece;

import plateau.Damier;

public class Pion extends Piece{

	public Pion(int colonne, int ligne, char Nom) {
		super(colonne, ligne, Nom);
	}

	@Override
	public boolean peutAllerEn(int colonne, int ligne, Damier d) {
		//Noire
		if(d.getJoueur()==2) {
			if(Math.abs(getLigne()-ligne)>2){
				return false;
			}
			if(Math.abs(getColonne()-colonne)>2){
				return false;
			}
			if (getColonne() + 1 == colonne && getLigne() + 1 == ligne) {

				return true;
			}
			
			if (getColonne() - 1 == colonne && getLigne() + 1 == ligne) {

				return true;
			}

			if(Math.abs(getLigne()-ligne)==2&&Math.abs(getColonne()-colonne)==2
					&& (d.getTableau((ligne+getLigne())/2, (colonne+getColonne())/2)=='b'
					||d.getTableau((ligne+getLigne())/2, (colonne+getColonne())/2)=='B')
			){
				return true;
			}
			
			
		}
		//Blanc
		if(d.getJoueur()==1) {
			if(Math.abs(getLigne()-ligne)>2){
				return false;
			}
			if(Math.abs(getColonne()-colonne)>2){
				return false;
			}

			if (getColonne() + 1 == colonne && getLigne() - 1 == ligne) {
				return true;
			}
			
			if (getColonne() - 1 == colonne && getLigne() - 1 == ligne ) {
				return true;
			}
			if(Math.abs(getLigne()-ligne)==2&&Math.abs(getColonne()-colonne)==2
			&& (d.getTableau((ligne+getLigne())/2, (colonne+getColonne())/2)=='n'
			||d.getTableau((ligne+getLigne())/2, (colonne+getColonne())/2)=='N')
			){
				return true;
			}


		}
		
		//System.out.println("mouvement impossible");
		return false;
	}

	@Override
	public void deplacerPiece(int colonne, int ligne, Damier d) {

		if(d.getJoueur()==2) {

                    d.setVideTableau(getLigne(),getColonne());
                    if((colonne+getColonne())%2==0) {
                    	
                            for(int j=0;j<d.getBlanches().size();++j){
                                if(d.getBlanches().get(j).getLigne()==((ligne+getLigne())/2) && d.getBlanches().get(j).getColonne()==((colonne+getColonne())/2) ){
                                    d.setVideTableau((ligne+getLigne())/2,(colonne+getColonne())/2);

                                    d.getBlanches().remove(j);
                                }
                            }

                            this.deplacer(colonne, ligne);

                    }else {


                        this.deplacer(colonne, ligne);
                    }
                    
                    if(ligne==9) {
                    	d.getNoires().remove(this);
                    	d.getNoires().add(new Dame(colonne, ligne, 'N'));

                    }
                    
                    d.mettreLesPieces();

        }
		if(d.getJoueur()==1) {

                    d.setVideTableau(getLigne(),getColonne());
                        
       
                    if((colonne+getColonne())%2==0) {
                    	
                            for(int j=0;j<d.getNoires().size();++j){
                                if(d.getNoires().get(j).getLigne()==((ligne+getLigne())/2) && d.getNoires().get(j).getColonne()==((colonne+getColonne())/2) ){
                                	d.setVideTableau((ligne+getLigne())/2,(colonne+getColonne())/2);
                                    d.getNoires().remove(j);
                                }
                            }

                            this.deplacer(colonne, ligne);

                    }else {
                        this.deplacer(colonne, ligne);

                    }
                    
                    if(ligne==0) {
                    	d.getBlanches().remove(this);
                    	d.getBlanches().add(new Dame(colonne, ligne, 'B'));
                    }
                    
                    d.mettreLesPieces();

                }

		d.LeTourDuJoueur();
	}
	
	@Override
	public void deplacerPieceIA(int colonne, int ligne, Damier d) {

		if(d.getJoueur()==2) {
                    d.setVideTableau(getLigne(),getColonne());
                    if((colonne+getColonne())%2==0) {
                    	
                            for(int j=0;j<d.getBlanches().size();++j){
                                if(d.getBlanches().get(j).getLigne()==((ligne+getLigne())/2) && d.getBlanches().get(j).getColonne()==((colonne+getColonne())/2) ){
                                    d.setVideTableau((ligne+getLigne())/2,(colonne+getColonne())/2);
                                    d.getBlanches().remove(j);
                                }
                            }

                        	this.deplacer(colonne,ligne);
                            
                            
                            
                    }else {
                       
                        this.deplacer(colonne,ligne);
                    }   
                    d.mettreLesPieces();

        }
		
		if(d.getJoueur()==1) {

                    d.setVideTableau(getLigne(),getColonne());
                        
       
                    if((colonne+getColonne())%2==0) {
                    	
                            for(int j=0;j<d.getNoires().size();++j){
                                if(d.getNoires().get(j).getLigne()==((ligne+getLigne())/2) && d.getNoires().get(j).getColonne()==((colonne+getColonne())/2) ){
                                	d.setVideTableau((ligne+getLigne())/2,(colonne+getColonne())/2);
                                    d.getNoires().remove(j);
                                }
                            }
                            
                            
                        	this.deplacer(colonne,ligne);
                            
                            
                            
                    }else {
                        this.deplacer(colonne,ligne);
                       
                    }
                    d.mettreLesPieces();

                }     

		
	}
	
	

}

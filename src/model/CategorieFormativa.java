package model;

import java.util.Optional;

public enum CategorieFormativa {
	
	DF("DF","Disciplina Fundamentala",1),
	DD("DD","Disciplina de domeniu",2),
	DS("DS","Disciplina de specialitate",3),
	DC("DC","Disciplina complementara",4);
	
	private String abreviere;
	private String numeCategorieFormativa;
	private int nrOrdine;
	
	/**
	 * @param abreviere
	 * @param numeCategorieFormativa
	 * @param nrOrdine
	 */
	private CategorieFormativa(String abreviere, String numeCategorieFormativa, int nrOrdine) {
		this.abreviere = abreviere;
		this.numeCategorieFormativa = numeCategorieFormativa;
		this.nrOrdine = nrOrdine;
	}
	
	
	
	/**
	 * @return the abreviere
	 */
	public String getAbreviere() {
		return abreviere;
	}



	/**
	 * @return the numeCategorieFormativa
	 */
	public String getNumeCategorieFormativa() {
		return numeCategorieFormativa;
	}



	/**
	 * @return the nrOrdine
	 */
	public int getNrOrdine() {
		return nrOrdine;
	}



	public final static Optional<CategorieFormativa> string2CategorieFormativa(String val) {
		
		Optional<CategorieFormativa> obj=Optional.empty();;
		for(int i=0;i<values().length;i++) {
				if (  val.equalsIgnoreCase(CategorieFormativa.values()[i].abreviere) ==true ) {
						obj=Optional.of(CategorieFormativa.values()[i]);
						return obj;
			    }
	   }
		return obj;
	}
	

}

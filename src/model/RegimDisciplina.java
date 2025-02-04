package model;

import java.util.Optional;

public enum RegimDisciplina {
	
	DI("DI","Disciplina Impusa",1),
	DO("DO","Disciplina Optionala",2),
	DF("DF","Disciplina Facultativa",3);
	
	private String abreviere;
	private String nume;
	private int nrOrdine;
	
	/**
	 * @param abreviere
	 * @param nume
	 * @param nrOrdine
	 */
	private RegimDisciplina(String abreviere, String nume, int nrOrdine) {
		this.abreviere = abreviere;
		this.nume = nume;
		this.nrOrdine = nrOrdine;
	}

	/**
	 * @return the abreviere
	 */
	public String getAbreviere() {
		return abreviere;
	}

	/**
	 * @return the nume
	 */
	public String getNume() {
		return nume;
	}

	/**
	 * @return the nrOrdine
	 */
	public int getNrOrdine() {
		return nrOrdine;
	}
	
	public final static Optional<RegimDisciplina> string2CategorieFormativa(String val) {
		
		Optional<RegimDisciplina> obj=Optional.empty();;
		for(int i=0;i<values().length;i++) {
				if (  val.equalsIgnoreCase(RegimDisciplina.values()[i].abreviere) ==true ) {
						obj=Optional.of(RegimDisciplina.values()[i]);
						return obj;
			    }
	   }
		return obj;
	}
	
	

}

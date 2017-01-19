package blackJack;

public class Carte {

	private Suita suita;
	private Valoare valCarte;
	
	
	public Carte(Suita suita ,Valoare valCarte){
		this.valCarte = valCarte;
		this.suita = suita;
	}
	

	
	public String toString(){
		return this.valCarte.toString()+" - "+ this.suita.toString();
	}

	public Valoare getValCarte() {
		return valCarte;
	}
		
	
	
}

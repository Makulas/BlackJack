package blackJack;

import java.util.ArrayList;
import java.util.Collections;

public class Pachet {
	
private ArrayList<Carte>carti;
	
	
	//constructors//
	public Pachet(){
		this.carti = new ArrayList<Carte>();
	}
	
	//methods//
	
	public void pachetDeCarti(){//generare carti//	
		for (Suita carteSuita : Suita.values()) {
			for (Valoare carteValoare : Valoare.values()) {
				this.carti.add(new Carte(carteSuita, carteValoare));
				
			}
		}
	}
	
	public void amestecaCartileDinPachet(){
		Collections.shuffle(carti);
	}
		
	public String toString(){
		String cartiInPachet = "";
		for( Carte oCarte:this.carti){	
		cartiInPachet += "\n "+ oCarte.toString();
		}
		return cartiInPachet;
	}
	public void removeCarte(int i){
		this.carti.remove(i);
	}
	public Carte getCarte(int i){
	      return	this.carti.get(i);
	}
	public void aduagaCarte(Carte adugaCarte){
		this.carti.add(adugaCarte);
	}
	public int marimePachet(){
		return this.carti.size();
	}
	
	//trage din pachet//
	public void trage(Pachet comingFrom){
		this.carti.add(comingFrom.getCarte(0));
		comingFrom.removeCarte(0);
		
	}
	public void umplePachetDinNou(Pachet pacNou){
		int marimePac = this.carti.size();
		
		for (int i = 0; i < marimePac; i++) {
			pacNou.aduagaCarte(this.getCarte(i));
		}
		for (int i = 0; i < marimePac; i++) {
			this.removeCarte(0);
			
		}
	}
	
	public int valoareCarte(){
		int valFinala =0;
		int As = 0;
		
		for (Carte oCarte : this.carti) {
			switch(oCarte.getValCarte()){
			case DOI:valFinala += 2;break;
			case TREI:valFinala += 3;break;
			case PATRU:valFinala += 4;break;
			case CINCI:valFinala += 5;break;
			case SASE:valFinala += 6;break;
			case SAPTE:valFinala += 7;break;
			case OPT:valFinala += 8;break;
			case NOUA:valFinala +=9;break;
			case ZECE:valFinala +=10;break;
			case VALET:valFinala +=10;break;
			case DAMA:valFinala += 10;break;
			case REGE:valFinala += 10;break;
			case AS: As += 1;break;
			
			}
		}
		for (int i = 0; i < As; i++) {
			if (valFinala>10) {
				valFinala += 1;
			}else{
				valFinala += 11;
			}
		}
		return valFinala;
	}

	
	
	

}

package it.luigibennardis.boot.demo.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntityPrenotazioneEsame {
	
	@Id
	@GeneratedValue
	private Long id;
	private String codiceprenotazione;
	private String codiceEsame;
	private String matricolaStudente;
		
	public EntityPrenotazioneEsame(){}
	
	public EntityPrenotazioneEsame(String codPrenotazione, String codEsame, String matrStudente){
		
		
	}

	public String getCodiceprenotazione() {
		return codiceprenotazione;
	}

	public String getCodiceEsame() {
		return codiceEsame;
	}

	public String getMatricolaStudente() {
		return matricolaStudente;
	}
	
	
	
}

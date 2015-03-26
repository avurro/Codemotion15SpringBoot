package it.luigibennardis.boot.demo.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntityEsame {
	
	@Id
	@GeneratedValue
	private Long id;
	private String codice;
	private String descrizione;
		
	public EntityEsame(){}
	
	public EntityEsame(String codice, String Descrizione){
				
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	
	
	
	
}

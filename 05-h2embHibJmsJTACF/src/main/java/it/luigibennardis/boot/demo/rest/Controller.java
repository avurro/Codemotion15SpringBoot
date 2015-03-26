package it.luigibennardis.boot.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	 @Autowired
	 private ApplicationContext context;
	 
	// http://localhost:8080/prenotaEsame?matricola=000001&esame=abcd0001
	// http://localhost:8080/prenotaEsame?matricola=000001&esame=ROLLBACK_SIMULATO
		
	@RequestMapping("/prenotaEsame")
	public String prenotaEsame(
			@RequestParam(value="matricola") String matricola,
			@RequestParam(value="esame") String esame
			)
	{
		String esitoPrenotazione;
		
		String codPrenotazione;
		//LOGICA APPLICATIVA DI VERIFICA MATRICOLA STUDENTE (TASSE/PROPEDEUTICITA', ECC)
		
		//LOGICA APPLICATIVA DI DETERMINAZIONE DEL CODICE DI PRENOTAZIONE
		codPrenotazione= "PRE00001";
		
		//LOGICA APPLICATIVA DI PERSISTENZA SUL DATABASE
		
		ServicePrenotazioneEsame  service = context.getBean(ServicePrenotazioneEsame.class);
   	 	
   	 	
		try {
			//INVOCA METODO ESPOSTO DAL SERVICE
			service.registraPrenotazione(codPrenotazione, esame, matricola);
		
			esitoPrenotazione = "ESEGUITA";
			
		}
		catch (Exception ex) {
			esitoPrenotazione = "NON ESEGUITA";
			System.out.println(ex.getMessage());
			
		} 
			
			return "PRENOTAZIONE " + esitoPrenotazione + " : " +
					" <BR> codice esame: " + esame + 
					" <BR> codice prenotazione: " + codPrenotazione +
					" <BR> matricola studente: " + matricola;
		 
				 
	}
	
	// http://localhost:8080/prenotazioniFatte
		
	@RequestMapping("/prenotazioniFatte")
	public String prenotazioniFatte()
	{	
		
		IRepositoryPrenotazioneEsame repository = context.getBean(IRepositoryPrenotazioneEsame.class);
		
	
		return "PRENOTAZIONI PRESENTI IN BASE DATI: " +
				" <BR> " +  repository.count() +
				" <BR> " + repository.findAll(); 
				 
	}
	
			
	
}

package it.luigibennardis.boot.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller @ResponseBody
public class Controller {

	// http://localhost:8080/prenotaEsame?matricola=000001&esame=abcd0001
	
	
	@RequestMapping("/prenotaEsame")
	public String servletTest(
			@RequestParam(value="matricola") String matricola,
			@RequestParam(value="esame") String esame
			)
	{
		
		
		//LOGICA APPLICATIVA DI VERIFICA MATRICOLA STUDENTE (TASSE/PROPEDEUTICITA', ECC)
		
		//LOGICA APPLICATIVA DI DETERMINAZIONE DEL CODICE DI PRENOTAZIONE
				
		//LOGICA APPLICATIVA DI PERSISTENZA SUL DATABASE
		
		
		return "<HTML><BODY><BR>Servlet avviata: <BR> codice esame: " + esame + " <BR> matricola studente: " + matricola +"<BODY><HTML>";
	}
	
	
	
}

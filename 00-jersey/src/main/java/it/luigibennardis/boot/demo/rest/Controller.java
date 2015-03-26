package it.luigibennardis.boot.demo.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

/* http://localhost:8080/prenotaEsameTest/infoPrenota?matricolaStudente=000111&codiceEsame=ABC0001 */

@Named
@Path("/prenotaEsameTest")
@Produces(MediaType.TEXT_HTML)
public class Controller {

	@Inject
	private ServicePrenotazioneEsame service;

	  @GET
	  @Path("/infoPrenota")
	  public Response  get(@QueryParam("codiceEsame") String codiceEsame,
			  @QueryParam("matricolaStudente") String matricolaStudente) {
		  
		  String esitoPrenotazione;
		  String output;
		  String codPrenotazione;
		  
		  //LOGICA APPLICATIVA DI VERIFICA MATRICOLA STUDENTE (TASSE/PROPEDEUTICITA', ECC)
			
		  //LOGICA APPLICATIVA DI DETERMINAZIONE DEL CODICE DI PRENOTAZIONE
		  codPrenotazione= "PRE00001";
						
		  try {
			  service.registraPrenotazione("aa00099",codiceEsame, matricolaStudente);
			  esitoPrenotazione = "ESEGUITA";
		  }
		  catch (Exception ex) {
			  esitoPrenotazione = "NON ESEGUITA";
			  System.out.println(ex.getMessage());
		  } 
		  
		  output = "PRENOTAZIONE " + esitoPrenotazione + " : " +
					" <BR> codice esame: " + codiceEsame + 
					" <BR> codice prenotazione: " + codPrenotazione +
					" <BR> matricola studente: " + matricolaStudente;
		 
		  return Response.status(200).entity(output).build();
	  }
	  
	  @GET
	  @Path("/prenotazioniFatte")
	  public Response  get() {
		  
		  String output;
		  		  
		  output = "PRENOTAZIONI PRESENTI IN BASE DATI: " +
			" <BR> " + service.numeroPrenotazioniPresenti() +
			" <BR> " + service.findAll();
		  
		  return Response.status(200).entity(output).build();
	  }

    
    
}
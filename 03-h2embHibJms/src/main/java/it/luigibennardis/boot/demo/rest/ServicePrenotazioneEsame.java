package it.luigibennardis.boot.demo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service
public class ServicePrenotazioneEsame {

	private final JmsTemplate jmsTemplate;
	 
	private final IRepositoryPrenotazioneEsame prenEsameRepo;

	
	@Autowired
	public ServicePrenotazioneEsame(IRepositoryPrenotazioneEsame localRepo,JmsTemplate jmsTemplate) {
		this.prenEsameRepo = localRepo;
		this.jmsTemplate = jmsTemplate;
	}

	public void registraPrenotazione(String codPrenotazione, String codEsame, String matricolaStud) {
		
		//PERSISTENZA DATI SUL DATABASE
		this.prenEsameRepo.save(new EntityPrenotazioneEsame(codPrenotazione, codEsame, matricolaStud));
		
		//PUBBLICAZIONE MESSAGGIO SULA CODA
		this.jmsTemplate.convertAndSend("codaPrenotazioneEsami", codPrenotazione + "|" +  codEsame + "|" + matricolaStud);
		
	}
	
}
package it.luigibennardis.boot.demo.rest;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;


@Service
@Transactional
public class ServicePrenotazioneEsame {

	private final JmsTemplate jmsTemplate;
	 
	private final IRepositoryPrenotazioneEsame prenEsameRepo;

	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
		public ServicePrenotazioneEsame(IRepositoryPrenotazioneEsame localRepo,JmsTemplate jmsTemplate) {
		this.prenEsameRepo = localRepo;
		this.jmsTemplate = jmsTemplate;
	}

	public void registraPrenotazione(String codPrenotazione, String codEsame, String matricolaStud) {
		
		//PERSISTENZA DATI SUL DATABASE
		this.prenEsameRepo.save(new EntityPrenotazioneEsame(codPrenotazione, codEsame, matricolaStud));
		
		//PUBBLICAZIONE MESSAGGIO SULA CODA
		this.jmsTemplate.convertAndSend("codaPrenotazioneEsami","PROGRESSIVO MESSAGGIO IN CODA "+ counter.incrementAndGet( )+ "|" +  codPrenotazione + "|" +  codEsame + "|" + matricolaStud);
				
		
		if (codEsame.equals("ROLLBACK_SIMULATO")) {
			
			//ECCEZIONE->ROLLBACK TRANSAZIONE
			throw new RuntimeException("SIMULAZIONE DI ROLLBACK ULTIMA TRANSAZIONE");
		}
		
	}
}
package it.luigibennardis.boot.demo.rest;


import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.jms.core.JmsTemplate;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;


@Named
@Transactional
public   class ServicePrenotazioneEsame {
	@Inject
	private JmsTemplate jmsTemplate;
	
	@PersistenceContext
    private EntityManager entityManager;

	private final AtomicLong counter = new AtomicLong();
		
	public void registraPrenotazione(String codPrenotazione, String codEsame, String matricolaStud) {
		
		//PERSISTENZA DATI SUL DATABASE
		this.entityManager.persist(new EntityPrenotazioneEsame(codPrenotazione, codEsame, matricolaStud));
		
		//PUBBLICAZIONE MESSAGGIO SULA CODA
		this.jmsTemplate.convertAndSend("codaPrenotazioneEsami","PROGRESSIVO MESSAGGIO IN CODA "+ counter.incrementAndGet( )+ "|" +  codPrenotazione + "|" +  codEsame + "|" + matricolaStud);
			
		if (codEsame.equals("ROLLBACK_SIMULATO")) {
			
			//ECCEZIONE->ROLLBACK TRANSAZIONE
			throw new RuntimeException("SIMULAZIONE DI ROLLBACK ULTIMA TRANSAZIONE");
		}
	}	
	
	public Collection<EntityPrenotazioneEsame> findAll() {
	
		String query = "select g from " + EntityPrenotazioneEsame.class.getName() + " g";
	
		return this.entityManager
            .createQuery(query, EntityPrenotazioneEsame.class)
            .getResultList();
    }
	
	public String numeroPrenotazioniPresenti() {
		String query = "select count(g) from " + EntityPrenotazioneEsame.class.getName() + " g";
		
		Object count = this.entityManager
                .createQuery(query).getSingleResult();
		
		return "Occorrenze in base dati: " + ((Number)count).toString();
         
	}
    
	
}
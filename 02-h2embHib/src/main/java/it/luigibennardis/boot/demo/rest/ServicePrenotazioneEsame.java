package it.luigibennardis.boot.demo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicePrenotazioneEsame {

	 
	private final IRepositoryPrenotazioneEsame prenEsameRepo;

	
	@Autowired //COSTRUTTORE
	public ServicePrenotazioneEsame(IRepositoryPrenotazioneEsame localRepo) {
		this.prenEsameRepo = localRepo;
	}

	public void registraPrenotazione(String codPrenotazione, String codEsame, String matricolaStud) {
		
		this.prenEsameRepo.save(new EntityPrenotazioneEsame(codPrenotazione, codEsame, matricolaStud));
		
	}
}
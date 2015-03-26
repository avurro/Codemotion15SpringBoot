package it.luigibennardis.boot.demo.rest;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnitTestCaricaTipologiche {

	private final IRepositoryEsame esameRepo;
	
	@Autowired  
	public UnitTestCaricaTipologiche(IRepositoryEsame localRepo) {
		this.esameRepo = localRepo;
	}
    @PostConstruct //JSR 250 ANNOTAZIONE (PARTE DELLA SPECIFICA JAVA EE 5) ESEMPIO DEGLI HOOK DEL CICLO DI VITA.
    public void inizializzaBaseDati() throws Exception {
    	System.out.println("INIZIALIZZAZIONE TABELLA TIPOLOGICA ESAME");
        
    	this.esameRepo.save(new EntityEsame("00001", "Ingegneria Civile"));
    	this.esameRepo.save(new EntityEsame("00002", "Ingegneria Elettronica"));
    	this.esameRepo.save(new EntityEsame("00003", "Ingegneria Meccanica"));
    	this.esameRepo.save(new EntityEsame("00004", "Ingegneria Informatica"));
        
    	System.out.println("TABELLA TIPOLOGICA ESAME-> INIZIALIZZAZIONE COMPLETA RECORD: " + esameRepo.count());
        
    }
    
}

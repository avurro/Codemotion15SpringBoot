package it.luigibennardis.boot.demo.rest;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CodaPrenotazioneEsame {

	@JmsListener(destination = "codaPrenotazioneEsami")
	public void onMessage(String content) {
		System.out.println("MESSAGGIO PUBBLICATO SULLA CODA codaPrenotazioneEsami :" + content);
	
	}
 
}

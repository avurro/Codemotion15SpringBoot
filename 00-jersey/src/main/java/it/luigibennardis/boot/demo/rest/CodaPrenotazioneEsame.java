package it.luigibennardis.boot.demo.rest;

import javax.inject.Named;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Named
public class CodaPrenotazioneEsame {

	@JmsListener(destination = "codaPrenotazioneEsami")
	public void onMessage(String content) {
		System.out.println("MESSAGGIO PUBBLICATO SULLA CODA codaPrenotazioneEsami :" + content);
	
	}
 
}

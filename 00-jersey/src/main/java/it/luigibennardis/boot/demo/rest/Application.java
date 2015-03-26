package it.luigibennardis.boot.demo.rest;
 
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.inject.Named;

@SpringBootApplication
public class Application {

    @Named
    public static class JerseyConfig extends ResourceConfig {

        public JerseyConfig() {
            this.register(Controller.class);
            //this.register(JacksonFeature.class);
        }
    }
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
}
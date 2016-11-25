package eMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import eMarket.domain.Store;

@SpringBootApplication
public class EMarketApp extends WebMvcConfigurerAdapter {

	private static Store store = new Store();
	
    public static void main(String[] args) {
        SpringApplication.run(EMarketApp.class, args);
    }

	public static Store getStore() {
		return store;
	}

}

package eMarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eMarket.domain.Store;
import eMarket.repository.StoreRepository;

@SpringBootApplication
public class EMarketApp implements CommandLineRunner { 

	@Autowired 
	StoreRepository repo;

	public static final String STORE_NAME = "MyEMarket";
	
    public static void main(String[] args) {
        SpringApplication.run(EMarketApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
		// creation of instance according to the object diagram in Fig. 2
		
		if (repo.findByName(STORE_NAME).size() == 0) {
			Store store = new Store(STORE_NAME);
			repo.save(store);
		}
		
    }   

}

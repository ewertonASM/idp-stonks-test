package br.com.inatel.stonks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.inatel.stonks.client.BeanInitMethodImpl;
import br.com.inatel.stonks.dto.NotificationDTO;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@EnableCaching
@Log4j2
public class StockManagerApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(StockManagerApplication.class, args);
	}

	@Bean(initMethod="runAfterObjectCreated")
    public BeanInitMethodImpl getFunnyBean() {
        return new BeanInitMethodImpl();
    }

}

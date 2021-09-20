package br.com.inatel.stonks.client;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.inatel.stonks.dto.NotificationDTO;
import br.com.inatel.stonks.dto.StockDTO;
import br.com.inatel.stonks.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StockClient {

    
    
    public static StockDTO createStock(StockDTO stockDTO){
        
        return new RestTemplate().postForObject("http://localhost:8080/stock", stockDTO, StockDTO.class);
        
    }

    @Cacheable(value = "stockList")
    public static ResponseEntity<List<StockDTO>> listStocks(){

        ResponseEntity<List<StockDTO>> exchange = new RestTemplate().exchange("http://localhost:8080/stock", HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<StockDTO>>(){});
        log.info(exchange.getBody());

        return exchange;

    }

    public static StockDTO checkStock(String id){
        
        StockDTO stockDTO = new RestTemplate().getForObject("http://localhost:8080/stock/{id}", StockDTO.class, id);

        if(stockDTO == null){
            throw new BadRequestException("stock not found");
        }

        return stockDTO;

    }

    public static NotificationDTO registerApplication(NotificationDTO notificationDTO){

        return new RestTemplate().postForObject("http://localhost:8080/stock", notificationDTO, NotificationDTO.class);
         
    }

}

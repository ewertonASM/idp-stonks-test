package br.com.inatel.stonks.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.inatel.stonks.exception.BadRequestException;
import br.com.inatel.stonks.model.Stock;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StockClient {

    public static ResponseEntity<List<Stock>> stockList(){

        ResponseEntity<List<Stock>> exchange = new RestTemplate().exchange("http://localhost:8080/stock", HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<Stock>>(){});
        log.info(exchange.getBody());

        return exchange;

    }

    public static Stock checkStock(String id){
        
        Stock object = new RestTemplate().getForObject("http://localhost:8080/stock/{id}", Stock.class, id);

        if(object == null){
            throw new BadRequestException("stock not found");
        }

        return object;

    }


}

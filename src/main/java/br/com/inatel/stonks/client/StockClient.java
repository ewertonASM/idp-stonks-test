package br.com.inatel.stonks.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.inatel.stonks.dto.StockDTO;
import br.com.inatel.stonks.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StockClient {

    // public static ResponseEntity<List<Stock>> stockList(){

    //     ResponseEntity<List<Stock>> exchange = new RestTemplate().exchange("http://localhost:8080/stock", HttpMethod.GET, null,
    //                         new ParameterizedTypeReference<List<Stock>>(){});
    //     log.info(exchange.getBody());

    //     return exchange;

    // }

    public static ResponseEntity<List<StockDTO>> stockList(){

        ResponseEntity<List<StockDTO>> exchange = new RestTemplate().exchange("http://localhost:8080/stock", HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<StockDTO>>(){});
        log.info(exchange.getBody());

        return exchange;

    }

    public static StockDTO checkStock(String id){
        
        StockDTO object = new RestTemplate().getForObject("http://localhost:8080/stock/{id}", StockDTO.class, id);

        if(object == null){
            throw new BadRequestException("stock not found");
        }

        return object;

    }


}

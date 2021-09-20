package br.com.inatel.stonks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inatel.stonks.client.StockClient;
import br.com.inatel.stonks.dto.StockDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("stock")
@RequiredArgsConstructor
public class StockClientController {

    @PostMapping
    public ResponseEntity<StockDTO> createStock(@RequestBody @Valid StockDTO stockDTO) {
        
        return new ResponseEntity<>(StockClient.createStock(stockDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> listStocks() {
        return StockClient.listStocks();
    }

}

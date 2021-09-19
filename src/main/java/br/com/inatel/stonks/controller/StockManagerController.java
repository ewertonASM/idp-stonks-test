package br.com.inatel.stonks.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.inatel.stonks.client.StockClient;
import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.dto.StockQuoteResponseDTO;
import br.com.inatel.stonks.model.Quotes;
import br.com.inatel.stonks.model.QuotesTest;
import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.service.StockQuoteService;

import java.util.HashMap;

import javax.validation.Valid;

@RestController
@RequestMapping("quotes")
@Log4j2
@RequiredArgsConstructor
public class StockManagerController {


    private final StockQuoteService stockQuoteService;

    @PostMapping
    public ResponseEntity<StockQuoteResponseDTO> createQuote(@RequestBody @Valid StockQuotePostDTO stockQuoteDTO) {

        StockClient.checkStock(stockQuoteDTO.getStockId());

        return new ResponseEntity<>(stockQuoteService.save(stockQuoteDTO), HttpStatus.CREATED);
    }

    // @GetMapping(path = "/stock")
    // public ResponseEntity<HashMap<String, HashMap<String, String>>> findByName(@RequestParam String stockId) {

            

    //         log.info(stockId);
    //         return ResponseEntity.ok(stockQuoteService.findByName(stockId));
    // }

    // @GetMapping
    // public ResponseEntity<HashMap<String, HashMap<String, String>>> findAll() {
    //     return ResponseEntity.ok(stockQuoteService.findAll());

    // }

}

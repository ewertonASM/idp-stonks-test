package br.com.inatel.stonks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.inatel.stonks.client.StockClient;
import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.dto.StockQuoteResponseDTO;
import br.com.inatel.stonks.service.StockQuoteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("quotes")
@RequiredArgsConstructor
public class StockManagerController {

    private final StockQuoteService stockQuoteService;

    @PostMapping
    public ResponseEntity<StockQuoteResponseDTO> createQuote(@RequestBody @Valid StockQuotePostDTO stockQuoteDTO) {
        StockClient.checkStock(stockQuoteDTO.getStockId());
        return new ResponseEntity<>(stockQuoteService.save(stockQuoteDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/stock")
    public ResponseEntity<List<StockQuoteResponseDTO>> findByStock(@RequestParam String stockId) {
            return ResponseEntity.ok(stockQuoteService.findByStockId(stockId));
    }

    @GetMapping
    public ResponseEntity<List<StockQuoteResponseDTO>> findAllQuotes() {
        return ResponseEntity.ok(stockQuoteService.findAllQuotes());

    }

  
}

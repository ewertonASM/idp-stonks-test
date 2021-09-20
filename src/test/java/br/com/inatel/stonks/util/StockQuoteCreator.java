package br.com.inatel.stonks.util;

import java.util.HashMap;
import java.util.List;

import br.com.inatel.stonks.dto.StockQuoteResponseDTO;
import br.com.inatel.stonks.model.Quotes;
import br.com.inatel.stonks.model.StockQuote;

public class StockQuoteCreator {

    public static StockQuote createStockQuoteToBeSaved(){
        return StockQuote.builder()
                .stockId("petr4")
                .quotes(List.of(Quotes.builder().date("2020-01-20").value("20").build()))
                .build();
    }
    public static StockQuoteResponseDTO createValiStockQuote(){

        return StockQuoteResponseDTO.builder()
                .id("2c9830817c0051f8017c00570a260005")
                .stockId("petr4")
                .quotes(new HashMap<>())
                .build();

    }
}

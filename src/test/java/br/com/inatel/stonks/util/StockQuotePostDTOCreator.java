package br.com.inatel.stonks.util;

import java.util.HashMap;
import java.util.Map;

// import br.com.inatel.dto.AnimePostDTO;
import br.com.inatel.stonks.dto.StockQuotePostDTO;

public class StockQuotePostDTOCreator {

    public static StockQuotePostDTO createStockQuotePostDTO(){

        Map<String, String> quotes = new HashMap<String, String>();
        quotes.put("2020-01-20", "20");

        return StockQuotePostDTO.builder()
                .stockId(StockQuoteCreator.createStockQuoteToBeSaved().getStockId())
                .quotes(quotes)
                .build();

    }
}
package br.com.inatel.stonks.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import br.com.inatel.stonks.model.Quotes;
import br.com.inatel.stonks.model.StockQuote;
import javassist.expr.NewArray;
import br.com.inatel.stonks.dto.StockQuoteResponseDTO;

public class StockQuoteView {

    public static List<StockQuoteResponseDTO> generateView(List<Quotes> quotes, List<StockQuote> stockQuotes){
        
        List<StockQuoteResponseDTO> stockQuotesResponseDTO = new LinkedList<StockQuoteResponseDTO>();
        

        StockQuoteResponseDTO stockQuoteResponseDTO = StockQuoteResponseDTO.builder().build();

        for(StockQuote stockQuote:stockQuotes){

            stockQuoteResponseDTO = StockQuoteResponseDTO.builder()
                                                        .stockId(stockQuote.getStockId())
                                                        .id(stockQuote.getId())
                                                        .quotes(new HashMap<>())
                                                        .build();
            for(Quotes quote:quotes){
                stockQuoteResponseDTO.getQuotes().put(quote.getDate(), quote.getValue());
            }
            stockQuotesResponseDTO.add(stockQuoteResponseDTO);
        }

        return stockQuotesResponseDTO;

    }
    
}

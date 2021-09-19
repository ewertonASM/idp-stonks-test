package br.com.inatel.stonks.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.dto.StockQuoteResponseDTO;
import br.com.inatel.stonks.exception.BadRequestException;
import br.com.inatel.stonks.mapper.StockMapper;
import br.com.inatel.stonks.model.Quotes;
import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.repository.QuotesRepository;
import br.com.inatel.stonks.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class StockQuoteService {

    private final StockRepository stockRepository;
    private final QuotesRepository quotesRepository;


    // public HashMap<String, HashMap<String, String>> findByStockId(String stockId) {

    //     StockQuote stockQuote = stockRepository.findByStockId(stockId).get(0);
    //     // Quotes quotes = quotesRepository.findBy

    //     if(stockQuote == null){
    //         throw new BadRequestException("stock not found");
    //     }


    // //     return StockQuoteView.generateView(StockQuote, );
    // }

    // public HashMap<String, HashMap<String, String>> findAll() {


    //     List<Quotes> quotes = quotesRepository.findAll();

    //     log.info("##########################################################################################");
    //     log.info(quotes);
    //     log.info("##########################################################################################");


    //     return QuoteView.generateView(quotes);
    // }

    public StockQuoteResponseDTO save(StockQuotePostDTO stockQuotePostDTO) {
   
        List<StockQuote> stockQuotesList = stockRepository.findByStockId(stockQuotePostDTO.getStockId());

        log.info("***********************************************************************************************************************************************");
        StockQuote stockQuote = stockQuotesList.isEmpty() ? 
                                        stockRepository.save(StockMapper.INSTANCE.toStockQuote(stockQuotePostDTO)) : stockQuotesList.get(0);

        
        StockQuoteResponseDTO stockQuoteResponseDTO = StockQuoteResponseDTO.builder()
                                                        .stockId(stockQuote.getStockId())
                                                        .id(stockQuote.getId())
                                                        .quotes(new HashMap<>())
                                                        .build();

        for (var entry : stockQuotePostDTO.getQuotes().entrySet()) {

            Quotes quoteSaved = quotesRepository.save(Quotes.builder().date(entry.getKey()).value(entry.getValue()).stockQuote(stockQuote).build());
            stockQuoteResponseDTO.getQuotes().put(quoteSaved.getDate(), quoteSaved.getValue());
        }
                    
        return stockQuoteResponseDTO;

    }

}

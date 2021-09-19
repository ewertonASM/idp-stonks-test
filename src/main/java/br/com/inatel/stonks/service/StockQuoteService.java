package br.com.inatel.stonks.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.dto.StockQuoteResponseDTO;
import br.com.inatel.stonks.mapper.QuotesTestMapper;
import br.com.inatel.stonks.mapper.StockQuoteMapper;
import br.com.inatel.stonks.mapper.StockTestMapper;
import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.model.StockQuoteTest;
import br.com.inatel.stonks.model.Quotes;
import br.com.inatel.stonks.model.QuotesTest;
import br.com.inatel.stonks.repository.QuotesRepositoryTest;
// import br.com.inatel.stonks.repository.QuotesRepository;
// import br.com.inatel.stonks.repository.StockRepository;
import br.com.inatel.stonks.repository.StockRepositoryTest;
import br.com.inatel.stonks.view.QuoteView;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.mysql.cj.log.Log;

@Service
@RequiredArgsConstructor
@Log4j2
public class StockQuoteService {

    // private final StockRepository stockRepository;
    private final StockRepositoryTest stockRepositoryTest;
    private final QuotesRepositoryTest quotesRepositoryTest;
    // private final QuotesRepository quotesRepository;


    // public HashMap<String, HashMap<String, String>> findByName(String stockId) {

    //     List<Quote> quotes = stockRepository.findByStockId(stockId);
    //     return QuoteView.generateView(quotes);
    // }

    // public HashMap<String, HashMap<String, String>> findAll() {


    //     List<Quotes> quotes = quotesRepository.findAll();

    //     log.info("##########################################################################################");
    //     log.info(quotes);
    //     log.info("##########################################################################################");


    //     return QuoteView.generateView(quotes);
    // }

    public StockQuoteResponseDTO save(StockQuotePostDTO stockQuoteDTO) {
   
        List<StockQuoteTest> stockQuoteTestList = stockRepositoryTest.findByStockId(stockQuoteDTO.getStockId());

        StockQuoteTest stockQuoteTest = stockQuoteTestList.isEmpty() ? 
                                        stockRepositoryTest.save(StockTestMapper.INSTANCE.toStockQuote(stockQuoteDTO)) : stockQuoteTestList.get(0);
        
        StockQuoteResponseDTO stockQuoteResponseDTO = StockQuoteResponseDTO.builder()
                                                        .stockId(stockQuoteTest.getStockId())
                                                        .id(stockQuoteTest.getId())
                                                        .quotes(new HashMap<>())
                                                        .build();

        for (var entry : stockQuoteDTO.getQuotes().entrySet()) {

            QuotesTest quoteTestSaved = quotesRepositoryTest.save(QuotesTest.builder().date(entry.getKey()).value(entry.getValue()).stockQuoteTest(stockQuoteTest).build());
            stockQuoteResponseDTO.getQuotes().put(quoteTestSaved.getDate(), quoteTestSaved.getValue());
        }
                    
        return stockQuoteResponseDTO;

    }

}

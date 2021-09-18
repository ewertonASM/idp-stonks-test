package br.com.inatel.stonks.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.mapper.StockQuoteMapper;
import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.model.Quotes;
// import br.com.inatel.stonks.repository.QuotesRepository;
import br.com.inatel.stonks.repository.StockRepository;
import br.com.inatel.stonks.view.QuoteView;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class StockQuoteService {

    private final StockRepository stockRepository;
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

    public StockQuote save(StockQuotePostDTO quoteDTO) {

        // Optional<StockQuote> stockId = stockRepository.findByStockId(quoteDTO.getStockId());

        // if(stockId.isEmpty()){
            // }
            
        return stockRepository.save(StockQuoteMapper.INSTANCE.toStockQuote(quoteDTO));
            
        // return quoteRepository.save(QuoteMapper.INSTANCE.toQuote(quoteDTO));
        
    }

}

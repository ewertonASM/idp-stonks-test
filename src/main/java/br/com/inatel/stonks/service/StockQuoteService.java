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
import br.com.inatel.stonks.view.StockQuoteView;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class StockQuoteService {

    private final StockRepository stockRepository;
    private final QuotesRepository quotesRepository;


    public List<StockQuoteResponseDTO> findByStockId(String stockId) {

        List<StockQuote> stockQuotes = stockRepository.findByStockId(stockId);

        if(stockQuotes.isEmpty()){
            throw new BadRequestException("stock not found");
        }

        List<Quotes> quotes = quotesRepository.findByStockQuoteId(stockQuotes.get(0).getId());

        return StockQuoteView.generateView(quotes, stockQuotes);
        
    }

    public List<StockQuoteResponseDTO> findAllQuotes() {

        List<StockQuote> stockQuotes = stockRepository.findAll();

        if(stockQuotes.isEmpty()){
            throw new BadRequestException("stock not found");
        }

        List<Quotes> quotes = quotesRepository.findByStockQuoteId(stockQuotes.get(0).getId());

        return StockQuoteView.generateView(quotes, stockQuotes);
    }

    public StockQuoteResponseDTO save(StockQuotePostDTO stockQuotePostDTO) {
   
        List<StockQuote> stockQuotesList = stockRepository.findByStockId(stockQuotePostDTO.getStockId());

        StockQuote stockQuote = stockQuotesList.isEmpty() ? 
                                        stockRepository.save(StockQuote.builder().stockId(stockQuotePostDTO.getStockId()).build()) : stockQuotesList.get(0);

        
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

package br.com.inatel.stonks.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.mapper.QuoteMapper;
import br.com.inatel.stonks.model.Quote;
import br.com.inatel.stonks.repository.StockRepository;
import br.com.inatel.stonks.view.QuoteView;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockQuoteService {

    private final StockRepository stockRepository;


    public HashMap<String, HashMap<String, String>> findByName(String stockId) {

        List<Quote> quotes = stockRepository.findByStockId(stockId);
        return QuoteView.generateView(quotes);
    }

    public HashMap<String, HashMap<String, String>> findByUserId() {


        List<Quote> quotes = stockRepository.findAll();
        return QuoteView.generateView(quotes);
    }

    public Quote save(StockQuotePostDTO stockQuotePostDTO) {
        return stockRepository.save(QuoteMapper.INSTANCE.toQuote(stockQuotePostDTO));
    }

}

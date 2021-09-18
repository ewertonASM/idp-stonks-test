package br.com.inatel.stonks.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.stonks.model.QuotesTest;
import br.com.inatel.stonks.model.StockQuote;

public interface QuotesRepositoryTest extends JpaRepository<QuotesTest, String> {

    // List<QuotesTest> findByStockQuoteId(String stockId);
    // List<Quote> findByStockId(String stockId);

}

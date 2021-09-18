package br.com.inatel.stonks.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.stonks.model.StockQuoteTest;

public interface StockRepositoryTest extends JpaRepository<StockQuoteTest, String> {

    List<StockQuoteTest> findByStockId(String stockId);
    // List<Quote> findByStockId(String stockId);

}

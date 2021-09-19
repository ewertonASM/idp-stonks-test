package br.com.inatel.stonks.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.stonks.model.StockQuote;

public interface StockRepository extends JpaRepository<StockQuote, String> {

    List<StockQuote> findByStockId(String stockId);
    // List<Quote> findByStockId(String stockId);

}

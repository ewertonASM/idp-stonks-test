package br.com.inatel.stonks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.stonks.model.StockQuote;

public interface StockRepository extends JpaRepository<StockQuote, String> {

    List<StockQuote> findByStockId(String stockId);

}

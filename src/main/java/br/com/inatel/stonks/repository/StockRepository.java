package br.com.inatel.stonks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.stonks.model.Quote;

public interface StockRepository extends JpaRepository<Quote, Long> {

    List<Quote> findByUserId(Long userId);
    List<Quote> findByStockId(String stockId);

}

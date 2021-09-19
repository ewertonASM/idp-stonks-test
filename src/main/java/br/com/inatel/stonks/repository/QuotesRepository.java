package br.com.inatel.stonks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.stonks.model.Quotes;

public interface QuotesRepository extends JpaRepository<Quotes, String> {

    // List<Quotes> findByStockQuoteId(String stockId);
    // List<Quote> findByStockId(String stockId);

}

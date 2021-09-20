package br.com.inatel.stonks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.stonks.model.Quotes;

import java.util.*;

public interface QuotesRepository extends JpaRepository<Quotes, String> {

    List<Quotes> findByStockQuoteId(String stockQuoteId);
    // List<Quote> findByStockId(String stockId);

}

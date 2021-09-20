package br.com.inatel.stonks.repository;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.inatel.stonks.model.Quotes;
import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.util.StockQuoteCreator;

@DataJpaTest
@DisplayName("Tests for StockQuote Repository")
class StockQuoteRepositoryTest {

    @Autowired
    private StockRepository stockQuoteRepository;

    @Autowired
    private QuotesRepository quotesRepository;

    @Test
    @DisplayName("Save persists stockQuote when Successful")
    void save_PersistStockQuote_WhenSuccessful(){
        StockQuote stockQuoteToBeSaved = StockQuoteCreator.createStockQuoteToBeSaved();

        StockQuote stockQuoteSaved = this.stockQuoteRepository.save(stockQuoteToBeSaved);

        Assertions.assertThat(stockQuoteSaved).isNotNull();

        Assertions.assertThat(stockQuoteSaved.getId()).isNotNull();

        Assertions.assertThat(stockQuoteSaved.getStockId()).isEqualTo(stockQuoteToBeSaved.getStockId());
    }


    @Test
    @DisplayName("Find By Name returns list of stockQuote when Successful")
    void findByStockId_ReturnsListOfStockQuote_WhenSuccessful(){

        StockQuote stockQuoteToSave = StockQuote.builder().stockId("petr4").build();  
        StockQuote stockQuoteSaved = stockQuoteRepository.save(stockQuoteToSave);

        Quotes quoteToSave = Quotes.builder().date("2020-10-10").value("20").stockQuote(stockQuoteSaved).build();
        quotesRepository.save(quoteToSave);

        String name = stockQuoteSaved.getStockId();

        List<StockQuote> stockQuotes = this.stockQuoteRepository.findByStockId(name);

        Assertions.assertThat(stockQuotes)
                .isNotEmpty()
                .contains(stockQuoteSaved);

    }

    @Test
    @DisplayName("Find By Name returns empty list when no stockQuote is found")
    void findByStockId_ReturnsEmptyList_WhenStockQuoteIsNotFound(){
        List<StockQuote> stockQuotes = this.stockQuoteRepository.findByStockId("xaxa");

        Assertions.assertThat(stockQuotes).isEmpty();
    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when stock id is empty")
    void save_ThrowsConstraintViolationException_WhenNameIsEmpty(){
        StockQuote stockQuote = new StockQuote();
//        Assertions.assertThatThrownBy(() -> this.stockQuoteRepository.save(stockQuote))
//                .isInstanceOf(ConstraintViolationException.class);

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.stockQuoteRepository.save(stockQuote));
    }

}

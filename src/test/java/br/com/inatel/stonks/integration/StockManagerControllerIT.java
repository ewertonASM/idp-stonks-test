package br.com.inatel.stonks.integration;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.dto.StockQuoteResponseDTO;
import br.com.inatel.stonks.model.Quotes;
import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.repository.QuotesRepository;
import br.com.inatel.stonks.repository.StockRepository;
import br.com.inatel.stonks.util.StockQuoteCreator;
import br.com.inatel.stonks.util.StockQuotePostDTOCreator;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class StockManagerControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private QuotesRepository quotesRepository;

    @Test
    @DisplayName("findByStockId returns stock quote when successful")
    void findByStockId_ReturnsStock_WhenSuccessful(){

        StockQuote stockQuoteToSave = StockQuote.builder().stockId("petr4").build();  
        StockQuote stockQuote = stockRepository.save(stockQuoteToSave);

        Quotes quoteToSave = Quotes.builder().date("2020-10-10").value("20").stockQuote(stockQuote).build();
        quotesRepository.save(quoteToSave);

        String expectedStockId = stockQuoteToSave.getStockId();

        String url = String.format("/quotes/stock?stockId=%s", expectedStockId);

        List<StockQuoteResponseDTO> stockQuotes = testRestTemplate.exchange(url, HttpMethod.GET, null,
                                new ParameterizedTypeReference<List<StockQuoteResponseDTO>>() {
                                }).getBody();



        Assertions.assertThat(stockQuotes)
                    .isNotEmpty()
                    .hasSize(1);

        Assertions.assertThat(stockQuotes.get(0).getStockId()).isEqualTo(expectedStockId);
    }

    @Test
    @DisplayName("findAll returns a list of stock quotes when successful")
    void findAll_ReturnsListOfStockQuotes_WhenSuccessful(){

        StockQuote stockQuoteToSave = StockQuote.builder().stockId("petr4").build();  
        StockQuote stockQuote = stockRepository.save(stockQuoteToSave);

        Quotes quoteToSave = Quotes.builder().date("2020-10-10").value("20").stockQuote(stockQuote).build();
        quotesRepository.save(quoteToSave);

        String expectedStockId = stockQuoteToSave.getStockId();

        // String url = String.format("/quotes", expectedStockId);

        List<StockQuoteResponseDTO> stockQuotes = testRestTemplate.exchange("/quotes", HttpMethod.GET, null,
                                new ParameterizedTypeReference<List<StockQuoteResponseDTO>>() {
                                }).getBody();

        Assertions.assertThat(stockQuotes)
                    .isNotEmpty()
                    .hasSize(1);

        Assertions.assertThat(stockQuotes.get(0).getStockId()).isEqualTo(expectedStockId);

    }

    

    @Test
    @DisplayName("save returns stock quote when successful")
    void save_ReturnStockQuote_WhenSuccessful(){
        
        StockQuotePostDTO stockQuotePostDTO = StockQuotePostDTOCreator.createStockQuotePostDTO();

        ResponseEntity<StockQuoteResponseDTO> stockQuoteResponseEntity = testRestTemplate.postForEntity("/quotes", stockQuotePostDTO, StockQuoteResponseDTO.class);

        Assertions.assertThat(stockQuoteResponseEntity).isNotNull();
        Assertions.assertThat(stockQuoteResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(stockQuoteResponseEntity.getBody()).isNotNull();
        Assertions.assertThat(stockQuoteResponseEntity.getBody().getId()).isNotNull();

    }

}

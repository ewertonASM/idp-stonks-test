package br.com.inatel.stonks.controller;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.dto.StockQuoteResponseDTO;
import br.com.inatel.stonks.service.StockQuoteService;
import br.com.inatel.stonks.util.StockQuoteCreator;
import br.com.inatel.stonks.util.StockQuotePostDTOCreator;

@ExtendWith(SpringExtension.class)
class StockManagerControllerTest {
    @InjectMocks
    private StockManagerController stockManagerController;
    @Mock
    private StockQuoteService stockQuoteServiceMock;

    @BeforeEach
    void setUp(){

        BDDMockito.when(stockQuoteServiceMock.findAllQuotes())
                .thenReturn(List.of(StockQuoteCreator.createValiStockQuote()));
        
        BDDMockito.when(stockQuoteServiceMock.findByStockId(ArgumentMatchers.anyString()))
                .thenReturn(List.of(StockQuoteCreator.createValiStockQuote()));


        BDDMockito.when(stockQuoteServiceMock.save(ArgumentMatchers.any(StockQuotePostDTO.class)))
                .thenReturn(StockQuoteCreator.createValiStockQuote());

    }



    @Test
    @DisplayName("listAll returns list of quotes when successful")
    void listAll_ReturnsListOfQuotes_WhenSuccessful(){

        String stockId = StockQuoteCreator.createValiStockQuote().getStockId();

        List<StockQuoteResponseDTO> stockQuotes = stockManagerController.findAllQuotes().getBody();

        Assertions.assertThat(stockQuotes)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(stockQuotes.get(0).getStockId()).isEqualTo(stockId);
    }

    @Test
    @DisplayName("findByStockId returns stock quote when successful")
    void findByStockId_ReturnsStockQuote_WhenSuccessful(){

        String expectedStockId = StockQuoteCreator.createValiStockQuote().getStockId();

        List<StockQuoteResponseDTO> stockQuotes = stockManagerController.findByStock(expectedStockId).getBody();

        Assertions.assertThat(stockQuotes)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(stockQuotes.get(0).getStockId()).isNotNull().isEqualTo(expectedStockId);
    }



    @Test
    @DisplayName("findStockId returns an empty list of stock quotes when quote is not found")
    void findStockId_ReturnsEmptyListOfStockQuote_WhenStockQuoteIsNotFound(){

        BDDMockito.when(stockQuoteServiceMock.findByStockId(ArgumentMatchers.anyString()))
                .thenReturn(Collections.emptyList());

        List<StockQuoteResponseDTO> stockQuoteResponseDTOs = stockManagerController.findByStock("stockId").getBody();

        Assertions.assertThat(stockQuoteResponseDTOs)
                .isNotNull()
                .isEmpty();

    }

    @Test
    @DisplayName("save returns stock quote when successful")
    void save_ReturnsStockQuote_WhenSuccessful(){

        StockQuoteResponseDTO stockQuoteResponseDTO = stockManagerController.createQuote(StockQuotePostDTOCreator.createStockQuotePostDTO()).getBody();
        Assertions.assertThat(stockQuoteResponseDTO).isNotNull().isEqualTo(StockQuoteCreator.createValiStockQuote());

    }

}

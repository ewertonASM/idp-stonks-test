package br.com.inatel.stonks.service;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.repository.StockRepository;
import br.com.inatel.stonks.util.StockQuoteCreator;
import br.com.inatel.stonks.util.StockQuotePostDTOCreator;

@ExtendWith(SpringExtension.class)
public class StockQuoteServiceTest {

//     @InjectMocks
//     private StockQuoteService stockQuoteService;
//     @Mock
//     private StockRepository stockQuoteRepositoryMock;

//     @BeforeEach
//     void setUp(){


//         BDDMockito.when(stockQuoteRepositoryMock.findAll())
//                 .thenReturn(List.of(StockQuoteCreator.createValiStockQuote()));

//         BDDMockito.when(stockQuoteRepositoryMock.findByStockId(ArgumentMatchers.anyString()))
//                 .thenReturn(List.of(StockQuoteCreator.createValiStockQuote()));

//         BDDMockito.when(stockQuoteRepositoryMock.save(ArgumentMatchers.any(StockQuote.class)))
//                 .thenReturn(StockQuoteCreator.createValiStockQuote());

//     }
    
  
//     @Test
//     @DisplayName("findByIdOrThrowBadRequestException returns StockQuote when successful")
//     void findByIdOrThrowBadRequestException_ReturnsStockQuote_WhenSuccessful(){
//         Long expectedId = StockQuoteCreator.createValiStockQuote().getStockId();

//         StockQuote StockQuote = stockQuoteService.findByStockId("petr4");

//         Assertions.assertThat(StockQuote).isNotNull();

//         Assertions.assertThat(StockQuote.getStockId()).isNotNull().isEqualTo(expectedId);
//     }

//     @Test
//     @DisplayName("findByIdOrThrowBadRequestException throws BadRequestException when StockQuote is not found")
//     void findByIdOrThrowBadRequestException_ThrowsBadRequestException_WhenStockQuoteIsNotFound(){
//         BDDMockito.when(stockQuoteRepositoryMock.findByStockId(ArgumentMatchers.anyLong()))
//                 .thenReturn(Optional.empty());

//         Assertions.assertThatExceptionOfType(BadRequestException.class)
//                 .isThrownBy(() -> stockQuoteService.findByIdOrThrowBadRequestException(1L));
//     }

//     @Test
//     @DisplayName("findByName returns a list of StockQuote when successful")
//     void findByName_ReturnsListOfStockQuote_WhenSuccessful(){
//         String expectedName = StockQuoteCreator.createValiStockQuote().getStockId();

//         List<StockQuote> stockQuotes = stockQuoteService.findByStockId("StockQuote");

//         Assertions.assertThat(stockQuotes)
//                 .isNotNull()
//                 .isNotEmpty()
//                 .hasSize(1);

//         Assertions.assertThat(stockQuotes.get(0).getStockId()).isEqualTo(expectedName);
//     }

//     @Test
//     @DisplayName("findByName returns an empty list of StockQuote when StockQuote is not found")
//     void findByName_ReturnsEmptyListOfStockQuote_WhenStockQuoteIsNotFound(){
//         BDDMockito.when(stockQuoteRepositoryMock.findByStockId(ArgumentMatchers.anyString()))
//                 .thenReturn(Collections.emptyList());

//         List<StockQuote> stockQuotes = stockQuoteService.findByStockId("StockQuote");

//         Assertions.assertThat(stockQuotes)
//                 .isNotNull()
//                 .isEmpty();

//     }

//     @Test
//     @DisplayName("save returns StockQuote when successful")
//     void save_ReturnsStockQuote_WhenSuccessful(){

//         StockQuote stockQuote = stockQuoteService.save(StockQuotePostDTOCreator.createStockQuotePostDTO());

//         Assertions.assertThat(StockQuote).isNotNull().isEqualTo(StockQuoteCreator.createValiStockQuote());

//     }


}

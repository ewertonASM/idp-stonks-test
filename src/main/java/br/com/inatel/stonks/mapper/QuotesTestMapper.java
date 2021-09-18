package br.com.inatel.stonks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.model.StockQuoteTest;
import br.com.inatel.stonks.model.Quotes;
import br.com.inatel.stonks.model.QuotesTest;

@Mapper(componentModel = "spring")
public abstract class QuotesTestMapper {
    
    public static final QuotesTestMapper INSTANCE = Mappers.getMapper(QuotesTestMapper.class);
    public abstract QuotesTest toQuoteTest(StockQuotePostDTO quoteDTO);

}

package br.com.inatel.stonks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.model.Quotes;

@Mapper(componentModel = "spring")
public abstract class QuotesMapper {
    
    public static final QuotesMapper INSTANCE = Mappers.getMapper(QuotesMapper.class);
    public abstract Quotes toQuotes(StockQuotePostDTO quoteDTO);

}

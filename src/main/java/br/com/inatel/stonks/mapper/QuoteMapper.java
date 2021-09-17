package br.com.inatel.stonks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.model.Quote;

@Mapper(componentModel = "spring")
public abstract class QuoteMapper {
    
    public static final QuoteMapper INSTANCE = Mappers.getMapper(QuoteMapper.class);
    public abstract Quote toQuote(StockQuotePostDTO stockQuotePostDTO);

}

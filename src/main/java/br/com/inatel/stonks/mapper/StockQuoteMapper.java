package br.com.inatel.stonks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.model.Quote;
import br.com.inatel.stonks.model.StockQuote;

@Mapper(componentModel = "spring")
public abstract class StockQuoteMapper {
    
    public static final StockQuoteMapper INSTANCE = Mappers.getMapper(StockQuoteMapper.class);
    public abstract StockQuote toStockQuote(StockQuotePostDTO stockQuotePostDTO);

}

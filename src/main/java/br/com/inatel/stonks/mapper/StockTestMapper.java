package br.com.inatel.stonks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.model.StockQuote;
import br.com.inatel.stonks.model.StockQuoteTest;
import br.com.inatel.stonks.model.Quotes;

@Mapper(componentModel = "spring")
public abstract class StockTestMapper {
    
    public static final StockTestMapper INSTANCE = Mappers.getMapper(StockTestMapper.class);
    public abstract StockQuoteTest toStockQuote(StockQuotePostDTO quoteDTO);

}

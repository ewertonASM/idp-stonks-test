package br.com.inatel.stonks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.inatel.stonks.dto.StockQuotePostDTO;
import br.com.inatel.stonks.model.StockQuote;

@Mapper(componentModel = "spring")
public abstract class StockMapper {
    
    public static final StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);
    public abstract StockQuote toStockQuote(StockQuotePostDTO stockQuotePostDTO);

}

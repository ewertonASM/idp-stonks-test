package br.com.inatel.stonks.mapper;

import java.util.Map;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.inatel.stonks.model.Quotes;

@Mapper(componentModel = "spring")
public abstract class QuotesMapper {
    
    public static final QuotesMapper INSTANCE = Mappers.getMapper(QuotesMapper.class);
    public abstract Quotes toQuote(Map<String, String> quoteDTO);

}

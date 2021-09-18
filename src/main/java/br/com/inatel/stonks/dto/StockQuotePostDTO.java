package br.com.inatel.stonks.dto;

import java.util.Map;

import javax.validation.constraints.NotEmpty;

import br.com.inatel.stonks.model.StockQuote;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockQuotePostDTO {
    
    private String id;

    @NotEmpty(message = "The stock id cannot be empty")
    private String stockId;

    @NotEmpty(message = "The quote cannot be empty")
    private Map<String, String> quotes;
    
}

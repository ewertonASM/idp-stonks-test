package br.com.inatel.stonks.dto;

import java.util.Map;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockQuotePostDTO {

    @NotEmpty(message = "The stock id cannot be empty")
    private String stockId;

    @NotEmpty(message = "The quote cannot be empty")
    private Map<String, String> quotes;
    
}

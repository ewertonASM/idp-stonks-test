package br.com.inatel.stonks.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockQuoteResponseDTO {
    
    private String id;

    private String stockId;

    private Map<String, String> quotes;
    
}

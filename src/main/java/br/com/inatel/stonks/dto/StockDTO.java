package br.com.inatel.stonks.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO {

    @NotEmpty(message = "The id cannot be empty")
    private String id;
    
    @NotEmpty(message = "The description cannot be empty")
    private String description;

}

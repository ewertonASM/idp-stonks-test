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
public class NotificationDTO {

    @NotEmpty(message = "The host cannot be empty")
    private String host;
    
    @NotEmpty(message = "The port cannot be empty")
    private int port;

}

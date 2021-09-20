package br.com.inatel.stonks.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import br.com.inatel.stonks.dto.NotificationDTO;

public class BeanInitMethodImpl {
    
    public void runAfterObjectCreated() {
        NotificationDTO notificationDTO = NotificationDTO.builder().host("localhost").port(8080).build();
        
        new RestTemplate().exchange("http://localhost:8080/notification",HttpMethod.POST,
                                                                            new HttpEntity<>(notificationDTO, createJsonHeader()), Void.class);
    }

    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;

    }
} 


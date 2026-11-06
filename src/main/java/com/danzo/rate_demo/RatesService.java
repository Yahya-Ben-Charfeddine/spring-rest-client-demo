package com.danzo.rate_demo;


import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RatesService {
    private final RestClient frankfurterClient;
    public RatesService(RestClient frankfurterClient){
        this.frankfurterClient=frankfurterClient;
    }

    public RatesResponse getRates(String currency){
        return frankfurterClient.get()
                .uri("/latest?from={currency}", currency)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,(request, response) -> {
                    throw new CurrentlyNotFoundException(currency);
                })
                .body(RatesResponse.class);
    }



}

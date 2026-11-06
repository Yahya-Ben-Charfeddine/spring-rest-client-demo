package com.danzo.rate_demo;


import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rates")
public class RatesController {
    private final RatesService ratesService;
    public RatesController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @GetMapping("/{currency}")
    public ResponseEntity<RatesResponse> getRate(@PathVariable @Pattern(regexp = "[A-Za-z]{3}") String currency){
        return new ResponseEntity<>(ratesService.getRates(currency.toUpperCase()), HttpStatus.OK);
    }
}

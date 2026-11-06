package com.danzo.rate_demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public record RatesResponse(
        BigDecimal amount,
        String base,
        LocalDate date,
        Map<String,BigDecimal> rates
) {
}

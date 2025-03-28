package com.ramesh.models;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeRate {
    private int  currencyID;  // Currency object
    private double buyRate;     // Buying rate
    private double sellRate;    // Selling rate
    private LocalDate date;     // Date of the exchange rate
}

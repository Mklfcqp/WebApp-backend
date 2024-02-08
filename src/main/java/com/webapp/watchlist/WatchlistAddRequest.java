package com.webapp.watchlist;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WatchlistAddRequest {

    private Long id;
    private String ticker;
    private String company;
    private BigDecimal price;
    private String currencyPrice;
    private BigDecimal dcf;
    private String currencyDcf;
    private BigDecimal dividendY;
    private String currencyDividendY;
    private BigDecimal dividendQ;
    private String currencyDividendQ;
    private BigDecimal dividendYield;
    private String overValuedUnderValued;

/*
    public getDividendY() {
        BigDecimal value = dividendQ.multiply(4);
        dividendY = value.setScale(2, RoundingMode.HALF_UP);
        return dividendY;
    }

    public getDividendYield() {
        BigDecimal value = (dividendQ.divide(price)).multiply(100);
        dividendYield = value.setScale(2, RoundingMode.HALF_UP);
        return dividendYield;
    }

    */

    public String getOverValuedUnderValued() {
        BigDecimal value = (((price.divide(dcf)).multiply(BigDecimal.valueOf(100))).subtract(BigDecimal.valueOf(100)));

        if(value.compareTo(BigDecimal.ZERO) < 0) {
            value = value.abs();
            return overValuedUnderValued = value.setScale(0, RoundingMode.HALF_UP) + " %" + " Undervalued";
        } else if(value.compareTo(BigDecimal.ZERO) > 0) {
            return overValuedUnderValued = value.setScale(0, RoundingMode.HALF_UP) + " %" + " Overvalued";
        } else {
            return overValuedUnderValued = "0 %";
        }
    }


}

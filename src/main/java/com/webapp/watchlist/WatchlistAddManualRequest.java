package com.webapp.watchlist;

import com.webapp.dcf.Dcf;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WatchlistAddManualRequest {

    private Long id;
    private String ticker;
    private String company;
    private BigDecimal price;
    private String currencyPrice;
    private String currencyDcf;
    private BigDecimal dividendY;
    private String currencyDividendY;
    private BigDecimal dividendQ;
    private String currencyDividendQ;
    private BigDecimal dividendYield;
    private String overValuedUnderValued;

    private BigDecimal dcfWithMarginOfSafety;





    public BigDecimal getDividendY() {
        BigDecimal value = dividendQ.multiply(BigDecimal.valueOf(4));
        dividendY = value.setScale(3, RoundingMode.HALF_UP);
        return dividendY;
    }

    public BigDecimal getDividendYield() {
        BigDecimal value = (dividendY.divide(price, 2, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100));
        dividendYield = value.setScale(2, RoundingMode.HALF_UP);
        return dividendYield;
    }



    public String getOverValuedUnderValued() {
        BigDecimal value = (((price.divide(dcfWithMarginOfSafety, 3, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100))).subtract(BigDecimal.valueOf(100)));

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

package com.webapp.portfolio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioAddRequest {

    private Long id;
    private String ticker;
    private String company;
    private Long shares;
    private BigDecimal buy;
    private BigDecimal sell;
    private BigDecimal interestBuySell;
    private BigDecimal profitLossBuySell;
    private BigDecimal dividend;
    private BigDecimal interestDividend;
    private BigDecimal profitLossDividend;
    private BigDecimal sumProfitLoss;




    public BigDecimal profitLossBuySellCalc(){
        profitLossBuySell = ((buy.subtract(sell)).add(interestBuySell)).setScale(2, RoundingMode.HALF_UP);
        return profitLossBuySell;
    }


    public BigDecimal profitLossDividendCalc(){
        profitLossDividend = (dividend.subtract(interestDividend)).setScale(2, RoundingMode.HALF_UP);
        return profitLossDividend;
    }


    public BigDecimal sumProfitLossCalc(){
        sumProfitLoss = (profitLossBuySellCalc().add(profitLossDividendCalc())).setScale(2, RoundingMode.HALF_UP);
        return sumProfitLoss;
    }
}

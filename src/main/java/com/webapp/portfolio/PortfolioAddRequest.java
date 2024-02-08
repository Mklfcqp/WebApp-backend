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
    private Long sharesBuy;
    private BigDecimal buy;
    private BigDecimal sell;
    private Long sharesSell;
    private BigDecimal interestBuySell;
    private BigDecimal profitLossBuySell;
    private BigDecimal dividend;
    private BigDecimal interestDividend;
    private BigDecimal profitLossDividend;
    private BigDecimal sumProfitLoss;




    public BigDecimal getProfitLossBuySell() {

        BigDecimal buyRatio = buy.divide(sharesBuy);
        BigDecimal sellRatio = sell.divide(sharesSell);
        BigDecimal profLoss1 = sellRatio.subtract(buyRatio);
        BigDecimal value1 = profLoss1.multiply(sharesSell);
        BigDecimal value2 = value1.subtract(interestBuySell)

        //BigDecimal value1 = buy.add(interestBuySell);
        //BigDecimal value2 = sell.subtract(value1);

        profitLossBuySell = sell.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : value2;

        return profitLossBuySell;
    }


    public BigDecimal getProfitLossDividend(){
        profitLossDividend = (dividend.subtract(interestDividend)).setScale(2, RoundingMode.HALF_UP);
        return profitLossDividend;
    }


    public BigDecimal getSumProfitLoss(){
        sumProfitLoss = (getProfitLossBuySell().add(getProfitLossDividend())).setScale(2, RoundingMode.HALF_UP);
        return sumProfitLoss;
    }
}

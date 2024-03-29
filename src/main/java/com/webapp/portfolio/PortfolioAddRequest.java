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

        BigDecimal buyRatio;
        BigDecimal sellRatio;

        if (sharesBuy != 0) {
            buyRatio = buy.divide(BigDecimal.valueOf(sharesBuy), 2, RoundingMode.HALF_UP);
        } else {
            buyRatio = BigDecimal.ZERO;
        }

        if (sharesSell != 0) {
            sellRatio = sell.divide(BigDecimal.valueOf(sharesSell), 2, RoundingMode.HALF_UP);
        } else {
            sellRatio = BigDecimal.ZERO;
        }

        BigDecimal profLoss1 = sellRatio.subtract(buyRatio);
        BigDecimal value1 = profLoss1.multiply(BigDecimal.valueOf(sharesSell));
        BigDecimal value2 = value1.subtract(interestBuySell);

        profitLossBuySell = sell.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : value2;

        return profitLossBuySell;
    }


    public BigDecimal getProfitLossDividend(){
        profitLossDividend = (dividend.subtract(interestDividend)).setScale(2, RoundingMode.HALF_UP);
        return profitLossDividend;
    }


    public BigDecimal getSumProfitLoss() {
        BigDecimal profitLossBuySell = getProfitLossBuySell();
        BigDecimal profitLossDividend = getProfitLossDividend();

        if (profitLossBuySell.compareTo(BigDecimal.ZERO) == 0 && profitLossDividend.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal sumProfitLoss = profitLossBuySell.add(profitLossDividend).setScale(2, RoundingMode.HALF_UP);
        return sumProfitLoss;
    }
}

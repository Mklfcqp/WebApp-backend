package com.webapp.portfolio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioGetRequestSUM {

    private Long id;
    private BigDecimal buy;
    private BigDecimal sell;
    private BigDecimal interestBuySell;
    private BigDecimal profitLossBuySell;
    private BigDecimal dividend;
    private BigDecimal interestDividend;
    private BigDecimal profitLossDividend;
    private BigDecimal sumProfitLoss;

}

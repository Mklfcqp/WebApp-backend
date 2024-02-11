package com.webapp.dcf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DcfGetFinancialRequest {

    private Long id;

    private BigDecimal freeCashFlow0;
    private BigDecimal freeCashFlow1;
    private BigDecimal freeCashFlow2;
    private BigDecimal freeCashFlow3;
    private BigDecimal freeCashFlow4;
    private BigDecimal freeCashFlow5;
    private BigDecimal freeCashFlow6;
    private BigDecimal freeCashFlow7;

    private BigDecimal growthRate;

    private BigDecimal perpetualGrowthRate;
    private BigDecimal discountRate;

    private BigDecimal cash;
    private BigDecimal totalDebt;

    private BigDecimal sharesOutstanding;

    private BigDecimal dcfWithMarginOfSafety;
}

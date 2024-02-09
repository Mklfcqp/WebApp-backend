package com.webapp.dcf;

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
public class DcfAddRequest {

    private Long id;

    private String company;

    private BigDecimal freeCashFlow0;
    private BigDecimal freeCashFlow1;
    private BigDecimal freeCashFlow2;
    private BigDecimal freeCashFlow3;
    private BigDecimal freeCashFlow4;
    private BigDecimal freeCashFlow5;
    private BigDecimal freeCashFlow6;
    private BigDecimal freeCashFlow7;

    private BigDecimal growth0; // growth0 = (freeCashFlow0 - freeCashFlow1) / freeCashFlow1
    private BigDecimal growth1; // growth1 = (freeCashFlow1 - freeCashFlow2) / freeCashFlow2
    private BigDecimal growth2; // growth2 = (freeCashFlow2 - freeCashFlow3) / freeCashFlow3
    private BigDecimal growth3; // growth3 = (freeCashFlow3 - freeCashFlow4) / freeCashFlow4
    private BigDecimal growth4; // growth4 = (freeCashFlow4 - freeCashFlow5) / freeCashFlow5
    private BigDecimal growth5; // growth5 = (freeCashFlow5 - freeCashFlow6) / freeCashFlow6
    private BigDecimal growth6; // growth6 = (freeCashFlow6 - freeCashFlow7) / freeCashFlow7
    private BigDecimal growth7; // neni potreba?

    private BigDecimal growthRate;
    private BigDecimal avgGrowthRate; // vypocet (viz nize)

    private BigDecimal futureFreeCashFlow0; // futureFreeCashFlow0 = freeCashFlow0 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow1; // futureFreeCashFlow1 = futureFreeCashFlow0 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow2; // futureFreeCashFlow2 = futureFreeCashFlow1 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow3; // futureFreeCashFlow3 = futureFreeCashFlow2 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow4; // futureFreeCashFlow4 = futureFreeCashFlow3 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow5; // futureFreeCashFlow5 = futureFreeCashFlow4 * (1 + growthRate)
    private BigDecimal futureFreeCashFlow6; // futureFreeCashFlow6 = futureFreeCashFlow5 * (1 + growthRate)

    private BigDecimal terminalValue; // terminalValue = futureFreeCashFlow6 * (1 + perpetualGrowthRate) / (discountRate - perpetualGrowthRate)

    private BigDecimal pvOfFreeCashFlow0; // pvOfFreeCashFlow0 = futureFreeCashFlow0 / Math.pow((1 + discountRate), 1)
    private BigDecimal pvOfFreeCashFlow1; // pvOfFreeCashFlow1 = futureFreeCashFlow1 / Math.pow((1 + discountRate), 2)
    private BigDecimal pvOfFreeCashFlow2; // pvOfFreeCashFlow2 = futureFreeCashFlow2 / Math.pow((1 + discountRate), 3)
    private BigDecimal pvOfFreeCashFlow3; // pvOfFreeCashFlow3 = futureFreeCashFlow3 / Math.pow((1 + discountRate), 4)
    private BigDecimal pvOfFreeCashFlow4; // pvOfFreeCashFlow4 = futureFreeCashFlow4 / Math.pow((1 + discountRate), 5)
    private BigDecimal pvOfFreeCashFlow5; // pvOfFreeCashFlow5 = futureFreeCashFlow5 / Math.pow((1 + discountRate), 6)
    private BigDecimal pvOfFreeCashFlow6; // pvOfFreeCashFlow6 = futureFreeCashFlow6 / Math.pow((1 + discountRate), 7)
    private BigDecimal pvOfFreeCashFlow7; // pvOfFreeCashFlow7 = futureFreeCashFlow7 / Math.pow((1 + discountRate), 8)

    private BigDecimal perpetualGrowthRate;
    private BigDecimal discountRate;

    private BigDecimal sumPvOfFcf; // vypocet (viz nize)
    private BigDecimal cash;
    private BigDecimal totalDebt;

    private BigDecimal equityValue; // equityValue = sumPvOfFcf + cash - totalDebt
    private BigDecimal sharesOutstanding;

    private BigDecimal dcfWithoutMarginOfSafety; // dcfWithoutMarginOfSafety = equityValue / sharesOutstanding
    private BigDecimal dcfWithMarginOfSafety;


    public BigDecimal getGrowth0() {
        growth0 = (freeCashFlow0.subtract(freeCashFlow1)).divide(freeCashFlow1, 2, RoundingMode.HALF_UP);
        return growth0;
    }

    public BigDecimal getGrowth1() {
        growth1 = (freeCashFlow1.subtract(freeCashFlow2)).divide(freeCashFlow2, 2, RoundingMode.HALF_UP);
        return growth1;
    }

    public BigDecimal getGrowth2() {
        growth2 = (freeCashFlow2.subtract(freeCashFlow3)).divide(freeCashFlow3, 2, RoundingMode.HALF_UP);
        return growth2;
    }

    public BigDecimal getGrowth3() {
        growth3 = (freeCashFlow3.subtract(freeCashFlow4)).divide(freeCashFlow4, 2, RoundingMode.HALF_UP);
        return growth3;
    }

    public BigDecimal getGrowth4() {
        growth4 = (freeCashFlow4.subtract(freeCashFlow5)).divide(freeCashFlow5, 2, RoundingMode.HALF_UP);
        return growth4;
    }

    public BigDecimal getGrowth5() {
        growth5 = (freeCashFlow5.subtract(freeCashFlow6)).divide(freeCashFlow6, 2, RoundingMode.HALF_UP);
        return growth5;
    }

    public BigDecimal getGrowth6() {
        growth6 = (freeCashFlow6.subtract(freeCashFlow7)).divide(freeCashFlow7, 2, RoundingMode.HALF_UP);
        return growth6;
    }

    public BigDecimal getGrowth7() {
        // neni potreba?
        return growth7;
    }


    public BigDecimal getAvgGrowthRate() {
        // vypocet (viz nize)
        return avgGrowthRate;
    }

    public BigDecimal getFutureFreeCashFlow0() {
        // futureFreeCashFlow0 = freeCashFlow0 * (1 + growthRate)
        return futureFreeCashFlow0;
    }

    public BigDecimal getFutureFreeCashFlow1() {
        // futureFreeCashFlow1 = futureFreeCashFlow0 * (1 + growthRate)
        return futureFreeCashFlow1;
    }

    public BigDecimal getFutureFreeCashFlow2() {
        // futureFreeCashFlow2 = futureFreeCashFlow1 * (1 + growthRate)
        return futureFreeCashFlow2;
    }

    public BigDecimal getFutureFreeCashFlow3() {
        // futureFreeCashFlow3 = futureFreeCashFlow2 * (1 + growthRate)
        return futureFreeCashFlow3;
    }

    public BigDecimal getFutureFreeCashFlow4() {
        // futureFreeCashFlow4 = futureFreeCashFlow3 * (1 + growthRate)
        return futureFreeCashFlow4;
    }

    public BigDecimal getFutureFreeCashFlow5() {
        // futureFreeCashFlow5 = futureFreeCashFlow4 * (1 + growthRate)
        return futureFreeCashFlow5;
    }

    public BigDecimal getFutureFreeCashFlow6() {
        // futureFreeCashFlow6 = futureFreeCashFlow5 * (1 + growthRate)
        return futureFreeCashFlow6;
    }

    public BigDecimal getTerminalValue() {
        // terminalValue = futureFreeCashFlow6 * (1 + perpetualGrowthRate) / (discountRate - perpetualGrowthRate)
        return terminalValue;
    }

    public BigDecimal getPvOfFreeCashFlow0() {
        // pvOfFreeCashFlow0 = futureFreeCashFlow0 / Math.pow((1 + discountRate), 1)
        return pvOfFreeCashFlow0;
    }

    public BigDecimal getPvOfFreeCashFlow1() {
        // pvOfFreeCashFlow1 = futureFreeCashFlow1 / Math.pow((1 + discountRate), 2)
        return pvOfFreeCashFlow1;
    }

    public BigDecimal getPvOfFreeCashFlow2() {
        // pvOfFreeCashFlow2 = futureFreeCashFlow2 / Math.pow((1 + discountRate), 3)
        return pvOfFreeCashFlow2;
    }

    public BigDecimal getPvOfFreeCashFlow3() {
        // pvOfFreeCashFlow3 = futureFreeCashFlow3 / Math.pow((1 + discountRate), 4)
        return pvOfFreeCashFlow3;
    }

    public BigDecimal getPvOfFreeCashFlow4() {
        // pvOfFreeCashFlow4 = futureFreeCashFlow4 / Math.pow((1 + discountRate), 5)
        return pvOfFreeCashFlow4;
    }

    public BigDecimal getPvOfFreeCashFlow5() {
        // pvOfFreeCashFlow5 = futureFreeCashFlow5 / Math.pow((1 + discountRate), 6)
        return pvOfFreeCashFlow5;
    }

    public BigDecimal getPvOfFreeCashFlow6() {
        // pvOfFreeCashFlow6 = futureFreeCashFlow6 / Math.pow((1 + discountRate), 7)
        return pvOfFreeCashFlow6;
    }

    public BigDecimal getPvOfFreeCashFlow7() {
        // pvOfFreeCashFlow7 = futureFreeCashFlow7 / Math.pow((1 + discountRate), 8)
        return pvOfFreeCashFlow7;
    }


    public BigDecimal getSumPvOfFcf() {
        // vypocet (viz nize)
        return sumPvOfFcf;
    }

    public BigDecimal getEquityValue() {
        // equityValue = sumPvOfFcf + cash - totalDebt
        return equityValue;
    }

    public BigDecimal getDcfWithoutMarginOfSafety() {
        // dcfWithoutMarginOfSafety = equityValue / sharesOutstanding
        return dcfWithoutMarginOfSafety;
    }

    public BigDecimal getDcfWithMarginOfSafety() {
        return dcfWithMarginOfSafety;
    }
}

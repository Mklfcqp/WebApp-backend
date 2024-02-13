package com.webapp.watchlist;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WatchlistAddCalcRequest {

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

    private BigDecimal freeCashFlow0;
    private BigDecimal freeCashFlow1;
    private BigDecimal freeCashFlow2;
    private BigDecimal freeCashFlow3;
    private BigDecimal freeCashFlow4;
    private BigDecimal freeCashFlow5;

    private BigDecimal growth0;
    private BigDecimal growth1;
    private BigDecimal growth2;
    private BigDecimal growth3;
    private BigDecimal growth4;

    private BigDecimal growthRate;
    private BigDecimal avgGrowthRate;

    private BigDecimal futureFreeCashFlow0;
    private BigDecimal futureFreeCashFlow1;
    private BigDecimal futureFreeCashFlow2;
    private BigDecimal futureFreeCashFlow3;
    private BigDecimal futureFreeCashFlow4;
    private BigDecimal futureFreeCashFlow5;
    private BigDecimal futureFreeCashFlow6;

    private BigDecimal terminalValue;

    private BigDecimal pvOfFreeCashFlow0;
    private BigDecimal pvOfFreeCashFlow1;
    private BigDecimal pvOfFreeCashFlow2;
    private BigDecimal pvOfFreeCashFlow3;
    private BigDecimal pvOfFreeCashFlow4;
    private BigDecimal pvOfFreeCashFlow5;
    private BigDecimal pvOfFreeCashFlow6;
    private BigDecimal pvOfFreeCashFlow7;

    private BigDecimal perpetualGrowthRate;
    private BigDecimal discountRate;

    private BigDecimal sumPvOfFcf;
    private BigDecimal cash;
    private BigDecimal totalDebt;

    private BigDecimal equityValue;
    private BigDecimal sharesOutstanding;

    private BigDecimal dcfWithoutMarginOfSafety;
    private BigDecimal dcfWithMarginOfSafety;


    public BigDecimal getDividendY() {
        BigDecimal value = dividendQ.multiply(BigDecimal.valueOf(4));
        dividendY = value.setScale(3, RoundingMode.HALF_UP);
        return dividendY;
    }

    public BigDecimal getDividendYield() {
        BigDecimal value = (dividendY.divide(price, 3, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100));
        dividendYield = value.setScale(3, RoundingMode.HALF_UP);
        return dividendYield;
    }

    public BigDecimal getGrowth0() {
        if (freeCashFlow1.compareTo(BigDecimal.ZERO) == 0) {
            growth0 = BigDecimal.ZERO;
        } else {
            BigDecimal value = (freeCashFlow0.subtract(freeCashFlow1)).divide(freeCashFlow1, 3, RoundingMode.HALF_UP);
            growth0 = value.setScale(3, RoundingMode.HALF_UP);
        }
        return growth0;
    }

    public BigDecimal getGrowth1() {
        if (freeCashFlow2.compareTo(BigDecimal.ZERO) == 0) {
            growth1 = BigDecimal.ZERO;
        } else {
            BigDecimal value = (freeCashFlow1.subtract(freeCashFlow2)).divide(freeCashFlow2, 3, RoundingMode.HALF_UP);
            growth1 = value.setScale(3, RoundingMode.HALF_UP);
        }
        return growth1;
    }

    public BigDecimal getGrowth2() {
        if (freeCashFlow3.compareTo(BigDecimal.ZERO) == 0) {
            growth2 = BigDecimal.ZERO;
        } else {
            BigDecimal value = (freeCashFlow2.subtract(freeCashFlow3)).divide(freeCashFlow3, 3, RoundingMode.HALF_UP);
            growth2 = value.setScale(3, RoundingMode.HALF_UP);
        }
        return growth2;
    }

    public BigDecimal getGrowth3() {
        if (freeCashFlow4.compareTo(BigDecimal.ZERO) == 0) {
            growth3 = BigDecimal.ZERO;
        } else {
            BigDecimal value = (freeCashFlow3.subtract(freeCashFlow4)).divide(freeCashFlow4, 3, RoundingMode.HALF_UP);
            growth3 = value.setScale(3, RoundingMode.HALF_UP);
        }
        return growth3;
    }

    public BigDecimal getGrowth4() {
        if (freeCashFlow5.compareTo(BigDecimal.ZERO) == 0) {
            growth4 = BigDecimal.ZERO;
        } else {
            BigDecimal value = (freeCashFlow4.subtract(freeCashFlow5)).divide(freeCashFlow5, 3, RoundingMode.HALF_UP);
            growth4 = value.setScale(3, RoundingMode.HALF_UP);
        }
        return growth4;
    }


    public BigDecimal getAvgGrowthRate() {
        BigDecimal[] growthValues = {growth0, growth1, growth2, growth3, growth4};

        int count = 0;
        BigDecimal sum = BigDecimal.ZERO;

        for (BigDecimal value : growthValues) {
            if (value.compareTo(BigDecimal.ZERO) != 0) {
                sum = sum.add(value);
                count++;
            }
        }

        if (count != 0) {
            avgGrowthRate = sum.divide(BigDecimal.valueOf(count), 3, RoundingMode.HALF_UP);
        } else {
            avgGrowthRate = BigDecimal.ZERO;
        }

        return avgGrowthRate;
    }

    public BigDecimal getFutureFreeCashFlow0() {
        BigDecimal value = freeCashFlow0.multiply((BigDecimal.valueOf(1).add(growthRate.divide(BigDecimal.valueOf(100)))));
        futureFreeCashFlow0 = value.setScale(3, RoundingMode.HALF_UP);
        return futureFreeCashFlow0;
    }

    public BigDecimal getFutureFreeCashFlow1() {
        BigDecimal value = futureFreeCashFlow0.multiply((BigDecimal.valueOf(1).add(growthRate.divide(BigDecimal.valueOf(100)))));
        futureFreeCashFlow1 = value.setScale(3, RoundingMode.HALF_UP);
        return futureFreeCashFlow1;
    }

    public BigDecimal getFutureFreeCashFlow2() {
        BigDecimal value = futureFreeCashFlow1.multiply((BigDecimal.valueOf(1).add(growthRate.divide(BigDecimal.valueOf(100)))));
        futureFreeCashFlow2 = value.setScale(3, RoundingMode.HALF_UP);
        return futureFreeCashFlow2;
    }

    public BigDecimal getFutureFreeCashFlow3() {
        BigDecimal value = futureFreeCashFlow2.multiply((BigDecimal.valueOf(1).add(growthRate.divide(BigDecimal.valueOf(100)))));
        futureFreeCashFlow3 = value.setScale(3, RoundingMode.HALF_UP);
        return futureFreeCashFlow3;
    }

    public BigDecimal getFutureFreeCashFlow4() {
        BigDecimal value = futureFreeCashFlow3.multiply((BigDecimal.valueOf(1).add(growthRate.divide(BigDecimal.valueOf(100)))));
        futureFreeCashFlow4 = value.setScale(3, RoundingMode.HALF_UP);
        return futureFreeCashFlow4;
    }

    public BigDecimal getFutureFreeCashFlow5() {
        BigDecimal value = futureFreeCashFlow4.multiply((BigDecimal.valueOf(1).add(growthRate.divide(BigDecimal.valueOf(100)))));
        futureFreeCashFlow5 = value.setScale(3, RoundingMode.HALF_UP);
        return futureFreeCashFlow5;
    }

    public BigDecimal getFutureFreeCashFlow6() {
        BigDecimal value = futureFreeCashFlow5.multiply((BigDecimal.valueOf(1).add(growthRate.divide(BigDecimal.valueOf(100)))));
        futureFreeCashFlow6 = value.setScale(3, RoundingMode.HALF_UP);
        return futureFreeCashFlow6;
    }

    public BigDecimal getTerminalValue() {
        BigDecimal value = futureFreeCashFlow6.multiply((BigDecimal.valueOf(1).add(perpetualGrowthRate.divide(BigDecimal.valueOf(100)))))
                .divide((discountRate.divide(BigDecimal.valueOf(100)).subtract(perpetualGrowthRate.divide(BigDecimal.valueOf(100)))), 3, RoundingMode.HALF_UP);
        terminalValue = value.setScale(3, RoundingMode.HALF_UP);
        return terminalValue;
    }

    public BigDecimal getPvOfFreeCashFlow0() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate.divide(BigDecimal.valueOf(100)));
        BigDecimal denominatorPowered = denominator.pow(1);
        BigDecimal value = futureFreeCashFlow0.divide(denominatorPowered, 3, RoundingMode.HALF_UP);
        pvOfFreeCashFlow0 = value.setScale(3, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow0;
    }

    public BigDecimal getPvOfFreeCashFlow1() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate.divide(BigDecimal.valueOf(100)));
        BigDecimal denominatorPowered = denominator.pow(2);
        BigDecimal value = futureFreeCashFlow1.divide(denominatorPowered, 3, RoundingMode.HALF_UP);
        pvOfFreeCashFlow1 = value.setScale(3, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow1;
    }

    public BigDecimal getPvOfFreeCashFlow2() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate.divide(BigDecimal.valueOf(100)));
        BigDecimal denominatorPowered = denominator.pow(3);
        BigDecimal value = futureFreeCashFlow2.divide(denominatorPowered, 3, RoundingMode.HALF_UP);
        pvOfFreeCashFlow2 = value.setScale(3, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow2;
    }

    public BigDecimal getPvOfFreeCashFlow3() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate.divide(BigDecimal.valueOf(100)));
        BigDecimal denominatorPowered = denominator.pow(4);
        BigDecimal value = futureFreeCashFlow3.divide(denominatorPowered, 3, RoundingMode.HALF_UP);
        pvOfFreeCashFlow3 = value.setScale(3, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow3;
    }

    public BigDecimal getPvOfFreeCashFlow4() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate.divide(BigDecimal.valueOf(100)));
        BigDecimal denominatorPowered = denominator.pow(5);
        BigDecimal value = futureFreeCashFlow4.divide(denominatorPowered, 3, RoundingMode.HALF_UP);
        pvOfFreeCashFlow4 = value.setScale(3, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow4;
    }

    public BigDecimal getPvOfFreeCashFlow5() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate.divide(BigDecimal.valueOf(100)));
        BigDecimal denominatorPowered = denominator.pow(6);
        BigDecimal value = futureFreeCashFlow5.divide(denominatorPowered, 3, RoundingMode.HALF_UP);
        pvOfFreeCashFlow5 = value.setScale(3, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow5;
    }

    public BigDecimal getPvOfFreeCashFlow6() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate.divide(BigDecimal.valueOf(100)));
        BigDecimal denominatorPowered = denominator.pow(7);
        BigDecimal value = futureFreeCashFlow6.divide(denominatorPowered, 3, RoundingMode.HALF_UP);
        pvOfFreeCashFlow6 = value.setScale(3, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow6;
    }

    public BigDecimal getPvOfFreeCashFlow7() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate.divide(BigDecimal.valueOf(100)));
        BigDecimal denominatorPowered = denominator.pow(8);
        BigDecimal value = terminalValue.divide(denominatorPowered, 3, RoundingMode.HALF_UP);
        pvOfFreeCashFlow7 = value.setScale(3, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow7;
    }

    public BigDecimal getSumPvOfFcf() {
        BigDecimal[] growthValues = {pvOfFreeCashFlow0, pvOfFreeCashFlow1, pvOfFreeCashFlow2, pvOfFreeCashFlow3, pvOfFreeCashFlow4,
                pvOfFreeCashFlow5, pvOfFreeCashFlow6, pvOfFreeCashFlow7};

        BigDecimal sum = BigDecimal.ZERO;

        for (BigDecimal value : growthValues) {
            sum = sum.add(value);
        }
        sumPvOfFcf = sum;

        return sumPvOfFcf;

    }

    public BigDecimal getEquityValue() {
        BigDecimal value = sumPvOfFcf.add(cash).subtract(totalDebt);
        equityValue = value.setScale(3, RoundingMode.HALF_UP);
        return equityValue;
    }

    public BigDecimal getDcfWithoutMarginOfSafety() {
        BigDecimal value = equityValue.divide(sharesOutstanding, 3,RoundingMode.HALF_UP);
        this.dcfWithoutMarginOfSafety = value.setScale(2, RoundingMode.HALF_UP);
        return this.dcfWithoutMarginOfSafety;
    }



    public BigDecimal getDcfWithMarginOfSafety() {
        BigDecimal value = dcfWithoutMarginOfSafety.multiply(BigDecimal.valueOf(0.8));
        dcfWithMarginOfSafety = value.setScale(2, RoundingMode.HALF_UP);
        return dcfWithMarginOfSafety;
    }



    public String getOverValuedUnderValued() {
        BigDecimal value = (((price.divide(dcfWithMarginOfSafety, 3,
                RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100))).subtract(BigDecimal.valueOf(100)));

        if(value.compareTo(BigDecimal.ZERO) < 0) {
            value = value.abs();
            return overValuedUnderValued = value.setScale(0, RoundingMode.HALF_UP) + " %"
                    + " Undervalued";
        } else if(value.compareTo(BigDecimal.ZERO) > 0) {
            return overValuedUnderValued = value.setScale(0, RoundingMode.HALF_UP) + " %"
                    + " Overvalued";
        } else {
            return overValuedUnderValued = "0 %";
        }
    }


    public void calculateDCF() {
        getDividendY();
        getDividendYield();
        getGrowth0();
        getGrowth1();
        getGrowth2();
        getGrowth3();
        getGrowth4();
        getAvgGrowthRate();
        getFutureFreeCashFlow0();
        getFutureFreeCashFlow1();
        getFutureFreeCashFlow2();
        getFutureFreeCashFlow3();
        getFutureFreeCashFlow4();
        getFutureFreeCashFlow5();
        getFutureFreeCashFlow6();
        getTerminalValue();
        getPvOfFreeCashFlow0();
        getPvOfFreeCashFlow1();
        getPvOfFreeCashFlow2();
        getPvOfFreeCashFlow3();
        getPvOfFreeCashFlow4();
        getPvOfFreeCashFlow5();
        getPvOfFreeCashFlow6();
        getPvOfFreeCashFlow7();
        getSumPvOfFcf();
        getEquityValue();
        getDcfWithoutMarginOfSafety();
        getDcfWithMarginOfSafety();
        getOverValuedUnderValued();
    }
}




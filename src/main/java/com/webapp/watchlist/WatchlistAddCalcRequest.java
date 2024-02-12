package com.webapp.watchlist;

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
        BigDecimal value = (dividendY.divide(price, 2, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100));
        dividendYield = value.setScale(2, RoundingMode.HALF_UP);
        return dividendYield;
    }


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


    public BigDecimal getAvgGrowthRate() {
        BigDecimal[] growthValues = {growth0, growth1, growth2, growth3, growth4};

        int count = growthValues.length;

        BigDecimal sum = BigDecimal.ZERO;

        for (BigDecimal value : growthValues) {
            sum = sum.add(value);
        }

        if (count != 0) {
            avgGrowthRate = sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
        } else {
            avgGrowthRate = BigDecimal.ZERO;
        }

        return avgGrowthRate;
    }

    public BigDecimal getFutureFreeCashFlow0() {
        futureFreeCashFlow0 = freeCashFlow0.multiply((BigDecimal.valueOf(1).add(growthRate)));
        return futureFreeCashFlow0;
    }

    public BigDecimal getFutureFreeCashFlow1() {
        futureFreeCashFlow1 = futureFreeCashFlow0.multiply((BigDecimal.valueOf(1).add(growthRate)));
        return futureFreeCashFlow1;
    }

    public BigDecimal getFutureFreeCashFlow2() {
        futureFreeCashFlow2 = futureFreeCashFlow1.multiply((BigDecimal.valueOf(1).add(growthRate)));
        return futureFreeCashFlow2;
    }

    public BigDecimal getFutureFreeCashFlow3() {
        futureFreeCashFlow3 = futureFreeCashFlow2.multiply((BigDecimal.valueOf(1).add(growthRate)));
        return futureFreeCashFlow3;
    }

    public BigDecimal getFutureFreeCashFlow4() {
        futureFreeCashFlow4 = futureFreeCashFlow3.multiply((BigDecimal.valueOf(1).add(growthRate)));
        return futureFreeCashFlow4;
    }

    public BigDecimal getFutureFreeCashFlow5() {
        futureFreeCashFlow5 = futureFreeCashFlow4.multiply((BigDecimal.valueOf(1).add(growthRate)));
        return futureFreeCashFlow5;
    }

    public BigDecimal getFutureFreeCashFlow6() {
        futureFreeCashFlow6 = futureFreeCashFlow5.multiply((BigDecimal.valueOf(1).add(growthRate)));
        return futureFreeCashFlow6;
    }

    public BigDecimal getTerminalValue() {
        terminalValue = futureFreeCashFlow6.multiply(BigDecimal.valueOf(1).add(perpetualGrowthRate))
                .divide((discountRate.subtract(perpetualGrowthRate)), 2, RoundingMode.HALF_UP);
        return terminalValue;
    }

    public BigDecimal getPvOfFreeCashFlow0() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate);
        BigDecimal denominatorPowered = denominator.pow(1);
        pvOfFreeCashFlow0 = futureFreeCashFlow0.divide(denominatorPowered, 2, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow0;
    }

    public BigDecimal getPvOfFreeCashFlow1() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate);
        BigDecimal denominatorPowered = denominator.pow(2);
        pvOfFreeCashFlow1 = futureFreeCashFlow1.divide(denominatorPowered, 2, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow1;
    }

    public BigDecimal getPvOfFreeCashFlow2() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate);
        BigDecimal denominatorPowered = denominator.pow(3);
        pvOfFreeCashFlow2 = futureFreeCashFlow2.divide(denominatorPowered, 2, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow2;
    }

    public BigDecimal getPvOfFreeCashFlow3() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate);
        BigDecimal denominatorPowered = denominator.pow(4);
        pvOfFreeCashFlow3 = futureFreeCashFlow3.divide(denominatorPowered, 2, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow3;
    }

    public BigDecimal getPvOfFreeCashFlow4() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate);
        BigDecimal denominatorPowered = denominator.pow(5);
        pvOfFreeCashFlow4 = futureFreeCashFlow4.divide(denominatorPowered, 2, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow4;
    }

    public BigDecimal getPvOfFreeCashFlow5() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate);
        BigDecimal denominatorPowered = denominator.pow(6);
        pvOfFreeCashFlow5 = futureFreeCashFlow5.divide(denominatorPowered, 2, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow5;
    }

    public BigDecimal getPvOfFreeCashFlow6() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate);
        BigDecimal denominatorPowered = denominator.pow(7);
        pvOfFreeCashFlow6 = futureFreeCashFlow6.divide(denominatorPowered, 2, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow6;
    }
    public BigDecimal getPvOfFreeCashFlow7() {
        BigDecimal denominator = BigDecimal.valueOf(1).add(discountRate);
        BigDecimal denominatorPowered = denominator.pow(8);
        pvOfFreeCashFlow7 = terminalValue.divide(denominatorPowered, 2, RoundingMode.HALF_UP);
        return pvOfFreeCashFlow7;
    }


    public BigDecimal getSumPvOfFcf() {
        BigDecimal[] growthValues = {pvOfFreeCashFlow1, pvOfFreeCashFlow2, pvOfFreeCashFlow3, pvOfFreeCashFlow4,
                pvOfFreeCashFlow5, pvOfFreeCashFlow6, pvOfFreeCashFlow7};

        int count = growthValues.length;

        BigDecimal sum = BigDecimal.ZERO;

        for (BigDecimal value : growthValues) {
            sum = sum.add(value);
        }
        sumPvOfFcf = sum;

        return sumPvOfFcf;

    }

    public BigDecimal getEquityValue() {
        equityValue = sumPvOfFcf.add(cash).subtract(totalDebt);
        return equityValue;
    }

    public BigDecimal getDcfWithoutMarginOfSafety() {
        dcfWithoutMarginOfSafety = equityValue.divide(sharesOutstanding, 2, RoundingMode.HALF_UP);
        return dcfWithoutMarginOfSafety;
    }

    public BigDecimal getDcfWithMarginOfSafety() {
        dcfWithMarginOfSafety = dcfWithoutMarginOfSafety.multiply(BigDecimal.valueOf(0.8));
        return dcfWithMarginOfSafety;
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

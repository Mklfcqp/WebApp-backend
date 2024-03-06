package com.webapp.watchlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WatchlistAddCalcRequestTest {

    private WatchlistAddCalcRequest watchlistAddCalcRequest;

    @BeforeEach
    void setUp() {
        watchlistAddCalcRequest = new WatchlistAddCalcRequest();
    }

    @Test
    void testGetDividendYWithInteger() {
        // Given
        watchlistAddCalcRequest.setDividendQ(BigDecimal.valueOf(2.5));

        // When
        BigDecimal result = watchlistAddCalcRequest.getDividendY();

        // Then
        assertEquals(BigDecimal.valueOf(10.000).setScale(3), result);
    }

    @Test
    void testGetDividendYWithDecimal() {
        // Given
        watchlistAddCalcRequest.setDividendQ(BigDecimal.valueOf(1.07));

        // When
        BigDecimal result = watchlistAddCalcRequest.getDividendY();

        // Then
        assertEquals(BigDecimal.valueOf(4.280).setScale(3), result);
    }

    @Test
    void testGetDividendYRouding() {
        // Given
        watchlistAddCalcRequest.setDividendQ(BigDecimal.valueOf(2.031425));

        // When
        BigDecimal result = watchlistAddCalcRequest.getDividendY();

        // Then
        assertEquals(BigDecimal.valueOf(8.126).setScale(3), result);
    }

    @Test
    void testGetDividendYWithZero() {
        // Given
        watchlistAddCalcRequest.setDividendQ(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getDividendY();

        // Then
        assertEquals(BigDecimal.valueOf(0.000).setScale(3), result);
    }

    @Test
    void testGetDividendYield() {
        // Given
        watchlistAddCalcRequest.setDividendY(BigDecimal.valueOf(10));
        watchlistAddCalcRequest.setPrice(BigDecimal.valueOf(100));

        // When
        BigDecimal result = watchlistAddCalcRequest.getDividendYield();

        // Then
        assertEquals(BigDecimal.valueOf(10.00).setScale(2), result);
    }

    @Test
    void getGrowth0() {
        // Given
        watchlistAddCalcRequest.setFreeCashFlow0(BigDecimal.valueOf(528.3));
        watchlistAddCalcRequest.setFreeCashFlow1(BigDecimal.valueOf(400));

        // When
        BigDecimal result = watchlistAddCalcRequest.getGrowth0();

        // Then
        assertEquals(BigDecimal.valueOf(0.321).setScale(3), result);
    }

    @Test
    void getGrowth1() {
        // Given
        watchlistAddCalcRequest.setFreeCashFlow1(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setFreeCashFlow2(BigDecimal.valueOf(400));

        // When
        BigDecimal result = watchlistAddCalcRequest.getGrowth1();

        // Then
        assertEquals(BigDecimal.valueOf(-1.000).setScale(3), result);
    }

    @Test
    void getGrowth2() {
        // Given
        watchlistAddCalcRequest.setFreeCashFlow2(BigDecimal.valueOf(400));
        watchlistAddCalcRequest.setFreeCashFlow3(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getGrowth2();

        // Then
        assertEquals(BigDecimal.valueOf(0), result);
    }

    @Test
    void getGrowth3() {
        // Given
        watchlistAddCalcRequest.setFreeCashFlow3(BigDecimal.valueOf(300));
        watchlistAddCalcRequest.setFreeCashFlow4(BigDecimal.valueOf(-400));

        // When
        BigDecimal result = watchlistAddCalcRequest.getGrowth3();

        // Then
        assertEquals(BigDecimal.valueOf(-1.750).setScale(3), result);
    }

    @Test
    void getGrowth4() {
        // Given
        watchlistAddCalcRequest.setFreeCashFlow4(BigDecimal.valueOf(-400));
        watchlistAddCalcRequest.setFreeCashFlow5(BigDecimal.valueOf(300));

        // When
        BigDecimal result = watchlistAddCalcRequest.getGrowth4();

        // Then
        assertEquals(BigDecimal.valueOf(-2.333).setScale(3), result);
    }

    @Test
    void getAvgGrowthRateValues3() {
        // Given
        watchlistAddCalcRequest.setGrowth0(BigDecimal.valueOf(1.5));
        watchlistAddCalcRequest.setGrowth1(BigDecimal.valueOf(2.3));
        watchlistAddCalcRequest.setGrowth2(BigDecimal.valueOf(0.8));
        watchlistAddCalcRequest.setGrowth3(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setGrowth4(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getAvgGrowthRate();

        // Then
        assertEquals(BigDecimal.valueOf(1.533).setScale(3), result);

    }

    @Test
    void getAvgGrowthRateValues0() {
        // Given
        watchlistAddCalcRequest.setGrowth0(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setGrowth1(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setGrowth2(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setGrowth3(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setGrowth4(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getAvgGrowthRate();

        // Then
        assertEquals(BigDecimal.valueOf(0), result);

    }


    @Test
    void getAvgGrowthRateValuesMinus() {
        // Given
        watchlistAddCalcRequest.setGrowth0(BigDecimal.valueOf(-1.5));
        watchlistAddCalcRequest.setGrowth1(BigDecimal.valueOf(2.3));
        watchlistAddCalcRequest.setGrowth2(BigDecimal.valueOf(0.8));
        watchlistAddCalcRequest.setGrowth3(BigDecimal.valueOf(-0.6));
        watchlistAddCalcRequest.setGrowth4(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getAvgGrowthRate();

        // Then
        assertEquals(BigDecimal.valueOf(0.250).setScale(3), result);

    }


    @Test
    void getAvgGrowthRateMinus() {
        // Given
        watchlistAddCalcRequest.setGrowth0(BigDecimal.valueOf(-1.5));
        watchlistAddCalcRequest.setGrowth1(BigDecimal.valueOf(-2.3));
        watchlistAddCalcRequest.setGrowth2(BigDecimal.valueOf(-0.8));
        watchlistAddCalcRequest.setGrowth3(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setGrowth4(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getAvgGrowthRate();

        // Then
        assertEquals(BigDecimal.valueOf(-1.533).setScale(3), result);
    }

    @Test
    void getFutureFreeCashFlow0() {
        // Given
        watchlistAddCalcRequest.setFreeCashFlow0(BigDecimal.valueOf(100));
        watchlistAddCalcRequest.setGrowthRate(BigDecimal.valueOf(15));

        // When
        BigDecimal result = watchlistAddCalcRequest.getFutureFreeCashFlow0();

        // Then
        assertEquals(BigDecimal.valueOf(115.000).setScale(3), result);
    }

    @Test
    void getFutureFreeCashFlow1() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow0(BigDecimal.valueOf(-115));
        watchlistAddCalcRequest.setGrowthRate(BigDecimal.valueOf(15));

        // When
        BigDecimal result = watchlistAddCalcRequest.getFutureFreeCashFlow1();

        // Then
        assertEquals(BigDecimal.valueOf(-132.250).setScale(3), result);
    }

    @Test
    void getFutureFreeCashFlow2() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow1(BigDecimal.valueOf(-115));
        watchlistAddCalcRequest.setGrowthRate(BigDecimal.valueOf(-10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getFutureFreeCashFlow2();

        // Then
        assertEquals(BigDecimal.valueOf(-103.500).setScale(3), result);
    }

    @Test
    void getFutureFreeCashFlow3() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow2(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setGrowthRate(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getFutureFreeCashFlow3();

        // Then
        assertEquals(BigDecimal.valueOf(0.000).setScale(3), result);
    }

    @Test
    void getFutureFreeCashFlow4() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow3(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setGrowthRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getFutureFreeCashFlow4();

        // Then
        assertEquals(BigDecimal.valueOf(0.000).setScale(3), result);
    }

    @Test
    void getFutureFreeCashFlow5() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow4(BigDecimal.valueOf(-100));
        watchlistAddCalcRequest.setGrowthRate(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getFutureFreeCashFlow5();

        // Then
        assertEquals(BigDecimal.valueOf(-100.000).setScale(3), result);
    }

    @Test
    void getFutureFreeCashFlow6() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow5(BigDecimal.valueOf(100));
        watchlistAddCalcRequest.setGrowthRate(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getFutureFreeCashFlow6();

        // Then
        assertEquals(BigDecimal.valueOf(100.000).setScale(3), result);
    }

    @Test
    void getTerminalValue() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow6(BigDecimal.valueOf(120));
        watchlistAddCalcRequest.setPerpetualGrowthRate(BigDecimal.valueOf(2.5));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getTerminalValue();

        // Then
        assertEquals(BigDecimal.valueOf(1640.000).setScale(3), result);
    }

    @Test
    void getTerminalValueFFCF0() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow6(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setPerpetualGrowthRate(BigDecimal.valueOf(2.5));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getTerminalValue();

        // Then
        assertEquals(BigDecimal.valueOf(0.000).setScale(3), result);
    }

    @Test
    void getTerminalValuePGR0() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow6(BigDecimal.valueOf(120));
        watchlistAddCalcRequest.setPerpetualGrowthRate(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getTerminalValue();

        // Then
        assertEquals(BigDecimal.valueOf(1200.000).setScale(3), result);
    }

    @Test
    void getTerminalValueDR0() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow6(BigDecimal.valueOf(120));
        watchlistAddCalcRequest.setPerpetualGrowthRate(BigDecimal.valueOf(2.5));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getTerminalValue();

        // Then
        assertEquals(BigDecimal.valueOf(-4920.000).setScale(3), result);
    }

    @Test
    void getTerminalValueFFCFMinus() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow6(BigDecimal.valueOf(-120));
        watchlistAddCalcRequest.setPerpetualGrowthRate(BigDecimal.valueOf(2.5));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getTerminalValue();

        // Then
        assertEquals(BigDecimal.valueOf(-1640.000).setScale(3), result);
    }

    @Test
    void getPvOfFreeCashFlow0() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow0(BigDecimal.valueOf(115));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getPvOfFreeCashFlow0();

        // Then
        assertEquals(BigDecimal.valueOf(104.545).setScale(3), result);
    }

    @Test
    void getPvOfFreeCashFlow1() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow1(BigDecimal.valueOf(-132.250));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getPvOfFreeCashFlow1();

        // Then
        assertEquals(BigDecimal.valueOf(-109.298).setScale(3), result);
    }

    @Test
    void getPvOfFreeCashFlow2() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow2(BigDecimal.valueOf(-103.500));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getPvOfFreeCashFlow2();

        // Then
        assertEquals(BigDecimal.valueOf(-77.761).setScale(3), result);
    }

    // if(futureFreeCashFlow3 = BigDecimal.ZERO) {getPvOfFreeCashFlow3 = BigDecimal.ZERO} - pro vsechny PvOfFreeCashFlow
    @Test
    void getPvOfFreeCashFlow3() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow3(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getPvOfFreeCashFlow3();

        // Then
        assertEquals(BigDecimal.valueOf(0.000).setScale(3), result);
    }

    @Test
    void getPvOfFreeCashFlow4() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow4(BigDecimal.valueOf(100));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getPvOfFreeCashFlow4();

        // Then
        assertEquals(BigDecimal.valueOf(0.000).setScale(3), result);
    }

    @Test
    void getPvOfFreeCashFlow5() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow5(BigDecimal.valueOf(98));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getPvOfFreeCashFlow5();

        // Then
        assertEquals(BigDecimal.valueOf(55.318).setScale(3), result);
    }

    @Test
    void getPvOfFreeCashFlow6() {
        // Given
        watchlistAddCalcRequest.setFutureFreeCashFlow6(BigDecimal.valueOf(200));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getPvOfFreeCashFlow6();

        // Then
        assertEquals(BigDecimal.valueOf(102.632).setScale(3), result);
    }

    @Test
    void getPvOfFreeCashFlow7() {
        // Given
        watchlistAddCalcRequest.setTerminalValue(BigDecimal.valueOf(150));
        watchlistAddCalcRequest.setDiscountRate(BigDecimal.valueOf(10));

        // When
        BigDecimal result = watchlistAddCalcRequest.getPvOfFreeCashFlow7();

        // Then
        assertEquals(BigDecimal.valueOf(69.976).setScale(3), result);
    }

    @Test
    void getSumPvOfFcf() {
        // Given
        watchlistAddCalcRequest.setPvOfFreeCashFlow0(BigDecimal.valueOf(5));
        watchlistAddCalcRequest.setPvOfFreeCashFlow1(BigDecimal.valueOf(-3.2));
        watchlistAddCalcRequest.setPvOfFreeCashFlow2(BigDecimal.valueOf(2));
        watchlistAddCalcRequest.setPvOfFreeCashFlow3(BigDecimal.valueOf(1.8));
        watchlistAddCalcRequest.setPvOfFreeCashFlow4(BigDecimal.valueOf(1.23));
        watchlistAddCalcRequest.setPvOfFreeCashFlow5(BigDecimal.valueOf(2.338));
        watchlistAddCalcRequest.setPvOfFreeCashFlow6(BigDecimal.valueOf(-2.01));
        watchlistAddCalcRequest.setPvOfFreeCashFlow7(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getSumPvOfFcf();

        // Then
        assertEquals(BigDecimal.valueOf(7.158).setScale(3), result);
    }

    @Test
    void getEquityValue() {
        // Given
        watchlistAddCalcRequest.setSumPvOfFcf(BigDecimal.valueOf(8));
        watchlistAddCalcRequest.setCash(BigDecimal.valueOf(100));
        watchlistAddCalcRequest.setTotalDebt(BigDecimal.valueOf(150));

        // When
        BigDecimal result = watchlistAddCalcRequest.getEquityValue();

        // Then
        assertEquals(BigDecimal.valueOf(-42.000).setScale(3), result);
    }

    @Test
    void getEquityValueCash0() {
        // Given
        watchlistAddCalcRequest.setSumPvOfFcf(BigDecimal.valueOf(8));
        watchlistAddCalcRequest.setCash(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setTotalDebt(BigDecimal.valueOf(150));

        // When
        BigDecimal result = watchlistAddCalcRequest.getEquityValue();

        // Then
        assertEquals(BigDecimal.valueOf(-142.000).setScale(3), result);
    }

    @Test
    void getEquityValueTotalDebt0() {
        // Given
        watchlistAddCalcRequest.setSumPvOfFcf(BigDecimal.valueOf(8));
        watchlistAddCalcRequest.setCash(BigDecimal.valueOf(100));
        watchlistAddCalcRequest.setTotalDebt(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddCalcRequest.getEquityValue();

        // Then
        assertEquals(BigDecimal.valueOf(108.000).setScale(3), result);
    }

    @Test
    void getDcfWithoutMarginOfSafety() {
        // Given
        watchlistAddCalcRequest.setEquityValue(BigDecimal.valueOf(323));
        watchlistAddCalcRequest.setSharesOutstanding(BigDecimal.valueOf(12.5));

        // When
        BigDecimal result = watchlistAddCalcRequest.getDcfWithoutMarginOfSafety();

        // Then
        assertEquals(BigDecimal.valueOf(25.84).setScale(2), result);
    }

    // if (getEquityValue = BigDecimal.ZERO) { dcfWithoutMarginOfSafety = BigDecimal.ZERO }
    @Test
    void getDcfWithoutMarginOfSafetyEquityValue0() {
        // Given
        watchlistAddCalcRequest.setEquityValue(BigDecimal.valueOf(0));
        watchlistAddCalcRequest.setSharesOutstanding(BigDecimal.valueOf(12.5));

        // When
        BigDecimal result = watchlistAddCalcRequest.getDcfWithoutMarginOfSafety();

        // Then
        assertEquals(BigDecimal.valueOf(0).setScale(2), result);
    }

    @Test
    void getDcfWithMarginOfSafety() {
        // Given
        watchlistAddCalcRequest.setDcfWithoutMarginOfSafety(BigDecimal.valueOf(120.3));

        // When
        BigDecimal result = watchlistAddCalcRequest.getDcfWithMarginOfSafety();

        // Then
        assertEquals(BigDecimal.valueOf(96.24).setScale(2), result);
    }

    @Test
    void getOverValuedUnderValued() {
    }
}
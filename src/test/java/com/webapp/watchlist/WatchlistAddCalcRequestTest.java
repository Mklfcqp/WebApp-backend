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
    }

    @Test
    void getPvOfFreeCashFlow1() {
    }

    @Test
    void getPvOfFreeCashFlow2() {
    }

    @Test
    void getPvOfFreeCashFlow3() {
    }

    @Test
    void getPvOfFreeCashFlow4() {
    }

    @Test
    void getPvOfFreeCashFlow5() {
    }

    @Test
    void getPvOfFreeCashFlow6() {
    }

    @Test
    void getPvOfFreeCashFlow7() {
    }

    @Test
    void getSumPvOfFcf() {
    }

    @Test
    void getEquityValue() {
    }

    @Test
    void getDcfWithoutMarginOfSafety() {
    }

    @Test
    void getDcfWithMarginOfSafety() {
    }

    @Test
    void getOverValuedUnderValued() {
    }
}
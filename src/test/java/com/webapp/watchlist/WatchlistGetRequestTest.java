package com.webapp.watchlist;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WatchlistGetRequestTest {

    private final WatchlistGetRequest watchlistGetRequest = new WatchlistGetRequest();

    @Test
    void getId() {
        Long expected = 1L;
        watchlistGetRequest.setId(expected);
        assertEquals(expected, watchlistGetRequest.getId());
    }

    @Test
    void getTicker() {
        String expected = "AAPL";
        watchlistGetRequest.setTicker(expected);
        assertEquals(expected, watchlistGetRequest.getTicker());
    }

    @Test
    void getCompany() {
        String expected = "Apple Inc.";
        watchlistGetRequest.setCompany(expected);
        assertEquals(expected, watchlistGetRequest.getCompany());
    }

    @Test
    void getPrice() {
        BigDecimal expected = BigDecimal.valueOf(100.50);
        watchlistGetRequest.setPrice(expected);
        assertEquals(expected, watchlistGetRequest.getPrice());
    }

    @Test
    void getCurrencyPrice() {
        String expected = "USD";
        watchlistGetRequest.setCurrencyPrice(expected);
        assertEquals(expected, watchlistGetRequest.getCurrencyPrice());
    }

    @Test
    void getCurrencyDcf() {
        String expected = "USD";
        watchlistGetRequest.setCurrencyDcf(expected);
        assertEquals(expected, watchlistGetRequest.getCurrencyDcf());
    }

    @Test
    void getDividendY() {
        BigDecimal expected = BigDecimal.valueOf(2.50);
        watchlistGetRequest.setDividendY(expected);
        assertEquals(expected, watchlistGetRequest.getDividendY());
    }

    @Test
    void getCurrencyDividendY() {
        String expected = "USD";
        watchlistGetRequest.setCurrencyDividendY(expected);
        assertEquals(expected, watchlistGetRequest.getCurrencyDividendY());
    }

    @Test
    void getDividendQ() {
        BigDecimal expected = BigDecimal.valueOf(0.50);
        watchlistGetRequest.setDividendQ(expected);
        assertEquals(expected, watchlistGetRequest.getDividendQ());
    }

    @Test
    void getCurrencyDividendQ() {
        String expected = "USD";
        watchlistGetRequest.setCurrencyDividendQ(expected);
        assertEquals(expected, watchlistGetRequest.getCurrencyDividendQ());
    }

    @Test
    void getDividendYield() {
        BigDecimal expected = BigDecimal.valueOf(2.5);
        watchlistGetRequest.setDividendYield(expected);
        assertEquals(expected, watchlistGetRequest.getDividendYield());
    }

    @Test
    void getOverValuedUnderValued() {
        String expected = "Undervalued";
        watchlistGetRequest.setOverValuedUnderValued(expected);
        assertEquals(expected, watchlistGetRequest.getOverValuedUnderValued());
    }

    @Test
    void getDcfWithMarginOfSafety() {
        BigDecimal expected = BigDecimal.valueOf(150.50);
        watchlistGetRequest.setDcfWithMarginOfSafety(expected);
        assertEquals(expected, watchlistGetRequest.getDcfWithMarginOfSafety());
    }

    @Test
    void getFreeCashFlow0() {
        BigDecimal expected = BigDecimal.valueOf(1000.50);
        watchlistGetRequest.setFreeCashFlow0(expected);
        assertEquals(expected, watchlistGetRequest.getFreeCashFlow0());
    }

    @Test
    void getFreeCashFlow1() {
        BigDecimal expected = BigDecimal.valueOf(1100.50);
        watchlistGetRequest.setFreeCashFlow1(expected);
        assertEquals(expected, watchlistGetRequest.getFreeCashFlow1());
    }

    @Test
    void getFreeCashFlow2() {
        BigDecimal expected = BigDecimal.valueOf(1200.50);
        watchlistGetRequest.setFreeCashFlow2(expected);
        assertEquals(expected, watchlistGetRequest.getFreeCashFlow2());
    }

    @Test
    void getFreeCashFlow3() {
        BigDecimal expected = BigDecimal.valueOf(1300.50);
        watchlistGetRequest.setFreeCashFlow3(expected);
        assertEquals(expected, watchlistGetRequest.getFreeCashFlow3());
    }

    @Test
    void getFreeCashFlow4() {
        BigDecimal expected = BigDecimal.valueOf(1400.50);
        watchlistGetRequest.setFreeCashFlow4(expected);
        assertEquals(expected, watchlistGetRequest.getFreeCashFlow4());
    }

    @Test
    void getFreeCashFlow5() {
        BigDecimal expected = BigDecimal.valueOf(1500.50);
        watchlistGetRequest.setFreeCashFlow5(expected);
        assertEquals(expected, watchlistGetRequest.getFreeCashFlow5());
    }

    @Test
    void getGrowthRate() {
        BigDecimal expected = BigDecimal.valueOf(0.05);
        watchlistGetRequest.setGrowthRate(expected);
        assertEquals(expected, watchlistGetRequest.getGrowthRate());
    }

    @Test
    void getPerpetualGrowthRate() {
        BigDecimal expected = BigDecimal.valueOf(0.02);
        watchlistGetRequest.setPerpetualGrowthRate(expected);
        assertEquals(expected, watchlistGetRequest.getPerpetualGrowthRate());
    }

    @Test
    void getDiscountRate() {
        BigDecimal expected = BigDecimal.valueOf(0.10);
        watchlistGetRequest.setDiscountRate(expected);
        assertEquals(expected, watchlistGetRequest.getDiscountRate());
    }

    @Test
    void getCash() {
        BigDecimal expected = BigDecimal.valueOf(5000.50);
        watchlistGetRequest.setCash(expected);
        assertEquals(expected, watchlistGetRequest.getCash());
    }

    @Test
    void getTotalDebt() {
        BigDecimal expected = BigDecimal.valueOf(10000.50);
        watchlistGetRequest.setTotalDebt(expected);
        assertEquals(expected, watchlistGetRequest.getTotalDebt());
    }

    @Test
    void getSharesOutstanding() {
        BigDecimal expected = BigDecimal.valueOf(1000000);
        watchlistGetRequest.setSharesOutstanding(expected);
        assertEquals(expected, watchlistGetRequest.getSharesOutstanding());
    }

}
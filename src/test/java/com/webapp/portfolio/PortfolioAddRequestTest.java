package com.webapp.portfolio;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioAddRequestTest {

    private PortfolioAddRequest portfolioAddRequest;
    @Before
    public void setUp() {
        portfolioAddRequest = new PortfolioAddRequest();
    }

    @Test
    public void testGetProfitLossBuySell() {
        portfolioAddRequest.setBuy(BigDecimal.valueOf(100.00));
        portfolioAddRequest.setSharesBuy(10);
        portfolioAddRequest.setSell(BigDecimal.valueOf(120.00));
        portfolioAddRequest.setSharesSell(10);
        portfolioAddRequest.setInterestBuySell(BigDecimal.valueOf(5.00));

        BigDecimal expected = BigDecimal.valueOf(15.00);
        BigDecimal result = portfolioAddRequest.getProfitLossBuySell();

        assertEquals(expected, result);
    }

    @Test
    public void testGetProfitLossBuySellWithZeroSharesSell() {
        portfolioAddRequest.setBuy(BigDecimal.valueOf(100.00));
        portfolioAddRequest.setSharesBuy(10);
        portfolioAddRequest.setSell(BigDecimal.valueOf(120.00));
        portfolioAddRequest.setSharesSell(0);
        portfolioAddRequest.setInterestBuySell(BigDecimal.valueOf(5.00));

        BigDecimal expected = BigDecimal.ZERO;
        BigDecimal result = portfolioAddRequest.getProfitLossBuySell();

        assertEquals(expected, result);
    }

    @Test
    public void testGetProfitLossDividend() {
        portfolioAddRequest.setDividend(BigDecimal.valueOf(50.00));
        portfolioAddRequest.setInterestDividend(BigDecimal.valueOf(5.00));

        BigDecimal expected = BigDecimal.valueOf(45.00);
        BigDecimal result = portfolioAddRequest.getProfitLossDividend();

        assertEquals(expected, result);
    }

    @Test
    public void testGetSumProfitLoss() {
        portfolioAddRequest.setBuy(BigDecimal.valueOf(100.00));
        portfolioAddRequest.setSharesBuy(10);
        portfolioAddRequest.setSell(BigDecimal.valueOf(120.00));
        portfolioAddRequest.setSharesSell(10);
        portfolioAddRequest.setInterestBuySell(BigDecimal.valueOf(5.00));
        portfolioAddRequest.setDividend(BigDecimal.valueOf(50.00));
        portfolioAddRequest.setInterestDividend(BigDecimal.valueOf(5.00));

        BigDecimal expected = BigDecimal.valueOf(60.00);
        BigDecimal result = portfolioAddRequest.getSumProfitLoss();

        assertEquals(expected, result);
    }

    @Test
    public void testGetSumProfitLossWithZero() {
        portfolioAddRequest.setBuy(BigDecimal.ZERO);
        portfolioAddRequest.setSharesBuy(0);
        portfolioAddRequest.setSell(BigDecimal.ZERO);
        portfolioAddRequest.setSharesSell(0);
        portfolioAddRequest.setInterestBuySell(BigDecimal.ZERO);
        portfolioAddRequest.setDividend(BigDecimal.ZERO);
        portfolioAddRequest.setInterestDividend(BigDecimal.ZERO);

        BigDecimal expected = BigDecimal.ZERO;
        BigDecimal result = portfolioAddRequest.getSumProfitLoss();

        assertEquals(expected, result);
    }

}
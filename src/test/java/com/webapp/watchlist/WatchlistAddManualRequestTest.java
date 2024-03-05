package com.webapp.watchlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class WatchlistAddManualRequestTest {

    private WatchlistAddManualRequest watchlistAddManualRequest;

    @BeforeEach
    void setUp() {
        watchlistAddManualRequest = new WatchlistAddManualRequest();
    }

    @Test
    void testGetDividendYWithInteger() {
        // Given
        watchlistAddManualRequest.setDividendQ(BigDecimal.valueOf(2.5));

        // When
        BigDecimal result = watchlistAddManualRequest.getDividendY();

        // Then
        assertEquals(BigDecimal.valueOf(10.000).setScale(3), result);
    }

    @Test
    void testGetDividendYWithDecimal() {
        // Given
        watchlistAddManualRequest.setDividendQ(BigDecimal.valueOf(1.07));

        // When
        BigDecimal result = watchlistAddManualRequest.getDividendY();

        // Then
        assertEquals(BigDecimal.valueOf(4.280).setScale(3), result);
    }

    @Test
    void testGetDividendYRouding() {
        // Given
        watchlistAddManualRequest.setDividendQ(BigDecimal.valueOf(2.031425));

        // When
        BigDecimal result = watchlistAddManualRequest.getDividendY();

        // Then
        assertEquals(BigDecimal.valueOf(8.126).setScale(3), result);
    }

    @Test
    void testGetDividendYWithZero() {
        // Given
        watchlistAddManualRequest.setDividendQ(BigDecimal.valueOf(0));

        // When
        BigDecimal result = watchlistAddManualRequest.getDividendY();

        // Then
        assertEquals(BigDecimal.valueOf(0.000).setScale(3), result);
    }

    @Test
    void testGetDividendYield() {
        // Given
        watchlistAddManualRequest.setDividendY(BigDecimal.valueOf(10));
        watchlistAddManualRequest.setPrice(BigDecimal.valueOf(100));

        // When
        BigDecimal result = watchlistAddManualRequest.getDividendYield();

        // Then
        assertEquals(BigDecimal.valueOf(10.00).setScale(2), result);
    }

    @Test
    void testGetOverValuedUnderValued() {
        // Given
        watchlistAddManualRequest.setPrice(BigDecimal.valueOf(100));
        watchlistAddManualRequest.setDcfWithMarginOfSafety(BigDecimal.valueOf(80));

        // When
        String result = watchlistAddManualRequest.getOverValuedUnderValued();

        // Then
        assertEquals("25 % Overvalued", result);
    }

}
package com.webapp.watchlist;

import com.webapp.user.User;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WatchlistMapperTest {

    private final WatchlistMapper watchlistMapper = new WatchlistMapper();

    @Test
    void toWatchlistGetRequest() {
        Watchlist watchlist = new Watchlist();

        watchlist.setId(1L);
        watchlist.setTicker("AAPL");
        watchlist.setCompany("Apple Inc.");
        watchlist.setPrice(BigDecimal.valueOf(134.98));
        watchlist.setCurrencyPrice("USD");

        WatchlistGetRequest watchlistGetRequest = watchlistMapper.toWatchlistGetRequest(watchlist);

        assertEquals(watchlist.getId(), watchlistGetRequest.getId());
        assertEquals(watchlist.getTicker(), watchlistGetRequest.getTicker());
        assertEquals(watchlist.getCompany(), watchlistGetRequest.getCompany());
        assertEquals(watchlist.getPrice(), watchlistGetRequest.getPrice());
        assertEquals(watchlist.getCurrencyPrice(), watchlistGetRequest.getCurrencyPrice());
    }

    @Test
    void watchlistAddManualRequestToWatchlist() {
        WatchlistAddManualRequest request = new WatchlistAddManualRequest();

        request.setId(1L);
        request.setTicker("AAPL");
        request.setCompany("Apple Inc.");
        request.setPrice(BigDecimal.valueOf(134.98));
        request.setCurrencyPrice("USD");

        User user = new User();

        Watchlist watchlist = watchlistMapper.WatchlistAddManualRequestToWatchlist(request, user);

        assertEquals(request.getId(), watchlist.getId());
        assertEquals(user, watchlist.getUser());
        assertEquals(request.getTicker(), watchlist.getTicker());
        assertEquals(request.getCompany(), watchlist.getCompany());
        assertEquals(request.getPrice(), watchlist.getPrice());
        assertEquals(request.getCurrencyPrice(), watchlist.getCurrencyPrice());
    }

    @Test
    void watchlistAddCalcRequestToWatchlist() {
        WatchlistAddCalcRequest request = new WatchlistAddCalcRequest();

        request.setId(1L);
        request.setTicker("AAPL");
        request.setCompany("Apple Inc.");
        request.setPrice(BigDecimal.valueOf(134.98));
        request.setCurrencyPrice("USD");

        User user = new User();

        Watchlist watchlist = watchlistMapper.WatchlistAddCalcRequestToWatchlist(request, user);

        assertEquals(request.getId(), watchlist.getId());
        assertEquals(user, watchlist.getUser());
        assertEquals(request.getTicker(), watchlist.getTicker());
        assertEquals(request.getCompany(), watchlist.getCompany());
        assertEquals(request.getPrice(), watchlist.getPrice());
        assertEquals(request.getCurrencyPrice(), watchlist.getCurrencyPrice());
        assertEquals(request.getDcfWithMarginOfSafety(), watchlist.getDcfWithMarginOfSafety());
        assertEquals(request.getCurrencyDcf(), watchlist.getCurrencyDcf());
        assertEquals(request.getDividendY(), watchlist.getDividendY());
        assertEquals(request.getCurrencyDividendY(), watchlist.getCurrencyDividendY());
        assertEquals(request.getDividendQ(), watchlist.getDividendQ());
        assertEquals(request.getCurrencyDividendQ(), watchlist.getCurrencyDividendQ());
        assertEquals(request.getDividendYield(), watchlist.getDividendYield());
        assertEquals(request.getOverValuedUnderValued(), watchlist.getOverValuedUnderValued());
        assertEquals(request.getFreeCashFlow0(), watchlist.getFreeCashFlow0());
        assertEquals(request.getFreeCashFlow1(), watchlist.getFreeCashFlow1());
        assertEquals(request.getFreeCashFlow2(), watchlist.getFreeCashFlow2());
        assertEquals(request.getFreeCashFlow3(), watchlist.getFreeCashFlow3());
        assertEquals(request.getFreeCashFlow4(), watchlist.getFreeCashFlow4());
        assertEquals(request.getFreeCashFlow5(), watchlist.getFreeCashFlow5());
        assertEquals(request.getGrowth0(), watchlist.getGrowth0());
        assertEquals(request.getGrowth1(), watchlist.getGrowth1());
        assertEquals(request.getGrowth2(), watchlist.getGrowth2());
        assertEquals(request.getGrowth3(), watchlist.getGrowth3());
        assertEquals(request.getGrowth4(), watchlist.getGrowth4());
        assertEquals(request.getGrowthRate(), watchlist.getGrowthRate());
        assertEquals(request.getAvgGrowthRate(), watchlist.getAvgGrowthRate());
        assertEquals(request.getFutureFreeCashFlow0(), watchlist.getFutureFreeCashFlow0());
        assertEquals(request.getFutureFreeCashFlow1(), watchlist.getFutureFreeCashFlow1());
        assertEquals(request.getFutureFreeCashFlow2(), watchlist.getFutureFreeCashFlow2());
        assertEquals(request.getFutureFreeCashFlow3(), watchlist.getFutureFreeCashFlow3());
        assertEquals(request.getFutureFreeCashFlow4(), watchlist.getFutureFreeCashFlow4());
        assertEquals(request.getFutureFreeCashFlow5(), watchlist.getFutureFreeCashFlow5());
        assertEquals(request.getFutureFreeCashFlow6(), watchlist.getFutureFreeCashFlow6());
        assertEquals(request.getTerminalValue(), watchlist.getTerminalValue());
        assertEquals(request.getPvOfFreeCashFlow0(), watchlist.getPvOfFreeCashFlow0());
        assertEquals(request.getPvOfFreeCashFlow1(), watchlist.getPvOfFreeCashFlow1());
        assertEquals(request.getPvOfFreeCashFlow2(), watchlist.getPvOfFreeCashFlow2());
        assertEquals(request.getPvOfFreeCashFlow3(), watchlist.getPvOfFreeCashFlow3());
        assertEquals(request.getPvOfFreeCashFlow4(), watchlist.getPvOfFreeCashFlow4());
        assertEquals(request.getPvOfFreeCashFlow5(), watchlist.getPvOfFreeCashFlow5());
        assertEquals(request.getPvOfFreeCashFlow6(), watchlist.getPvOfFreeCashFlow6());
        assertEquals(request.getPvOfFreeCashFlow7(), watchlist.getPvOfFreeCashFlow7());
        assertEquals(request.getPerpetualGrowthRate(), watchlist.getPerpetualGrowthRate());
        assertEquals(request.getDiscountRate(), watchlist.getDiscountRate());
        assertEquals(request.getSumPvOfFcf(), watchlist.getSumPvOfFcf());
        assertEquals(request.getCash(), watchlist.getCash());
        assertEquals(request.getTotalDebt(), watchlist.getTotalDebt());
        assertEquals(request.getEquityValue(), watchlist.getEquityValue());
        assertEquals(request.getSharesOutstanding(), watchlist.getSharesOutstanding());
        assertEquals(request.getDcfWithoutMarginOfSafety(), watchlist.getDcfWithoutMarginOfSafety());
    }
}
package com.webapp.watchlist;

import com.webapp.user.User;
import org.springframework.stereotype.Service;

@Service
public class WatchlistMapper {

    public WatchlistGetRequest toWatchlistGetRequest(Watchlist watchlist) {

        return WatchlistGetRequest.builder()
                .id(watchlist.getId())
                .ticker(watchlist.getTicker())
                .company(watchlist.getCompany())
                .price(watchlist.getPrice())
                .currencyPrice(watchlist.getCurrencyPrice())
                .dcfWithMarginOfSafety(watchlist.getWithMarginOfSafety())
                .currencyDcf(watchlist.getCurrencyDcf())
                .dividendY(watchlist.getDividendY())
                .currencyDividendY(watchlist.getCurrencyDividendY())
                .dividendQ(watchlist.getDividendQ())
                .currencyDividendQ(watchlist.getCurrencyDividendQ())
                .dividendYield(watchlist.getDividendYield())
                .overValuedUnderValued(watchlist.getOverValuedUnderValued())
                .build();
    }

    public Watchlist WatchlistAddManualRequestToWatchlist(WatchlistAddManualRequest watchlistAddManualRequest, User user) {

        return Watchlist.builder()
                .id(watchlistAddManualRequest.getId())
                .user(user)
                .ticker(watchlistAddManualRequest.getTicker())
                .company(watchlistAddManualRequest.getCompany())
                .price(watchlistAddManualRequest.getPrice())
                .currencyPrice(watchlistAddManualRequest.getCurrencyPrice())
                .dcfWithMarginOfSafety(watchlistAddManualRequest.getWithMarginOfSafety())
                .currencyDcf(watchlistAddManualRequest.getCurrencyDcf())
                .dividendY(watchlistAddManualRequest.getDividendY())
                .currencyDividendY(watchlistAddManualRequest.getCurrencyDividendY())
                .dividendQ(watchlistAddManualRequest.getDividendQ())
                .currencyDividendQ(watchlistAddManualRequest.getCurrencyDividendQ())
                .dividendYield(watchlistAddManualRequest.getDividendYield())
                .overValuedUnderValued(watchlistAddManualRequest.getOverValuedUnderValued())
                .build();
    }

    public Watchlist WatchlistAddCalcRequestToWatchlist(WatchlistAddCalcRequest watchlistAddCalcRequest, User user) {

        return Watchlist.builder()
                .id(watchlistAddCalcRequest.getId())
                .user(user)
                .ticker(watchlistAddCalcRequest.getTicker())
                .company(watchlistAddCalcRequest.getCompany())
                .price(watchlistAddCalcRequest.getPrice())
                .currencyPrice(watchlistAddCalcRequest.getCurrencyPrice())
                .dcfWithMarginOfSafety(watchlistAddCalcRequest.getWithMarginOfSafety())
                .currencyDcf(watchlistAddCalcRequest.getCurrencyDcf())
                .dividendY(watchlistAddCalcRequest.getDividendY())
                .currencyDividendY(watchlistAddCalcRequest.getCurrencyDividendY())
                .dividendQ(watchlistAddCalcRequest.getDividendQ())
                .currencyDividendQ(watchlistAddCalcRequest.getCurrencyDividendQ())
                .dividendYield(watchlistAddCalcRequest.getDividendYield())
                .overValuedUnderValued(watchlistAddCalcRequest.getOverValuedUnderValued())
                .freeCashFlow0(watchlistAddCalcRequest.getFreeCashFlow0());
                .freeCashFlow1(watchlistAddCalcRequest.getFreeCashFlow1());
                .freeCashFlow2(watchlistAddCalcRequest.getFreeCashFlow2());
                .freeCashFlow3(watchlistAddCalcRequest.getFreeCashFlow3());
                .freeCashFlow4(watchlistAddCalcRequest.getFreeCashFlow4());
                .freeCashFlow5(watchlistAddCalcRequest.getFreeCashFlow5());
                .growth0(watchlistAddCalcRequest.getGrowth0());
                .growth1(watchlistAddCalcRequest.getGrowth1());
                .growth2(watchlistAddCalcRequest.getGrowth2());
                .growth3(watchlistAddCalcRequest.getGrowth3());
                .growth4(watchlistAddCalcRequest.getGrowth4());
                .growth5(watchlistAddCalcRequest.getGrowth5());
                .growth6(watchlistAddCalcRequest.getGrowth6());
                .growthRate(watchlistAddCalcRequest.getGrowthRate());
                .avgGrowthRate(watchlistAddCalcRequest.getAvgGrowthRate());
                .futureFreeCashFlow0(watchlistAddCalcRequest.getFutureFreeCashFlow0());
                .futureFreeCashFlow1(watchlistAddCalcRequest.getFutureFreeCashFlow1());
                .futureFreeCashFlow2(watchlistAddCalcRequest.getFutureFreeCashFlow2());
                .futureFreeCashFlow3(watchlistAddCalcRequest.getFutureFreeCashFlow3());
                .futureFreeCashFlow4(watchlistAddCalcRequest.getFutureFreeCashFlow4());
                .futureFreeCashFlow5(watchlistAddCalcRequest.getFutureFreeCashFlow5());
                .futureFreeCashFlow6(watchlistAddCalcRequest.getFutureFreeCashFlow6());
                .terminalValue(watchlistAddCalcRequest.getTerminalValue());
                .pvOfFreeCashFlow0(watchlistAddCalcRequest.getPvOfFreeCashFlow0());
                .pvOfFreeCashFlow1(watchlistAddCalcRequest.getPvOfFreeCashFlow1());
                .pvOfFreeCashFlow2(watchlistAddCalcRequest.getPvOfFreeCashFlow2());
                .pvOfFreeCashFlow3(watchlistAddCalcRequest.getPvOfFreeCashFlow3());
                .pvOfFreeCashFlow4(watchlistAddCalcRequest.getPvOfFreeCashFlow4());
                .pvOfFreeCashFlow5(watchlistAddCalcRequest.getPvOfFreeCashFlow5());
                .pvOfFreeCashFlow6(watchlistAddCalcRequest.getPvOfFreeCashFlow6());
                .pvOfFreeCashFlow7(watchlistAddCalcRequest.getPvOfFreeCashFlow7());
                .perpetualGrowthRate(watchlistAddCalcRequest.getPerpetualGrowthRate());
                .discountRate(watchlistAddCalcRequest.getDiscountRate());
                .sumPvOfFcf(watchlistAddCalcRequest.getSumPvOfFcf());
                .cash(watchlistAddCalcRequest.getCash());
                .totalDebt(watchlistAddCalcRequest.getTotalDebt());
                .equityValue(watchlistAddCalcRequest.getEquityValue());
                .sharesOutstanding(watchlistAddCalcRequest.getSharesOutstanding());
                .dcfWithoutMarginOfSafety(watchlistAddCalcRequest.getDcfWithoutMarginOfSafety());
                .build();
    }

}

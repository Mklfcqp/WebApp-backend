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
                .dcf(watchlist.getDcf())
                .currencyDcf(watchlist.getCurrencyDcf())
                .dividendY(watchlist.getDividendY())
                .currencyDividendY(watchlist.getCurrencyDividendY())
                .dividendQ(watchlist.getDividendQ())
                .currencyDividendQ(watchlist.getCurrencyDividendQ())
                .dividendYield(watchlist.getDividendYield())
                .overValuedUnderValued(watchlist.getOverValuedUnderValued())
                .build();
    }

    public Watchlist toWatchlist(WatchlistAddRequest watchlistAddRequest, User user) {

        return Watchlist.builder()
                .id(watchlistAddRequest.getId())
                .user(user)
                .ticker(watchlistAddRequest.getTicker())
                .company(watchlistAddRequest.getCompany())
                .price(watchlistAddRequest.getPrice())
                .currencyPrice(watchlistAddRequest.getCurrencyPrice())
                .dcf(watchlistAddRequest.getDcf())
                .currencyDcf(watchlistAddRequest.getCurrencyDcf())
                .dividendY(watchlistAddRequest.getDividendY())
                .currencyDividendY(watchlistAddRequest.getCurrencyDividendY())
                .dividendQ(watchlistAddRequest.getDividendQ())
                .currencyDividendQ(watchlistAddRequest.getCurrencyDividendQ())
                .dividendYield(watchlistAddRequest.getDividendYield())
                .overValuedUnderValued(watchlistAddRequest.getOverValuedUnderValued())
                .build();
    }

    public void updateWatchlistFromRequest(Watchlist existingWatchlist, WatchlistAddRequest request) {

        existingWatchlist.setTicker(request.getTicker());
        existingWatchlist.setCompany(request.getCompany());
        existingWatchlist.setPrice(request.getPrice());
        existingWatchlist.setCurrencyPrice(request.getCurrencyPrice());
        existingWatchlist.setDcf(request.getDcf());
        existingWatchlist.setCurrencyDcf(request.getCurrencyDcf());
        existingWatchlist.setDividendYield(request.getDividendYield());
        existingWatchlist.setDividendQ(request.getDividendQ());
        existingWatchlist.setCurrencyDividendQ(request.getCurrencyDividendQ());
        existingWatchlist.setDividendY(request.getDividendY());
        existingWatchlist.setCurrencyDividendY(request.getCurrencyDividendY());
    }
}

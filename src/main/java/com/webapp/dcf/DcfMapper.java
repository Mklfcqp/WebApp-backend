package com.webapp.dcf;

import com.webapp.portfolio.Portfolio;
import com.webapp.portfolio.PortfolioAddRequest;
import com.webapp.portfolio.PortfolioGetRequest;
import com.webapp.portfolio.PortfolioGetRequestSUM;
import com.webapp.user.User;
import com.webapp.watchlist.Watchlist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DcfMapper {

    public DcfGetRequest toPortfolioGetRequest(Dcf dcf, Watchlist watchlist) {

        return DcfGetRequest.builder()
                .id(watchlist.getId())
                .id(dcf.getId())
                .dcfWithMarginOfSafety(dcf.getDcfWithMarginOfSafety())
                .build();
    }

    public Portfolio toPortfolio(PortfolioAddRequest portfolioAddRequest, User user) {

        return Portfolio.builder()
                .user(user)
                .id(portfolioAddRequest.getId())
                .ticker(portfolioAddRequest.getTicker())
                .company(portfolioAddRequest.getCompany())
                .sharesBuy(portfolioAddRequest.getSharesBuy())
                .buy(portfolioAddRequest.getBuy())
                .sell(portfolioAddRequest.getSell())
                .sharesSell(portfolioAddRequest.getSharesSell())
                .interestBuySell(portfolioAddRequest.getInterestBuySell())
                .profitLossBuySell(portfolioAddRequest.getProfitLossBuySell())
                .dividend(portfolioAddRequest.getDividend())
                .interestDividend(portfolioAddRequest.getInterestDividend())
                .profitLossDividend(portfolioAddRequest.getProfitLossDividend())
                .sumProfitLoss(portfolioAddRequest.getSumProfitLoss())
                .build();
    }

    public void updatePortfolioFromRequest(Portfolio existingPortfolio, PortfolioAddRequest request) {
        existingPortfolio.setCompany(request.getCompany());
        existingPortfolio.setSharesBuy(request.getSharesBuy());
        existingPortfolio.setBuy(request.getBuy());
        existingPortfolio.setSell(request.getSell());
        existingPortfolio.setSharesSell(request.getSharesSell());
        existingPortfolio.setInterestBuySell(request.getInterestBuySell());
        existingPortfolio.setProfitLossBuySell(request.getProfitLossBuySell());
        existingPortfolio.setDividend(request.getDividend());
        existingPortfolio.setInterestDividend(request.getInterestDividend());
        existingPortfolio.setProfitLossDividend(request.getProfitLossDividend());
        existingPortfolio.setSumProfitLoss(request.getSumProfitLoss());


    }



    public PortfolioGetRequestSUM toPortfolioGetRequestSUM(Portfolio portfolio) {

        return PortfolioGetRequestSUM.builder()
                .id(portfolio.getId())
                .buy(portfolio.getBuy())
                .sell(portfolio.getSell())
                .interestBuySell(portfolio.getInterestBuySell())
                .profitLossBuySell(portfolio.getProfitLossBuySell())
                .dividend(portfolio.getDividend())
                .interestDividend(portfolio.getInterestDividend())
                .profitLossDividend(portfolio.getProfitLossDividend())
                .sumProfitLoss(portfolio.getSumProfitLoss())
                .build();
    }


    public List<PortfolioGetRequest> toPortfolioGetRequest(List<Portfolio> portfolios) {
        return portfolios.stream()
                .map(this::toPortfolioGetRequest)
                .collect(Collectors.toList());
    }
}

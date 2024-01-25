package com.webapp.portfolio;

import com.webapp.user.User;
import org.springframework.stereotype.Service;

@Service
public class PortfolioMapper {

    public PortfolioGetRequest toPortfolioGetRequest(Portfolio portfolio) {

        return PortfolioGetRequest.builder()
                .id(portfolio.getId())
                .ticker(portfolio.getTicker())
                .company(portfolio.getCompany())
                .shares(portfolio.getShares())
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

    public Portfolio toPortfolio(PortfolioAddRequest portfolioAddRequest, User user) {

        return Portfolio.builder()
                .id(portfolioAddRequest.getId())
                .ticker(portfolioAddRequest.getTicker())
                .company(portfolioAddRequest.getCompany())
                .shares(portfolioAddRequest.getShares())
                .buy(portfolioAddRequest.getBuy())
                .sell(portfolioAddRequest.getSell())
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
        existingPortfolio.setShares(request.getShares());
        existingPortfolio.setBuy(request.getBuy());
        existingPortfolio.setSell(request.getSell());
        existingPortfolio.setInterestBuySell(request.getInterestBuySell());
        existingPortfolio.setProfitLossBuySell(request.getProfitLossBuySell());
        existingPortfolio.setDividend(request.getDividend());
        existingPortfolio.setInterestDividend(request.getInterestDividend());
        existingPortfolio.setProfitLossDividend(request.getProfitLossDividend());
        existingPortfolio.setSumProfitLoss(request.getSumProfitLoss());


    }
}

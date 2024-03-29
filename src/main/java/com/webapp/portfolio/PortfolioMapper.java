package com.webapp.portfolio;

import com.webapp.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortfolioMapper {

    public PortfolioGetRequest toPortfolioGetRequest(Portfolio portfolio) {

        return PortfolioGetRequest.builder()
                .id(portfolio.getId())
                .ticker(portfolio.getTicker())
                .company(portfolio.getCompany())
                .sharesBuy(portfolio.getSharesBuy())
                .buy(portfolio.getBuy())
                .sell(portfolio.getSell())
                .sharesSell(portfolio.getSharesSell())
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

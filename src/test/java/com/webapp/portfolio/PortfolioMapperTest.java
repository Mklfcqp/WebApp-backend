package com.webapp.portfolio;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioMapperTest {

//    private final PortfolioMapper portfolioMapper = new PortfolioMapper();
//
//    @Test
//    public void toPortfolioGetRequestTest() {
//        Portfolio portfolio = Portfolio.builder()
//                .id(1L)
//                .ticker("AAPL")
//                .company("Apple Inc.")
//                .sharesBuy(100L)
//                .buy(BigDecimal.valueOf(150.0))
//                .sell(BigDecimal.valueOf(175.0))
//                .sharesSell(50L)
//                .interestBuySell(BigDecimal.valueOf(25.0))
//                .profitLossBuySell(BigDecimal.valueOf(125.0))
//                .dividend(BigDecimal.valueOf(1.0))
//                .interestDividend(BigDecimal.valueOf(0.25))
//                .profitLossDividend(BigDecimal.valueOf(0.75))
//                .sumProfitLoss(BigDecimal.valueOf(125.75))
//                .build();
//        PortfolioGetRequest portfolioGetRequest = portfolioMapper.toPortfolioGetRequest(portfolio);
//        assertNotNull(portfolioGetRequest);
//        assertEquals(1L, portfolioGetRequest.getId());
//        assertEquals("AAPL", portfolioGetRequest.getTicker());
//        assertEquals("Apple Inc.", portfolioGetRequest.getCompany());
//        assertEquals(100, portfolioGetRequest.getSharesBuy());
//        assertEquals(150.0, portfolioGetRequest.getBuy());
//        assertEquals(175.0, portfolioGetRequest.getSell());
//        assertEquals(50, portfolioGetRequest.getSharesSell());
//        assertEquals(25.0, portfolioGetRequest.getInterestBuySell());
//        assertEquals(125.0, portfolioGetRequest.getProfitLossBuySell());
//        assertEquals(1.0, portfolioGetRequest.getDividend());
//        assertEquals(0.25, portfolioGetRequest.getInterestDividend());
//        assertEquals(0.75, portfolioGetRequest.getProfitLossDividend());
//        assertEquals(125.75, portfolioGetRequest.getSumProfitLoss());
//    }
//
//    @Test
//    public void toPortfolioTest() {
//        PortfolioAddRequest portfolioAddRequest = PortfolioAddRequest.builder()
//                .id(1L)
//                .ticker("AAPL")
//                .company("Apple Inc.")
//                .sharesBuy(100)
//                .buy(150.0)
//                .sell(175.0)
//                .sharesSell(50)
//                .interestBuySell(25.0)
//                .profitLossBuySell(125.0)
//                .dividend(1.0)
//                .interestDividend(0.25)
//                .profitLossDividend(0.75)
//                .sumProfitLoss(125.75)
//                .build();
//        User user = User.builder()
//                .email("testuser@example.com")
//                .password("password")
//                .role(Role.USER)
//                .build();
//        Portfolio portfolio = portfolioMapper.toPortfolio(portfolioAddRequest, user);
//        assertNotNull(portfolio);
//        assertNull(portfolio.getId());
//        assertEquals("AAPL", portfolio.getTicker());
//        assertEquals("Apple Inc.", portfolio.getCompany());
//        assertEquals(100, portfolio.getSharesBuy());
//        assertEquals(150.0, portfolio.getBuy());
//        assertEquals(175.0, portfolio.getSell());
//        assertEquals(50, portfolio.getSharesSell());
//        assertEquals(25.0, portfolio.getInterestBuySell());
//        assertEquals(125.0, portfolio.getProfitLossBuySell());
//        assertEquals(1.0, portfolio.getDividend());
//        assertEquals(0.25, portfolio.getInterestDividend());
//        assertEquals(0.75, portfolio.getProfitLossDividend());
//        assertEquals(125.75, portfolio.getSumProfitLoss());
//        assertEquals(user, portfolio.getUser());
//    }
//
//    @Test
//    public void updatePortfolioFromRequestTest() {
//        Portfolio existingPortfolio = Portfolio.builder()
//                .id(1L)
//                .ticker("AAPL")
//                .company("Apple Inc.")
//                .sharesBuy(100)
//                .buy(150.0)
//                .sell(175.0)
//                .sharesSell(50)
//                .interestBuySell(25.0)
//                .profitLossBuySell(125.0)
//                .dividend(1.0)
//                .interestDividend(0.25)
//                .profitLossDividend(0.75)
//                .sumProfitLoss(125.75)
//                .build();
//        PortfolioAddRequest request = PortfolioAddRequest.builder()
//                .company("Apple Inc.")
//                .sharesBuy(200)
//                .buy(152.51)
//                .sell(155.0)
//                .sharesSell(0)
//                .interestBuySell(0.49)
//                .profitLossBuySell(51.0)
//                .dividend(0.0)
//                .interestDividend(0.0)
//                .profitLossDividend(0.0)
//                .sumProfitLoss(51.49)
//                .build();
//        portfolioMapper.updatePortfolioFromRequest(existingPortfolio, request);
//        assertEquals("Apple Inc.", existingPortfolio.getCompany());
//        assertEquals(200, existingPortfolio.getSharesBuy());
//        assertEquals(152.51, existingPortfolio.getBuy());
//        assertEquals(155.0, existingPortfolio.getSell());
//        assertEquals(0, existingPortfolio.getSharesSell());
//        assertEquals(0.49, existingPortfolio.getInterestBuySell());
//        assertEquals(51.0, existingPortfolio.getProfitLossBuySell());
//        assertEquals(0.0, existingPortfolio.getDividend());
//        assertEquals(0.0, existingPortfolio.getInterestDividend());
//        assertEquals(0.0, existingPortfolio.getProfitLossDividend());
//        assertEquals(51.49, existingPortfolio.getSumProfitLoss());
//    }
//
//    @Test
//    public void toPortfolioGetRequestSUMTest() {
//        Portfolio portfolio = Portfolio.builder()
//                .id(1L)
//                .buy(150.0)
//                .sell(175.0)
//                .interestBuySell(25.0)
//                .profitLossBuySell(125.0)
//                .dividend(1.0)
//                .interestDividend(0.25)
//                .profitLossDividend(0.75)
//                .sumProfitLoss(125.75)
//                .build();
//        PortfolioGetRequestSUM portfolioSUM = portfolioMapper.toPortfolioGetRequestSUM(portfolio);
//        assertNotNull(portfolioSUM);
//        assertEquals(1L, portfolioSUM.getId());
//        assertEquals(150.0, portfolioSUM.getBuy());
//        assertEquals(175.0, portfolioSUM.getSell());
//        assertEquals(25.0, portfolioSUM.getInterestBuySell());
//        assertEquals(125.0, portfolioSUM.getProfitLossBuySell());
//        assertEquals(1.0, portfolioSUM.getDividend());
//        assertEquals(0.25, portfolioSUM.getInterestDividend());
//        assertEquals(0.75, portfolioSUM.getProfitLossDividend());
//        assertEquals(125.75, portfolioSUM.getSumProfitLoss());
//    }
//
//    @Test
//    public void toPortfolioGetRequestListTest() {
//        Portfolio portfolio = Portfolio.builder()
//                .id(1L)
//                .ticker("AAPL")
//                .company("Apple Inc.")
//                .sharesBuy(100)
//                .buy(150.0)
//                .sell(175.0)
//                .sharesSell(50)
//                .interestBuySell(25.0)
//                .profitLossBuySell(125.0)
//                .dividend(1.0)
//                .interestDividend(0.25)
//                .profitLossDividend(0.75)
//                .sumProfitLoss(125.75)
//                .build();
//        List<PortfolioGetRequest> portfolioGetRequests = portfolioMapper.toPortfolioGetRequest(Collections.singletonList(portfolio));
//        assertNotNull(portfolioGetRequests);
//        assertEquals(1, portfolioGetRequests.size());
//        PortfolioGetRequest portfolioGetRequest = portfolioGetRequests.get(0);
//        assertEquals(1L, portfolioGetRequest.getId());
//        assertEquals("AAPL", portfolioGetRequest.getTicker());
//        assertEquals("Apple Inc.", portfolioGetRequest.getCompany());
//        assertEquals(100, portfolioGetRequest.getSharesBuy());
//        assertEquals(150.0, portfolioGetRequest.getBuy());
//        assertEquals(175.0, portfolioGetRequest.getSell());
//        assertEquals(50, portfolioGetRequest.getSharesSell());
//        assertEquals(25.0, portfolioGetRequest.getInterestBuySell());
//        assertEquals(125.0, portfolioGetRequest.getProfitLossBuySell());
//        assertEquals(1.0, portfolioGetRequest.getDividend());
//        assertEquals(0.25, portfolioGetRequest.getInterestDividend());
//        assertEquals(0.75, portfolioGetRequest.getProfitLossDividend());
//        assertEquals(125.75, portfolioGetRequest.getSumProfitLoss());
//    }

}
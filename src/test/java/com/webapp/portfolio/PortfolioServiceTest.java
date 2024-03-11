package com.webapp.portfolio;

import com.webapp.user.Role;
import com.webapp.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PortfolioServiceTest {

    @Mock
    private PortfolioRepository portfolioRepository;

    @Mock
    private PortfolioMapper portfolioMapper;

    @InjectMocks
    private PortfolioService portfolioService;

    @Test
    public void addCompanyToPortfolioTest() {
        PortfolioAddRequest request = PortfolioAddRequest.builder()
                .ticker("AAPL")
                .company("Apple Inc.")
                .sharesBuy(100)
                .buy(150.0)
                .sell(175.0)
                .sharesSell(50)
                .interestBuySell(25.0)
                .profitLossBuySell(125.0)
                .dividend(1.0)
                .interestDividend(0.25)
                .profitLossDividend(0.75)
                .sumProfitLoss(125.75)
                .build();
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        when(portfolioMapper.toPortfolio(request, user)).thenReturn(Portfolio.builder().build());
        portfolioService.addCompanyToPortfolio(request);
        verify(portfolioRepository, times(1)).save(any(Portfolio.class));
    }

    @Test
    public void getPortfolioTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        when(portfolioService.getCurrentUser()).thenReturn(user);
        when(portfolioRepository.findByUserId(user.getId())).thenReturn(Collections.singletonList(Portfolio.builder().build()));
        when(portfolioMapper.toPortfolioGetRequest(Collections.singletonList(Portfolio.builder().build()))).thenReturn(Collections.singletonList(PortfolioGetRequest.builder().build()));
        List<PortfolioGetRequest> portfolio = portfolioService.getPortfolio();
        assertNotNull(portfolio);
        assertEquals(1, portfolio.size());
        verify(portfolioRepository, times(1)).findByUserId(user.getId());
        verify(portfolioMapper, times(1)).toPortfolioGetRequest(Collections.singletonList(Portfolio.builder().build()));
    }

    @Test
    public void updatePortfolioTest() {
        PortfolioAddRequest request = PortfolioAddRequest.builder()
                .id(1L)
                .ticker("AAPL")
                .company("Apple Inc.")
                .sharesBuy(100)
                .buy(150.0)
                .sell(175.0)
                .sharesSell(50)
                .interestBuySell(25.0)
                .profitLossBuySell(125.0)
                .dividend(1.0)
                .interestDividend(0.25)
                .profitLossDividend(0.75)
                .sumProfitLoss(125.75)
                .build();
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        when(portfolioMapper.toPortfolio(request, user)).thenReturn(Portfolio.builder().build());
        portfolioService.updatePortfolio(request);
        verify(portfolioRepository, times(1)).save(any(Portfolio.class));
    }

    @Test
    public void deletePortfolioTest() {
        Long id = 1L;
        portfolioService.deletePortfolio(id);
        verify(portfolioRepository, times(1)).deleteById(id);
    }

    @Test
    public void getPortfolioSUMTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        when(portfolioService.getCurrentUser()).thenReturn(user);
        when(portfolioRepository.findByUserId(user.getId())).thenReturn(Collections.singletonList(Portfolio.builder()
                .buy(BigDecimal.valueOf(150.0))
                .sell(BigDecimal.valueOf(175.0))
                .interestBuySell(BigDecimal.valueOf(25.0))
                .profitLossBuySell(BigDecimal.valueOf(125.0))
                .dividend(BigDecimal.valueOf(1.0))
                .interestDividend(BigDecimal.valueOf(0.25))
                .profitLossDividend(BigDecimal.valueOf(0.75))
                .sumProfitLoss(BigDecimal.valueOf(125.75))
                .build()));
        PortfolioGetRequestSUM summary = portfolioService.getPortfolioSUM();
        assertNotNull(summary);
        assertEquals(1L, summary.getId());
        assertEquals(BigDecimal.valueOf(150.0), summary.getBuy());
        assertEquals(BigDecimal.valueOf(175.0), summary.getSell());
        assertEquals(BigDecimal.valueOf(25.0), summary.getInterestBuySell());
        assertEquals(BigDecimal.valueOf(125.0), summary.getProfitLossBuySell());
        assertEquals(BigDecimal.valueOf(1.0), summary.getDividend());
        assertEquals(BigDecimal.valueOf(0.25), summary.getInterestDividend());
        assertEquals(BigDecimal.valueOf(0.75), summary.getProfitLossDividend());
        assertEquals(BigDecimal.valueOf(125.75), summary.getSumProfitLoss());
    }

}
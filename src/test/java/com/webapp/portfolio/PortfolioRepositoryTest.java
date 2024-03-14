package com.webapp.portfolio;

import com.webapp.user.Role;
import com.webapp.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PortfolioRepositoryTest {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Test
    public void findByUserIdTest() {
        User user = User.builder()
                .email("testuser@example.com")
                .password("password")
                .role(Role.USER)
                .build();
        Portfolio portfolio = Portfolio.builder()
                .user(user)
                .ticker("AAPL")
                .company("Apple Inc.")
                .sharesBuy(100L)
                .buy(BigDecimal.valueOf(150.0))
                .sell(BigDecimal.valueOf(175.0))
                .sharesSell(50L)
                .interestBuySell(BigDecimal.valueOf(25.0))
                .profitLossBuySell(BigDecimal.valueOf(125.0))
                .dividend(BigDecimal.valueOf(1.0))
                .interestDividend(BigDecimal.valueOf(0.25))
                .profitLossDividend(BigDecimal.valueOf(0.75))
                .sumProfitLoss(BigDecimal.valueOf(125.75))
                .build();
        portfolioRepository.save(portfolio);
        List<Portfolio> portfolios = portfolioRepository.findByUserId(user.getId());
        assertNotNull(portfolios);
        assertEquals(1, portfolios.size());
        assertEquals(portfolio, portfolios.get(0));
    }

}
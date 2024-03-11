package com.webapp.portfolio;

import com.webapp.user.Role;
import com.webapp.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
        portfolioRepository.save(portfolio);
        List<Portfolio> portfolios = portfolioRepository.findByUserId(user.getId());
        assertNotNull(portfolios);
        assertEquals(1, portfolios.size());
        assertEquals(portfolio, portfolios.get(0));
    }

}
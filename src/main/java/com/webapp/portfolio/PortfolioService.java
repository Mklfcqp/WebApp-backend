package com.webapp.portfolio;

import com.webapp.user.User;
import com.webapp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;

    public void addCompanyToPortfolio(PortfolioAddRequest request) {

        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Portfolio portfolio = portfolioMapper.toPortfolio(request, currentUser);
        portfolioRepository.save(portfolio);

    }

    //---------------loadWatchlistData()---------------
    public List<PortfolioGetRequest> getPortfolio() {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Long userId = currentUser.getId();

        List<Portfolio> portfolios = portfolioRepository.findByUserId(userId);
        List<PortfolioGetRequest> requests = portfolioMapper.toPortfolioGetRequest(portfolios);

        return requests;
    }


    //---------------updateWatchlistData()---------------
    public void updatePortfolio(PortfolioAddRequest request) {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Portfolio portfolio = portfolioMapper.toPortfolio(request, currentUser);
        portfolioRepository.save(portfolio);
    }


    //---------------deleteWatchlistData()---------------
    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }



    //---------------getCurrentUser()---------------

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        }

        return null;
    }


    //---------------getSum()---------------

    public PortfolioGetRequestSUM getPortfolioSUM() {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Long userId = currentUser.getId();

        List<Portfolio> portfolios = portfolioRepository.findByUserId(userId);

        BigDecimal buySum = portfolios.stream().map(Portfolio::getBuy).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal sellSum = portfolios.stream().map(Portfolio::getSell).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal interestBuySellSum = portfolios.stream().map(Portfolio::getInterestBuySell).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal profitLossBuySellSum = portfolios.stream().map(Portfolio::getProfitLossBuySell).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal dividendSum = portfolios.stream().map(Portfolio::getDividend).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal interestDividendSum = portfolios.stream().map(Portfolio::getInterestDividend).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal profitLossDividendSum = portfolios.stream().map(Portfolio::getProfitLossDividend).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal profitLossSum = portfolios.stream().map(Portfolio::getSumProfitLoss).reduce(BigDecimal.ZERO, BigDecimal::add);

        PortfolioGetRequestSUM summary = PortfolioGetRequestSUM.builder()
                .id(userId)
                .buy(buySum)
                .sell(sellSum)
                .interestBuySell(interestBuySellSum)
                .profitLossBuySell(profitLossBuySellSum)
                .dividend(dividendSum)
                .interestDividend(interestDividendSum)
                .profitLossDividend(profitLossDividendSum)
                .sumProfitLoss(profitLossSum)
                .build();

        return summary;
    }


}

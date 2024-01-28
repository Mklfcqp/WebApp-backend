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
//    public List<PortfolioGetRequest> getPortfolio() {
//        User currentUser = getCurrentUser();
//        if (currentUser == null) {
//            throw new IllegalStateException("User not authenticated");
//        }
//
//        Long userId = currentUser.getId();
//        System.out.println(userId);
//
//        List<Portfolio> portfolios = portfolioRepository.findByUserId(userId);
//        List<PortfolioGetRequest> requests = portfolioMapper.toPortfolioGetRequest(portfolios);
//
//        return requests;
//    }

//        public List<PortfolioGetRequest> getPortfolio() {
//        User currentUser = getCurrentUser();
//        if (currentUser == null) {
//            throw new IllegalStateException("User not authenticated");
//        }
//
//        Long userId = currentUser.getId();
//        return portfolioRepository.findByUserId(userId).stream()
//                .map(portfolioMapper::toPortfolioGetRequest)
//                .toList();
//    }

    public List<PortfolioGetRequest> getPortfolio() {
        return portfolioRepository.findAll().stream()
                .map(portfolioMapper::toPortfolioGetRequest)
                .toList();
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

//    public PortfolioGetRequestSUM getPortfolioSUM() {
//        List<Portfolio> portfolios = portfolioRepository.findByUserId(getCurrentUser().getId());
//
//        BigDecimal buySum = portfolios.stream()
//                .map(Portfolio::getBuy)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        BigDecimal sellSum = portfolios.stream()
//                .map(Portfolio::getSell)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        BigDecimal interestBuySellSum = portfolios.stream()
//                .map(Portfolio::getInterestBuySell)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        BigDecimal profitLossBuySellSum = portfolios.stream()
//                .map(Portfolio::getProfitLossBuySell)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        BigDecimal dividendSum = portfolios.stream()
//                .map(Portfolio::getDividend)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        BigDecimal interestDividendSum = portfolios.stream()
//                .map(Portfolio::getInterestDividend)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        BigDecimal profitLossDividendSum = portfolios.stream()
//                .map(Portfolio::getProfitLossDividend)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//        return PortfolioGetRequestSUM.builder()
//                .buy(buySum)
//                .sell(sellSum)
//                .interestBuySell(interestBuySellSum)
//                .profitLossBuySell(profitLossBuySellSum)
//                .dividend(dividendSum)
//                .interestDividend(interestDividendSum)
//                .profitLossDividend(profitLossDividendSum)
//                .build();
//    }


}

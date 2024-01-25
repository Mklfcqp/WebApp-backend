package com.webapp.portfolio;

import com.webapp.user.User;
import com.webapp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;
    private final UserRepository userRepository;

    public void addCompanyToPortfolio(PortfolioAddRequest request) {

        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Portfolio portfolio = portfolioMapper.toPortfolio(request, currentUser);
        portfolioRepository.save(portfolio);

    }

    //---------------loadWatchlistData()---------------
//    public List<WatchlistGetRequest> getWatchlists() {
//        User currentUser = getCurrentUser();
//        if (currentUser == null) {
//            throw new IllegalStateException("User not authenticated");
//        }
//
//        Long userId = currentUser.getId();
//        return watchlistRepository.findByUserId(userId).stream()
//                .map(watchlistMapper::toWatchlistGetRequest)
//                .toList();
//    }

    public List<PortfolioGetRequest> getPortfolio() {
        return portfolioRepository.findAll().stream()
                .map(portfolioMapper::toPortfolioGetRequest)
                .toList();
    }



    //---------------loadWatchlistDataById()---------------

//    public WatchlistGetRequest getWatchlistById(Long id) {
//        Optional<Watchlist> optionalWatchlist = watchlistRepository.findById(id);
//
//        if (optionalWatchlist.isPresent()) {
//            Watchlist watchlist = optionalWatchlist.get();
//            return watchlistMapper.toWatchlistGetRequest(watchlist);
//        } else {
//            throw new IllegalStateException("Watchlist not found with ID: " + id);
//        }
//    }

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
}

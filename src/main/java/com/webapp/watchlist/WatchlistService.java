package com.webapp.watchlist;

import com.webapp.auth.AuthenticationResponse;
import com.webapp.config.JwtService;
import com.webapp.patient.Patient;
import com.webapp.user.User;
import com.webapp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WatchlistService {

    private final WatchlistRepository watchlistRepository;
    private final WatchlistMapper watchlistMapper;

    public void addCompanyToWatchlist(WatchlistAddRequest request) {

        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Watchlist watchlist = watchlistMapper.toWatchlistAddRequest(request, currentUser);
        watchlistRepository.save(watchlist);

    }

    //---------------loadWatchlistData()---------------

    public List<WatchlistGetRequest> getWatchlists() {
        return watchlistRepository.findAll().stream()
                .map(watchlistMapper::toWatchlistGetRequest)
                .toList();
    }

    //---------------updateWatchlistData()---------------

//    public void updateWatchlistData(Long watchlistId, WatchlistAddRequest request) {
//        Optional<Watchlist> optionalWatchlist = watchlistRepository.findById(watchlistId);
//
//        User currentUser = getCurrentUser();
//        if (currentUser == null) {
//            throw new IllegalStateException("User not authenticated");
//        }
//
//        if (optionalWatchlist.isPresent()) {
//            Watchlist watchlist = Watchlist.builder()
//                    .user(currentUser)
//                    .ticker(request.getTicker())
//                    .company(request.getCompany())
//                    .price(request.getPrice())
//                    .currencyPrice(request.getCurrencyPrice())
//                    .dcf(request.getDcf())
//                    .currencyDcf(request.getCurrencyDcf())
//                    .dividendY(request.getDividendY())
//                    .currencyDividendY(request.getCurrencyDividendY())
//                    .dividendQ(request.getDividendQ())
//                    .currencyDividendQ(request.getCurrencyDividendQ())
//                    .dividendYield(request.getDividendYield())
//                    .overValuedUnderValued(request.getOverValuedUnderValued())
//                    .build();
//
//            watchlistRepository.save(watchlist);
//        } else {
//            throw new RuntimeException("Watchlist not found.");
//        }
//    }


    //---------------deleteWatchlistData()---------------

    public void deleteWatchlist(Long id) {
        watchlistRepository.deleteById(id);
    }







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

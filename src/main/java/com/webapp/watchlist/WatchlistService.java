package com.webapp.watchlist;

import com.webapp.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WatchlistService {

    private final WatchlistRepository watchlistRepository;
    private final WatchlistMapper watchlistMapper;

    public void addCompanyToWatchlist(WatchlistAddManualRequest request) {

        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Watchlist watchlist = watchlistMapper.toWatchlist(request, currentUser);
        watchlistRepository.save(watchlist);

    }

    //---------------loadWatchlistData()---------------
    public List<WatchlistGetRequest> getWatchlists() {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Long userId = currentUser.getId();
        return watchlistRepository.findByUserId(userId).stream()
                .map(watchlistMapper::toWatchlistGetRequest)
                .toList();
    }

    //---------------updateWatchlistData()---------------
    public void updateWatchlist(WatchlistAddManualRequest request) {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Watchlist watchlist = watchlistMapper.toWatchlist(request, currentUser);
        watchlistRepository.save(watchlist);
    }


    //---------------deleteWatchlistData()---------------
    public void deleteWatchlist(Long id) {
        watchlistRepository.deleteById(id);
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


    //---------------sortedDisparity()---------------

    public List<WatchlistGetRequest> sortedDisparity() {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new IllegalStateException("User not authenticated");
        }

        Long userId = currentUser.getId();
        return watchlistRepository.findByUserId(userId).stream()
                .map(watchlistMapper::toWatchlistGetRequest)
                .sorted((w1, w2) -> {

                    double p1 = Double.parseDouble(w1.getOverValuedUnderValued().replaceAll("[^\\d.+-]", ""));
                    double p2 = Double.parseDouble(w2.getOverValuedUnderValued().replaceAll("[^\\d.+-]", ""));

                    if (w1.getOverValuedUnderValued().contains("Overvalued")) {
                        p1 = -p1;
                    }
                    if (w2.getOverValuedUnderValued().contains("Overvalued")) {
                        p2 = -p2;
                    }

                    return Double.compare(p2, p1);
                })
                .toList();
    }




}
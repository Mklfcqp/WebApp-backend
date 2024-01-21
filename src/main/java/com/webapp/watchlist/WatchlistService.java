package com.webapp.watchlist;

import com.webapp.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


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

//    public void updateWatchlist(WatchlistAddRequest request, Long id) {
//        Optional<Watchlist> optionalWatchlist = watchlistRepository.findById(id);
//
//        if (optionalWatchlist.isPresent()) {
//            Watchlist existingWatchlist = optionalWatchlist.get();
//            watchlistMapper.updateWatchlistFromRequest(existingWatchlist, request);
//            watchlistRepository.save(existingWatchlist);
//        } else {
//            throw new IllegalStateException("Watchlist item not found with ID: " + id);
//        }
//    }

        public void updateWatchlist(WatchlistAddRequest request) {
            User currentUser = getCurrentUser();
            if (currentUser == null) {
                throw new IllegalStateException("User not authenticated");
            }

            Watchlist watchlist = watchlistMapper.toWatchlistAddRequest(request, currentUser);
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




}

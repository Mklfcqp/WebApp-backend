package com.webapp.watchlist;

import com.webapp.auth.AuthenticationResponse;
import com.webapp.auth.AuthenticationService;
import com.webapp.patient.Patient;
import com.webapp.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class WatchlistController {

    private final WatchlistService watchlistService;

    @PostMapping("/add")
    public ResponseEntity<String> addCompanyToWatchlist(@RequestBody WatchlistAddRequest request) {
        try {

            watchlistService.addCompanyToWatchlist(request);
            return ResponseEntity.ok("Watchlist item added successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //---------------loadWatchlistData()---------------

    @GetMapping("/load")
    public List<WatchlistGetRequest> getWatchlists(){
        return watchlistService.getWatchlists();
    }

    //---------------updateWatchlistData()---------------

//    @PutMapping("/update/{watchlistId}")
//    public ResponseEntity<String> updateWatchlistData(@PathVariable Long watchlistId, @RequestBody WatchlistAddRequest request) throws Exception {
//        try {
//            watchlistService.updateWatchlistData(watchlistId, request);
//            return ResponseEntity.ok("Watchlist item updated successfully");
//        } catch (IllegalStateException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }


    //---------------deleteWatchlistData()---------------

    @DeleteMapping("/delete/{id}")
    public void deleteWatchlist(@PathVariable("id") Long id){
        watchlistService.deleteWatchlist(id);
    }



}

package com.webapp.watchlist;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:5173/")
@CrossOrigin("https://web-app-frontend-jeolwgw0x-mkqps-projects.vercel.app/")
public class WatchlistController {

    private final WatchlistService watchlistService;


    //---------------addWatchlistDataManual()---------------
    @PostMapping("/add/manual")
    public ResponseEntity<String> addWatchlistDataManual(@RequestBody WatchlistAddManualRequest request) {
        try {

            watchlistService.addWatchlistDataManual(request);
            return ResponseEntity.ok("Watchlist item added successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //---------------addWatchlistDataCalc()---------------

    @PostMapping("/add/calc")
    public ResponseEntity<String> addWatchlistDataCalc(@RequestBody WatchlistAddCalcRequest request) {
        try {

            watchlistService.addWatchlistDataCalc(request);
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


    //---------------updateWatchlistDataManual()---------------

    @PutMapping("/update/manual")
    public ResponseEntity<String> updateWatchlistDataManual(@RequestBody WatchlistAddManualRequest request){
        try {

            watchlistService.updateWatchlistDataManual(request);
            return ResponseEntity.ok("Watchlist item updated successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    //---------------updateWatchlistData()---------------

    @PutMapping("/update/calc")
    public ResponseEntity<String> updateWatchlistDataCalc(@RequestBody WatchlistAddCalcRequest request){
        try {

            watchlistService.updateWatchlistDataCalc(request);
            return ResponseEntity.ok("Watchlist item updated successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //---------------deleteWatchlistData()---------------

    @DeleteMapping("/delete/{id}")
    public void deleteWatchlist(@PathVariable("id") Long id){
        watchlistService.deleteWatchlist(id);
    }




    @GetMapping("/sorted/disparity")
    public List<WatchlistGetRequest> sortedDisparity() {
        return watchlistService.sortedDisparity();
    }



}

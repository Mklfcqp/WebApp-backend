package com.webapp.watchlist;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlist")
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:5173/")
//@CrossOrigin("https://web-app-frontend-jeolwgw0x-mkqps-projects.vercel.app/")
@CrossOrigin
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

    //---------------loadWatchlistDataById()---------------

//    @GetMapping("/load/{id}")
//    public WatchlistGetRequest getWatchlistById(@PathVariable("id") Long id){
//        return watchlistService.getWatchlistById(id);
//    }

    //---------------updateWatchlistData()---------------

    @PutMapping("/update")
    public ResponseEntity<String> updateWatchlist(@RequestBody WatchlistAddRequest request){
        try {

            watchlistService.updateWatchlist(request);
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






//    @GetMapping
//    public ResponseEntity<Page<WatchlistGetRequest>> getWatchlistsByUserId(
//            @PathVariable Long userId,
//            @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
//        Page<WatchlistGetRequest> watchlists = watchlistService.getWatchlistsByUserId(userId, pageable);
//        return ResponseEntity.ok().body(watchlists);
//    }


}

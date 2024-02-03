package com.webapp.portfolio;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
//@CrossOrigin("https://web-app-frontend-6evsq3ewm-mkqps-projects.vercel.app/")
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping("/add")
    public ResponseEntity<String> addCompanyToWatchlist(@RequestBody PortfolioAddRequest request) {
        try {

            portfolioService.addCompanyToPortfolio(request);
            return ResponseEntity.ok("Watchlist item added successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //---------------loadPortfolioData()---------------

    @GetMapping("/load")
    public List<PortfolioGetRequest> getPortfolio(){
        return portfolioService.getPortfolio();
    }


    //---------------updatePortfolioData()---------------

    @PutMapping("/update")
    public ResponseEntity<String> updatePortfolio(@RequestBody PortfolioAddRequest request){
        try {

            portfolioService.updatePortfolio(request);
            return ResponseEntity.ok("Watchlist item updated successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //---------------deletePortfolioData()---------------

    @DeleteMapping("/delete/{id}")
    public void deleteWatchlist(@PathVariable("id") Long id){
        portfolioService.deletePortfolio(id);
    }


    //---------------getSUMPortfolioData()---------------
    @GetMapping("/load/sum")
    public PortfolioGetRequestSUM getPortfolioSUM(){
        return portfolioService.getPortfolioSUM();
    }

}

package com.webapp.watchlist;

import com.webapp.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WatchlistServiceTest {

    @Autowired
    private WatchlistService watchlistService;

    @Test
    public void addWatchlistDataManualTest() {
        WatchlistAddManualRequest request = new WatchlistAddManualRequest();
        request.setCompany("Apple Inc.");
        request.setTicker("AAPL");
        request.setPrice(152.51);
        request.setNumShares(100);
        request.setNotes("Adding Apple to my watchlist");
        watchlistService.addWatchlistDataManual(request);

        List<WatchlistGetRequest> watchlists = watchlistService.getWatchlists();
        assertNotNull(watchlists);
        assertEquals(1, watchlists.size());
        assertEquals("Apple Inc.", watchlists.get(0).getName());
        assertEquals("AAPL", watchlists.get(0).getTicker());
        assertEquals(152.51, watchlists.get(0).getPrice());
        assertEquals(100, watchlists.get(0).getNumShares());
        assertEquals("Adding Apple to my watchlist", watchlists.get(0).getNotes());
    }

    @Test
    public void addWatchlistDataCalcTest() {
        WatchlistAddCalcRequest request = new WatchlistAddCalcRequest();
        request.setName("Microsoft Corporation");
        request.setTicker("MSFT");
        request.setPrice(305.76);
        request.setNumShares(50);
        request.setNotes("Adding Microsoft to my watchlist");
        request.setEps(8.05);
        request.setGrowthRate(0.05);
        request.setDiscountRate(0.1);
        request.calculateDCF();
        watchlistService.addWatchlistDataCalc(request);
        List<WatchlistGetRequest> watchlists = watchlistService.getWatchlists();
        assertNotNull(watchlists);
        assertEquals(1, watchlists.size());
        assertEquals("Microsoft Corporation", watchlists.get(0).getName());
        assertEquals("MSFT", watchlists.get(0).getTicker());
        assertEquals(305.76, watchlists.get(0).getPrice());
        assertEquals(50, watchlists.get(0).getNumShares());
        assertEquals("Adding Microsoft to my watchlist", watchlists.get(0).getNotes());
        assertEquals("Undervalued by 56.66%", watchlists.get(0).getOverValuedUnderValued());
    }

    @Test
    public void getWatchlistsTest() {
        List<WatchlistGetRequest> watchlists = watchlistService.getWatchlists();
        assertNotNull(watchlists);
        assertEquals(1, watchlists.size()); // assuming there is at least one watchlist already in the database
    }

    @Test
    public void updateWatchlistDataManualTest() {
        WatchlistAddManualRequest request = new WatchlistAddManualRequest();
        request.setId(1L); // assuming there is at least one watchlist already in the database
        request.setName("Apple Inc.");
        request.setTicker("AAPL");
        request.setPrice(152.51);
        request.setNumShares(200);
        request.setNotes("Adding more shares of Apple to my watchlist");
        watchlistService.updateWatchlistDataManual(request);
        List<WatchlistGetRequest> watchlists = watchlistService.getWatchlists();
        assertNotNull(watchlists);
        assertEquals(1, watchlists.size());
        assertEquals("Apple Inc.", watchlists.get(0).getName());
        assertEquals("AAPL", watchlists.get(0).getTicker());
        assertEquals(152.51, watchlists.get(0).getPrice());
        assertEquals(200, watchlists.get(0).getNumShares());
        assertEquals("Adding more shares of Apple to my watchlist", watchlists.get(0).getNotes());
    }

    @Test
    public void updateWatchlistDataCalcTest() {
        WatchlistAddCalcRequest request = new WatchlistAddCalcRequest();
        request.setId(1L); // assuming there is at least one watchlist already in the database
        request.setName("Microsoft Corporation");
        request.setTicker("MSFT");
        request.setPrice(305.76);
        request.setNumShares(100);
        request.setNotes("Adding more shares of Microsoft to my watchlist");
        request.setEps(8.05);
        request.setGrowthRate(0.05);
        request.setDiscountRate(0.1);
        request.calculateDCF();
        watchlistService.updateWatchlistDataCalc(request);
        List<WatchlistGetRequest> watchlists = watchlistService.getWatchlists();
        assertNotNull(watchlists);
        assertEquals(1, watchlists.size());
        assertEquals("Microsoft Corporation", watchlists.get(0).getName());
        assertEquals("MSFT", watchlists.get(0).getTicker());
        assertEquals(305.76, watchlists.get(0).getPrice());
        assertEquals(100, watchlists.get(0).getNumShares());
        assertEquals("Adding more shares of Microsoft to my watchlist", watchlists.get(0).getNotes());
        assertEquals("Undervalued by 56.66%", watchlists.get(0).getOverValuedUnderValued());
    }

    @Test
    public void deleteWatchlistTest() {
        Long id = 1L; // assuming there is at least one watchlist already in the database
        watchlistService.deleteWatchlist(id);
        List<WatchlistGetRequest> watchlists = watchlistService.getWatchlists();
        assertNotNull(watchlists);
        assertEquals(0, watchlists.size());
    }

    @Test
    public void sortedDisparityTest() {
        WatchlistAddManualRequest request1 = new WatchlistAddManualRequest();
        request1.setName("Apple Inc.");
        request1.setTicker("AAPL");
        request1.setPrice(152.51);
        request1.setNumShares(100);
        request1.setNotes("Adding Apple to my watchlist");
        watchlistService.addWatchlistDataManual(request1);
        WatchlistAddCalcRequest request2 = new WatchlistAddCalcRequest();
        request2.setName("Microsoft Corporation");
        request2.setTicker("MSFT");
        request2.setPrice(305.76);
        request2.setNumShares(50);
        request2.setNotes("Adding Microsoft to my watchlist");
        request2.setEps(8.05);
        request2.setGrowthRate(0.05);
        request2.setDiscountRate(0.1);
        request2.calculateDCF();
        watchlistService.addWatchlistDataCalc(request2);
        List<WatchlistGetRequest> watchlists = watchlistService.sortedDisparity();
        assertNotNull(watchlists);
        assertEquals(2, watchlists.size());
        assertEquals("Microsoft Corporation", watchlists.get(0).getName());
        assertEquals("MSFT", watchlists.get(0).getTicker());
        assertEquals("Undervalued by 56.66%", watchlists.get(0).getOverValuedUnderValued());
        assertEquals("Apple Inc.", watchlists.get(1).getName());
        assertEquals("AAPL", watchlists.get(1).getTicker());
        assertEquals("Overvalued by 0.33%", watchlists.get(1).getOverValuedUnderValued());
    }

    @Test
    public void getCurrentUserTest() {
        // add authentication logic here if needed
        User user = watchlistService.getCurrentUser();
        assertNotNull(user);
        // add assertion here if needed
    }

    @Test
    public void addWatchlistDataManualThrowsExceptionTest() {
        WatchlistAddManualRequest request = new WatchlistAddManualRequest();
        request.setName("Amazon.com, Inc.");
        request.setTicker("AMZN");
        request.setPrice(3200.00);
        request.setNumShares(10);
        request.setNotes("Adding Amazon to my watchlist");
        assertThrows(IllegalStateException.class, () -> watchlistService.addWatchlistDataManual(request));
    }

    // add more test methods here if needed
}
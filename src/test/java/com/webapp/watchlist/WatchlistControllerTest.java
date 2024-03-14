package com.webapp.watchlist;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WatchlistControllerTest {

    private WatchlistController watchlistController;
    private WatchlistService watchlistService;

    @BeforeEach
    public void setUp() {
        watchlistService = mock(WatchlistService.class);
        watchlistController = new WatchlistController(watchlistService);
    }

    @Test
    public void testAddWatchlistDataManual() {
        WatchlistAddManualRequest request = new WatchlistAddManualRequest();

        doNothing().when(watchlistService).addWatchlistDataManual(request);

        ResponseEntity<String> response = watchlistController.addWatchlistDataManual(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Watchlist item added successfully", response.getBody());
    }

    @Test
    public void testAddWatchlistDataCalc() {
        WatchlistAddCalcRequest request = new WatchlistAddCalcRequest();

        doNothing().when(watchlistService).addWatchlistDataCalc(request);

        ResponseEntity<String> response = watchlistController.addWatchlistDataCalc(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Watchlist item added successfully", response.getBody());
    }

    @Test
    public void testGetWatchlists() {
        List<WatchlistGetRequest> watchlists = new ArrayList<>();

        when(watchlistService.getWatchlists()).thenReturn(watchlists);

        List<WatchlistGetRequest> response = watchlistController.getWatchlists();

        assertEquals(watchlists, response);
    }

    @Test
    public void testUpdateWatchlistDataManual() {
        WatchlistAddManualRequest request = new WatchlistAddManualRequest();

        doNothing().when(watchlistService).updateWatchlistDataManual(request);

        ResponseEntity<String> response = watchlistController.updateWatchlistDataManual(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Watchlist item updated successfully", response.getBody());
    }

    @Test
    public void testUpdateWatchlistDataCalc() {
        WatchlistAddCalcRequest request = new WatchlistAddCalcRequest();

        doNothing().when(watchlistService).updateWatchlistDataCalc(request);

        ResponseEntity<String> response = watchlistController.updateWatchlistDataCalc(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Watchlist item updated successfully", response.getBody());
    }

    @Test
    public void testDeleteWatchlist() {
        Long id = 1L;

        doNothing().when(watchlistService).deleteWatchlist(id);

        watchlistController.deleteWatchlist(id);

        verify(watchlistService, times(1)).deleteWatchlist(id);
    }

    @Test
    public void testSortedDisparity() {
        List<WatchlistGetRequest> watchlists = new ArrayList<>();

        when(watchlistService.sortedDisparity()).thenReturn(watchlists);

        List<WatchlistGetRequest> response = watchlistController.sortedDisparity();

        assertEquals(watchlists, response);
    }

}
package com.webapp.watchlist;

import org.aspectj.lang.annotation.Before;
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

    @Before
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









    private WatchlistController watchlistController;
    private WatchlistService watchlistService;

    @Before
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







//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//public class WatchlistControllerIntegrationTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void testAddWatchlistDataManual() {
//        // create a request body
//        WatchlistAddManualRequest request = new WatchlistAddManualRequest();
//        request.setName("AAPL");
//        request.setPrice(150.0);
//        request.setShares(100);
//
//        // send the POST request
//        ResponseEntity<String> response = restTemplate.postForEntity("/watchlist/add/manual", request, String.class);
//
//        // verify the response
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Watchlist item added successfully", response.getBody());
//    }
//}




//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//public class WatchlistControllerTests {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @MockBean
//    private WatchlistService watchlistService;
//
//    @Test
//    public void testAddWatchlistDataManual() {
//        WatchlistAddManualRequest request = new WatchlistAddManualRequest();
//
//        ResponseEntity<String> response = restTemplate.postForEntity("/add/manual", request, String.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void testAddWatchlistDataCalc() {
//        WatchlistAddCalcRequest request = new WatchlistAddCalcRequest();
//
//        ResponseEntity<String> response = restTemplate.postForEntity("/add/calc", request, String.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void testGetWatchlists() {
//        List<WatchlistGetRequest> watchlists = new ArrayList<>();
//
//        when(watchlistService.getWatchlists()).thenReturn(watchlists);
//
//        ResponseEntity<List> response = restTemplate.getForEntity("/load", List.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void testUpdateWatchlistDataManual() {
//        WatchlistAddManualRequest request = new WatchlistAddManualRequest();
//
//        ResponseEntity<String> response = restTemplate.exchange("/update/manual", HttpMethod.PUT, new HttpEntity<>(request), String.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void testUpdateWatchlistDataCalc() {
//        WatchlistAddCalcRequest request = new WatchlistAddCalcRequest();
//
//        ResponseEntity<String> response = restTemplate.exchange("/update/calc", HttpMethod.PUT, new HttpEntity<>(request), String.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void testDeleteWatchlist() {
//        Long id = 1L;
//
//        restTemplate.delete("/delete/" + id);
//
//        verify(watchlistService, times(1)).deleteWatchlist(id);
//    }
//
//    @Test
//    public void testSortedDisparity() {
//        List<WatchlistGetRequest> watchlists = new ArrayList<>();
//
//        when(watchlistService.sortedDisparity()).thenReturn(watchlists);
//
//        ResponseEntity<List> response = restTemplate.getForEntity("/sorted/disparity", List.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
}
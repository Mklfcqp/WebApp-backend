package com.webapp.portfolio;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(PortfolioController.class)
class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
    public void addCompanyToPortfolioTest() throws Exception {
        PortfolioAddRequest request = new PortfolioAddRequest();
        request.setName("Apple Inc.");
        request.setTicker("AAPL");
        request.setPrice(152.51);
        request.setNumShares(100);
        String requestJson = objectMapper.writeValueAsString(request);
        mockMvc.perform(MockMvcRequestBuilders.post("/portfolio/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Watchlist item added successfully"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
    public void getPortfolioTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/portfolio/load"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
    public void updatePortfolioTest() throws Exception {
        PortfolioAddRequest request = new PortfolioAddRequest();
        request.setId(1L); // assuming there is at least one portfolio item already in the database
        request.setName("Apple Inc.");
        request.setTicker("AAPL");
        request.setPrice(152.51);
        request.setNumShares(200);
        String requestJson = objectMapper.writeValueAsString(request);
        mockMvc.perform(MockMvcRequestBuilders.put("/portfolio/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Watchlist item updated successfully"));
    }

    @Test
    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
    public void deletePortfolioTest() throws Exception {
        Long id = 1L; // assuming there is at least one portfolio item already in the database
        mockMvc.perform(MockMvcRequestBuilders.delete("/portfolio/delete/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
    public void getPortfolioSUMTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/portfolio/load/sum"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }








//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
//    public void addCompanyToPortfolioTest() throws Exception {
//        PortfolioAddRequest request = new PortfolioAddRequest();
//        request.setName("Apple Inc.");
//        request.setTicker("AAPL");
//        request.setPrice(152.51);
//        request.setNumShares(100);
//        String requestJson = objectMapper.writeValueAsString(request);
//        mockMvc.perform(MockMvcRequestBuilders.post("/portfolio/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestJson))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Watchlist item added successfully"));
//        List<PortfolioGetRequest> portfolio = portfolioService.getPortfolio();
//        assertNotNull(portfolio);
//        assertEquals(1, portfolio.size());
//        PortfolioGetRequest portfolioItem = portfolio.get(0);
//        assertEquals("Apple Inc.", portfolioItem.getName());
//        assertEquals("AAPL", portfolioItem.getTicker());
//        assertEquals(152.51, portfolioItem.getPrice());
//        assertEquals(100, portfolioItem.getNumShares());
//    }
//
//    @Test
//    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
//    public void getPortfolioTest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/portfolio/load"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        List<PortfolioGetRequest> portfolio = portfolioService.getPortfolio();
//        assertNotNull(portfolio);
//        // add assertion here if needed
//    }
//
//    @Test
//    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
//    public void updatePortfolioTest() throws Exception {
//        PortfolioAddRequest request = new PortfolioAddRequest();
//        request.setId(1L); // assuming there is at least one portfolio item already in the database
//        request.setName("Apple Inc.");
//        request.setTicker("AAPL");
//        request.setPrice(152.51);
//        request.setNumShares(200);
//        String requestJson = objectMapper.writeValueAsString(request);
//        mockMvc.perform(MockMvcRequestBuilders.put("/portfolio/update")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestJson))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Watchlist item updated successfully"));
//        PortfolioGetRequest portfolioItem = portfolioService.getPortfolioItem(1L);
//        assertNotNull(portfolioItem);
//        assertEquals("Apple Inc.", portfolioItem.getName());
//        assertEquals("AAPL", portfolioItem.getTicker());
//        assertEquals(152.51, portfolioItem.getPrice());
//        assertEquals(200, portfolioItem.getNumShares());
//    }
//
//    @Test
//    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
//    public void deletePortfolioTest() throws Exception {
//        Long id = 1L; // assuming there is at least one portfolio item already in the database
//        mockMvc.perform(MockMvcRequestBuilders.delete("/portfolio/delete/{id}", id))
//                .andExpect(status().isOk());
//        PortfolioGetRequest portfolioItem = portfolioService.getPortfolioItem(1L);
//        assertNull(portfolioItem);
//    }
//
//    @Test
//    @WithMockUser(username = "testuser@example.com", password = "password", authorities = {"ROLE_USER"})
//    public void getPortfolioSUMTest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/portfolio/load/sum"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        PortfolioGetRequestSUM portfolioSUM = portfolioService.getPortfolioSUM();
//        assertNotNull(portfolioSUM);
//        // add assertion here if needed
//    }

}
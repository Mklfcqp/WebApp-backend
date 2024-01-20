package com.webapp.portfolio;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class PortfolioController {

    private final PortfolioService portfolioService;
}

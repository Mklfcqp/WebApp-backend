package com.webapp.portfolio;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
@CrossOrigin("https://web-app-frontend-alpha.vercel.app/")
public class PortfolioController {

    private final PortfolioService portfolioService;
}

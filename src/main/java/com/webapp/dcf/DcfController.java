package com.webapp.dcf;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dcf")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
//@CrossOrigin("https://web-app-frontend-jeolwgw0x-mkqps-projects.vercel.app/")
public class DcfController {

    private final DcfService dcfService;
}

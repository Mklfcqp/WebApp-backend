package com.webapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:5173/")
@CrossOrigin("web-app-frontend-alpha.vercel.app/")
public class UserController {

    private final UserService userService;

    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
}

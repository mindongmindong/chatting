package com.openchat.chatting.controller;

import com.openchat.chatting.dto.SignUpDTO;
import com.openchat.chatting.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class SignUpController {
    private final SignUpService signUpService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> SignUp(@RequestBody SignUpDTO signUpDTO){
        signUpService.signUp(signUpDTO);
        return ResponseEntity.ok().body("Sign-Up success");
    }
}

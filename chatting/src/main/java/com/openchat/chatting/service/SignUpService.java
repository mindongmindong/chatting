package com.openchat.chatting.service;

import com.openchat.chatting.dto.SignUpDTO;
import com.openchat.chatting.entity.User;
import com.openchat.chatting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signUp(SignUpDTO signUpDTO) {
        String userName = signUpDTO.getUserName();
        String password = signUpDTO.getPassword();

        if(userRepository.existsByUserName(userName)){
            throw new RuntimeException();
        }
        User user = User.builder()
                .userName(userName)
                .password(bCryptPasswordEncoder.encode(password))
                .build();

        userRepository.save(user);
    }
}

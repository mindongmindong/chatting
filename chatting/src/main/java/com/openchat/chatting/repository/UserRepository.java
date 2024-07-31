package com.openchat.chatting.repository;

import com.openchat.chatting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByUserName(String userName);

    User findByUserName(String userName);
}

package com.dh.sportspot.Repository;

import com.dh.sportspot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUId(String uId);
}

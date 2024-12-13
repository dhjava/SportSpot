package com.dh.sportspot.service.user;

import com.dh.sportspot.entity.user.CustomUserDetails;
import com.dh.sportspot.entity.user.User;
import com.dh.sportspot.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 사용자 정보 조회
        User user = userRepository.findByUId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // CustomUserDetails 반환
        return new CustomUserDetails(user);
    }
}

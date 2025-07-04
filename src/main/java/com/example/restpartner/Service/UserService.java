package com.example.restpartner.Service;

import com.example.restpartner.Constant.Level;
import com.example.restpartner.DTO.UserDTO;
import com.example.restpartner.Entity.UserEntity;
import com.example.restpartner.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity != null) {
            return User.withUsername(userEntity.getUsername())
                    .password(userEntity.getPassword())
                    .roles(userEntity.getLevel().name())
                    .build();
        }

        throw new UsernameNotFoundException(username);
    }

    public void create(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new IllegalStateException("이미 가입된 회원입니다");
        }
        UserEntity entity = modelMapper.map(userDTO, UserEntity.class);
        entity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        entity.setLevel(Level.USER);
        userRepository.save(entity);
    }
}

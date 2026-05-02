package de.samuel.gamevault.service;

import de.samuel.gamevault.rabbit.UserProducer;
import de.samuel.gamevault.dto.UserDTO;
import de.samuel.gamevault.exception.EmailDuplicadoException;
import de.samuel.gamevault.exception.UserNotFoundException;
import de.samuel.gamevault.mapper.UserMapper;
import de.samuel.gamevault.model.UserModel;
import de.samuel.gamevault.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserProducer userProducer;

    @Transactional
    public UserDTO saveUsers(UserDTO userDTO) {

        userRepository.findUserByEmail(userDTO.email())
                .ifPresent(user -> {
                    throw new EmailDuplicadoException(userDTO.email());
                });

        String encodedPassword = passwordEncoder.encode(userDTO.password());
        UserModel user = userMapper.map(userDTO);
        user.setPassword(encodedPassword);

        UserModel savedUser = userRepository.save(user);
        userProducer.publishEvent(savedUser);
        return userMapper.map(savedUser);
    }


    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::map)
                .toList();
    }

    public UserDTO getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::map)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        UserModel updatedUser = userMapper.map(userDTO);
        updatedUser.setId(id);

        UserModel saved = userRepository.save(updatedUser);
        userProducer.publishUpdate(saved);
        return userMapper.map(saved);
    }

    public UserDTO deleteUser(Long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userProducer.publishDelete(user);
        userRepository.delete(user);
        return userMapper.map(user);
    }
}

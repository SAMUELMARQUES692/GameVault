package de.samuel.gamevault.service;

import de.samuel.gamevault.dto.UserDTO;
import de.samuel.gamevault.exception.UserNotFoundException;
import de.samuel.gamevault.mapper.UserMapper;
import de.samuel.gamevault.model.UserModel;
import de.samuel.gamevault.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO saveUsers(UserDTO userDTO) {
        return userMapper.map(userRepository.save(userMapper.map(userDTO)));
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

        return userMapper.map(userRepository.save(updatedUser));
    }

    public void deleteUser(Long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
    }

}

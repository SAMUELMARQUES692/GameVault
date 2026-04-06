package de.samuel.gamevault.mapper;

import de.samuel.gamevault.dto.UserDTO;
import de.samuel.gamevault.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel map(UserDTO userDTO) {
       return UserModel.builder()
               .id(userDTO.id())
               .name(userDTO.name())
               .email(userDTO.email())
               .password(userDTO.password())
               .build();

    }

    public UserDTO map(UserModel user) {

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

}

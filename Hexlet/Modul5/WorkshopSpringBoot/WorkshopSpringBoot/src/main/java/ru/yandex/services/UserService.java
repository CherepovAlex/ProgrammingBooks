package ru.yandex.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.yandex.dto.User;
import ru.yandex.dto.UserDto;
import ru.yandex.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createNewUser(UserDto dto) {
        return null;
    }

    private UserDto convertToDto(User user) {
        // преобразование entity в DTO
        return new UserDto(user.getFirstName(), user.getEmail(), null); // не возвращаем пароль
    }

    public void deleteUser(long id) {
    }
}

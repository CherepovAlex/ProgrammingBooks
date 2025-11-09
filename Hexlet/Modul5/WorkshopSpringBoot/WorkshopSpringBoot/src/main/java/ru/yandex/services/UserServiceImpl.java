package ru.yandex.services;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.yandex.dto.User;
import ru.yandex.repository.UserRepository;

public class UserServiceImpl implements UserService1 {

//    private final UserRepository userRepository;
//    private final PasswordEncoder bCryptPasswordEncoder;

    public void deleteUser(long id, UserDetails authDetails) {
//        User existedUser = getUserById(id);
//        User existingUser = userRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
//        validateOwnerByEmail(existingUser.getEmail(), authDetails);
//        userRepository.delete(existingUser);
    }

    private void validateOwnerByEmail(String userEmail, UserDetails authDetails) {
        String authenticatedEmail = authDetails.getUsername();
        // логику нижу нужно убрать и перенести всё в аннотацию
        if (!authenticatedEmail.equalsIgnoreCase(userEmail)) {
            throw new AccessDeniedException("Access denied!");
        }
//        // Безопасное сравнение email с учетом регистра
//        if (!userEmail.equals(authenticatedEmail)) {
//            throw new AccessDeniedException("Access denied: You can only delete your own account");
//        }
    }
}

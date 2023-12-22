package ru.skypro.homework.manager;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;

@Component
@Data
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsManager {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;
    public void createUser(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPhone(user.getPhone());
        newUser.setRole(user.getRole());
        userRepository.save(newUser);
    }

    @Override
    public void createUser(UserDetails user) {
    }

    public void updateUser(UserDetails user) {

        //найти пользователья и обновить
    }

    public void deleteUser(String username) {
        // сделать запрос в репозиторий ти удалить
    }

    public void changePassword(String oldPassword, String newPassword) {
    }

    public boolean userExists(String username) {
        User user = userRepository.findByEmail(username);
        return user != null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return user;
    }
//org.springframework.security.core.userdetails.User.builder()
//        .username(user.getEmail())
//            .password(user.getPassword())
//            .roles(user.getRole().name())
//            .build();
}
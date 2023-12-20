package ru.skypro.homework.manager;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;

@Component
public class MyUserDetailsManager implements UserDetailsManager {
    private final UserRepository userRepository;

    public MyUserDetailsManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDetails user) {
        User newUser = new User();
        newUser.setEmail(user.getUsername());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
    }

    @Override
    public void updateUser(UserDetails user) {
        //найти пользователья и обновить
    }

    @Override
    public void deleteUser(String username) {
        // сделать запрос в репозиторий ти удалить
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        User user = userRepository.findByPassword(oldPassword);
        user.setPassword(newPassword);
    }

    @Override
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
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
//new User(user.getPk(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getRole(), user.getImage(), user.getPassword());
}
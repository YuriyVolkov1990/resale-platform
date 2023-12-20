//package ru.skypro.homework.manager;
//
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.stereotype.Service;
//import ru.skypro.homework.entity.User;
//import ru.skypro.homework.repository.UserRepository;
//
//import java.util.Collections;
//
//@Service
//public class MyUserDetailsManager implements UserDetailsManager {
//    private final UserRepository userRepository;
//
//    public MyUserDetailsManager(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void createUser(UserDetails user) {
//        User newUser = new User();
//        newUser.setEmail(user.getUsername());
//        newUser.setPassword(user.getPassword());
//        userRepository.save(newUser);
//    }
//
//    @Override
//    public void updateUser(UserDetails user) {
//        //найти пользователья и обновить
//    }
//
//    @Override
//    public void deleteUser(String username) {
//        // сделать запрос в репозиторий ти удалить
//    }
//
//    @Override
//    public void changePassword(String oldPassword, String newPassword) {
//
//    }
//
//    @Override
//    public boolean userExists(String username) {
//        return false;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("Пользователь не найден");
//        }
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getEmail())
//                .password(user.getPassword())
//                .roles(user.getRole().name())
//                .build();
//    }
//}

package ru.skypro.homework.service;

import ru.skypro.homework.dto.RegisterDto;

/**
 * Интерфейс содержит методы для авторизации и регистрации пользователя
 */
public interface AuthService {

    /**
     * Метод проверяет, произошла процедура входа пользователя в свой аккаунт, или нет
     *
     * @return возвращает true или false в зависимости от совпадения введённого пользователем пароля и пароля, хранящегося в БД
     */
    boolean login(String userName, String password);

    /**
     * Метод проверяет, произошла процедура регистрации пользователя, или нет
     *
     * @return возвращает true, если регистрация пройдена успешно и false, если такой пользователь уже зарегистрирован
     */
    boolean register(RegisterDto register);
}

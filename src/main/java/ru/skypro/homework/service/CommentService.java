package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
/**
 * Интерфейс содержит методы для работы с комментариями
 */
public interface CommentService {

    /**
     * Метод получает все комментарии к объявлению
     *
     * @param adId - идентификатор объявления
     * @return объект класса CommentsDto, содержащий List<Comment> и общее количество комментариев.
     */
    CommentsDto getCommentsByAd(Integer adId);

    /**
     * Метод добавляет новый комментарий к объявлению
     *
     * @param adId - идентификатор объявления
     * @param createOrUpdateCommentDto - DTO, содержащий текст, который нужно преобразовать в комментарий
     * @return объект класса CommentDto, содержащий текст комментария.
     */
    CommentDto postCommentToAd(Integer adId, CreateOrUpdateCommentDto createOrUpdateCommentDto, Authentication authentication);

    /**
     * Метод удаляет комментарий
     *
     * @param adId - идентификатор объявления
     * @param id - идентификатор комментария
     */
    void deleteCommentAtAd(Integer adId, Integer id);

    /**
     * Метод изменяет текст комментария
     *
     * @param adId - идентификатор объявления
     * @param id - идентификатор комментария
     * @return объект класса CommentDto, содержащий текст комментария.
     */
    CommentDto patchCommentAtAd(Integer adId, Integer id, CreateOrUpdateCommentDto createOrUpdateCommentDt);
}

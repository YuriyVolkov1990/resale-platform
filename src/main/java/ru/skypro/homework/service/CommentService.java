package ru.skypro.homework.service;

import ru.skypro.homework.dto.CommentsDto;

public interface CommentService {
    public CommentsDto getCommentsByAd(Integer adId);
}

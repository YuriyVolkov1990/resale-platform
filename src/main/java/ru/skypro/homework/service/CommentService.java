package ru.skypro.homework.service;

import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;

import javax.xml.stream.events.Comment;

public interface CommentService {
    CommentsDto getCommentsByAd(Integer adId);

    CommentDto postCommentToAd(Integer adId);

    CommentDto deleteCommentAtAd(Integer adId, Integer id);

    CommentDto patchCommentAtAd(Integer adId, Integer id);
}

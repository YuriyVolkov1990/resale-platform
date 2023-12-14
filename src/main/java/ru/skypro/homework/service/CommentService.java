package ru.skypro.homework.service;

import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;

import javax.xml.stream.events.Comment;

public interface CommentService {
    public CommentsDto getCommentsByAd(Integer adId);

    public CommentDto postCommentToAd(Integer adId);

    public CommentDto deleteCommentAtAd(Integer adId, Integer id);

    public CommentDto patchCommentAtAd(Integer adId, Integer id);
}

package ru.skypro.homework.service;

import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;

import javax.xml.stream.events.Comment;

public interface CommentService {
    CommentsDto getCommentsByAd(Integer adId);

    CommentDto postCommentToAd(Integer adId, CreateOrUpdateCommentDto createOrUpdateCommentDto);

    CommentDto deleteCommentAtAd(Integer adId, Integer id);

    CommentDto patchCommentAtAd(Integer adId, Integer id, CreateOrUpdateCommentDto createOrUpdateCommentDt);
}

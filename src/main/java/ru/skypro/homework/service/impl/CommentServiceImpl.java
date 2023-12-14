package ru.skypro.homework.service.impl;

import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.service.CommentService;

public class CommentServiceImpl implements CommentService {

    @Override
    public CommentsDto getCommentsByAd(Integer adId) {
        return null;
    }// по ид объявления нужно вытащить все коменты

    @Override
    public CommentDto postCommentToAd(Integer adId) {
        return null;
    }// по ид объявления добавить коментарий

    @Override
    public CommentDto deleteCommentAtAd(Integer adId, Integer id) {
        return null;
    }//

    @Override
    public CommentDto patchCommentAtAd(Integer adId, Integer id) {
        return null;
    }// как удаление, толкьо на вход ещё реквест бади
}

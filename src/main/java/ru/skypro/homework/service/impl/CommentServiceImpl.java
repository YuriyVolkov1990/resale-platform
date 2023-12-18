package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentMapper commentMapper, CommentRepository commentRepository) {
        this.commentMapper = commentMapper;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentsDto getCommentsByAd(Integer adId) {
        List<Comment> comments = commentRepository.getCommentByAdId(adId);
        return commentMapper.mapToCommentsDto(comments);
    }// по ид объявления нужно вытащить все коменты

    @Override
    public CommentDto postCommentToAd(Integer adId, CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        return null;
    }// по ид объявления добавить коментарий

    @Override
    public CommentDto deleteCommentAtAd(Integer adId, Integer id) {
        return null;
    }//

    @Override
    public CommentDto patchCommentAtAd(Integer adId, Integer id, CreateOrUpdateCommentDto createOrUpdateCommentDt) {
        return null;
    }// как удаление, толкьо на вход ещё реквест бади
}

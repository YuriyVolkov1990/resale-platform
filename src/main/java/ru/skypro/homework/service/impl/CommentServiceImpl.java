package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final AdsRepository adsRepository;
    private final AdMapper adMapper;

    @Override
    public CommentsDto getCommentsByAd(Integer adId) {
        Ad ad = adsRepository.getAdByPk(adId);
        List<Comment> comments = commentRepository.findAllByAd(ad);
        ad.setComments(comments);
        adsRepository.save(ad);
        return commentMapper.mapToCommentsDto(comments);
    }// по ид объявления нужно вытащить все коменты

    @Override
    public CommentDto postCommentToAd(Integer adId, CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        Comment comment = new Comment();
        String text = createOrUpdateCommentDto.getText();
        comment.setText(text);
        Ad ad = adsRepository.getAdByPk(adId);
        comment.setAuthor(ad.getUser().getPk());
        comment.setAuthorFirstName(ad.getUser().getFirstName());
        comment.setCreatedAt(System.currentTimeMillis());
        comment.setAd(ad);
        List<Comment> newComment = new ArrayList<>();
        newComment.add(comment);
        ad.setComments(newComment);
        commentRepository.save(comment);
        return commentMapper.mapToCommentDto(comment);
    }// по ид объявления добавить коментарий

    @Override
    public void deleteCommentAtAd(/*Integer adId,*/ Integer id) {
        commentRepository.deleteById(id);
    }//

    @Override
    public CommentDto patchCommentAtAd(Integer adId, Integer id, CreateOrUpdateCommentDto createOrUpdateCommentDt) {
        return null;
    }// как удаление, толкьо на вход ещё реквест бади
}

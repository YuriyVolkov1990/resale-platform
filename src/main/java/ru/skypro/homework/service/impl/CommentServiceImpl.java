package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.CommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, имплементирующий CommentService
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;

    @Override
    public CommentsDto getCommentsByAd(Integer adId) {
        Ad ad = adsRepository.findAdByPk(adId);
        List<Comment> comments = commentRepository.findAllByAd(ad);
        ad.setComments(comments);
        adsRepository.save(ad);
        return commentMapper.mapToCommentsDto(comments);
    }

    @Override
    public CommentDto postCommentToAd(Integer adId, CreateOrUpdateCommentDto createOrUpdateCommentDto, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        Comment comment = new Comment();
        String text = createOrUpdateCommentDto.getText();
        comment.setText(text);
        Ad ad = adsRepository.findAdByPk(adId);
        comment.setAuthor(user.getPk());
        comment.setAuthorFirstName(user.getFirstName());
        comment.setCreatedAt(System.currentTimeMillis());
        comment.setAd(ad);
        List<Comment> newComment = new ArrayList<>();
        newComment.add(comment);
        ad.setComments(newComment);
        commentRepository.save(comment);
        return commentMapper.mapToCommentDto(comment);
    }

    @Override
    public void deleteCommentAtAd(Integer adId, Integer id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto patchCommentAtAd(Integer adId, Integer id, CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        Ad ad = adsRepository.findAdByPk(adId);
        Comment comment = commentRepository.findCommentByPk(id);
        comment.setText(createOrUpdateCommentDto.getText());
        commentRepository.save(comment);
        return commentMapper.mapToCommentDto(comment);
    }
}

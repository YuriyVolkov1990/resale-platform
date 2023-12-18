package ru.skypro.homework.mapper;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.entity.Comment;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentMapper {
    public CommentDto mapToCommentDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setAuthorId(comment.getAuthor());
        dto.setAuthorImage(comment.getAuthorImage());
        dto.setAuthorFirstName(comment.getAuthorFirstName());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setText(comment.getText());
        dto.setPk(comment.getId());
        return dto;
    }
    public Comment mapToComment(CommentDto dto) {
        Comment comment = new Comment();
        comment.setAuthor(dto.getAuthorId());
        comment.setAuthorImage(dto.getAuthorImage());
        comment.setAuthorFirstName(dto.getAuthorFirstName());
        comment.setCreatedAt(dto.getCreatedAt());
        dto.setText(comment.getText());
        dto.setPk(comment.getId());
        return comment;
    }
    public CommentsDto mapToCommentsDto(List<Comment> comments) {
        CommentsDto commentsDto = new CommentsDto();
        commentsDto.setResults(comments);
        Integer count = comments.size();
        commentsDto.setCount(count);
        return commentsDto;
    }

    public List<Comment> mapToComments(CommentsDto commentsDto) {
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i <= commentsDto.getCount(); i++) {
            comments.add(i,commentsDto.getResults().get(i));
        }
        return comments;
    }

    public CreateOrUpdateCommentDto mapToCreateOrUpdateCommentDto(Comment comment) {
        CreateOrUpdateCommentDto dto = new CreateOrUpdateCommentDto();
        dto.setText(comment.getText());
        return dto;
    }
}

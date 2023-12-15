package ru.skypro.homework.controller;

import liquibase.pro.packaged.R;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.service.CommentService;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<CommentsDto> getComments(@PathVariable Integer id) {
            return ResponseEntity.ok(commentService.getCommentsByAd(id));
        }

    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentDto> getComment(@PathVariable Integer id, @RequestBody CreateOrUpdateCommentDto createOrUpdateCommentDto) {
            return ResponseEntity.ok(commentService.postCommentToAd(id, createOrUpdateCommentDto));
        }

    @DeleteMapping("/{adId}/comments/{commentId}")
    public void deleteComment(@PathVariable Integer adId, @PathVariable Integer id) {
        }

    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<CommentDto> patchComment(@PathVariable Integer adId, @PathVariable Integer id, @RequestBody CreateOrUpdateCommentDto createOrUpdateCommentDto) {
            return ResponseEntity.ok(commentService.patchCommentAtAd(adId, id, createOrUpdateCommentDto));
        }
}

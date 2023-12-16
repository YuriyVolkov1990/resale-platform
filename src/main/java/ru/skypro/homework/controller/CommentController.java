package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.service.CommentService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/{id}/comments", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentsDto> getComments(@PathVariable(required = true) Integer id) {
            return ResponseEntity.ok(commentService.getCommentsByAd(id));
        }

    @PostMapping(value = "/{id}/comments", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDto> getComment(@PathVariable(required = true) Integer id, @RequestBody(required = false) CreateOrUpdateCommentDto createOrUpdateCommentDto) {
            return ResponseEntity.ok(commentService.postCommentToAd(id, createOrUpdateCommentDto));
        }

    @DeleteMapping("/{adId}/comments/{commentId}")
    public void deleteComment(@PathVariable(required = true) Integer adId, @PathVariable(required = true) Integer id) {
        }

    @PatchMapping(value = "/{adId}/comments/{commentId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDto> patchComment(@PathVariable(required = true) Integer adId, @PathVariable(required = true) Integer id, @RequestBody(required = false) CreateOrUpdateCommentDto createOrUpdateCommentDto) {
            return ResponseEntity.ok(commentService.patchCommentAtAd(adId, id, createOrUpdateCommentDto));
        }
}

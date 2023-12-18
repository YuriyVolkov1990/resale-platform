package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AuthService;
import ru.skypro.homework.service.CommentService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class CommentController {
    private final CommentService commentService;
//    private final AuthService authService;
//    private final UserRepository userRepository;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
//        this.authService = authService;
//        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{id}/comments", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentsDto> getComments(@PathVariable(required = true) Integer id) {
            return ResponseEntity.ok(commentService.getCommentsByAd(id));
        }

    @PostMapping(value = "/{id}/comments", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDto> getComment(@PathVariable(required = true) Integer id,
                                                 @RequestBody(required = false) CreateOrUpdateCommentDto createOrUpdateCommentDto) {
            return ResponseEntity.ok(commentService.postCommentToAd(id, createOrUpdateCommentDto));
        }

    @DeleteMapping(value = "/comments/{commentId}")///{adId}
    public void deleteComment(/*@PathVariable(required = false) Integer adId,*/
                              @PathVariable(required = true) Integer commentId) {
        commentService.deleteCommentAtAd(/*adId,*/ commentId);
        }

    @PatchMapping(value = "/{adId}/comments/{commentId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDto> patchComment(@PathVariable(required = true) Integer adId,
                                                   @PathVariable(required = true) Integer id,
                                                   @RequestBody(required = false) CreateOrUpdateCommentDto createOrUpdateCommentDto) {
            return ResponseEntity.ok(commentService.patchCommentAtAd(adId, id, createOrUpdateCommentDto));
        }
}

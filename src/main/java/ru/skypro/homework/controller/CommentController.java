package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.service.CommentService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    @Operation(
            tags = "Комментарии",
            summary = "Получение комментариев объявления",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CommentsDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content()
                    )
            }
    )
    @GetMapping(value = "/{id}/comments", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentsDto> getComments(@PathVariable(required = true) Integer id) {
        logger.info("Запущен метод CommentController getComments: Получение комментариев объявления");
        return ResponseEntity.ok(commentService.getCommentsByAd(id));
        }

    @Operation(
            tags = "Комментарии",
            summary = "Добавление комментария к объявлению",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CommentsDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content()
                    )
            }
    )
    @PostMapping(value = "/{id}/comments", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDto> postComment(@PathVariable(required = true) Integer id,
                                                  @RequestBody(required = false) CreateOrUpdateCommentDto createOrUpdateCommentDto,
                                                  Authentication authentication) {
        logger.info("Запущен метод CommentController postComment: Добавление комментария к объявлению");
        return ResponseEntity.ok(commentService.postCommentToAd(id, createOrUpdateCommentDto, authentication));
        }

    @Operation(
            tags = "Комментарии",
            summary = "Удаление комментария",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content()
                    )
            }
    )
    @DeleteMapping(value = "/{adId}/comments/{commentId}")
    @PreAuthorize(value = "hasRole('ADMIN') or @adsServiceImpl.isUserAd(authentication.getName(), #id)")
    public void deleteComment(@PathVariable(required = false) Integer adId,
                              @PathVariable(required = true) Integer commentId) {
        logger.info("Запущен метод CommentController deleteComment: Удаление комментария");
        commentService.deleteCommentAtAd(adId, commentId);
        }

    @Operation(
            tags = "Комментарии",
            summary = "Обновление комментария",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CommentsDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content()
                    )
            }
    )
    @PatchMapping(value = "/{adId}/comments/{commentId}", produces = APPLICATION_JSON_VALUE)
    @PreAuthorize(value = "hasRole('ADMIN') or @adsServiceImpl.isUserAd(authentication.getName(), #id)")
    public ResponseEntity<CommentDto> patchComment(@PathVariable Integer adId,
                                                   @PathVariable Integer commentId,
                                                   @RequestBody(required = false) CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        logger.info("Запущен метод CommentController patchComment: Обновление комментария");
        return ResponseEntity.ok(commentService.patchCommentAtAd(adId, commentId, createOrUpdateCommentDto));
        }
}

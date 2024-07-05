package com.sparta.legendofdelivery.domain.like.controller;

import com.sparta.legendofdelivery.domain.like.dto.LikeResponseDto;
import com.sparta.legendofdelivery.domain.like.service.LikeService;
import com.sparta.legendofdelivery.domain.user.security.UserDetailsImpl;
import com.sparta.legendofdelivery.global.dto.DataResponse;
import com.sparta.legendofdelivery.global.dto.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/reviews/{reviewId}/like")
    public ResponseEntity<MessageResponse> addLike(@PathVariable Long reviewId,
                                                   @AuthenticationPrincipal UserDetailsImpl userDetails) {

        return ResponseEntity.ok(likeService.addLike(reviewId, userDetails.getUser()));

    }

    @DeleteMapping("/reviews/{reviewId}/like")
    public ResponseEntity<MessageResponse> deleteLike(@PathVariable Long reviewId,
                                                      @AuthenticationPrincipal UserDetailsImpl userDetails) {

        return ResponseEntity.ok(likeService.deleteLike(reviewId, userDetails.getUser()));

    }

    @GetMapping("/likes/my")
    public ResponseEntity<DataResponse<List<LikeResponseDto>>> getMyLikes(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                          @RequestParam(value = "size", defaultValue = "5") int size,
                                                                          @RequestParam(value = "sortBy", defaultValue = "createAt") String sortBy) {
        DataResponse<List<LikeResponseDto>> response = likeService.getMyLikes(page, size, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

package com.sparta.legendofdelivery.domain.like.dto;

import com.sparta.legendofdelivery.domain.like.entity.Like;
import lombok.Getter;

@Getter
public class LikeResponseDto {

    private Long id;
    private Long userId;
    private Long reviewId;
    private String reviewContent;

    public LikeResponseDto(Like like) {
        this.id = like.getId();
        this.userId = like.getUser().getId();
        this.reviewId = like.getReview().getId();
        this.reviewContent = like.getReview().getContent();
    }
}

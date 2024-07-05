package com.sparta.legendofdelivery.domain.like.service;

import com.sparta.legendofdelivery.domain.like.dto.LikeResponseDto;
import com.sparta.legendofdelivery.domain.like.entity.Like;
import com.sparta.legendofdelivery.domain.like.repository.LikeRepository;
import com.sparta.legendofdelivery.domain.review.entity.Review;
import com.sparta.legendofdelivery.domain.review.repository.ReviewRepository;
import com.sparta.legendofdelivery.domain.user.entity.User;
import com.sparta.legendofdelivery.domain.user.repository.UserRepository;
import com.sparta.legendofdelivery.domain.user.service.UserService;
import com.sparta.legendofdelivery.global.dto.DataResponse;
import com.sparta.legendofdelivery.global.dto.MessageResponse;
import com.sparta.legendofdelivery.global.exception.BadRequestException;
import com.sparta.legendofdelivery.global.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class LikeService {

    private static final Logger logger = LoggerFactory.getLogger(LikeService.class);

    private final LikeRepository likeRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public LikeService(LikeRepository likeRepository, ReviewRepository reviewRepository, UserRepository userRepository, UserService userService) {
        this.likeRepository = likeRepository;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public MessageResponse addLike(Long reviewId, User user) {

        Review review = findReviewById(reviewId);

        if (review.getUser().getId().equals(user.getId())){
            throw new BadRequestException("본인이 작성한 리뷰에는 좋아요를 할 수 없습니다.");
        }

        Like checkIsLike = findLikeByReviewIdAndUserId(reviewId, user.getId());

        if (checkIsLike != null) {
            throw new BadRequestException("이미 좋아요를 누른 리뷰입니다.");
        } else {
            Like like = new Like(review, user);
            review.upLikesCount();
            user.upLikesCount();
            likeRepository.save(like);
            reviewRepository.save(review);
            userRepository.save(user);
            return new MessageResponse(200, "좋아요 등록에 성공했습니다.");
        }

    }

    public MessageResponse deleteLike(Long reviewId, User user) {
        Review review = findReviewById(reviewId);
        Like checkIslike = findLikeByReviewIdAndUserId(reviewId, user.getId());

        if (checkIslike == null) {
            throw new NotFoundException("해당 리뷰는 좋아요가 등록되어 있지 않습니다.");
        } else {
            review.downLikesCount();
            user.downLikesCount();
            likeRepository.delete(checkIslike);
            reviewRepository.save(review);
            userRepository.save(user);
            return new MessageResponse(200, "좋아요 취소를 성공했습니다.");
        }

    }

    public DataResponse<List<LikeResponseDto>> getMyLikes(int page, int size, String sortBy) {
        User user = userService.getUser();
        Sort sort = Sort.by(Sort.Direction.DESC, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<LikeResponseDto> likesPage = likeRepository.findAllByUser(user, pageable).map(LikeResponseDto::new);
        List<LikeResponseDto> likesList = likesPage.getContent();

        if (likesList.isEmpty()) {
            throw new NotFoundException("좋아요를 등록한 리뷰가 없습니다.");
        }
        return new DataResponse<>(200, "사용자가 좋아요를 등록한 리뷰 조회에 성공했습니다.", likesList);
    }

    private Review findReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(
                () -> new NotFoundException("해당 id를 가진 리뷰가 없습니다.")
        );
    }

    private Like findLikeByReviewIdAndUserId(Long reviewId, Long userId) {
        return likeRepository.findLikeByReviewIdAndUserId(reviewId,userId).orElse(null);
    }

}

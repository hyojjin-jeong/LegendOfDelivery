package com.sparta.legendofdelivery.domain.user.entity;

import com.sparta.legendofdelivery.domain.user.dto.UserSignupRequestDto;
import com.sparta.legendofdelivery.domain.user.oauth.dto.KakaoUserDto;
import com.sparta.legendofdelivery.global.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(name = "likes_count")
    private Long likesCount;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Column
    private String refreshToken;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserOauth oauth;

    @Column
    private Long kakaoId;

    @ElementCollection
    private List<String> passwordList = new LinkedList<>();

    private static final int PASSWORD_LENGTH = 3;

    public User(UserSignupRequestDto requestDto, UserRole role, UserStatus status, UserOauth oauth) {
        this.userId = requestDto.getUserId();
        this.password = requestDto.getPassword();
        this.email = requestDto.getEmail();
        this.name = requestDto.getName();
        this.role = role;
        this.status = status;
        this.oauth = oauth;
        this.likesCount = 0L;
    }

    public User(KakaoUserDto kakaoUserDto, String password, UserRole role, UserStatus status, UserOauth oauth) {
        this.userId = kakaoUserDto.getId() + kakaoUserDto.getEmail();
        this.password = password;
        this.email = kakaoUserDto.getEmail();
        this.name = kakaoUserDto.getNickname();
        this.kakaoId = kakaoUserDto.getId();
        this.role = role;
        this.status = status;
        this.oauth = oauth;
        this.likesCount = 0L;
    }

    public void encryptionPassword(String encryptionPassword) {
        this.password = encryptionPassword;

        if (passwordList.size() >= PASSWORD_LENGTH) {
            passwordList.remove(0);
        }

        passwordList.add(encryptionPassword);
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void updateStatus(UserStatus status) {
        this.status = status;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateUserRole(UserRole role) {
        this.role = role;
    }

    public void upLikesCount(){
        this.likesCount += 1L;
    }

    public void downLikesCount(){
        this.likesCount -= 1L;
    }

}

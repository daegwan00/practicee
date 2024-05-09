package com.bob.silver_watch_server.member.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor // 모든 필드를 초기화하는 생성자 자동 생성
public class LoginReqVo {
    private String loginId;
    private String password;

}

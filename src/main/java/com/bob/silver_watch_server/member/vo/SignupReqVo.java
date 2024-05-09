package com.bob.silver_watch_server.member.vo;
// 회원 가입 시 입력받은 값을 객체 형태로 전달하기 위해 정의된 SignupReqVo 클래스
// VO(Value Object) 또는 DTO(Data Transfer Object)로, 클라이언트 요청으로부터 데이터를 캡슐화하는 역할
import lombok.Builder;
import lombok.Getter;

// 회원가입 시 입력 받아 온 값을 객체 형태로 전달 받음
@Getter
@Builder
public class SignupReqVo {

    private String loginId;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String birthday;
    private String address;
    private String disease;
}

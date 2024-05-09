package com.bob.silver_watch_server.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter // getter는 값을 읽기 위한 setter는 변경되면 안돼서 안씀
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 키값 생성
    private Long id;
    private String loginId;
    private String password;
    private String email;

    private String name;
    private String phone;
    private String birthday;
    private String address;
    private String disease;// 질병

    @Builder //생성 될때만 값을 들어 갈 수 있도록 하는 어노테이션
    public Member(String loginId, String email, String password, String name, String phone, String birthday, String address, String disease){

        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.disease = disease;
    }

}

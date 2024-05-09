package com.bob.silver_watch_server.member.service;

import com.bob.silver_watch_server.member.domain.Member;
import com.bob.silver_watch_server.member.repository.MemberRepository;
import com.bob.silver_watch_server.member.vo.LoginReqVo;
import com.bob.silver_watch_server.member.vo.SignupReqVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

// 조건 확인하는 곳
//회원 가입 기능을 처리하는 서비스 클래스로, 회원 데이터의 저장을 담당하는 로직을 구현
@Service
@AllArgsConstructor
public class MemberService {
    final MemberRepository memberRepository;
    public void createMember(SignupReqVo signupReqVo){


        // 신규 회원등록
        memberRepository.save(Member
                .builder()
                .name(signupReqVo.getName())
                .phone(signupReqVo.getPhone())
                .address(signupReqVo.getAddress())
                .disease(signupReqVo.getDisease())
                .birthday(signupReqVo.getBirthday())
                .email(signupReqVo.getEmail())
                .loginId(signupReqVo.getLoginId())
                .password(signupReqVo.getPassword())
                .build()); // save가 회원저장
    }

    public boolean login(LoginReqVo loginReqVo) {
        Optional<Member> member = memberRepository.findByLoginId(loginReqVo.getLoginId());
        if (member.isPresent()) {
            return member.get().getPassword().equals(loginReqVo.getPassword());
        }

        return false;
    }
}


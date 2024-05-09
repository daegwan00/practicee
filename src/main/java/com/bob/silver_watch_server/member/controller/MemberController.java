package com.bob.silver_watch_server.member.controller;

import com.bob.silver_watch_server.member.service.MemberService;
import com.bob.silver_watch_server.member.vo.LoginReqVo;
import com.bob.silver_watch_server.member.vo.SignupReqVo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.annotation.RequestScope;

@Controller
@ResponseBody
@RequestMapping("/api/v1/members")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:62088", methods = {RequestMethod.POST}, allowedHeaders = "*")

public class MemberController {
    final private MemberService memberService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupReqVo signupReqVo){
        memberService.createMember(signupReqVo);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginReqVo loginReqVo){
        boolean isAuthenticated = memberService.login(loginReqVo);
        if(isAuthenticated){
            return ResponseEntity.ok("로그인 성공");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }
}

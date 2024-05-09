package com.bob.silver_watch_server.member.repository;

//JpaRepository 인터페이스를 확장하여, Member 엔티티의 저장소(repository)
// 역할을 하는 MemberRepository 인터페이스를 정의
import com.bob.silver_watch_server.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// findbyid자체는 long type인데
// 여기 repository에서 optional 을 이용해 string type으로 바꿔줄 수 잇다
public interface MemberRepository extends JpaRepository<Member, Long> {


    Optional<Member> findByEmail(String email);


    Optional<Member> findByLoginId(String loginId);
}

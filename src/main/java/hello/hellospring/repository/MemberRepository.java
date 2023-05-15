package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 고객 저장
    Optional<Member> findById(Long id); // id로 찾기
    Optional<Member> findByName(String name);   // name 으로 찾기
    List<Member> findAll(); // 모두 찾기
}

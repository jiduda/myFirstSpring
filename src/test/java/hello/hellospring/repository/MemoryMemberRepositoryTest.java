package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {   // 테스트 케이스

    MemoryMemberRepository repository = new MemoryMemberRepository(); // 동적 바인딩

    @AfterEach  // 메서드 하나가 끝날 때마다 실행
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();   // 멤버 인스턴스 생성
        member.setName("spring");   // 멤버 name : spring

        repository.save(member);    // 멤버에 id 값 저장

        Member result = repository.findById(member.getId()).get();  // id가 있을 경우 멤버, 없을 경우 null 가져옴
        System.out.println("result = " + (result == member));   // id 부여한 멤버와 id로 찾은 멤버가 같다면 True 아니면 False 출력
        assertThat(member).isEqualTo(result);    //core, Assertion.assertThat -> assertThat
    }

    @Test
    public void findByName(){
        Member m1 = new Member();   // 멤버의 인스턴스 m1 생성
        m1.setName("m1");   // m1 name: m1
        repository.save(m1);    // m1에 id 값 부여

        Member m2 = new Member();
        m2.setName("m2");
        repository.save(m2);

        Member result = repository.findByName("m1").get();

        assertThat(result).isEqualTo(m1);

    }

    @Test
    public void findAll(){
        Member m1 = new Member();
        m1.setName("m1");
        repository.save(m1);

        Member m2 = new Member();
        m2.setName("m2");
        repository.save(m2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}

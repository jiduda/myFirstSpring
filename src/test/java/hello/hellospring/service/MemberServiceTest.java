package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");
        // when
        Long memberId = memberService.join(member);
        // then
        Member findMember = memberService.fineOne(memberId).get();
        assertThat(findMember.getId()).isEqualTo(member.getId());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("same");

        Member member2 = new Member();
        member2.setName("same");
        // when
        Long memberId1 = memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("중복된 이름이 있습니다.");
        /*try {
            Long memberId2 = memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        } catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("중복된 이름이 있습니다.");
        }*/
        // then
    }

}
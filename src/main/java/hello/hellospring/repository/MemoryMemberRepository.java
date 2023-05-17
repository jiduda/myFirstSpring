package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();   // id, member 저장할 임시 hash
    private static long sequence = 0L;  // 임시 id 값

    @Override
    public Member save(Member member) { // 멤버 id 저장
        member.setId(++sequence);   // 멤버에 +1한 id 값 저장
        store.put(member.getId(), member);  // id와 멤버를 저장하는 Hash
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.of(store.get(id));  // id를 가져옴 member or null
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))    // member에서 파라미터와 같으면 출력
                .findAny();
    }

    @Override
    public List<Member> findAll() { // 모든 밸류(모든 값) 출력
        return new ArrayList<>(store.values());
    }

    public void clearStore(){   // 테스트를 위한 clear 메서드
        store.clear();
    }
}

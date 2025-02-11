package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements  MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 실무에서는 동시성 문제때문에 Concurrent HashMap 사용
    private static long sequence = 0L; // 마찬가지로 동시성 문제 때문에 실무에서는 atomic long

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    /* 결과가 없을 경우 null이 반환될 가능성이 있으면 Optional을 감싼다.
    -> 이후 클라이언트에서 관련된 처리를 할 수 있음*/

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

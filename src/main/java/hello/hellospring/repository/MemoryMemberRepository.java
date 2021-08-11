package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    // implements Mem..치고 옵션엔터하면 아까 정의한 네가지 기능 포맷을 자동으로 만들 수 있음.

    private static Map<Long, Member> store = new HashMap<>(); //save 해놓을 곳
    // 실무에서는 동시성 문제가 있기 때문에 HashMap보다 ConcurrentHashMap을 사용함
    private static long sequence = 0L;
    // 마찬가지로 실무에서는 long 보다는 동시성 문제를 위해 AtomicLong을 사용함

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //id로 회원 검색. 만약에 없으면 null반환하므로 Optional로 묶음
        //이렇게 하면 이후에 클라이언트에서 뭘 할수가 있다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //stream은 람다함수를 사용할 수 있도록 해줌. 대표적으로 stream().map(), filter(), sorted()
                .filter(member -> member.getName().equals(name)) //람다함수. filter는 특정 조건이 만족하는 녀석만 리턴해줌.
                .findAny(); //findAny()는 하나라도 찾으면 반환. Optional로 반환이므로 null도 가능.
        //람다로 구현한 거임.
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}

package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional; // null을 처리하는 방법. findById에서 null이 올 수 있는데, 이걸 Optional로 감싸서 보내는 것이 보통이다.

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //java8에 들어간 기능인 optional은 null반환 함수를 처리해주는 기능이다
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
//네 가지 기능을 구현했다.
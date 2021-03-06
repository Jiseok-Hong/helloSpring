package jpabook.jpashop.repository;
import jpabook.jpashop.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findBYId(Long id);
    Optional<Member> findBYName(String name);
    List<Member> findAll();

}

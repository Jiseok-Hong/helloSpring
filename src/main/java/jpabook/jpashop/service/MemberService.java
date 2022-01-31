package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * Register
     */
    public Long join(Member member) {
        //If the same username is already existed in the repository
        validateDuplicatedUsername(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedUsername(Member member) {
        memberRepository.findBYName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("User name is already existed");
                    });
    }

    /**
     * Find all the members
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findBYId(memberId);
    }
}

package jpabook.jpashop;

import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.MemoryMemberRepository;
import jpabook.jpashop.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

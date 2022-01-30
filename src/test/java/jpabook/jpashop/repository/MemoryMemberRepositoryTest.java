package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void AfterEach() {
        repository.clearStore();
    }

    @Test
    public void Save(){
        Member member = new Member();
        member.setName("Jiseok");
        repository.save(member);
        Member result = repository.findBYId(member.getId()).get();
        //Assertions.assertEquals( member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);
        Member result1 = repository.findBYName(member1.getName()).get();


        assertThat(member1).isEqualTo(result1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}

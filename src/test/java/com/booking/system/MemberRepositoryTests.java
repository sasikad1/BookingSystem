package com.booking.system;

import com.booking.system.entity.Member;
import com.booking.system.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository repo;

    @Autowired
    public TestEntityManager entityManager;

    @Test
    public void testCreateMember(){
        Member member = new Member();
        member.setFirstName("ha");
        member.setLastName("na");
        member.setPassword("123123");
        member.setPhoneNumber("0715156233");
        member.setEmail("a@gmail.com");

        Member savedMember = repo.save(member);

        Member existMember = entityManager.find(Member.class, savedMember.getId());

        assertThat(member.getEmail()).isEqualTo(existMember.getEmail());
    }
}

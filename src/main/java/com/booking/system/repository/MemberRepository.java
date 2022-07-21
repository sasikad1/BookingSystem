package com.booking.system.repository;

import com.booking.system.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, Long> {

    Member findByEmailAndPassword(String email, String password);
}

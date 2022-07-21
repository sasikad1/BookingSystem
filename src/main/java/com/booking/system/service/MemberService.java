package com.booking.system.service;

import com.booking.system.entity.Member;

import java.util.List;

public interface MemberService {

    Member saveMember(Member member);

    Member member(String email, String password);
}

package com.booking.system.service.impl;

import com.booking.system.entity.Member;
import com.booking.system.repository.DoctorRepository;
import com.booking.system.repository.MemberRepository;
import com.booking.system.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    public MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        super();
        this.memberRepository = memberRepository;
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Member member(String email, String password){
        Member member = memberRepository.findByEmailAndPassword(email, password);
        return member;
    }

}

package com.booking.system.controller;

import com.booking.system.entity.Doctor;
import com.booking.system.entity.Member;
import com.booking.system.repository.MemberRepository;
import com.booking.system.service.DoctorService;
import com.booking.system.service.MemberService;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;
    public MemberService memberService;

    public MemberController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String MemberPage(){
        return "members";
    }

    //html page name
    @GetMapping("/member_register")
    public String showSignUpForm(Model model){
        model.addAttribute("members", new Member());
        return "member_register";
    }

    @PostMapping("/members")
    public String Member (@ModelAttribute("member") Member member){
        memberService.saveMember(member);
        return "redirect:/members";
    }

//login
//    @GetMapping("/member_login")
//    public String MemberLogin(){
//        return "member_login";
//    }

    @GetMapping("/member_login")
    public ModelAndView member(){
        ModelAndView mav = new ModelAndView("member_login");
        mav.addObject("Members", new Member());
        return mav;
    }

    @PostMapping("member_login")
    public String member (@ModelAttribute("Members") Member member){

        Member oauthUser = memberService.member(member.getEmail(), member.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser))
        {
            return "redirect:/";
        }else{
            return "redirect:/member";
        }
    }
}

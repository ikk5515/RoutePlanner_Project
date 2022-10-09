package RoutePlanner.core.controller;

import RoutePlanner.core.Service.MemberService;
import RoutePlanner.core.domain.member.Member;
import RoutePlanner.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Slf4j
@Controller
public class UserController {

    @Autowired
    private final MemberService memberService;

    private final MemberRepository memberRepository;

    @GetMapping("/signUp")
    public String dispsignup(Member member) {
        return "/members/signup";
    }

    @PostMapping("/signUp")
    public String save(@ModelAttribute("member") @Valid Member member, BindingResult bindingResult, Model model) {

        if (memberRepository.existsByUserID(member.getUserID())) {
            bindingResult.rejectValue("userID", "userIdError", "이미 존재하는 아이디입니다.");
        }
        if (memberRepository.existsByUserName(member.getUserName())) {
            bindingResult.rejectValue("userName", "userNameError", "이미 존재하는 유저네임입니다.");
        }
        if (memberRepository.existsByUserEmail(member.getUserEmail())) {
            bindingResult.rejectValue("userEmail", "userEmailError", "이미 존재하는 이메일입니다.");
        }
        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "/members/signup";
        }
        if (!member.getUserPassword1().equals(member.getUserPassword2())) {
            bindingResult.rejectValue("userPassword2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
            return "/members/signup";
        }
        try {
            memberService.create(member.getId(), member.getUserID(), member.getUserPassword1(), member.getUserName(), member.getUserGender(), member.getUserEmail());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            log.info("error = {}", bindingResult);
            return "/members/signup";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "/members/signup";
        }
        log.info("회원가입 성공!");
        return "redirect:Main";
    }

    @GetMapping("/Main")
    public String mainPage() {
        return "/main";
    }
}
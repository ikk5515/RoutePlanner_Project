package RoutePlanner.core.controller;

import RoutePlanner.core.Service.MemberService;
import RoutePlanner.core.Service.SurveyService;
import RoutePlanner.core.domain.member.Member;
import RoutePlanner.core.domain.survey.Memsur;
import RoutePlanner.core.domain.survey.Survey;
import RoutePlanner.core.repository.MemberRepository;
import RoutePlanner.core.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Slf4j
@Controller
public class UserController {

    private final MemberService memberService;
    private final SurveyService surveyService;

    private final MemberRepository memberRepository;
    private final SurveyRepository surveyRepository;

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
        model.addAttribute("message", "회원가입이 완료되었습니다.");
        model.addAttribute("nextUrl", "/Login");
        return "/setting/message";
    }

    @GetMapping("/Main")
    public String mainPage() {
        return "/main";
    }

    @GetMapping("/SurveyForm")
    public String SurveyPage(Survey survey)
    {
        return "/surveyForm";
    }

    @PostMapping("/SurveyForm")
    public String save(@ModelAttribute("survey") @Valid Memsur memsur, BindingResult bindingResult, Model model) {
        Object principaluser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principaluser;
        String userID = userDetails.getUsername();

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "/surveyForm";
        }

        if (surveyRepository.existsByUserID(userID)) {
            surveyService.delete(userID);
        }

        try {
            surveyService.create(memsur.getId(), userID, memsur.getUserWhere(), memsur.getUserWHAT(), memsur.getUserWho());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            log.info("error = {}", bindingResult);
            return "/surveyForm";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("surveyFailed", e.getMessage());
            return "/surveyForm";
        }
        log.info("설문조사 완료!");
        model.addAttribute("message", "설문조사를 완료하였습니다.");
        model.addAttribute("nextUrl", "/Main");
        return "/setting/message";
    }

    @GetMapping("/reSurveyForm")
    public String reSurveyPage(Survey survey)
    {
        return "/reSurveyForm";
    }

    @PostMapping("/reSurveyForm")
    public String resave(@ModelAttribute("survey") @Valid Memsur memsur, BindingResult bindingResult, Model model) {
        Object principaluser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principaluser;
        String userID = userDetails.getUsername();

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "/reSurveyForm";
        }

        if (surveyRepository.existsByUserID(userID)) {
            surveyService.delete(userID);
        }

        try {
            surveyService.create(memsur.getId(), userID, memsur.getUserWhere(), memsur.getUserWHAT(), memsur.getUserWho());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            log.info("error = {}", bindingResult);
            return "/reSurveyForm";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("surveyFailed", e.getMessage());
            return "/reSurveyForm";
        }
        log.info("재설문 완료!");
        model.addAttribute("message", "재설문을 완료하였습니다.");
        model.addAttribute("nextUrl", "/Main");
        return "/setting/message";
    }

}
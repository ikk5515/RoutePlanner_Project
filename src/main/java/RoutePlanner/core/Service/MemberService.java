package RoutePlanner.core.Service;

import RoutePlanner.core.domain.member.SiteUser;
import RoutePlanner.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    public SiteUser create(Long id, String userID, String userPassword, String userName, String userGender, String userEmail) {
        SiteUser user = new SiteUser();
        user.setId(id);
        user.setUserID(userID);
        user.setUserPassword(passwordEncoder.encode(userPassword));
        user.setUserName(userName);
        user.setUserGender(userGender);
        user.setUserEmail(userEmail);

        this.memberRepository.save(user);
        return user;
    }
}

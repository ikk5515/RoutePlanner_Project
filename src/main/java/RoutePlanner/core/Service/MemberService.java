package RoutePlanner.core.Service;

import RoutePlanner.core.domain.member.SiteUser;
import RoutePlanner.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    public SiteUser create(Long id, String userID, String userPassword, String userName, String userGender ,String userEmail) {
        SiteUser siteUser = new SiteUser();
        siteUser.setId(id);
        siteUser.setUserID(userID);
        siteUser.setUserPassword(passwordEncoder.encode(userPassword));
        siteUser.setUserName(userName);
        siteUser.getUserGender();
        siteUser.setUserEmail(userEmail);

        this.memberRepository.save(siteUser);
        return siteUser;
    }
}

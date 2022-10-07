package RoutePlanner.core.Service;

import RoutePlanner.core.domain.member.SiteUser;
import RoutePlanner.core.domain.role.UserRole;
import RoutePlanner.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
/* SpringSecurity에 등록하기 위한 MemberSecurityService
 * UserDetailsService는 loadUserByUsername 메서드 구현을 강제하는 인터페이스    => 사용자명으로 비밀번호를 조회하여 리턴하는 메서드
 */


/* SiteUser 객체 조회
 * 해당하는 데이터가 없을 시 UsernameNotFoundException 오류
 * id가 admin인 경우 ADMIN 권한 부여 / 이외의 경우는 USER 권한 부여
 * 사용자명 비밀번호 권한 ==> SpringSecurity User의 User 객체를 생성하여 리턴   => 리턴된 User 객체의 비밀번호가 입력받은 비밀번호와 일치하는지 검사하는 로직
 */
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
        Optional<SiteUser> siteUserOptional = Optional.ofNullable(this.memberRepository.findByUserID(userID)
                .orElseThrow(() -> new UsernameNotFoundException("not found userID: " + userID)));


        SiteUser siteUser = siteUserOptional.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if ("admin".equals(userID)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new User(siteUser.getUserID(), siteUser.getUserPassword(), authorities);
    }
}

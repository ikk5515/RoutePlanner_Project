package RoutePlanner.core.repository;


import RoutePlanner.core.domain.member.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<SiteUser, Long> {
    // 사용자 조회 기능
    Optional<SiteUser> findByUserID(String userID);
    Optional<SiteUser> findByUserEmail(String userEmail);
}

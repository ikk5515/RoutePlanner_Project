package RoutePlanner.core.repository;


import RoutePlanner.core.domain.member.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<SiteUser, Long> {
}

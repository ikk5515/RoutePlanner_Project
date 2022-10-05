package RoutePlanner.core.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "SITE_USER")
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userID;

    private String userPassword;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String userEmail;

    @Column(unique = false)
    private String userGender;
}

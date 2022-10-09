package RoutePlanner.core.domain.member;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "SITE_USER")
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERID",unique = true)
    private String userID;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @Column(name = "USER_EMAIL", unique = true)
    private String userEmail;

    @Column(name = "USER_GENDER", unique = false)
    private String userGender;
}

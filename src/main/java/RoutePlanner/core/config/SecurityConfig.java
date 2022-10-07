package RoutePlanner.core.config;

import RoutePlanner.core.Service.MemberSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity  //모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 어노테이션
public class SecurityConfig {

    private final MemberSecurityService memberSecurityService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer = http.formLogin()
                .usernameParameter("userID")
                .passwordParameter("userPassword")
                .loginPage("/Login")
                .defaultSuccessUrl("/Login");

        LogoutConfigurer<HttpSecurity> httpSecurityLogoutConfigurer = http.logout()   // 로그아웃 기능 작동
                .logoutUrl("/Logout")
                .logoutSuccessUrl("/Login");

        http.authorizeRequests()
                .antMatchers("/**").permitAll()

                // 로그인 URL 등록
                .and()
                .csrf().disable()   // 로그인 창
        ;
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // SpringSecurity 인증 담당
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

package RoutePlanner.core.domain.member;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Member {

    private Long id;

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-z0-9]{5,20}$", message = "아이디는 5~20자의 영문, 숫자만 사용 가능합니다.")
    @Column(unique = true)
    private String userID;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 모두 포함해야합니다.")
    private String userPassword1;

    @NotBlank(message = "비밀번호 확인을 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호 확인은 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 모두 포함해야합니다.")
    private String userPassword2;


    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,6}$", message = "닉네임은 2~6자의 영문, 한글, 숫자만 사용 가능가능합니다.")
    @Column(unique = true)
    private String userName;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    @Column(unique = true)
    private String userEmail;

    @NotBlank(message = "성별을 체크해주세요.")
    private String userGender;
}

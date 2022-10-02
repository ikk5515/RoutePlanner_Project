package RoutePlanner.core.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDto {

    @NotBlank(message = "아이디를 입력해 주세요.")
    @Pattern(regexp = "^(?=.*[a-z0-9])[a-z0-9]{6,20}$", message = "6~20자의 영문, 숫자만 사용 가능")
    private String userID;

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,16}$", message = "8~16자리 영문 대소문자, 숫자, 특수문자 중 3가지 이상 조합을 사용 가능.")
    private String userPassword;

    @NotBlank(message = "비밀번호를 입력해 주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,16}$", message = "8~16자리 영문 대소문자, 숫자, 특수문자 중 3가지 이상 조합을 사용 가능")
    private String userPasswordCheck;


    @NotBlank(message = "닉네임을 입력해 주세요.")
    @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$", message = "2~16자의 영문, 한글, 숫자만 사용 가능")
    private String userName;

    private String userGender;

    @NotBlank(message = "이메일을 입력해 주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$", message = "이메일 형식이 올바르지 않습니다.")
    private String userEmail;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

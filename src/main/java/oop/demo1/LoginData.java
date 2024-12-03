package oop.demo1;

public class LoginData {
    private String loginId;
    private String password;
    private String userType;

    public LoginData(String loginId, String password, String userType) {
        this.loginId = loginId;
        this.password = password;
        this.userType = userType;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "loginId='" + loginId + '\'' +
                ", password='***'" + // Hide password for security
                ", userType='" + userType + '\'' +
                '}';
    }
}

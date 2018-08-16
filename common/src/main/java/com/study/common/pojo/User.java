package com.study.common.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;

    private Long userId;

    private String userEmail;

    private String userPhone;

    private String userPassword;

    private String userPwdSalt;

    private String userState;

    public User(String userName, Long userId, String userEmail, String userPhone, String userPassword, String userPwdSalt, String userState) {
        this.userName = userName;
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userPwdSalt = userPwdSalt;
        this.userState = userState;
    }

    public User() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPwdSalt() {
        return userPwdSalt;
    }

    public void setUserPwdSalt(String userPwdSalt) {
        this.userPwdSalt = userPwdSalt == null ? null : userPwdSalt.trim();
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }
}
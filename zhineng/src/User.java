package com.zhineng.bean;

import java.io.Serializable;

public class User implements Serializable {
    private int userID;
    private String userName;
    private String userSex;
    private String userPassword;
    private String userBirthday;
    private String userEmail;
    private String userAddress;
    private int userStatus;
    private String userMoblie;

    public User(){

    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserMoblie() {
        return userMoblie;
    }

    public void setUserMoblie(String userMoblie) {
        this.userMoblie = userMoblie;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + userID +
                ", username='" + userName + '\'' +
                ", password='" + userPassword+ '\'' +
                ", name='" + userAddress + '\'' +
                ", birthday='" + userBirthday + '\'' +
                ", sex='" + userSex + '\'' +
                ", telephone='" + userMoblie + '\'' +
                ", email='" + userEmail + '\'' +
                ", status=" + userStatus +
                '}';
    }
}



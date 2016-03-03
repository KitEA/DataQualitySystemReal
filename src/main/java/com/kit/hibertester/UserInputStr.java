package com.kit.hibertester;

/**
 * Created by Eldest on 02.03.2016.
 */
public class UserInputStr {
    private String userInputTo;
    private int userInputNumber;

    public UserInputStr(String userInputTo) {
        this.userInputTo = userInputTo;
    }

    public UserInputStr(int userInputNumber) {
        this.userInputNumber = userInputNumber;
    }

    public String getUserInputTo() {
        return userInputTo;
    }

    public int getUserInputNumber() {
        return userInputNumber;
    }

    public void setUserInputTo(String userInputTo) {
        this.userInputTo = userInputTo;
    }

    public void setUserInputNumber(int userInputNumber) {
        this.userInputNumber = userInputNumber;
    }
}

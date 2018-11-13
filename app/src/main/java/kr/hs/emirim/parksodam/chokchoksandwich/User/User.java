package kr.hs.emirim.parksodam.chokchoksandwich.User;

/**
 * Created by Mirim on 2018-11-13.
 */

public class User {
    private String userName;
    private String userID;
    private String usrePW;

    public User() {

    }
    public User(String userID, String userName, String usrePW) {
        this.userName = userName;
        this.userID = userID;
        this.usrePW = usrePW;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsrePW() {
        return usrePW;
    }

    public void setUsrePW(String usrePW) {
        this.usrePW = usrePW;
    }
}

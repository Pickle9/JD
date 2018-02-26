package by.htp.hw.nb.entity;

public class User {

    private String nickName;
    private String hashPassword;

    public User(String nickName, String hashPassword) {
        this.nickName = nickName;
        this.hashPassword = hashPassword;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    @Override
    public String toString() {
        return nickName + " " + hashPassword;
    }
}

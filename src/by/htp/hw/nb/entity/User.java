package by.htp.hw.nb.entity;

public class User {
    private String nickName;
    private String hashPassword;
    private int idUser;

    public User(int idUser, String nickName, String hashPassword) {
        this.nickName = nickName;
        this.hashPassword = hashPassword;
        this.idUser = idUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (nickName != null ? !nickName.equals(user.nickName) : user.nickName != null) return false;
        return hashPassword != null ? hashPassword.equals(user.hashPassword) : user.hashPassword == null;
    }

    @Override
    public int hashCode() {
        int result = nickName != null ? nickName.hashCode() : 0;
        result = 31 * result + (hashPassword != null ? hashPassword.hashCode() : 0);
        result = 31 * result + idUser;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%o %s %s", idUser, nickName, hashPassword);
    }
}
package by.htp.hw.nb.entity;

public class UserInfo extends User{
    private String name;
    private String surname;

    public UserInfo(int idUser, String nickName, String hashPassword, String name, String surname) {
        super(idUser, nickName, hashPassword);
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserInfo userInfo = (UserInfo) o;

        if (name != null ? !name.equals(userInfo.name) : userInfo.name != null) return false;
        return surname != null ? surname.equals(userInfo.surname) : userInfo.surname == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
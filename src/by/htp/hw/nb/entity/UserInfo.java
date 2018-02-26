package by.htp.hw.nb.entity;

public class UserInfo extends User{
	private String name;
	private String surname;

	public UserInfo(String nickName, String hashPassword, String name, String surname) {
		super(nickName, hashPassword);
		this.name = name;
		this.surname = surname;
	}
}

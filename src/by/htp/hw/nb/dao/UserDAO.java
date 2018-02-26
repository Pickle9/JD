package by.htp.hw.nb.dao;

import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;

public interface UserDAO {

	boolean signIn(User user);

	boolean singUp(User user);

	void editPassword(String oldPassword, String newPassword);

	void editUserInfo(int id, UserInfo userInfo);
}

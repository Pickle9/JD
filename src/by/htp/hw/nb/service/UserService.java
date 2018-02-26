package by.htp.hw.nb.service;

import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;

public interface UserService {
	
	boolean signIn(User user);
	
	boolean singUp(User user);

	void editPassword(String oldPassword, String newPassword);

	void editUserInfo(int id, UserInfo userInfo);
}

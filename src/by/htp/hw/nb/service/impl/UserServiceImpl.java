package by.htp.hw.nb.service.impl;

import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;
import by.htp.hw.nb.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public boolean signIn(User user) {
        return false;
    }

    @Override
    public boolean singUp(User user) {
        return false;
    }

    @Override
    public void editPassword(String oldPassword, String newPassword) {

    }

    @Override
    public void editUserInfo(int id, UserInfo userInfo) {

    }
}

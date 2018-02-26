package by.htp.hw.nb.dao.impl;

import by.htp.hw.nb.dao.UserDAO;
import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUserDAO implements UserDAO {

    @Override
    public boolean signIn(User user) {

        /*try {
            Files.write(Paths.get(DataSourceProperty.USER_DATA_FILE), (user.toString() + System.getProperty("line.separator")).getBytes(), StandardOpenOption.APPEND);
        } catch (NoSuchFileException e) {
            Files.write(Files.createFile(Paths.get(DataSourceProperty.USER_DATA_FILE)), (user.toString() + System.getProperty("line.separator")).getBytes(), StandardOpenOption.APPEND);
        }*/

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

package by.htp.hw.nb.dao;

import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;

import java.util.List;

public interface UserDAO {

    boolean logIn(User user) throws DAOException;

    boolean logOut(User user) throws DAOException;

    void edit(UserInfo user) throws DAOException;

    void addUser(UserInfo userInfo) throws DAOException;

    void deleteUser(User user) throws DAOException;

    List<String> getAllUsers() throws DAOException;
}
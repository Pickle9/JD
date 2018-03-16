package by.htp.hw.nb.service;

import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;
import by.htp.hw.nb.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    boolean logIn(User user) throws ServiceException;

    boolean logOut(User user) throws ServiceException;

    void edit(UserInfo user) throws ServiceException;

    void addUser(UserInfo userInfo) throws ServiceException;

    void deleteUser(User user) throws ServiceException;

    List<String> getAllUsers() throws ServiceException;
}
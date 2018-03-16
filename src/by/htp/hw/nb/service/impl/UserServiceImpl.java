package by.htp.hw.nb.service.impl;

import by.htp.hw.nb.dao.DAOFactory;
import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;
import by.htp.hw.nb.service.UserService;
import by.htp.hw.nb.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Override
    public boolean logIn(User user) throws ServiceException {

        try {
            return DAOFactory.getInstance().getUserDAO().logIn(user);
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean logOut(User user) throws ServiceException {

        // TODO до лучших времён

        return false;
    }

    @Override
    public void edit(UserInfo user) throws ServiceException {

        try {
            DAOFactory.getInstance().getUserDAO().edit(user);
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addUser(UserInfo userInfo) throws ServiceException {

        try {
            DAOFactory.getInstance().getUserDAO().addUser(userInfo);
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUser(User user) throws ServiceException {

        try {
            DAOFactory.getInstance().getUserDAO().deleteUser(user);
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<String> getAllUsers() throws ServiceException {
        try {
            return DAOFactory.getInstance().getUserDAO().getAllUsers();
        }
        catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
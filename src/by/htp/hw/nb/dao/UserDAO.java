package by.htp.hw.nb.dao;

import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;

public interface UserDAO {

	boolean logIn(User user) throws DAOException;

	boolean logOut(User user) throws DAOException;

	void edit(int id, UserInfo user) throws DAOException;

	void addUser(User user) throws DAOException;
}

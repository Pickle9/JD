package by.htp.hw.nb.dao;

import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.User;

public interface UserDAO {

	boolean logination(User user) throws DAOException;
	//void edit(int id, UserInfo user) throws DAOException;
}

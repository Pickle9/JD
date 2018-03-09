package by.htp.hw.nb.service;

import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;
import by.htp.hw.nb.service.exception.ServiceException;

public interface UserService {

    boolean logination(User user) throws ServiceException;
}

package by.htp.hw.nb.dao.impl;

import by.htp.hw.nb.dao.UserDAO;
import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUserDAO implements UserDAO {

    @Override
    public boolean logination(User user) throws DAOException {

        // Предположим, этот метод отвечает за проверку логина (записывать в файл он ничё не будет).
        // Заодно предположим, что юзеры в файле хранятся в виде "ЛОГИН = ПАРОЛЬ"

        BufferedReader reader;

        try {

            reader = new BufferedReader(new FileReader(DataSourceProperty.USER_DATA_FILE));
            ArrayList<String> users = new ArrayList<>();

            while (reader.ready()) {
                users.add(reader.readLine());
            }

            for (String s : users) {
                String[] arr = s.split(" = ");

                if (user.getNickName().equals(arr[0]) && user.getHashPassword().equals(arr[1])) {
                    return true;
                }
            }

        } catch (IOException e) {
            throw new DAOException("Logination error!", e);
        }

        return false;
    }
}
package by.htp.hw.nb.dao.impl;

import by.htp.hw.nb.dao.UserDAO;
import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.User;
import by.htp.hw.nb.entity.UserInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *      USER format in file: "ID = LOGIN = PASSWORD = NAME = SURNAME"
 */

public class FileUserDAO implements UserDAO {

    // Относительный путь к файлу с пользователями.
    private static final String pathToUsersFile = DataSourceProperty.RELATIVE_PATH + DataSourceProperty.USER_DATA_FILE;


    /**
     * Производит авторизацию пользователя.
     *
     * @param user - данные пользователя.
     * @return true при совпадении id, логина и пароля
     *         false в обратном случае.
     * @throws DAOException при невозможности прочесть файл.
     */
    @Override
    public boolean logIn(User user) throws DAOException {

        List<String> users = readFileIntoList(pathToUsersFile);

        for (String s : users) {
            String[] arr = s.split(" = ");

            if (user.getNickName().equals(arr[1]) && user.getHashPassword().equals(arr[2])) {
                return true;
            }
        }

        return false;
    }


    /**
     * Отвечает за выход пользователя из аккаунта. (пока нет смысла реализовывать)
     *
     * @param user - данные пользователя.
     * @return true при успешном выходе из аккаунта.
     *         false в обратном случае.
     * @throws DAOException TODO
     */
    @Override
    public boolean logOut(User user) throws DAOException {

        // TODO как-нибудь потом

        return false;
    }


    /**
     * Изменение даныых пользователя. (LOGIN, PASSWORD, NAME, SURNAME)
     * Предполагается, что пользователь успешно авторизировался!
     *
     * @param userInfo Вся информация и пользователе.
     * @throws DAOException при невоможности прочесть либо перезаписать файл.
     */
    @Override
    public void edit(UserInfo userInfo) throws DAOException {

        List<String> users = readFileIntoList(pathToUsersFile);

        // Ищем нужного юзера
        for (String s : users) {
            String[] user = s.split(" = ");

            // Сверяемся с записями в файле
            if (Integer.parseInt(user[0]) == userInfo.getIdUser()) {

                // Если нашли, то делаем строку из новых данных юзера
                String userForWrite = String.format("%s = %s = %s = %s = %s",
                        user[0], userInfo.getNickName(), userInfo.getHashPassword(), userInfo.getName(), userInfo.getSurname());

                // Закидываем строку в наш лист со строками из файла
                users.set(users.indexOf(s), userForWrite);

                // Записываем
                try {
                    new FileWriter(pathToUsersFile).close(); // Чистим файл
                    Files.write(Paths.get(pathToUsersFile), users, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    throw new DAOException("Edit error!", e);
                }
            }
        }
    }


    /**
     * Добавляет пользователя и его данные в общий файл.
     * Проверяет, занят ли id.
     *
     * @param userInfo - информация о пользователе.
     * @throws DAOException при невозможности перезаписать файл или при уже занятом id.
     */
    @Override
    public void addUser(UserInfo userInfo) throws DAOException {

        try {

            // Строка для записи
            String lineForWrite = String.format("%o = %s = %s = %s = %s",
                    userInfo.getIdUser(), userInfo.getNickName(), userInfo.getHashPassword(), userInfo.getName(), userInfo.getSurname());

            // Проверка, не занят ли id.
            if (!checkId(userInfo.getIdUser()))
                throw new DAOException("ID already taken!");

            Files.write(Paths.get(pathToUsersFile), (lineForWrite + System.getProperty("line.separator")).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new DAOException("Add user error!", e);
        }
    }


    /**
     * Удаление пользователя из файла.
     *
     * @param user - данные о пользователе (не UserInfo, только ID, LOGIN, PASSWORD)
     * @throws DAOException при невоможности прочесть либо перезаписать файл.
     */
    @Override
    public void deleteUser(User user) throws DAOException {

        List<String> users = readFileIntoList(pathToUsersFile);

        // Ищем нужного юзера
        for (String s : users) {
            String[] line = s.split(" = ");

            // Ищем в файле совпадения по id, login, password
            if (Integer.parseInt(line[0]) == user.getIdUser()
                    && line[1].equals(user.getNickName())
                    && line[2].equals(user.getHashPassword())) {

                // Если нашли, то удаляем
                users.remove(s);
                break;
            }
        }

        // И меняем данные в файле
        try {
            new FileWriter(pathToUsersFile).close(); // Хитрый способ очистить файл.
            Files.write(Paths.get(pathToUsersFile), users, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new DAOException("Edit error!", e);
        }
    }


    /**
     *  Выдаёт список со всеми пользователями.
     *
     * @return List типа String с  информацией о всех пользователях.
     * @throws DAOException при невоможности прочесть файл.
     */
    @Override
    public List<String> getAllUsers() throws DAOException {
        return readFileIntoList(pathToUsersFile);
    }

    /**
     * Приватный метод для использования только в этом классе.
     * Читает файл по переданному пути и возвращает копию всех строк файла в виде списка.
     *
     * @param path путь к требуемому файлу.
     * @return List со строками из файла (тип String).
     * @throws DAOException при невозможности прочесть файл.
     */
    private List<String> readFileIntoList(String path) throws DAOException {
        List<String> file = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            while (reader.ready()) {
                file.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new DAOException("ReadFile error!", e);
        }

        return file;
    }


    /**
     * Приватный метод для использования только в этом классе.
     * Проверяет, не занят ли idUser в файле пользователей.
     * Используется метод readFileIntoList!
     *
     * @param id для проверки
     * @return true, если id свободен
     *         false, если занят
     * @throws DAOException при невозможности прочесть файл.
     */
    private boolean checkId(int id) throws DAOException {
        for (String s : readFileIntoList(pathToUsersFile)) {
            String[] arr = s.split(" = ");

            if (arr[0].equals(id + ""))
                return false;
        }

        return true;
    }
}
package by.htp.hw.nb.dao.impl;

import by.htp.hw.nb.dao.NoteDAO;
import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.Note;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileNoteDAO implements NoteDAO {

    // Note в файле: "ID || ЧИСЛО МЕСЯЦ ГОД || ТЕКСТ"

    @Override
    public void add(Note note) throws DAOException {

        // idUser text data

        FileWriter noteWriter = null;

        // Формат строки под запись
        String forWrite = " || " + note.getDate() + " || " + note.getText() + System.getProperty("line.separator");

        // Путь к файлу с записями
        Path userNoteFile = Paths.get(getUserNoteFilePath(note.getIdUser()));

        try {

            // А тут интересно...
            if (!(new File(userNoteFile.toString()).exists())) {

                // Если файл не создан, то создаём и пишем Note с id = 1
                Files.createFile(userNoteFile);

                noteWriter = new FileWriter(userNoteFile.toString(), true);
                noteWriter.write("1" + forWrite);
            } else {

                // А если файл создан, то узнаём кол-во строк в нём (следовательно и id) и пишем туда Note с нужным id
                List<String> list = readFileIntoList(getUserNoteFilePath(note.getIdUser()));

                noteWriter = new FileWriter(userNoteFile.toString(), true);
                noteWriter.write(list.size() + 1 + "" + forWrite);
            }
        } catch (IOException e) {

            e.printStackTrace();
            throw new DAOException("Add note error!", e);

        } finally {
            if (noteWriter != null) {
                try {
                    noteWriter.close();
                } catch (IOException e) {
                    // log ERROR
                }
            }
        }
    }

    @Override
    public List<Note> findWithContent(int idUser, String text) throws DAOException {

        List<Note> result = new ArrayList<>();
        List<String> lines = readFileIntoList(getUserNoteFilePath(idUser));

        // Ищем нужные строки
        for (String s : lines) {

            // У нас в файле строка вида "ID || ЧИСЛО МЕСЯЦ ГОД || ТЕКСТ"
            String[] arr = s.split(" \\|\\| "); // Разделяем дату и текст

            // Это наш текст
            String line = arr[2];

            // Если текст из файла равен нужному нам тексту, то кидаем Note в лист.
            if (line.contains(text)) {
                result.add(new Note(idUser, line));
            }
        }

        return result;
    }

    @Override
    public void remove(int idNote, int idUser) throws DAOException {

        String filePath = getUserNoteFilePath(idUser);
        List<String> lines = readFileIntoList(filePath);

        // Ищем запись по id и удаляем её
        for (String s : lines) {

            // У нас в файле строка вида "ID || ЧИСЛО МЕСЯЦ ГОД || ТЕКСТ"
            String[] arr = s.split(" \\|\\| ");

            // Если нашли, то удаляем и выходим
            if (Integer.parseInt(arr[0]) == (idNote) && idNote != 0) {
                lines.remove(s);
                break;
            }
        }

        // Обновляем id, чтобы они шли по очереди
        lines = refreshId(lines);

        // Записываем обновлённые записи обратно в файл
        try {
            new FileWriter(filePath); // А это хитрый способ очистить файл
            Files.write(Paths.get(filePath), lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new DAOException("Remove error!", e);
        }
    }

    @Override
    public void edit(int idNote, int idUser, String text, String date) throws DAOException {

        String filePath = getUserNoteFilePath(idUser);
        List<String> lines = readFileIntoList(filePath);

        // Ищем нужную строку
        for (String s : lines) {

            // У нас в файле строка вида "ID || ЧИСЛО МЕСЯЦ ГОД || ТЕКСТ"
            String[] arr = s.split(" \\|\\| ");

            if (Integer.parseInt(arr[0]) == idNote) {
                lines.set(lines.indexOf(s), idNote + " || " + date + " || " + text);
            }
        }

        // Записываем обновлённые записи обратно в файл
        try {
            new FileWriter(filePath); // Тот же хитрый способ очистить файл
            Files.write(Paths.get(filePath), lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new DAOException("Remove error!", e);
        }
    }

    private List<String> readFileIntoList(String path) throws DAOException {
        BufferedReader reader = null;
        List<String> lines = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(path));

            // Чтение записей из файла
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new DAOException("Read file error!", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // log ERROR
                }
            }
        }

        return lines;
    }

    // Даёт путь к файлу юзера с записями
    private String getUserNoteFilePath(int idUser) {
        return DataSourceProperty.RELATIVE_PATH + idUser + DataSourceProperty.USER_NOTE_BASE_SOURCE_NAME;
    }

    // Ставит id по очереди
    private List<String> refreshId(List<String> list) {
        List<String> tmp = new ArrayList<>();
        int i = 1;

        for (String s : list) {
            String[] arr = s.split(" \\|\\| ");

            tmp.add(i++ + " || " + arr[1] + " || " + arr[2]);
        }

        return tmp;
    }
}

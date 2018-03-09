package by.htp.hw.nb.dao.impl;

import by.htp.hw.nb.dao.NoteDAO;
import by.htp.hw.nb.dao.exception.DAOException;
import by.htp.hw.nb.entity.Note;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FileNoteDAO implements NoteDAO {

    @Override
    public void add(Note note) throws DAOException {

        // idUser text data
        FileWriter noteWriter = null;
        try {
            String userNoteFile = note.getIdUser()
                    + DataSourceProperty.USER_NOTE_BASE_SOURCE_NAME;
            noteWriter = new FileWriter(userNoteFile, true);

            noteWriter.write(note.getDate() + " || " + note.getText() + "\n");
        } catch(IOException e){
            throw new DAOException("Add note error!", e);
        }finally {
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
    public List<Note> findWithContent(int id, String text) throws DAOException {

        BufferedReader reader;
        List<String> lines = new ArrayList<>();
        List<Note> result = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(id + DataSourceProperty.USER_NOTE_BASE_SOURCE_NAME));

            // Чтение записей из файла
            while (reader.ready()) {
                lines.add(reader.readLine());
            }

            // Ищем нужные строки
            for (String s : lines) {

                // У нас в файле строка вида "ЧИСЛО МЕСЯЦ ГОД || ТЕКСТ"
                String[] arr = s.split(" \\|\\| "); // Разделяем дату и текст
                String[] data = arr[0].split(" "); // Разделяем число, месяц и год для записи в календарь

                // Записываем дату в календарь
                Calendar calendar = new GregorianCalendar();
                calendar.set(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0])); // Запись даты в виде "ГОД МЕСЯЦ ЧИСЛО"

                // А это наш текст
                String line = arr[1];

                // Если текст из файла равен нужному нам тексту, то кидаем Note в лист.
                if (line.equals(text)) {
                    result.add(new Note(id, line, calendar));
                }
            }
        }
        catch (IOException e) {
            throw new DAOException("Find note error!", e);
        }

        return result;
    }
}

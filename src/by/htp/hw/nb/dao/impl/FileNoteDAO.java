package by.htp.hw.nb.dao.impl;

import by.htp.hw.nb.dao.NoteDAO;
import by.htp.hw.nb.entity.Note;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileNoteDAO implements NoteDAO {

    /*TODO ПРОБЕЖАТЬСЯ ПО ИСКЛЮЧЕНИЯМ
    * TODO СМЕНИТЬ ПУТИ ФАЙЛОВ*/

    @Override
    public void create(Note note) throws IOException {

        try {
            // Запись note в файл с сохранением предыдущих данных.
            Files.write(Paths.get(DataSourceProperty.USER_DATA_FILE), (note.toString() + System.getProperty("line.separator")).getBytes(), StandardOpenOption.APPEND);
        } catch (NoSuchFileException e) {
            // Если файл не создан, то создаём и записываем туда данные.
            try {
                Files.write(Files.createFile(Paths.get(DataSourceProperty.USER_DATA_FILE)), (note.toString() + System.getProperty("line.separator")).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ioe) {
                throw new IOException("Error, the note have't been created!");
            }
        }
    }

    @Override
    public void remove(int id) throws IOException {

        ArrayList<String> notesFromFile;
        try {
            notesFromFile = copyFileToList(DataSourceProperty.USER_DATA_FILE);
        } catch (IOException e) {
            throw new IOException("Remove error!\nFile not found.");
        }

        // Поиск записи по id
        int index = -1;
        for (String s : notesFromFile) {
            String[] valuesOfNote = s.split(" ");

            if (Integer.parseInt(valuesOfNote[0]) == id) {
                index = notesFromFile.indexOf(s);
            }
        }

        // Бросаем исключение, если элемент не найден.
        if (index == -1)
            throw new IOException("Remove error!\n The note not found.");

        // Удаляенм найденную запись
        notesFromFile.remove(index);

        // Перезаписываем данные обратно в файл без удалённой записи
        BufferedWriter writer = new BufferedWriter(new FileWriter(DataSourceProperty.USER_DATA_FILE));

        for (String s : notesFromFile) {
            writer.write(s + System.getProperty("line.separator"));
        }

        writer.close();
    }

    @Override
    public List<Note> find(Calendar date) throws IOException {

        ArrayList<String> notesFromFile;
        try {
            notesFromFile = copyFileToList(DataSourceProperty.USER_DATA_FILE);
        } catch (IOException e) {
            throw new IOException("Find error!\nFile not found.");
        }

        // Поиск записей по дате и добавление их в список
        ArrayList<Note> foundNotes = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");   // Это тип для приведения двух дат к одинаковому виду для сравнение
        GregorianCalendar calendar = new GregorianCalendar();

        for (String s : notesFromFile) {
            String[] valuesOfNote = s.split(" ");   // Режем примерно такие строчки (объект Note) "id data text"

            if (dateFormat.format(date.getTime()).equals(valuesOfNote[1])) {

                // Это сраный говнокод, но делать нечего, строку в календарь пересвести надо...
                String[] arr = valuesOfNote[1].split("\\.");      // А тут режем нашу дату "yyyy.MM.dd".

                calendar.set(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                foundNotes.add(new Note(calendar, valuesOfNote[2]));
            }
        }

        return foundNotes;
    }

    @Override
    public void edit(int id, String newText, int newYear) throws IOException {

        ArrayList<String> notesFromFile;
        try {
            notesFromFile = copyFileToList(DataSourceProperty.USER_DATA_FILE);
        } catch (IOException e) {
            throw new IOException("Edit error!\nNotes not found");
        }

        // Поиск записи по id
        int index = -1;
        for (String s : notesFromFile) {
            String[] valuesOfNote = s.split(" ");

            // Замена данных в записи на новые.
            if (Integer.parseInt(valuesOfNote[0]) == id) {
                index = notesFromFile.indexOf(s);

                String[] date = valuesOfNote[1].split("\\.");
                notesFromFile.set(index, String.format("%s %s.%s.%s %s", id, newYear, date[1], date[2], newText));
            }
        }

        // Бросаем исключение, если элемент не найден.
        if (index == -1)
            throw new IOException("Edit error!\nThe note not found");

        // Перезапись файла
        BufferedWriter writer = new BufferedWriter(new FileWriter(DataSourceProperty.USER_DATA_FILE));

        for (String s : notesFromFile) {
            writer.write(s + System.getProperty("line.separator"));
        }

        writer.close();
    }

    private ArrayList<String> copyFileToList(String fileName) throws IOException {

        // Копирование записей из файла в ArrayList
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> notesFromFile = new ArrayList<>();

        while (reader.ready()) {
            notesFromFile.add(reader.readLine());
        }

        reader.close();

        return notesFromFile;
    }
}

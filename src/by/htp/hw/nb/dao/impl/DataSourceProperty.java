package by.htp.hw.nb.dao.impl;

public final class DataSourceProperty {

    /**
     * Все пути следует использовать как "RELATIVE_PATH + USER_DATA_FILE"
     *                               или "RELATIVE_PATH + idUser + USER_NOTE_BASE_SOURCE_NAME".
     */

    // Приставка к относительному пути к дирректории NoteBook
    public static final String RELATIVE_PATH = "src/by/htp/hw/nb/";

    // Файл для хранения данных о пользователях
    public static final String USER_DATA_FILE = "users.txt";

    // Шаблон названия файла с записями
    public static final String USER_NOTE_BASE_SOURCE_NAME = "_notes.txt";

    private DataSourceProperty() {
    }
}

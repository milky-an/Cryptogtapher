package consts;

public class Consts {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    public static final int NUMBER_KEY = ALPHABET.length-1;
    public static final String ENTER_KEY = "Введите ключ: от 1 до " + NUMBER_KEY;
    public static final String REPEAT_ENTER_KEY = "Ключ должен быть от 1 до " + NUMBER_KEY;
    public static final String ENTER_SOURCE_CRYPT_FILE = "Введите имя файла, который нужно заменить";
    public static final String ENTER_SOURCE_DECRYPT_FILE = "Введите имя файла, который нужно расшифровать";
    public static final String ENTER_DESTINATION_FILE = "Введите имя файла, куда сложить результат";
    public static final String ENTER_SOURCE_EXAMPLE_FILE = "Введите имя файла с примером текста";
    public static final String ENTER_NUMBER_OPERATION = "Введите номер операции";
    public static final String WRITING_ERROR = "Не удалось записать ответ в файл";
    public static final String READING_ERROR = "Не смог прочитать данные из файла";



}

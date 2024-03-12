package enums;

import java.util.Arrays;
import java.util.List;

public enum Actions {
    EXIT(0,"Выход"),
    CRYPT(1,"Стандартное шифрование"),
    DECRYPT(2,"Стандартная расшифровка"),
    BRUTE_FORCE(3,"Брут форс"),
    STATIC_ANALYZE(4,"Статистический анализ");


    private int number;
    private String text;

    Actions(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public static Actions chooseAction(int numberOfAction) {
        List<Actions> actionsList = Arrays.asList(Actions.values());
        for (Actions action: actionsList
             ) {
            if (action.getNumber() == numberOfAction) {
                return action;
            }
        }
        return null;
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }
}

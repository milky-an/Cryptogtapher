package service;

import model.CryptoModel;

import java.util.Scanner;

import static consts.Consts.*;

public class ConsoleService {
    private final Scanner scanner;

    public ConsoleService(Scanner scanner) {
        this.scanner = scanner;
    }

    public CryptoModel createCryptoModel(String enterSourceDecryptFile) {
        CryptoModel cryptoModel = new CryptoModel();
        System.out.println(enterSourceDecryptFile);
        String s = scanner.nextLine();
        cryptoModel.setPathFrom(s);

        System.out.println(ENTER_DESTINATION_FILE);
        cryptoModel.setPathTo(scanner.nextLine());

        System.out.println(ENTER_KEY);
        while (true) {
            int key = Integer.parseInt(scanner.nextLine());
            if (key > NUMBER_KEY || key < 0) {
                System.out.println(REPEAT_ENTER_KEY);
            } else {
                cryptoModel.setKey(key);
                break;
            }
        }
        return cryptoModel;
    }

    public CryptoModel createCryptoModelWithPathExample(String enterSourceDecryptFile) {
        CryptoModel cryptoModel = new CryptoModel();
        System.out.println(enterSourceDecryptFile);
        cryptoModel.setPathFrom(scanner.nextLine());

        System.out.println(ENTER_DESTINATION_FILE);
        cryptoModel.setPathTo(scanner.nextLine());

        System.out.println(ENTER_SOURCE_EXAMPLE_FILE);
        cryptoModel.setPathExample(scanner.nextLine());
        return cryptoModel;
    }
}

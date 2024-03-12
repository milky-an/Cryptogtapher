import enums.Actions;
import service.ConsoleService;
import service.CryptoService;
import service.FileService;

import java.util.Scanner;

import static consts.Consts.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileService fileService = new FileService();
        CryptoService cryptoService = new CryptoService(fileService);
        ConsoleService consoleService = new ConsoleService(scanner);
        boolean continueWork = true;
        while (continueWork) {
            System.out.println(ENTER_NUMBER_OPERATION);
            System.out.println();
            for (Actions action : Actions.values()
            ) {
                System.out.println(action.getNumber() + " - " + action.getText());
            }
            Actions value = Actions.chooseAction(Integer.parseInt(scanner.nextLine()));
            if (value == null) {
                System.out.println("Такого варианта нет :(");
                System.exit(1);
            }
            switch (value) {
                case EXIT -> continueWork = false;
                case CRYPT -> cryptoService.crypt(consoleService.createCryptoModel(ENTER_SOURCE_CRYPT_FILE));
                case DECRYPT -> cryptoService.decrypt(consoleService.createCryptoModel(ENTER_SOURCE_DECRYPT_FILE));
                case BRUTE_FORCE ->
                        cryptoService.bruteForce(consoleService.createCryptoModelWithPathExample(ENTER_SOURCE_DECRYPT_FILE));
                case STATIC_ANALYZE ->
                        cryptoService.staticAnalyze(consoleService.createCryptoModelWithPathExample(ENTER_SOURCE_DECRYPT_FILE));
            }
        }
    }
}

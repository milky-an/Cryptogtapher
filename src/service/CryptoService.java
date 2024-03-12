package service;

import exceptions.FileCreateException;
import exceptions.FileReadException;
import exceptions.FileWriteException;
import model.CryptoModel;

import java.nio.file.Path;
import java.util.*;

import static consts.Consts.*;

public class CryptoService {
    private final FileService fileService;

    public CryptoService(FileService fileService) {
        this.fileService = fileService;
    }

    public void crypt(CryptoModel model) {
        processCrypt(model);
    }

    public void decrypt(CryptoModel model) {
        int key = -model.getKey();
        model.setKey(key);
        processCrypt(model);
    }

    public void bruteForce(CryptoModel model) {
        List<String> dataFromFile = new ArrayList<>();
        List<String> dataToFile = new ArrayList<>();
        List<String> dataFromFileExample = new ArrayList<>();
        dataFromFile = readStringFromFile(Path.of(model.getPathFrom()));
        dataFromFileExample = readStringFromFile(Path.of(model.getPathExample()));
        HashMap<String, Integer> charNumberInExample = counterChars(dataFromFileExample);
        for (int i = 0; i < NUMBER_KEY; i++) {
            dataToFile = addKeyToString(dataFromFile, i);
            HashMap<String, Integer> charNumberInFile = counterChars(dataToFile);
            if (searchMaxValue(charNumberInExample).equals(searchMaxValue(charNumberInFile))) {
                break;
            }
        }
        try {
            fileService.writeStringToFile(Path.of(model.getPathTo()), dataToFile);
        } catch (FileCreateException | FileWriteException e) {
            System.out.println(WRITING_ERROR);
        }

    }

    public void staticAnalyze(CryptoModel model) {
        System.out.println("Попробуй лучше bruteForce)");
    }

    private void processCrypt(CryptoModel model) {
        List<Character> dataFromFile = new ArrayList<>();
        dataFromFile = readFromFile(Path.of(model.getPathFrom()));
        List<Character> dataToFile = addKeyToChar(dataFromFile, model.getKey());
        try {
            fileService.writeToFile(Path.of(model.getPathTo()), dataToFile);
        } catch (FileCreateException | FileWriteException e) {
            System.out.println(WRITING_ERROR);
        }
    }

    private List<Character> addKeyToChar(List<Character> dataFromFile, int key) {
        List<Character> dataToFile = new ArrayList<>();
        for (Character s : dataFromFile
        ) {
            for (int i = 0; i < ALPHABET.length; i++) {
                if (s == ALPHABET[i]) {
                    if (i + key >= ALPHABET.length) {
                        dataToFile.add(ALPHABET[i + key - ALPHABET.length]);
                    } else if (i + key < 0) {
                        dataToFile.add(ALPHABET[ALPHABET.length + i + key]);
                    } else dataToFile.add(ALPHABET[i + key]);
                }
            }
        }
        return dataToFile;
    }

    private List<String> addKeyToString(List<String> dataFromFile, int key) {
        List<String> dataToFile = new ArrayList<>();
        for (String s : dataFromFile
        ) {
            for (int i = 0; i < ALPHABET.length; i++) {
                if (s.equals(ALPHABET[i])) {
                    if (i + key >= ALPHABET.length) {
                        dataToFile.add(String.valueOf(ALPHABET[i + key - ALPHABET.length]));
                    } else if (i + key < 0) {
                        dataToFile.add(String.valueOf(ALPHABET[ALPHABET.length + i + key]));
                    } else dataToFile.add(String.valueOf(ALPHABET[i + key]));
                }
            }
        }
        return dataToFile;
    }

    private List<Character> readFromFile(Path path) {
        List<Character> data = new ArrayList<>();
        try {
            data = fileService.readFromFile(path);
        } catch (FileReadException e) {
            System.out.println(READING_ERROR);
        }
        return data;
    }

    private List<String> readStringFromFile(Path path) {
        List<String> data = new ArrayList<>();
        try {
            data = fileService.readStringFromFile(path);
        } catch (FileReadException e) {
            System.out.println(READING_ERROR);
        }
        return data;
    }

    private HashMap<String, Integer> counterChars(List<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list
        ) {
            boolean b = map.containsKey(s);
            if (b) {
                int x = map.get(s) + 1;
                map.put(s, x);
            } else map.put(s, 1);
        }
        System.out.println(map);
        return map;
    }

    private String searchMaxValue(HashMap<String, Integer> map) {
        int maxValue = 0;
        String stringOfMaxValue = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()
        ) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                stringOfMaxValue = entry.getKey();
            }
        }
        return stringOfMaxValue;
    }
}
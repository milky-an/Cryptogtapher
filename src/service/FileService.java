package service;

import exceptions.FileCreateException;
import exceptions.FileReadException;
import exceptions.FileWriteException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileService {
    public List<Character> readFromFile(Path path) throws FileReadException {
        List<Character> charFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {
            while (bufferedReader.ready()) {
                charFromFile.add((char) bufferedReader.read());
            }
        } catch (IOException e) {
            throw new FileReadException(e.getMessage(), e);
        }
        return charFromFile;
    }

    public List<String> readStringFromFile(Path path) throws FileReadException {
        List<String> stringFromFile = new ArrayList<>();
        try {
            stringFromFile = Files.readAllLines(path);
        } catch (IOException e) {
            throw new FileReadException(e.getMessage(), e);
        }
        ArrayList<String> strings = null;
        for (String s:stringFromFile
             ) {
            String[] strings1 = s.split(" ");
            strings = new ArrayList<>(Arrays.asList(strings1));
        }
        for (int i = 0; i < strings.size(); i=i+2) {
            if (i!=strings.size()-1) {
                strings.add(i+1," ");
            }
        }
        return strings;
    }

    public void writeToFile(Path path, List<Character> data) throws FileCreateException, FileWriteException {
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new FileCreateException(e.getMessage(), e);
            }
        }
        try {
            Files.writeString(path, data.toString());
        } catch (IOException e) {
            throw new FileWriteException(e.getMessage(), e);
        }
    }

    public void writeStringToFile(Path path, List<String> data) throws FileCreateException, FileWriteException {
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new FileCreateException(e.getMessage(), e);
            }
        }
        try {
            Files.writeString(path, (CharSequence) data);
        } catch (IOException e) {
            throw new FileWriteException(e.getMessage(), e);
        }
    }
}

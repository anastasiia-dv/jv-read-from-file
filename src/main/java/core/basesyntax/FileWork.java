package core.basesyntax;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIAL_REGEX = "\\W+";
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> text;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
             text = bufferedReader.readAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> data = new ArrayList<>();
        for (String line: text) {
            String[] arrLine = line.toLowerCase().split(SPECIAL_REGEX);
            for (String word : arrLine) {
                if (word.startsWith("w")) {
                    data.add(word);
                }
            }
        }
        Collections.sort(data);
        return data.toArray(new String[0]);
    }
}

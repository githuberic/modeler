package com.lgq.designer.practices.jira_2678.utils;

import com.lgq.designer.practices.jira_2678.MyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lgq
 */
public class FileUtil {
    public static List<String> readFileByLines(final String filePath) throws MyException {
        List<String> lines = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            return lines;
        }

        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = bf.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException ex) {
            throw new MyException("readFileByLines error");
        }

        return lines;
    }

    public static void write(final String filePath, final String content) throws MyException {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException ex) {
            throw new MyException("write error");
        }
    }
}

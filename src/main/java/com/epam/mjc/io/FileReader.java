package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile result = new Profile();
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[10];
        try (FileInputStream fis = new FileInputStream(file)) {
            while (fis.read(buffer) != -1) {
                sb.append(new String(buffer));
                buffer = new byte[10];
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] profileContentArr = sb.toString().split("\n");
        for (String profileString : profileContentArr) {
            String[] words = profileString.split(": ");
            switch (words[0]) {
                case "Name":
                    result.setName(words[1]);
                    break;
                case "Age":
                    result.setAge(Integer.parseInt(words[1]));
                    break;
                case "Email":
                    result.setEmail(words[1]);
                    break;
                case "Phone":
                    result.setPhone(Long.parseLong(words[1]));
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}

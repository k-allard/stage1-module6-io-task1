package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[10];
        try (FileInputStream fis = new FileInputStream(file)) {
            while (fis.read(buffer) != -1) {
                sb.append(new String(buffer));
                buffer = new byte[10];
            }
        } catch (IOException e) {
            throw new TestFileIncorrectException(e.getMessage());
        }
        return getProfileFromRawString(sb.toString());
    }

    private Profile getProfileFromRawString(String fileString) {
        String[] strings = fileString.split("\n");
        Profile profile = new Profile();
        for (String str : strings) {
            String[] words = str.split(": ");
            switch (words[0]) {
                case "Name":
                    profile.setName(words[1]);
                    break;
                case "Age":
                    profile.setAge(Integer.parseInt(words[1]));
                    break;
                case "Email":
                    profile.setEmail(words[1]);
                    break;
                case "Phone":
                    profile.setPhone(Long.parseLong(words[1]));
                    break;
                default:
                    break;
            }
        }
        return profile;
    }
}

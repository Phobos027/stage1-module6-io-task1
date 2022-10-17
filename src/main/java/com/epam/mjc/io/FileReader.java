package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {
    public static void main(String[] args) throws IOException {
        Profile profile = getDataFromFile(new File("src/main/resources/Profile.txt"));

        System.out.println(profile);
    }

    public static Profile getDataFromFile(File file) throws IOException {
        Profile profile = new Profile();
        FileInputStream fileInputStream = new FileInputStream(file);
        String text = "";
        int ch = 0;

        while ((ch = fileInputStream.read()) != -1) {
            text += ((char) ch);
        }
        fileInputStream.close();

        String[] splitText = text.split(System.lineSeparator());

        String[][] arrayText = new String[splitText.length][];
        for (int i = 0; i < splitText.length; i++) {
            arrayText[i] = splitText[i].split(" ");
        }

        profile.setName(arrayText[0][1]);
        int age = Integer.parseInt(arrayText[1][1]);
        long phone = Long.parseLong(arrayText[3][1]);
        profile.setAge(age);
        profile.setEmail(arrayText[2][1]);
        profile.setPhone(phone);
        return new Profile(profile.getName(), profile.getAge(), profile.getEmail(), profile.getPhone());
    }
}

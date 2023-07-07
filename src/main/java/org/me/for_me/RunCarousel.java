package org.me.for_me;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RunCarousel {
    static ArrayList<String> allFilms = new ArrayList<>();
    static String outString;
    static int nowChoiceNumber;

    public static void main(String[] args) throws IOException {
        createFileWithFilmForWatchNow();
        createFileWithListOfFilmsToWatchNext();
    }

    public static String createListOfFileForWatch() throws FileNotFoundException {
        File filmsListForWatch = new File("Films.txt");
        Scanner in = new Scanner(filmsListForWatch);
        while ((in.hasNextLine())) {
            allFilms.add(in.nextLine());
        }
        Random ChoiceNumberOfRandom = new Random();
        nowChoiceNumber = ChoiceNumberOfRandom.nextInt(allFilms.size());
        String nowFilmWatch = allFilms.get(nowChoiceNumber);
        in.close();
        System.out.println(nowFilmWatch);
        return nowFilmWatch;
    }

    public static void createFileWithFilmForWatchNow() throws IOException {
        FileWriter newFileWithOneFilmForWatchNow = new FileWriter("NowWatch.txt");
        newFileWithOneFilmForWatchNow.write(createListOfFileForWatch());
        newFileWithOneFilmForWatchNow.close();
    }

    public static void createFileWithListOfFilmsToWatchNext() throws IOException {
        FileWriter newFileWithListOfFilmsToWatchNext = new FileWriter("Films.txt");
        outString = "";
        for (int i = 0; i < allFilms.size(); i++) {
            if (i != nowChoiceNumber && i != allFilms.size() - 1) {
                outString += allFilms.get(i) + "\n";
            }
            if (i != nowChoiceNumber && i == allFilms.size() - 1) {
                outString += allFilms.get(i);
            }
        }
        newFileWithListOfFilmsToWatchNext.write(outString);
        newFileWithListOfFilmsToWatchNext.close();
    }
}
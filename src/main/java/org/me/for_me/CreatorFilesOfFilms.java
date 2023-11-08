package org.me.for_me;

import static java.lang.System.in;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class CreatorFilesOfFilms {

  static ArrayList<String> allFilms = new ArrayList<>();
  static String outString;
  static int nowChoiceNumber;
  static String nowChoiceFilm;

  public static ArrayList<String> createListOfFileForWatch() throws FileNotFoundException {
    File filmsListForWatch = new File("Films.txt");
    Scanner in = new Scanner(filmsListForWatch);
    while ((in.hasNextLine())) {
      allFilms.add(in.nextLine());
    }
    return allFilms;
  }

  public static String choiceTheFilm() throws IOException {
    Random ChoiceNumberOfRandom = new Random();
    nowChoiceNumber = ChoiceNumberOfRandom.nextInt(allFilms.size());
    String nowFilmWatch = allFilms.get(nowChoiceNumber);
    nowChoiceFilm = nowFilmWatch;
    in.close();
    System.out.println(nowFilmWatch);
    return nowFilmWatch;
  }

  public static void createFileWithFilmForWatchNow() throws IOException {
    FileWriter newFileWithOneFilmForWatchNow = new FileWriter("NowWatch.txt");
    newFileWithOneFilmForWatchNow.write(String.valueOf(nowChoiceFilm));
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

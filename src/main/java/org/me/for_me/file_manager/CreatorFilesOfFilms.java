package org.me.for_me.file_manager;

import static java.lang.System.in;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class CreatorFilesOfFilms {

  public ArrayList<String> createListOfFileForWatch() throws FileNotFoundException {
    ArrayList<String> allFilms = new ArrayList<>();
    File filmsListForWatch = new File("Films.txt");
    Scanner in = new Scanner(filmsListForWatch);
    while ((in.hasNextLine())) {
      allFilms.add(in.nextLine());
    }
    return allFilms;
  }

  public int filmNumber() throws FileNotFoundException {
    CreatorFilesOfFilms creatorFilesOfFilms = new CreatorFilesOfFilms();
    ArrayList<String> allFilms = new ArrayList<>(creatorFilesOfFilms.createListOfFileForWatch());
    Random ChoiceNumberOfRandom = new Random();
    return ChoiceNumberOfRandom.nextInt(allFilms.size());
  }

  public String choiceTheFilm() throws IOException {
    String nowFilmWatch = createListOfFileForWatch().get(filmNumber());
    in.close();
    System.out.println(nowFilmWatch);
    return nowFilmWatch;
  }

  public void createFileWithFilmForWatchNow() throws IOException {
    FileWriter newFileWithOneFilmForWatchNow = new FileWriter("NowWatch.txt");
    newFileWithOneFilmForWatchNow.write(String.valueOf(filmNumber()));
    newFileWithOneFilmForWatchNow.close();
  }

  public void createFileWithListOfFilmsToWatchNext() throws IOException {
    CreatorFilesOfFilms creatorFilesOfFilms = new CreatorFilesOfFilms();
    int nowChoiceNumber = filmNumber();
    ArrayList<String> allFilms = new ArrayList<>(creatorFilesOfFilms.createListOfFileForWatch());
    FileWriter newFileWithListOfFilmsToWatchNext = new FileWriter("Films.txt");
    String outString = "";
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

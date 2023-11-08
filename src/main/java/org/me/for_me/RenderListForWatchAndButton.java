package org.me.for_me;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RenderListForWatchAndButton {

  static JFrame frame;
  static JPanel panel;
  static JPanel mainPanel;
  static JButton buttonExit;
  static JButton buttonChoice;
  private static String[] data;

  public static void renderTopMenu() throws FileNotFoundException {

    panel = new JPanel();
    panel.setBorder(BorderFactory.createTitledBorder("Список фильмов:"));
    mainPanel = new JPanel();

    data = CreatorFilesOfFilms.createListOfFileForWatch().toArray(new String[0]);
    JList list = new JList(data);
    list.setOpaque(true);
    list.setFont(new Font("Dialog", Font.BOLD, 14));

    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel.add(new JScrollPane(list));
    onClickExit();
    panel.add(buttonExit);
    onClickChoice();
    panel.add(buttonChoice);
    panel.setSize(700, 250);

    mainPanel.add(panel, BorderLayout.NORTH);
  }

  public static void addTopMenuInFrame() {
    frame = new JFrame("Карусель фильмов");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.getContentPane().add(mainPanel);
    frame.setVisible(true);
  }

  public static void onClickExit() {
    buttonExit = new JButton("Exit");
    buttonExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        System.exit(0);
      }
    });
  }

  public static void onClickChoice() {
    buttonChoice = new JButton("Choice");
    buttonChoice.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String film = CreatorFilesOfFilms.choiceTheFilm();
          CreatorFilesOfFilms.createFileWithFilmForWatchNow();
          CreatorFilesOfFilms.createFileWithListOfFilmsToWatchNext();
          RenderNameTheFilmForWatch.film.setText(film);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }
}

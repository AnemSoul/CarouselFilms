package org.me.for_me;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RenderNameTheFilmForWatch {

  static JPanel bottomPanel;
  static JPanel mainPanel;
  static JFrame frame;
  static String chosenFilm;
  static JLabel film;

  public static void renderBottomMenu() {

    mainPanel = RenderListForWatchAndButton.mainPanel;

    chosenFilm = "Нажмите Choice для выбора фильма!";
    bottomPanel = new JPanel();
    bottomPanel.setBorder(BorderFactory.createTitledBorder("Выбранный фильм:"));
    film = new JLabel(chosenFilm);

    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    bottomPanel.setSize(700, 250);
    bottomPanel.add(film);
    mainPanel.add(bottomPanel, BorderLayout.AFTER_LINE_ENDS);
  }

  public static void addBottomMenuInFrame() {
    frame = RenderListForWatchAndButton.frame;
    frame.getContentPane().add(mainPanel);
    frame.setSize(700, 500);
    frame.setVisible(true);
  }
}

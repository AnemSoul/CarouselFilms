package org.me.for_me.render;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RenderNameTheFilmForWatch {

  static JLabel film;

  public JLabel renderChosenFilmLabel() {
    String chosenFilm = "Нажмите Choice для выбора фильма!";
    film = new JLabel(chosenFilm);
    return film;
  }

  public JPanel renderBottomMenu() throws FileNotFoundException {
    RenderListForWatchAndButton renderListForWatchAndButton = new RenderListForWatchAndButton();
    RenderNameTheFilmForWatch renderNameTheFilmForWatch = new RenderNameTheFilmForWatch();

    JPanel mainPanel = renderListForWatchAndButton.renderTopMenu();

    JPanel bottomPanel = new JPanel();
    bottomPanel.setBorder(BorderFactory.createTitledBorder("Выбранный фильм:"));

    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    bottomPanel.setSize(700, 250);
    bottomPanel.add(renderNameTheFilmForWatch.renderChosenFilmLabel());
    mainPanel.add(bottomPanel, BorderLayout.AFTER_LINE_ENDS);

    return mainPanel;
  }

  public void addBottomMenuInFrame() throws FileNotFoundException {
    RenderListForWatchAndButton renderListForWatchAndButton = new RenderListForWatchAndButton();
    RenderNameTheFilmForWatch renderNameTheFilmForWatch = new RenderNameTheFilmForWatch();
    JFrame frame = renderListForWatchAndButton.addTopMenuInFrame();
    frame.getContentPane().add(renderNameTheFilmForWatch.renderBottomMenu());
    frame.setSize(700, 500);
    frame.setVisible(true);
  }
}

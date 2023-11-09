package org.me.for_me.render;

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
import org.me.for_me.file_manager.CreatorFilesOfFilms;

public class RenderListForWatchAndButton {

  public JPanel renderTopMenu() throws FileNotFoundException {
    CreatorFilesOfFilms creatorFilesOfFilms = new CreatorFilesOfFilms();

    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createTitledBorder("Список фильмов:"));
    JPanel mainPanel = new JPanel();

    String[] data = creatorFilesOfFilms.createListOfFileForWatch().toArray(new String[0]);
    JList list = new JList(data);
    list.setOpaque(true);
    list.setFont(new Font("Dialog", Font.BOLD, 14));

    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel.add(new JScrollPane(list));
    onClickExit();
    panel.add(onClickExit());
    onClickChoice();
    panel.add(onClickChoice());
    panel.setSize(700, 250);

    mainPanel.add(panel, BorderLayout.NORTH);
    return mainPanel;
  }

  public JFrame addTopMenuInFrame() throws FileNotFoundException {
    RenderListForWatchAndButton renderListForWatchAndButton = new RenderListForWatchAndButton();

    JFrame frame = new JFrame("Карусель фильмов");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.getContentPane().add(renderListForWatchAndButton.renderTopMenu());
    frame.setVisible(true);

    return frame;
  }

  public JButton onClickExit() {
    RenderListForWatchAndButton renderListForWatchAndButton = new RenderListForWatchAndButton();
    JButton buttonExit = new JButton("Exit");
    buttonExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          renderListForWatchAndButton.addTopMenuInFrame().setVisible(false);
        } catch (FileNotFoundException ex) {
          throw new RuntimeException(ex);
        }
        System.exit(0);
      }
    });
    return buttonExit;
  }

  public JButton onClickChoice() {
    CreatorFilesOfFilms creatorFilesOfFilms = new CreatorFilesOfFilms();
    RenderNameTheFilmForWatch renderNameTheFilmForWatch = new RenderNameTheFilmForWatch();
    JButton buttonChoice = new JButton("Choice");
    buttonChoice.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String film = creatorFilesOfFilms.choiceTheFilm();
          creatorFilesOfFilms.createFileWithFilmForWatchNow();
          creatorFilesOfFilms.createFileWithListOfFilmsToWatchNext();
          RenderNameTheFilmForWatch.film.setText(film);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
    return buttonChoice;
  }
}

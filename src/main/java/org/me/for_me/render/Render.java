package org.me.for_me.render;

import java.io.FileNotFoundException;

public class Render {

  public void render() throws FileNotFoundException {

    RenderListForWatchAndButton renderListForWatchAndButton = new RenderListForWatchAndButton();
    renderListForWatchAndButton.renderTopMenu();
    renderListForWatchAndButton.addTopMenuInFrame();

    RenderNameTheFilmForWatch.renderBottomMenu();
    RenderNameTheFilmForWatch.addBottomMenuInFrame();
  }
}

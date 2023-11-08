package org.me.for_me;

import java.io.FileNotFoundException;

public class Render {

  public void render() throws FileNotFoundException {
    RenderListForWatchAndButton.renderTopMenu();
    RenderListForWatchAndButton.addTopMenuInFrame();
    RenderNameTheFilmForWatch.renderBottomMenu();
    RenderNameTheFilmForWatch.addBottomMenuInFrame();
  }
}

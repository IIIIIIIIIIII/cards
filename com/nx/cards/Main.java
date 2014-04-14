package com.nx.cards;

import com.nx.cards.ui.CardsFrame;
import javax.swing.*;

/* ---------------------------------------------------------------[ Main ]--- */

public class Main {

  public static void main(String... args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel("org.pushingpixels.substance" +
              ".api.skin.SubstanceGraphiteLookAndFeel");
        } catch (Exception e) {
          e.printStackTrace();
        }
        CardsFrame frame = new CardsFrame();
        frame.setVisible(true);
      }
    });
  }
}
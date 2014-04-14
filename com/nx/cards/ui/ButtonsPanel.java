package com.nx.cards.ui;

import com.nx.cards.data.PairCollection;
import com.nx.cards.data.PairOfWords;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/* -------------------------------------------------------[ ButtonsPanel ]--- */

public class ButtonsPanel extends JPanel {

  private CardsFrame parent;

  private int guessing;

  private PairCollection coll;
  private PairOfWords actualPair;
  private NextButton nextButton;
  private GuessButton guessButton;

  public ButtonsPanel(CardsFrame parent) {
    this.parent = parent;

    nextButton = new NextButton("next");
    guessButton = new GuessButton("guess");

    add(nextButton);
    add(guessButton);
    add(new SwapButton("swap"));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }

  public void openFile(File file) {
    try {
      coll = new PairCollection(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int getNumberOfPairs() {
    return coll.getNumberOfPairs();
  }

  /* -------------------------------------------------------[ NextButton ]--- */

  class NextButton extends JButton {
    NextButton(String text) {
      super(text);
      addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          actualPair = coll.getRandomPair();
          parent.setWords(actualPair);
          guessing = 0;
          parent.setState("");
          parent.setGuessFieldContent("");
          guessButton.setEnabled(true);
        }
      });
    }
  }

  /* ------------------------------------------------------[ GuessButton ]--- */

  class GuessButton extends JButton {

    GuessButton(String text) {
      super(text);
      addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          // 3x lehet tippelni
          if (guessing < 3) {
            guessing += 1;

            if (actualPair.getWordB()
                .equals(parent.getGuessFieldContent())) {
              parent.setState(":)");
              parent.setPoint(1);
              setEnabled(false);
            } else {
              parent.setState(":(");
              parent.setPoint(-1);
            }

          } else {
            // ha 3x rosszat tippelt a user, akkor szabad a gazda
            parent.setGuessFieldContent(actualPair.getWordB());
            parent.setState("xD");
          }
        }
      });
    }
  }

  /* -------------------------------------------------------[ SwapButton ]--- */

  class SwapButton extends JButton {
    SwapButton(String text) {
      super(text);
      addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          coll.swapMode();
          nextButton.doClick();
        }
      });
    }
  }
}
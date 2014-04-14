package com.nx.cards.ui;

import com.nx.cards.data.PairOfWords;

import javax.swing.*;
import java.awt.*;

/* ---------------------------------------------------------[ WordsPanel ]--- */

public class WordsPanel extends JPanel {

  private JLabel wordA = new JLabel("");
  private JTextField wordB = new JTextField("");
  private JLabel state = new JLabel("");

  public WordsPanel() {
    wordA.setPreferredSize(new JButton("something").getPreferredSize());
    wordA.setAlignmentX(Component.CENTER_ALIGNMENT);
    wordB.setPreferredSize(wordA.getPreferredSize());
    state.setPreferredSize(wordA.getPreferredSize());
    state.setAlignmentX(Component.CENTER_ALIGNMENT);

    add(wordA);
    add(wordB);
    add(state);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }

  public void setWords(PairOfWords pair) {
    wordA.setText(pair.getWordA());
  }

  public String getGuessFieldContent() {
    return wordB.getText();
  }

  public void setGuessFieldContent(String solution) {
    wordB.setText(solution);
  }

  public void setState(String state) {
    this.state.setText(state);
  }
}
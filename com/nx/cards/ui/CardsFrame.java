package com.nx.cards.ui;

import com.nx.cards.data.PairOfWords;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/* ---------------------------------------------------------[ CardsFrame ]--- */

public class CardsFrame extends JFrame {

  private static final int DEFAULT_WIDTH = 300;
  private static final int DEFAULT_HEIGHT = 120;

  private WordsPanel wordsPanel = new WordsPanel();
  private ButtonsPanel buttonsPanel = new ButtonsPanel(this);
  private StatsPanel statsPanel = new StatsPanel(this);

  public CardsFrame() {
    setTitle("Cards");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setResizable(false);
    setLocationByPlatform(true);
    setLayout(new FlowLayout());
    add(wordsPanel);
    add(buttonsPanel);
    add(statsPanel);
    //pack();
  }

  public void setWords(PairOfWords pair) {
    wordsPanel.setWords(pair);
  }

  public String getGuessFieldContent() {
    return wordsPanel.getGuessFieldContent();
  }

  public void openFile(File file) {
    buttonsPanel.openFile(file);
  }

  public void setState(String state) {
    wordsPanel.setState(state);
  }

  public void setGuessFieldContent(String solution) {
    wordsPanel.setGuessFieldContent(solution);
  }

  public int getNumberOfPairs() {
    return buttonsPanel.getNumberOfPairs();
  }

  public void setPoint(int i) {
    statsPanel.setPoint(i);
  }
}
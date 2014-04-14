package com.nx.cards.data;

/* --------------------------------------------------------[ PairOfWords ]--- */

public class PairOfWords {

  private String wordA;
  private String wordB;

  public PairOfWords(String wordA, String wordB) {
    this.wordA = wordA;
    this.wordB = wordB;
  }

  public String getWordA() {
    return wordA;
  }

  public String getWordB() {
    return wordB;
  }

  public void swap() {
    String temp = wordA;
    wordA = wordB;
    wordB = temp;
  }
}
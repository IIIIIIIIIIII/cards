package com.nx.cards.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/* -----------------------------------------------------[ PairCollection ]--- */

public class PairCollection {

  private ArrayList<PairOfWords> pairCollection = new ArrayList<PairOfWords>();
  private Random random = new Random();

  public PairCollection(File filePath) throws IOException {
    BufferedReader reader =
        new BufferedReader(new FileReader(filePath));

    String line;
    while ((line = reader.readLine()) != null) {
      String[] pair = line.split(";");
      addPair(pair[0], pair[1]);
    }
    reader.close();
  }

  public int getNumberOfPairs() {
    return pairCollection.size();
  }

  private PairOfWords getPair(int n) {
    return pairCollection.get(n);
  }

  private void addPair(String wordA, String wordB) {
    pairCollection.add(new PairOfWords(wordA, wordB));
  }

  public PairOfWords getRandomPair() {
    int randomNumber = random.nextInt(getNumberOfPairs());
    return getPair(randomNumber);
  }

  public void swapMode() {
    for (PairOfWords pair : pairCollection) {
      pair.swap();
    }
  }
}
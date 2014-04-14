package com.nx.cards.ui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/* ---------------------------------------------------------[ StatsPanel ]--- */

public class StatsPanel extends JPanel {

  private CardsFrame parent;

  private int actualPoints = 0;
  private JButton topic = new JButton("topic");
  private JLabel numberOfWords = new JLabel("0 words");
  private JLabel points = new JLabel(actualPoints + " point");

  private JFileChooser chooser = new JFileChooser();

  public StatsPanel(CardsFrame parent) {
    this.parent = parent;

    numberOfWords.setPreferredSize(topic.getPreferredSize());
    points.setPreferredSize(topic.getPreferredSize());

    chooser.setFileFilter(new FileNameExtensionFilter("Cards", "cards"));

    topic.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (chooser.showOpenDialog(StatsPanel.this)
            == JFileChooser.APPROVE_OPTION) {
          File chosenFile = chooser.getSelectedFile();
          StatsPanel.this.parent.openFile(chosenFile);
          topic.setText(chosenFile.getName());
          numberOfWords.setText(StatsPanel.this.parent.getNumberOfPairs()
              + " words");
        }
      }
    });

    add(topic);
    add(numberOfWords);
    add(points);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }

  public void setPoint(int i) {
    actualPoints += i;
    points.setText(actualPoints + " point(s)");
  }
}

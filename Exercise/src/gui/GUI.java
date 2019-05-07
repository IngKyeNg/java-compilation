package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI {

  public static void main(String[] args) {
    (new MyListener("My Listener")).Start();
  }
}

class MyFrame extends JFrame {

  MyFrame(String title) {
    super(title);
  }

  @Override
  public void paint(Graphics g) {
    super.paintComponents(g);
    g.setColor(Color.RED);
    g.drawRect(50, 70, 120, 15);
    g.setColor(Color.PINK);
    g.fillRect(240, 160, 40, 110);

    g.setColor(Color.GREEN);
    g.drawOval(50, 225, 100, 50);
    g.setColor(Color.ORANGE);
    g.fillOval(225, 87, 50, 25);

    g.setColor(Color.YELLOW);
    g.drawArc(10, 210, 80, 80, 90, 180);
    g.setColor(Color.CYAN);
    g.fillArc(140, 140, 120, 120, 90, 45);

    g.setColor(Color.MAGENTA);
    g.fillArc(150, 250, 100, 100, 90, 90);
    g.setColor(Color.BLACK);
    g.fillArc(160, 260, 80, 80, 90, 90);

    g.setColor(Color.BLUE);
    g.drawString("Java 2D!", 50, 150);
  }
}

class MyListener implements MouseMotionListener, MouseListener,
  ItemListener, ActionListener {

  private MyFrame f;
  private JMenuBar mb = new JMenuBar();

  public MyListener(String title) {
    f = new MyFrame(title);
    JMenu m = new JMenu("File");
    JMenuItem mi = new JMenuItem("Exit");
    mi.addActionListener(this);
    m.add(mi);
    mb.add(m);

    m = new JMenu("Edit");
    JMenu mColor = new JMenu("Color");
    JMenuItem mColorRed = new JMenuItem("Red");
    mColor.add(mColorRed);
    mColorRed.addActionListener(this);
    JMenuItem mColorGreen = new JMenuItem("Green");
    mColorGreen.addActionListener(this);
    mColor.add(mColorGreen);
    JMenuItem mColorBlue = new JMenuItem("Blue");
    mColorBlue.addActionListener(this);
    mColor.add(mColorBlue);
    mColor.addSeparator();
    JMenuItem mColorCustom = new JMenuItem("Custom");
    mColorCustom.addActionListener(this);
    mColor.add(mColorCustom);
    m.add(mColor);
    mb.add(m);
    f.setJMenuBar(mb);
  }

  public void Start() {
    f.addMouseMotionListener(this);
    f.addMouseListener(this);
    f.setSize(640, 480);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {
      
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
      case "Exit":
        if (JOptionPane.showConfirmDialog(null, 
          "Are you sure?","Exit Confirmation", 
          JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
          System.exit(0);
        }
        break;
      case "Red":
        mb.setBackground(Color.RED);
        break;
      case "Green":
        mb.setBackground(Color.GREEN);
        break;
      case "Blue":
        mb.setBackground(Color.BLUE);
        break;
      case "Custom":
        Color c = JColorChooser.showDialog(
          null, "Select Color",mb.getBackground());
        if (c != null) mb.setBackground(c);
        break;
    }    
  }
}

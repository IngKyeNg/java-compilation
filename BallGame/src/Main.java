
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class GameFrame extends JFrame {

  private ArrayList<Ball> Balls = new ArrayList<Ball>();

  public GameFrame(String title) {
    super(title);
  }

  public void AddBall(Ball b) {
    Balls.add(b);
  }

  public void paint(Graphics g) {
    super.paintComponents(g);
    for (Ball b : Balls) {
      int x = b.X - b.R;
      int y = b.Y - b.R;
      int d = 2 * b.R;//Diameter
      g.setColor(b.C);
      g.drawOval(x, y, d, d);
      g.fillOval(x, y, d, d);
    }
  }
}

class Ball implements Runnable {

  static enum BallSpeed {

    Fast, Normal, Slow
  }
  private int DX = 2;
  private int DY = 2;
  private boolean Moving;
  private GameFrame GF;
  Color C;
  int X, Y;//Center of the ball
  int R;//Radius
  BallSpeed Speed = BallSpeed.Normal;

  public Ball(GameFrame f, Color c, int x, int y, int r, BallSpeed speed) {
    C = c;
    X = x;
    Y = y;
    R = r;
    GF = f;
    Speed = speed;
    Moving = true;
  }

  public Ball(GameFrame f, Color c, int x, int y, int r) {
    this(f, c, x, y, r, BallSpeed.Normal);
  }

  public void run() {
    int ms = (Speed == BallSpeed.Fast) ? 5 : (Speed == BallSpeed.Slow) ? 200 : 50;
    int w, h;
    while (Moving) {
      w = GF.getWidth();
      X += DX;
      if ((X - R) < 0) {
        X = 2 * R - X;
        DX = -DX;
      } else {
        if ((X + R) > w) {
          X = 2 * (w - R) - X;
          DX = -DX;
        }
      }
      h = GF.getHeight();
      Y += DY;
      if ((Y - R) < 0) {
        Y = 2 * R - Y;
        DY = -DY;
      } else {
        if ((Y + R) > h) {
          Y = 2 * (h - R) - Y;
          DY = -DY;
        }
      }
      GF.repaint();
      try {
        Thread.sleep(ms);
      } catch (InterruptedException e) {
      }
    }
  }
}

class Game implements KeyListener {

  private GameFrame gf;

  public void keyPressed(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
  }

  public void keyTyped(KeyEvent e) {
        //char c = e.getKeyChar();
    //if ( c != KeyEvent.CHAR_UNDEFINED ) {
    //  s = s + c;
    //  repaint();
    //  e.consume();
    //}
  }

  public Game(String title, int w, int h) {
    gf = new GameFrame(title);
    gf.setSize(w, h);
    gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gf.setVisible(true);
  }

  public void AddBall(Color c, int x, int y, int r, Ball.BallSpeed speed) {
    Ball b = new Ball(gf, c, x, y, r, speed);
    gf.AddBall(b);
    Thread t = new Thread(b);
    t.start();
  }

  public void AddBall(Color c, int x, int y, int r) {
    AddBall(c, x, y, r, Ball.BallSpeed.Normal);
  }
}

public class Main {

  public static void main(String[] args) {
    Game g = new Game("Ball Game", 500, 300);
    g.AddBall(Color.RED, 50, 50, 20, Ball.BallSpeed.Fast);
    g.AddBall(Color.BLUE, 10, 100, 10);
    g.AddBall(Color.YELLOW, 200, 200, 15);
    g.AddBall(Color.GREEN, 10, 300, 5, Ball.BallSpeed.Slow);
    g.AddBall(Color.CYAN, 100, 100, 25, Ball.BallSpeed.Slow);
    g.AddBall(Color.pink, 25, 25, 5, Ball.BallSpeed.Slow);
  }
}

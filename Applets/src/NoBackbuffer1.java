/*--------------------------------------------------------------------
Exercise 7: Backbuffers
Up to this point, the graphics drawn by our applets have been relatively simple. With more complex graphics however, whether in animations or interactive programs, flicker can become a problem. (You may have already noticed subtle flickering in some of the previous applets.) 

This example demonstrate the problem. It uses a pseudo-random number generator to produce a big, hairy tangle of lines. The lines follow the mouse cursor. 


--------------------------------------------------------------------*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class NoBackbuffer1 extends Applet
   implements MouseMotionListener {

   int width, height;
   int mx, my;  // the mouse coordinates
   Point[] points;
   int N = 300;

   public void init() {
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.black );

      mx = width/2;
      my = height/2;

      points = new Point[ N ];
      for ( int i = 0; i < N; ++i ) {
         int x = (int)(( Math.random() - 0.5 ) * width / 1.5);
         int y = (int)(( Math.random() - 0.5 ) * height / 1.5);
         points[i] = new Point( x, y );
      }

      addMouseMotionListener( this );
   }

   public void mouseMoved( MouseEvent e ) {
      mx = e.getX();
      my = e.getY();
      showStatus( "Mouse at (" + mx + "," + my + ")" );
      repaint();
      e.consume();
   }
   public void mouseDragged( MouseEvent e ) { }

   public void paint( Graphics g ) {
      g.setColor( Color.white );
      for ( int j = 1; j < N; ++j ) {
         Point A = points[j-1];
         Point B = points[j];
         g.drawLine( mx+A.x, my+A.y, mx+B.x, my+B.y );
      }
   }
}

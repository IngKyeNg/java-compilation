/*--------------------------------------------------------------------
Exercise 7B: Backbuffers
You probably see flickering when you move the mouse over the applet. The lines take a significant amount of time to draw, and since the canvas is cleared before each redraw, the image on the canvas is actually incomplete most of the time. 

This second example makes the problem even more pronounced by rendering a bitmap image in the background. 
The flickering you see now should be especially bad.

--------------------------------------------------------------------*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class NoBackbuffer2 extends Applet
   implements MouseMotionListener {

   int width, height;
   int mx, my;  // the mouse coordinates
   Point[] points;
   int N = 300;
   Image img;

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

      // Download the image "fractal.gif" from the
      // same directory that the applet resides in.
      img = getImage( getDocumentBase(), "fractal.gif" );

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
      g.drawImage( img, 0, 0, this );
      g.setColor( Color.white );
      for ( int j = 1; j < N; ++j ) {
         Point A = points[j-1];
         Point B = points[j];
         g.drawLine( mx+A.x, my+A.y, mx+B.x, my+B.y );
      }
   }
}

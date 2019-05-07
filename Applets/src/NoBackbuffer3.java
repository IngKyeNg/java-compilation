/*--------------------------------------------------------------------
Exercise 7B: Backbuffers
The solution is to use double-buffering : rather than perform drawing operations directly to screen, we draw onto an image buffer (the "backbuffer") in memory, and only after completing this image do we copy it onto the screen. There is no need to erase or clear the contents of the screen before copying (or "swapping", as it's called) the backbuffer onto the screen. During the swap, we simply overwrite the image on the screen. Hence the screen never displays a partial image: even in the middle of swapping, the screen will contain 50 % of the old image and 50 % of the new image. As long as the swap is not too slow, the eye is fooled into seeing a continuous, smooth flow of images. 

This example uses a backbuffer. 
--------------------------------------------------------------------*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class NoBackbuffer3 extends Applet
   implements MouseMotionListener {

   int width, height;
   int mx, my;  // the mouse coordinates
   Point[] points;
   int N = 300;
   Image img;
   Image backbuffer;
   Graphics backg;

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

      img = getImage(getDocumentBase(), "fractal.gif");

      backbuffer = createImage( width, height );
      backg = backbuffer.getGraphics();
      backg.setColor( java.awt.Color.WHITE );

      addMouseMotionListener( this );
   }

   public void mouseMoved( MouseEvent e ) {
      mx = e.getX();
      my = e.getY();
      showStatus( "Mouse at (" + mx + "," + my + ")" );

      backg.drawImage( img, 0, 0, this );
      for ( int j = 1; j < N; ++j ) {
         Point A = points[j-1];
         Point B = points[j];
         backg.drawLine( mx+A.x, my+A.y, mx+B.x, my+B.y );
      }

      repaint();
      e.consume();
   }
   public void mouseDragged( MouseEvent e ) { }

   public void paint( Graphics g ) {
      g.drawImage( backbuffer, 0, 0, this );
   }
}
/*
Why do we still see flicker ? Whenever the applet is supposed to redraw itself, the applet's update() function gets called. The java.awt.Component class (which is a base class of Applet) defines a default version of update() which does the following: (1) clears the applet by filling it with the background color, (2) sets the color of the graphics context to be the applet's foreground color, (3) calls the applet's paint() function. We see flickering because the canvas is still cleared before each redraw. To prevent this, we need to define our own update() function, to override the base class' behavior. 


import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Backbuffer2 extends Applet
   implements MouseMotionListener {

   int width, height;
   int mx, my;  // the mouse coordinates
   Point[] points;
   int N = 300;
   Image img;
   Image backbuffer;
   Graphics backg;

   public void init() {
      width = getSize().width;
      height = getSize().height;

      mx = width/2;
      my = height/2;

      points = new Point[ N ];
      for ( int i = 0; i < N; ++i ) {
         int x = (int)(( Math.random() - 0.5 ) * width / 1.5);
         int y = (int)(( Math.random() - 0.5 ) * height / 1.5);
         points[i] = new Point( x, y );
      }

      img = getImage(getDocumentBase(), "fractal.gif");

      backbuffer = createImage( width, height );
      backg = backbuffer.getGraphics();
      backg.setColor( Color.white );

      addMouseMotionListener( this );
   }

   public void mouseMoved( MouseEvent e ) {
      mx = e.getX();
      my = e.getY();
      showStatus( "Mouse at (" + mx + "," + my + ")" );

      backg.drawImage( img, 0, 0, this );
      for ( int j = 1; j < N; ++j ) {
         Point A = points[j-1];
         Point B = points[j];
         backg.drawLine( mx+A.x, my+A.y, mx+B.x, my+B.y );
      }

      repaint();
      e.consume();
   }
   public void mouseDragged( MouseEvent e ) { }

   public void update( Graphics g ) {
      g.drawImage( backbuffer, 0, 0, this );
   }

   public void paint( Graphics g ) {
      update( g );
   }
}

*/
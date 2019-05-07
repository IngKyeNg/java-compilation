/*--------------------------------------------------------------------
Exercise 8C: Painting
Programming a custom brush and canvas enables experimentation with behaviors not otherwise possible. An understanding of arithmetic, geometry, and trigonometry will enhance your own ability to "play" in this medium 
--------------------------------------------------------------------*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class Brush2 extends Applet
   implements MouseMotionListener {

   int width, height;
   Image backbuffer;
   Graphics backg;

   int mx, my;

   double t = 0;

   public void init() {
      width = getSize().width;
      height = getSize().height;

      mx = width / 2;
      my = height / 2;

      backbuffer = createImage( width, height );
      backg = backbuffer.getGraphics();
      backg.setColor( java.awt.Color.BLACK );
      backg.fillRect( 0, 0, width, height );
      backg.setColor( java.awt.Color.WHITE );

      addMouseMotionListener( this );
   }

   public void mouseMoved( MouseEvent e ) { }
   public void mouseDragged( MouseEvent e ) {
      int x = e.getX();
      int y = e.getY();
      int dx = x - mx;
      int dy = y - my;
      t += Math.sqrt( dx*dx + dy*dy ) / 20;
      if ( t > 2*Math.PI ) {
         t -= 2*Math.PI;
      }
      backg.drawLine( x, y, x+(int)(15*Math.cos(t)), y+(int)(15*Math.sin(t)) );
      mx = x;
      my = y;
      repaint();
      e.consume();
   }

   public void update( Graphics g ) {
      g.drawImage( backbuffer, 0, 0, this );
   }

   public void paint( Graphics g ) {
      update( g );
   }
}

/*--------------------------------------------------------------------
Exercise 8B: Painting
Click and type; click again and type some more:  
--------------------------------------------------------------------*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Keyboard3 extends Applet
   implements KeyListener, MouseListener {

   int width, height;
   int x, y;
   String s = "";
   Image backbuffer;
   Graphics backg;

   public void init() {
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.black );

      x = width/2;
      y = height/2;

      backbuffer = createImage( width, height );
      backg = backbuffer.getGraphics();
      backg.setColor( Color.black );
      backg.fillRect( 0, 0, width, height );
      backg.setColor( Color.green );

      addKeyListener( this );
      addMouseListener( this );
   }

   public void keyPressed( KeyEvent e ) { }
   public void keyReleased( KeyEvent e ) { }
   public void keyTyped( KeyEvent e ) {
      char c = e.getKeyChar();
      if ( c != KeyEvent.CHAR_UNDEFINED ) {
         s = s + c;
         backg.drawString( s, x, y );
         repaint();
         e.consume();
      }
   }

   public void mouseEntered( MouseEvent e ) { }
   public void mouseExited( MouseEvent e ) { }
   public void mousePressed( MouseEvent e ) { }
   public void mouseReleased( MouseEvent e ) { }
   public void mouseClicked( MouseEvent e ) {
      x = e.getX();
      y = e.getY();
      s = "";
      repaint();
      e.consume();
   }

   public void update( Graphics g ) {
      g.drawImage( backbuffer, 0, 0, this );
      g.setColor( Color.gray );
      g.drawLine( x, y, x, y-10 );
      g.drawLine( x, y, x+10, y );
   }

   public void paint( Graphics g ) {
      update( g );
   }
}



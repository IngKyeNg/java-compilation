/*--------------------------------------------------------------------
Exercise 4C: Mouse Input

Move freely over the applet. Notice that moving faster makes the line stretch out longer.  
--------------------------------------------------------------------*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Mouse3 extends Applet
   implements MouseListener, MouseMotionListener {

   int width, height;

   // We need a place to store a list of mouse positions.
   // Rather than use an array, we'll use a Vector, because
   // it allows elements to be easily appended and deleted.
   // (Technically, it would probably be more appropriate to
   // use a LinkedList, but they're only supported by Java 1.2)
   Vector listOfPositions;

   public void init() {
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.black );

      listOfPositions = new Vector();

      addMouseListener( this );
      addMouseMotionListener( this );
   }

   public void mouseEntered( MouseEvent e ) { }
   public void mouseExited( MouseEvent e ) { }
   public void mouseClicked( MouseEvent e ) { }
   public void mousePressed( MouseEvent e ) { }
   public void mouseReleased( MouseEvent e ) { }
   public void mouseMoved( MouseEvent e ) {

      if ( listOfPositions.size() >= 50 ) {
         // delete the first element in the list
         listOfPositions.removeElementAt( 0 );
      }

      // add the new position to the end of the list
      listOfPositions.addElement( new Point( e.getX(), e.getY() ) );

      repaint();
      e.consume();
   }
   public void mouseDragged( MouseEvent e ) { }

   public void paint( Graphics g ) {
      g.setColor( Color.white );
      for ( int j = 1; j < listOfPositions.size(); ++j ) {
         Point A = (Point)(listOfPositions.elementAt(j-1));
         Point B = (Point)(listOfPositions.elementAt(j));
         g.drawLine( A.x, A.y, B.x, B.y );
      }
   }
}





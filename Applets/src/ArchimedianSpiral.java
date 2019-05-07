/*--------------------------------------------------------------------
Exercise 12: Odds and Ends
Audio 

To play audio files, use Applet.play(). Java 1.1 only supports Sun Audio (.au) files, or specifically, 8 bit, u-law, 8000 Hz, one-channel Sun format. Both Applet.play() and AudioClip.play() are non-blocking: they return immediately after starting the playback of the audio file. Try here for an example. 

Applet Info 

You can embed information about your applet inside itself by defining getAppletInfo() and getParameterInfo(). 

Debugging Tips 

If you're having trouble understanding what your applet is doing (or not doing), use System.out.println() and showStatus() to print out the values of variables and information about where the program is. 

Browsers won't normally reload applets after they've been loaded once. If you test an applet inside your browser, and then modify the applet's source code and recompile, simply reloading the webpage in your browser isn't enough to view the new applet. You'll have to exit and restart your browser. To avoid this nuisance, do initial testing of applets with appletviewer rather than a web browser. 

Conditional Compilation 

In C, blocks of code can be conditionally compiled using #define flags thus: 


#define FLAG 1
...
#ifdef FLAG
...
#else
...
#endif

Java is not as flexible, but allows for something that is sometimes just as good: 


private static final boolean DEBUG = false;
...
if ( DEBUG ) {
   ...
}
else {
   ...
}

The final keyword means the variable is constant, so unless your compiler's optimizer is brain-dead, it should prune out the conditional and the unreachable block of code. 


--------------------------------------------------------------------*/
import java.applet.*;
import java.awt.*;
import java.lang.Math;
 
public class ArchimedianSpiral extends Applet {
 
   int width, height;
   int N = 30; // number of points per full rotation
   int W = 5;  // winding number, or number of full rotations
 
   public void init() {

      width = getSize().width;
      height = getSize().height;
      setBackground( Color.black );
      setForeground( Color.green );
   }
 
   public void paint( Graphics g ) {

      int x1 = 0, y1 = 0, x2, y2;
      for ( int i = 1; i <= W*N; ++i ) {
         double angle = 2*Math.PI*i/(double)N;
         double radius = i/(double)N * width/2 / (W+1);
         x2 = (int)( radius*Math.cos(angle) );
         y2 = -(int)( radius*Math.sin(angle) );
         g.drawLine( width/2+x1, height/2+y1, width/2+x2, height/2+y2 );
         x1 = x2;
         y1 = y2;
      }
   }
}
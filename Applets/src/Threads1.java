/*--------------------------------------------------------------------
Exercise 6: Threads and Animation
The only functions we have seen in applets so far are init(), paint(), and functions called in response to input events. All of these functions are supposed to do a small amount of work and return quickly. There has been no opportunity, so far, for a function to loop and do some continuous work. 

This applet creates a thread, a separate stream of execution, to perform a background task. The body of the thread's code is in the run() function. In this case, the purpose of the thread is to increment the variable i once every 1000 milliseconds, and cause the applet to redraw itself. The result is a simple animation. 
--------------------------------------------------------------------*/

import java.applet.*;
import java.awt.*;

public class Threads1 extends Applet implements Runnable {

   int width, height;
   int i = 0;
   Thread t = null;
   boolean threadSuspended;

   // Executed when the applet is first created.
   public void init() {
      System.out.println("init(): begin");
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.black );
      System.out.println("init(): end");
   }

   // Executed when the applet is destroyed.
   public void destroy() {
      System.out.println("destroy()");
   }

   // Executed after the applet is created; and also whenever
   // the browser returns to the page containing the applet.
   public void start() {
      System.out.println("start(): begin");
      if ( t == null ) {
         System.out.println("start(): creating thread");
         t = new Thread( this );
         System.out.println("start(): starting thread");
         threadSuspended = false;
         t.start();
      }
      else {
         if ( threadSuspended ) {
            threadSuspended = false;
            System.out.println("start(): notifying thread");
            synchronized( this ) {
               notify();
            }
         }
      }
      System.out.println("start(): end");
   }

   // Executed whenever the browser leaves the page containing the applet.
   public void stop() {
      System.out.println("stop(): begin");
      threadSuspended = true;
   }

   // Executed within the thread that this applet created.
   public void run() {
      System.out.println("run(): begin");
      try {
         while (true) {
            System.out.println("run(): awake");

            // Here's where the thread does some work
            ++i;  // this is shorthand for "i = i+1;"
            if ( i == 10 ) {
               i = 0;
            }
            showStatus( "i is " + i );

            // Now the thread checks to see if it should suspend itself
            if ( threadSuspended ) {
               synchronized( this ) {
                  while ( threadSuspended ) {
                     System.out.println("run(): waiting");
                     wait();
                  }
               }
            }
            System.out.println("run(): requesting repaint");
            repaint();
            System.out.println("run(): sleeping");
            t.sleep( 1000 );  // interval given in milliseconds
         }
      }
      catch (InterruptedException e) { }
      System.out.println("run(): end");
   }

   // Executed whenever the applet is asked to redraw itself.
   public void paint( Graphics g ) {
      System.out.println("paint()");
      g.setColor( Color.green );
      g.drawLine( width, height, i * width / 10, 0 );
   }
}

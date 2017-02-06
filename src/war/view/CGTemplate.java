package war.view;

import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;    // Using Swing's components and containers
 
/** Custom Drawing Code Template */
// A Swing application extends javax.swing.JFrame
public class CGTemplate extends JFrame {
   // Define constants
   public static final int CANVAS_WIDTH  = 640;
   public static final int CANVAS_HEIGHT = 480; 
   // Declare an instance of the drawing canvas,
   // which is an inner class called DrawCanvas extending javax.swing.JPanel.
   private final DrawCanvas canvas; 
   // Constructor to set up the GUI components and event handlers
   public CGTemplate() {
      canvas = new DrawCanvas();    // Construct the drawing canvas
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
 
      // Set the Drawing JPanel as the JFrame's content-pane
      Container cp = getContentPane();
      cp.add(canvas);
      // or "setContentPane(canvas);"
 
      setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
      pack();              // Either pack() the components; or setSize()
      setTitle("......");  // "super" JFrame sets the title
      setVisible(true);    // "super" JFrame show
   }
 
   /**
    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
    */
   private class DrawCanvas extends JPanel {
      // Override paintComponent to perform your own painting
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);     // paint parent's background
         
         paintBrazil(g);
      }
      
      public void paintBrazil(Graphics g){
        String pathToImageSortBy = "200.png";
        BufferedImage image = null;
        try {
            URL url = getClass().getResource(pathToImageSortBy);
            image = ImageIO.read(url);
          } catch (IOException e) {
              System.out.println("n foi");
          }
          for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
            }
          }
          g.drawImage(image, 10, 10, this);
      }
   }
 
   // The entry main method
   public static void main(String[] args) {
      // Run the GUI codes on the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new CGTemplate(); // Let the constructor do the job
         }
      });
   }
}
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame; 
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ball extends JPanel {
    //Initialize ball position
    int x = 0, y = 0, xVelocity = 1, yVelocity = 1;
    int width = 700, height =700 ;
    int diameter = 60;
    

    private void moveBall() {
        if (x > width - diameter)
            xVelocity = -1;
        if (y > height - diameter)
            yVelocity = -1;
        if (x < width)
            xVelocity = ;
        if (y < width)
            yVelocity = ; 
        // move ball
        x = x + xVelocity;
        y = y + yVelocity;
        
    }


    @Override
    public void paint(Graphics g) {
        //this clears the screen before reprinting circle at new position
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Antialiasing makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        
            //Draws the cirlce at new position with same diameter
        g2d.fillOval(x, y, diameter, diameter);
    }

    public static void main(String[] args) throws InterruptedException {
        //Name of the window 
        JFrame frame = new JFrame("Mini Tennis");
        Ball game = new Ball();
        frame.add(game);
        frame.setSize(game.width, game.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.moveBall();
            game.repaint();

            // tells the processor that the thread which is being
            // run must sleep for 10 milliseconds. Bigger the number the slower
            // the game moves
            Thread.sleep(10);
        }     
    }
}
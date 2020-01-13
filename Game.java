import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// suppresses all warnings for serialization
@SuppressWarnings("serial")
//Game class 
public class Game extends JPanel {
    //
	Ball ball = new Ball(this);
	Paddle paddle = new Paddle(this);
	int speed = 1;

	public Game() {
        // an event is created which recieves keystrokes from the user
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

            @Override
            // method is created for when keys are realeased
			public void keyReleased(KeyEvent e) {
				paddle.keyReleased(e);
			}

            @Override
            // method is created for when keys are being pressed
			public void keyPressed(KeyEvent e) {
				paddle.keyPressed(e);
			}
        });
        // 
		setFocusable(true);
	}
	
	private void move() {
        // moveBall method can be accesed from the ball class
        ball.moveBall();
        //  moveBall method can be accesed from the paddle class
		paddle.moveBall();
	}

	@Override
	public void paint(Graphics g) {
        // 
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		paddle.paint(g2d);	
	}

	public static void main(String[] args) throws InterruptedException {
        // creates a title for the window
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
        frame.add(game);
        // creates dimensions for the window
		frame.setSize(300, 400);
        frame.setVisible(true);
        // 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
            game.repaint();
            // 
			Thread.sleep(10);
		}
	}
}
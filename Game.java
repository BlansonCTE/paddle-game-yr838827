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
import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

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
        // sets boolean to true for it to run 
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
		
		//Score 
		g2d.setColor(Color.gray);
		g2d.setFont(new Font("Comic Sans", Font.ITALIC, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}

	public void gameOver(){
		JOptionPane.showMessageDialog(this, "Your score is: "+ getScore(),"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	//returns the score 
	private int getScore(){
		return speed -1;
	}


	public static void main(String[] args) throws InterruptedException {
        // creates a title for the window
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
        frame.add(game);
        // creates dimensions for the window
		frame.setSize(300, 400);
		// frame.setLocationRelativeTo(null);
		// JButton button = new JButton("Click me");
		// frame.add(button);
		// button.addActionListener(new AL());
        // makes the window visible if conditions are met 
        frame.setVisible(true);
        // enables user to exit the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
            game.repaint();
            // delays for 10 milliseconds 
			Thread.sleep(10);
		}
	}
}

// static class AL implements ActionListener{
// 	public final void actionPerformed(ActionEvent e){
// 		music()
// 	}
// }

// 	public static void music()
// 	{
// 		AudioPlayer MGP = AudioPlayer.player;

// 	}
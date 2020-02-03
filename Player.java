import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player{
    // 1. Create a variable that will hold the Y axis of the paddle2
    //    remember the paddle2 needs to have a constant Y axis because it shouldnt move vertically
    int Y = 150; 
    // 2. Create a variable to hold the width of the paddle2.
    int WIDTH = 50;
    // 3. Create a variable to hold the height of the paddle2.
    int HEIGHT = 12;
    // create a variable for current speed
    int x = 0;
    // create a variable for change in paddle2 velocity
    int xa = 0;

    private Game game;

    public Player(Game game){
        this.game = game;
    }

    public void moveBall() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            xa = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_S)
            xa = game.speed;
    }    
    
    public Rectangle getBounds(){
        return new Rectangle(x,Y, WIDTH,HEIGHT);
    }

    public int getTopY(){
        return Y;
    }

}
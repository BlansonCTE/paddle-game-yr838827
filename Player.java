import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player{
    // 1. Create a variable that will hold the Y axis of the paddle2
    //    remember the paddle2 needs to have a constant Y axis because it shouldnt move vertically
    int Y = 550; 
    // 2. Create a variable to hold the width of the paddle2.
    int WIDTH = 20;
    // 3. Create a variable to hold the height of the paddle2.
    int HEIGHT = 70;
    // create a variable for current speed
    int x = 960;
    // create a variable for change in paddle2 velocity
    int xa = 0;

    private Game game;

    public Player(Game game){
        this.game = game;
    }

    public void move() {
        if (Y + xa > 0 && Y + xa < game.getWidth() - WIDTH)
            Y = Y + xa;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.WHITE);
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
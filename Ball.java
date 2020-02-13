import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

class Ball{
    // initialize ball position and initial velocity
    int x = 500, y = 1, xa = 1, ya = 1;
    // create ball size
    private static final int DIAMETER = 30;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }
    void moveBall() {
        if (x + xa < 0)
            game.gameOver(); 
        if (x + xa > game.getWidth() - DIAMETER)
            game.gameOver();
        if (y + ya < 0)
            ya = -game.speed;
        if (y +ya > game.getHeight()-DIAMETER)
            ya = -game.speed;
        if (y + ya < 0)
            ya = game.speed;
        //makes ball bounce off paddle
        if (collision()) {
            xa *= -game.speed;
            x += 2; 
            game.speed++;
        }
        // move ball
        x = x + xa;
        y = y + ya; 
    }

    
    public void paint(Graphics2D g){
        g.setColor(Color.PINK);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
    private boolean collision(){
        boolean collided =false;
         
        if (game.paddle1.getBounds().intersects(getBounds())){
            collided = true;
        }
        if (game.paddle2.getBounds().intersects(getBounds())){
            collided = true;
        }
        return collided;
    }


    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
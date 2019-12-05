import java.awt.Graphics2D;
class Ball{
    // initialize ball position and initial velocity
    int x = 0, y = 0, xVelocity = 1, yVelocity = 1;
    // create ball size
    private static final int DIAMETER = 30;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }
    void moveBall() {
        if (x + xVelocity > game.getWidth() - DIAMETER);
            xVelocity = -1;
        else if (x < 0)
            xVelocity = 1;
        if (y + yVelocity > game.getHeight() - DIAMETER);
            yVelocity = -1;
        else if (y < 0)
            yVelocity = 1;

        // move ball
        x = x + xVelocity;
        y = y + yVelocity; 
    }
    
    public void paint(Graphics2D g){
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
}
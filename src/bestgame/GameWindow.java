/*
 * 
 */
package bestgame;
import java.awt.*;
import java.awt.event.*;


public class GameWindow extends Frame {
    
    private Button left, right;
    private Ball ball;
    int score = 0;
    String sc;
    
    public GameWindow(){
        
        this.setBackground(Color.black);
        this.setSize(900,800);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("The Game, Score: 0");
        
        
        left = new Button();
        right = new Button();
        ball = new Ball();
        
        
        left.setSize(20,100);
        left.setBackground(Color.white);
        left.setFocusable(false);
        left.setLocation(50,410);
        
        right.setSize(20,100);
        right.setBackground(Color.white);
        right.setFocusable(false);
        right.setLocation(830,410);
        
        ball.setSize(20,20);
        ball.setBackground(Color.white);
        ball.setFocusable(false);
        ball.setLocation(450,400);
        
        this.add(left);
        this.add(right);
        this.add(ball);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        addKeyListener(new Movement());
        
    }
    void moveLeft(int x){
        left.setLocation(50,x);
    }
    
    void iterateScore(){
        score++;
        sc = String.valueOf(score);
        this.setTitle("The Game, score: " + sc);
    }
    
    void moveRight(int x){
        right.setLocation(830,x);
    }
    
    
    void setBallColor(Color c){ball.setBackground(c);}
    
    void moveBall(){
        ball.setLocation(ball.getX() + Ball.xVel,
                        ball.getY() + Ball.yVel);
    }
    
    public boolean isBallColidating(){
        Point p = ball.getLocation();
        return !((p.x <= 810) & (p.x >= 70) & (p.y <= 780) & (p.y >= 24));
    }
    
    
    public boolean isBallOnSides(){
        Point p = ball.getLocation();
        return !((p.x <= 810) & (p.x >= 70));
    }
    
    public boolean ballPushedByLeft(){
        Point p = ball.getLocation();
        return (p.x < 300 & p.y >= left.getY() - 19
                & p.y <= left.getY() + 99);
        
    }
    public boolean ballPushedByRight(){
        Point p = ball.getLocation();
        return (p.x > 300 & p.y >= right.getY() - 19
                & p.y <= right.getY() + 99);
        
    }
    
    public boolean isBallOnLeft(){
        Point p = ball.getLocation();
        return (p.x > 300);
    }
    
    class Movement extends KeyAdapter{
        int speed= 40;
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_UP){
                right.setLocation(830, right.getY()-speed);
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                right.setLocation(830, right.getY()+speed);
            }
            if(e.getKeyCode() == KeyEvent.VK_W){
                left.setLocation(50, left.getY()-speed);
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                left.setLocation(50, left.getY()+speed);
            }
        }
    }
}

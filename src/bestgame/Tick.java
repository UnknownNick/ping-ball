/*
 * 
 */
package bestgame;

import java.awt.*;


public class Tick extends Thread{
    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        while(true){
            try {
                if(!Main.gm.isBallColidating()){
                    Ball.updateVelocity();
                    Main.gm.moveBall();
                    Tick.sleep(15L);
                }
                else{
                    if(Main.gm.isBallOnSides()){
                        push();                            
                    }
                    else{
                        Ball.pingBallOnWalls();
                        Ball.updateVelocity();
                        Main.gm.moveBall();
                    }
                }
            } catch (InterruptedException ex) {
                System.err.println("Unexpected interruption.");
            }
        }
    }
    private void push(){
        boolean pushed = false;
        if(Main.gm.ballPushedByLeft()){
            Ball.pingBallOnSides();
            Ball.updateVelocity();
            Main.gm.moveBall();
            pushed = true;
        } 
        if(Main.gm.ballPushedByRight()){
            Ball.pingBallOnSides();
            Ball.updateVelocity();
            Main.gm.moveBall();
            pushed = true;
        } 
        if(pushed) Main.gm.iterateScore();
        if(!pushed) {
            ///*
            Main.gm.setBallColor(Color.red);
            try {Tick.sleep(750L); } catch (InterruptedException ex) {}
            Main.gm.setBallColor(Color.white);
            try{Tick.sleep(2000L); } catch(InterruptedException ex){}
            System.exit(0);
            //*/
        }
    }
}

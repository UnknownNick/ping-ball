/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestgame;
import java.awt.*;
/**
 *
 * @author JH
 */
public class Ball extends Button{
    static int xVel=2, yVel=1;
    static int velInit = 2;
    private static int angle = 1;
    
    public static void updateVelocity(){
        switch( angle ){
            case 0:{xVel = -3*velInit; yVel = 0*velInit; break;}
            case 1:{xVel = -2*velInit; yVel = -1*velInit; break;}
            case 2:{xVel = -1*velInit; yVel = -2*velInit; break;}
            case 3:{xVel = 0*velInit; yVel = -3*velInit; break;}
            case 4:{xVel = 1*velInit; yVel = -2*velInit; break;}
            case 5:{xVel = 2*velInit; yVel = -1*velInit; break;}
            case 6:{xVel = 3*velInit; yVel = 0*velInit; break;}
            case 7:{xVel = 2*velInit; yVel = 1*velInit; break;}
            case 8:{xVel = 1*velInit; yVel = 2*velInit; break;}
            case 9:{xVel = 0*velInit; yVel = 3*velInit; break;}
            case 10:{xVel = -1*velInit; yVel = 2*velInit; break;}
            case 11:{xVel = -2*velInit; yVel = 1*velInit; break;}
            default:{xVel = 2*velInit; yVel = 1*velInit; angle = 3; break;}

        }
    }
    
    public static void pingBallOnWalls(){
        if(Main.gm.isBallColidating())
        switch( angle ) {
            case 0:{angle = 6; break;}
            case 1:{angle = 11; break;}
            case 2:{angle = 10; break;}
            case 3:{angle = 9; break;}
            case 4:{angle = 8; break;}
            case 5:{angle = 7; break;}
            case 6:{angle = 0; break;}
            case 7:{angle = 5; break;}
            case 8:{angle = 4; break;}
            case 9:{angle = 3; break;}
            case 10:{angle = 2; break;}
            case 11:{angle = 1; break;}
            default:{angle = 3; break;}
        }
        updateVelocity();
    }
    
    public static void pingBallOnSides(){
        if(Main.gm.isBallColidating())
        switch( angle ) {
            case 0:{angle = 6; break;}
            case 1:{angle = 5; break;}
            case 2:{angle = 4; break;}
            case 3:{angle = 9; break;}
            case 4:{angle = 2; break;}
            case 5:{angle = 1; break;}
            case 6:{angle = 0; break;}
            case 7:{angle = 11; break;}
            case 8:{angle = 10; break;}
            case 9:{angle = 3; break;}
            case 10:{angle = 8; break;}
            case 11:{angle = 7; break;}
            default:{angle = 3; break;}
        }
        updateVelocity();
    }
}

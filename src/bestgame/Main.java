/*
 * 
 */
package bestgame;


public class Main {
    static GameWindow gm;
    static Tick tc;
    
    public static void main(String[] args) {
        gm = new GameWindow();
        gm.setVisible(true);
        tc = new Tick();
        tc.start();
    }
    
}

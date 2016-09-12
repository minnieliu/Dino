package dev.tilegame;

/**
 * Created by Minnie on 2016-07-08.
 */
public class Launcher {
    // responsible for starting up our game
    public static void main (String[] args){
       Game game = new Game("Dino", 800, 600);
        game.start();
    }
}

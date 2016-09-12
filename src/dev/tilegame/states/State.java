package dev.tilegame.states;

import dev.tilegame.Game;
import dev.tilegame.Handler.Handler;

import java.awt.*;

/**
 * Created by Minnie on 2016-07-09.
 */
public abstract class State {
    // Gamestate Manager
    private static State currentState = null;
    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    //CLASS
    public Handler handler;
    public State(Handler handler){
        this.handler = handler;
    }

    public abstract void tick();

    // take graphics so that state draws to screen
    public abstract void render(Graphics g);

}

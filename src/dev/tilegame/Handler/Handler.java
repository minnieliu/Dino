package dev.tilegame.Handler;

import dev.tilegame.Game;
import dev.tilegame.Worlds.World;
import dev.tilegame.gfx.GameCamera;
import dev.tilegame.input.KeyManager;
import dev.tilegame.input.MouseManager;
import dev.tilegame.gfx.Sounds;

/**
 * Created by Minnie on 2016-07-11.
 */
public class Handler {
    // provides us with access to move than one thing!!
    private Game game;
    private World world;

    public Handler(Game game){
        this.game = game;
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Sounds getSound(){
        return game.sounds;
    }
}

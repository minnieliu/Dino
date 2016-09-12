package dev.tilegame.states;

import dev.tilegame.Entities.Statics.Tree;
import dev.tilegame.Entities.creatures.Player;
import dev.tilegame.Game;
import dev.tilegame.Handler.Handler;
import dev.tilegame.Worlds.World;
import dev.tilegame.gfx.Assets;
import dev.tilegame.tile.Tile;

import java.awt.*;

/**
 * Created by Minnie on 2016-07-09.
 */
public class GameState extends State {

    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"/Users/minnieliu/Desktop/Dino/src/res/world1.txt");
        handler.setWorld(world);



    }
    public void tick() {
        world.tick();
    }


    public void render(Graphics g)
    {
        world.render(g);

    }
}

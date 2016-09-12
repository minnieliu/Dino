package dev.tilegame.Entities.Statics;

import dev.tilegame.Entities.creatures.Player;
import dev.tilegame.Handler.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.Sounds;
import dev.tilegame.tile.Tile;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Minnie on 2016-07-12.
 */
public class Flower extends StaticEntity {

    public Flower(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        bounds.x = 20;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;
    }

    @Override
    public void die(){
        int score = handler.getWorld().getEntityManager().getPlayer().getScore();
        score += 20;
        handler.getWorld().getEntityManager().getPlayer().setScore(score);

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.flower, (int) (x - handler.getGameCamera().getxOffset()),
                (int)(y - handler.getGameCamera().getyOffset()),width ,height ,null);
       // g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
       //         (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
       //         bounds.width, bounds.height);
    }
}
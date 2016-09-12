package dev.tilegame.gfx;

import dev.tilegame.Entities.Entity;
import dev.tilegame.Game;
import dev.tilegame.Handler.Handler;
import dev.tilegame.tile.Tile;

/**
 * Created by Minnie on 2016-07-10.
 */
public class GameCamera {
    private float xOffset, yOffset;
    private Handler handler;

    public GameCamera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }


    public void centerOnEnity(Entity e){
        // how much tiles need to move
        xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
        checkBlankSpace();
    }


    public void checkBlankSpace(){
        if (xOffset < 0){
            xOffset = 0;
        }
        // how big the world is minus what can be seen, thats the limit to what we can show
        else if (xOffset > handler.getWorld().getWidth()* Tile.TILEWIDTH - handler.getWidth()){
            xOffset = handler.getWorld().getWidth()* Tile.TILEWIDTH -handler.getWidth();
        }
        if (yOffset < 0){
            yOffset = 0;
        }

        else if (yOffset > handler.getWorld().getHeight()* Tile.TILEHEIGHT - handler.getHeight()){
            yOffset = handler.getWorld().getHeight()* Tile.TILEHEIGHT - handler.getHeight();
        }

    }
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

}

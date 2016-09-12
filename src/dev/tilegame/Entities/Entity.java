package dev.tilegame.Entities;

import dev.tilegame.Game;
import dev.tilegame.Handler.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Minnie on 2016-07-10.
 */
public abstract class Entity {


    //float gives us smooth movement
    protected int health;
    public static final int DEFAULT_HEALTH = 10;
    protected boolean active = true;
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;


    public Entity(Handler handler,float x, float y, int width, int height){
        this.handler = handler;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        health = DEFAULT_HEALTH;

        bounds = new Rectangle(0,0, width, height);
    }

    public void hurt(int amt) {
        health = health - amt;
        if (health <= 0) {
            active = false;
            die();
        }
    }

    public boolean isActive(){
        return active;
    }

    public abstract void die();

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for (Entity e: handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int)( x + bounds.x + xOffset),(int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}

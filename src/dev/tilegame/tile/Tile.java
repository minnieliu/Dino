package dev.tilegame.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Minnie on 2016-07-10.
 */
public class Tile {
    //Static stuff here
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile rockTile = new RockTile(1);
    public static Tile waterTile = new WaterTile(2);
    public static Tile dirtTile = new DirtTile(3);

    //Class
    protected BufferedImage texture;
    // for us to idenify the tile, final because we should never have to change it
    protected final int id;
    public static final int TILEWIDTH = 64, TILEHEIGHT=64;


    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}

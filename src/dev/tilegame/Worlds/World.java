package dev.tilegame.Worlds;

import dev.tilegame.Entities.EntityManager;
import dev.tilegame.Entities.Statics.*;
import dev.tilegame.Entities.creatures.Player;
import dev.tilegame.Game;
import dev.tilegame.Handler.Handler;
import dev.tilegame.tile.Tile;
import dev.tilegame.utils.Utils;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.util.Random;

/**
 * Created by Minnie on 2016-07-10.
 */
public class World {
    private Handler handler;
    private int width, height;
    private int Spawnx, Spawny;
    private int[][]tiles;
    private int score;

    //Entities
    private EntityManager entityManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler,80,80));
        entityManager.addEntity(new Tree(handler, 192, 320));
        entityManager.addEntity(new Tree(handler, 192, 384));
        entityManager.addEntity(new Tree(handler, 128, 600));
        entityManager.addEntity(new Tree(handler, 64, 600));

        entityManager.addEntity(new Flower(handler, 320, 640));
        entityManager.addEntity(new Flower(handler, 380, 640));
        entityManager.addEntity(new Flower(handler, 440, 640));
        entityManager.addEntity(new Flower(handler, 500, 640));
        entityManager.addEntity(new Flower(handler, 560, 640));

        entityManager.addEntity(new Star(handler,832,384));
        entityManager.addEntity(new Star(handler,1600, 1216));
        entityManager.addEntity(new Star(handler,2560, 1216));
        entityManager.addEntity(new Star(handler,1500, 1000));
        entityManager.addEntity(new Star(handler,600, 300));

        entityManager.addEntity(new Kitty(handler, 2688, 1344));

        entityManager.addEntity(new Log(handler,2688,128 ));
        entityManager.addEntity(new Log(handler,2688,256 ));

        entityManager.addEntity(new Rock(handler,2000,300 ));

        loadWorld(path);
        entityManager.getPlayer().setX(Spawnx * 64);
        entityManager.getPlayer().setY(Spawny * 64);

        score = 0;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void tick(){
        entityManager.tick();

    }
    public void render(Graphics g){
        int xStart =(int) Math.max(0,handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset()+ handler.getWidth())/Tile.TILEWIDTH +1);
        int yStart = (int) Math.max(0,handler.getGameCamera().getyOffset()/Tile.TILEWIDTH);
        int yEnd = (int) Math.min(width, (handler.getGameCamera().getyOffset()+ handler.getHeight())/Tile.TILEHEIGHT +1);


        for(int y = yStart;y < yEnd; y++){
            for (int x = xStart; x < xEnd; x++){
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        entityManager.render(g);


    }

    public Tile getTile(int x, int y){
        if (x<0 || y<0 || x>= width || y>= height){
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.grassTile;
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        Spawnx = Utils.parseInt(tokens[2]);
        Spawny = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x+y * width )+4 ]);
            }
        }
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

}


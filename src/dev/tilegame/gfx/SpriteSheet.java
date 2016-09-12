package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Minnie on 2016-07-09.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }
    // need to create a method to crop from the sprite sheet

    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }
}

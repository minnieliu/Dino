package dev.tilegame.tile;

import dev.tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by Minnie on 2016-07-10.
 */
public class WaterTile extends Tile {

    public WaterTile(int id) {
        super(Assets.water, id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }
}

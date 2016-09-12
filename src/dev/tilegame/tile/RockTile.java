package dev.tilegame.tile;

import dev.tilegame.gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by Minnie on 2016-07-10.
 */
public class RockTile extends Tile{
    public RockTile( int id) {
        super(Assets.stone, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}

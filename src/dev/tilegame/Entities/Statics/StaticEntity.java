package dev.tilegame.Entities.Statics;

import dev.tilegame.Entities.Entity;
import dev.tilegame.Handler.Handler;

/**
 * Created by Minnie on 2016-07-12.
 */
public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
}

package dev.tilegame.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Minnie on 2016-07-09.
 */
public class ImageLoader {

    public static BufferedImage loadImage(String path){
        try {
            // returns the buffered image of our loaded image
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}

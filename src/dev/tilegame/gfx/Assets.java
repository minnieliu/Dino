package dev.tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by Minnie on 2016-07-09.
 */
public class Assets {
    // an asset is any image, music, etc in out game

    private static final int width = 64, height = 64;

    public static BufferedImage grass,water,stone,dirt,tree,kitty,rock,star,log,flower;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_left;
    public static BufferedImage[] button_start;



    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
        SpriteSheet entitySheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheetentities.png"));
        SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheetmenu.png"));
        player_down = new BufferedImage[2];
        player_down[0] = sheet.crop(width,0,width,height);
        player_down[1] = sheet.crop(width,height,width,height);

        player_up = new BufferedImage[2];
        player_up[0] = sheet.crop(width*2,0,width,height);
        player_up[1] = sheet.crop(0,height,width,height);

        player_left = new BufferedImage[2];
        player_left[0] = sheet.crop(0,height*2+1,width,height);
        player_left[1] = sheet.crop(width,height*2+1,width,height);

        player_right = new BufferedImage[2];
        player_right[0] = sheet.crop(0,0,width,height);
        player_right[1] = sheet.crop(width*2,height,width,height);


        grass = sheet.crop(0,height*3+3, width, height);
        stone = sheet.crop(width+1,height*3+3,width,height);
        dirt = sheet.crop(width*2+2,height*2+2,width,height);
        water = sheet.crop(width*2+2,height*3+3,width,height);

        //Entities
        tree = entitySheet.crop(0,0,width,height);
        rock = entitySheet.crop(0,height+1,width,height);
        flower = entitySheet.crop(0,(height+1)*2,width,height);
        star = entitySheet.crop(width+1, 0, width, height);
        kitty = entitySheet.crop(width+1,height+1,width,height);
        log = entitySheet.crop(width+1,(height+1)*2,width,height);

        //Menu Buttons
        button_start = new BufferedImage[2];
        button_start[0] = menuSheet.crop(0,0,100,30);
        button_start[1]= menuSheet.crop(0,30,100,30);



    }
}

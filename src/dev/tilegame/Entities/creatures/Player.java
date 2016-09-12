package dev.tilegame.Entities.creatures;

import dev.tilegame.Entities.Entity;
import dev.tilegame.Game;
import dev.tilegame.Handler.Handler;
import dev.tilegame.gfx.Animation;
import dev.tilegame.gfx.Assets;
import dev.tilegame.states.State;
import sun.tools.jar.Main;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Minnie on 2016-07-10.
 */
public class Player extends Creature {

    private Animation animDown, animUp, animLeft, animRight;
    int score, stepCount;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 10;
        bounds.y = 10;
        bounds.width = 48;
        bounds.height = 48;

        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);

        score = 0;
        stepCount = 0;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    @Override
    public void die() {
        System.out.println("You lose!");
    }

    @Override
    public void tick() {
        //Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        //Movements
        getInput();
        move();
        handler.getGameCamera().centerOnEnity(this);
        checkAttacks();
    }

    public int getStepCount(){
        return stepCount;
    }

    public void setStepCount(int n){
        stepCount = n;
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;


        if (handler.getKeyManager().up) {
            yMove = -speed;
            stepCount++;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
            stepCount++;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
            stepCount++;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
            stepCount++;
        }
    }

    @Override
    public void render(Graphics g) {
        // x- xoffset ensures that we are centered on the
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        String s = Integer.toString(score);
        Font font = new Font("Cooper Black", Font.BOLD, 32);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Score: " + s, 600+2, 100+2);
        g.setColor(new Color(198,226,255));
        g.drawString("Score: " + s, 600, 100);

        if (score == 520){
            State.setState(handler.getGame().endState);
        }
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
        //        (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
        //        bounds.width, bounds.height);
    }

    public BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else {
            return animDown.getCurrentFrame();
        }
    }

    //Attack

    private void checkAttacks() {
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar0 = new Rectangle();
        Rectangle ar1 = new Rectangle();
        Rectangle ar2 = new Rectangle();
        Rectangle ar3 = new Rectangle();

        int arSize = 20;
        ar0.width = arSize;
        ar0.height = arSize;
        ar1.width = arSize;
        ar1.height = arSize;
        ar2.width = arSize;
        ar2.height = arSize;
        ar3.width = arSize;
        ar3.height = arSize;


       if (handler.getKeyManager().attack) {
           ar0.x = cb.x + cb.width / 2 - arSize / 2;
           ar0.y = cb.y - arSize;
           // }
           //  else
           // if (handler.getKeyManager().aDown){
           ar1.x = cb.x + cb.width / 2 - arSize / 2;
           ar1.y = cb.y + cb.height;
           //     }
           // else if (handler.getKeyManager().aLeft){
           ar2.x = cb.x - arSize;
           ar2.y = cb.y + cb.height / 2 - arSize / 2;
           //     }
           // else if (handler.getKeyManager().aRight){
           ar3.x = cb.x + cb.width;
           ar3.y = cb.y + cb.height / 2 - arSize / 2;
       }
        else {
            return;
        }
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if (e.getCollisionBounds(0,0).intersects(ar0) ||
                    e.getCollisionBounds(0,0).intersects(ar1) ||
                    e.getCollisionBounds(0,0).intersects(ar2) ||
                    e.getCollisionBounds(0,0).intersects(ar3)){
                e.hurt(1);
                return;
            }
        }
        try {
            handler.getGame().getSounds().playSound("C:\\Users\\Minnie\\Desktop\\Technical Projects\\GameProject\\src\\res\\Sound\\scoresound.wav");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

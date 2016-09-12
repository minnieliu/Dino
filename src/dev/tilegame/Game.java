package dev.tilegame;

import dev.tilegame.Handler.Handler;
import dev.tilegame.gfx.Assets;
import dev.tilegame.gfx.GameCamera;
import dev.tilegame.gfx.Sounds;
import dev.tilegame.input.KeyManager;
import dev.tilegame.input.MouseManager;
import dev.tilegame.states.*;


import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

/**
 * Created by Minnie on 2016-07-08.
 */
public class Game implements Runnable {
    // holds the base code of our game
    private Display display;
    public String title;
    private int width, height;
    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

   // private BufferedImage test;
   // private SpriteSheet sheet;
    public State gameState;
    public State endState;
    public State menuState;
    public State settingState;
    private KeyManager keyManager;
    private MouseManager mouseManager;
    public Sounds sounds;


    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

    }

    private void init(){

        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().addMouseMotionListener((MouseMotionListener) mouseManager);
        display.getCanvas().addMouseListener((MouseListener) mouseManager);
        display.getFrame().addMouseMotionListener((MouseMotionListener) mouseManager);
        display.getFrame().addMouseListener((MouseListener) mouseManager);
        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);


        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        settingState = new SettingState(handler);
        endState = new EndState(handler);
        sounds = new Sounds();

        State.setState(menuState);
    }


    private void tick() {
        keyManager.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render(){
        // render means drawing things to screen
        // buffer strategy is a way computers draw things to the screen
        // buffer can be thought of as a hidden screen behind your screen to prevent flickering
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3); // 3 buffers is max we should allow
            return;

        }
        g = bs.getDrawGraphics();
        // Clear the Screen
        g.clearRect(0, 0, width, height);
        // Draw here!
        // g.drawImage(sheet.crop(0,64,32,32),5,5,null);
        if (State.getState() != null) {
            State.getState().render(g);
        }
        //End Drawing!
        bs.show();
        g.dispose();
    }

    // must have when we have runnable
    public void run() {
        // where majority of game code goes
        // runs when start() thread is run
        init();
        // how many times tick and render runs each second
        int fps = 60;
        // one billion nanoseconds in one second
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        // returns the current time of computer in nanoseconds
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            // how much time we have before we have to call tick and render again
            delta += (now - lastTime) / timePerTick;
            timer += (now-lastTime);
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000){
             //   System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    public Sounds getSounds(){return sounds;}

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }


    public synchronized void start(){
        if (running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized  void stop(){
        if (!running){
            return; // safety case
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

package dev.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

/**
 * Created by Minnie on 2016-07-10.
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right;
    public boolean aUp, aDown, aLeft, aRight, attack;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];

        attack = keys[KeyEvent.VK_SPACE];
       // aUp = keys[KeyEvent.VK_W];
       // aDown = keys[KeyEvent.VK_S];
       // aLeft = keys[KeyEvent.VK_A];
       // aRight = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    // called whenever user presses key
        keys[e.getKeyCode()] = true;
       // System.out.println("Pressed!");

    }

    @Override
    public void keyReleased(KeyEvent e) {
    // called whenever user releases key
        keys[e.getKeyCode()] = false;
    }
}

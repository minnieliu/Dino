package dev.tilegame.gfx;

import  sun.audio.*;    //import the sun.audio package

import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import  java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Minnie on 2016-07-15.
 */
public class Sounds {

    public static void playSound(String fileName) throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException{
        File url = new File(fileName);
        Clip clip = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.
                getAudioInputStream( url );
        clip.open(ais);
        clip.start();
    }
}

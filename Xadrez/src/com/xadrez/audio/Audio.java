/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.audio;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;


public class Audio {
        public static synchronized void playSound(final String url,boolean loop) {
    new Thread(new Runnable() { // the wrapper thread is unnecessary, unless it blocks on the Clip finishing, see comments
      public void run()
      {
            try {
                //InputStream in = new FileInputStream(url);
                //AudioStream as = new AudioStream(in);
                //AudioPlayer.player.start(as);

              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(Audio.class.getResourceAsStream(url));
              clip.open(inputStream);
              if(loop){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
              }else{
              clip.loop(0);
              }              
            }
            catch (Exception e) {
              System.err.println(e.getMessage());
            }
      }
    }).start();
  }
       
 
}

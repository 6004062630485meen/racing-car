/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.applet.*;
import java.net.*;

/**
 *
 * @author wasinee
 */
public class Sound {
   private AudioClip sound;

    Sound(int i) {
        try {
         if(i==0){
            sound = Applet.newAudioClip(new URL("file:\\Users\\wasinee\\Desktop\\RacingCar\\src\\sound\\opengame.wav"));
            sound.loop();
         }   
         if(i==1){
            sound = Applet.newAudioClip(new URL("file:\\Users\\wasinee\\Desktop\\RacingCar\\src\\sound\\motor_car.wav"));
            sound.loop();
         }
         if(i==2){
            sound = Applet.newAudioClip(new URL("file:\\Users\\wasinee\\Desktop\\RacingCar\\src\\sound\\brake.wav"));
            sound.loop();
         }
            
         } catch (MalformedURLException e) {
           e.printStackTrace();
        }
        sound.loop();
    }

   
   public void stopSound(){
      sound.stop();
   }
}

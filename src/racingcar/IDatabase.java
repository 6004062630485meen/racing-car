/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;


import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.*;
import java.io.*;



/**
 *
 * @author wasinee
 */
public class IDatabase {
    static AudioStream brake, click, Crash, motor, turn, open;
    IDatabase(int a){
        if(a == 0){
            try {
                InputStream in = new FileInputStream("C:\\Users\\wasinee\\Desktop\\RacingCar\\src\\sound\\opengame.wav");
                open = new AudioStream(in);
                AudioPlayer.player.start(open);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(a == 1){
            try {
                InputStream in = new FileInputStream("C:\\Users\\wasinee\\Desktop\\RacingCar\\src\\sound\\motor2.wav");
                motor = new AudioStream(in);
                AudioPlayer.player.start(motor);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(a == 2){
            try {
                InputStream in = new FileInputStream("C:\\Users\\wasinee\\Desktop\\RacingCar\\src\\sound\\brake.wav");
                brake = new AudioStream(in);
                AudioPlayer.player.start(brake);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(a == 3){
            try {
                InputStream in = new FileInputStream("C:\\Users\\wasinee\\Desktop\\RacingCar\\src\\sound\\turnCar.wav");
                turn = new AudioStream(in);
                AudioPlayer.player.start(turn);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(a == 4){
            try {
                InputStream in = new FileInputStream("C:\\Users\\wasinee\\Desktop\\RacingCar\\src\\sound\\crash.wav");
                Crash = new AudioStream(in);
                AudioPlayer.player.start(Crash);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(a == 5){
            try {
                InputStream in = new FileInputStream("C:\\Users\\wasinee\\Desktop\\RacingCar\\src\\sound\\wink.wav");
                click = new AudioStream(in);
                AudioPlayer.player.start(click);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void stopMusic() {
        AudioPlayer.player.stop(motor);
        //AudioPlayer.player.stop(click);
    }
    public static void stopMusicOpen() {
        AudioPlayer.player.stop(open);
    }
}

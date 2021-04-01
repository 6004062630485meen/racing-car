/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import sun.audio.AudioStream;
import static racingcar.IDatabase.stopMusicOpen;





public class Display extends Applet implements Runnable{
    public static BufferedImage full, fullImage, fullImageB, road, grass, footPath, black, finish;
    public static BufferedImage carP, carE, subImage1, subImage2, crash, fuel, effect;
    private Thread thread;
    private BufferStrategy buffer;
    private Graphics g;
    private FrameGame fg;
    private gameManager manager;
    private String title;
    private int width;
    private int height;
    
    private Menu menu;
    public static enum STATE{
      MENU,
      GAME
    };
    public static STATE State = STATE.MENU;
    
    
    

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void init() {
        new IDatabase(0);
        fg = new FrameGame(title, width, height);
        //menu = new Menu();
        //this.addMouseListener(new MouseInput());
        manager = new gameManager();
        manager.init();
        
        //open image.
        openImage();
    }
    
    public synchronized void start(){
        if(thread==null){
            thread = new Thread(this);
            thread.start();
        }
    }
    
    public synchronized void stop(){
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void render(){
        
        buffer = fg.canvas.getBufferStrategy();
        if(buffer==null){
            fg.canvas.createBufferStrategy(3);
            return;
        }
        g = buffer.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        
        if(State == STATE.GAME){
            //draw
            manager.paintComponent(g);
        }
        else if(State == STATE.MENU){
            //menu.init();
            //menu.render(g);
            Display.State = Display.STATE.GAME;
            
            
        }
        
        //draw end
        buffer.show();
        g.dispose();
        
    }
    
    public void tick() {
        if(State == STATE.GAME){
            manager.tick();
            stopMusicOpen();
        }
    }

    // TODO overwrite start(), stop() and destroy() method.
    @Override
    public void run() {
        init();
        
        int fps = 50;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long current = System.nanoTime();
        
        while(true){
            delta = delta + (System.nanoTime()-current)/timePerTick;
            current = System.nanoTime();
            if(delta>=1){
                tick();
                render();
                delta--;
            }
            
            
        }
        
    }
    
    
    public static BufferedImage imageLoader(String path){
        
        try {
            return ImageIO.read(Display.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Image not found");
            System.exit(1);
        }
        
        return null;
    }

    public void openImage() {
        full = imageLoader("/full.png");
        fullImage = imageLoader("/road.jpg");
        fullImageB = imageLoader("/black.png");
        carP = imageLoader("/car1-2.png");
        carE = imageLoader("/carE3.png");
        fuel = imageLoader("/Fuel.png");
        effect = imageLoader("/effect.png");
        crash = imageLoader("/blast.png");
        finish = imageLoader("/finish_line.png");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import static racingcar.IDatabase.stopMusic;



public class Motor extends Applet implements KeyListener {
    
    private int x,y;
    private int ofset;
    private double speed;
    
    //direction.
    private boolean left, right, up, down;
    
    private int health;
    private int blast = 0;
    private int item = 0;
    private int n_health = 0;
    private int score = 0;
    private int highScore = 0;
    private int fuel = 100;
    private int n_fuel = 0;
    
    //saving.
    private String saveDataPath;
    private String fileName = "HighScore.txt";
    
    public Motor(){
        try{
            saveDataPath = Motor.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            saveDataPath = System.getProperty("user.home") + "\\Desktop" + "\\RacingCar" + "\\src" + "\\racingcar";

        }
        catch(Exception e){
            e.printStackTrace();
        }

        x = FrameGame.width/2;
        y = Tile.tileHeight*7700;
        ofset = 0;
        speed = 0.3f;
        health = 3;
        
        loadHighScore();
    }
    
    public void createSaveData(){
        try{
            File file = new File(saveDataPath, fileName);
            
            FileWriter output = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write("" + 0);
            //create fastest time.
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loadHighScore(){
        try{
            File f = new File(saveDataPath, fileName);
            if(!f.isFile()){
                createSaveData();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            highScore = Integer.parseInt(reader.readLine());
            //read fastest time.
            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setHighScore(){
        FileWriter output = null;
        try{
            File f = new File(saveDataPath, fileName);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write("" + highScore);
            writer.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void init() {
        FrameGame.frame.addKeyListener(this);

    }
    
    public int getofset(){
        return ofset;
    }
    
    public int getY(){
        return y;
    }
    
    public double getSpeed(){
        return speed;
    }
    
    public int getX(){
        return x;
    }
    
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public int getHealth(){
        return health;
    }
    public int getFuel(){
        return fuel;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public void tick(){
        //System.out.println(y);
        if(health > 0){
            ofset = y - (FrameGame.height-130);
            if(right){
                if(x <= 727 ){
                    x += 1;
                }
                //new IDatabase(3);
            }
            if(left){
                if(x >= 386){
                    x -= 1;
                }
                //new IDatabase(3);
            }
            if(up){
                if(y > 700){
                    speed += 0.03f;
                    if(speed >= 7){
                        speed = 7;
                    }
                    //new IDatabase(1);
                }
            }
            
            if(down){
                speed -= 0.030f;
                if(speed <=0){
                    speed = 0;
                }
                new IDatabase(2);
            }
            /*
            if(y > 700){
                y -= speed;

            }
            */
            if(y > 700){
                y -= speed;
                speed = -2;
                new IDatabase(1);
            }
            
        }
        
        
    }
    
    public void drawBoard(Graphics g){
        //set Score.
        if(health>0){
            n_health += 1;
            if(n_health == 30){
                score += 1;
                if(score > highScore){
                    highScore = score;
                    setHighScore();
                }
                n_health = 0;
            }
            
            //set Fuel.
            if(fuel>0){
                n_fuel += 1;
                if(n_fuel == 25){
                    fuel -= 1;
                    n_fuel = 0;
                }
            }
            
        }
        //set Font.
        g.setFont(new Font("arial", Font.BOLD, 27));
        
        //draw Score.
        g.setColor(Color.WHITE);
        g.drawString("SCORE:  ", 10, 240);
        g.setColor(Color.ORANGE);
        g.drawString(""+score, 130, 240);
        
        //draw High Score.
        g.setColor(Color.PINK);
        g.drawString("HIGH SCORE", 9, 50);
        g.drawLine(5, 63, 188, 63);
        g.drawString("        "+highScore, 10, 95);
        
        //draw Health.
        g.setColor(Color.WHITE);
        g.drawString("HEALTH:  ", 1015, 50);
        g.setColor(Color.red);
        g.drawString(""+health, 1150, 50);

        //draw Fuel.
        g.setColor(Color.red);
        g.drawRect(1012, 512, 120, 50);
        g.setColor(Color.WHITE);
        g.drawString("FUEL", 1020, 550);
        g.setColor(Color.CYAN);
        if(fuel == 100){
            g.drawString("  "+fuel, 1065, 600);
        }
        else if(fuel >= 10){
            g.drawString("  0"+fuel, 1065, 600);
        }
        else if(fuel >= 0){
            g.drawString("  00"+fuel, 1065, 600);
        }
        
    }
    
    public void GameOver(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("arial", Font.BOLD, 60));
        g.drawString("Game Over", (FrameGame.width/3)+35, FrameGame.height/2);
    }
    
    public void render(Graphics g){
        if(blast == 1){
            g.drawImage(Display.crash,x-200, y-ofset-200, 450, 450, null);
            new IDatabase(4);
            blast = 0;
        }
        if(item == 1){
            g.drawImage(Display.effect,x-170, y-ofset-200, 450, 450, null);
            new IDatabase(5);
            fuel += 40;
            if(fuel > 100){
                fuel = 100;
            }
            item = 0;
        }
        if(health > 0 && fuel > 0){
            g.drawImage(Display.carP,x, y-ofset-50, 70, 130, null);
        }
        else{
            stopMusic();
            GameOver(g);
        }
        
        
        //draw Board.
        drawBoard(g);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int source = e.getKeyCode();
        if(source == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if(source == KeyEvent.VK_LEFT) {
            left = true;
        }
        if(source == KeyEvent.VK_DOWN) {
            down = true;
        }
        if(source == KeyEvent.VK_UP) {
            up = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int source = e.getKeyCode();
        if(source == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if(source == KeyEvent.VK_LEFT) {
            left = false;
        }
        if(source == KeyEvent.VK_DOWN) {
            down = false;
        }
        if(source == KeyEvent.VK_UP) {
            up = false;
        }
    }

    void setHealth(int health) {
        this.health = health;
    }

    void Blast(int i) {
        this.blast = i;
    }
    
    void Item(int i){
        this.item = i;
    }

}

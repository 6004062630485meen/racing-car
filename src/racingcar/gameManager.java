
package racingcar;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;
import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;
import static racingcar.Display.subImage1;


public class gameManager{

    private world world;
    private Motor motor;
    private long time = System.nanoTime();
    private long delay;
    private int health;
    private ArrayList<EnemyMotor> eMotor;
    private ArrayList<FuelMotor> eMotorFuel;
    
    public gameManager(){
        motor = new Motor();
        world = new world(motor);
        eMotor = new ArrayList<EnemyMotor>();
        eMotorFuel = new ArrayList<FuelMotor>();
        
        delay = 1000;  //2000
        health = 3;
    }
    
    public void init() {
        motor.init();
        
    }

    public void tick(){
        //motor.
        motor.tick();
        
        Random rand = new Random();
        int randX = rand.nextInt(700);
        int randY = FrameGame.height-700;

        while((randX < 400)){
            randX = rand.nextInt(700);
        }
                
        //r1.x = player motor x;
        //r1.y = player motor y;
        
        //r2.x = enemyMotor x;
        //r2.y = enemyMotor y;
        
        //Position player and enemy.
        for(int i=0; i<eMotor.size(); i++){
            //player.
            int px = motor.getX();
            int py = motor.getY()-50;
            
            //enemy motor
            int ex = eMotor.get(i).getX();
            int ey = eMotor.get(i).getY();
            /*if(r1.x < r2.x + width &&
                 r1.x + width > r2.x &&
                 r1.y < r2.y + width &&
                 r1.y + width > r2.y &&
             */

            if(Math.abs(py-ey) <= 210){
                if(Math.abs(px-ex) <= 80){
                    if(px < ex){
                        
                        if((px-=5) > 386 && (px-=5) > ex-10){
                            motor.setX(px-=5);
                        }
                        else{
                            motor.setX(px+=5);
                        }
                    }
                    else if (px >= ex ){
                        if((px+=5) < 727 && (px+=5) < ex+10){
                            motor.setX(px+=5);
                        }
                        else{
                            motor.setX(px-=5);
                        }      
                    }
                }
            }
            /*
            if(Math.abs(px-ex) <= 80){
                if(px < ex){
                    if((px-=3) >= 386){
                        motor.setX(px-=3);
                    }
                    else{
                        motor.setX(px+=3);
                    }
                }
                else if (px >= ex){
                    if((px+=3) <= 727){
                        motor.setX(px+=3);
                    }
                    else{
                        motor.setX(px-=3);
                    }  
                }
            }
            */
            /*
            if(px < ex + 70 && px + 70 > ex &&
               py < ey + 130 && py + 100 > ey ){
                motor.Blast(1);
                //collided.
                eMotor.remove(i);
                i--;
                
                health--;
                if(health < 0){
                    health = 0;
                }

                motor.setSpeed(0);
                motor.setHealth(health);
            }
            */
            
            
        }
        
        //Position player and fuel.
        for(int i=0; i<eMotorFuel.size(); i++){
            //player.
            int px = motor.getX();
            int py = motor.getY()-50;
            
            //fuel motor
            int ex = eMotorFuel.get(i).getX();
            int ey = eMotorFuel.get(i).getY();

            if(Math.abs(py-ey) <= 140){
                if(Math.abs(px-ex) <= 400){
                    if(px <= ex && px >= ex){
                        motor.setX(px);
                    }
                    else if(px < ex){
                        if((px+=5) <= 727 )
                            motor.setX(px+=5);
                    }
                    else{
                        if((px-=5) >= 386 )
                            motor.setX(px-=5);
                    }
                }
            }
            /*
            if(Math.abs(px-ex) <= 200){
                if(px < ex){
                    if((px+=2) <= 727)
                        motor.setX(px+=2);
                    }
                else{
                    if((px-=2) >= 386)
                        motor.setX(px-=2);
                    }
            }
            */
            if(px < ex + 80 && px + 55 > ex &&
               py < ey + 100 && py + 90 > ey ){
                motor.Item(1);
                //collided.
                eMotorFuel.remove(i);
                i--;
            }
        }
        
        
        long elapsed = (System.nanoTime() - time)/1000000;
        if(elapsed > delay){
            if(Math.abs(motor.getSpeed()) >= -2000000000 && motor.getY() > 900 && motor.getHealth() > 0 && motor.getFuel() > 0){
                if( (motor.getFuel() <= 75 && motor.getFuel() > 73) ||
                    (motor.getFuel() <= 55 && motor.getFuel() > 52) ||
                    (motor.getFuel() <= 25 && motor.getFuel() > 22) ||
                    (motor.getFuel() <= 7 && motor.getFuel() > 4) ){
                    eMotorFuel.add(new FuelMotor(motor,randX,(-randY) + motor.getofset()));
                }
                else{
                    eMotor.add(new EnemyMotor(motor,randX,(-randY) + motor.getofset()));
                }
            }
            time = System.nanoTime();
        }
        //enemy motor.
        for(int i=0; i<eMotor.size(); i++){
            eMotor.get(i).tick();
        }
        //fuel motor.
        for(int i=0; i<eMotorFuel.size(); i++){
            eMotorFuel.get(i).tick();
        }
        
    }
    
    public void paintComponent(Graphics g) {
        crop();
        
        world.render(g);
        motor.render(g);
        
        //enemy motor.
        for(int i=0; i<eMotor.size(); i++){
            eMotor.get(i).render(g);
        }
        //fuel motor.
        for(int i=0; i<eMotorFuel.size(); i++){
            eMotorFuel.get(i).render(g);
        }
    }
    
    public static void crop(){
        //Display.black = Display.fullImageB.getSubimage(0, 0, 50, 50);
        Display.road = Display.full.getSubimage(255, 0, 125, 115);
        Display.grass = Display.fullImage.getSubimage(300, 0, 200, 115);
        Display.footPath = Display.fullImage.getSubimage(580, 0, 200, 115);
        
    }


}

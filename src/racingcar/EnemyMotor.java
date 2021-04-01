/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.awt.Graphics;

/**
 *
 * @author wasinee
 */
public class EnemyMotor {
    private int x, y;
    private Motor motor;
    public EnemyMotor(Motor motor, int x, int y){
        this.motor = motor;
        this.x = x;
        this.y = y;
    }
    public void tick(){
        y += 1;
    }
    public void render(Graphics g){
        g.drawImage(Display.carE, x, y-motor.getofset(), 70, 130, null);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

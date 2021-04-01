/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {
    Game g;
    public KeyInput(Game p) {
        this.g = g;
    } 
    
    @Override
    public void keyPressed(KeyEvent e) {
        g.keyPressed(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        g.keyReleased(e);
    }
}

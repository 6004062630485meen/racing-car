/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;


public class FrameGame {
    private String title;
    public static JFrame frame;
    public static Canvas canvas;
    public static int width;
    public static int height;
    
    public FrameGame(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        createFrameGame();
        
    }
    
    public void createFrameGame(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setBackground(Color.black);
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    
    
}

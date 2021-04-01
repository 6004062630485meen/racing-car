/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author wasinee
 */
public class Menu {//extends Applet implements ActionListener{
/*
    Button play, quit;
    Label label;
    
    public void init() {
        play = new Button("Play");
        quit = new Button("Quit");
        label = new Label("RACING CAR GAME");
        play.setBackground(Color.WHITE);
        play.setBounds(525, 250, 150, 80);
        label.setBounds(350, 150, 400, 50);
        quit.setBackground(Color.WHITE);
        quit.setBounds(525, 400, 150, 80);
        add(label);
        add(play);
        add(quit);
        
        play.addActionListener(this);
        quit.addActionListener(this);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ans = e.getActionCommand();
        if(ans.equals("Play")){
            Display.State = Display.STATE.GAME;
        }
        else if(ans.equals("Quit")){
           System.exit(1);
        }
        
        //repaint();
    }

    public void paint(Graphics g){
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.WHITE);
        g.drawString("RACING CAR GAME", 350, 150);
        
    }
*/
    public Rectangle playButton = new Rectangle(525, 250, 150, 80);
    public Rectangle quitButton = new Rectangle(525, 400, 150, 80);
    
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.WHITE);
        g.drawString("RACING CAR GAME", 350, 150);
        
        
        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.drawString("Play", playButton.x + 25, playButton.y + 50);
        g2d.draw(playButton);
        g.drawString("Quit", quitButton.x + 25, quitButton.y + 50);
        g2d.draw(quitButton);
    }

}

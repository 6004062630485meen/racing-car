
package racingcar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {

    private int x;
    private int y;
    private int speedx = 0;
    private int speedy = 0;
    private int WIDTH = 60;
    private int HEIGHT = 120;
    Image img;
    public Game(int i, int i0) {
        this.x  = i;
        this.y = i0;
        ImageIcon myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("carE1.png")));
        img = myimage.getImage();
    }
    
    public void update() {
        x += speedx;
        y += speedy;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.red);
        g2d.fillRect(x, y, 50, 50);
        g2d.drawImage(img, x-210, y-50, WIDTH, HEIGHT, this);
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT){
            speedx = 5;
        }
        if(key==KeyEvent.VK_LEFT){
            speedx = -5;
        }
        if(key==KeyEvent.VK_DOWN){
            speedx = 5;
        }
        if(key==KeyEvent.VK_UP){
            speedx = -5;
        }
        
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT){
            speedx = 0;
        }
        if(key==KeyEvent.VK_LEFT){
            speedx = 0;
        }
        if(key==KeyEvent.VK_DOWN){
            speedx = 0;
        }
        if(key==KeyEvent.VK_UP){
            speedx = 0;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author wasinee
 */
public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        /*
        public Rectangle playButton = new Rectangle(525, 250, 150, 80);
        public Rectangle quitButton = new Rectangle(525, 400, 150, 80);
        */
        //Play Button.
        if(mx >= 525 && mx <= 675){
            if(my >= 250 && my <= 330){
                //Pressed Play Button.
                Display.State = Display.STATE.GAME;
            }
        }
        //Quit Button.
        if(mx >= 525 && mx <= 675){
            if(my >= 400 && my <= 480){
                //Pressed Quit Button.
                System.exit(1);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

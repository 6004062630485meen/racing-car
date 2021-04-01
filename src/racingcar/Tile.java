/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile{
    public static Tile[] tiles = new Tile[24];
    public static Tile blackTile = new blackTile(0);
    public static Tile roadTile = new roadTile(1);
    public static Tile grassTile = new grassTile(2);                            //ถนน
    public static Tile footPathTile = new footPathTile(3);                      //เส้นสีเหลือง
    
    public BufferedImage texture;
    public static final int tileWidht = 32, tileHeight = 32;
    
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        tiles[id] = this;
    }
    
    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, null);
    }
    
}

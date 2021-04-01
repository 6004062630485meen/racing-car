/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racingcar;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author wasinee
 */
public final class world {
    
    private Motor motor;
    private Tile t;
    int widthT = 33;
    int heightT =  2100000;
    int[][] tile = new int[widthT][heightT];
    static int[] value = {0,0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,3,2,2,2,2,2,2,1,1,1,0,0,0,0,0};

    world(Motor motor) {
        this.motor = motor;
    }


    
    public void render(Graphics g){
        int start = Math.max(0, (motor.getofset())/Tile.tileHeight);
        int end = Math.min(heightT, (motor.getofset() + FrameGame.height)/Tile.tileHeight);
        for(int i=0; i<widthT; i++){
            for(int j=start; j<end; j++){
                tile[i][j] = value[i];
                if(tile[i][j]==0){
                    t = Tile.tiles[0];
                }
                else if(tile[i][j]==1){
                    t = Tile.tiles[1];
                }
                else if(tile[i][j]==2){
                    t = Tile.tiles[2];
                }
                else if(tile[i][j]==3){
                    t = Tile.tiles[3];
                }
                
                //Tile t = Tile.tiles[0];
                t.render(g, i*Tile.tileWidht, (j*Tile.tileHeight) - motor.getofset());
            }
        }
    }
}

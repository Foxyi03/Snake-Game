/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.body;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Foxyi03
 */
public class Head { 
    private int x = 300;
    private int y = 300;
    private Point point;
    private int width ;
    private int height;

    public Head(Point sPoint) {
        this.point = sPoint;
    }
    
    //main Head
    private void draw(Graphics g){
       //TODO
    }
}

//the head will be drawn here
//head is green with eyes looking forward
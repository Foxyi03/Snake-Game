/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Foxyi03
 */
public class snakeBody extends Snake{

    public snakeBody() {
    }

   

    @Override
    public void draw(Graphics g){
        int Size = getSize();
        int[] x = getX();
        int[] y = getY();
        
        //base
        g.setColor(Color.GREEN);
        g.fillOval( x - Size, y - Size, Size * 2, Size * 2);
    }

    
    
    

    
    
}

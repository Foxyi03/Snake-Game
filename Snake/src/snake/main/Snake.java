/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.main;

import java.awt.Point;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 *
 * @author Foxyi03
 */
public class Snake { 
    private final int Width = 300; //width of the drawPanel
    private final int Height = 300; //height of the drawPanel
    private final int Size = 10; //sizes of the body and foods
    private final int maxSize = 900; //max numbers of things on the DrawPanel
    private final int randomPosition = 30; //calculation of the position of an apple
    
    private final int x[] = new int[maxSize]; //learned this from the internet, stores the x coordinates of all the bodyparts of the snake
    private final int y[] = new int[maxSize];//stores the y coordinates of all the bodyparts of the snake

    private boolean goLeft = false;
    private boolean goRight = false;
    private boolean goUp = false;
    private boolean goDown = false;
    private boolean inField = false;

    private Image body;
    private Image head;

    private void loadImages(){
        ImageIcon iib = new ImageIcon("src/lib/snakeBody.png");
            body = iib.getImage();
        
        ImageIcon iih = new ImageIcon("src/lib/snakeHead.png");
            head = iih.getImage();
    }
    

    
    private void draw(Graphics g){
        if
    }









    public int getWidth() {
        return Width;
    }
    public int getHeight() {
        return Height;
    }
    public int getSize() {
        return Size;
    }
    public int getMaxSize() {
        return maxSize;
    }
    public int getRandomPosition() {
        return randomPosition;
    }
    public int[] getY() {
        return y;
    }
    public boolean isGoLeft() {
        return goLeft;
    }
    public void setGoLeft(boolean goLeft) {
        this.goLeft = goLeft;
    }
    public boolean isGoRight() {
        return goRight;
    }
    public void setGoRight(boolean goRight) {
        this.goRight = goRight;
    }
    public boolean isGoUp() {
        return goUp;
    }
    public void setGoUp(boolean goUp) {
        this.goUp = goUp;
    }
    public boolean isGoDown() {
        return goDown;
    }
    public void setGoDown(boolean goDown) {
        this.goDown = goDown;
    }
    public boolean isInField() {
        return inField;
    }
    public void setInField(boolean inField) {
        this.inField = inField;
    }
    
    
    
}
//the snake will be build here, head + body
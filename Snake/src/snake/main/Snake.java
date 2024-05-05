/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.main;

import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;

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
    private Image apple;
    private Timer timer;

    private int parts;
    private int appleX;
    private int appleY;


    private void loadImages(){
        ImageIcon iib = new ImageIcon("src/lib/snakeBody.png");
            body = iib.getImage();
        
        ImageIcon iih = new ImageIcon("src/lib/snakeHead.png");
            head = iih.getImage();
        ImageIcon iia = new ImageIcon("src/lib/apple.png");
            apple = iia.getImage();
    }
    private void initField(){
        parts = 3;

        for(int i = 0; i < parts; i++){
            x[i] = 50 - i * 10;
            y[i] = 50;
        }
        appleLoc();

        
    }
    private void appleLoc(){
        int r = (int) (Math.random() * randomPosition);
        appleX = (r * Size);
        appleY = (r * Size);

    }
    
    private void draw(Graphics g){
        if(inField){
            g.drawImage(apple, appleX, appleY, this);

            for(int i = 0; i < parts; i++){
                if(i ==0){
                    g.drawImage(head, x[i], y[i], this);
                } else {
                    g.drawImage(body, x[i], y[i], this);
                }
            }
             Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }       

    }

    private void gameOver(Graphics g){
        String msg = "Game Over";
        g.setColor(Color.white);
        g.drawString(msg, Width / 2, Height / 2);
    }
    private void checkApple(){
        if((x[0]== appleX) && (y[0]== appleY)){
            parts ++;
            appleLoc();
        }
    }
    private void actionPerformed(ActionEvent e){
        if(inField){
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }
    
    private void move() {

        for (int z = parts; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (goLeft) {
            x[0] -= Size;
        }

        if (goRight) {
            x[0] += Size;
        }

        if (goUp) {
            y[0] -= Size;
        }

        if (goDown) {
            y[0] += Size;
        }
    }

    private void checkCollision() {

        for (int z = parts; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inField = false;
            }
        }

        if (y[0] >= Height) {
            inField = false;
        }

        if (y[0] < 0) {
            inField = false;
        }

        if (x[0] >= Width) {
            inField = false;
        }

        if (x[0] < 0) {
            inField = false;
        }
        
        if (!inField) {
            timer.stop();
        }
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

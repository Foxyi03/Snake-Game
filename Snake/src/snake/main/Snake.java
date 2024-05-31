/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.main;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Foxyi03
 */
public class Snake implements ImageObserver{ 
    private final int Width = 300; //width of the drawPanel
    private final int Height = 300; //height of the drawPanel
    private final int Size = 10; //sizes of the body and foods
    private final int maxSize = 900; //max numbers of things on the DrawPanel
    private final int randomPosition = 30; //calculation of the position of an apple
    
    
    public final int x[] = new int[maxSize]; //stores the x coordinates of all the bodyparts of the snake
    public final int y[] = new int[maxSize];//stores the y coordinates of all the bodyparts of the snake

    //directions are set to false by default
    public boolean goLeft = false; 
    public boolean goRight = false;
    public boolean goUp = false;
    public boolean goDown = false;
    private boolean inField = false;
    //Images are being called to be implemented, the images are in snake.lib
    private Image body;
    private Image head;
    private Image apple;
    private Image bread;
    private Timer timer;
    //body and head and apple parts are being called up + the location of the food
    public int parts;
    private int appleX;
    private int appleY;
    private int breadX;
    private int breadY;
    
    
    
    
    



    

    
    /*public void initField(){
        parts = 3;

        for(int i = 0; i < parts; i++){
            x[i] = 50 - i * 10;
            y[i] = 50;
        }
        appleLoc();

        
    }*/
    public void appleLoc(){  //generates an apple at a random position on the field
        int r = (int) (Math.random() * randomPosition);
        appleX = (r * Size);
        appleY = (r * Size);

    }
    public void breadLoc(){//generates a bread at a random position on the field
        int b = (int)(Math.random()* randomPosition);
        breadX = (b * Size);
        breadY = (b * Size);
    }
    
    public void draw(Graphics g){ //draws the apple and the snake
        if(!inField){ //need to change the code to draw the images -> look into the solutions for the latest progr chapter
            g.drawImage(apple, appleX, appleY,  this); //snake cannot be converted to ImageObserver
            g.drawImage(bread,breadX, breadY,  this); 
            
            for(int i = 0; i < parts; i++){
                if(i ==0){
                    g.drawImage(head, x[i], y[i],  this);
                } else {
                    g.drawImage(body, x[i], y[i], this);
                }
            }
             Toolkit.getDefaultToolkit().sync(); //syncs the Graphics up with what is being displayed on screen

        }  else {
            gameOver(g); //it is game over once the parts are null 
            score(g);//gives the current score
        }      

    }
    public void appledraw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(appleX, appleY, Size, Size);
        
    }
    public void loadImages(){ //Images are loaded up / Change of plans, draw the head and body parts with draw
        ImageIcon iib = new ImageIcon("src/lib/snakeBody.png");
            body = iib.getImage();
        
        ImageIcon iih = new ImageIcon("src/lib/snakeHead.png");
            head = iih.getImage();
        
        ImageIcon iia = new ImageIcon("src/lib/apple.png");
            apple = iia.getImage();
        
        ImageIcon iibread = new ImageIcon("src/lib/bread.png");
            bread = iibread.getImage();
         
    }
    public void gameOver(Graphics g){ //game over screen
        String msg = "Game Over";
        g.setColor(Color.black);
        g.drawString(msg, Width / 2, Height / 2);
    }
    public void checkApple(){ //checks if the head collides with the apple, when yes then the snake gets longer and the apple changes location
        if((x[0]== appleX) && (y[0]== appleY)){
            parts ++;
            appleLoc();
        }
    }
    
    public void checkBread(){//checks for bread, i think it adds 2 parts
        if((x[0]==breadX) && (y[0]==breadY)){
            parts +=2; //adds 2 bread
            breadLoc();
        }
    }
    
    public void score(Graphics g){//returns the score
        String scoremsg = "Score:";
        int scoreAmount = parts;
        g.setColor(Color.BLACK);
        g.drawString(scoremsg + " " + scoreAmount, Width , Height);
    }
    /*public void actionPerformed(ActionEvent e){
        if(inField){
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }*/
    
    public void move() { //movement of the snake

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

    public void checkCollision() { //checks if the snake hits anything

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
        
        if (inField) {
            timer.stop();
        }
    }


/*------------------------------------------------------------------------------------------------------------------------*/

    //draw body and head
    


//getter and setters
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
    public int[] getX(){
        return x;
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

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}

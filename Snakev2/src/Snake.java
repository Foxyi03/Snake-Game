/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import javax.swing.Timer;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;



/**
 *
 * @author Foxyi03
 */

public class Snake { 
    private final int Width = 300; //width of the drawPanel
    private final int Height = 300; //height of the drawPanel
    private final int maxWidth = 400;  //maximum Width of the DrawPanel and the Game Field
    private final int maxHeight = 400; //maximum Height of the DrawPanel and the Game Field
    final int Size = 10; //sizes of the body and foods
    private final int maxSize = 900; //max numbers of things on the DrawPanel
    private final int randomPosition = 30; //calculation of the position of the food, uses the size to calculate the position of the food to a max of 300, can be less
    
    
    public final int x[] = new int[maxSize]; //stores the x coordinates of all the bodyparts of the snake
    public final int y[] = new int[maxSize];//stores the y coordinates of all the bodyparts of the snake

    //directions are set to false by default
    public boolean goLeft = false; 
    public boolean goRight = false;
    public boolean goUp = false;
    public boolean goDown = false;
    private boolean inField = false; //must be false, determines if the code works or not
    //the location of the food, x and y coords
    public int parts = 3; //can be changed. is the default starting size of the snake
    private int appleX;
    private int appleY;
    private int breadX;
    private int breadY;
    //other classes
    private final StopWatch stopWatch = new StopWatch();
    private Timer gameTimer;

/*------------------------------------------------------------------------------------------------------------------------*/
    public void draw(Graphics g){ //draws the game
        System.out.println(x[0] + " " + y[0]); //coordinates will be shown
        if(!inField){ 
            //draws everything needed to start the game
            appledraw(g);
            breaddraw(g);
            score(g);
            headdraw(g);
            bodydraw(g);
            
            
            //works
            drawElapsedTime(g);
            stopWatch.stop(); //starts the time
            
            for(int i = 0; i < parts; i++){ //if x[0] then a head will be drawn, if x[1] a body will be drawn
                if(i == 0){
                    //head
                    g.setColor(Color.BLUE);
                    g.fillOval(x[i], y[i], Size, Size);
                } else {
                    //body
                    g.setColor(Color.CYAN);
                    g.fillOval(x[i], y[i], Size, Size);
                }
            }
            Toolkit.getDefaultToolkit().sync(); //syncs the Graphics up with what is being displayed on screen

            }  else if(inField){
            gameOver(g); //it is game over once the parts are null, game Over does not work
            score(g);//gives the current score
            
            //this works
            drawElapsedTime(g); //draws the elapsed time
        }
        
    }    


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
    
    
    public void checkApple(){ //checks if the head collides with the apple, when yes then the snake gets longer and the apple changes location
        if((x[0]== appleX) && (y[0]== appleY)){
            parts ++;
            appleLoc();
        }
    }
    
    public void checkBread(){//checks for bread, adds 2 parts
        if((x[0]==breadX) && (y[0]==breadY)){
            parts +=2; //adds 2 bread
            breadLoc();
        }
    }
    
    
    
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

    public void checkCollision() { 

        for (int z = parts; z > 0; z--) {//checks if the snake hits itself

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inField = true;
            }
        }
        //checks if the snake hits borders, if the snake goes over the borders + - 100 then the timer ends
        if (y[0] >= Height) {
            inField = true;
        }
        if(y[0] >= maxHeight) {
            gameTimer.stop();
        }

        if (y[0] < 0) {
            inField = true;
        }
        if(y[0] < -100) {
            gameTimer.stop();
        }

        if (x[0] >= Width) {
            inField = true;
        }
        if (x[0] >= maxWidth) {
            gameTimer.stop();
        }

        if (x[0] < 0) {
            inField = true;
        }
        if(x[0] < -100) {
            gameTimer.stop();
        }
        
        if (inField) { //if snake hits the wall then it should give a game over. is unneeded
            //gameTimer.stop();
            //stopWatch.stop();
        }
        
    }
/*------------------------------------------------------------------------------------------------------------------------*/

    public void score(Graphics g){//returns the score
        String scoremsg = "Score:";
        int scoreAmount = parts;
        g.setColor(Color.WHITE);
        g.drawString(scoremsg + " " + scoreAmount, 10,10);
    }
    
    public void gameStart(Graphics g){ //game start screen, needs to be implemented
        String msg = "Game Start";
        g.setColor(Color.BLACK);
        g.drawString(msg, Width/2, Height/2);
    }
    
    public void gameOver(Graphics g){ //game over screen, works
        String msg = "Game Over";
        g.setColor(Color.WHITE);
        g.drawString(msg, Size + 100, Height /2);
    }
    
    public void drawElapsedTime(Graphics g){ //draws the elapsed time
        g.setColor(Color.WHITE);
        g.drawString(stopWatch.elapsedTime(), Size , Height );
    }
    
    

/*------------------------------------------------------------------------------------------------------------------------*/

    //draw section
    
    private void bodydraw(Graphics g){
        g.setColor(Color.CYAN);
        g.fillOval(x[0], y[0], Size, Size);
    }
    private void headdraw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x[0], y[0], Size, Size);
    }
    public void appledraw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(appleX, appleY, Size, Size);
        
    }
    public void breaddraw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval(breadX, breadY, Size, Size);
    }
    
    

/*------------------------------------------------------------------------------------------------------------------------*/
    //unneeded code, but won't get rid of it yet in case of need
    /*public void actionPerformed(ActionEvent e){
        if(inField){
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }*/
        
    /*public void initField(){
        parts = 3;

        for(int i = 0; i < parts; i++){
            x[i] = 50 - i * 10;
            y[i] = 50;
        }
        appleLoc();

        
    }*/
/*------------------------------------------------------------------------------------------------------------------------*/
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

   
   
    
    
}

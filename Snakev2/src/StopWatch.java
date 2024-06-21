

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VilPa977
 */
public class StopWatch { //checks the time played until a game over
    private long startTime = 0;
    private long stopTime = 0;

    public StopWatch() { //constructor
        startTime = System.currentTimeMillis();
    }
    
    public void start(){ //to start the timer
        startTime = (System.currentTimeMillis());
    }
    public void stop(){ //to stop the timer
        stopTime = (System.currentTimeMillis());
        //System.out.println("StopWatch: " + getElapsedTimeSecs() + " second.");
    }
    public double getElapsedTimeSecs(){ //calculates the time elapsed from the start to the stop
        double elapsed = (stopTime - startTime);
        return elapsed / 1000;
    }
    public String elapsedTime(){ //gives the elapsed time back in a string
        return ("Time: " + getElapsedTimeSecs() + " seconds.");
    }
    /*------------------------------------------------------------------------------------------------------------------------*/
   
    
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VilPa977
 */
public class StopWatch {
    private long startTime = 0;
    private long stopTime = 0;

    public StopWatch() {
        startTime = System.currentTimeMillis();
    }
    
    public void start(){
        startTime = (System.currentTimeMillis());
    }
    public void stop(){
        stopTime = (System.currentTimeMillis());
        //System.out.println("StopWatch: " + getElapsedTimeSecs() + " second.");
    }
    public double getElapsedTimeSecs(){
        double elapsed = (stopTime - startTime);
        return elapsed / 1000;
    }
    public String elapsedTime(){
        return ("Time: " + getElapsedTimeSecs() + " seconds.");
    }
    /*------------------------------------------------------------------------------------------------------------------------*/
   
    
}

import greenfoot.*;

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.5)
 */

public class GameWorld extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("themesong.mp3");
    Snake playerSnake = new Snake(0, 0,255,0);
    Counter snakeCounter = new Counter();
    private int count = 0;
    
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);
        
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        addObject(playerSnake, 500, 300);
        addObject(snakeCounter,50, 30);
        
        Tail.snakeLength = 1;  
    }
    public void act()
    {
        backgroundMusic.playLoop();
        count++;
        if(count > 100) {
            addObject(new Food(255, 0, 0), Greenfoot.getRandomNumber(getWidth() -1), Greenfoot.getRandomNumber(getHeight() -1));
            count = 0;
            
        }
    }
}

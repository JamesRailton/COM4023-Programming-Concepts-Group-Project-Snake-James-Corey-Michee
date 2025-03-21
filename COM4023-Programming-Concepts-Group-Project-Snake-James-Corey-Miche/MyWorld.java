import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.3)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    Snake playerSnake = new Snake(0, 0,255,0);
    Counter snakeCounter = new Counter();
    int count =0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        addObject(playerSnake, 500, 300);
        addObject(snakeCounter,50, 30);
        
    }
    public void act()
    {
        count++;
        if(count > 100) {
            addObject(new Food(255, 0, 0), Greenfoot.getRandomNumber(getWidth() -1), Greenfoot.getRandomNumber(getHeight() -1));
            count =0;
            
        }
    }
}

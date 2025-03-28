import greenfoot.*;

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.6)
 */

public class GameWorld extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("themesong.mp3");
    Snake playerSnake = new Snake(0, 0, 255, 255);
    Counter snakeCounter = new Counter();
    private int foodCount = 0;
    private int poisonousFoodCount = 0;
    
    //Food food = new Food(0, 255, 0);  // red for regular food
    //PoisonousFood poisonousFood = new PoisonousFood(255, 0, 0); // Yellow for poisonous food

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
        foodCount++;
        poisonousFoodCount++;
        if(foodCount > 150) {
            addObject(new Food("apple2.png"), Greenfoot.getRandomNumber(getWidth() -1), Greenfoot.getRandomNumber(getHeight() -1));
            foodCount = 0;
        }
        if(poisonousFoodCount > 75){
            addObject(new PoisonousFood("apple1.png"), Greenfoot.getRandomNumber(getWidth() -1), Greenfoot.getRandomNumber(getHeight() -1));
            poisonousFoodCount = 0;
        }
    }
}

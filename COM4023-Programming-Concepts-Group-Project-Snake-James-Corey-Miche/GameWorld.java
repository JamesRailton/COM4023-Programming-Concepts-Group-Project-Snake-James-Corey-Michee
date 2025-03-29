import greenfoot.*;
import java.util.List;
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (1.0)
 */

public class GameWorld extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("themesong.mp3");
    Snake playerSnake = new Snake(0, 0, 255, 255);
    Counter snakeCounter = new Counter();
    private int foodCount = 0;
    private int poisonousFoodCount = 0;
    private int bonusFoodCount = 0;
    private int powerUpCount = 0;
    
    private static final int foodDistance = 40; // Minimum distance food must be away from snake & tail

    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);

        setBackground("rivets.jpg");

        addObject(playerSnake, 500, 300);
        addObject(snakeCounter,50, 30);

        Tail.snakeLength = 1;  
    }

    public void act()
    {
        backgroundMusic.setVolume(50);
        backgroundMusic.playLoop();
        foodCount++;
        poisonousFoodCount++;
        bonusFoodCount++;
        powerUpCount++;
        
        if (foodCount > 150) {
            spawnFood(new Food("apple2.png"));
            foodCount = 0;
        }
        
        if (poisonousFoodCount > 75) {
            spawnFood(new PoisonousFood("apple1.png"));
            poisonousFoodCount = 0;
        }
        
        if (bonusFoodCount > 300) {
            spawnFood(new BonusFood("apple3.png"));
            bonusFoodCount = 0;
        }
        
        if (powerUpCount > 1000){
            spawnFood(new PowerUp("powerUp.png"));
            powerUpCount = 0;
        }
    }
    
    private void spawnFood(Actor food)
    {
        int x, y;
        // generates random x,y coordinates
        do {
            x = Greenfoot.getRandomNumber(getWidth() - 1);
            y = Greenfoot.getRandomNumber(getHeight() - 1);
        } while (isTooCloseToSnake(x, y));

        addObject(food, x, y); // When isTooCloseToSnake is false, food will spawn (because snake + tail is a suitable distance away)
    }
    
    private boolean isTooCloseToSnake(int x, int y)
    {
        // Check if food is too close to the snake
        if (distance(playerSnake.getX(), playerSnake.getY(), x, y) < foodDistance) {
            return true;
        }

        // Check if coordinates generated is too close to any of part of the tail. If so, returns true
        List<Tail> tailList = getObjects(Tail.class);
        for (Tail tail : tailList) {
            if (distance(tail.getX(), tail.getY(), x, y) < foodDistance) {
                return true;
            }
        }
        
        return false; // Position is safe for food to spawn
    }

    private double distance(int x1, int y1, int x2, int y2)
    {
        // Returns the distance between generated coordinates and snake
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}

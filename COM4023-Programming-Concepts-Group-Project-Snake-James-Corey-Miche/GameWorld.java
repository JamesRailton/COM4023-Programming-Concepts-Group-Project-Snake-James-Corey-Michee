import greenfoot.*;
import java.util.List;
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (1.0)
 */

public class GameWorld extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("themesong.mp3"); //Imports background music
    Snake playerSnake = new Snake();
    
    Counter snakeCounter = new Counter(); //Counter for the game score
    
    //Counters for in-game pickups
    private int foodCount;
    private int poisonousFoodCount;
    private int bonusFoodCount;
    private int powerUpCount;
    
    private static final int foodDistance = 40; // Minimum distance food must be away from snake & tail

    public GameWorld()
    {    
        super(700, 500, 1); // Creates game world of 700 * 500 size

        setBackground("rivets.jpg"); // Sets background for game

        // Adds snake & counter objects to game
        addObject(playerSnake, 500, 300);
        addObject(snakeCounter,50, 30);

        Tail.snakeLength = 1; // Resets tail length after restart to prevent issues
    }

    public void act()
    {
        // Sets background volume and starts music on loop
        backgroundMusic.setVolume(50);
        backgroundMusic.playLoop();
        
        // Increases counters by 1 each frame
        foodCount++;
        poisonousFoodCount++;
        bonusFoodCount++;
        powerUpCount++;
        
        // Used to spawn food
        if (foodCount > 175) {
            spawnFood(new Food());
            foodCount = 0;
        }
        
        // Used to spawn poisonous food
        if (poisonousFoodCount > 50) {
            spawnFood(new PoisonousFood());
            poisonousFoodCount = 0;
        }
        
        // Used to spawn bonus food
        if (bonusFoodCount > 1000) {
            spawnFood(new BonusFood());
            bonusFoodCount = 0;
        }
        
        // Used to spawn power up
        if (powerUpCount > 750){
            spawnFood(new PowerUp());
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

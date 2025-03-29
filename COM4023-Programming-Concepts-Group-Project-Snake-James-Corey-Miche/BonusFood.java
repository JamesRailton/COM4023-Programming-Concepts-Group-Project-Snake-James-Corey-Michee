import greenfoot.*;
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (1.0)
 */
public class BonusFood extends Actor
{
    private int foodCount; // counter for Bonusfood removal
    
    public BonusFood() 
    {
        setImage("apple3.png"); // Sets actor image to golden apple
    }
    
    // Used to increase counter by 1 each frame and once counter reaches 400 removes BonusFood from game and also removes if player collides with food
    public void act()
    {
        foodCount++;

        if(foodCount == 400){
            getWorld().removeObject(this);
        }
        
        else if(isTouching(Snake.class)){
            getWorld().removeObject(this);
        }
    }
}

import greenfoot.*;
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (1.0)
 */
public class Food extends Actor
{
    private int count; // counter for food removal
    
    public Food() 
    {
        setImage("apple2.png"); // Sets actor image to green apple
    }
    
    // Used to increase counter by 1 each frame and once counter reaches 400 removes Food from game and also removes if player collides with food
    public void act()
    {
        count++;
        
        if(count == 400){
            getWorld().removeObject(this);
        }
        
        else if(isTouching(Snake.class)){
            getWorld().removeObject(this);
        }
    }
}

import greenfoot.*;

public class PowerUp extends Actor
{
    private int count; // counter for PowerUp removal
    
    public PowerUp() 
    {
        setImage("powerUp.png"); // Sets actor image to power up
    }
    
    // Used to increase counter by 1 each frame and once counter reaches 400 removes Poisonous Food from game and also removes if player collides with food
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

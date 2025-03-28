import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.7)
 */
public class PoisonousFood extends Actor
{
    private int red, green, blue;
    private int count = 0;
    
    public PoisonousFood(String imageName) 
    {
        setImage(imageName);
    }
    
    public void act()
    {
        count++;
        
        if(count > 400){
            getWorld().removeObject(this);
        }
        
        else if(isTouching(Snake.class)){
            getWorld().removeObject(this);
        }
    }
}

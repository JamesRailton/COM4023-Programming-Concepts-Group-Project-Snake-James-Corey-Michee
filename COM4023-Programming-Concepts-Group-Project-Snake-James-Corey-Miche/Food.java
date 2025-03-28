import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.2)
 */
public class Food extends Actor
{
    private int red, green, blue;
    private int count = 0;
    
    public Food(String imageName) 
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

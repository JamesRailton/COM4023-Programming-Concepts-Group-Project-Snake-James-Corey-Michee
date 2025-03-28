import greenfoot.*;
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (1.0)
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

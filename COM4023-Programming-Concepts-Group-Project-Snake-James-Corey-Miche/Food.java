import greenfoot.*;

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.2)
 */

public class Food extends Actor
{
    private int red, green, blue;
    private int count = 0;
    
    public Food(int red, int green, int blue) 
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
        
        getImage().setColor(new Color(red,green,blue));
        getImage().fillRect(0,0,20,20);
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

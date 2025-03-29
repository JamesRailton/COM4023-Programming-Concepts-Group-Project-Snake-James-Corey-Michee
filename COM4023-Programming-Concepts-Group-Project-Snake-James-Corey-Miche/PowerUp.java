import greenfoot.*;

public class PowerUp extends Actor
{
    private int count;
    
    public PowerUp(String imageName) 
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

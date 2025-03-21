import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{

    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int red, green, blue;
    int count = 0;
    
    public Food(int red, int green, int blue) 
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
        getImage().setColor(new Color(red,green,blue));
        getImage().fillRect(0,0,40,40);
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

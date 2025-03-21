import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.2)
 */
public class Tail extends Actor
{
    /**
     * Act - do whatever the Tail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int red, green, blue;
    int count = 0;
    public Tail(int red, int green, int blue)
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
        if(count > 60){
        getWorld().removeObject(this);
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.3)
 */
public class Tail extends Actor
{
    /**
     * Act - do whatever the Tail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int countLength = 0;
    static int snakeLength = 1;
    int red, green, blue, snake;
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
        
        countLength++;
        
        if(countLength > 5 && isTouching(Snake.class)){
            getWorld().addObject(new YouLose(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        
        if(snake == 0 && countLength % snakeLength == 0){
            getWorld().removeObject(this);
            //snakeLength++;
        }
    }
}

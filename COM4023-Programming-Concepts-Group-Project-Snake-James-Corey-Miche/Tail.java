import greenfoot.*;

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.5)
 */

public class Tail extends Actor
{
    public static int snakeLength = 1;
    private int countLength = 0;
    private int red, green, blue, snake;
    private int count = 0;
    
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
        
        // Causes game over if player collides with tail
        if(countLength > 10 && isTouching(Snake.class)){
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.backgroundMusic.stop();
            
            getWorld().addObject(new YouLose(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        
        // Removes player tail when becomes too long (Allows for moving tail)
        if(snake == 0 && countLength % snakeLength == 0){
            getWorld().removeObject(this);
        }
    }
}

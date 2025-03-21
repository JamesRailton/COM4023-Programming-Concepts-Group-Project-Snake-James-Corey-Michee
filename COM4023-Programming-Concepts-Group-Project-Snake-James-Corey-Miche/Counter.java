import greenfoot.*;

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.3)
 */

public class Counter extends Actor
{
    private int playerScore = 0;
    
    public Counter()
    {
        setImage(new GreenfootImage("Score: " + playerScore,25,Color.BLUE, Color.WHITE));
    }    
    public void act()
    {
        setImage(new GreenfootImage("Score: " + playerScore,25,Color.BLUE, Color.WHITE));
        youWin();
    }
    public void addScore()
    {
        playerScore++;
    }
    private void youWin()
    {
        if (playerScore == 15){
            // Stops background music when player wins
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.backgroundMusic.stop();
            
            getWorld().addObject(new YouWin(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}

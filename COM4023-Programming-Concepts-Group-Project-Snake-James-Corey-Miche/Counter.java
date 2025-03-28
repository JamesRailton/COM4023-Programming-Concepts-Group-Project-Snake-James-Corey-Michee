import greenfoot.*;

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.7)
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
    }
    
    public void addScore()
    {
        playerScore++;
    }
    
    public void addBonusFoodScore()
    {
        playerScore = playerScore + 3;
    }
    
    public void halveScore()
    {
        if (playerScore == 1) {
            playerScore = 0; 
        } else {
            playerScore /= 2;
        }
    }
}


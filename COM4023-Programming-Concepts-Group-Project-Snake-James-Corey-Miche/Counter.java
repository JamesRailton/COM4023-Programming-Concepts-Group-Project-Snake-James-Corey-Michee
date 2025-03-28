import greenfoot.*;

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (1.0)
 */

public class Counter extends Actor
{
    private int playerScore = 0;
    GreenfootSound gameWinSound = new GreenfootSound("gamewin.mp3");
    
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
    
    private void youWin()
    {
         if (playerScore == 15){
             GameWorld gameWorld = (GameWorld) getWorld();
             gameWorld.backgroundMusic.stop();
             getWorld().addObject(new YouWin("youWin.png"), getWorld().getWidth()/2, getWorld().getHeight()/2);
             gameWinSound.setVolume(25);
             gameWinSound.play();
             Greenfoot.stop();
         }
    }
}


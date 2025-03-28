import greenfoot.*;

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.3)
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
    public void halveScore()
    {
        playerScore = (int) Math.floor(playerScore / 2);
        if(playerScore == 1){
            playerScore = 0;
        }
    }
    private void youWin()
    {
         if (playerScore == 1){
             GameWorld gameWorld = (GameWorld) getWorld();
             gameWorld.backgroundMusic.stop();
             getWorld().addObject(new YouWin(), getWorld().getWidth()/2, getWorld().getHeight()/2);
             gameWinSound.setVolume(25);
             gameWinSound.play();
             Greenfoot.stop();
         }
    }
}


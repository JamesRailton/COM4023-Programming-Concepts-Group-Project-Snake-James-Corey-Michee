import greenfoot.*;

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (1.0)
 */

public class Counter extends Actor
{
    private int playerScore; 
    GreenfootSound gameWinSound = new GreenfootSound("gamewin.mp3"); // Imports game win sound
    
    public Counter()
    {
        setImage(new GreenfootImage("Score: " + playerScore,25,Color.BLUE, Color.WHITE)); // Creates player score within world
    }    
    
    // Keeps player score within world and allows it to increase, also triggers YouWin method 
    public void act()
    {
        setImage(new GreenfootImage("Score: " + playerScore,25,Color.BLUE, Color.WHITE));
        youWin();
    }
    
    public void addScore()
    {
        playerScore++; // Adds 1 to player score each time
    }
    
    public void addBonusFoodScore()
    {
        playerScore = playerScore + 3; // Adds 3 to player score if BonusFood is eaten
    }
    
    // Halves player score if poisonous food is eaten
    public void halveScore()
    {
        if (playerScore == 1) {
            playerScore = 0; 
        } else {
            playerScore /= 2;
        }
    }
    
    // Once counter reaches 20 or higher game is won, youWin screen is shown, background music stops and win music is played
    private void youWin()
    {
         if (playerScore > 20){
             GameWorld gameWorld = (GameWorld) getWorld();
             gameWorld.backgroundMusic.stop();
             getWorld().addObject(new YouWin(), getWorld().getWidth()/2, getWorld().getHeight()/2);
             gameWinSound.setVolume(50);
             gameWinSound.play();
             Greenfoot.stop();
         }
    }
}


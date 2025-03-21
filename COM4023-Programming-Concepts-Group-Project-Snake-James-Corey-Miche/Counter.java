import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.1)
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int playerScore = 0;
    public Counter()
    {
        setImage(new GreenfootImage("Score: " + playerScore,20,Color.BLUE, Color.WHITE));
        youWin();
    }
    public void act()
    {
        setImage(new GreenfootImage("Score: " + playerScore,20,Color.BLUE, Color.WHITE));
    }
    public void addScore(){
        playerScore++;
    }
    
    public void youWin()
    {
        if (playerScore == 10){
            getWorld().addObject(new YouWin(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}

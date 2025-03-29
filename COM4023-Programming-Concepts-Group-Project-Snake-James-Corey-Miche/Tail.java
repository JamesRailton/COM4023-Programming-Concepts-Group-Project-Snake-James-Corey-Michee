import greenfoot.*;
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (1.0)
 */
public class Tail extends Actor
{
    public static int snakeLength = 1; //Lenght of snake within game
    private int countLength; // Count lenght to ensure tail does not become to long
    GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3"); // Imports the game over sound into game
    
    // Creates tail for snake in game
    public Tail()
    {
        getImage().setColor(new Color(110,255,255)); 
        getImage().fillRect(0,0,40,40);
    }
     
    // Increases countLenght by 1 each frame, used to game over when player hits own tail
    public void act()
    {
        countLength++;
        
        // Causes game over if player collides with tail, background music is stoped, game over music is played and game over image is shown
        if(countLength > 10 && isTouching(Snake.class)){
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.backgroundMusic.stop();
            getWorld().addObject(new YouLose(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            gameOverSound.setVolume(25);
            gameOverSound.play();
            Greenfoot.stop();
        }
        
        // Removes player tail when becomes too long (Allows for moving tail)
        if(countLength % snakeLength == 0){
            getWorld().removeObject(this);
        }
    }
}

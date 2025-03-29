import greenfoot.*;  
import java.util.List;
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (1.0)
 */
public class Snake extends Actor
{
    private int speed = 3; // Sets player speed
    private boolean isDoublePointsActive = false; // Used to track if double points bonus is active
    private int doublePointsTimer = 0;

    //Imports sound files into game
    GreenfootSound foodSound = new GreenfootSound("food.mp3");
    GreenfootSound poisonousFoodSound = new GreenfootSound("poisonousfood.mp3");
    GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3");
    GreenfootSound powerUpSound = new GreenfootSound("doublePoints.mp3");
    GreenfootSound bonusFoodSound = new GreenfootSound("bonusFood.mp3");

    // Adds player to game and sets the inital direction
    public Snake()
    {
        setRotation(270);
        
        getImage().setColor(new Color(110,255,255));
        getImage().fillRect(0, 0, 40, 40);
    }    
    
    public void act()
    {
        getWorld().addObject(new Tail(), getX(), getY());// Adds tail to game
        
        // Triggers game play methods
        move(speed);
        playerInput();
        eatFood();
        eatPoisonousFood();
        eatBonusFood();
        gameBoundaries();
        eatPowerUp();
        updatePowerUpTimer(); 
    }
    
    // Used to control snake via player keyboard input
    private void playerInput()
    {
        if(Greenfoot.isKeyDown("right")){
            setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("left")){
            setRotation(180);
        }
        
        if(Greenfoot.isKeyDown("up")){
            setRotation(270);
        }
        
        if(Greenfoot.isKeyDown("down")){
            setRotation(90);
        }
    }
    
    // Used to allow player to eat food, plays food eating sound, increase player score and tail size
    private void eatFood()
    {
        if(isTouching(Food.class)){
        foodSound.setVolume(50);
        foodSound.play();
        GameWorld gameWorld = (GameWorld) getWorld();
        if(isDoublePointsActive) {
            gameWorld.snakeCounter.addScore();
        }
        gameWorld.snakeCounter.addScore();      
        Tail.snakeLength += 50;
        }
    }

    // Used to allow player to eat poisonous food, plays poisonous food sound, decreases player score via halveScore method, increases tail size
    private void eatPoisonousFood() {
        if(isTouching(PoisonousFood.class)){
            poisonousFoodSound.setVolume(50);
            poisonousFoodSound.play();
            
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.snakeCounter.halveScore();
            
            Tail.snakeLength += 75;
        }
    }
    
    // Used to allow player to get powerup, plays poweup sound, activates powerup for 10 seconds
    private void eatPowerUp() {
         if(isTouching(PowerUp.class)){
            powerUpSound.setVolume(50);
            powerUpSound.play();
            isDoublePointsActive = true;
            doublePointsTimer = 600; 
            
        }
    }
    
    // Used to allow player to eat bonus food, plays bonus food sound, increases player score via addBonusScore method, increases tail size
    private void eatBonusFood() {
        if(isTouching(BonusFood.class)){
            bonusFoodSound.setVolume(50);
            bonusFoodSound.play();
            
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.snakeCounter.addBonusFoodScore();
            
            //Only decreases tail when tail has actually grown from eating food beforehand
            if (Tail.snakeLength > 1) {
                Tail.snakeLength /= 2; 
                // loop through 50% of tail instances and remove them
                List<Tail> tailList = getWorld().getObjects(Tail.class);
                int removeCount = tailList.size() / 2;
                
                for (int i = 0; i < removeCount; i++) {
                    getWorld().removeObject(tailList.get(i));
                }
            }
        }
    }
    
    // Used to create timer that after 10 seconds disables powerup
    private void updatePowerUpTimer()
    {
        if(isDoublePointsActive) {
            doublePointsTimer--;
            if(doublePointsTimer <= 0) {
                isDoublePointsActive = false;
            }
        }
    }
    
    // Used to game over when player leaves game area, stops background music, starts game over music and shows game over screen
    private void gameBoundaries()
    {
        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1 || getY() <= 0 
        || getY() >= getWorld().getHeight() - 1)
        {
            // Stops background music when player dies
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.backgroundMusic.stop();
            
            getWorld().addObject(new YouLose(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            
            gameOverSound.setVolume(25);
            gameOverSound.play();
            Greenfoot.stop();
        }
    }
}

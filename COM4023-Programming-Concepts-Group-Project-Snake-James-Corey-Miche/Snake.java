import greenfoot.*;  
import java.util.List;
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.7)
 */
public class Snake extends Actor
{
    private int red, green, blue, player;
    private int speed = 3;
    GreenfootSound foodSound = new GreenfootSound("food.mp3");
    GreenfootSound poisonousFoodSound = new GreenfootSound("poisonousfood.mp3");
    GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3");
    Counter counter = new Counter();

    public Snake(int player, int red, int green, int blue)
    {
        setRotation(270);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.player = player;
        getImage().setColor(new Color(red,green,blue));
        getImage().fillRect(0, 0, 40, 40);
    }    

    public void act()
    {
        getWorld().addObject(new Tail(red, green, blue), getX(), getY());
        move(speed);
        playerInput();
        eatFood();
        eatPoisonousFood();
        eatBonusFood();
        gameBoundaries();
    }

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

    private void eatFood()
    {
        // Used to increase length of snake when food is eaten, and add eaten food to score
        if(isTouching(Food.class)){
            foodSound.setVolume(50);
            foodSound.play();
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.snakeCounter.addScore();
            Tail.snakeLength += 30;
        }
    }

    private void eatPoisonousFood() {
        if(isTouching(PoisonousFood.class)){
            poisonousFoodSound.setVolume(50);
            poisonousFoodSound.play();
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.snakeCounter.halveScore();
            Tail.snakeLength += 60;
        }
    }
    
    private void eatBonusFood() {
        if(isTouching(BonusFood.class)){
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

    private void gameBoundaries()
    {
        // Used to game over if player leaves game area

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

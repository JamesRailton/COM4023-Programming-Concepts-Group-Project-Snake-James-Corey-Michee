import greenfoot.*;  
/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.3)
 */
public class Snake extends Actor
{
    private int red, green, blue, player;
    private int speed = 3;
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
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.snakeCounter.addScore();
            
            Tail.snakeLength += 30;
        }
    }

    private void eatPoisonousFood() {
        if(isTouching(PoisonousFood.class)){
            GameWorld gameWorld = (GameWorld) getWorld();
            gameWorld.snakeCounter.halveScore();
            Tail.snakeLength += 60;
            
            
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
            Greenfoot.stop();
        }
    }
}

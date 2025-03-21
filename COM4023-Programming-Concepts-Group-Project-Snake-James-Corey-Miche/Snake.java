import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Corey Wright, James Railton, Michee Kibenge) 
 * @version (0.2)
 */
public class Snake extends Actor
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int red, green, blue, player;
    int speed = 3;
    int count = 0;
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
        count++;
        getWorld().addObject(new Tail(red, green, blue), getX(), getY());
        move(speed);
        moveAround();
        eatFood();
        checkBoundaries();
    }
    public void moveAround()
    {
        if(this.player == 0){
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
    }
    public void eatFood()
    {
        if(isTouching(Food.class) && player == 0){
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.snakeCounter.addScore();
            Tail.snakeLength++;
        }
    }
    public void checkBoundaries()
    {
        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1 || getY() <= 0 
        || getY() >= getWorld().getHeight() - 1)
        {
            getWorld().addObject(new YouLose(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}

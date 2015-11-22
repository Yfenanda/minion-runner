import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Banana here.
 * 
 * @author Manthan 
 * @version (a version number or a date)
 */
public class BackgroundHandler implements Chain
{
    private Actor collidedBackground;
    private  Chain nextInChain;
    public void setNextChain(Chain nextInChain) 
    {     
        this.nextInChain = nextInChain;    
    }

    public void calculate(Car a)    
    {
        collidedBackground = a.getCollidedActor(Background.class);
        if (collidedBackground != null)
        {
            a.getWorld().removeObject(collidedBackground);
            ((CarWorld) a.getWorld()).collided();
            Greenfoot.playSound("Explosion.wav");
        }
        else 
        {
            if(nextInChain != null)
                nextInChain.calculate(a);

        }
    }
}

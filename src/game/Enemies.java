package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;



public class Enemies extends Walker {
   private static final Shape grassWalkerShape = new BoxShape(0.5f,0.8f);                           //Shape of the enemies
   private static final BodyImage grassWalkerImage = new BodyImage("data/grassWalker.png", 2);         //Image of the enemies
   private static int healthPoints;                                                                                   //Health points of the enemies
   private static int damage;                                                                                         //Damage of the enemies

    public Enemies(World world,int healthPoints,int damage){
        super(world,grassWalkerShape);
        this.healthPoints = healthPoints;
        super.setPosition(new Vec2(-8,-3));
        super.addImage(grassWalkerImage);
        super.setName("Grass Walker");
        this.damage = damage;
    }
    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }
    public int getHealthPoints(){
        return healthPoints;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDamage(){
        return damage;
    }
    public void getDamaged(int damage){
        this.setHealthPoints(this.getHealthPoints() - damage);                                                        //A method to decrease enemie's health
    }
    public boolean isDead(){
        if(this.getHealthPoints() == 0){
            return true;
        } else {
            return false;
        }
    }

}

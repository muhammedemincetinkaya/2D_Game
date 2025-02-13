package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Bullet extends Walker   {
    private static final Shape bulletShape = new BoxShape(1,0.1f);
    private static Character character;
    private int bulletLeft;
    private DynamicBody bullet;
    int bulletDamage;
    private BodyImage bulletImage = new BodyImage("data/bullet.png",2);
    public Bullet(GameLevel world, Character character,  int bulletLeft, int bulletDamage){
        super(world,bulletShape);
        this.setPosition(new Vec2(5000,5000));
        this.bulletLeft = bulletLeft;
        this.addImage(bulletImage);
        this.character = character;
        this.bulletDamage = bulletDamage;
    }

    public void setBulletPosition(float x,float y){
        this.setPosition(new Vec2(x,y));
    }

    public void setBulletSpeed(int x){
        this.setLinearVelocity(new Vec2(x,0));
    }

    public void setBullet(int bulletLeft){
        this.bulletLeft = bulletLeft;
    }

    public int getBullet(){
        return bulletLeft;
    }
    public int getBulletDamage(){
        return bulletDamage;
    }
    public void setBulletDamage(int bulletDamage){
        this.bulletDamage = bulletDamage;
    }
    public void setCharacterBullets(){
        character.setBullets(bulletLeft);
    }
}

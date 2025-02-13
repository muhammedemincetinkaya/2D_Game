package game;

import city.cs.engine.*;
import game.Enemies;
import game.GameLevel;
import org.jbox2d.common.Vec2;

public class Level1 extends GameLevel {
    private static Enemies enemy1;
    private static Enemies enemy2;
    private static StaticBody jumpingPlatform;
    private static SolidFixture jumpingPlatformFixture;
    private Shape jumpingPlatformShape = new BoxShape(1,1f);
    private BodyImage platformImage = new BodyImage("data/jumo.png",5);
    private Bullet shoot;
    public Level1(){
        super();
        getCharacter().setPosition(new Vec2(0,0));
        this.createPlatform(600,20,new Vec2(-10,-13.5f),0);
        this.createPlatform(10,1,new Vec2(0,3),0);
        this.createPlatform(20,3,new Vec2(18,7),0);
        enemy1 = new Enemies(this,20,5);
        enemy1.setPosition(new Vec2(0,5));
        enemy2 = new Enemies(this,50,10);
        enemy2.setPosition(new Vec2(18,10));
        jumpingPlatform = new StaticBody(this,jumpingPlatformShape);
        jumpingPlatformFixture = new SolidFixture(jumpingPlatform,jumpingPlatformShape);
        jumpingPlatformFixture.setRestitution(1.5f);
        jumpingPlatform.addImage(platformImage);
        jumpingPlatform.setPosition(new Vec2(-12,-3));
        this.addStepListener(new EnemyMover(enemy1,-2,3));
        this.addStepListener(new EnemyMover(enemy2,12,24));
        shoot = new Bullet(this,this.getCharacter(),20,10);
        this.getCharacter().addCollisionListener(new CollisionHandler(this.getCharacter(),shoot,enemy1));





    }
    @Override
    public boolean isComplete() {
        return enemy1.isDead();
    }

    @Override
    public Enemies getEnemy() {
        return enemy1;
    }
    public Bullet getShoot(){
        return shoot;
    }
}

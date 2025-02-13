package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {
    private final Character character;

    public GameLevel(){
        character = new Character(this,50);
    }

    public Character getCharacter() {
        return character;
    }

    public abstract boolean isComplete();
    public abstract Enemies getEnemy();
    public abstract Bullet getShoot();

    public void createPlatform(float width, float height, Vec2 position, int rotationDegree){                         //A method to create platforms,prevents excessive lines of code.
        Shape platformShape = new BoxShape(width/2.0f,height/2.0f);
        StaticBody platform = new StaticBody(this,platformShape);
        platform.setPosition(position);
        platform.rotateDegrees(rotationDegree);
        platform.setFillColor(Color.WHITE);

    }

}

package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

public class CollisionHandler implements CollisionListener {
    Character character;
    Bullet shoot;
    Enemies enemy;
    public CollisionHandler(Character character, Bullet shoot, Enemies enemy){
        this.character = character;                                                 //Inıtiate the elements that will be in collision.
        this.shoot = shoot;
        this.enemy = enemy;
        character.addCollisionListener(this);                                       //Add a collision listener to those elements.
        shoot.addCollisionListener(this);
        enemy.addCollisionListener(this);
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Bullet && e.getOtherBody() instanceof Enemies){                  //If a bullet and an enemy collides,
            ((Enemies) e.getOtherBody()).getDamaged(((Bullet) e.getReportingBody()).getBulletDamage());      //Deal the bullet's damage to the enemy,
            e.getReportingBody().setPosition(new Vec2(5000,5000));                                     //Move the bullet away from the view of the player,
            if (((Enemies) e.getOtherBody()).getHealthPoints() == 0){                                        //If the enemy drops to zero hp,
                e.getOtherBody().destroy();                                                                  //Destroy the enemy,

            }
        }
        if (e.getReportingBody() instanceof Bullet && e.getOtherBody() instanceof StaticBody){              //If a bullet and a static body collides,
            e.getReportingBody().setPosition(new Vec2(5000,5000));                                    //Move to bullet away from the view of the player.
        }
        if (e.getReportingBody() instanceof Enemies && e.getOtherBody() instanceof Character){              //If an enemy and a character collides,
            ((Character) e.getOtherBody()).getDamaged(((Enemies) e.getReportingBody()).getDamage());        //Deal damage to the character.
            if (((Character) e.getOtherBody()).getCharacterHealth() == 0){                                   //If the character drops to zero health,
                e.getOtherBody().destroy();                                                                 //Destroy the character.
            }
        }

    }
}

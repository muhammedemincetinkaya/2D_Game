package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class EnemyMover implements StepListener {
    private final Enemies enemy;
    private final static int enemySpeed = 2;
    private final int leftEnd;
    private final int rightEnd;
    public EnemyMover(Enemies enemy,int leftEnd,int rightEnd){
        this.enemy = enemy;
        this.leftEnd = leftEnd;                 //Specifies the left border of the movement.
        this.rightEnd = rightEnd;               //Specifies the right border of the movement.
        enemy.startWalking(enemySpeed);         //Enemy starts walking to the right by default.
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        Vec2 position = enemy.getPosition();

        if (position.x <= leftEnd){                     //If enemy is at the left end, start walking to the right
            enemy.startWalking(enemySpeed);
        }
        if (position.x >= rightEnd ) {                  //If enemy is at the right end, start walking to the left
            enemy.startWalking(-enemySpeed);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}

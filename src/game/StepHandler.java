package game;

import city.cs.engine.StepEvent;
import org.jbox2d.common.Vec2;

public class StepHandler implements city.cs.engine.StepListener {

    private  View view;
    private  Character character;

    public StepHandler(View view, Character character){
        this.view = view;
        this.character = character;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        view.setCentre(new Vec2(character.getPosition()));          //Centre the view to the character
    }
}

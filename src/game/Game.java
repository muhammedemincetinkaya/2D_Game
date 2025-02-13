package game;



/**
 * Your main game entry point
 */
public class Game    {
    //Initialise the fields
    private GameLevel level;
    private View view;





    public Game() {


        //1. make an empty game world and start it
        level = new Level1();

        //3. make a view to look into the game world
        view = new View(level,800,600);

        Frame frame = new Frame(view);
        view.addKeyListener(new CharacterControls(level.getCharacter(),frame,level.getShoot()));
        level.addStepListener(new StepHandler(view,level.getCharacter()));



        //Add the mover class to make the character move,enable shooting.


        //Add the collision handler



        //Make the enemies move




        // start our game world simulation!
        level.start();

    }


    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }

}

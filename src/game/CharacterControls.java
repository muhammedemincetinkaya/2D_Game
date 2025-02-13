package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterControls implements KeyListener {
    Character character;
    private static Bullet shoot;
    private final int characterWalkSpeed = 3;     // Walking speed of the character
    private final int characterRunSpeed = 6;      // Running speed of the character
    private final int characterJumpSpeed = 10;    // Jumping speed of the character
    private boolean isRunning = false;            // Tracks if the character is running
    private boolean isLookingRight = true;        //Is character looking right?
    int bulletSpeed = 50;

    public CharacterControls(Character character, Frame frame, Bullet shoot) {    // Adds the keyListener interface to the specified frame
        this.character = character;
        this.shoot = shoot;
        frame.addKeyListener(this);
        shoot.setCharacterBullets();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (isRunning) {                                                //If the character is in running speed, make him run. If the shift key is pressed
            switch (e.getKeyCode()) {                                   // while in running mode, put the character in walking mode,
                case 68:
                    character.startWalking(characterRunSpeed);
                    break;
                case 65:
                    character.startWalking(-characterRunSpeed);
                    break;
                case 16:
                    isRunning = false;
                    break;
            }
        } else {
            switch (e.getKeyCode()) {                                   //If the character is in walking mode,make it walk.
                case 68:
                    character.startWalking(characterWalkSpeed);
                    break;
                case 65:
                    character.startWalking(-characterWalkSpeed);
                    break;
                case 16:                                               //If shift key is pressed while walking,put character in to the running mode.
                    isRunning = true;
            }
        }
        if (e.getKeyCode() == 32) {                                    //If space key is pressed,make the character jump.
            character.jump(characterJumpSpeed);
        }
        if (e.getKeyCode() == 70){
            shoot.setBullet(shoot.getBullet() - 1);                                                       //If the f key is pressed,decrease the number of ammo character has by 1.
            if (shoot.getBullet() > 0 && isLookingRight) {                                                //If the character has ammo and its looking to right,shoot one ammo towards right.
                shoot.setBulletPosition(character.getPosition().x,character.getPosition().y);
                shoot.setBulletSpeed(bulletSpeed);
                shoot.setCharacterBullets();
            }  if (shoot.getBullet() > 0 && !isLookingRight) {                                            //If the character has ammo and looking to left,
                shoot.setBulletPosition(character.getPosition().x - 1,character.getPosition().y);      //Shoot one ammo to the left.
                shoot.setBulletSpeed(-bulletSpeed);
                shoot.setCharacterBullets();
            }
        }
        if (e.getKeyCode() == 69 && !isLookingRight){                                  //If the character is not looking right and the
            character.addImageRight();                                                // e key is pressed,flip the character so it looks to the right.
            isLookingRight = true;
        }
        if (e.getKeyCode() == 81 && isLookingRight){                                   //If the character is looking to the right and the
            character.addImageLeft();                                                 //q key is pressed, flip the character to look to left
            isLookingRight = false;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {                                           //If a key is released,stop character from moving.
        character.stopWalking();
        //if (e.getKeyChar() != ' ') {
        //  walker.setLinearVelocity(new Vec2(0, 0));
        //}
    }

    public boolean whereisCharactherLooking(){                                      //Checks if the character is looking to right or left
        return isLookingRight;
    }
}

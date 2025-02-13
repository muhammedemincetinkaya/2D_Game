package game;

import city.cs.engine.*;


public class Character extends Walker {
    private static  final Shape studentShape = new PolygonShape(1.0f,1.67f, 1.01f,-1.96f, -1.19f,-1.98f, -1.24f,1.6f, 0.99f,1.67f);     //Polygon shape of the character
    private static final BodyImage imageRight = new BodyImage("data/characther_right.png", 4);                                   //Image of the right side of the character,
    private static final BodyImage imageLeft = new BodyImage("data/characther_left.png" , 4);                                    //Image of the left side of the character.
    private static int characterHealth;                                                                                                         //Character health.
    int bullets;                                                                                                                                //Number of bullets character has.




    public Character(World world,int characterHealth){
        super(world,studentShape);
        this.addImage(imageRight);
        this.characterHealth = characterHealth;
    }



    public void addImageRight(){                              //This method flips the character image to right.
        this.removeAllImages();
        this.addImage(imageRight);
    }

    public void addImageLeft(){                               //This method flips the character imago to left.
        this.removeAllImages();
        this.addImage(imageLeft);
    }
    public void setCharacterHealth(int health){
        this.characterHealth = health;
    }
    public int getCharacterHealth(){
        return characterHealth;
    }

    public void getDamaged(int damage){
        this.setCharacterHealth(this.getCharacterHealth() - damage);
    }
    public int getBullets(){
        return bullets;
    }
    public void setBullets(int bullets){
        this.bullets = bullets;
    }

}

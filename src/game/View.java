package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.UserView;


import javax.swing.*;
import java.awt.*;

public class View extends UserView {
    GameLevel world;                                                                                               //The world that view will bo looking to.
   private Image background1;                                                                                     //The background image.
   public static final Font font1 = new Font("Monospaced",Font.PLAIN,20);                             //The font of the foreground.
    public View(GameLevel world, int width, int height) {
        super(world,width,height);
        this.world = world;
        background1 = new ImageIcon("data/background2.jpg").getImage();
        background1 = background1.getScaledInstance(800,600,Image.SCALE_DEFAULT);                   //Scale the image to fit into the view.
        JFrame debug = new DebugViewer(world,800,600);
    }

    @Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(background1,0,0,this);
    }           //Draw the background
    @Override
    protected void paintForeground(Graphics2D g){                                                               //Draw the foreground
       int charactherHealth = world.getCharacter().getCharacterHealth();
       int remainingBullet = world.getCharacter().getBullets();
       g.setColor(Color.RED);
       g.setFont(font1);
       g.drawString("Health:" + charactherHealth,100,100);
       g.drawString("Reaming Bullets:" + remainingBullet,100,50);
       if (world.getCharacter().getCharacterHealth() == 0){
           g.drawString("Game Over",350,250);
       }
    }
}

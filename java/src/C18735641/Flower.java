package C18735641;
import processing.core.*;

public class Flower {
    MyVisual mv;

    public Flower(MyVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        // center of bottom of rose
        float rX = 0;
        float rY = 0;

        // size of petal
        float pX = 40;
        float pY = 70;

        mv.pushMatrix();
        // translate to center of screen
        mv.translate(mv.width / 2, mv.height / 2);

        mv.noStroke();
        mv.fill(230, 255, 255);
        
        mv.pushMatrix();
        mv.ellipse(rX, rY, pX, pY);
        
    }
}
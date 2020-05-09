package C18735641;

import processing.core.*;

public class BranchVisual {
    MyVisual mv;

    int numLines = 10;
    float distance = 25;
    float angle = 0;

    public BranchVisual(MyVisual mv) {
        this.mv = mv;
    }

    /*

    public void render(float startX, float startY, float height, float angle, int gen) {
        float x, z;
        
        mv.stroke(255);
        mv.fill(255);
        // trunk first
        mv.pushMatrix();
        //mv.translate(mv.width / 2, mv.height / 2);
        // translate and rotate to where we're told
        // mv.translate(startX, startY, 0);
        // float nextX = startX * MyVisual.cos(gen * angle) - startX * MyVisual.sin(gen * angle);
        // float nextY = startY * MyVisual.cos(gen * angle) +  startY * MyVisual.sin(gen * angle);
        // mv.rotateZ(angle);

        // mv.line(startX, startY, 0, nextX, nextY, 0);
        mv.box(10);
        // for (int i = 0; i < numLines; i++) {
        //     angle = MyVisual.map(i, 0, numLines, 0, MyVisual.TWO_PI);

        //     x = MyVisual.cos(angle) * distance;
        //     z = MyVisual.sin(angle) * distance;

        //     mv.line(x, 0, z, x, height, z);
        // }

        mv.popMatrix();

    }
    */

    public void render()
    {
        
    }
}
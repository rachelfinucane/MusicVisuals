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

    public void render(float startX, float startY, float height) {

        mv.stroke(255);
        mv.fill(255);
        // mv.translate(startX, startY, 0);
        // for (int i = 0; i < numLines; i++) {
        // angle = MyVisual.map(i, 0, numLines, 0, MyVisual.TWO_PI);

        // x = MyVisual.cos(angle) * distance;
        // z = MyVisual.sin(angle) * distance;

        // mv.line(x, 0, z, x, -height, z);
        // }

        // float rowAngleOffset = MyVisual.map(i, 0, numLeafs, MyVisual.HALF_PI, 0);
        // // mv.pushMatrix();
        // mv.rotateX(rowAngleOffset);
        // mv.ellipse(rX, rY + (pY / 2), pX, pY);

        // mv.popMatrix();
        // mv.rotate(MyVisual.TWO_PI / numPetals);

        mv.line(0, 0, 0, -height);
    }

}
package C18735641;

import processing.core.*;

public class TreeVisual {
    MyVisual mv;
    int maxGenerations = 2;
    int numBranches = 2;
    float branchHeight = 70;
    float angle = MyVisual.THIRD_PI;

    float margin = 50;

    public TreeVisual(MyVisual mv) {
        this.mv = mv;
    }

    public void render() {

        // trunk first
        // drawSelf(mv.width / 2f, mv.height / 10f, 0, branchHeight, 0);
        float startX = mv.width / 2;
        float startY = mv.height - margin;

        for (int i = 0; i < maxGenerations; i++) {
            mv.stroke(255);
            // float endX = startX;
            // float endY = mv.height - 200;

            float endX = startX * MyVisual.cos(i * angle) + startY * MyVisual.sin(i * angle);
            float endY = -startY * MyVisual.cos(i * angle) + startX * MyVisual.sin(i * angle);
            mv.pushMatrix();
            mv.translate(endX, endY);
            mv.box(50);
            mv.popMatrix();

            mv.line(startX, startY, endX, endY);
            startX = endX;
            startY = endY;

        }

        // x * MyVisual.cos(gen * angle) - y * MyVisual.sin(gen * angle);
        // nextY = y * MyVisual.cos(gen * angle) + x * MyVisual.sin(gen * angle);

    }

    /*
     * 
     * private void drawSelf(float x, float y, float a, float height, int gen) {
     * float nextX, nextY; // nextX = (1 / (gen + 1) ) * MyVisual.sin(angle) + x; //
     * so far, this will have to change in the for loop // nextY = -(1 / (gen + 1))
     * * MyVisual.cos(angle) + y; nextX = x * MyVisual.cos(gen * angle) - y *
     * MyVisual.sin(gen * angle); nextY = y * MyVisual.cos(gen * angle) + x *
     * MyVisual.sin(gen * angle);
     * 
     * // if (gen < maxGenerations) { // // for(int i = 0; i < numBranches; i++) //
     * // { // // BranchVisual br = new BranchVisual(mv); // // br.render(0f, 0f,
     * 0f); // // drawSelf(gen); // // } // BranchVisual br = new BranchVisual(mv);
     * // br.render(x, y, branchHeight, a * gen, gen); // drawSelf(nextX, nextY, a,
     * height, gen + 1); // }
     * 
     * for(int i = 0; i < 3; i++) { BranchVisual br = new BranchVisual(mv);
     * br.render(x, y, branchHeight, a * i); }
     * 
     * }
     * 
     */
}
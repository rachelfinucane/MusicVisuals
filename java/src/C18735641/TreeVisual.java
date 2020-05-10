package C18735641;

public class TreeVisual {
    MyVisual mv;
    int maxGenerations = 2;
    int numBranches = 2;
    float branchHeight = 300;
    float staticAngle = MyVisual.QUARTER_PI;
    float angle;
    float branchReduction = 0.6f;
    float margin = 50;
    float leafMin = branchHeight * 0.2f;
    float leafMax = branchHeight * 0.4f;
    float trunkMin = 20f;
    float trunkMax = 40f;

    public TreeVisual(MyVisual mv) {
        this.mv = mv;
    }

    public void render() {
        mv.stroke(255);
        mv.pushMatrix();
        mv.translate(mv.width / 2, mv.height - margin);
        drawBranch(branchHeight);
        mv.popMatrix();
        mv.translate(mv.width / 2, mv.height - margin - branchHeight);
        drawSelf(branchHeight);

        angle = MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 1f * staticAngle, 1.5f * staticAngle);
    }

    private void drawSelf(float bHeight) {
        bHeight = bHeight * branchReduction;
        if (bHeight > 30) {

            mv.pushMatrix();
            mv.rotate(angle);
            drawBranch(bHeight);
            mv.translate(0, -bHeight);
            drawSelf(bHeight);
            mv.popMatrix();

            mv.pushMatrix();
            mv.rotate(-angle);
            drawBranch(bHeight);
            mv.translate(0, -bHeight);
            drawSelf(bHeight);
            mv.popMatrix();

        }

    }

    private void drawBranch(float bHeight) {
        int numLines = mv.getBands().length;
        float distance = MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, trunkMin, trunkMax);
        float lnAngle;

        float x, z;
        for (int i = 0; i < numLines; i++) {
            lnAngle = MyVisual.map(i, 0, numLines, 0, MyVisual.TWO_PI);

            x = MyVisual.cos(lnAngle) * distance;
            z = MyVisual.sin(lnAngle) * distance;

            mv.line(x, 0, z, x, -bHeight, z);
        }
        if (bHeight < branchHeight / 4) {
            drawLeaves(bHeight);
        }
    }

    private void drawLeaves(float bHeight) {
        int numLines = mv.getBands().length;
        float distance = MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, trunkMin, trunkMax);
        float leafHeight;
        float colour = 0;

        for (int i = 0; i < numLines; i++) {
            colour = MyVisual.map(i, 0, numLines, 0, 255);
            leafHeight = MyVisual.map(mv.getSmoothedBands()[i], 0, 1000, leafMin, leafMax);
            mv.fill(colour, 255, 255);
            mv.noStroke();
            mv.pushMatrix();
            mv.popMatrix();
            mv.ellipse(leafHeight * 1.5f, 0, leafHeight, distance);
            mv.rotate(MyVisual.TWO_PI / numLines);

        }
        mv.stroke(255);
    }

}
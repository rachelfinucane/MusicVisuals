package C18735641;

import processing.core.*;

public class Flower {
    MyVisual mv;

    public Flower(MyVisual mv) {
        this.mv = mv;
    }

    public void render() {
        mv.pushMatrix();
        int numPetals = 8;
        int numRows = mv.getBands().length; // was 5
        float pOffset = PConstants.HALF_PI * 0.3f;
        // float rowAngleOffset = MyVisual.PI / mv.getBands().length * -1; // this is cool and makes a "powder puff", but not a flower
        // float rowAngleOffset = MyVisual.HALF_PI / mv.getBands().length;
        float rowAngleOffset = 0;

        // size of petal
        float pX = 50;
        float pY = 100;

        // center of bottom of rose
        float rX = 0;
        float rY = pY / 2;

        float rColor = 0;

        // mv.pushMatrix(); // push default screen

        // translate to center of screen
        mv.translate(mv.width / 2, mv.height / 2);
        // rotate rose to see side on
        mv.rotateX(PConstants.PI * 0.3f) ;
        // mv.rotateX(mv.mouseX*0.1f);
        // mv.rotateY(mv.mouseY*0.1f);

        mv.noStroke();

        for (int i = 0; i < numRows; i++) {
            // mv.pushMatrix(); // push translated screen

            mv.fill(rColor, 255, 255);
            // pX = mv.getSmoothedBands()[numRows - i - 1] * 0.2f;
            pY = MyVisual.map(mv.getSmoothedBands()[i], 0, 1000, mv.height / 12, mv.height / 2);

            for (int j = 0; j < numPetals; j++) {
                rowAngleOffset = MyVisual.map(i, 0, numPetals, MyVisual.HALF_PI, 0);
                mv.pushMatrix();
                mv.rotateX(rowAngleOffset);
                mv.ellipse(rX, rY + (pY / 2), pX, pY);
                
                mv.popMatrix();
                mv.rotate(MyVisual.TWO_PI / numPetals);
            }

            // pop translated screen (remove petal rotation)
            // mv.popMatrix();
            
            // offset petals for next row
            mv.rotate(pOffset);

            // reduce petal size
            pY = pY * 0.9f;
            rColor += (255 / numRows);
        }

        // mv.pushMatrix(); // push translated screen
        
        

        // mv.popMatrix(); // pop translated screen
        mv.popMatrix();

    }
}
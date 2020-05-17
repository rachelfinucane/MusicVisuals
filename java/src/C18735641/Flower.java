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
        int numRows = mv.getBands().length; 
        float pOffset = PConstants.HALF_PI * 0.3f;
        float rowAngleOffset = 0;

        // size of petal
        float pX = 50;
        float pY = 100;

        // center of bottom of rose
        float rX = 0;
        float rY = pY / 2;

        float rColor = 0;
        mv.translate(mv.width / 2, mv.height / 2);
        // rotate rose to see side on
        mv.rotateX(PConstants.PI * 0.3f) ;

        mv.noStroke();

        for (int i = 0; i < numRows; i++) {

            mv.fill(rColor, 255, 255);
            pY = MyVisual.map(mv.getSmoothedBands()[i], 0, 1000, mv.height / 12, mv.height / 2);

            for (int j = 0; j < numPetals; j++) {
                rowAngleOffset = MyVisual.map(i, 0, numPetals, MyVisual.HALF_PI, 0);
                mv.pushMatrix();
                mv.rotateX(rowAngleOffset);
                mv.ellipse(rX, rY + (pY / 2), pX, pY);
                
                mv.popMatrix();
                mv.rotate(MyVisual.TWO_PI / numPetals);
            }
            
            // offset petals for next row
            mv.rotate(pOffset);

            // reduce petal size
            pY = pY * 0.9f;
            rColor += (255 / numRows);
        }

        mv.popMatrix();

    }
}
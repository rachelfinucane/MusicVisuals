package C18735641;

import processing.core.*;

public class Flower {
    MyVisual mv;

    public Flower(MyVisual mv) {
        this.mv = mv;
    }

    public void render() {
        int numPetals = 8;
        int numRows = 5;
        float pOffset = PConstants.PI * 0.3f;
        float rowAngleOffset = 0.1f;

        // size of petal
        float pX = (270f / numPetals);
        float pY = 100;

        // center of bottom of rose
        float rX = 0;
        float rY = pY / 2;

        float rColor = 0;

        mv.pushMatrix(); // push default screen

        // translate to center of screen
        mv.translate(mv.width / 2, mv.height / 2);
        // rotate rose to see side on
        mv.rotateX(PConstants.PI * 0.4f) ;

        mv.noStroke();

        for (int i = 0; i < numRows; i++) {
            mv.pushMatrix(); // push translated screen
            mv.fill(rColor, 255, 255);
            for (int j = 0; j < numPetals; j++) {
                mv.pushMatrix();
                mv.rotateX(PConstants.PI * rowAngleOffset);
                mv.ellipse(rX, rY, pX, pY);
                
                mv.popMatrix();
                mv.rotate(PConstants.TWO_PI / numPetals);
            }

            // pop translated screen (remove petal rotation)
            mv.popMatrix();
            
            // offset petals for next row
            mv.rotate(pOffset);

            // reduce petal size
            pY = pY * 0.9f;
            rColor += (255 / numRows);

            rowAngleOffset += 0.1f;
        }

        mv.pushMatrix(); // push translated screen
        
        

        mv.popMatrix(); // pop translated screen

    }
}
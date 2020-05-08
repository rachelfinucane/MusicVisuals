package C18735641;

import processing.core.*;

public class ClusterVisual {
    MyVisual mv;

    public ClusterVisual(MyVisual mv) {
        this.mv = mv;
    }

    public void render() {
        // draw a bunch of spheres around a radius
        // then rotate 90 degrees and draw them again
        // then change the radius based on amplitude

        int numSpheres = 8;
        float radius = mv.height / 30f;
        float dist = MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 3 * radius, mv.height * 0.5f);
        float offset = 0;
        float angle, X, Y;
        float colour;

        mv.pushMatrix();
        mv.translate((mv.width / 2), mv.height / 2);
        mv.pushMatrix();
        for (int i = 0; i < numSpheres; i++) {
            
            colour = MyVisual.map(i, 0, numSpheres, 0, 255);
            mv.noStroke();
            mv.lights();
            mv.fill(colour, 255, 255);
            for (int j = 0; j < numSpheres; j++)
            {

                angle = MyVisual.map(j, 0, numSpheres, 0, MyVisual.TWO_PI);
                mv.pushMatrix();
                X = MyVisual.cos(angle) * (dist + offset);
                Y = -MyVisual.sin(angle) * (dist + offset);
                mv.translate(X, Y, 0);

                mv.sphere(radius);
                mv.popMatrix();
            }
        }
        mv.popMatrix();
        mv.popMatrix();
    }
}
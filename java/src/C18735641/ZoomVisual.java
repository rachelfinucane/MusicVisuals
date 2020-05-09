package C18735641;

import processing.core.*;

public class ZoomVisual {
    MyVisual mv;
    float distance[];
    int numCircles;
    float colour = 0;
    float colourInc;
    float dist = 0;

    public ZoomVisual(MyVisual mv) {
        this.mv = mv;
        numCircles = mv.getBands().length;
        distance = new float[numCircles];
        for (int i = 0; i < numCircles; i++) {
            distance[i] = MyVisual.map(i, 0, numCircles, 0, mv.width);
        }
        colourInc = 255 / numCircles;
    }

    public void render() {

        float max = 2 * mv.width;
        float curr = max;
        int del = (int) MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 80, 120);

        mv.noStroke();
        mv.translate(mv.width / 2, mv.height / 2);
        mv.delay(del);
        // drawCircles(max);
        while (curr > 0) {
            
            colour = (colour + 10) % 255;
            mv.fill(colour, 255, 255);
            mv.circle(0, 0, curr);

            curr -= 30;
        }

    }

    private void drawCircles(float distance) {
        float rad = distance;
        float colour = 0;
        while (rad > 0) {
            colour = (colour + 10) % 255;
            mv.fill(colour, 255, 255);
            mv.circle(0, 0, rad);
            rad -= 10;
        }
    }

}
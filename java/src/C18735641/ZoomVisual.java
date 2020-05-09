package C18735641;

public class ZoomVisual {
    MyVisual mv;
    float colour = 0;

    public ZoomVisual(MyVisual mv) {
        this.mv = mv;

    }

    public void render() {

        float colour = 0;
        float max = 2 * mv.width;
        float curr = max;
        int del = 200;
        int numCircs = 30;
        float colourInc = 255 / numCircs;

        mv.noStroke();
        mv.translate(mv.width / 2, mv.height / 2);
        mv.delay(del);
        // drawCircles(max);
        while (curr > 0) {

            // colour = (colour + 10) % 255;
            colour = (colour + colourInc) % 255;
            mv.fill(colour, 255, 255);
            mv.circle(0, 0, curr);
            // //curr -= MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 80, 110);
            // curr -= 10;

            if (mv.getAmplitude() > 0) {
                curr -= max / numCircs - MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 0, 70);
            } else {
                curr -= max / numCircs;
            }

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
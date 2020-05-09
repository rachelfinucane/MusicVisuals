package C18735641;

public class ZoomVisual {
    MyVisual mv;
    float colour = 0;

    public ZoomVisual(MyVisual mv) {
        this.mv = mv;

    }

    public void render() {

        float colour = 0;
        float max = (float) Math.sqrt(mv.height * mv.height + mv.width * mv.width);
        float curr = max;
        int numCircs = 20;
        float colourInc = 255 / numCircs;
        float speed = max / numCircs;
        int maxSpeed = 100;

        mv.noStroke();
        mv.translate(mv.width / 2, mv.height / 2);
        while (curr > 0) {
            colour = (colour + colourInc) % 255;
            mv.fill(colour, 255, 255);
            mv.circle(0, 0, curr);

            if (mv.getAmplitude() > 0) {
                curr -= speed - MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 0, maxSpeed);
            } else {
                curr -= speed;
            }

        }

    }

}
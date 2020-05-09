package C18735641;

public class ClusterVisual {
    MyVisual mv;

    public ClusterVisual(MyVisual mv) {
        this.mv = mv;
    }

    public void render() {

        int numSpheres = mv.getBands().length;
        float radius = mv.height / 50;
        float dist = MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 2 * radius, 0.7f * mv.height);
        float offset = 50;
        float angle, X, Y;
        float colour;
        float freqBandRadius;

        mv.pushMatrix();
        mv.translate((mv.width / 2), mv.height / 2);
        mv.pushMatrix();
        for (int i = 0; i < numSpheres; i++) {
            colour = MyVisual.map(i, 0, numSpheres, 0, 255);
            mv.noStroke();
            mv.lights();
            mv.fill(colour, 255, 255);
            offset = radius * i;
            MyVisual.println("i: " + i + "offset " + offset);
            mv.pushMatrix();
            for (int j = 0; j < numSpheres * (i + 1); j++) {

                freqBandRadius = MyVisual.map(mv.getSmoothedBands()[i], 0, 1000, 0.4f * radius, 1.6f * radius);
                angle = MyVisual.map(j, 0, numSpheres * (i + 1), 0, MyVisual.TWO_PI);
                MyVisual.println("angle: " + angle);

                mv.pushMatrix();
                X = MyVisual.cos(angle) * (dist + offset);
                Y = -MyVisual.sin(angle) * (dist + offset);
                mv.translate(X, Y, 0);

                mv.sphere(freqBandRadius);
                mv.popMatrix();

                mv.pushMatrix();
                mv.rotateX(MyVisual.PI);
                X = MyVisual.cos(angle) * (dist + offset);
                Y = -MyVisual.sin(angle) * (dist + offset);
                mv.translate(X, Y, 0);

                mv.sphere(freqBandRadius);
                mv.popMatrix();

                mv.rotateX(MyVisual.TWO_PI / (numSpheres * i));
            }
            mv.popMatrix();
            mv.rotateX(MyVisual.TWO_PI / (numSpheres));
        }
        mv.popMatrix();
        mv.popMatrix();
    }

}

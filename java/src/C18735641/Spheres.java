package C18735641;

public class Spheres {
    MyVisual mv;
    float angle = 0;

    public Spheres(MyVisual mv) {
        this.mv = mv;
    }

    public void render() {
        float minDistance = mv.height / 6f; // at least 2 meters!
        float distance = MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, minDistance, mv.width / 2);
        float size = MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 30, 100);
        float shadowAngle = -MyVisual.PI * 0.08f;
        int fadeOut = 10;
        int fade = 50;

        mv.noStroke();
        mv.lights();
        mv.fill(255, 255, 255);
        mv.translate(mv.width / 2, mv.height / 2);
        mv.rotateZ(angle);

        // mv.pushMatrix();
        // mv.translate(distance, 0);
        // mv.sphere(size);
        // mv.translate(-2 * distance, 0);
        // mv.sphere(size);
        // mv.popMatrix();
        
        // mv.rotateZ(shadowAngle);
        // mv.fill(255, 255, 200);
        // mv.pushMatrix();
        // mv.translate(distance, 0);
        // mv.sphere(size);
        // mv.translate(-2 * distance, 0);
        // mv.sphere(size);
        // mv.popMatrix();

        // mv.rotateZ(shadowAngle);
        // mv.fill(255, 255, 100);
        // mv.pushMatrix();
        // mv.translate(distance, 0);
        // mv.sphere(size);
        // mv.translate(-2 * distance, 0);
        // mv.sphere(size);
        // mv.popMatrix();
        mv.pushMatrix();
        mv.translate(distance, 0);
        mv.sphere(size);
        mv.translate(-2 * distance, 0);
        mv.sphere(size);
        mv.popMatrix();
        for (int i = 0; i < fadeOut; i++)
        {
            fade = (int)(fade * 0.8);
            mv.rotateZ(shadowAngle);
            mv.fill(255, 255, fade);
            mv.pushMatrix();
            mv.translate(distance, 0);
            mv.sphere(30);
            mv.translate(-2 * distance, 0);
            mv.sphere(30);
            mv.popMatrix();
        }
        mv.pushMatrix();
        mv.rotateZ(-shadowAngle);
        mv.translate(distance, 0);
        mv.sphere(size);
        mv.translate(-2 * distance, 0);
        mv.sphere(size);
        mv.popMatrix();

        angle += MyVisual.PI * 0.005f;

    }

}

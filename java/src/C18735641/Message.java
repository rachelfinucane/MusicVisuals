package C18735641;

public class Message {
    MyVisual mv;
    float colour = 0;
    String message;
    float size;
    float angle = 0;
    float lerpedAngle = 0;
    boolean increasing = true;

    public Message(MyVisual mv, String message, float size) {
        this.mv = mv;
        this.message = message;
        this.size = size;
    }

    public void render() {

        int numWords = 3;
        float yTransform = size / 3;
        int fade = 255;
        lerpedAngle = MyVisual.lerp(angle, lerpedAngle, 0.1f);

        mv.pushMatrix();
        mv.translate(mv.width / 2, mv.height * 0.9f);
        mv.textAlign(MyVisual.CENTER);
        mv.rotateY(angle);

        for (int i = 0; i < numWords; i++) {
            mv.textSize(size);
            mv.fill(colour, 255, fade);
            mv.text(message, 0, 0);
            colour = (colour + 1) % 255;
            mv.translate(0, yTransform, -yTransform);
            fade = fade / 3;
        }
        mv.popMatrix();

        if (increasing == true) {
            angle += 0.001;

            if (angle > MyVisual.PI * 0.05) {
                increasing = false;
            }
        }

        else {
            angle -= 0.001;
            if (angle < -MyVisual.PI * 0.05) {
                increasing = true;
            }
        }

    }
}
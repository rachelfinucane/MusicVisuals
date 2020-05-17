package C18735641;

public class Message {
    MyVisual mv;
    float colour = 0;
    String message;
    float size;
    float angle = 0;
    float lerpedAngle = 0;

    public Message(MyVisual mv, String message, float size) {
        this.mv = mv;
        this.message = message;
        this.size = size;
    }

    public void render() {
        
        int numWords = 2;
        float zTransform = -100;
        angle = MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 0, MyVisual.QUARTER_PI);
        lerpedAngle = MyVisual.lerp(angle, lerpedAngle, 0.1f);

        mv.pushMatrix();
        mv.translate(mv.width / 2, mv.height * 0.8f);
        mv.textAlign(MyVisual.CENTER);
        mv.rotateY(angle);

        for (int i = 0; i < numWords; i++) {
            mv.textSize(size);
            mv.stroke(colour, 255, 255);
            mv.fill(colour, 255, 255);
            mv.text(message, 0, 0);
            colour = (colour + 1) % 255;
            mv.translate(0, 0, zTransform);
        }
        mv.popMatrix();
      
    }
}
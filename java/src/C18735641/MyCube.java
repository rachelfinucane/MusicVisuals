package C18735641;

public class MyCube {
    MyVisual mv;
    float size;
    float freqBandSize;
    float x, y, z;
    float speed = 0;
    float margin;
    
    public MyCube(MyVisual mv, float size, float x, float y, float z, float margin)
    {
        this.mv = mv; 
        this.size = size;
        this.x = x;
        this.y = y;
        this.z = z;
        this.margin = margin;
    }

    public void render(float freqBand) {
        freqBandSize = MyVisual.map(freqBand, 0, 1000, size / 2, size * 2);
        speed = mv.getSmoothedAmplitude() * 10;
        mv.noFill();
        mv.stroke(255);
        mv.pushMatrix();
        mv.translate(mv.width / 2, mv.height / 2);
        mv.translate(x, y, z);
        mv.box(freqBandSize);
        mv.popMatrix();
        z += speed;

        if (z > mv.height / 2)
        {
            x = mv.random(-mv.width / 6, mv.width / 6);
            y = mv.random(-mv.height / 6, mv.height / 6);
            z = -mv.height;
        }
    }
}
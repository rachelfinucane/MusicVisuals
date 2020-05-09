package C18735641;

public class MyCube {
    MyVisual mv;
    float size;
    float x, y, z;
    float speed = 2;
    float margin;
    
    public MyCube(MyVisual mv, float size, float x, float y, float margin)
    {
        this.mv = mv; 
        this.size = size;
        this.x = x;
        this.y = y;
        this.z = mv.height;
        this.margin = margin;
    }

    public void render() {
        mv.noFill();
        mv.stroke(255);
        z = (z++) % mv.height;
        mv.pushMatrix();
        mv.translate(mv.width / 2, mv.height / 2);
        mv.translate(x, y, z);
        mv.box(size);
        mv.popMatrix();
        z += speed;

        if (z > mv.height)
        {
            x = mv.random(-mv.width / 6, mv.width / 6);
            y = mv.random(-mv.height / 6, mv.height / 6);
            z = -mv.height;
        }
    }
}
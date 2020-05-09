package C18735641;

public class MyCube {
    MyVisual mv;
    
    public MyCube(MyVisual mv)
    {
        this.mv = mv; 
    }

    public void render(float x, float y, float z, float size) {
        mv.noFill();
        mv.translate(x, y, z);
        mv.box(size);
    }
}
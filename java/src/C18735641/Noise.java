package C18735641;

public class Noise {
    MyVisual mv;

    public Noise(MyVisual mv) {
        this.mv = mv;
    }
    public void render()
    {
        mv.stroke(255);
        for(int i = 0; i < 100; i++)
        {
            mv.point(mv.random(mv.width ), mv.random(mv.height), mv.random(mv.width / 2));
        }
    }
    
}
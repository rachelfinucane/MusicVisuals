package C18735641;

public class Noise {
    MyVisual mv;

    public Noise(MyVisual mv) {
        this.mv = mv;
    }
    public void render()
    {
        int numPoints = 200;
        mv.stroke(255);
        for(int i = 0; i < numPoints; i++)
        {
            mv.point(mv.random(mv.width ), mv.random(mv.height), mv.random(mv.width / 2));
        }
    }
    
}
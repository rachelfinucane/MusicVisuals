package C18735641;

import java.util.ArrayList;

public class BoxZoom {
    MyVisual mv;
    int numBoxes = 6;
    float boxSize = 50;
    float[] boxDistance;
    ArrayList<MyCube> boxes;
    float x, y, z;
    float margin = 2 * boxSize;

    public BoxZoom(MyVisual mv) {
        this.mv = mv;
        boxDistance = new float[numBoxes];
        boxes = new ArrayList<MyCube>();
        for (int i = 0; i < numBoxes; i++) {
            x = mv.random(-mv.width / 6, mv.width / 6);
            y = mv.random(-mv.height / 6, mv.height / 6);
            z = mv.random(-mv.height / 2, mv.height / 2);
            boxes.add(new MyCube(mv, boxSize, x, y, z, margin));
        }

    }

    public void render() {
        for (int i = 0; i < boxes.size(); i++) {
            
            MyCube b = boxes.get(i);
            b.render(mv.getSmoothedBands()[i]);
        }
    }
}
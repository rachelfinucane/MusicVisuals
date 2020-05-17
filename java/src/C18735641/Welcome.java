package C18735641;


public class Welcome {
    MyVisual mv;
    float angle = 0;

    public Welcome(MyVisual mv) {
        this.mv = mv;
    }

    public void render() {
        String title = "Welcome";
        String subtitle = "Press space to start";
        float titleSize = mv.width / 10f;
        float subtitleSize = mv.width / 20f;

        int titleFill = 100;
        int subtitleFill = 200; 

        mv.textAlign(MyVisual.CENTER);
        mv.fill(titleFill, 255, 255);
        mv.textSize(titleSize);

        mv.text(title, mv.width / 2, mv.height / 2);
        mv.fill(subtitleFill, 255, 255);
        mv.textSize(subtitleSize);
        mv.text(subtitle, mv.width / 2, mv.height / 2 + 50);
        mv.rotateY(angle);

    }
}
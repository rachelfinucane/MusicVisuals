package example;

import ie.tudublin.Visual;

public class Procedural extends Visual
{
    int n;
    // default is 4-sided shape
    public Procedural()
    {
        this.n = 4;
    }

    public Procedural(int n)
    {
        this.n = n;
    }

    public void settings()
    {
        size(800, 800, P3D);
        // fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
        if (key == '1')
        {
            

        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("heroplanet.mp3");
        
    }

    float smoothedPyrSize = 0;
    float angle = 0;
    int num = 10;
    int smoothed_num = 3;
    int polarity = 1;
    float offset = 0;
    float distance = 0;
    float maxAmp = 0;

    public void draw()
    {
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);

        float amp = getSmoothedAmplitude();
        if(amp < 0.2)
        {
            smoothed_num = 3;
        }
        else if (amp < 0.6)
        {
            smoothed_num = 4;
        }
        else if(amp < 0.8)
        {
            smoothed_num = 5;
        }
        else
        {
            smoothed_num = 6;
        }
        // int num_shapes = (int)(map(getSmoothedAmplitude(), 0, 1, 3, 10));
        // smoothed_num = (int)lerp(smoothed_num, num_shapes, 1);
       
        float x, y;
        float angle = 0;
        float ang_inc = TWO_PI / (float)smoothed_num;
        // make loop
        for(int i = 0; i < smoothed_num; i++)
        {
            pushMatrix();
            x = (height / 10) * cos(angle);
            y = (height / 10) * sin(angle);
            translate(x, y, 0);
            angle += ang_inc;
            drawShape();
            popMatrix();
            
        }
    }

    public void drawShape()
    {
        // pushMatrix();
        float rough_distance;
        float ang_inc = TWO_PI / (float)n;
        float ang = 0;
        float x1, y1, x2, y2;
        // int rough_n;

        calculateAverageAmplitude();
        

        // n = (int)map(getSmoothedAmplitude(), 0, 1, 10, 25);
        // n = (int)lerp(n, rough_n, 1);

        rough_distance = map(getSmoothedAmplitude(), 0, 1, 20, 100);
        distance = lerp(distance, rough_distance, 0.2f);
               
        // rotateX(PI/2);
        // rotateZ(-PI/6);

        noFill();
        beginShape();
        for(int i = 0; i < n; i++)
        {

            // this is the top of the pyramid
            vertex(0, 0, distance);

            //calculate the co-ordinate for next vertex
            // x = distance cos theta
            // y = distance cos theta
            x1 = distance * cos(ang);
            x2 = distance * cos(ang - ang_inc);
            y1 = distance * sin(ang);
            y2 = distance * sin(ang - ang_inc);

            vertex(x1, y1, -distance);
            vertex(x2, y2, -distance);

            ang += ang_inc;
        }
        endShape();

        angle += map(getSmoothedAmplitude(), 0, 1, 0, 0.5f);
        // popMatrix();   
    }
}
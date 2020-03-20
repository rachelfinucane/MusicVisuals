package example;

import ie.tudublin.Visual;

public class ProceduralShape extends Visual
{
    public void settings()
    {
        //size(800, 800, P3D);
        fullScreen(P3D, SPAN);
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

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        noFill();
        // lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        // camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        // translate(0, 0, -250);
               
        float boxSize = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedPyrSize = lerp(smoothedPyrSize, boxSize, 0.2f);  

        // pushMatrix();
        translate(width/2, height/2);
        // popMatrix();

        // rotateX(angle);
        // rotateY(-angle);
        rotateZ(angle);

        noFill();

        beginShape();
        vertex(-smoothedPyrSize, -smoothedPyrSize, -smoothedPyrSize);
        vertex( smoothedPyrSize, -smoothedPyrSize, -smoothedPyrSize);
        vertex(   0,    0,  smoothedPyrSize);

        vertex( smoothedPyrSize, -smoothedPyrSize, -smoothedPyrSize);
        vertex( smoothedPyrSize,  smoothedPyrSize, -smoothedPyrSize);
        vertex(   0,    0,  smoothedPyrSize);

        vertex( smoothedPyrSize, smoothedPyrSize, -smoothedPyrSize);
        vertex(-smoothedPyrSize, smoothedPyrSize, -smoothedPyrSize);
        vertex(   0,   0,  smoothedPyrSize);

        vertex(-smoothedPyrSize,  smoothedPyrSize, -smoothedPyrSize);
        vertex(-smoothedPyrSize, -smoothedPyrSize, -smoothedPyrSize);
        vertex(   0,    0,  smoothedPyrSize);
        endShape();

        angle += map(getSmoothedAmplitude(), 0, 1, 0, 0.5f);
        
    }
}
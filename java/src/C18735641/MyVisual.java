package C18735641;

import ie.tudublin.*;

public class MyVisual extends Visual {
    // WaveForm wf;
    // AudioBandsVisual abv;
    Flower fl;
    ClusterVisual cv;
    BoxZoom bz;
    ZoomVisual zv;
    TreeVisual tv;

    int currentSketch = 1;
    
    public void settings() {
        size(800, 800, P3D);

        // Use this to make fullscreen
        // fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        // fullScreen(P3D, SPAN);
    }

    public void setup() {
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("Joywave - 01. Obsession.mp3");

        // Call this instead to read audio from the microphone
        // startListening();

        // wf = new WaveForm(this);
        // abv = new AudioBandsVisual(this);
        fl = new Flower(this);
        cv = new ClusterVisual(this);
        zv = new ZoomVisual(this);
        bz = new BoxZoom(this);
        tv = new TreeVisual(this);
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
            currentSketch = 1;
        }
        if (key == '2')
        {
            currentSketch = 2;
        }
        if (key == '3')
        {
            currentSketch = 3;
        }
        if (key == '4')
        {
            currentSketch = 4;
        }
        if (key == '5')
        {
            currentSketch = 5;
        }
        
    }

    public void draw() {
        background(0);
        colorMode(HSB);
        try {
            // Call this if you want to use FFT data
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        // wf.render();
        // abv.render();
        // fl.render();
        if(currentSketch == 1)
        {
            fl.render();
        }
        if(currentSketch == 2)
        {
            cv.render();
        }
        if(currentSketch == 3)
        {
            bz.render();
        }
        if(currentSketch == 4)
        {
            zv.render();
        }
        if (currentSketch == 4)
        {
            tv.render();
        }
    }
}

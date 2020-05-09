package C18735641;

import java.util.ArrayList;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    // WaveForm wf;
    // AudioBandsVisual abv;
    Flower fl;
    ClusterVisual cv;
    MySketch currentSketch;

    ArrayList<MySketch> sketches = new ArrayList<MySketch>();

    public void settings()
    {
        size(800, 800, P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Joywave - 01. Obsession.mp3");   

        
        
        // Call this instead to read audio from the microphone
        // startListening(); 
        
        // wf = new WaveForm(this);
        // abv = new AudioBandsVisual(this);
        fl = new Flower(this);
        cv = new ClusterVisual(this);

        sketches.add(fl);
        sketches.add(cv);

        // currentSketch = currentSketch = sketches.get(0);
        currentSketch = fl;


    }

    public void keyPressed()
    {
        int i = 1;

        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
        // if (key == 'f')
        // {
        //     currentSketch = sketches.get(i);
        //     i = (i + 1) % sketches.size();
        // }
    }

    public void draw()
    {
        background(0);
        colorMode(HSB);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
        // wf.render();
        // abv.render();
        // fl.render();
        cv.render();
        // currentSketch.render();
    }
}

package C18735641;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    // WaveForm wf;
    // AudioBandsVisual abv;
    // Flower fl;
    ZoomVisual zv;

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
        // fl = new Flower(this);
        zv = new ZoomVisual(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
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
        zv.render();
    }
}

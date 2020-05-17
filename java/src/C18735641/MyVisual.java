package C18735641;

import ie.tudublin.*;

public class MyVisual extends Visual {
    // WaveForm wf;
    // AudioBandsVisual abv;
    Boolean started = false;
    Boolean showTitle = false;
    Boolean showLyric = false;
    Flower fl;
    ClusterVisual cv;
    BoxZoom bz;
    ZoomVisual zv;
    TreeVisual tv;
    Welcome we;
    Message ti;
    Message ly;
    Noise no;

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
        we = new Welcome(this);
        ti = new Message(this, "Obsession", 100);
        ly = new Message(this, "Something to hold in my sights", 50);
        no = new Noise(this);
    }

    public void keyPressed() {

        if (key == ' ') {
            started = true;
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            showLyric = false;
            showTitle = false;
        }
        if (key == '1') {
            currentSketch = 1;
        }
        if (key == '2') {
            currentSketch = 2;
        }
        if (key == '3') {
            currentSketch = 3;
        }
        if (key == '4') {
            currentSketch = 4;
        }
        if (key == '5') {
            currentSketch = 5;
        }
        if (key == 't')
        {
            showTitle = true;
        }
        if (key == 'l')
        {
            showLyric = true;
        }
        if (key == 'r')
        {
            showTitle = false;
            showLyric = false;
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
        // ti.render();
        // cv.render();
        
        if (started == false) {
            we.render();
            no.render();
        } else {
            if(showTitle == true)
            {
                ti.render();
            }
            if(showLyric == true)
            {
                ly.render();
            }
            if (currentSketch == 1) {
                fl.render();
                no.render();
            }
            else if (currentSketch == 2) {
                cv.render();
                no.render();
            }
            else if (currentSketch == 3) {
                bz.render();
                no.render();
            }
            else if (currentSketch == 4) {
                zv.render();
            }
            else if (currentSketch == 5) {
                tv.render();
                no.render();
            }
        }
    }
}

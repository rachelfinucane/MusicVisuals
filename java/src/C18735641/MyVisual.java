package C18735641;

import ie.tudublin.*;

public class MyVisual extends Visual {
    Boolean started = false;
    Flower fl;
    ClusterVisual cv;
    BoxZoom bz;
    ZoomVisual zv;
    TreeVisual tv;
    Welcome we;
    Message obsess;
    Message hold;
    Message get;
    Noise no;

    int currentSketch = 1;

    public void settings() {
        size(800, 800, P3D);
    }

    public void setup() {
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("Joywave - 01. Obsession.mp3");

        fl = new Flower(this);
        cv = new ClusterVisual(this);
        zv = new ZoomVisual(this);
        bz = new BoxZoom(this);
        tv = new TreeVisual(this);
        we = new Welcome(this);
        obsess = new Message(this, "OBSESSION", 100);
        hold = new Message(this, "hold in my sights", 50);
        get = new Message(this, "get me through the night", 50);
        no = new Noise(this);
    }

    public void keyPressed() {

        if (key == ' ') {
            started = true;
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

    }

    public void draw() {
        float position = getAudioPlayer().position();
        background(0);
        colorMode(HSB);

        int t1 = 33100;
        int t2 = 71000;
        int t3 = 116500;
        int t4 = 136000;
        int t5 = 171500;

        int mLength = 3000;
        int m1 = 3800; //obsession
        int m2 = 36200; //get me through the night
        int m3 = 43500; // obsession
        int m4 = 67000; // hold in my sights
        int m5 = 97500; // get me through the night
        int m6 = 107400; //hold in my sights
        int m7 = 172950; // something to hold in my sights


        try {
            // Call this if you want to use FFT data
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this if you want to get the average amplitude
        calculateAverageAmplitude();

        if (started == false) {
            we.render();
            no.render();
        } else {

            if (position > 0 && position < t1) {
                fl.render();
                no.render();
            } else if (position > t1 && position < t2) {
                tv.render();
                no.render();
            }
            else if(position > t2 && position < t3) {
                bz.render();
                no.render();
            } else if (position > t3 && position < t4) {
                zv.render();
            } else if (position > t4 && position < t5) {
                cv.render();
                no.render();
            } else if (position > t5 && position < getAudioPlayer().length()) {
                fl.render();
            }

            if (position > m1 && position < m1 + mLength) {
                obsess.render();
            } 
            else if (position > m2 && position < m2 + mLength) {
                get.render();
            } 
            else if (position > m3 && position < m3 + mLength) {
                obsess.render(); 
            } 
            else if (position > m4 && position < m4 + mLength) {
                hold.render(); 
            }
             else if (position > m5 && position < m5 + mLength) {
                get.render();
            } 
            else if (position > m6 && position < m6 + mLength) {
                hold.render();
            } 
            else if (position > m7 && position < m7 + mLength) {
                hold.render();
            } 



        }
    }
}

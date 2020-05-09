package ie.tudublin;

<<<<<<< HEAD

import C18735641.*;

=======
import C18735641.MyVisual;
>>>>>>> feature_zoom

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
<<<<<<< HEAD

        // processing.core.PApplet.runSketch( a, new RotatingAudioBands());		

        processing.core.PApplet.runSketch( a, new MyVisual());		
		

=======
        processing.core.PApplet.runSketch( a, new MyVisual());		
>>>>>>> feature_zoom
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}
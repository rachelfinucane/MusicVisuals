package ie.tudublin;

<<<<<<< HEAD
=======
import C18735641.*;
>>>>>>> feature_zooming_boxes

import C18735641.*;
public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};

        // processing.core.PApplet.runSketch( a, new RotatingAudioBands());		

        processing.core.PApplet.runSketch( a, new MyVisual());		
		

	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}
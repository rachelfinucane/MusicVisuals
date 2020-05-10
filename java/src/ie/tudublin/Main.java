package ie.tudublin;

<<<<<<< HEAD
import C18735641.*;

=======

import C18735641.*;
>>>>>>> feature_tree

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};

<<<<<<< HEAD
=======
        // processing.core.PApplet.runSketch( a, new RotatingAudioBands());		
>>>>>>> feature_tree

        // processing.core.PApplet.runSketch( a, new RotatingAudioBands());		

		processing.core.PApplet.runSketch( a, new MyVisual());	
	}	
	

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}
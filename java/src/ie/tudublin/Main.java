package ie.tudublin;

<<<<<<< HEAD

import C18735641.*;
=======
import example.CubeVisual;
import example.CustomShape;
import example.MyVisual;
import example.Procedural;
import example.Procedural;
>>>>>>> custom_shape

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
<<<<<<< HEAD

        // processing.core.PApplet.runSketch( a, new RotatingAudioBands());		

        processing.core.PApplet.runSketch( a, new MyVisual());		
		

=======
        processing.core.PApplet.runSketch( a, new Procedural());
		
>>>>>>> custom_shape
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}
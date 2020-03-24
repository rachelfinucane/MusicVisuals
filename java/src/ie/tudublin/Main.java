package ie.tudublin;

import example.CubeVisual;
import example.CustomShape;
import example.MyVisual;
import example.Procedural;
import example.Procedural;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
<<<<<<< HEAD
        processing.core.PApplet.runSketch( a, new Procedural());
		
=======
        processing.core.PApplet.runSketch( a, new CubeVisual());		
>>>>>>> 4544869fc088cc2d72d157835b14734e61ace876
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}
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
        processing.core.PApplet.runSketch( a, new Procedural());
		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}
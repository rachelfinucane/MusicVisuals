package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
		// processing.core.PApplet.runSketch( a, new CubeVisual());
		// processing.core.PApplet.runSketch( a, new AudioBandsVisual());
		processing.core.PApplet.runSketch( a, new MyVisual());
		// processing.core.PApplet.runSketch( a, new WaveForm());
		
		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}
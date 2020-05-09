package ie.tudublin;

<<<<<<< HEAD
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
=======
import C18735641.MyVisual;
>>>>>>> feature_flower

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
<<<<<<< HEAD
        processing.core.PApplet.runSketch( a, new RotatingAudioBands());		
=======
        processing.core.PApplet.runSketch( a, new MyVisual());		
>>>>>>> feature_flower
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
// Start
public class start {
	static Color Grauefarbe, Pixelfarbe;
	static int Wartezeit;

	public static void main(String[] args) throws AWTException {
		
		Grauefarbe = new Color(83,83,83);
		Wartezeit = 1100;
		
		new bothenry();
		new Zeitbedingtebefehle();
			
	}
}
// Roboter Klasse
class bothenry {
	static Robot rob;
	
	
	public bothenry() throws AWTException {
		rob = new Robot();
	}
	
	public static void suchpixelfarbe() {
		start.Pixelfarbe = rob.getPixelColor(1200,481);
	}
	public static void pressspace() {
		rob.keyPress(KeyEvent.VK_SPACE);
		rob.keyRelease(KeyEvent.VK_SPACE);
	}
	public static void pressarrowdown() {
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyRelease(KeyEvent.VK_DOWN);
	}
	
}

class Zeitbedingtebefehle {
	
	static Timer timepixelabfrage, timejumping;
	
	public Zeitbedingtebefehle() {
		
			timepixelabfrage = new Timer();
			timejumping = new Timer();
			
				timepixelabfrage.schedule(new TimerTask() {

					@Override
					public void run() {
					
					bothenry.suchpixelfarbe();
						if(start.Pixelfarbe.equals(start.Grauefarbe)) {
						jump();
						}
				
					}}, 0,1);
	}
	
		public void jump() {
		
				timejumping.schedule(new TimerTask() {

					@Override
					public void run() {
				
					bothenry.pressspace();
					this.cancel();
				
					}},start.Wartezeit );
		}
	
}
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;



public class TrexTest {
	
	public static void main(String[] args) {
		
		final Color graufarbe = new Color(83,83,83);
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			public void run() {
				
			try {
		         Robot robot = new Robot();    
		         Color Farbe = robot.getPixelColor(800,510);	
		         
		            if ((Farbe.equals(graufarbe))) {
		            	System.out.println("Springen"); 
						robot.keyPress(KeyEvent.VK_SPACE);
						
		            } 
    
		    } 
			catch (AWTException e) {
	            e.printStackTrace();
			}
			
			}
			
		},0, 10 );
		 
	}
	    
}
	


import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
// Start
public class start {


	public static void main(String[] args) throws AWTException {
			
			// Aufrufen der anderen Klassen
			detection detect = new detection();
			tools tol = new tools();
			
			
			
			// Timer erstellen um immerwieder Code auszuführen
			Timer timer = new Timer();
			timer.schedule(detect, 0,1);
	
			/*
			score sc = new score();
			Timer scoretim = new Timer();
			scoretim.schedule(sc, 0, 1000);*/
			}
	
			
			

}

// Klasse um statische Variablen Abzuspeichern und Abzufragen
class tools  {
	static Color Farbe, graufarbe;
	static Robot rob;
	static int Wartezeit;

	tools() throws AWTException{
		rob = new Robot();
		Farbe = new Color(0,0,0);	
		graufarbe = new Color(83,83,83);
		Wartezeit = 1100;
		}
	
	
	
	public static void scancolor() { 
		Farbe = rob.getPixelColor(1200,481);
		}
	
	
	public static void pressspace()  {
		
				try {
					new Timer().schedule(new Jump(), Wartezeit);
				} catch (AWTException e) {
					System.out.println("Aufgehalten");
					e.printStackTrace();
				}
	}
	
	public static Color farbenausgabe(){
		return Farbe;
	}
	public static Color farbenausgabestandart(){
		return graufarbe;
	}
}


//Klasse mit Code zum immerwieder ausführen

class detection extends TimerTask {

	
// Test ob Pixel Grau ist
	public void run() {
					tools.scancolor();
		
					if (tools.farbenausgabe().equals(tools.farbenausgabestandart())) {
			
					tools.pressspace();
					System.out.println("Objekt erkannt");
					}
		}
}

// Klasse zum Springen
class Jump extends TimerTask{
	Robot bot;

	
	Jump() throws AWTException{
		bot = new Robot();
		
	}
	public void run() {
		 
		System.out.println("Springen");
		bot.keyPress(KeyEvent.VK_SPACE);
	    bot.keyRelease(KeyEvent.VK_SPACE);  
		this.cancel();
		 
		
		
	}
	
	
}

/*class score extends TimerTask{

	@Override
	public void run() {
			tools.Wartezeit = tools.Wartezeit-3;
		
	}
	
	
}

*/
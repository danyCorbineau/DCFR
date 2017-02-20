package technique;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyJtaListener implements KeyListener	{
	public void keyTyped(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyChar()>='0' && arg0.getKeyChar()<='9' &&  ((arg0.getModifiers() & KeyEvent.CTRL_MASK) != 0))
		{
			int key=arg0.getKeyChar()-'0';
			LiaisonBdGui.changeCurentWord(key);
			
		}
	}
}

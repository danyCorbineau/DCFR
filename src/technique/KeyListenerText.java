package technique;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mainPack.FrMain;

public class KeyListenerText implements KeyListener{
	public void keyTyped(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyChar()>='0' && arg0.getKeyChar()<='9' &&  ((arg0.getModifiers() & KeyEvent.CTRL_MASK) != 0))
		{
			
			int key=arg0.getKeyChar()-'0';
			if(FrMain.dlt.words!=null && FrMain.dlt.words.length>key)
			{
				String word= FrMain.dlt.words[key].substring(3);
				String strrcv=FrMain.cpText.getText().substring(0,FrMain.cpText.getCaretPosition());
				String[] table=strrcv.split(" ");
				if(table.length>0)
					FrMain.cpText.setText( (FrMain.cpText.getText().substring(0,FrMain.cpText.getCaretPosition())) +
							word.substring(table[table.length-1].length()) + 
							(FrMain.cpText.getText().substring(FrMain.cpText.getCaretPosition())) );
			}
		}
	}
}

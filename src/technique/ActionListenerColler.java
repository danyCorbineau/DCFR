package technique;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import mainPack.FrMain;

public class ActionListenerColler implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		try {
			FrMain.cpText.setText(FrMain.cpText.getText()+(String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
		}
	}

}

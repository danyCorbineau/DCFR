package technique;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainPack.FrMain;

public class ActionListenerCopier implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(FrMain.cpText.getText()),null);
	}

}

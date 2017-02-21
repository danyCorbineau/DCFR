package technique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainPack.FrMain;

public class ActionListenerInformations implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		if(FrMain.wpList.getSelectedValue()!=null)
		{
			String t[]=FrMain.bdd.selectWordComplet((String)FrMain.wpList.getSelectedValue());
			FrMain.ip.affInfoWord(t);
			FrMain.w.reactualise();
		}
	}
}

package technique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphique.WindowVerbe;
import mainPack.FrMain;

public class ActionListenerRechercheVerbe implements ActionListener{
	
	public void actionPerformed(ActionEvent arg0) {
		
		if(FrMain.bdd.verbeExist(ActionListenerVerbe.jtf.getText()))
		{
			new WindowVerbe(ActionListenerVerbe.jtf.getText());
		}
		
	}

}

package technique;

import java.awt.ScrollPane;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import mainPack.FrMain;

public class DocumentListenerTextRechercheVerbe implements DocumentListener{

	public void changedUpdate(DocumentEvent e) {
		
	}

	public void insertUpdate(DocumentEvent e) {
		if(ActionListenerVerbe.jtf.getText().length()>2)
		{
			String words[]=FrMain.bdd.listVerb(ActionListenerVerbe.jtf.getText());
			ActionListenerVerbe.brp.remove(ActionListenerVerbe.brp.getComponentCount()-1);
			ActionListenerVerbe.jl=new JList<>(words);
			ActionListenerVerbe.brp.add(new JScrollPane((ActionListenerVerbe.jl)));
			ActionListenerVerbe.bv.reactualiser();
		}
	}

	public void removeUpdate(DocumentEvent e) {
		
	}

}

package technique;

import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import mainPack.FrMain;

public class DocumentListenerText implements DocumentListener{
	String words[];
	
	public void changedUpdate(DocumentEvent arg0) {
		
	}
	public void insertUpdate(DocumentEvent arg0) {
		String[] table=(FrMain.cpText.getText().substring(0,FrMain.cpText.getCaretPosition()+1).replaceAll("'"," ")).split(" ");
		updateDocument(table[table.length-1], FrMain.ap.getLimite(), FrMain.ap.isOrderWord());
	}
	public void removeUpdate(DocumentEvent arg0) {
		
	}
	
	
	private void updateDocument(String word,int limit, boolean order)
	{
		if(word.length()>2 && word.length()<20)
		{
			words=FrMain.bdd.selectWord(word, limit, order);
			for(int j=0;j<words.length;j++)
				words[j]=j+": "+words[j];
				
			if(words!=null)
			{
				FrMain.wpList=new JList<String>(words);
				FrMain.wp.addList(FrMain.wpList);
				FrMain.w.reactualise();
			}
		}
	}
	

}
